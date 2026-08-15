package com.openai.auth

import java.time.Duration
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class WorkloadIdentityTest {

    @Test
    fun x509BuilderCreatesIdentityWithoutSubjectTokenProvider() {
        val identity =
            WorkloadIdentity.x509Builder()
                .identityProviderId("idp_test")
                .serviceAccountId("svc_acct_test")
                .refreshBuffer(Duration.ofMinutes(5))
                .build()

        assertThat(identity.clientId).isNull()
        assertThat(identity.identityProviderId).isEqualTo("idp_test")
        assertThat(identity.serviceAccountId).isEqualTo("svc_acct_test")
        assertThat(identity.refreshBuffer).isEqualTo(Duration.ofMinutes(5))
        assertThat(identity.isX509()).isTrue()
        assertThat(identity.subjectTokenProvider()).isNull()
        assertThatThrownBy { identity.provider }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessage("X.509 workload identity does not have a subject-token provider")
    }

    @Test
    fun x509BuilderRejectsNegativeRefreshBuffer() {
        assertThatThrownBy { WorkloadIdentity.x509Builder().refreshBuffer(Duration.ofSeconds(-1)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("refreshBuffer must not be negative")
    }
}
