package com.openai.services.blocking

import com.github.tomakehurst.wiremock.client.WireMock.aResponse
import com.github.tomakehurst.wiremock.client.WireMock.delete
import com.github.tomakehurst.wiremock.client.WireMock.okJson
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.client.OpenAIClient
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.JsonValue
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.errors.NotFoundException
import com.openai.errors.OpenAIInvalidDataException
import com.openai.errors.RateLimitException
import com.openai.models.beta.responses.ResponseDeleteParams as BetaResponseDeleteParams
import com.openai.models.containers.ContainerDeleteParams
import com.openai.models.containers.ContainerDeleteResponse
import com.openai.models.containers.files.FileDeleteParams
import com.openai.models.containers.files.FileDeleteResponse
import com.openai.models.responses.ResponseDeleteParams
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class DeleteResultHttpTest {
    private lateinit var client: OpenAIClient
    private val strict = RequestOptions.builder().responseValidation(true).build()

    @BeforeEach
    fun connect(server: WireMockRuntimeInfo) {
        client =
            OpenAIOkHttpClient.builder()
                .apiKey("test-key")
                .baseUrl(server.httpBaseUrl)
                .maxRetries(0)
                .build()
    }

    @AfterEach fun close() = client.close()

    private fun stubDeleted(path: String, id: String, objectType: String) {
        stubFor(
            delete(urlEqualTo(path))
                .willReturn(
                    okJson("""{"id":"$id","object":"$objectType","deleted":true}""")
                        .withHeader("x-request-id", "req_delete")
                )
        )
    }

    private fun <T> parse(raw: HttpResponseFor<T>): T =
        raw.use {
            assertThat(it.statusCode()).isEqualTo(200)
            assertThat(it.requestId()).contains("req_delete")
            it.parse()
        }

    @Test
    fun deleteContainer() {
        stubDeleted("/containers/cntr_test", "cntr_test", "container.deleted")
        val params = ContainerDeleteParams.builder().containerId("cntr_test").build()
        val containers = client.containers()
        val async = client.async().containers()
        listOf(
                containers.delete("cntr_test"),
                async.delete(params, strict).join(),
                parse(containers.withRawResponse().delete("cntr_test", strict)),
                parse(async.withRawResponse().delete(params).join()),
            )
            .forEach {
                assertThat(it.idOrThrow()).isEqualTo("cntr_test")
                assertThat(it.deleted()).contains(true)
                assertThat(it.object_OrThrow())
                    .isEqualTo(ContainerDeleteResponse.Object.CONTAINER_DELETED)
            }
    }

    @Test
    fun deleteContainerFile() {
        stubDeleted("/containers/cntr_test/files/file_test", "file_test", "container.file.deleted")
        val container = FileDeleteParams.builder().containerId("cntr_test").build()
        val file = container.toBuilder().fileId("file_test").build()
        val files = client.containers().files()
        val async = client.async().containers().files()
        listOf(
                files.delete("file_test", container),
                async.delete(file, strict).join(),
                parse(files.withRawResponse().delete(file)),
                parse(async.withRawResponse().delete("file_test", container, strict).join()),
            )
            .forEach {
                assertThat(it.idOrThrow()).isEqualTo("file_test")
                assertThat(it.deleted()).contains(true)
                assertThat(it.object_OrThrow())
                    .isEqualTo(FileDeleteResponse.Object.CONTAINER_FILE_DELETED)
            }
    }

    @Test
    fun deleteResponse() {
        stubDeleted("/responses/resp_test", "resp_test", "response.deleted")
        val params = ResponseDeleteParams.builder().responseId("resp_test").build()
        val responses = client.responses()
        val async = client.async().responses()
        listOf(
                responses.delete(params),
                async.delete("resp_test", strict).join(),
                parse(responses.withRawResponse().delete("resp_test")),
                parse(async.withRawResponse().delete("resp_test", params, strict).join()),
            )
            .forEach {
                assertThat(it.idOrThrow()).isEqualTo("resp_test")
                assertThat(it.deleted()).contains(true)
                assertThat(it._object_()).isEqualTo(JsonValue.from("response.deleted"))
            }
    }

    @Test
    fun deleteBetaResponse() {
        stubDeleted("/responses/resp_test?beta=true", "resp_test", "response.deleted")
        val params = BetaResponseDeleteParams.builder().responseId("resp_test").build()
        val responses = client.beta().responses()
        val async = client.async().beta().responses()
        listOf(
                responses.delete("resp_test", params),
                async.delete(params).join(),
                parse(responses.withRawResponse().delete(params, strict)),
                parse(async.withRawResponse().delete("resp_test").join()),
            )
            .forEach {
                assertThat(it.idOrThrow()).isEqualTo("resp_test")
                assertThat(it.deleted()).contains(true)
                assertThat(it._object_()).isEqualTo(JsonValue.from("response.deleted"))
            }
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "{"])
    fun unreadableSuccessBodyFailsWhenParsed(body: String) {
        stubFor(delete(urlEqualTo("/containers/cntr_test")).willReturn(okJson(body)))
        val containers = client.containers()
        assertThatThrownBy { containers.delete("cntr_test") }
            .isInstanceOf(OpenAIInvalidDataException::class.java)
        containers.withRawResponse().delete("cntr_test").use {
            assertThat(it.statusCode()).isEqualTo(200)
            assertThatThrownBy { it.parse() }.isInstanceOf(OpenAIInvalidDataException::class.java)
        }
    }

    @Test
    fun noContentPreservesRawStatusAndHasNoTypedResult() {
        stubFor(delete(urlEqualTo("/responses/resp_test")).willReturn(aResponse().withStatus(204)))
        val responses = client.responses()
        responses.withRawResponse().delete("resp_test").use {
            assertThat(it.statusCode()).isEqualTo(204)
            assertThatThrownBy { it.parse() }.isInstanceOf(OpenAIInvalidDataException::class.java)
        }
        assertThatThrownBy { responses.delete("resp_test") }
            .isInstanceOf(OpenAIInvalidDataException::class.java)
    }

    @Test
    fun strictAsyncDeleteRejectsMissingDeletedFlag() {
        stubFor(
            delete(urlEqualTo("/responses/resp_test?beta=true"))
                .willReturn(okJson("""{"id":"resp_test","object":"response.deleted"}"""))
        )
        assertThatThrownBy { client.async().beta().responses().delete("resp_test", strict).join() }
            .hasCauseInstanceOf(OpenAIInvalidDataException::class.java)
    }

    @Test
    fun missingFileRaisesNotFound() {
        stubFor(
            delete(urlEqualTo("/containers/cntr_test/files/file_test"))
                .willReturn(
                    aResponse().withStatus(404).withBody("""{"error":{"message":"file expired"}}""")
                )
        )
        val params = FileDeleteParams.builder().containerId("cntr_test").fileId("file_test").build()
        assertThatThrownBy { client.containers().files().delete(params) }
            .isInstanceOf(NotFoundException::class.java)
            .hasMessageContaining("file expired")
    }

    @Test
    fun asyncRawDeleteRaisesRateLimitBeforeParsing() {
        stubFor(
            delete(urlEqualTo("/responses/resp_test"))
                .willReturn(
                    aResponse()
                        .withStatus(429)
                        .withBody("""{"error":{"message":"too many deletes"}}""")
                )
        )
        assertThatThrownBy {
                client.async().responses().withRawResponse().delete("resp_test").join()
            }
            .hasCauseInstanceOf(RateLimitException::class.java)
    }
}
