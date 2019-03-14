package mold.data.jpa;
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
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**

 */
@Vetoed
@Audited
@Entity
@Table(name="usr"
    , uniqueConstraints = @UniqueConstraint(columnNames="uid")
)
public class Usr  implements java.io.Serializable {


     static final long serialVersionUID = 1L;
	 private Integer id;
     private Usr usrByUsrModified;
     private Usr usrByUsrCreated;
     private UUID uid;
     private String nme;
     private String pswd;
     private Boolean enabled;
     private Date created;
     private Date modified;
     private List<Aaaaaa> aaaaaasForUsrCreated = Collections.synchronizedList(new ArrayList<Aaaaaa>(0));
     private List<Rle> rlesForUsrModified = Collections.synchronizedList(new ArrayList<Rle>(0));
     private List<UsrRleMap> usrRleMapsForUsrCreated = Collections.synchronizedList(new ArrayList<UsrRleMap>(0));
     private List<LoginUsrKnownLog> loginUsrKnownLogsForUsrId = Collections.synchronizedList(new ArrayList<LoginUsrKnownLog>(0));
     private List<Rle> rlesForUsrCreated = Collections.synchronizedList(new ArrayList<Rle>(0));
     private List<UsrRleMap> usrRleMapsForUsrId = Collections.synchronizedList(new ArrayList<UsrRleMap>(0));
     private List<LoginUsrKnownLog> loginUsrKnownLogsForUsrModified = Collections.synchronizedList(new ArrayList<LoginUsrKnownLog>(0));
     private List<Usr> usrsForUsrModified = Collections.synchronizedList(new ArrayList<Usr>(0));
     private List<LoginUsrUnknownLog> loginUsrUnknownLogsForUsrCreated = Collections.synchronizedList(new ArrayList<LoginUsrUnknownLog>(0));
     private List<Aaaaaa> aaaaaasForUsrModified = Collections.synchronizedList(new ArrayList<Aaaaaa>(0));
     private List<Usr> usrsForUsrCreated = Collections.synchronizedList(new ArrayList<Usr>(0));
     private List<LoginUsrUnknownLog> loginUsrUnknownLogsForUsrModified = Collections.synchronizedList(new ArrayList<LoginUsrUnknownLog>(0));
     private List<UsrRleMap> usrRleMapsForUsrModified = Collections.synchronizedList(new ArrayList<UsrRleMap>(0));
     private List<LoginUsrKnownLog> loginUsrKnownLogsForUsrCreated = Collections.synchronizedList(new ArrayList<LoginUsrKnownLog>(0));

    public Usr() {
    }

	
    public Usr(Integer id, Usr usrByUsrModified, Usr usrByUsrCreated, UUID uid, String nme, String pswd) {
        this.id = id;
        this.usrByUsrModified = usrByUsrModified;
        this.usrByUsrCreated = usrByUsrCreated;
        this.uid = uid;
        this.nme = nme;
        this.pswd = pswd;
    }
    public Usr(Integer id, Usr usrByUsrModified, Usr usrByUsrCreated, UUID uid, String nme, String pswd, Boolean enabled, Date created, Date modified, List<Aaaaaa> aaaaaasForUsrCreated, List<Rle> rlesForUsrModified, List<UsrRleMap> usrRleMapsForUsrCreated, List<LoginUsrKnownLog> loginUsrKnownLogsForUsrId, List<Rle> rlesForUsrCreated, List<UsrRleMap> usrRleMapsForUsrId, List<LoginUsrKnownLog> loginUsrKnownLogsForUsrModified, List<Usr> usrsForUsrModified, List<LoginUsrUnknownLog> loginUsrUnknownLogsForUsrCreated, List<Aaaaaa> aaaaaasForUsrModified, List<Usr> usrsForUsrCreated, List<LoginUsrUnknownLog> loginUsrUnknownLogsForUsrModified, List<UsrRleMap> usrRleMapsForUsrModified, List<LoginUsrKnownLog> loginUsrKnownLogsForUsrCreated) {
       this.id = id;
       this.usrByUsrModified = usrByUsrModified;
       this.usrByUsrCreated = usrByUsrCreated;
       this.uid = uid;
       this.nme = nme;
       this.pswd = pswd;
       this.enabled = enabled;
       this.created = created;
       this.modified = modified;
       this.aaaaaasForUsrCreated = aaaaaasForUsrCreated;
       this.rlesForUsrModified = rlesForUsrModified;
       this.usrRleMapsForUsrCreated = usrRleMapsForUsrCreated;
       this.loginUsrKnownLogsForUsrId = loginUsrKnownLogsForUsrId;
       this.rlesForUsrCreated = rlesForUsrCreated;
       this.usrRleMapsForUsrId = usrRleMapsForUsrId;
       this.loginUsrKnownLogsForUsrModified = loginUsrKnownLogsForUsrModified;
       this.usrsForUsrModified = usrsForUsrModified;
       this.loginUsrUnknownLogsForUsrCreated = loginUsrUnknownLogsForUsrCreated;
       this.aaaaaasForUsrModified = aaaaaasForUsrModified;
       this.usrsForUsrCreated = usrsForUsrCreated;
       this.loginUsrUnknownLogsForUsrModified = loginUsrUnknownLogsForUsrModified;
       this.usrRleMapsForUsrModified = usrRleMapsForUsrModified;
       this.loginUsrKnownLogsForUsrCreated = loginUsrKnownLogsForUsrCreated;
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
    @JoinColumn(name="usr_modified", nullable=false)
    public Usr getUsrByUsrModified() {
        return this.usrByUsrModified;
    }
    
    public void setUsrByUsrModified(Usr usrByUsrModified) {
        this.usrByUsrModified = usrByUsrModified;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="usr_created", nullable=false)
    public Usr getUsrByUsrCreated() {
        return this.usrByUsrCreated;
    }
    
    public void setUsrByUsrCreated(Usr usrByUsrCreated) {
        this.usrByUsrCreated = usrByUsrCreated;
    }

    
    @Column(name="uid", columnDefinition = "UUID", unique=true, nullable=false, updatable=true)
    public UUID getUid() {
        return this.uid;
    }
    
    public void setUid(UUID uid) {
        this.uid = uid;
    }

    
    @Column(name="nme", nullable=false, length=254)
    public String getNme() {
        return this.nme;
    }
    
    public void setNme(String nme) {
        this.nme = nme;
    }

    
    @Column(name="pswd", nullable=false, length=254)
    public String getPswd() {
        return this.pswd;
    }
    
    public void setPswd(String pswd) {
        this.pswd = pswd;
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

@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="usrByUsrCreated")
    public List<Aaaaaa> getAaaaaasForUsrCreated() {
        return this.aaaaaasForUsrCreated;
    }
    
    public void setAaaaaasForUsrCreated(List<Aaaaaa> aaaaaasForUsrCreated) {
        this.aaaaaasForUsrCreated = aaaaaasForUsrCreated;
    }

@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="usrByUsrModified")
    public List<Rle> getRlesForUsrModified() {
        return this.rlesForUsrModified;
    }
    
    public void setRlesForUsrModified(List<Rle> rlesForUsrModified) {
        this.rlesForUsrModified = rlesForUsrModified;
    }

@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="usrByUsrCreated")
    public List<UsrRleMap> getUsrRleMapsForUsrCreated() {
        return this.usrRleMapsForUsrCreated;
    }
    
    public void setUsrRleMapsForUsrCreated(List<UsrRleMap> usrRleMapsForUsrCreated) {
        this.usrRleMapsForUsrCreated = usrRleMapsForUsrCreated;
    }

@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="usrByUsrId")
    public List<LoginUsrKnownLog> getLoginUsrKnownLogsForUsrId() {
        return this.loginUsrKnownLogsForUsrId;
    }
    
    public void setLoginUsrKnownLogsForUsrId(List<LoginUsrKnownLog> loginUsrKnownLogsForUsrId) {
        this.loginUsrKnownLogsForUsrId = loginUsrKnownLogsForUsrId;
    }

@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="usrByUsrCreated")
    public List<Rle> getRlesForUsrCreated() {
        return this.rlesForUsrCreated;
    }
    
    public void setRlesForUsrCreated(List<Rle> rlesForUsrCreated) {
        this.rlesForUsrCreated = rlesForUsrCreated;
    }

@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="usrByUsrId")
    public List<UsrRleMap> getUsrRleMapsForUsrId() {
        return this.usrRleMapsForUsrId;
    }
    
    public void setUsrRleMapsForUsrId(List<UsrRleMap> usrRleMapsForUsrId) {
        this.usrRleMapsForUsrId = usrRleMapsForUsrId;
    }

@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="usrByUsrModified")
    public List<LoginUsrKnownLog> getLoginUsrKnownLogsForUsrModified() {
        return this.loginUsrKnownLogsForUsrModified;
    }
    
    public void setLoginUsrKnownLogsForUsrModified(List<LoginUsrKnownLog> loginUsrKnownLogsForUsrModified) {
        this.loginUsrKnownLogsForUsrModified = loginUsrKnownLogsForUsrModified;
    }

@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="usrByUsrModified")
    public List<Usr> getUsrsForUsrModified() {
        return this.usrsForUsrModified;
    }
    
    public void setUsrsForUsrModified(List<Usr> usrsForUsrModified) {
        this.usrsForUsrModified = usrsForUsrModified;
    }

@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="usrByUsrCreated")
    public List<LoginUsrUnknownLog> getLoginUsrUnknownLogsForUsrCreated() {
        return this.loginUsrUnknownLogsForUsrCreated;
    }
    
    public void setLoginUsrUnknownLogsForUsrCreated(List<LoginUsrUnknownLog> loginUsrUnknownLogsForUsrCreated) {
        this.loginUsrUnknownLogsForUsrCreated = loginUsrUnknownLogsForUsrCreated;
    }

@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="usrByUsrModified")
    public List<Aaaaaa> getAaaaaasForUsrModified() {
        return this.aaaaaasForUsrModified;
    }
    
    public void setAaaaaasForUsrModified(List<Aaaaaa> aaaaaasForUsrModified) {
        this.aaaaaasForUsrModified = aaaaaasForUsrModified;
    }

@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="usrByUsrCreated")
    public List<Usr> getUsrsForUsrCreated() {
        return this.usrsForUsrCreated;
    }
    
    public void setUsrsForUsrCreated(List<Usr> usrsForUsrCreated) {
        this.usrsForUsrCreated = usrsForUsrCreated;
    }

@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="usrByUsrModified")
    public List<LoginUsrUnknownLog> getLoginUsrUnknownLogsForUsrModified() {
        return this.loginUsrUnknownLogsForUsrModified;
    }
    
    public void setLoginUsrUnknownLogsForUsrModified(List<LoginUsrUnknownLog> loginUsrUnknownLogsForUsrModified) {
        this.loginUsrUnknownLogsForUsrModified = loginUsrUnknownLogsForUsrModified;
    }

@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="usrByUsrModified")
    public List<UsrRleMap> getUsrRleMapsForUsrModified() {
        return this.usrRleMapsForUsrModified;
    }
    
    public void setUsrRleMapsForUsrModified(List<UsrRleMap> usrRleMapsForUsrModified) {
        this.usrRleMapsForUsrModified = usrRleMapsForUsrModified;
    }

@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="usrByUsrCreated")
    public List<LoginUsrKnownLog> getLoginUsrKnownLogsForUsrCreated() {
        return this.loginUsrKnownLogsForUsrCreated;
    }
    
    public void setLoginUsrKnownLogsForUsrCreated(List<LoginUsrKnownLog> loginUsrKnownLogsForUsrCreated) {
        this.loginUsrKnownLogsForUsrCreated = loginUsrKnownLogsForUsrCreated;
    }




}


