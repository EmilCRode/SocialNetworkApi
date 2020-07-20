package socialnetworkapi.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pkp_symmetric")
public class PkpSymmetric {
    @EmbeddedId
    private PkpSymmetricPK id;

    @Basic
    @Column(name = "person_1", nullable = true)
    private Long person1;

    @Basic
    @Column(name = "person_2", nullable = true)
    private Long person2;

    public PkpSymmetric() {}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PkpSymmetric other = (PkpSymmetric) obj;
        return Objects.equals(this.person1, other.person1) &&
                Objects.equals(this.person2, other.person2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person1, person2);
    }

    public Long getPerson1() {
        return person1;
    }
    public void setPerson1(Long person1) {
        this.person1 = person1;
    }

    public Long getPerson2() {
        return person2;
    }
    public void setPerson2(Long person2) {
        this.person2 = person2;
    }
}
