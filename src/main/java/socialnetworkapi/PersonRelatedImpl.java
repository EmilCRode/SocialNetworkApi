package socialnetworkapi;

import org.hibernate.Session;
import socialnetworkapi.models.Person;

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

    }

    public void getShortestFriendshipPath(Session session, long pid) {

    }
}
