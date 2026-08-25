package com.openai.auth

import com.openai.core.checkRequired

/** Preview: metadata that binds an X.509 workload identity to an OpenAI service account. */
class X509WorkloadIdentity
private constructor(
    /** Identity provider resource id in WIFAPI. */
    @get:JvmName("identityProviderId") val identityProviderId: String,
    /** Service account id to bind the verified certificate identity to. */
    @get:JvmName("serviceAccountId") val serviceAccountId: String,
) {

    companion object {
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [X509WorkloadIdentity]. */
    class Builder internal constructor() {

        private var identityProviderId: String? = null
        private var serviceAccountId: String? = null

        /** Identity provider resource id in WIFAPI. */
        fun identityProviderId(identityProviderId: String) = apply {
            this.identityProviderId = identityProviderId
        }

        /** Service account id to bind the verified certificate identity to. */
        fun serviceAccountId(serviceAccountId: String) = apply {
            this.serviceAccountId = serviceAccountId
        }

        fun build(): X509WorkloadIdentity =
            X509WorkloadIdentity(
                checkRequired("identityProviderId", identityProviderId).also {
                    require(it.isNotBlank()) { "identityProviderId must not be blank" }
                },
                checkRequired("serviceAccountId", serviceAccountId).also {
                    require(it.isNotBlank()) { "serviceAccountId must not be blank" }
                },
            )
    }
}
