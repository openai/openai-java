package com.openai.client.okhttp

import com.openai.http.okhttp.X509WorkloadIdentity as Identity
import java.net.Proxy
import java.time.Duration

/** Configuration for workload identity authenticated with a fixed X.509 client certificate. */
class X509WorkloadIdentity
private constructor(
    @get:JvmSynthetic internal val delegate: Identity,
    @get:JvmName("transport") val transport: X509Transport,
) {
    @get:JvmName("identityProviderId")
    val identityProviderId
        get() = delegate.identityProviderId

    @get:JvmName("serviceAccountId")
    val serviceAccountId
        get() = delegate.serviceAccountId

    @get:JvmName("refreshBuffer")
    val refreshBuffer
        get() = delegate.refreshBuffer

    @JvmSynthetic
    internal fun withTestProxies(exchangeProxy: Proxy, apiProxy: Proxy) =
        X509WorkloadIdentity(delegate.withTestProxies(exchangeProxy, apiProxy), transport)

    companion object {
        @JvmStatic fun builder() = Builder()
    }

    /** A Java-compatible builder for certificate-based workload identity. */
    class Builder internal constructor() {
        private val builder = Identity.builder()
        private var transport: X509Transport? = null

        /** Sets the identity provider resource ID. */
        fun identityProviderId(identityProviderId: String) = apply {
            builder.identityProviderId(identityProviderId)
        }

        /** Sets the service account ID associated with the certificate identity. */
        fun serviceAccountId(serviceAccountId: String) = apply {
            builder.serviceAccountId(serviceAccountId)
        }

        /** Sets how early a cached token should be refreshed. Defaults to 20 minutes. */
        fun refreshBuffer(refreshBuffer: Duration) = apply { builder.refreshBuffer(refreshBuffer) }

        /** Sets the existing fixed-alias X.509 mutual TLS transport capability. */
        fun transport(transport: X509Transport) = apply {
            builder.transport(transport.delegate)
            this.transport = transport
        }

        /** Returns immutable certificate-based workload identity configuration. */
        fun build() = X509WorkloadIdentity(builder.build(), checkNotNull(transport))
    }
}
