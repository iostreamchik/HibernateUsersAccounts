package dao;

import hibernate.classes.UserData;
import org.hibernate.HibernateException;
import org.hibernate.Query;

public class UserDataDAO extends DAO {
    public UserData create(String login, Long pass, String email, Long userStatus, Long userData) throws Exception {
        try {
            UserData userDataLoc = new UserData(login, pass, email, userStatus, userData);
            getSESSION().save(userDataLoc);
            commit();
            return userDataLoc;
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new Exception("Could not create UserData " + login, e);
        }
    }

    public UserData retrieve(String login) throws Exception {
        try {
            begin();
            Query query = getSESSION().createQuery("from UserData where login =:login");
            //TODO need to know about query.setString()
            query.setString("login", login);
            UserData tmp = (UserData) query.uniqueResult();
            commit();
            if (tmp != null) {
                return tmp;
            } else
                return null;
//            Criteria criteria = getSESSION().createCriteria(UserData.class);
//            criteria.add(Restrictions.like("uname", "login"));
//            List results = criteria.list();
        } catch (HibernateException e) {
            throw new Exception("Can`t retrieve " + login, e);
        }
    }

    public void delete(UserData userData) throws Exception{
        try {
            begin();
            getSESSION().delete(userData);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Can`t delete " + userData.getLogin(), e);
        }
    }
}
