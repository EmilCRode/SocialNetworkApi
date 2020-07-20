package socialnetworkapi.models;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class LikesRemarkPK implements Serializable {
    @Column(name = "person", nullable = false)
    private long person;

    @Column(name = "remark", nullable = false)
    private long remark;

    public LikesRemarkPK() {}

    public LikesRemarkPK(long person, long remark) {
        this.person = person;
        this.remark = remark;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        LikesRemarkPK other = (LikesRemarkPK) obj;
        return person == other.person &&
                remark == other.remark;
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, remark);
    }

    public long getPerson() {
        return person;
    }
    public void setPerson(long person) {
        this.person = person;
    }

    public long getRemark() {
        return remark;
    }
    public void setRemark(long remark) {
        this.remark = remark;
    }
}
