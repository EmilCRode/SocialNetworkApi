package socialnetworkapi;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;

        try {
            System.out.println( "Initializing Hibernate" );
            sessionFactory = new Configuration().configure().buildSessionFactory();
            System.out.println( "Finished Initializing Hibernate" );
        } catch(HibernateException ex) {
            ex.printStackTrace();
            System.exit( 5 );
        }

        Session session = sessionFactory.openSession();
        //Transaction transaction = session.beginTransaction();
        //Person p94 = session.get(Person.class, (long) 94);
        //transaction.commit();

        //PersonRelatedImpl pApi = new PersonRelatedImpl();
        //pApi.getProfile(session, 12094627905604L);

        StatisticImpl sApi = new StatisticImpl();
        sApi.getTagClassHierarchy(session);

        session.close();
    }
}