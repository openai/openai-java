package com.openai.auth

import com.openai.core.checkRequired

/** Configuration for workload identity federation. */
class WorkloadIdentity
private constructor(
    /** A unique string that identifies the client. */
    @get:JvmName("clientId") val clientId: String?,
    /** Identity provider resource id in WIFAPI. */
    @get:JvmName("identityProviderId") val identityProviderId: String,
    /** Service account id to bind the verified external identity to. */
    @get:JvmName("serviceAccountId") val serviceAccountId: String,
    /** The provider configuration for obtaining the subject token. */
    @get:JvmName("provider") val provider: SubjectTokenProvider,
    /**
     * Buffer time in seconds to refresh the OpenAI token before it expires. Defaults to 1200
     * seconds (20 minutes).
     */
    @get:JvmName("refreshBufferSeconds") val refreshBufferSeconds: Int,
) {

    companion object {
        @JvmStatic fun builder() = Builder()
    }

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
                checkRequired("provider", provider),
                refreshBufferSeconds,
            )
    }
}
