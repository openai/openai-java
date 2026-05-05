package com.openai.core.http

import java.net.Proxy
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets
import java.util.Base64
import java.util.Optional

/**
 * Provides credentials when an HTTP proxy responds with `407 Proxy Authentication Required`.
 *
 * Implementations inspect the 407 [response] (typically its `Proxy-Authenticate` header) and return
 * the request to retry with a `Proxy-Authorization` header set, or [Optional.empty] to abandon
 * authentication and surface the 407 to the caller.
 *
 * Implementations must be thread-safe; they may be invoked concurrently from multiple HTTP calls.
 */
fun interface ProxyAuthenticator {

    /**
     * @param proxy the proxy that produced the challenge, or [Proxy.NO_PROXY] if the route is not
     *   yet established
     * @param request the request that produced [response]
     * @param response the 407 challenge response
     * @return the retry request to send (typically [request] with a `Proxy-Authorization` header
     *   added), or [Optional.empty] to abandon authentication
     */
    fun authenticate(
        proxy: Proxy,
        request: HttpRequest,
        response: HttpResponse,
    ): Optional<HttpRequest>

    companion object {

        /**
         * A [ProxyAuthenticator] that uses RFC 7617 Basic authentication with the ISO-8859-1
         * charset.
         */
        @JvmStatic
        fun basic(username: String, password: String): ProxyAuthenticator =
            basic(username, password, StandardCharsets.ISO_8859_1)

        /**
         * A [ProxyAuthenticator] that uses RFC 7617 Basic authentication with the given [charset].
         */
        @JvmStatic
        fun basic(username: String, password: String, charset: Charset): ProxyAuthenticator {
            val token =
                Base64.getEncoder().encodeToString("$username:$password".toByteArray(charset))
            val headerValue = "Basic $token"
            return ProxyAuthenticator { _, request, _ ->
                Optional.of(
                    request.toBuilder().putHeader("Proxy-Authorization", headerValue).build()
                )
            }
        }
    }
}
