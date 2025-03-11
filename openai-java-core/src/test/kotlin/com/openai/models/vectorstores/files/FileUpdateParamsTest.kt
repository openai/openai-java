// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores.files

import com.openai.core.JsonValue
import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FileUpdateParamsTest {

    @Test
    fun create() {
        FileUpdateParams.builder()
            .vectorStoreId("vs_abc123")
            .fileId("file-abc123")
            .attributes(
                FileUpdateParams.Attributes.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            FileUpdateParams.builder()
                .vectorStoreId("vs_abc123")
                .fileId("file-abc123")
                .attributes(
                    FileUpdateParams.Attributes.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.attributes())
            .contains(
                FileUpdateParams.Attributes.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            FileUpdateParams.builder()
                .vectorStoreId("vs_abc123")
                .fileId("file-abc123")
                .attributes(
                    FileUpdateParams.Attributes.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.attributes())
            .contains(
                FileUpdateParams.Attributes.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
    }

    @Test
    fun getPathParam() {
        val params =
            FileUpdateParams.builder()
                .vectorStoreId("vs_abc123")
                .fileId("file-abc123")
                .attributes(
                    FileUpdateParams.Attributes.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .build()
        assertThat(params).isNotNull
        // path param "vectorStoreId"
        assertThat(params.getPathParam(0)).isEqualTo("vs_abc123")
        // path param "fileId"
        assertThat(params.getPathParam(1)).isEqualTo("file-abc123")
        // out-of-bound path param
        assertThat(params.getPathParam(2)).isEqualTo("")
    }
}
