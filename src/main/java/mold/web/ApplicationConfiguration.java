package mold.web;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;

@CustomFormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(
                loginPage = "/login.xhtml",
                useForwardToLogin = false
            )
)

@DatabaseIdentityStoreDefinition(
		   dataSourceLookup = "${'java:global/permissions_db'}",
		   callerQuery = "#{'select password from caller where name = ?'}",
		   groupsQuery = "select group_name from caller_groups where caller_name = ?",
		   hashAlgorithm = PBKDF2WithHmacSHA512.class,
		   priority = 10
		)
@FacesConfig
@ApplicationScoped
public class ApplicationConfiguration {

}
