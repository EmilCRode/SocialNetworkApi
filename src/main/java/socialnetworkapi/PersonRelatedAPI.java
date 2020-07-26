package socialnetworkapi;

import org.hibernate.Session;

public interface PersonRelatedAPI {
    //Ausgabe ist gefordert, also keine Rückgabe.

    public void getProfile(Session session, long pid);
    public void getCommonInterestsOfMyFriends(Session session, long pid);
    //Könnte User Input in die Methode verlegen ist unklar formuliert.
    public void getCommonFriends(Session session, long pid1, long pid2);
    public void getPersonsWithMostCommonInterests(Session session, long pid);
    public void getJobRecommendation(Session session, long pid);
    //Hardest method???
    public void getShortestFriendshipPath(Session session, long pid);
}
