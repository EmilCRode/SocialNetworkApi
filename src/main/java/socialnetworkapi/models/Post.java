package socialnetworkapi.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postid", nullable = false)
    private long postid;

    @Basic
    @Column(name = "image_file", nullable = true, length = -1)
    private String imageFile;

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
    @Column(name = "language", nullable = true, length = -1)
    private String language;

    @Basic
    @Column(name = "content", nullable = true, length = -1)
    private String content;

    @Basic
    @Column(name = "length", nullable = false)
    private int length;

    @ManyToOne
    @JoinColumn(name = "creator", referencedColumnName = "pid", nullable = false)
    private Person creator;

    @ManyToOne
    @JoinColumn(name = "forum", referencedColumnName = "fid", nullable = false)
    private Forum forum;

    @ManyToOne
    @JoinColumn(name = "country", referencedColumnName = "counid", nullable = false)
    private Country country;

    @OneToMany(mappedBy = "post")
    private Collection<LikesPost> likesPosts;

    @ManyToMany
    @JoinTable(name = "post_has_tag", joinColumns = @JoinColumn(name = "post"), inverseJoinColumns = @JoinColumn(name = "tag"))
    private Collection<Tag> tags;

    @OneToMany(mappedBy = "replyOfPost")
    private Collection<Remark> remarks;

    /* --- */

    public Post() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return postid == post.postid &&
                length == post.length &&
                creator == post.creator &&
                forum == post.forum &&
                country == post.country &&
                Objects.equals(imageFile, post.imageFile) &&
                Objects.equals(creationDate, post.creationDate) &&
                Objects.equals(locationIp, post.locationIp) &&
                Objects.equals(browserUsed, post.browserUsed) &&
                Objects.equals(language, post.language) &&
                Objects.equals(content, post.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postid, imageFile, creationDate, locationIp, browserUsed, language, content, length, creator, forum, country);
    }

    public long getPostid() {
        return postid;
    }
    public void setPostid(long postid) {
        this.postid = postid;
    }

    public String getImageFile() {
        return imageFile;
    }
    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
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

    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
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

    public Forum getForum() {
        return forum;
    }
    public void setForum(Forum forum) {
        this.forum = forum;
    }

    public Country getCountry() {
        return country;
    }
    public void setCountry(Country country) {
        this.country = country;
    }

    public Collection<LikesPost> getLikesPosts() {
        return likesPosts;
    }
    public void setLikesPosts(Collection<LikesPost> likesPosts) {
        this.likesPosts = likesPosts;
    }

    public Collection<Tag> getTags() {
        return tags;
    }
    public void setTags(Collection<Tag> tags) {
        this.tags = tags;
    }

    public Collection<Remark> getRemarks() {
        return remarks;
    }
    public void setRemarks(Collection<Remark> remarks) {
        this.remarks = remarks;
    }
}
