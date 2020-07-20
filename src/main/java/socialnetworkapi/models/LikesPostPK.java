package socialnetworkapi.models;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class LikesPostPK implements Serializable {
    @Column(name = "person", nullable = false)
    private long person;

    @Column(name = "post", nullable = false)
    private long post;

    public LikesPostPK() {}

    public LikesPostPK(long person, long post) {
        this.person = person;
        this.post = post;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        LikesPostPK other = (LikesPostPK) obj;
        return person == other.person &&
                post == other.post;
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, post);
    }

    public long getPerson() {
        return person;
    }
    public void setPerson(long person) {
        this.person = person;
    }

    public long getPost() {
        return post;
    }
    public void setPost(long postId) {
        this.post = post;
    }
}
