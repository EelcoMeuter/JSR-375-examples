package org.nljug.jcp.jsr375.authentication;

import javax.security.authentication.mechanism.http.annotation.FormAuthenticationMechanismDefinition;
import javax.security.authentication.mechanism.http.annotation.LoginToContinue;
import javax.security.identitystore.annotation.Credentials;
import javax.security.identitystore.annotation.EmbeddedIdentityStoreDefinition;

@FormAuthenticationMechanismDefinition(loginToContinue = @LoginToContinue(loginPage = "/login.xhtml", errorPage = ""))
@EmbeddedIdentityStoreDefinition({ @Credentials(callerName = "admin", password = "admin", groups = { "role1" }) })
public class SecurityConfig {

}
