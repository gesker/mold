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
@Table(name = "login_usr_unknown_log"
        , uniqueConstraints = @UniqueConstraint(columnNames = "uid")
)
public class LoginUsrUnknownLog implements java.io.Serializable {


    static final long serialVersionUID = 1L;
    private Integer id;
    private LoginCode loginCode;
    private Usr usrByUsrCreated;
    private Usr usrByUsrModified;
    private UUID uid;
    private String usr;
    private String pswd;
    private String ipAddress;
    private Boolean enabled;
    private Date created;
    private Date modified;

    public LoginUsrUnknownLog() {
    }


    public LoginUsrUnknownLog(Integer id, Usr usrByUsrCreated, Usr usrByUsrModified, UUID uid) {
        this.id = id;
        this.usrByUsrCreated = usrByUsrCreated;
        this.usrByUsrModified = usrByUsrModified;
        this.uid = uid;
    }

    public LoginUsrUnknownLog(Integer id, LoginCode loginCode, Usr usrByUsrCreated, Usr usrByUsrModified, UUID uid, String usr, String pswd, String ipAddress, Boolean enabled, Date created, Date modified) {
        this.id = id;
        this.loginCode = loginCode;
        this.usrByUsrCreated = usrByUsrCreated;
        this.usrByUsrModified = usrByUsrModified;
        this.uid = uid;
        this.usr = usr;
        this.pswd = pswd;
        this.ipAddress = ipAddress;
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
    @JoinColumn(name = "login_code_id")
    public LoginCode getLoginCode() {
        return this.loginCode;
    }

    public void setLoginCode(LoginCode loginCode) {
        this.loginCode = loginCode;
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


    @Column(name = "usr", length = 254)
    public String getUsr() {
        return this.usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }


    @Column(name = "pswd", length = 254)
    public String getPswd() {
        return this.pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }


    @Column(name = "ip_address", length = 45)
    public String getIpAddress() {
        return this.ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
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


