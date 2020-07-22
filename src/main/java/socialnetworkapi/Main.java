package socialnetworkapi;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import socialnetworkapi.models.Person;

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
        Transaction transaction = session.beginTransaction();
        Person p94 = session.get(Person.class, (long) 94);
        transaction.commit();
        session.close();

        System.out.println(p94.getFirstName());
        System.out.println(p94.getLastName());
    }
}
