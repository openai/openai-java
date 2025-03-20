// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores.files

import com.openai.core.JsonValue
import com.openai.models.vectorstores.AutoFileChunkingStrategyParam
import com.openai.models.vectorstores.FileChunkingStrategyParam
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileCreateParamsTest {

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
    fun pathParams() {
        val params = FileCreateParams.builder().vectorStoreId("vs_abc123").fileId("file_id").build()

        assertThat(params._pathParam(0)).isEqualTo("vs_abc123")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
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

        assertThat(body.fileId()).isEqualTo("file_id")
    }
}
