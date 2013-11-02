package dao;

import hibernate.classes.Pass;
import org.hibernate.HibernateException;

import org.hibernate.Query;

public class PassDAO extends DAO {
    public Pass create(String password) throws Exception {
        try {
            begin();
            Pass pass = new Pass(password);
            getSESSION().save(pass);
            commit();
            return pass;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not create " + password);
        }
    }

    public Pass retrieve(Long identificator) throws Exception {
        try {
            begin();
            Query query = getSESSION().createQuery("from Pass where id =:identificator");
            query.setLong("identificator", identificator);
            Pass pass = (Pass) query.uniqueResult();
            commit();
            if(pass != null) {
                return pass;
            } else {
                return null;
            }
        } catch (HibernateException e) {
            throw new Exception("Can`t retrieve pass on id" + identificator, e);
        }
    }

    public void delete(Pass pass) throws Exception {
        try {
            begin();
            getSESSION().delete(pass);
            commit();
        } catch (HibernateException e) {
            throw new Exception("Can`t delete " + pass.getUpass(), e);
        }
    }
}
