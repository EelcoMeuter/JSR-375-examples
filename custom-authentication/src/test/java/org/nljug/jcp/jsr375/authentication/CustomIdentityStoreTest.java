package org.nljug.jcp.jsr375.authentication;

import org.junit.Test;

import javax.security.identitystore.CredentialValidationResult;
import javax.security.identitystore.credential.Credential;
import javax.security.identitystore.credential.UsernamePasswordCredential;
import java.util.stream.IntStream;

import static javax.security.identitystore.CredentialValidationResult.INVALID_RESULT;
import static javax.security.identitystore.CredentialValidationResult.NOT_VALIDATED_RESULT;
import static org.junit.Assert.assertEquals;

public class CustomIdentityStoreTest {

    private CustomIdentityStore store = new CustomIdentityStore();

    @Test
    public void should_not_validate_null_arg() {
        assertEquals(NOT_VALIDATED_RESULT, store.validate(null));
    }

    @Test
    public void should_not_validate_invalid_type() {
        assertEquals(NOT_VALIDATED_RESULT, store.validate(new Credential() {
        }));
    }

    @Test
    public void should_invalidate_evil_credential() {
        String evil = "dr. No";
        assertEquals(INVALID_RESULT, store.validate(new UsernamePasswordCredential(evil, evil)));
    }

    @Test
    public void should_validate_credential() {
        String admin = "admin";
        CredentialValidationResult result = store.validate(new UsernamePasswordCredential(admin, admin));
        assertEquals(admin, result.getCallerPrincipal().getName());
        IntStream.range(1, result.getCallerGroups().size()).forEach(
                index -> assertEquals(String.format("role%s", index), result.getCallerGroups().get(index - 1)));
    }
}
