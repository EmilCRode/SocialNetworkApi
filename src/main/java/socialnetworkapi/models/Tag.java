package socialnetworkapi.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tid", nullable = false)
    private long tid;

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    private String name;

    @ManyToMany(mappedBy = "tags")
    private Collection<Forum> forums;

    @ManyToMany(mappedBy = "interests")
    private Collection<Person> hasInterests;

    @ManyToMany(mappedBy = "tags")
    private Collection<Post> posts;

    @ManyToMany(mappedBy = "tags")
    private Collection<Remark> remarks;

    @ManyToMany
    @JoinTable(name = "tag_has_type", joinColumns = @JoinColumn(name = "tag"), inverseJoinColumns = @JoinColumn(name = "tag_class"))
    private Collection<TagClass> tagClasses;

    public Tag() {}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Tag other = (Tag) obj;
        return (tid == other.tid) &&
                Objects.equals(this.name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tid, name);
    }

    public long getTid() {
        return tid;
    }
    public void setTid(long tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Collection<Forum> getForums() {
        return forums;
    }
    public void setForums(Collection<Forum> forums) {
        this.forums = forums;
    }

    public Collection<Person> getHasInterests() {
        return hasInterests;
    }
    public void setHasInterests(Collection<Person> hasInterests) {
        this.hasInterests = hasInterests;
    }

    public Collection<Post> getPosts() {
        return posts;
    }
    public void setPosts(Collection<Post> posts) {
        this.posts = posts;
    }

    public Collection<Remark> getRemarks() {
        return remarks;
    }
    public void setRemarks(Collection<Remark> remarks) {
        this.remarks = remarks;
    }

    public Collection<TagClass> getTagClasses() {
        return tagClasses;
    }

    public void setTagClasses(Collection<TagClass> tagClasses) {
        this.tagClasses = tagClasses;
    }
}
