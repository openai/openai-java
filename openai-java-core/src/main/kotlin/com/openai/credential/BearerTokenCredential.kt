package com.openai.credential

import java.util.function.Supplier

/**
 * <p> A credential that provides a bearer token. </p>
 *
 * <p>
 * If you are using the OpenAI API, you need to provide a bearer token for authentication. All API
 * requests should include your API key in an Authorization HTTP header as follows: "Authorization:
 * Bearer OPENAI_API_KEY" </p>
 *
 * <p> Two ways to provide the token: </p>
 * <ol>
 * <l1> 1. Provide the token directly, 'BearerTokenCredential.create(String)'. The method
 *      'ClientOptions.apiKey(String)' is a wrapper for this.</li> <l1> 2. Provide a supplier that
 *      provides the token, 'BearerTokenCredential.create(Supplier<String>)'.</li>
 * </ol>
 *
 * @param tokenSupplier a supplier that provides the token.
 * @see <a href="https://platform.openai.com/docs/api-reference/authentication">OpenAI
 *   Authentication</a>
 */
class BearerTokenCredential private constructor(private val tokenSupplier: Supplier<String>) :
    Credential {

    companion object {
        @JvmStatic fun create(token: String): Credential = BearerTokenCredential { token }

        @JvmStatic
        fun create(tokenSupplier: Supplier<String>): Credential =
            BearerTokenCredential(tokenSupplier)
    }

    fun token(): String = tokenSupplier.get()
}
