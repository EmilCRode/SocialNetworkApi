package socialnetworkapi.models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class SpeaksPK implements Serializable {
    @Column(name = "person", nullable = false)
    private long person;

    @Column(name = "lang", nullable = false, length = -1)
    private String lang;

    /* --- */

    public SpeaksPK() {}

    public SpeaksPK(long person, String lang) {
        this.person = person;
        this.lang = lang;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpeaksPK speaksPK = (SpeaksPK) o;
        return person == speaksPK.person &&
                Objects.equals(lang, speaksPK.lang);
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
