package org.nljug.jcp.jsr375.authentication;

import javax.enterprise.context.RequestScoped;
import javax.security.identitystore.CredentialValidationResult;
import javax.security.identitystore.IdentityStore;
import javax.security.identitystore.credential.Credential;

/**
 * An @IdentityStore is responsible for the access to a credential repository and the actual validation of the given
 *
 * @Credential. This example presents an hard coded example for the caller 'admin' with its too obvious password.
 */
@RequestScoped
public class CustomIdentityStore implements IdentityStore {

    /**
     * This method validate the given UsernamePasswordCredential instance
     *
     * @param credential
     *
     * @return
     */
    @Override
    public CredentialValidationResult validate(Credential credential) {
        // FIXME
    }

}
