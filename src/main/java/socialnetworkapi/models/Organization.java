package socialnetworkapi.models;

import javax.persistence.*;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Organization {
    @Basic
    @Column(name = "name", nullable = false, length = -1)
    private String name;

    public Organization() { }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
