package socialnetworkapi.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "has_member")
public class HasMember {
    @EmbeddedId
    private HasMemberPK id;

    @ManyToOne
    @MapsId("forum")
    @JoinColumn(name = "forum", referencedColumnName = "fid", nullable = false)
    private Forum forum;

    @ManyToOne
    @MapsId("person")
    @JoinColumn(name = "person", referencedColumnName = "pid", nullable = false)
    private Person person;

    @Basic
    @Column(name = "join_date", nullable = false)
    private Timestamp joinDate;

    public HasMember() {}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        HasMember other = (HasMember) obj;
        return  Objects.equals(this.id, other.id) &&
                Objects.equals(this.forum, other.forum) &&
                Objects.equals(this.person, other.person) &&
                Objects.equals(this.joinDate, other.joinDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(forum, person, joinDate);
    }

    public HasMemberPK getId() {
        return id;
    }
    public void setId(HasMemberPK id) {
        this.id = id;
    }

    public Timestamp getJoinDate() {
        return joinDate;
    }
    public void setJoinDate(Timestamp joinDate) {
        this.joinDate = joinDate;
    }

    public Forum getForum() {
        return forum;
    }
    public void setForum(Forum forum) {
        this.forum = forum;
    }

    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
}
