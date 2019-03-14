package mold.data.jpa;
import mold.data.obj.*;
import java.util.UUID;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;
import org.hibernate.annotations.SQLDelete;

import java.util.*;
import javax.persistence.*;
import javax.enterprise.inject.Vetoed;




import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**

 */
@Vetoed
@Audited
@NamedQueries(value = {
	@NamedQuery(name = "LoginCode.findAll", query = "SELECT o FROM LoginCode o ORDER BY o.id"),
	@NamedQuery(name = "LoginCode.findById", query = "SELECT o FROM LoginCode o WHERE o.id = :id"),
	@NamedQuery(name = "Usr.findAll", query = "SELECT o FROM Usr o ORDER BY o.nme"),
	@NamedQuery(name = "Usr.findByNme", query = "SELECT o FROM Usr o WHERE o.nme = :nme"),
	@NamedQuery(name = "Usr.findById", query = "SELECT o FROM Usr o WHERE o.id = :id"),
	@NamedQuery(name = "Usr.findByEnabled", query = "SELECT o FROM Usr o WHERE o.enabled = :enabled ORDER BY o.nme"),
	@NamedQuery(name = "Aaaaaa.findAll", query = "SELECT o FROM Aaaaaa o ORDER BY o.id"),
	@NamedQuery(name = "Aaaaaa.findById", query = "SELECT o FROM Aaaaaa o WHERE o.id = :id"),
	@NamedQuery(name = "Rle.findAll", query = "SELECT o FROM Rle o ORDER BY o.nme"),
	@NamedQuery(name = "Rle.findById", query = "SELECT o FROM Rle o WHERE o.id = :id"),
	@NamedQuery(name = "Rle.findByRle", query = "SELECT o FROM Rle o WHERE o.nme = :nme"),
	@NamedQuery(name = "Rle.findByEnabled", query = "SELECT o FROM Rle o WHERE o.enabled = :enabled ORDER BY o.nme"),
	@NamedQuery(name = "LoginUsrKnownLog.findAll", query = "SELECT o FROM LoginUsrKnownLog o ORDER BY o.id"),
	@NamedQuery(name = "LoginUsrKnownLog.findById", query = "SELECT o FROM LoginUsrKnownLog o WHERE o.id = :id"),
	@NamedQuery(name = "LoginUsrUnknownLog.findAll", query = "SELECT o FROM LoginUsrUnknownLog o ORDER BY o.id"),
	@NamedQuery(name = "LoginUsrUnknownLog.findById", query = "SELECT o FROM LoginUsrUnknownLog o WHERE o.id = :id"),
	@NamedQuery(name = "UsrRleMap.unmapUsrFromRle", query = "DELETE FROM UsrRleMap c WHERE c.usrByUsrId = :usr AND c.rle IN (:roleList)"),
	@NamedQuery(name = "UsrRleMap.usrUnmappedForRle", query = "SELECT c FROM Rle c WHERE c NOT IN (SELECT b.rle FROM UsrRleMap b WHERE b.usrByUsrId = :usr)")
})
@Entity
@Table(name="aaaaaa"
    , uniqueConstraints = {@UniqueConstraint(columnNames="uid"), @UniqueConstraint(columnNames="val")}
)
public class Aaaaaa  implements java.io.Serializable {


     static final long serialVersionUID = 1L;
	 private Integer id;
     private Usr usrByUsrCreated;
     private Usr usrByUsrModified;
     private UUID uid;
     private Integer val;
     private Boolean enabled;
     private Date created;
     private Date modified;

    public Aaaaaa() {
    }

	
    public Aaaaaa(Integer id, Usr usrByUsrCreated, Usr usrByUsrModified, UUID uid, Integer val) {
        this.id = id;
        this.usrByUsrCreated = usrByUsrCreated;
        this.usrByUsrModified = usrByUsrModified;
        this.uid = uid;
        this.val = val;
    }
    public Aaaaaa(Integer id, Usr usrByUsrCreated, Usr usrByUsrModified, UUID uid, Integer val, Boolean enabled, Date created, Date modified) {
       this.id = id;
       this.usrByUsrCreated = usrByUsrCreated;
       this.usrByUsrModified = usrByUsrModified;
       this.uid = uid;
       this.val = val;
       this.enabled = enabled;
       this.created = created;
       this.modified = modified;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="usr_created", nullable=false)
    public Usr getUsrByUsrCreated() {
        return this.usrByUsrCreated;
    }
    
    public void setUsrByUsrCreated(Usr usrByUsrCreated) {
        this.usrByUsrCreated = usrByUsrCreated;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="usr_modified", nullable=false)
    public Usr getUsrByUsrModified() {
        return this.usrByUsrModified;
    }
    
    public void setUsrByUsrModified(Usr usrByUsrModified) {
        this.usrByUsrModified = usrByUsrModified;
    }

    
    @Column(name="uid", columnDefinition = "UUID", unique=true, nullable=false, updatable=true)
    public UUID getUid() {
        return this.uid;
    }
    
    public void setUid(UUID uid) {
        this.uid = uid;
    }

    
    @Column(name="val", unique=true, nullable=false)
    public Integer getVal() {
        return this.val;
    }
    
    public void setVal(Integer val) {
        this.val = val;
    }

    
    @Column(name="enabled")
    public Boolean getEnabled() {
        return this.enabled;
    }
    
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created", length=35) @CreationTimestamp
    public Date getCreated() {
        return this.created;
    }
    
    public void setCreated(Date created) {
        this.created = created;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="modified", length=35) @UpdateTimestamp
    public Date getModified() {
        return this.modified;
    }
    
    public void setModified(Date modified) {
        this.modified = modified;
    }




}


