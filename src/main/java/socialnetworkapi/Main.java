package socialnetworkapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import socialnetworkapi.models.Person;

public class Main {

    public static void main(String[] args) {
        Configuration con = new Configuration().configure();
        SessionFactory sessionFactory = con.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Person p94 = (Person) session.get(Person.class, 94);
    }

}
