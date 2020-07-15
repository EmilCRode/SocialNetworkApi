package socialnetworkapi.models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class StudiesAtPK implements Serializable {
    @Column(name = "person", nullable = false)
    private long person;

    @Column(name = "university", nullable = false)
    private long university;

    @Column(name = "class_year", nullable = false)
    private int classYear;

    /* --- */

    public  StudiesAtPK() {}

    public StudiesAtPK(long person, long university, int classYear) {
        this.person = person;
        this.university = university;
        this.classYear = classYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudiesAtPK that = (StudiesAtPK) o;
        return person == that.person &&
                university == that.university &&
                classYear == that.classYear;
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, university, classYear);
    }

    public long getPerson() {
        return person;
    }
    public void setPerson(long person) {
        this.person = person;
    }

    public long getUniversity() {
        return university;
    }
    public void setUniversity(long university) {
        this.university = university;
    }

    public int getClassYear() {
        return classYear;
    }
    public void setClassYear(int classYear) {
        this.classYear = classYear;
    }
}
