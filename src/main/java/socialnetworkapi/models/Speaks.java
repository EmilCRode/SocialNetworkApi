package socialnetworkapi.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "speaks")
public class Speaks {
    @EmbeddedId
    private SpeaksPK id;

    @MapsId("lang")
    @Column(name = "lang", nullable = false, length = -1)
    private String lang;

    /*  Questionable */
    @ManyToOne
    @MapsId("person")
    @JoinColumn(name = "person", referencedColumnName = "pid", nullable = false)
    private Person personByPerson;

    public Speaks() {}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Speaks other = (Speaks) obj;
        return  Objects.equals(this.lang, other.lang) &&
                Objects.equals(this.personByPerson, other.personByPerson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lang);
    }

    public SpeaksPK getId() {
        return id;
    }
    public void setId(SpeaksPK id) {
        this.id = id;
    }

    public String getLang() {
        return lang;
    }
    public void setLang(String lang) {
        this.lang = lang;
    }

    public Person getPersonByPerson() {
        return personByPerson;
    }
    public void setPersonByPerson(Person personByPerson) {
        this.personByPerson = personByPerson;
    }
}
