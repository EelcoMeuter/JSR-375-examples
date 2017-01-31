package org.nljug.jcp.jsr375.rest;

import javax.security.authentication.mechanism.http.annotation.BasicAuthenticationMechanismDefinition;
import javax.security.identitystore.annotation.Credentials;
import javax.security.identitystore.annotation.EmbeddedIdentityStoreDefinition;

@BasicAuthenticationMechanismDefinition(realmName = "test realm")
@EmbeddedIdentityStoreDefinition(
        { @Credentials(callerName = "admin", password = "admin", groups = { "role1", "role2" }) })
public class SecurityConfig {

}
