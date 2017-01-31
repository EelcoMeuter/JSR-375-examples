package org.nljug.jcp.jsr375.authentication;

import javax.enterprise.context.RequestScoped;
import javax.security.CallerPrincipal;
import javax.security.identitystore.CredentialValidationResult;
import javax.security.identitystore.IdentityStore;
import javax.security.identitystore.credential.Credential;
import javax.security.identitystore.credential.UsernamePasswordCredential;
import java.util.List;

import static java.util.Arrays.asList;
import static javax.security.identitystore.CredentialValidationResult.INVALID_RESULT;
import static javax.security.identitystore.CredentialValidationResult.NOT_VALIDATED_RESULT;

/**
 * An @IdentityStore is responsible for the access to a credential repository and the actual validation of the given
 *
 * @Credential. This example presents an hard coded example for the caller 'admin' with its too obvious password.
 */
@RequestScoped
public class CustomIdentityStore implements IdentityStore {

    private static final String CALLER = "admin";

    private static final List<String> ROLES = asList("role1", "role2");

    @Override
    public CredentialValidationResult validate(Credential credential) {
        if (credential != null && credential instanceof UsernamePasswordCredential) {
            return validateCredential((UsernamePasswordCredential) credential);
        }
        return NOT_VALIDATED_RESULT;
    }

    private CredentialValidationResult validateCredential(UsernamePasswordCredential credential) {
        if (credential.getCaller().equals(CALLER) && credential.getPasswordAsString().equals(CALLER)) {
            return new CredentialValidationResult(new CallerPrincipal(credential.getCaller()), ROLES);
        }
        return INVALID_RESULT;
    }
}
