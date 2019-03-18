package mold.data.jpa;

import org.hibernate.annotations.Immutable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import javax.enterprise.inject.Vetoed;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 */
@Vetoed
@Immutable
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
@Entity
@Table(name = "usr_rle_map_view"
)
public class UsrRleMapView implements java.io.Serializable {


    static final long serialVersionUID = 1L;
    private Integer id;
    private String usrnme;
    private String usrpswd;
    private String rlenme;

    public UsrRleMapView() {
    }


    public UsrRleMapView(Integer id) {
        this.id = id;
    }

    public UsrRleMapView(Integer id, String usrnme, String usrpswd, String rlenme) {
        this.id = id;
        this.usrnme = usrnme;
        this.usrpswd = usrpswd;
        this.rlenme = rlenme;
    }

    @Id


    @Column(name = "id", nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Column(name = "usrnme", length = 254)
    public String getUsrnme() {
        return this.usrnme;
    }

    public void setUsrnme(String usrnme) {
        this.usrnme = usrnme;
    }


    @Column(name = "usrpswd", length = 254)
    public String getUsrpswd() {
        return this.usrpswd;
    }

    public void setUsrpswd(String usrpswd) {
        this.usrpswd = usrpswd;
    }


    @Column(name = "rlenme", length = 10)
    public String getRlenme() {
        return this.rlenme;
    }

    public void setRlenme(String rlenme) {
        this.rlenme = rlenme;
    }


}


