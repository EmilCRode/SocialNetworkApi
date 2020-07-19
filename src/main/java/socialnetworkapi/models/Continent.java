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

    public Continent() {

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Continent other = (Continent) obj;
        return contid == other.contid &&
                this.name == other.name;
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
