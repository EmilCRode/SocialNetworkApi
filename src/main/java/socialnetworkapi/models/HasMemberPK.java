package socialnetworkapi.models;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class HasMemberPK implements Serializable {
    @Column(name = "forum", nullable = false)
    private long forum;

    @Column(name = "person", nullable = false)
    private long person;

    /* --- */

    public HasMemberPK() {}

    public HasMemberPK(long forum, long person) {
        this.forum = forum;
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HasMemberPK that = (HasMemberPK) o;
        return forum == that.forum &&
                person == that.person;
    }

    @Override
    public int hashCode() {
        return Objects.hash(forum, person);
    }

    public long getForum() {
        return forum;
    }
    public void setForum(long forum) {
        this.forum = forum;
    }

    public long getPerson() {
        return person;
    }
    public void setPerson(long person) {
        this.person = person;
    }
}
