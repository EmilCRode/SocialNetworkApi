package socialnetworkapi.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "pkp_symmetric")
public class PkpSymmetric {
    @EmbeddedId
    private PkpSymmetricPK id;

    public PkpSymmetric() {}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PkpSymmetric other = (PkpSymmetric) obj;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash();
    }

    public PkpSymmetricPK getKey(){ return this.id; }
}
