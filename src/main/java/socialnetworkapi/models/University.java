package socialnetworkapi.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "university")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private long uid;

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    private String name;

    @ManyToOne
    @JoinColumn(name = "city", referencedColumnName = "cityid", nullable = false)
    private City city;

    @OneToMany(mappedBy = "university")
    private Collection<StudiesAt> studiesAts;

    /* --- */

    public University() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return uid == that.uid &&
                city == that.city &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, name, city);
    }

    public long getUid() {
        return uid;
    }
    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }
    public void setCity(City city) {
        this.city = city;
    }

    public Collection<StudiesAt> getStudiesAts() {
        return studiesAts;
    }
    public void setStudiesAts(Collection<StudiesAt> studiesAts) {
        this.studiesAts = studiesAts;
    }
}
