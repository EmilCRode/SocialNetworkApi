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

    @MapsId("class_year")
    @Column(name = "class_year", nullable = false)
    private int classYear;

    /* --- */

    public StudiesAt() {}

    @Override
    public int hashCode() {
        return Objects.hash(person, university, classYear);
    } //Maybe just use the PK hash

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
        return (other.id.equals(this.id)  && other.person.equals(this.person) &&
                other.university.equals(this.university) && other.classYear==this.classYear);
    }

    public StudiesAtPK getId() {
        return id;
    }
    public void setId(StudiesAtPK id) {
        this.id = id;
    }

    public int getClassYear() {
        return classYear;
    }
    public void setClassYear(int classYear) {
        this.classYear = classYear;
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
