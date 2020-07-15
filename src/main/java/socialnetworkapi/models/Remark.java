package socialnetworkapi.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "remark")
public class Remark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rid", nullable = false)
    private long rid;

    @Basic
    @Column(name = "creation_date", nullable = false)
    private Timestamp creationDate;

    @Basic
    @Column(name = "location_ip", nullable = true, length = -1)
    private String locationIp;

    @Basic
    @Column(name = "browser_used", nullable = true, length = -1)
    private String browserUsed;

    @Basic
    @Column(name = "content", nullable = false, length = -1)
    private String content;

    @Basic
    @Column(name = "length", nullable = false)
    private int length;

    @ManyToOne
    @JoinColumn(name = "creator", referencedColumnName = "pid", nullable = false)
    private Person creator;

    @ManyToOne
    @JoinColumn(name = "country", referencedColumnName = "counid", nullable = false)
    private Country country;

    @ManyToOne
    @JoinColumn(name = "reply_of_post", referencedColumnName = "postid")
    private Post replyOfPost;

    @ManyToOne
    @JoinColumn(name = "reply_of_remark", referencedColumnName = "rid")
    private Remark replyOfRemark;

    @OneToMany(mappedBy = "replyOfRemark")
    private Collection<Remark> remarks;

    @OneToMany(mappedBy = "remark")
    private Collection<LikesRemark> likesRemarks;

    @ManyToMany
    @JoinTable(name = "remark_has_tag", joinColumns = @JoinColumn(name = "remark"), inverseJoinColumns = @JoinColumn(name = "tag"))
    private Collection<Tag> tags;

    /* --- */

    public Remark() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Remark remark = (Remark) o;
        return rid == remark.rid &&
                length == remark.length &&
                creator == remark.creator &&
                country == remark.country &&
                Objects.equals(creationDate, remark.creationDate) &&
                Objects.equals(locationIp, remark.locationIp) &&
                Objects.equals(browserUsed, remark.browserUsed) &&
                Objects.equals(content, remark.content) &&
                Objects.equals(replyOfPost, remark.replyOfPost) &&
                Objects.equals(replyOfRemark, remark.replyOfRemark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rid, creationDate, locationIp, browserUsed, content, length, creator, country, replyOfPost, replyOfRemark);
    }

    public long getRid() {
        return rid;
    }
    public void setRid(long rid) {
        this.rid = rid;
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

    public String getBrowserUsed() {
        return browserUsed;
    }
    public void setBrowserUsed(String browserUsed) {
        this.browserUsed = browserUsed;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }

    public Person getCreator() {
        return creator;
    }
    public void setCreator(Person creator) {
        this.creator = creator;
    }

    public Country getCountry() {
        return country;
    }
    public void setCountry(Country country) {
        this.country = country;
    }

    public Post getReplyOfPost() {
        return replyOfPost;
    }
    public void setReplyOfPost(Post replyOfPost) {
        this.replyOfPost = replyOfPost;
    }

    public Remark getReplyOfRemark() {
        return replyOfRemark;
    }
    public void setReplyOfRemark(Remark replyOfRemark) {
        this.replyOfRemark = replyOfRemark;
    }

    public Collection<Remark> getRemarks() {
        return remarks;
    }
    public void setRemarks(Collection<Remark> remarks) {
        this.remarks = remarks;
    }

    public Collection<LikesRemark> getLikesRemarks() {
        return likesRemarks;
    }
    public void setLikesRemarks(Collection<LikesRemark> likesRemarks) {
        this.likesRemarks = likesRemarks;
    }

    public Collection<Tag> getTags() {
        return tags;
    }
    public void setTags(Collection<Tag> tags) {
        this.tags = tags;
    }
}
