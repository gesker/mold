package mold.web.page.setup;

import mold.data.jpa.Usr;
import mold.ejb.AuthEJB;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Named
@SessionScoped
public class UsrBB implements Serializable {

    @EJB
    AuthEJB authEJB;

    Logger logger = Logger.getLogger(this.getClass().getSimpleName());
    List<Usr> usrList;

    @SuppressWarnings("unchecked")
    public List<Usr> getUsrList() {
        usrList = authEJB.retrieveUsrs();
        String msg = "Size of usrList is: " + usrList.size();
        logger.warning(msg);
        return usrList;
    }

    public void setUsrList(List<Usr> usrList) {
        this.usrList = usrList;
    }
}
