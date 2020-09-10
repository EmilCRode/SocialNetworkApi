package socialnetworkapi;

import org.hibernate.Session;
import socialnetworkapi.models.Person;

public interface PersonRelatedAPI {
    public void getProfile(Session session, Person person);
    public void getCommonInterestsOfMyFriends(Session session, Person person);
    public void getCommonFriends(Session session, Person person, Person targetPerson);
    public void getPersonsWithMostCommonInterests(Session session, Person person);
    public void getJobRecommendation(Session session, Person person);
    public void getShortestFriendshipPath(Session session, Person person, Person targetPerson);
}
