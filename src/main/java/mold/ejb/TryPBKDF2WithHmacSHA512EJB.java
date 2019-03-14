package mold.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Startup;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Singleton
@Startup

public class TryPBKDF2WithHmacSHA512EJB {

    private Logger logger = Logger.getLogger(this.getClass().getSimpleName());



    @Inject
    private Pbkdf2PasswordHash passwordHash;





    @PostConstruct
    public void init() {


        Map<String, String> parametersMap = new HashMap<>();
        parametersMap.put("Pbkdf2PasswordHash.Algorithm", "PBKDF2WithHmacSHA512");
        parametersMap.put("Pbkdf2PasswordHash.Iterations", "4096");
        parametersMap.put("Pbkdf2PasswordHash.KeySizeBytes", "64");
        parametersMap.put("Pbkdf2PasswordHash.SaltSizeBytes", "64");
        passwordHash.initialize(parametersMap);

        logger.warning(passwordHash.generate("password".toCharArray()));

    }

}
