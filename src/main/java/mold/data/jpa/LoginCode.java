package mold.data.jpa;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import javax.enterprise.inject.Vetoed;
import javax.persistence.*;
import java.util.*;

/**
 *
 */
@Vetoed
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
@Entity
@Table(name = "login_code"
        , uniqueConstraints = {@UniqueConstraint(columnNames = "description"), @UniqueConstraint(columnNames = "nme"), @UniqueConstraint(columnNames = "uid")}
)
public class LoginCode implements java.io.Serializable {


    static final long serialVersionUID = 1L;
    private Integer id;
    private UUID uid;
    private String nme;
    private String description;
    private Boolean enabled;
    private Date created;
    private Date modified;
    private List<LoginUsrUnknownLog> loginUsrUnknownLogs = Collections.synchronizedList(new ArrayList<LoginUsrUnknownLog>(0));
    private List<LoginUsrKnownLog> loginUsrKnownLogs = Collections.synchronizedList(new ArrayList<LoginUsrKnownLog>(0));

    public LoginCode() {
    }


    public LoginCode(Integer id, UUID uid, String nme, String description) {
        this.id = id;
        this.uid = uid;
        this.nme = nme;
        this.description = description;
    }

    public LoginCode(Integer id, UUID uid, String nme, String description, Boolean enabled, Date created, Date modified, List<LoginUsrUnknownLog> loginUsrUnknownLogs, List<LoginUsrKnownLog> loginUsrKnownLogs) {
        this.id = id;
        this.uid = uid;
        this.nme = nme;
        this.description = description;
        this.enabled = enabled;
        this.created = created;
        this.modified = modified;
        this.loginUsrUnknownLogs = loginUsrUnknownLogs;
        this.loginUsrKnownLogs = loginUsrKnownLogs;
    }

    @Id


    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Column(name = "uid", columnDefinition = "UUID", unique = true, nullable = false, updatable = true)
    public UUID getUid() {
        return this.uid;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
    }


    @Column(name = "nme", unique = true, nullable = false, length = 20)
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "loginCode")
    public List<LoginUsrUnknownLog> getLoginUsrUnknownLogs() {
        return this.loginUsrUnknownLogs;
    }

    public void setLoginUsrUnknownLogs(List<LoginUsrUnknownLog> loginUsrUnknownLogs) {
        this.loginUsrUnknownLogs = loginUsrUnknownLogs;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "loginCode")
    public List<LoginUsrKnownLog> getLoginUsrKnownLogs() {
        return this.loginUsrKnownLogs;
    }

    public void setLoginUsrKnownLogs(List<LoginUsrKnownLog> loginUsrKnownLogs) {
        this.loginUsrKnownLogs = loginUsrKnownLogs;
    }


}


