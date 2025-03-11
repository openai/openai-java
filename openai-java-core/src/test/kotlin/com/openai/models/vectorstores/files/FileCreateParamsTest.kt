// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores.files

import com.openai.core.JsonValue
import com.openai.models.vectorstores.AutoFileChunkingStrategyParam
import com.openai.models.vectorstores.FileChunkingStrategyParam
import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FileCreateParamsTest {

    @Test
    fun create() {
        FileCreateParams.builder()
            .vectorStoreId("vs_abc123")
            .fileId("file_id")
            .attributes(
                FileCreateParams.Attributes.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
            .chunkingStrategy(AutoFileChunkingStrategyParam.builder().build())
            .build()
    }

    @Test
    fun body() {
        val params =
            FileCreateParams.builder()
                .vectorStoreId("vs_abc123")
                .fileId("file_id")
                .attributes(
                    FileCreateParams.Attributes.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .chunkingStrategy(AutoFileChunkingStrategyParam.builder().build())
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.fileId()).isEqualTo("file_id")
        assertThat(body.attributes())
            .contains(
                FileCreateParams.Attributes.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(body.chunkingStrategy())
            .contains(
                FileChunkingStrategyParam.ofAuto(AutoFileChunkingStrategyParam.builder().build())
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = FileCreateParams.builder().vectorStoreId("vs_abc123").fileId("file_id").build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.fileId()).isEqualTo("file_id")
    }

    @Test
    fun getPathParam() {
        val params = FileCreateParams.builder().vectorStoreId("vs_abc123").fileId("file_id").build()
        assertThat(params).isNotNull
        // path param "vectorStoreId"
        assertThat(params.getPathParam(0)).isEqualTo("vs_abc123")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
