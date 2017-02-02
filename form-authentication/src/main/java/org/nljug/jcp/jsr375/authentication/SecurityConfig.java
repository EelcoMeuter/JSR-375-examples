package org.nljug.jcp.jsr375.authentication;

import javax.security.authentication.mechanism.http.annotation.FormAuthenticationMechanismDefinition;
import javax.security.authentication.mechanism.http.annotation.LoginToContinue;
import javax.security.identitystore.annotation.Credentials;
import javax.security.identitystore.annotation.EmbeddedIdentityStoreDefinition;

@FormAuthenticationMechanismDefinition(loginToContinue = @LoginToContinue(loginPage = "/login.xhtml", errorPage = ""))
@EmbeddedIdentityStoreDefinition({ @Credentials(callerName = "admin", password = "admin", groups = { "role1" }) })
public class SecurityConfig {
    // This is a working example of a Facelets application with an embedded identity store. The aim of this exercise
    // is to change this store to LDAP.
    // see https://github.com/javaee-security-spec/soteria/tree/master/test/app-ldap for more details.
}
