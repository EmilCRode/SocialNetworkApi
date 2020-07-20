package socialnetworkapi.models;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class PkpSymmetricPK implements Serializable {
    @Column(name = "person_1", nullable = false)
    private long person_1;

    @Column(name = "person_2", nullable = false)
    private long person_2;

    public PkpSymmetricPK() {}

    public PkpSymmetricPK(long person, long remark) {
        this.person_1 = person;
        this.person_2 = remark;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PkpSymmetricPK other = (PkpSymmetricPK) obj;
        return person_1 == other.person_1 &&
                person_2 == other.person_2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(person_1, person_2);
    }

    public long getPerson_1() {
        return person_1;
    }
    public void setPerson_1(long person_1) {
        this.person_1 = person_1;
    }

    public long getPerson_2() {
        return person_2;
    }
    public void setPerson_2(long person_2) {
        this.person_2 = person_2;
    }
}

