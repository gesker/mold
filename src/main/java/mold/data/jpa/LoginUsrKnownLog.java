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
@Entity
@Table(name="login_usr_known_log"
    , uniqueConstraints = @UniqueConstraint(columnNames="uid")
)
public class LoginUsrKnownLog  implements java.io.Serializable {


     static final long serialVersionUID = 1L;
	 private Integer id;
     private LoginCode loginCode;
     private Usr usrByUsrId;
     private Usr usrByUsrModified;
     private Usr usrByUsrCreated;
     private UUID uid;
     private String badPassword;
     private String ipAddress;
     private Boolean enabled;
     private Date created;
     private Date modified;

    public LoginUsrKnownLog() {
    }

	
    public LoginUsrKnownLog(Integer id, Usr usrByUsrModified, Usr usrByUsrCreated, UUID uid) {
        this.id = id;
        this.usrByUsrModified = usrByUsrModified;
        this.usrByUsrCreated = usrByUsrCreated;
        this.uid = uid;
    }
    public LoginUsrKnownLog(Integer id, LoginCode loginCode, Usr usrByUsrId, Usr usrByUsrModified, Usr usrByUsrCreated, UUID uid, String badPassword, String ipAddress, Boolean enabled, Date created, Date modified) {
       this.id = id;
       this.loginCode = loginCode;
       this.usrByUsrId = usrByUsrId;
       this.usrByUsrModified = usrByUsrModified;
       this.usrByUsrCreated = usrByUsrCreated;
       this.uid = uid;
       this.badPassword = badPassword;
       this.ipAddress = ipAddress;
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
    @JoinColumn(name="login_code_id")
    public LoginCode getLoginCode() {
        return this.loginCode;
    }
    
    public void setLoginCode(LoginCode loginCode) {
        this.loginCode = loginCode;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="usr_id")
    public Usr getUsrByUsrId() {
        return this.usrByUsrId;
    }
    
    public void setUsrByUsrId(Usr usrByUsrId) {
        this.usrByUsrId = usrByUsrId;
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

    
    @Column(name="bad_password", length=254)
    public String getBadPassword() {
        return this.badPassword;
    }
    
    public void setBadPassword(String badPassword) {
        this.badPassword = badPassword;
    }

    
    @Column(name="ip_address", length=45)
    public String getIpAddress() {
        return this.ipAddress;
    }
    
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
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


