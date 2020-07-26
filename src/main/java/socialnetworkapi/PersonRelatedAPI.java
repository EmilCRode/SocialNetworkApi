package socialnetworkapi;

public interface PersonRelatedAPI {
    //Ausgabe ist gefordert, also keine Rückgabe.

    public void getProfile(long pid);
    public void getCommonInterestsOfMyFriends(long pid);
    //Könnte User Input in die Methode verlegen ist unklar formuliert.
    public void getCommonFriends(long pid1, long pid2);
    public void getPersonsWithMostCommonInterests(long pid);
    public void getJobRecommendation(long pid);
    //Hardest method???
    public void getShorthestFriendshipPath(long pid);
}
