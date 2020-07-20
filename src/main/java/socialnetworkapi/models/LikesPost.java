package socialnetworkapi.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "likes_post")
public class LikesPost {
    @EmbeddedId
    private LikesPostPK id;

    @ManyToOne
    @MapsId("person")
    @JoinColumn(name = "person", referencedColumnName = "pid", nullable = false)
    private Person person;

    @ManyToOne
    @MapsId("post")
    @JoinColumn(name = "post", referencedColumnName = "postid", nullable = false)
    private Post post;

    @Basic
    @Column(name = "creation_date", nullable = false)
    private Timestamp creationDate;

    /* --- */

    public LikesPost() {}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        LikesPost other = (LikesPost) obj;
        return Objects.equals(this.person, other.person) &&
                Objects.equals(this.post, other.post) &&
                Objects.equals(this.creationDate, other.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, post, creationDate);
    }

    public LikesPostPK getId() {
        return id;
    }
    public void setId(LikesPostPK id) {
        this.id = id;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }


    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }

    public Post getPost() {
        return post;
    }
    public void setPost(Post post) {
        this.post = post;
    }
}
