package mold.web;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

import mold.security.HashPasswordSha512Base64;

@CustomFormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(
                loginPage = "/login.xhtml",
                useForwardToLogin = false
            )
)

@DatabaseIdentityStoreDefinition(
	    dataSourceLookup = "java:jboss/datasources/PgDsMold",
	    callerQuery = "SELECT usrpswd FROM usr_rle_map_view WHERE usrnme = ?",
	    groupsQuery = "SELECT rlenme FROM usr_rle_map_view WHERE usrnme = ?",
	    hashAlgorithm = Pbkdf2PasswordHash.class,
	    priorityExpression = "100",
	    hashAlgorithmParameters = {
	    		"Pbkdf2PasswordHash.Algorithm=PBKDF2WithHmacSHA512",
	    		"Pbkdf2PasswordHash.Iterations=4096",
	    		"Pbkdf2PasswordHash.SaltSizeBytes=64",
	    		"Pbkdf2PasswordHash.KeySizeBytes=64"
	    }
	)
@FacesConfig
@ApplicationScoped
public class ApplicationConfig {
	
//	 public String doHash(String in) {		 
//		 HashPasswordSha512Base64 hash = new HashPasswordSha512Base64(in);
//		 return hash.getSha512Base64PaddedPasswordHash();
//		 }
	

}
