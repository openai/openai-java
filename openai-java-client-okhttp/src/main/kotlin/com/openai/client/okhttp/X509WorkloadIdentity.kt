package com.openai.client.okhttp

import com.openai.core.Timeout
import com.openai.core.checkRequired
import java.net.Proxy
import java.time.Duration

/** Configuration for workload identity authenticated with a fixed X.509 client certificate. */
class X509WorkloadIdentity
private constructor(
    /** Identity provider resource ID. */
    @get:JvmName("identityProviderId") val identityProviderId: String,
    /** Service account ID associated with the certificate identity. */
    @get:JvmName("serviceAccountId") val serviceAccountId: String,
    /** Caller-owned, fixed-alias mutual TLS configuration. */
    @get:JvmName("transport") val transport: X509Transport,
    /** How early the SDK refreshes an access token. Defaults to 20 minutes. */
    @get:JvmName("refreshBuffer") val refreshBuffer: Duration,
    private val exchangeTestProxy: Proxy? = null,
    private val apiTestProxy: Proxy? = null,
) {

    companion object {
        @JvmStatic fun builder() = Builder()
    }

    /** A Java-compatible builder for certificate-based workload identity. */
    class Builder internal constructor() {

        private var identityProviderId: String? = null
        private var serviceAccountId: String? = null
        private var transport: X509Transport? = null
        private var refreshBuffer: Duration = Duration.ofMinutes(20)

        /** Sets the identity provider resource ID. */
        fun identityProviderId(identityProviderId: String) = apply {
            this.identityProviderId = identityProviderId
        }

        /** Sets the service account ID associated with the certificate identity. */
        fun serviceAccountId(serviceAccountId: String) = apply {
            this.serviceAccountId = serviceAccountId
        }

        /** Sets the existing fixed-alias X.509 mutual TLS transport capability. */
        fun transport(transport: X509Transport) = apply { this.transport = transport }

        /** Sets how early a cached token should be refreshed. Defaults to 20 minutes. */
        fun refreshBuffer(refreshBuffer: Duration) = apply {
            require(!refreshBuffer.isNegative) { "refreshBuffer must not be negative" }
            this.refreshBuffer = refreshBuffer
        }

        /** Returns immutable certificate-based workload identity configuration. */
        fun build(): X509WorkloadIdentity =
            X509WorkloadIdentity(
                checkRequired("identityProviderId", identityProviderId).also {
                    require(it.isNotBlank()) { "identityProviderId must not be blank" }
                },
                checkRequired("serviceAccountId", serviceAccountId).also {
                    require(it.isNotBlank()) { "serviceAccountId must not be blank" }
                },
                checkRequired("transport", transport),
                refreshBuffer,
            )
    }

    @JvmSynthetic
    internal fun bind(timeout: Timeout): BoundX509Transport =
        if (exchangeTestProxy == null || apiTestProxy == null) transport.bind(timeout)
        else transport.bindForTest(timeout, exchangeTestProxy, apiTestProxy)

    /** Test-only loopback CONNECT seam; production bindings always connect directly. */
    @JvmSynthetic
    internal fun withTestProxies(exchangeProxy: Proxy, apiProxy: Proxy): X509WorkloadIdentity =
        X509WorkloadIdentity(
            identityProviderId,
            serviceAccountId,
            transport,
            refreshBuffer,
            exchangeProxy,
            apiProxy,
        )
}
