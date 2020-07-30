package socialnetworkapi;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import socialnetworkapi.models.TagClass;

import java.util.List;

public class StatisticImpl implements StatisticAPI {

    public void getTagClassHierarchy(Session session) {
        StringBuilder sb = new StringBuilder();
        TagTree tree = new TagTree();
        try {
            List<TagClass> results = session.createQuery("SELECT a FROM TagClass a", TagClass.class).getResultList();
            while(results.isEmpty() == false) {

            }
        }catch (HibernateException hibernateException){
            System.out.println("Exception while trying to fetch TagClass Objects: " + hibernateException.getMessage());
        }
    }

    public void getPopularComments(Session session, int k) {

    }

    public void getMostPostingCountry(Session session) {

    }
}
