package socialnetworkapi;

import socialnetworkapi.models.Tag;
import socialnetworkapi.models.TagClass;

import java.util.ArrayList;

public class TagTree {
    private Object data;
    private ArrayList<TagTree> parents;
    private ArrayList<TagTree> children;

    /* Constructors */
    public TagTree(Tag tag){
        this.data =tag;
        this.parents = new ArrayList<TagTree>();
        this.children = new ArrayList<TagTree>();
    }
    public TagTree(TagTree parent, Tag tag){
        this.parents.add(parent);
        this.data = tag;
        this.children = new ArrayList<TagTree>();
    }
    public TagTree(TagClass tagClass){
        this.data = tagClass;
        this.parents = new ArrayList<TagTree>();
        this.children = new ArrayList<TagTree>();
        for(TagClass currentChild: tagClass.getSubclasses()){
            this.addChild(currentChild);
        }
    }
    public TagTree(TagTree parent, TagClass tagClass){
        if(this.parents != null) this.parents.add(parent);
        else this.parents = new ArrayList<TagTree>();
        this.data = tagClass;
        this.children = new ArrayList<TagTree>();
        for(TagClass currentChild: tagClass.getSubclasses()){
            this.addChild(currentChild);
        }

    }
    public TagTree(){
        this.children = new ArrayList<TagTree>();
        this.parents = new ArrayList<TagTree>();
    }

    public void addChild(Object o){
        if(o.getClass() == Tag.class){
            TagTree tmp = new TagTree(this, (Tag) o);
            children.add(tmp);
        }else if(o.getClass() == TagClass.class) {
            if(parents.contains(o)) return;
            TagTree tmp = new TagTree(this, (TagClass) o);
            children.add(tmp);

        }else{ System.out.println("Error while adding Child to Tree: Object not of right type."); }
    }
    public void addParent(TagTree parent){
        if(parents.contains(parent)) return;
        parents.add(parent);
    }
    public TagTree search(Object target) {
        if (target.equals(this.data)) return this;
        if (this.children == null) return null;
        TagTree[] children = this.children.toArray(new TagTree[this.children.size()]);
        TagTree tmp = null;
        if (children.length > 0) {
            for (int i = 0; i < children.length; i++){
                tmp = children[i].search(target);
                if(tmp != null) return tmp;
            }
        }
        return null;
    }
    public void printTree(String prefix){
        System.out.println(prefix + this.data);
        for(TagTree item: this.children){ item.printTree( "-" + prefix); }
    }
}
