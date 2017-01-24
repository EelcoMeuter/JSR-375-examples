package org.nljug.jcp.jsr375.authentication;

import javax.security.identitystore.CredentialValidationResult;
import javax.security.identitystore.IdentityStore;
import javax.security.identitystore.credential.Credential;
import javax.security.identitystore.credential.UsernamePasswordCredential;

import static javax.security.identitystore.CredentialValidationResult.INVALID_RESULT;
import static javax.security.identitystore.CredentialValidationResult.NOT_VALIDATED_RESULT;

/**
 * An @IdentityStore is responsible for the access to a credential repository and the actual validation of the given
 * @Credential. This example presents an hard coded example for the caller 'admin' with its too obvious password. The
 * common defensive practices for development apply.
 */
public final class CustomIdentityStore implements IdentityStore {

    private static final String CALLER = "admin";

    @Override
    public CredentialValidationResult validate(Credential credential) {
        if (credential != null && credential instanceof UsernamePasswordCredential) {
            return validateCredential((UsernamePasswordCredential) credential);
        }
        return NOT_VALIDATED_RESULT;
    }

    private CredentialValidationResult validateCredential(UsernamePasswordCredential credential){
        return INVALID_RESULT;
    }
}
