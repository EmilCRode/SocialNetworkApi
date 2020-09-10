package socialnetworkapi.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "company")
public class Company extends Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid", nullable = false)
    private long cid;

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
                Objects.equals(this.country, other.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cid, country);
    }

    public long getCid() {
        return cid;
    }
    public void setCid(long cid) {
        this.cid = cid;
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
