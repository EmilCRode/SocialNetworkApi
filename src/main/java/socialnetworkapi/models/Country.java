package socialnetworkapi.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "country")
public class Country extends Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "counid", nullable = false)
    private long counid;

    @ManyToOne
    @JoinColumn(name = "is_part_of", referencedColumnName = "contid", nullable = false)
    private Continent isPartOf;

    @OneToMany(mappedBy = "isPartOf")
    private Collection<City> cities;

    @OneToMany(mappedBy = "country")
    private Collection<Company> companies;

    @OneToMany(mappedBy = "country")
    private Collection<Post> posts;

    @OneToMany(mappedBy = "country")
    private Collection<Remark> remarks;

    public Country() {

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Country other = (Country) obj;
        return counid == other.counid &&
                Objects.equals(this.isPartOf, other.isPartOf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(counid, isPartOf);
    }

    public long getCounid() {
        return counid;
    }
    public void setCounid(long counid) {
        this.counid = counid;
    }

    public Continent getIsPartOf() {
        return isPartOf;
    }
    public void setIsPartOf(Continent isPartOf) {
        this.isPartOf = isPartOf;
    }

    public Collection<City> getCities() {
        return cities;
    }
    public void setCities(Collection<City> cities) {
        this.cities = cities;
    }

    public Collection<Company> getCompanies() {
        return companies;
    }
    public void setCompanies(Collection<Company> companies) {
        this.companies = companies;
    }

    public Collection<Post> getPosts() {
        return posts;
    }
    public void setPosts(Collection<Post> posts) {
        this.posts = posts;
    }

    public Collection<Remark> getRemarks() {
        return remarks;
    }
    public void setRemarks(Collection<Remark> remarks) {
        this.remarks = remarks;
    }
}
