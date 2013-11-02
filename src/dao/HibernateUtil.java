package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Create the most heavy class - SessionFactory
 * and set ThreadLocal variable of Session
 */
public class HibernateUtil {

    private static final SessionFactory SESSION_FACTORY;

    static {
        try {
            // Create the SessionFactory
            SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException ex) {
            throw new RuntimeException("Configuration problem: " + ex.getMessage(), ex);
        }
    }

    public static final ThreadLocal SESSION = new ThreadLocal();

    /**
     * Open a new Session, if this Thread has none yet
     * @return Session
     * @throws HibernateException
     */
    public static Session startSession() throws HibernateException {
        Session s = (Session) SESSION.get();
        // Open a new Session, if this Thread has none yet
        if (s == null) {
            s = SESSION_FACTORY.openSession();
            SESSION.set(s);
        }
        return s;
    }

    /**
     * Close Session
     * @throws HibernateException
     */
    public static void closeSession() throws HibernateException {
        Session s = (Session) SESSION.get();
        SESSION.set(null);
        if (s != null)
            s.close();
    }
}