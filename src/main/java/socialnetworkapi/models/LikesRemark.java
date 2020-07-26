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

    public LikesRemark() {}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        LikesRemark other = (LikesRemark) obj;
        return Objects.equals(this.person, other.person) &&
                Objects.equals(this.remark, other.remark) &&
                Objects.equals(this.creationDate, other.creationDate);
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
