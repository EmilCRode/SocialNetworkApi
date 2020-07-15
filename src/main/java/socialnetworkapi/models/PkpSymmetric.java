package socialnetworkapi.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "pkp_symmetric")
public class PkpSymmetric {
    @Basic
    @Column(name = "person_1", nullable = true)
    private Long person1;

    @Basic
    @Column(name = "person_2", nullable = true)
    private Long person2;

    /* --- */

    public PkpSymmetric() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PkpSymmetric that = (PkpSymmetric) o;
        return Objects.equals(person1, that.person1) &&
                Objects.equals(person2, that.person2);
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
