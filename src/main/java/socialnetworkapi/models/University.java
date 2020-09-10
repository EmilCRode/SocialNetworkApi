package socialnetworkapi.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "university")
public class University extends Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private long uid;

    @ManyToOne
    @JoinColumn(name = "city", referencedColumnName = "cityid", nullable = false)
    private City city;

    @OneToMany(mappedBy = "university")
    private Collection<StudiesAt> studiesAts;

    public University() {}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        University other = (University) obj;
        return  (uid == other.uid) &&
                Objects.equals(this.city, other.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, city);
    }

    public long getUid() {
        return uid;
    }
    public void setUid(long uid) {
        this.uid = uid;
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
