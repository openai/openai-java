package com.openai.core.http

import com.openai.client.OpenAIClientImpl
import com.openai.core.ClientOptions
import com.openai.errors.InvalidResourceIdException
import com.openai.models.vectorstores.files.FileDeleteParams
import java.util.concurrent.ExecutionException
import java.util.concurrent.TimeUnit
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.mockito.kotlin.mock
import org.mockito.kotlin.verifyNoInteractions

internal class ResourcePathValidationTest {
    @ParameterizedTest
    @ValueSource(strings = ["", ".", ".."])
    fun invalidIdsAreRejectedBeforeCustomTransport(fileId: String) {
        val transport = mock<HttpClient>()
        val client =
            OpenAIClientImpl(
                ClientOptions.builder().httpClient(transport).apiKey("test-api-key").build()
            )
        val params = FileDeleteParams.builder().vectorStoreId("store-test").fileId(fileId).build()

        assertThrows<InvalidResourceIdException> { client.vectorStores().files().delete(params) }
        val future = client.async().vectorStores().files().delete(params)
        assertThat(assertThrows<ExecutionException> { future.get(5, TimeUnit.SECONDS) }.cause)
            .isInstanceOf(InvalidResourceIdException::class.java)
        verifyNoInteractions(transport)
    }
}
