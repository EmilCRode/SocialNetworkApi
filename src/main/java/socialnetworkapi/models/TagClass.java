package socialnetworkapi.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tag_class")
public class TagClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tcid", nullable = false)
    private long tcid;

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    private String name;

    @ManyToMany
    @JoinTable(name = "tag_class_is_subclass_of", joinColumns = @JoinColumn(name = "tag_class"), inverseJoinColumns = @JoinColumn(name = "superclass"))
    private Collection<TagClass> superclasses;

    @ManyToMany(mappedBy = "superclasses")
    private Collection<TagClass> subclasses;

    @ManyToMany(mappedBy = "tagClasses")
    private Collection<Tag> tags;

    /* --- */

    public TagClass() {}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TagClass other = (TagClass) obj;
        return (tcid == other.tcid) &&
                Objects.equals(this.name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tcid, name);
    }

    public long getTcid() {
        return tcid;
    }
    public void setTcid(long tcid) {
        this.tcid = tcid;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Collection<TagClass> getSuperclasses() {
        return superclasses;
    }
    public void setSuperclasses(Collection<TagClass> superclasses) {
        this.superclasses = superclasses;
    }

    public Collection<TagClass> getSubclasses() {
        return subclasses;
    }
    public void setSubclasses(Collection<TagClass> subclasses) {
        this.subclasses = subclasses;
    }

    public Collection<Tag> getTags() {
        return tags;
    }
    public void setTags(Collection<Tag> tags) {
        this.tags = tags;
    }
}
