package com.openai.client.okhttp

import com.openai.http.okhttp.X509Transport as Transport
import javax.net.ssl.X509ExtendedKeyManager
import javax.net.ssl.X509TrustManager

/**
 * Preview: an immutable, caller-attested TLS capability for X.509 workload identity federation.
 *
 * The caller attests that the configured certificate alias resolves to the same private key and
 * certificate chain, and that the trust manager makes stable trust decisions, for this capability's
 * lifetime. The SDK does not copy private-key material. To rotate the identity or change server
 * trust, build a new capability; each capability is a distinct TLS generation with its own context.
 * Each bound session creates and owns its own isolated connection pools.
 *
 * This initial capability is direct-connect only. It always uses native hostname verification,
 * disables redirects, and does not accept arbitrary clients, interceptors, or socket factories.
 */
class X509Transport private constructor(@get:JvmSynthetic internal val delegate: Transport) {
    companion object {
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [X509Transport]. */
    class Builder internal constructor() {
        private val builder = Transport.builder()

        /**
         * Sets the caller-owned key manager. Its configured [certificateAlias] must remain stable
         * for the lifetime of the built capability.
         */
        fun keyManager(keyManager: X509ExtendedKeyManager) = apply {
            builder.keyManager(keyManager)
        }

        /**
         * Sets the one client-certificate alias allowed on both network legs. This explicit
         * selection overrides server CA issuer hints, which may not list the enrolled issuer. The
         * alias must still support the requested key type; server trust is unchanged.
         */
        fun certificateAlias(certificateAlias: String) = apply {
            builder.certificateAlias(certificateAlias)
        }

        /**
         * Sets the caller-owned trust manager used for server authentication. Client identity and
         * server trust remain independent. The caller attests that its trust decisions remain
         * stable for the lifetime of the built capability. To change the trust policy, build a new
         * capability.
         */
        fun trustManager(trustManager: X509TrustManager) = apply {
            builder.trustManager(trustManager)
        }

        fun build() = X509Transport(builder.build())
    }
}
