package socialnetworkapi.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "forum")
public class Forum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fid", nullable = false)
    private long fid;

    @Basic
    @Column(name = "title", nullable = false, length = -1)
    private String title;

    @Basic
    @Column(name = "creation_date", nullable = false)
    private Timestamp creationDate;

    @ManyToOne
    @JoinColumn(name = "moderator", referencedColumnName = "pid", nullable = false)
    private Person moderator;

    @ManyToMany
    @JoinTable(name = "forum_has_tag", joinColumns = @JoinColumn(name = "forum"), inverseJoinColumns = @JoinColumn(name = "tag"))
    private Collection<Tag> tags;

    @OneToMany(mappedBy = "forum")
    private Collection<HasMember> hasMembers;

    @OneToMany(mappedBy = "forum")
    private Collection<Post> posts;

    public Forum() {}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Forum other = (Forum) obj;
        return fid == other.fid &&
                this.moderator.equals(other.moderator) &&
                this.title == other.title &&
                this.creationDate.equals(other.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fid, title, creationDate, moderator);
    }

    public long getFid() {
        return fid;
    }
    public void setFid(long fid) {
        this.fid = fid;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Person getModerator() {
        return moderator;
    }
    public void setModerator(Person moderator) {
        this.moderator = moderator;
    }

    public Collection<Tag> getTags() {
        return tags;
    }
    public void setTags(Collection<Tag> tags) {
        this.tags = tags;
    }

    public Collection<HasMember> getHasMembers() {
        return hasMembers;
    }
    public void setHasMembers(Collection<HasMember> hasMembers) {
        this.hasMembers = hasMembers;
    }

    public Collection<Post> getPosts() {
        return posts;
    }
    public void setPosts(Collection<Post> posts) {
        this.posts = posts;
    }
}
