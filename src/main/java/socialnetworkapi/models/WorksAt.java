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

    @MapsId("work_from")
    @Column(name = "work_from", nullable = false)
    private int workFrom;

    /* --- */

    public WorksAt() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorksAt worksAt = (WorksAt) o;
        return person == worksAt.person &&
                company == worksAt.company &&
                workFrom == worksAt.workFrom;
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, company, workFrom);
    }

    public WorksAtPK getId() {
        return id;
    }
    public void setId(WorksAtPK id) {
        this.id = id;
    }

    public int getWorkFrom() {
        return workFrom;
    }
    public void setWorkFrom(int workFrom) {
        this.workFrom = workFrom;
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
