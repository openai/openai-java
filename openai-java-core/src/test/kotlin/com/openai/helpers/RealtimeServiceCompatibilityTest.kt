package com.openai.helpers

import com.openai.core.ClientOptions
import com.openai.core.http.HttpClient
import com.openai.services.async.RealtimeServiceAsync
import com.openai.services.async.RealtimeServiceAsyncImpl
import com.openai.services.async.realtime.CallServiceAsync
import com.openai.services.async.realtime.ClientSecretServiceAsync
import com.openai.services.blocking.RealtimeService
import com.openai.services.blocking.RealtimeServiceImpl
import com.openai.services.blocking.realtime.CallService
import com.openai.services.blocking.realtime.ClientSecretService
import java.util.function.Consumer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.Mockito.mock

internal class RealtimeServiceCompatibilityTest {
    // These implementations intentionally implement only the previously published interfaces.
    private class OldBlocking : RealtimeService {
        override fun withRawResponse() = OldBlockingRaw()

        override fun withOptions(modifier: Consumer<ClientOptions.Builder>) = this

        override fun clientSecrets(): ClientSecretService = mock(ClientSecretService::class.java)

        override fun calls(): CallService = mock(CallService::class.java)
    }

    private class OldBlockingRaw : RealtimeService.WithRawResponse {
        override fun withOptions(modifier: Consumer<ClientOptions.Builder>) = this

        override fun clientSecrets(): ClientSecretService.WithRawResponse =
            mock(ClientSecretService.WithRawResponse::class.java)

        override fun calls(): CallService.WithRawResponse =
            mock(CallService.WithRawResponse::class.java)
    }

    private class OldAsync : RealtimeServiceAsync {
        override fun withRawResponse() = OldAsyncRaw()

        override fun withOptions(modifier: Consumer<ClientOptions.Builder>) = this

        override fun clientSecrets(): ClientSecretServiceAsync =
            mock(ClientSecretServiceAsync::class.java)

        override fun calls(): CallServiceAsync = mock(CallServiceAsync::class.java)
    }

    private class OldAsyncRaw : RealtimeServiceAsync.WithRawResponse {
        override fun withOptions(modifier: Consumer<ClientOptions.Builder>) = this

        override fun clientSecrets(): ClientSecretServiceAsync.WithRawResponse =
            mock(ClientSecretServiceAsync.WithRawResponse::class.java)

        override fun calls(): CallServiceAsync.WithRawResponse =
            mock(CallServiceAsync.WithRawResponse::class.java)
    }

    @Test
    fun oldImplementationsRemainUsable() {
        val blocking = OldBlocking()
        val blockingRaw = blocking.withRawResponse()
        val async = OldAsync()
        val asyncRaw = async.withRawResponse()
        assertThat(blocking.withOptions {}).isSameAs(blocking)
        assertThat(blockingRaw.withOptions {}).isSameAs(blockingRaw)
        assertThat(async.withOptions {}).isSameAs(async)
        assertThat(asyncRaw.withOptions {}).isSameAs(asyncRaw)
        assertThat(blocking.calls()).isNotNull()
        assertThat(blockingRaw.calls()).isNotNull()
        assertThat(async.calls()).isNotNull()
        assertThat(asyncRaw.calls()).isNotNull()
        assertThrows<UnsupportedOperationException> { blocking.translations() }
        assertThrows<UnsupportedOperationException> { blockingRaw.translations() }
        assertThrows<UnsupportedOperationException> { async.translations() }
        assertThrows<UnsupportedOperationException> { asyncRaw.translations() }
    }

    @Test
    fun sdkImplementationsProvideTranslationsInEveryView() {
        val options =
            ClientOptions.builder()
                .httpClient(mock(HttpClient::class.java))
                .apiKey("test-api-key")
                .build()
        val blocking: RealtimeService = RealtimeServiceImpl(options)
        val async: RealtimeServiceAsync = RealtimeServiceAsyncImpl(options)
        assertThat(blocking.translations().clientSecrets()).isNotNull()
        assertThat(blocking.withRawResponse().translations().clientSecrets()).isNotNull()
        assertThat(async.translations().clientSecrets()).isNotNull()
        assertThat(async.withRawResponse().translations().clientSecrets()).isNotNull()
    }
}
