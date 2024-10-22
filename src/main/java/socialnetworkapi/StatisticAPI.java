package socialnetworkapi;

import org.hibernate.Session;

public interface StatisticAPI {
    public void getTagClassHierarchy(Session session);
    public void getPopularComments(Session session, int k);
    public void getMostPostingCountry(Session session);
}
