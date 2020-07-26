package socialnetworkapi.models;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pid", nullable = false)
    private long pid;

    @Basic
    @Column(name = "first_name", nullable = false, length = -1)
    private String firstName;

    @Basic
    @Column(name = "last_name", nullable = false, length = -1)
    private String lastName;

    @Basic
    @Column(name = "gender", nullable = true, length = -1)
    private String gender;

    @Basic
    @Column(name = "birthday", nullable = false)
    private Date birthday;

    @Basic
    @Column(name = "creation_date", nullable = false)
    private Timestamp creationDate;

    @Basic
    @Column(name = "location_ip", nullable = true, length = -1)
    private String locationIp;

    @Basic
    @Column(name = "browser", nullable = true, length = -1)
    private String browser;

    @ManyToOne
    @JoinColumn(name = "city", referencedColumnName = "cityid", nullable = false)
    private City city;

    @OneToMany(mappedBy = "person")
    private Collection<EmailAddresses> emailAddresses;

    @OneToMany(mappedBy = "moderator")
    private Collection<Forum> moderatedForums;

    @ManyToMany
    @JoinTable(name = "has_interest", joinColumns = @JoinColumn(name = "person"), inverseJoinColumns = @JoinColumn(name = "tag"))
    private Collection<Tag> interests;

    @OneToMany(mappedBy = "person")
    private Collection<HasMember> forumMemberships;

    @OneToMany(mappedBy = "person1")
    private Collection<Knows> knows;

    @OneToMany(mappedBy = "person2")
    private Collection<Knows> isKnown;

    @OneToMany(mappedBy = "person")
    private Collection<LikesPost> likesPosts;

    @OneToMany(mappedBy = "person")
    private Collection<LikesRemark> likesRemarks;

    @OneToMany(mappedBy = "creator")
    private Collection<Post> posts;

    @OneToMany(mappedBy = "creator")
    private Collection<Remark> remarks;

    @OneToMany(mappedBy = "person")
    private Collection<Speaks> speaks;

    @OneToMany(mappedBy = "person")
    private Collection<StudiesAt> studiesAts;

    @OneToMany(mappedBy = "person")
    private Collection<WorksAt> worksAts;

    @OneToMany(mappedBy = "person")
    private Collection<WorksAtTermination> worksAtTerminations;

    public Person() {}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person other = (Person) obj;
        return pid == other.pid &&
                Objects.equals(this.city, other.city) &&
                Objects.equals(this.firstName, other.firstName) &&
                Objects.equals(this.lastName, other.lastName) &&
                Objects.equals(this.gender, other.gender) &&
                Objects.equals(this.birthday, other.birthday) &&
                Objects.equals(this.creationDate, other.creationDate) &&
                Objects.equals(this.locationIp, other.locationIp) &&
                Objects.equals(this.browser, other.browser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pid, firstName, lastName, gender, birthday, creationDate, locationIp, browser, city);
    }

    @Override
    public String toString(){
        return      "pid: " + pid
                +   "\nfirst name: " + firstName
                +   "\nlast name: " + lastName
                +   "\ngender: " + gender
                +   "\nbirthday: " + birthday
                +   "\ncreation date: " + creationDate
                +   "\nlocation ip: " + locationIp
                +   "\nbrowser: " + browser
                +   "\ncity: " + city.getName();
    }

    public long getPid() {
        return pid;
    }
    public void setPid(long pid) {
        this.pid = pid;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public String getLocationIp() {
        return locationIp;
    }
    public void setLocationIp(String locationIp) {
        this.locationIp = locationIp;
    }

    public String getBrowser() {
        return browser;
    }
    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public City getCity() {
        return city;
    }
    public void setCity(City city) {
        this.city = city;
    }

    public Collection<EmailAddresses> getEmailAddresses() {
        return emailAddresses;
    }
    public void setEmailAddresses(Collection<EmailAddresses> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }

    public Collection<Forum> getModeratedForums() {
        return moderatedForums;
    }
    public void setModeratedForums(Collection<Forum> moderatedForums) {
        this.moderatedForums = moderatedForums;
    }

    public Collection<Tag> getHasInterests() {
        return interests;
    }
    public void setInterests (Collection<Tag> interests) {
        this.interests = interests;
    }

    public Collection<HasMember> getForumMemberships() {
        return forumMemberships;
    }
    public void setForumMemberships(Collection<HasMember> forumMemberships) {
        this.forumMemberships = forumMemberships;
    }

    public Collection<Knows> getKnows() {
        return knows;
    }
    public void setKnows(Collection<Knows> knows) {
        this.knows = knows;
    }

    public Collection<Knows> getIsKnown() {
        return isKnown;
    }
    public void setIsKnown(Collection<Knows> isKnown) {
        this.isKnown = isKnown;
    }

    public Collection<LikesPost> getLikesPosts() {
        return likesPosts;
    }
    public void setLikesPosts(Collection<LikesPost> likesPosts) {
        this.likesPosts = likesPosts;
    }

    public Collection<LikesRemark> getLikesRemarks() {
        return likesRemarks;
    }
    public void setLikesRemarks(Collection<LikesRemark> likesRemarks) {
        this.likesRemarks = likesRemarks;
    }

    public Collection<Post> getPosts() {
        return posts;
    }
    public void setPosts(Collection<Post> posts) {
        this.posts = posts;
    }

    public Collection<Remark> getRemarks() {
        return remarks;
    }
    public void setRemarks(Collection<Remark> remarks) {
        this.remarks = remarks;
    }

    public Collection<Speaks> getSpeaks() {
        return speaks;
    }

    public void setSpeaks(Collection<Speaks> speaks) {
        this.speaks = speaks;
    }

    public Collection<StudiesAt> getStudiesAts() {
        return studiesAts;
    }
    public void setStudiesAts(Collection<StudiesAt> studiesAts) {
        this.studiesAts = studiesAts;
    }

    public Collection<WorksAt> getWorksAts() {
        return worksAts;
    }
    public void setWorksAts(Collection<WorksAt> worksAts) {
        this.worksAts = worksAts;
    }

    public Collection<WorksAtTermination> getWorksAtTerminations() {
        return worksAtTerminations;
    }
    public void setWorksAtTerminations(Collection<WorksAtTermination> worksAtTerminations) {
        this.worksAtTerminations = worksAtTerminations;
    }
}
