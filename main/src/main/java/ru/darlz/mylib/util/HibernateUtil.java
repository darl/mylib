package ru.darlz.mylib.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.darlz.mylib.shared.model.Author;
import ru.darlz.mylib.shared.model.Book;

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
}
