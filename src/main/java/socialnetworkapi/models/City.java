package socialnetworkapi.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "city")
public class City extends Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cityid", nullable = false)
    private long cityid;

    @ManyToOne
    @JoinColumn(name = "is_part_of", referencedColumnName = "counid", nullable = false)
    private Country isPartOf;

    /* Do we need this? */
    @OneToMany(mappedBy = "city")
    private Collection<Person> persons;

    @OneToMany(mappedBy = "city")
    private Collection<University> universities;

    public City() {}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        City other = (City) obj;
        return (cityid == other.cityid) &&
                Objects.equals(this.isPartOf, other.isPartOf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityid, isPartOf);
    }

    @Override
    public String toString(){
        return this.getName();
    }

    public long getCityid() {
        return cityid;
    }
    public void setCityid(long cityid) {
        this.cityid = cityid;
    }

    public Country getIsPartOf() {
        return isPartOf;
    }
    public void setIsPartOf(Country isPartOf) {
        this.isPartOf = isPartOf;
    }

    public Collection<Person> getPersons() {
        return persons;
    }
    public void setPersons(Collection<Person> persons) {
        this.persons = persons;
    }

    public Collection<University> getUniversities() {
        return universities;
    }
    public void setUniversities(Collection<University> universities) {
        this.universities = universities;
    }
}
