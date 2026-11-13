package com.openai.core.http

import com.openai.client.OpenAIClientAsync
import com.openai.client.OpenAIClientAsyncImpl
import com.openai.core.ClientOptions
import com.openai.models.containers.files.FileDeleteParams
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit.SECONDS
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import org.mockito.kotlin.any
import org.mockito.kotlin.doAnswer
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

internal class TypedDeleteCancellationTest {

    enum class Endpoint(
        val objectType: String,
        val delete: (OpenAIClientAsync) -> CompletableFuture<*>,
    ) {
        CONTAINER("container.deleted", { it.containers().delete("cntr_test") }),
        FILE(
            "container.file.deleted",
            {
                it.containers()
                    .files()
                    .delete(
                        "file_test",
                        FileDeleteParams.builder().containerId("cntr_test").build(),
                    )
            },
        ),
        RESPONSE("response.deleted", { it.responses().delete("resp_test") }),
        BETA_RESPONSE("response.deleted", { it.beta().responses().delete("resp_test") }),
    }

    @ParameterizedTest
    @EnumSource(Endpoint::class)
    fun closesLateResponseOnceAfterCallerCancels(endpoint: Endpoint) {
        val transport = mock<HttpClient>()
        val pending = CompletableFuture<HttpResponse>()
        val started = CountDownLatch(1)
        whenever(transport.executeAsync(any(), any())).thenAnswer {
            started.countDown()
            pending
        }
        val client =
            OpenAIClientAsyncImpl(
                ClientOptions.builder().apiKey("test").httpClient(transport).build()
            )
        try {
            val result = endpoint.delete(client)
            assertThat(started.await(5, SECONDS)).isTrue()
            assertThat(result.cancel(true)).isTrue()

            val closed = CountDownLatch(1)
            val response = mock<HttpResponse>()
            whenever(response.statusCode()).thenReturn(200)
            whenever(response.headers()).thenReturn(Headers.builder().build())
            whenever(response.body())
                .thenReturn(
                    """{"id":"test","object":"${endpoint.objectType}","deleted":true}"""
                        .byteInputStream()
                )
            doAnswer { closed.countDown() }.whenever(response).close()
            assertThat(pending.complete(response)).isTrue()

            assertThat(closed.await(5, SECONDS)).isTrue()
            verify(response).close()
            assertThat(result.isCancelled).isTrue()
        } finally {
            client.close()
        }
    }
}
