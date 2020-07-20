package socialnetworkapi.models;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class SpeaksPK implements Serializable {
    @Column(name = "person", nullable = false)
    private long person;

    @Column(name = "lang", nullable = false, length = -1)
    private String lang;

    public SpeaksPK() {}

    public SpeaksPK(long person, String lang) {
        this.person = person;
        this.lang = lang;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SpeaksPK other = (SpeaksPK) obj;
        return (person == other.person) &&
                Objects.equals(lang, other.lang);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, lang);
    }

    public long getPerson() {
        return person;
    }
    public void setPerson(long person) {
        this.person = person;
    }

    public String getLang() {
        return lang;
    }
    public void setLang(String lang) {
        this.lang = lang;
    }
}
