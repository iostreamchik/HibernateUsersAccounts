package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public abstract class DAO {

    protected DAO() {
    }

    /**
     * start Session
     * @return thread local copy of Session variable
     */
    public static Session getSESSION() {
        return HibernateUtil.startSession();
    }

    /**
     * begin transaction from <b>org.hibernate.Transaction beginTransaction()</b>
     */
    protected void begin() {
        getSESSION().beginTransaction();
    }

    /**
     * commit transaction from <b>org.hibernate.Transaction</b>
     */
    protected void commit() {
        getSESSION().getTransaction().commit();
    }

    /**
     * rollback transaction from <b>org.hibernate.Transaction</b>
     */
    protected void rollback() {
        try {
            getSESSION().getTransaction().rollback();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        try {
            getSESSION().close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        HibernateUtil.closeSession();
    }

    /**
     * close session from <b>java.sql.Connection</b>
     * @throws org.hibernate.HibernateException
     */
    public static void close() {
        getSESSION().close();
        HibernateUtil.closeSession();
    }
}
