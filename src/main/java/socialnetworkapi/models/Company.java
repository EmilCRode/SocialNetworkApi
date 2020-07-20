package socialnetworkapi.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid", nullable = false)
    private long cid;

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    private String name;

    @ManyToOne
    @JoinColumn(name = "country", referencedColumnName = "counid", nullable = false)
    private Country country;

    /* Do we need this?*/
    @OneToMany(mappedBy = "company")
    private Collection<WorksAt> worksAts;

    @OneToMany(mappedBy = "company")
    private Collection<WorksAtTermination> worksAtTerminations;

    public Company() {

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Company other = (Company) obj;
        return (cid == other.cid) &&
                Objects.equals(this.country, other.country) &&
                Objects.equals(this.name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cid, name, country);
    }

    public long getCid() {
        return cid;
    }
    public void setCid(long cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }
    public void setCountry(Country country) {
        this.country = country;
    }

    public Collection<WorksAt> getWorksAts() {
        return worksAts;
    }
    public void setWorksAts(Collection<WorksAt> worksAts) {
        this.worksAts = worksAts;
    }

    public Collection<WorksAtTermination> getWorksAtTerminations() {
        return worksAtTerminations;
    }
    public void setWorksAtTerminations(Collection<WorksAtTermination> worksAtTerminations) {
        this.worksAtTerminations = worksAtTerminations;
    }
}
