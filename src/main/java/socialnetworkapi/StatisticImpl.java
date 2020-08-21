package socialnetworkapi;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import socialnetworkapi.models.LikesRemark;
import socialnetworkapi.models.Remark;
import socialnetworkapi.models.TagClass;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public void getMostPostingCountry(Session session) {

    }
}
