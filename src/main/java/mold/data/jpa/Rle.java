package mold.data.jpa;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;

import javax.enterprise.inject.Vetoed;
import javax.persistence.*;
import java.util.*;

/**
 *
 */
@Vetoed
@Audited
@Entity
@Table(name = "rle"
        , uniqueConstraints = {@UniqueConstraint(columnNames = "description"), @UniqueConstraint(columnNames = "nme"), @UniqueConstraint(columnNames = "uid")}
)
public class Rle implements java.io.Serializable {


    static final long serialVersionUID = 1L;
    private Integer id;
    private Usr usrByUsrModified;
    private Usr usrByUsrCreated;
    private UUID uid;
    private String nme;
    private String description;
    private Boolean enabled;
    private Date created;
    private Date modified;
    private List<UsrRleMap> usrRleMaps = Collections.synchronizedList(new ArrayList<UsrRleMap>(0));

    public Rle() {
    }


    public Rle(Integer id, Usr usrByUsrModified, Usr usrByUsrCreated, UUID uid, String nme, String description) {
        this.id = id;
        this.usrByUsrModified = usrByUsrModified;
        this.usrByUsrCreated = usrByUsrCreated;
        this.uid = uid;
        this.nme = nme;
        this.description = description;
    }

    public Rle(Integer id, Usr usrByUsrModified, Usr usrByUsrCreated, UUID uid, String nme, String description, Boolean enabled, Date created, Date modified, List<UsrRleMap> usrRleMaps) {
        this.id = id;
        this.usrByUsrModified = usrByUsrModified;
        this.usrByUsrCreated = usrByUsrCreated;
        this.uid = uid;
        this.nme = nme;
        this.description = description;
        this.enabled = enabled;
        this.created = created;
        this.modified = modified;
        this.usrRleMaps = usrRleMaps;
    }

    @Id


    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usr_modified", nullable = false)
    public Usr getUsrByUsrModified() {
        return this.usrByUsrModified;
    }

    public void setUsrByUsrModified(Usr usrByUsrModified) {
        this.usrByUsrModified = usrByUsrModified;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usr_created", nullable = false)
    public Usr getUsrByUsrCreated() {
        return this.usrByUsrCreated;
    }

    public void setUsrByUsrCreated(Usr usrByUsrCreated) {
        this.usrByUsrCreated = usrByUsrCreated;
    }


    @Column(name = "uid", columnDefinition = "UUID", unique = true, nullable = false, updatable = true)
    public UUID getUid() {
        return this.uid;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
    }


    @Column(name = "nme", unique = true, nullable = false, length = 10)
    public String getNme() {
        return this.nme;
    }

    public void setNme(String nme) {
        this.nme = nme;
    }


    @Column(name = "description", unique = true, nullable = false, length = 30)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Column(name = "enabled")
    public Boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", length = 35)
    @CreationTimestamp
    public Date getCreated() {
        return this.created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified", length = 35)
    @UpdateTimestamp
    public Date getModified() {
        return this.modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "rle")
    public List<UsrRleMap> getUsrRleMaps() {
        return this.usrRleMaps;
    }

    public void setUsrRleMaps(List<UsrRleMap> usrRleMaps) {
        this.usrRleMaps = usrRleMaps;
    }


}


