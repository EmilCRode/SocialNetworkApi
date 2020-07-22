package socialnetworkapi.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "studies_at")
public class StudiesAt {
    @EmbeddedId
    private StudiesAtPK id;

    @ManyToOne
    @MapsId("person")
    @JoinColumn(name = "person", referencedColumnName = "pid", nullable = false)
    private Person person;

    @ManyToOne
    @MapsId("university")
    @JoinColumn(name = "university", referencedColumnName = "uid", nullable = false)
    private University university;

    public StudiesAt() {}

    @Override
    public int hashCode() {
        return Objects.hash(person, university);
    }

    @Override
    public boolean equals(Object obj){
        // if both the object references are
        // referring to the same object.
        if (this == obj)
            return true;
        // it checks if the argument is of the
        // right type by comparing the classes
        // of the passed argument and this object.
        if(obj == null || obj.getClass()!= this.getClass())
            return false;
        // type casting of the argument.
        StudiesAt other = (StudiesAt) obj;
        // comparing the state of argument with
        // the state of 'this' Object.
        return  Objects.equals(other.id, this.id) && Objects.equals(other.person, this.person) &&
                Objects.equals(other.university, this.university);
    }

    public StudiesAtPK getId() {
        return id;
    }
    public void setId(StudiesAtPK id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }

    public University getUniversity() {
        return university;
    }
    public void setUniversity(University university) {
        this.university = university;
    }
}
