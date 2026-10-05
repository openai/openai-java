package com.openai.core

import com.openai.auth.WorkloadIdentityAuth
import com.openai.azure.credential.AzureApiKeyCredential
import com.openai.client.OpenAIClientImpl
import com.openai.core.http.Headers
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.QueryParams
import com.openai.core.http.WebSocketClient
import com.openai.core.http.WebSocketHandshakeException
import com.openai.credential.BearerTokenCredential
import com.openai.credential.WorkloadIdentityCredential
import java.io.InputStream
import java.util.concurrent.CompletableFuture
import java.util.function.Supplier
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyNoInteractions
import org.mockito.kotlin.whenever

internal class RemovedCredentialHeadersTest {

    private val transport = mock<HttpClient>()
    private val security = SecurityOptions.builder().bearerAuth(true).build()
    private val params =
        object : Params {
            override fun _headers(): Headers = Headers.builder().build()

            override fun _queryParams(): QueryParams = QueryParams.builder().build()
        }

    @Test
    fun removedAuthorizationIsNotRestoredDuringRequestPreparation() {
        val options =
            ClientOptions.builder()
                .httpClient(transport)
                .apiKey("test-api-key")
                .removeAllHeaders(setOf("aUtHoRiZaTiOn"))
                .build()

        assertThat(prepare(options).headers.values("Authorization")).isEmpty()
        assertThat(prepare(options.toBuilder().build()).headers.values("Authorization")).isEmpty()
    }

    @Test
    fun explicitReplacementIsPreservedWithoutAddingTheApiKey() {
        val options =
            ClientOptions.builder()
                .httpClient(transport)
                .apiKey("test-api-key")
                .removeHeaders("Authorization")
                .putHeader("Authorization", "Bearer test-explicit-token")
                .build()

        assertThat(prepare(options).headers.values("Authorization"))
            .containsExactly("Bearer test-explicit-token")
    }

    @Test
    fun removingAzureApiKeyDoesNotRestoreIt() {
        val options =
            ClientOptions.builder()
                .httpClient(transport)
                .credential(AzureApiKeyCredential.create("test-azure-key"))
                .removeHeaders("API-KEY")
                .build()

        assertThat(prepare(options).headers.values("api-key")).isEmpty()
    }

    @Test
    fun azureBearerReplacementRespectsExplicitRemoval() {
        val options =
            ClientOptions.builder()
                .httpClient(transport)
                .baseUrl("https://example.openai.azure.com")
                .apiKey("test-azure-token")
                .removeHeaders("Authorization")
                .build()

        assertThat(prepare(options).headers.values("Authorization")).isEmpty()
    }

    @Test
    fun removingUnrelatedHeadersPreservesAuthentication() {
        val original = ClientOptions.builder().httpClient(transport).apiKey("test-api-key").build()
        val updated = original.toBuilder().removeHeaders("X-Test").build()

        assertThat(prepare(updated).headers.values("Authorization"))
            .containsExactly("Bearer test-api-key")
        assertThat(prepare(original).headers.values("Authorization"))
            .containsExactly("Bearer test-api-key")
    }

    @Test
    fun removedAuthorizationAlsoSuppressesRouteSpecificAdminCredentials() {
        val options =
            ClientOptions.builder()
                .httpClient(transport)
                .adminApiKey("test-admin-key")
                .removeHeaders("authorization")
                .build()

        assertThat(
                options
                    .securityHeaders(SecurityOptions.builder().adminApiKeyAuth(true).build())
                    .values("Authorization")
            )
            .isEmpty()
    }

    @ParameterizedTest
    @CsvSource(
        "false,false,false",
        "false,false,true",
        "false,true,false",
        "false,true,true",
        "true,false,false",
        "true,false,true",
        "true,true,false",
        "true,true,true",
    )
    fun copiedBearerClientSkipsRemovedTokenSupplier(
        async: Boolean,
        azure: Boolean,
        replacement: Boolean,
    ) {
        val response = mock<HttpResponse>()
        whenever(response.statusCode()).thenReturn(200)
        whenever(response.headers())
            .thenReturn(Headers.builder().put("content-type", "application/json").build())
        whenever(response.body())
            .thenReturn(
                """{"id":"model-test","object":"model","created":0,"owned_by":"test"}"""
                    .byteInputStream()
            )
        val sent = mutableListOf<Headers>()
        whenever(transport.execute(any(), any())).thenAnswer {
            sent.add(it.getArgument<HttpRequest>(0).headers)
            response
        }
        whenever(transport.executeAsync(any(), any())).thenAnswer {
            sent.add(it.getArgument<HttpRequest>(0).headers)
            CompletableFuture.completedFuture(response)
        }
        var tokenCalls = 0
        val original =
            OpenAIClientImpl(
                ClientOptions.builder()
                    .httpClient(transport)
                    .baseUrl(
                        if (azure) "https://example.openai.azure.com" else "https://example.test"
                    )
                    .credential(
                        BearerTokenCredential.create(
                            Supplier<String> {
                                tokenCalls++
                                error("Removed token supplier must not run")
                            }
                        )
                    )
                    .build()
            )
        val copied =
            original.withOptions {
                it.removeHeaders("aUtHoRiZaTiOn")
                if (replacement) it.putHeader("Authorization", "Bearer test-explicit-token")
            }
        try {
            if (async) copied.async().models().retrieve("model-test").join()
            else copied.models().retrieve("model-test")
            assertThat(tokenCalls).isZero()
            assertThat(sent).hasSize(1)
            assertThat(sent.single().values("Authorization"))
                .containsExactlyElementsOf(
                    if (replacement) listOf("Bearer test-explicit-token") else emptyList()
                )
        } finally {
            copied.close()
        }
    }

    @ParameterizedTest
    @CsvSource("false,false", "false,true", "true,false", "true,true")
    fun copiedWorkloadClientHonorsRemovalAtTransport(async: Boolean, replacement: Boolean) {
        val auth = mock<WorkloadIdentityAuth>()
        whenever(auth.getToken()).thenReturn("test-workload-token")
        whenever(auth.getTokenAsync())
            .thenReturn(CompletableFuture.completedFuture("test-workload-token"))
        val sent = mutableListOf<Headers>()
        val transport =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse {
                    sent.add(request.headers)
                    return object : HttpResponse {
                        override fun statusCode() = 200

                        override fun headers() =
                            Headers.builder().put("content-type", "application/json").build()

                        override fun body(): InputStream =
                            """{"id":"model-test","object":"model","created":0,"owned_by":"test"}"""
                                .byteInputStream()

                        override fun close() {}
                    }
                }

                override fun executeAsync(request: HttpRequest, requestOptions: RequestOptions) =
                    CompletableFuture.completedFuture(execute(request, requestOptions))

                override fun close() {}
            }
        val original =
            OpenAIClientImpl(
                ClientOptions.builder()
                    .httpClient(transport)
                    .credential(WorkloadIdentityCredential(auth))
                    .build()
            )
        val copied =
            original.withOptions {
                it.removeAllHeaders(setOf("aUtHoRiZaTiOn"))
                if (replacement) it.putHeader("Authorization", "Bearer test-explicit-token")
            }
        if (async) {
            copied.async().models().retrieve("model-test").join()
            original.async().models().retrieve("model-test").join()
        } else {
            copied.models().retrieve("model-test")
            original.models().retrieve("model-test")
        }
        assertThat(sent[0].values("Authorization"))
            .containsExactlyElementsOf(
                if (replacement) listOf("Bearer test-explicit-token") else emptyList()
            )
        assertThat(sent[1].values("Authorization")).containsExactly("Bearer test-workload-token")
        if (async) verify(auth).getTokenAsync() else verify(auth).getToken()
        copied.close()
        verify(auth).close()
    }

    @ParameterizedTest
    @CsvSource("false,false", "false,true", "true,false", "true,true")
    fun copiedWorkloadWebSocketHonorsRemoval(replacement: Boolean, rejected: Boolean) {
        val auth = mock<WorkloadIdentityAuth>()
        whenever(auth.getTokenAsync())
            .thenReturn(CompletableFuture.completedFuture("test-workload-token"))
        val sent = mutableListOf<Headers>()
        val transport =
            object : HttpClient, WebSocketClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse = error("Unexpected HTTP request")

                override fun executeAsync(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): CompletableFuture<HttpResponse> = error("Unexpected HTTP request")

                override fun connectWebSocket(
                    request: HttpRequest,
                    options: RequestOptions,
                    maxMessageBytes: Int,
                    listener: WebSocketClient.Listener,
                ): CompletableFuture<WebSocketClient.Connection> {
                    sent.add(request.headers)
                    return if (rejected) {
                        CompletableFuture<WebSocketClient.Connection>().apply {
                            completeExceptionally(WebSocketHandshakeException(401))
                        }
                    } else CompletableFuture.completedFuture(mock<WebSocketClient.Connection>())
                }

                override fun close() {}
            }
        val original =
            OpenAIClientImpl(
                ClientOptions.builder()
                    .httpClient(transport)
                    .credential(WorkloadIdentityCredential(auth))
                    .build()
            )
        val copied =
            original.withOptions {
                it.removeHeaders("aUtHoRiZaTiOn")
                if (replacement) it.putHeader("Authorization", "Bearer test-explicit-token")
            }
        try {
            if (rejected) {
                assertThatThrownBy { copied.async().responses().connect().join() }
                    .hasCauseInstanceOf(WebSocketHandshakeException::class.java)
            } else copied.async().responses().connect().join().close()
            assertThat(sent[0].values("Authorization"))
                .containsExactlyElementsOf(
                    if (replacement) listOf("Bearer test-explicit-token") else emptyList()
                )
            verifyNoInteractions(auth)

            if (rejected) {
                assertThatThrownBy { original.async().responses().connect().join() }
                    .hasCauseInstanceOf(WebSocketHandshakeException::class.java)
                verify(auth).invalidateToken("Bearer test-workload-token")
            } else original.async().responses().connect().join().close()
            assertThat(sent[1].values("Authorization"))
                .containsExactly("Bearer test-workload-token")
            verify(auth).getTokenAsync()
        } finally {
            copied.close()
        }
        verify(auth).close()
    }

    private fun prepare(options: ClientOptions): HttpRequest =
        HttpRequest.builder()
            .method(HttpMethod.GET)
            .baseUrl("https://example.test")
            .build()
            .prepare(options, params, security)
}
