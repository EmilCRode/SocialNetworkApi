package socialnetworkapi.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "email_addresses")
public class EmailAddresses {
    @Id
    @Column(name = "email", nullable = false, length = -1)
    private String email;

    @ManyToOne
    @JoinColumn(name = "person", referencedColumnName = "pid", nullable = false)
    private Person person;

    /* --- */

    public EmailAddresses() {}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        EmailAddresses other = (EmailAddresses) obj;
        return Objects.equals(this.person, other.person) &&
                Objects.equals(this.email, other.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, email);
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
}
