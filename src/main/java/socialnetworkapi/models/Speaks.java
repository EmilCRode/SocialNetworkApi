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

    @ManyToOne
    @MapsId("person")
    @JoinColumn(name = "person", referencedColumnName = "pid", nullable = false)
    private Person personByPerson;

    /* --- */

    public Speaks() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Speaks speaks = (Speaks) o;
        return Objects.equals(lang, speaks.lang);
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
