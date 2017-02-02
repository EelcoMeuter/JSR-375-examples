package org.nljug.jcp.jsr375.authentication;

import com.unboundid.ldap.listener.InMemoryDirectoryServer;
import com.unboundid.ldap.listener.InMemoryDirectoryServerConfig;
import com.unboundid.ldap.listener.InMemoryListenerConfig;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldif.LDIFReader;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * Original source: https://github.com/javaee-security-spec/soteria/blob/master/test/app-ldap/src/main/java/org
 * /glassfish/soteria/test/LdapSetup.java
 */
@Startup
@Singleton
public class LdapSetup {

    private InMemoryDirectoryServer directoryServer;

    @PostConstruct
    public void init() {
        try {
            InMemoryDirectoryServerConfig config = new InMemoryDirectoryServerConfig("dc=net");
            config.setListenerConfigs(new InMemoryListenerConfig("myListener", null, 33389, null, null, null));

            directoryServer = new InMemoryDirectoryServer(config);

            directoryServer.importFromLDIF(true, new LDIFReader(this.getClass().getResourceAsStream("/test.ldif")));

            directoryServer.startListening();
        } catch (LDAPException e) {
            throw new IllegalStateException(e);
        }
    }

    @PreDestroy
    public void destroy() {
        directoryServer.shutDown(true);
    }

}