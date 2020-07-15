package socialnetworkapi.models;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class LikesPostPK implements Serializable {
    @Column(name = "person", nullable = false)
    private long person;

    @Column(name = "post", nullable = false)
    private long post;

    /* --- */

    public LikesPostPK() {}

    public LikesPostPK(long person, long post) {
        this.person = person;
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LikesPostPK that = (LikesPostPK) o;
        return person == that.person &&
                post == that.post;
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
