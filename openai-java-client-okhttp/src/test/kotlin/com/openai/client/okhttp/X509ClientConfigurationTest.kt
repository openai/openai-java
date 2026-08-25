package com.openai.client.okhttp

import com.openai.auth.X509WorkloadIdentity
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpRequestAttemptAuthenticator
import com.openai.errors.OpenAIIoException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class X509ClientConfigurationTest {

    @Test
    fun failedTransportInstallClosesBothLegsAndAuthenticatorButKeepsBuilderReusable() {
        val identity =
            X509WorkloadIdentity.builder()
                .identityProviderId("idp_test")
                .serviceAccountId("svc_acct_test")
                .build()
        val firstExchange = OkHttpClient.builder().build()
        val firstApi = OkHttpClient.builder().build()
        val firstTransport = BoundX509Transport.create(firstExchange, firstApi)
        val failure = IllegalStateException("injected install failure")
        var capturedAuthenticator: HttpRequestAttemptAuthenticator? = null
        val failing =
            X509ClientConfiguration.createForTest(identity, { firstTransport }) {
                _,
                _,
                authenticator ->
                capturedAuthenticator = authenticator
                throw failure
            }
        val builder = ClientOptions.builder()
        failing.reserve(builder)

        assertThatThrownBy { failing.buildClientOptions(builder) }.isSameAs(failure)

        val request =
            HttpRequest.builder().method(HttpMethod.GET).baseUrl(X509_API_BASE_URL).build()
        assertThatThrownBy { capturedAuthenticator!!.authenticate(request, null) }
            .isInstanceOf(OpenAIIoException::class.java)
            .hasMessageContaining("closed")
        assertThatThrownBy { firstExchange.execute(request, RequestOptions.none()) }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessageContaining("closed")
        assertThatThrownBy { firstApi.execute(request, RequestOptions.none()) }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessageContaining("closed")

        val secondTransport =
            BoundX509Transport.create(
                OkHttpClient.builder().build(),
                OkHttpClient.builder().build(),
            )
        val recovered =
            X509ClientConfiguration.create(identity) { secondTransport }.buildClientOptions(builder)
        assertThat(recovered.baseUrl()).isEqualTo(X509_API_BASE_URL)
        recovered.httpClient.close()
    }
}
