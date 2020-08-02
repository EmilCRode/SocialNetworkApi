package socialnetworkapi;

import socialnetworkapi.models.TagClass;

import java.util.ArrayList;

public class TagTree {
    private TagClass data;
    private ArrayList<TagTree> children;

    /* Constructors */
    public TagTree(){ this.children = new ArrayList<TagTree>(); }
    public TagTree(TagClass tagClass) {
        this.data = tagClass;
        this.children = new ArrayList<TagTree>();
        for (TagClass currentChild : tagClass.getSubclasses()) {
            this.addChild(currentChild);
        }
    }

    /* Getter and Setter */
    public Object getData() { return data; }
    public void setData(TagClass data) { this.data = data; }
    public ArrayList<TagTree> getChildren() { return children; }
    public void setChildren(ArrayList<TagTree> children) { this.children = children; }

    /* Utility Methods */
    public void addChild(TagClass child){
        TagTree tmp = new TagTree(child);
        this.children.add(tmp);
    }
    public TagTree search(TagClass target) {
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
    public void printTree(String postfix){
        System.out.println("0" + postfix + " " + this.data);
        for(int i = 0; i < this.children.size(); i++){ this.children.get(i).printTree( postfix + "." + (i+1)); }
    }
}
