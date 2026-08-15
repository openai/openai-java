package com.openai.auth

import com.openai.core.checkRequired
import java.time.Duration

/** Configuration for workload identity federation. */
class WorkloadIdentity
private constructor(
    /** A unique string that identifies the client. */
    @get:JvmName("clientId") val clientId: String?,
    /** Identity provider resource id in WIFAPI. */
    @get:JvmName("identityProviderId") val identityProviderId: String,
    /** Service account id to bind the verified external identity to. */
    @get:JvmName("serviceAccountId") val serviceAccountId: String,
    private val credentialSource: CredentialSource,
    private val subjectTokenProvider: SubjectTokenProvider?,
    /**
     * Buffer time in seconds to refresh the OpenAI token before it expires. Defaults to 1200
     * seconds (20 minutes).
     */
    @get:JvmName("refreshBufferSeconds") val refreshBufferSeconds: Int,
    /** Buffer time to refresh the OpenAI token before it expires. */
    @get:JvmName("refreshBuffer") val refreshBuffer: Duration,
) {

    /**
     * The provider configuration for obtaining the subject token.
     *
     * This accessor is only valid for identities created by [builder]. X.509 workload identity uses
     * the client certificate presented by the configured HTTP transport and has no subject-token
     * provider.
     */
    @get:JvmName("provider")
    val provider: SubjectTokenProvider
        get() =
            checkNotNull(subjectTokenProvider) {
                "X.509 workload identity does not have a subject-token provider"
            }

    companion object {
        @JvmStatic fun builder() = Builder()

        /** Returns a builder for X.509 workload identity federation. */
        @JvmStatic fun x509Builder() = X509Builder()
    }

    internal fun isX509(): Boolean = credentialSource == CredentialSource.X509

    internal fun subjectTokenProvider(): SubjectTokenProvider? = subjectTokenProvider

    class Builder internal constructor() {

        private var clientId: String? = null
        private var identityProviderId: String? = null
        private var serviceAccountId: String? = null
        private var provider: SubjectTokenProvider? = null
        private var refreshBufferSeconds: Int = 1200

        /** A unique string that identifies the client. */
        fun clientId(clientId: String) = apply { this.clientId = clientId }

        /** Identity provider resource id in WIFAPI. */
        fun identityProviderId(identityProviderId: String) = apply {
            this.identityProviderId = identityProviderId
        }

        /** Service account id to bind the verified external identity to. */
        fun serviceAccountId(serviceAccountId: String) = apply {
            this.serviceAccountId = serviceAccountId
        }

        /** The provider configuration for obtaining the subject token. */
        fun provider(provider: SubjectTokenProvider) = apply { this.provider = provider }

        /**
         * Buffer time in seconds to refresh the OpenAI token before it expires. Defaults to 1200
         * seconds (20 minutes).
         */
        fun refreshBufferSeconds(refreshBufferSeconds: Int) = apply {
            this.refreshBufferSeconds = refreshBufferSeconds
        }

        fun build(): WorkloadIdentity =
            WorkloadIdentity(
                clientId,
                checkRequired("identityProviderId", identityProviderId),
                checkRequired("serviceAccountId", serviceAccountId),
                CredentialSource.SUBJECT_TOKEN,
                checkRequired("provider", provider),
                refreshBufferSeconds,
                Duration.ofSeconds(refreshBufferSeconds.toLong()),
            )
    }

    class X509Builder internal constructor() {

        private var identityProviderId: String? = null
        private var serviceAccountId: String? = null
        private var refreshBuffer: Duration = Duration.ofMinutes(20)

        /** Identity provider resource id in WIFAPI. */
        fun identityProviderId(identityProviderId: String) = apply {
            this.identityProviderId = identityProviderId
        }

        /** Service account id to bind the verified certificate identity to. */
        fun serviceAccountId(serviceAccountId: String) = apply {
            this.serviceAccountId = serviceAccountId
        }

        /**
         * Buffer time to refresh the OpenAI token before it expires. Defaults to 20 minutes. The
         * effective buffer is clamped to half of each token's lifetime.
         */
        fun refreshBuffer(refreshBuffer: Duration) = apply {
            require(!refreshBuffer.isNegative) { "refreshBuffer must not be negative" }
            require(refreshBuffer.compareTo(Duration.ofSeconds(Int.MAX_VALUE.toLong())) <= 0) {
                "refreshBuffer must not exceed ${Int.MAX_VALUE} seconds"
            }
            this.refreshBuffer = refreshBuffer
        }

        fun build(): WorkloadIdentity =
            WorkloadIdentity(
                null,
                checkRequired("identityProviderId", identityProviderId),
                checkRequired("serviceAccountId", serviceAccountId),
                CredentialSource.X509,
                null,
                refreshBuffer.seconds.toInt(),
                refreshBuffer,
            )
    }

    private enum class CredentialSource {
        SUBJECT_TOKEN,
        X509,
    }
}
