package socialnetworkapi.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "works_at_termination")
public class WorksAtTermination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "watid", nullable = false)
    private long watid;

    @Basic
    @Column(name = "work_from", nullable = false)
    private int workFrom;

    @Basic
    @Column(name = "termination_date", nullable = false)
    private Timestamp terminationDate;

    @ManyToOne
    @JoinColumn(name = "person", referencedColumnName = "pid", nullable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "company", referencedColumnName = "cid", nullable = false)
    private Company company;

    /* --- */

    public WorksAtTermination() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorksAtTermination that = (WorksAtTermination) o;
        return watid == that.watid &&
                person == that.person &&
                company == that.company &&
                workFrom == that.workFrom &&
                Objects.equals(terminationDate, that.terminationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(watid, person, company, workFrom, terminationDate);
    }

    public long getWatid() {
        return watid;
    }
    public void setWatid(long watid) {
        this.watid = watid;
    }

    public int getWorkFrom() {
        return workFrom;
    }
    public void setWorkFrom(int workFrom) {
        this.workFrom = workFrom;
    }

    public Timestamp getTerminationDate() {
        return terminationDate;
    }
    public void setTerminationDate(Timestamp terminationDate) {
        this.terminationDate = terminationDate;
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
