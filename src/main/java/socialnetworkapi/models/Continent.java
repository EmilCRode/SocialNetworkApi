package socialnetworkapi.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "continent")
public class Continent extends Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contid", nullable = false)
    private long contid;

    @OneToMany(mappedBy = "isPartOf")
    private Collection<Country> countries;

    public Continent() {

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Continent other = (Continent) obj;
        return (contid == other.contid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contid);
    }

    public long getContid() {
        return contid;
    }
    public void setContid(long contid) {
        this.contid = contid;
    }

    public Collection<Country> getCountries() {
        return countries;
    }
    public void setCountries(Collection<Country> countries) {
        this.countries = countries;
    }
}
