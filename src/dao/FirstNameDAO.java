package dao;

import hibernate.classes.FirstName;
import org.hibernate.HibernateException;
import org.hibernate.Query;


public class FirstNameDAO extends DAO {
    public FirstName create(String uname) throws Exception{
        try {
            begin();
            FirstName firstName = new FirstName(uname);
            getSESSION().save(firstName);
            commit();
            return firstName;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not create firstname " + uname, e);
        }
    }

    public FirstName retrieve(String uname) throws Exception {
        try {
            begin();
            Query q = getSESSION().createQuery("from User where userName = :username");
            q.setString("uname", uname);
            FirstName firstName = (FirstName) q.uniqueResult();
            commit();
            return firstName;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not get firstname " + uname, e);
        }
    }

    public void delete(FirstName firstName) throws Exception {
        try {
            begin();
            getSESSION().delete(firstName);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not delete firstName " + firstName.getUname(), e);
        }
    }

}
