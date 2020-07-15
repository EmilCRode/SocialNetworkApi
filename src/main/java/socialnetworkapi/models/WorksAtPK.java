package socialnetworkapi.models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class WorksAtPK implements Serializable {
    @Column(name = "person", nullable = false)
    private long person;

    @Column(name = "company", nullable = false)
    private long company;

    @Column(name = "work_from", nullable = false)
    private int workFrom;

    /* --- */

    public WorksAtPK() {}

    public WorksAtPK(long person, long company, int workFrom) {
        this.person = person;
        this.company = company;
        this.workFrom = workFrom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorksAtPK worksAtPK = (WorksAtPK) o;
        return person == worksAtPK.person &&
                company == worksAtPK.company &&
                workFrom == worksAtPK.workFrom;
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
