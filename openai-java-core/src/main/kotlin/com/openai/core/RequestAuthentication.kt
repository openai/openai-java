package com.openai.core

import com.openai.core.http.HttpRequestAuthenticator
import com.openai.core.http.PhantomReachableClosingHttpRequestAuthenticator

/** Authentication that is applied to the final HTTP request rather than represented by a key. */
internal sealed interface RequestAuthentication {
    val authenticator: HttpRequestAuthenticator?

    val fixedBearerBaseUrl: String?
        get() = null

    fun satisfies(security: SecurityOptions): Boolean

    object None : RequestAuthentication {
        override val authenticator: HttpRequestAuthenticator? = null

        override fun satisfies(security: SecurityOptions): Boolean = false
    }

    class Provider private constructor(override val authenticator: HttpRequestAuthenticator) :
        RequestAuthentication {

        override fun satisfies(security: SecurityOptions): Boolean =
            security.bearerAuth || security.adminApiKeyAuth

        companion object {
            fun create(authenticator: HttpRequestAuthenticator): Provider =
                Provider(PhantomReachableClosingHttpRequestAuthenticator(authenticator))
        }
    }

    class FixedBearerReserved(override val fixedBearerBaseUrl: String) : RequestAuthentication {
        override val authenticator: HttpRequestAuthenticator? = null

        override fun satisfies(security: SecurityOptions): Boolean = false
    }

    class FixedBearerInstalled
    private constructor(
        override val fixedBearerBaseUrl: String,
        override val authenticator: HttpRequestAuthenticator,
    ) : RequestAuthentication {

        override fun satisfies(security: SecurityOptions): Boolean =
            security.bearerAuth && !security.adminApiKeyAuth

        companion object {
            fun create(
                fixedBearerBaseUrl: String,
                authenticator: HttpRequestAuthenticator,
            ): FixedBearerInstalled =
                FixedBearerInstalled(
                    fixedBearerBaseUrl,
                    PhantomReachableClosingHttpRequestAuthenticator(authenticator),
                )
        }
    }
}
