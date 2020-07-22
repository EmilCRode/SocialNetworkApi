package socialnetworkapi.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "speaks")
public class Speaks {
    @EmbeddedId
    private SpeaksPK id;

    /*  Questionable */
    @ManyToOne
    @MapsId("person")
    @JoinColumn(name = "person", referencedColumnName = "pid", nullable = false)
    private Person person;

    public Speaks() {}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Speaks other = (Speaks) obj;
        return Objects.equals(this.person, other.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash();
    }

    public SpeaksPK getId() {
        return id;
    }
    public void setId(SpeaksPK id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
}
