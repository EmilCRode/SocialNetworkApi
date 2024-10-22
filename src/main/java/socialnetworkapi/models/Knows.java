package socialnetworkapi.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "knows")
public class Knows {
    @EmbeddedId
    private KnowsPK id;

    @ManyToOne
    @MapsId("person_1")
    @JoinColumn(name = "person_1", referencedColumnName = "pid", nullable = false)
    private Person person1;

    @ManyToOne
    @MapsId("person_2")
    @JoinColumn(name = "person_2", referencedColumnName = "pid", nullable = false)
    private Person person2;

    @Basic
    @Column(name = "creation_date", nullable = false)
    private Timestamp creationDate;

    public Knows() {}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Knows other = (Knows) obj;
        return Objects.equals(this.person1, other.person1) &&
                Objects.equals(this.person2, other.person2) &&
                Objects.equals(this.creationDate, other.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person1, person2, creationDate);
    }

    public KnowsPK getId() {
        return id;
    }
    public void setId(KnowsPK id) {
        this.id = id;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Person getPerson1() {
        return person1;
    }
    public void setPerson1(Person person1) {
        this.person1 = person1;
    }

    public Person getPerson2() {
        return person2;
    }
    public void setPerson2(Person person2) {
        this.person2 = person2;
    }
}
