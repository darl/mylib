package ru.darlz.mylib.util;

import org.hibernate.Session;

/**
 * User: Vladislav Dolbilov (darl@yandex-team.ru)
 * Date: 15.05.12 10:19
 */
public interface SessionAction {
    void doInSession(Session session);
}
