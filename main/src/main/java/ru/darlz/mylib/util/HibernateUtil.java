package ru.darlz.mylib.util;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import ru.darlz.mylib.shared.model.Author;
import ru.darlz.mylib.shared.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * User: Vladislav Dolbilov (darl@yandex-team.ru)
 * Date: 15.05.12 0:02
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration conf = new Configuration()
                    .addAnnotatedClass(Author.class)
                    .addAnnotatedClass(Book.class);

            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = conf.configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void doInSession(SessionAction action) {
        try {
            Session s = sessionFactory.openSession();
            try {
                action.doInSession(s);
            } finally {
                s.flush();
                s.close();
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void addObject(final Object object) {
        doInSession(new SessionAction() {
            @Override
            public void doInSession(Session session) {
                session.save(object);
            }
        });
    }

    public static void updateObject(final Object object) {
        doInSession(new SessionAction() {
            @Override
            public void doInSession(Session session) {
                session.update(object);
            }
        });
    }

    public static <T> T loadById(final Class<T> clazz, final long id) {
        final AtomicReference<T> result = new AtomicReference<T>(null);
        doInSession(new SessionAction() {
            @Override
            public void doInSession(Session session) {
                result.set((T) session.get(clazz, id));
            }
        });

        return result.get();
    }

    public static <T> List<T> loadByCriteria(final Class<T> clazz) {
        return loadByCriteria(clazz, null);
    }

    public static <T> List<T> loadByCriteria(final Class<T> clazz, final Order order, final Criterion... criterions) {
        final List<T> result = new ArrayList<T>();
        doInSession(new SessionAction() {
            @Override
            public void doInSession(Session session) {
                final Criteria criteria = session.createCriteria(clazz);
                for (final Criterion criterion : criterions) {
                    criteria.add(criterion);
                }
                if (order != null) {
                    criteria.addOrder(order);
                }
                result.addAll(criteria.list());
            }
        });
        return result;
    }
}
