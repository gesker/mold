package mold.data.jpa;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;

import javax.enterprise.inject.Vetoed;
import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 *
 */
@Vetoed
@Audited
@Entity
@Table(name = "usr_rle_map"
        , uniqueConstraints = {@UniqueConstraint(columnNames = "uid"), @UniqueConstraint(columnNames = {"usr_id", "rle_id"})}
)
public class UsrRleMap implements java.io.Serializable {


    static final long serialVersionUID = 1L;
    private Integer id;
    private Rle rle;
    private Usr usrByUsrCreated;
    private Usr usrByUsrId;
    private Usr usrByUsrModified;
    private UUID uid;
    private Boolean enabled;
    private Date created;
    private Date modified;

    public UsrRleMap() {
    }


    public UsrRleMap(Integer id, Usr usrByUsrCreated, Usr usrByUsrModified, UUID uid) {
        this.id = id;
        this.usrByUsrCreated = usrByUsrCreated;
        this.usrByUsrModified = usrByUsrModified;
        this.uid = uid;
    }

    public UsrRleMap(Integer id, Rle rle, Usr usrByUsrCreated, Usr usrByUsrId, Usr usrByUsrModified, UUID uid, Boolean enabled, Date created, Date modified) {
        this.id = id;
        this.rle = rle;
        this.usrByUsrCreated = usrByUsrCreated;
        this.usrByUsrId = usrByUsrId;
        this.usrByUsrModified = usrByUsrModified;
        this.uid = uid;
        this.enabled = enabled;
        this.created = created;
        this.modified = modified;
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
    @JoinColumn(name = "rle_id")
    public Rle getRle() {
        return this.rle;
    }

    public void setRle(Rle rle) {
        this.rle = rle;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usr_created", nullable = false)
    public Usr getUsrByUsrCreated() {
        return this.usrByUsrCreated;
    }

    public void setUsrByUsrCreated(Usr usrByUsrCreated) {
        this.usrByUsrCreated = usrByUsrCreated;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usr_id")
    public Usr getUsrByUsrId() {
        return this.usrByUsrId;
    }

    public void setUsrByUsrId(Usr usrByUsrId) {
        this.usrByUsrId = usrByUsrId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usr_modified", nullable = false)
    public Usr getUsrByUsrModified() {
        return this.usrByUsrModified;
    }

    public void setUsrByUsrModified(Usr usrByUsrModified) {
        this.usrByUsrModified = usrByUsrModified;
    }


    @Column(name = "uid", columnDefinition = "UUID", unique = true, nullable = false, updatable = true)
    public UUID getUid() {
        return this.uid;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
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


}


