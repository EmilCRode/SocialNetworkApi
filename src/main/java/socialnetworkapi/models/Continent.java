package socialnetworkapi.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "continent")
public class Continent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contid", nullable = false)
    private long contid;

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    private String name;

    @OneToMany(mappedBy = "isPartOf")
    private Collection<Country> countries;

    /* --- */

    public Continent() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Continent continent = (Continent) o;
        return contid == continent.contid &&
                Objects.equals(name, continent.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contid, name);
    }

    public long getContid() {
        return contid;
    }
    public void setContid(long contid) {
        this.contid = contid;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Collection<Country> getCountries() {
        return countries;
    }
    public void setCountries(Collection<Country> countries) {
        this.countries = countries;
    }
}
