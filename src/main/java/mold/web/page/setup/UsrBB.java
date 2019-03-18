package mold.web.page.setup;

import mold.constant.WildFlyContainerConstant;
import mold.data.jpa.Usr;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Named
@SessionScoped
public class UsrBB implements Serializable {

    Logger logger = Logger.getLogger(this.getClass().getSimpleName());
    @PersistenceContext(unitName = WildFlyContainerConstant.JAVAEE_PERSISTANCE_UNIT)
    protected EntityManager em;

    List<Usr> usrList;

    public List<Usr> getUsrList() {
        Query qryAllUsers = em.createNamedQuery("Usr.findAll");
        usrList = qryAllUsers.getResultList();
        String msg = "Size of usrList is: " + usrList.size();
        logger.warning(msg);
        return usrList;
    }

    public void setUsrList(List<Usr> usrList) {
        this.usrList = usrList;
    }
}
