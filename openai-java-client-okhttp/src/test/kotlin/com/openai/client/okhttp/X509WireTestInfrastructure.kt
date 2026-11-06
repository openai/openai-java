package com.openai.client.okhttp

import java.net.Proxy
import java.net.Socket
import java.security.KeyStore
import java.security.SecureRandom
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import java.util.concurrent.CopyOnWriteArrayList
import javax.net.ssl.ExtendedSSLSession
import javax.net.ssl.KeyManagerFactory
import javax.net.ssl.SNIHostName
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLEngine
import javax.net.ssl.SSLSocket
import javax.net.ssl.X509ExtendedKeyManager
import javax.net.ssl.X509ExtendedTrustManager
import javax.net.ssl.X509TrustManager
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import okhttp3.mockwebserver.SocketPolicy
import okhttp3.tls.HandshakeCertificates
import okhttp3.tls.HeldCertificate

/** Test-only certificate identity for the X.509 wire-contract suite. */
internal class X509TestIdentity
private constructor(val leaf: HeldCertificate, val root: HeldCertificate) {
    fun clientHandshakeCertificates(
        trustedServerRoots: Iterable<X509Certificate>
    ): HandshakeCertificates =
        HandshakeCertificates.Builder()
            .heldCertificate(leaf)
            .apply {
                trustedServerRoots.forEach { certificate -> addTrustedCertificate(certificate) }
            }
            .build()

    companion object {
        fun create(commonName: String): X509TestIdentity {
            val root =
                HeldCertificate.Builder()
                    .commonName("$commonName root")
                    .certificateAuthority(1)
                    .build()
            val leaf = HeldCertificate.Builder().commonName(commonName).signedBy(root).build()
            return X509TestIdentity(leaf, root)
        }
    }
}

/**
 * A distinct mTLS peer that can act as an HTTP CONNECT proxy before negotiating TLS. This preserves
 * the production authority and SNI while keeping every connection on loopback.
 */
internal class X509TestPeer(
    val authority: String,
    trustedClientRoot: X509Certificate,
    private val tunnelProxy: Boolean = true,
    advertisedClientRoots: List<X509Certificate>? = null,
) : AutoCloseable {
    private val serverRoot =
        HeldCertificate.Builder().commonName("$authority test root").certificateAuthority(1).build()
    private val serverLeaf =
        HeldCertificate.Builder()
            .commonName(authority)
            .addSubjectAlternativeName(authority)
            .signedBy(serverRoot)
            .build()
    private val recordingTrustManager =
        RecordingClientTrustManager(
            HandshakeCertificates.Builder()
                .addTrustedCertificate(trustedClientRoot)
                .build()
                .trustManager,
            advertisedClientRoots,
        )
    private val serverIdentity = HandshakeCertificates.Builder().heldCertificate(serverLeaf).build()
    private val sslContext =
        SSLContext.getInstance("TLS").apply {
            init(arrayOf(serverIdentity.keyManager), arrayOf(recordingTrustManager), SecureRandom())
        }

    val server =
        MockWebServer().apply {
            useHttps(sslContext.socketFactory, tunnelProxy)
            requireClientAuth()
            start()
        }

    val proxy: Proxy
        get() = server.toProxyAddress()

    val serverRootCertificate: X509Certificate
        get() = serverRoot.certificate

    val requestedServerNames: List<String>
        get() = recordingTrustManager.requestedServerNames.toList()

    val rejectedClientCertificates: List<X509Certificate>
        get() = recordingTrustManager.rejectedClientCertificates.toList()

    fun enqueue(response: MockResponse) {
        if (tunnelProxy)
            server.enqueue(MockResponse().setSocketPolicy(SocketPolicy.UPGRADE_TO_SSL_AT_END))
        server.enqueue(response)
    }

    fun takeRequest(): RecordedRequest = server.takeRequest()

    override fun close() {
        server.close()
    }
}

internal inline fun <T> OkHttpClient.useTestClient(block: (OkHttpClient) -> T): T =
    try {
        block(this)
    } finally {
        connectionPool.evictAll()
        dispatcher.executorService.shutdownNow()
        cache?.close()
    }

internal fun x509TestKeyManager(identities: Map<String, X509TestIdentity>): X509ExtendedKeyManager {
    val password = "test password".toCharArray()
    val keyStore =
        KeyStore.getInstance("PKCS12").apply {
            load(null, null)
            identities.forEach { (alias, identity) ->
                setKeyEntry(
                    alias,
                    identity.leaf.keyPair.private,
                    password,
                    arrayOf(identity.leaf.certificate, identity.root.certificate),
                )
            }
        }
    val keyManagerFactory =
        KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm()).apply {
            init(keyStore, password)
        }
    return keyManagerFactory.keyManagers.filterIsInstance<X509ExtendedKeyManager>().single()
}

private class RecordingClientTrustManager(
    private val delegate: X509TrustManager,
    private val advertisedClientRoots: List<X509Certificate>? = null,
) : X509ExtendedTrustManager() {
    val requestedServerNames = CopyOnWriteArrayList<String>()
    val rejectedClientCertificates = CopyOnWriteArrayList<X509Certificate>()

    override fun checkClientTrusted(
        chain: Array<out X509Certificate>,
        authType: String,
        socket: Socket,
    ) {
        recordRequestedServerNames((socket as? SSLSocket)?.handshakeSession)
        validateClient(chain, authType)
    }

    override fun checkClientTrusted(
        chain: Array<out X509Certificate>,
        authType: String,
        engine: SSLEngine,
    ) {
        recordRequestedServerNames(engine.handshakeSession)
        validateClient(chain, authType)
    }

    override fun checkClientTrusted(chain: Array<out X509Certificate>, authType: String) {
        validateClient(chain, authType)
    }

    private fun validateClient(chain: Array<out X509Certificate>, authType: String) {
        try {
            delegate.checkClientTrusted(chain, authType)
        } catch (error: CertificateException) {
            chain.firstOrNull()?.let(rejectedClientCertificates::add)
            throw error
        }
    }

    override fun checkServerTrusted(
        chain: Array<out X509Certificate>,
        authType: String,
        socket: Socket,
    ) {
        delegate.checkServerTrusted(chain, authType)
    }

    override fun checkServerTrusted(
        chain: Array<out X509Certificate>,
        authType: String,
        engine: SSLEngine,
    ) {
        delegate.checkServerTrusted(chain, authType)
    }

    override fun checkServerTrusted(chain: Array<out X509Certificate>, authType: String) {
        delegate.checkServerTrusted(chain, authType)
    }

    override fun getAcceptedIssuers(): Array<X509Certificate> =
        advertisedClientRoots?.toTypedArray() ?: delegate.acceptedIssuers

    private fun recordRequestedServerNames(session: javax.net.ssl.SSLSession?) {
        val extendedSession = session as? ExtendedSSLSession ?: return
        extendedSession.requestedServerNames.filterIsInstance<SNIHostName>().mapTo(
            requestedServerNames
        ) { serverName ->
            serverName.asciiName
        }
    }
}
