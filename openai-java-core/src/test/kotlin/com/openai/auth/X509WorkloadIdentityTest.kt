package com.openai.auth

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class X509WorkloadIdentityTest {

    @Test
    fun buildsIndependentX509Metadata() {
        val identity =
            X509WorkloadIdentity.builder()
                .identityProviderId("idp_test")
                .serviceAccountId("svc_acct_test")
                .build()

        assertThat(identity.identityProviderId).isEqualTo("idp_test")
        assertThat(identity.serviceAccountId).isEqualTo("svc_acct_test")
    }

    @Test
    fun requiresNonBlankMetadata() {
        assertThatThrownBy { X509WorkloadIdentity.builder().serviceAccountId("service").build() }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessage("`identityProviderId` is required, but was not set")
        assertThatThrownBy {
                X509WorkloadIdentity.builder()
                    .identityProviderId(" ")
                    .serviceAccountId("service")
                    .build()
            }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("identityProviderId must not be blank")
        assertThatThrownBy {
                X509WorkloadIdentity.builder()
                    .identityProviderId("provider")
                    .serviceAccountId("\t")
                    .build()
            }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("serviceAccountId must not be blank")
    }
}
