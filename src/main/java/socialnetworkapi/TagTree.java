package socialnetworkapi;

import socialnetworkapi.models.Tag;
import socialnetworkapi.models.TagClass;

import java.util.ArrayList;

public class TagTree {
    private Tag tag;
    private TagClass tagClass;
    private TagTree parent;
    private ArrayList<TagTree> children;

    /* Constructors */
    public TagTree(Tag tag){ this.tag = tag; }
    public TagTree(TagTree parent, Tag tag){
        this.parent = parent;
        this.tag = tag;
    }
    public TagTree(TagClass tagClass){ this.tagClass = tagClass; }
    public TagTree(TagTree parent, TagClass tagClass){
        this.parent = parent;
        this.tagClass = tagClass;
    }
    public TagTree(){ }

    public void addChild(Object o){
        if(children == null){ this.children = new ArrayList<TagTree>(); }
        if(o.getClass() == Tag.class){
            TagTree tmp = new TagTree(this, (Tag) o);
            children.add(tmp);
        }else if(o.getClass() == TagClass.class) {
            TagTree tmp = new TagTree(this, (TagClass) o);
            children.add(tmp);
        }else{ System.out.println("Error while adding Child to Tree: Object not of right type."); }
    }
}
