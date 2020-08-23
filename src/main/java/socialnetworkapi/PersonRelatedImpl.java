package socialnetworkapi;

import org.hibernate.Session;
import org.hibernate.query.Query;
import socialnetworkapi.models.Company;
import socialnetworkapi.models.Person;
import socialnetworkapi.models.University;

import java.util.List;

public class PersonRelatedImpl implements PersonRelatedAPI{
    public void getProfile(Session session, long pid) {
        System.out.println(session.get(Person.class, pid));
    }

    public void getCommonInterestsOfMyFriends(Session session, long pid) {

    }

    public void getCommonFriends(Session session, long pid1, long pid2) {

    }

    public void getPersonsWithMostCommonInterests(Session session, long pid) {

    }

    public void getJobRecommendation(Session session, long pid) {
        boolean found = false;
        Person person = session.get(Person.class, pid);
        Query uniHql = session.createQuery("FROM University u WHERE u.city = :city", University.class);
        uniHql.setParameter("city", person.getCity());
        List<University> universityList = uniHql.getResultList();
        for(University current: universityList){
            System.out.println(current.getName());
        }
        Query companyHql = session.createQuery("FROM Company c WHERE c.country = :country", Company.class);
        companyHql.setParameter("country", person.getCity().getIsPartOf());
        List<Company> companyList = companyHql.getResultList();
        for(Company current: companyList){
            System.out.println(current.getName());
        }

    }

    public void getShortestFriendshipPath(Session session, long pid) {

    }
}
