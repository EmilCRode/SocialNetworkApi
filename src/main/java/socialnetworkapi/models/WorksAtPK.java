package socialnetworkapi.models;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class WorksAtPK implements Serializable {
    @Column(name = "person", nullable = false)
    private long person;

    @Column(name = "company", nullable = false)
    private long company;

    @Column(name = "work_from", nullable = false)
    private int workFrom;

    public WorksAtPK() {}

    public WorksAtPK(long person, long company, int workFrom) {
        this.person = person;
        this.company = company;
        this.workFrom = workFrom;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        WorksAtPK other = (WorksAtPK) obj;
        return  (person == other.person) &&
                (company == other.company) &&
                (workFrom == other.workFrom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, company, workFrom);
    }

    public long getPerson() {
        return person;
    }
    public void setPerson(long person) {
        this.person = person;
    }

    public long getCompany() {
        return company;
    }
    public void setCompany(long company) {
        this.company = company;
    }

    public int getWorkFrom() {
        return workFrom;
    }
    public void setWorkFrom(int workFrom) {
        this.workFrom = workFrom;
    }
}
