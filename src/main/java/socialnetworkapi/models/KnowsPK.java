package socialnetworkapi.models;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class KnowsPK implements Serializable {
    @Column(name = "person_1", nullable = false)
    private long person1;

    @Column(name = "person_2", nullable = false)
    private long person2;

    public KnowsPK() {}

    public KnowsPK(long person1, long person2) {
        this.person1 = person1;
        this.person2 = person2;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        KnowsPK other = (KnowsPK) obj;
        return person1 == other.person1 &&
                person2 == other.person2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(person1, person2);
    }

    public long getPerson1() {
        return person1;
    }
    public void setPerson1(long person1) {
        this.person1 = person1;
    }

    public long getPerson2() {
        return person2;
    }
    public void setPerson2(long person2) {
        this.person2 = person2;
    }
}
