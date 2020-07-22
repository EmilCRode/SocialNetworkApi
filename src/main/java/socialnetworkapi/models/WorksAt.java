package socialnetworkapi.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "works_at")
public class WorksAt {
    @EmbeddedId
    private WorksAtPK id;

    @ManyToOne
    @MapsId("person")
    @JoinColumn(name = "person", referencedColumnName = "pid", nullable = false)
    private Person person;

    @ManyToOne
    @MapsId("company")
    @JoinColumn(name = "company", referencedColumnName = "cid", nullable = false)
    private Company company;

    public WorksAt() {}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        WorksAt other = (WorksAt) obj;
        return  Objects.equals(this.person, other.person) &&
                Objects.equals(this.company, other.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, company);
    }

    public WorksAtPK getId() {
        return id;
    }
    public void setId(WorksAtPK id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }

    public Company getCompany() {
        return company;
    }
    public void setCompany(Company company) {
        this.company = company;
    }
}
