package mold.ejb;

import mold.constant.LoginCodes;
import mold.constant.WildFlyContainerConstant;
import mold.data.jpa.LoginCode;
import mold.data.jpa.LoginUsrKnownLog;
import mold.data.jpa.LoginUsrUnknownLog;
import mold.data.jpa.Usr;
import mold.security.HashPBKDF2WithHmacSHA512;

import javax.ejb.Asynchronous;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Singleton
public class AuthEJB {
    @PersistenceContext(unitName = WildFlyContainerConstant.JAVAEE_PERSISTANCE_UNIT)
    protected EntityManager em;
    Logger logger = Logger.getLogger(this.getClass().getSimpleName());


    public AuthEJB() {
    }

    @Asynchronous
    private void writeLoginUsrKnownLog(
            Usr usr, String password, LoginCode loginCode, String ipAddress) {
        //Make Entry in Login Log
        Date loginAttempt = new java.util.Date(); // Get a timestamp
        LoginUsrKnownLog loginUsrKnownLog = new LoginUsrKnownLog();
        loginUsrKnownLog.setUsrByUsrId(usr);
        loginUsrKnownLog.setBadPassword(password);
        loginUsrKnownLog.setLoginCode(loginCode);
        loginUsrKnownLog.setIpAddress(ipAddress);
        loginUsrKnownLog.setEnabled(true);
        loginUsrKnownLog.setCreated(loginAttempt);
        loginUsrKnownLog.setModified(loginAttempt);
        loginUsrKnownLog.setUid(UUID.randomUUID());
        loginUsrKnownLog.setUsrByUsrCreated(em.find(Usr.class, 1));
        loginUsrKnownLog.setUsrByUsrModified(em.find(Usr.class, 1));
        em.persist(loginUsrKnownLog);
    }

    private void writeLoginUsrUnknownLog(
            String username, String password, LoginCode loginCode, String ipAddress) {
        //Make Entry in Unknown User Log
        Date loginAttempt = new java.util.Date(); // Get a timestamp
        LoginUsrUnknownLog loginUsrUnknownLog = new LoginUsrUnknownLog();
        loginUsrUnknownLog.setUsr(username);
        loginUsrUnknownLog.setPswd(password);
        loginUsrUnknownLog.setLoginCode(loginCode);
        loginUsrUnknownLog.setIpAddress(ipAddress);
        loginUsrUnknownLog.setEnabled(true);
        loginUsrUnknownLog.setCreated(loginAttempt);
        loginUsrUnknownLog.setModified(loginAttempt);
        em.persist(loginUsrUnknownLog);
    }

    @Asynchronous
    public void logLogin(String username, String ipAddress) {
        // Get the User
        Usr usr = retrieveUsr(username);
        // Get the Login Code Object
        LoginCode loginCode = retrieveLoginCode(LoginCodes.LOGIN_CODE_SUCCESS);
        // Write Login Attempt
        writeLoginUsrKnownLog(usr, "", loginCode, ipAddress);
    }

    @Asynchronous
    public void logLogout(String username, String ipAddress) {
        // Get the User
        Usr usr = retrieveUsr(username);
        // Get the Login Code Object
        LoginCode loginCode = retrieveLoginCode(LoginCodes.LOGIN_CODE_LOGOUT);
        // Write Logout Attempt
        writeLoginUsrKnownLog(usr, "", loginCode, ipAddress);
    }

    @Asynchronous
    public void logTimeout(String username, String ipAddress) {
        // Get the User
        Usr usr = retrieveUsr(username);
        // Get the Login Code Object
        LoginCode loginCode = retrieveLoginCode(LoginCodes.LOGIN_CODE_TIMEOUT);
        // Write Timeout Attempt
        writeLoginUsrKnownLog(usr, "", loginCode, ipAddress);
    }

    @Asynchronous
    public void logLoginFail(String username, String password, String ipAddress) {
        LoginCode loginCode;
        // Bad username attempts
        if (!isUserInSystem(username)) {
            loginCode = retrieveLoginCode(LoginCodes.LOGIN_CODE_FAIL_USERNAME);
            writeLoginUsrUnknownLog(username, password, loginCode, ipAddress);
        }
        // Get the User
        Usr usr = retrieveUsr(username);
        loginCode = retrieveLoginCode(LoginCodes.LOGIN_CODE_FAIL_PASSWORD);
        writeLoginUsrKnownLog(usr, password, loginCode, ipAddress);
    }

    @Asynchronous
    public void logLoginFailAccountDisabled(String username, String ipAddress) {
        // Get the User
        Usr usr = retrieveUsr(username);
        LoginCode loginCode = retrieveLoginCode(LoginCodes.LOGIN_CODE_FAIL_ACCOUNT_DISABLED);
        writeLoginUsrKnownLog(usr, "NA", loginCode, ipAddress);
    }

    public Boolean isUserInSystem(String username) {
        // Get the User if possible
        Usr usr = retrieveUsr(username);
        if (usr == null) {
            return false;
        }
        return true;
    }

    public Boolean isLoginEnabled(String username) {
        // Get the User if possible
        Usr usr = retrieveUsr(username);
        if (usr == null) {
            return false;
        } // If the Usr doesn't exist they are not enabled
        return usr.getEnabled();
    }


    public void createUsr(Usr usr) {
        //usr.setUsr(usrCreator);
        usr.setNme(usr.getNme().toLowerCase().trim());
        usr.setEnabled(true);
        usr.setCreated(new Date());
        usr.setModified(usr.getCreated());

        if (usr.getPswd() != null) {
            HashPBKDF2WithHmacSHA512 hashPassword = new HashPBKDF2WithHmacSHA512();
            usr.setPswd(hashPassword.getHashedText(usr.getPswd()));
        } else {
            // Just to be sure put garbage/random in password for User
            HashPBKDF2WithHmacSHA512 hashPassword = new HashPBKDF2WithHmacSHA512();
            usr.setPswd(hashPassword.getHashedText(UUID.randomUUID().toString()));
        }
        em.persist(usr);
        em.flush();
    }

    public Usr retrieveUsr(String username) {
        // Get the User
        Query qryUser = em.createNamedQuery("Usr.findByEmail");
        qryUser.setParameter("email", username.trim().toLowerCase());
        Usr usr = null;
        try {
            usr = (Usr) qryUser.getSingleResult();
        } catch (Exception e) {
            return usr;
        }
        return usr;
    }

    public Usr retrieveUsr(Integer id) {
        Query qry = em.createNamedQuery("Usr.findById");
        qry.setParameter("id", id);
        Usr usr;
        try {
            usr = (Usr) qry.getSingleResult();
        } catch (Exception e) {
            return null;
        }
        return usr;
    }

    public List<Usr> retrieveUsrs() {
        TypedQuery<Usr> qry;
        qry = em.createNamedQuery("Usr.findAll", Usr.class);
        List<Usr> usrList = qry.getResultList();
        logger.info("usrList size: " + usrList.size());
        return usrList;
    }

    public void updateUsr(Usr usr, Usr applicationUsr) {
        usr.setNme(usr.getNme().toLowerCase().trim());
        usr.setCreated(new Date());
        usr.setModified(usr.getCreated());
        usr.setUsrByUsrModified(applicationUsr); // The Usr that modified this Usr record

        em.merge(usr);
    }

    public Boolean isUsrAccountingCodeInSystem(String accountingCode) {
        // Lifecycle might submit nothing so deal with it.
        if (accountingCode == null || accountingCode.isEmpty()) {
            return false;
        }
        // Get the User if possible
        Usr usr = retrieveUsrByAccountingCode(accountingCode);
        if (usr == null) {
            return false;
        }
        return true;
    }

    public Usr retrieveUsrByAccountingCode(String accountingCode) {
        Usr usr = null;
        if (accountingCode == null || accountingCode.isEmpty()) {
            return usr;
        }
        // Get the User if possible
        Query qryUser = em.createNamedQuery("Usr.findByAccountingCode");
        qryUser.setParameter("accountingCode", accountingCode);
        try {
            usr = (Usr) qryUser.getSingleResult();
            return usr;
        } catch (Exception e) {
            return usr;
        }
    }

    public LoginCode retrieveLoginCode(int loginCodeInt) {
        Query qryLoginCode = em.createNamedQuery("LoginCode.findById");
        qryLoginCode.setParameter("id", loginCodeInt);
        LoginCode loginCode = (LoginCode) qryLoginCode.getSingleResult();
        return loginCode;
    }
}
