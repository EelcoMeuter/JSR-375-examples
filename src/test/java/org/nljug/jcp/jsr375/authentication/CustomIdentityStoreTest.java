package org.nljug.jcp.jsr375.authentication;

import org.junit.Test;

import javax.security.identitystore.credential.Credential;
import javax.security.identitystore.credential.UsernamePasswordCredential;

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
    public void should_invalidate_empty_credential(){
        String evil = null;
        assertEquals(INVALID_RESULT,store.validate(new UsernamePasswordCredential(evil, evil)));
    }

}
