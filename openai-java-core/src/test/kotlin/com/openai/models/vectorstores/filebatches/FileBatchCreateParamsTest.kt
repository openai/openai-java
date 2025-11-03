// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores.filebatches

import com.openai.core.JsonValue
import com.openai.models.vectorstores.AutoFileChunkingStrategyParam
import com.openai.models.vectorstores.FileChunkingStrategyParam
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileBatchCreateParamsTest {

    @Test
    fun create() {
        FileBatchCreateParams.builder()
            .vectorStoreId("vs_abc123")
            .attributes(
                FileBatchCreateParams.Attributes.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
            .chunkingStrategy(AutoFileChunkingStrategyParam.builder().build())
            .addFileId("string")
            .addFile(
                FileBatchCreateParams.File.builder()
                    .fileId("file_id")
                    .attributes(
                        FileBatchCreateParams.File.Attributes.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .chunkingStrategy(AutoFileChunkingStrategyParam.builder().build())
                    .build()
            )
            .build()
    }

    @Test
    fun pathParams() {
        val params = FileBatchCreateParams.builder().vectorStoreId("vs_abc123").build()

        assertThat(params._pathParam(0)).isEqualTo("vs_abc123")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            FileBatchCreateParams.builder()
                .vectorStoreId("vs_abc123")
                .attributes(
                    FileBatchCreateParams.Attributes.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .chunkingStrategy(AutoFileChunkingStrategyParam.builder().build())
                .addFileId("string")
                .addFile(
                    FileBatchCreateParams.File.builder()
                        .fileId("file_id")
                        .attributes(
                            FileBatchCreateParams.File.Attributes.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .chunkingStrategy(AutoFileChunkingStrategyParam.builder().build())
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.attributes())
            .contains(
                FileBatchCreateParams.Attributes.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(body.chunkingStrategy())
            .contains(
                FileChunkingStrategyParam.ofAuto(AutoFileChunkingStrategyParam.builder().build())
            )
        assertThat(body.fileIds().getOrNull()).containsExactly("string")
        assertThat(body.files().getOrNull())
            .containsExactly(
                FileBatchCreateParams.File.builder()
                    .fileId("file_id")
                    .attributes(
                        FileBatchCreateParams.File.Attributes.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .chunkingStrategy(AutoFileChunkingStrategyParam.builder().build())
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = FileBatchCreateParams.builder().vectorStoreId("vs_abc123").build()

        val body = params._body()
    }
}
