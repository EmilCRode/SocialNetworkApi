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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudiesAt studiesAt = (StudiesAt) o;
        return person == studiesAt.person &&
                university == studiesAt.university &&
                classYear == studiesAt.classYear;
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, university, classYear);
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
