package socialnetworkapi.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "likes_remark")
public class LikesRemark {
    @EmbeddedId
    private LikesRemarkPK id;

    @ManyToOne
    @MapsId("person")
    @JoinColumn(name = "person", referencedColumnName = "pid", nullable = false)
    private Person person;

    @ManyToOne
    @MapsId("remark")
    @JoinColumn(name = "remark", referencedColumnName = "rid", nullable = false)
    private Remark remark;

    @Basic
    @Column(name = "creation_date", nullable = false)
    private Timestamp creationDate;

    /* --- */

    public LikesRemark() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LikesRemark that = (LikesRemark) o;
        return person == that.person &&
                remark == that.remark &&
                Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, remark, creationDate);
    }

    public LikesRemarkPK getId() {
        return id;
    }
    public void setId(LikesRemarkPK id) {
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

    public Remark getRemark() {
        return remark;
    }
    public void setRemark(Remark remark) {
        this.remark = remark;
    }
}
