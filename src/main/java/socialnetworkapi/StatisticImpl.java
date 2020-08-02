package socialnetworkapi;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import socialnetworkapi.models.TagClass;

import java.util.List;

public class StatisticImpl implements StatisticAPI {
    public void getTagClassHierarchy(Session session){
        TagTree root = new TagTree();
        try{
            TagClass startpoint = session.get(TagClass.class, 0L);
            root.addChild(startpoint);
        }catch(HibernateException hibernateException) {}
        System.out.println("Begin Tree Print:");
        for(int i = 0; i < root.getChildren().size(); i++){
            root.getChildren().get(i).printTree("");
        }
    }



    public void getTagClassHierarchy2(Session session) {
        TagTree root = new TagTree();
        try {
            TagClass[] superClasses;
            TagClass currentTC;
            List<TagClass> results = session.createQuery("SELECT a FROM TagClass a", TagClass.class).getResultList();
            for(int i = 0; i < results.size(); i++) {
                currentTC = results.get(i);
                superClasses = currentTC.getSuperclasses().toArray(new TagClass[currentTC.getSuperclasses().size()]);
                if (superClasses.length == 0) {
                    root.addChild(currentTC);
                    results.remove(i);
                }
            }
        }catch (HibernateException hibernateException) {
            System.out.println("Exception while trying to fetch TagClass Objects: " + hibernateException.getMessage());
        }
        root.printTree("Begin Tree Print:\n");
    }
    public void getTagClassHierarchy1(Session session) {
        TagTree root = new TagTree();
        try {
            TagClass[] superClasses;
            TagClass currentTC;
            List<TagClass> results = session.createQuery("SELECT a FROM TagClass a", TagClass.class).getResultList();
            for(int i = 0; i < results.size(); i++) {
                currentTC = results.get(i);
                superClasses = currentTC.getSuperclasses().toArray(new TagClass[currentTC.getSuperclasses().size()]);
                if (superClasses.length == 0) {
                    root.addChild(currentTC);
                    results.remove(i);
                }
            }
            TagTree currentTree;
            while(results.isEmpty() == false) {
                for (int k = 0; k < results.size(); k++) {
                    int size = results.size();
                    currentTC = results.get(k);
                    currentTree = root.search(currentTC.getSuperclasses());
                    if (currentTree != null) {
                        currentTree.addChild(currentTC);
                        results.remove(currentTC);
                    }
                }
            }
        }catch (HibernateException hibernateException) {
            System.out.println("Exception while trying to fetch TagClass Objects: " + hibernateException.getMessage());
        }
        root.printTree("Begin Tree Print:\n");
    }

    public void getPopularComments(Session session, int k) {

    }

    public void getMostPostingCountry(Session session) {

    }
}
