package socialnetworkapi;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import socialnetworkapi.models.*;

import java.util.*;

public class StatisticImpl implements StatisticAPI {
    public void getTagClassHierarchy(Session session){
        TagTree root = new TagTree();
        try{
            // This need check for multiples roots of the tree even if its stupid //
            TagClass startpoint = session.get(TagClass.class, 0L);
            root.addChild(startpoint);
        }catch(HibernateException hibernateException) {}
        System.out.println("Begin Tree Print:");
        for(int i = 0; i < root.getChildren().size(); i++){
            root.getChildren().get(i).printTree("");
        }
    }

    public void getPopularComments(Session session, int k) {
        HashMap<Remark, Integer> remarksPerCount = new HashMap<Remark, Integer>();
        List<LikesRemark> results = session.createQuery("SELECT a FROM LikesRemark a", LikesRemark.class).getResultList();
        for (LikesRemark current : results) {
            Remark remark = current.getRemark();
            Integer count = remarksPerCount.get(remark);
            if (count == null) {
                remarksPerCount.put(remark, 1);
            } else {
                remarksPerCount.put(remark, count + 1);
            }
        }
        for (Map.Entry<Remark, Integer> entry : remarksPerCount.entrySet()) {
            if(entry.getValue() >= k){
                System.out.println("Comment ID: " + entry.getKey().getRid()
                        + ", Creator Name: " + entry.getKey().getCreator().getName()
                        + ", Likes: " + entry.getValue());
            }
        }
    }

    /*
        Checked the result: It checks out in the data. 35 Comments from China + 2074 Posts.
     */
    public void getMostPostingCountry(Session session) {
        HashMap<Country, Integer> countryPerCount = new HashMap<>();
        List<Post> postList = session.createQuery("SELECT p FROM Post p", Post.class).getResultList();
        List<Remark> remarkList = session.createQuery("SELECT r FROM Remark r", Remark.class).getResultList();
        for (Post currentPost: postList){
            Country country = currentPost.getCountry();
            Integer count = countryPerCount.get(country);
            if(count == null){ countryPerCount.put(country, 1); }
            else { countryPerCount.put(country, count + 1); }
        }
        for (Remark currentRemark: remarkList){
            Country country = currentRemark.getCountry();
            Integer count = countryPerCount.get(country);
            if(count == null){ countryPerCount.put(country, 1); }
            else { countryPerCount.put(country, count + 1); }
        }
        Map.Entry<Country, Integer> maxEntry  = Collections.max(countryPerCount.entrySet(), new Comparator<Map.Entry<Country, Integer>>() {
            @Override
            public int compare(Map.Entry<Country, Integer> o1, Map.Entry<Country, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        System.out.println("Country: " + maxEntry.getKey().getName() + " --> Comments and Posts: " + maxEntry.getValue());
    }
}
