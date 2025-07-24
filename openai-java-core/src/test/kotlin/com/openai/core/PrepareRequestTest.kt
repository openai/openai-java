package com.openai.core

import com.openai.models.chat.completions.ChatCompletionListParams
import com.openai.models.embeddings.EmbeddingCreateParams
import com.openai.models.embeddings.EmbeddingModel
import com.openai.models.uploads.UploadCancelParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PrepareRequestTest {
    @Test
    fun noModelFunction() {
        val params = UploadCancelParams.builder().uploadId("my-upload-id").build()

        assertThat(params.modelNameOrNull()).isNull()
    }

    @Test
    fun modelLiteralNotNull() {
        val params =
            EmbeddingCreateParams.builder().model("my-model").input("Hello, world!").build()

        assertThat(params.modelNameOrNull()).isNotNull()
        assertThat(params.modelNameOrNull()).isEqualTo("my-model")
    }

    @Test
    fun modelEnumNotNull() {
        val params =
            EmbeddingCreateParams.builder()
                .model(EmbeddingModel.TEXT_EMBEDDING_3_LARGE)
                .input("Hello, world!")
                .build()

        assertThat(params.modelNameOrNull()).isNotNull()
        assertThat(params.modelNameOrNull()).isEqualTo("text-embedding-3-large")
    }

    @Test
    fun modelNull() {
        // There are no instances where a `Params.model()` returns a nullable value. If a model can
        // be `null`, it is always returned in a non-nullable `Optional`.
    }

    @Test
    fun modelOptionalNotNull() {
        val params = ChatCompletionListParams.builder().model("my-model-id").build()

        assertThat(params.modelNameOrNull()).isNotNull()
        assertThat(params.modelNameOrNull()).isEqualTo("my-model-id")
    }

    @Test
    fun modelOptionalNull() {
        // Test the same type of `Params` with and without `null`, to ensure `model()` is being
        // detected, but its `null` value is correctly returned when set. (Rather than `model()`
        // not being detected, which would also return `null`.)
        val params1 = ChatCompletionListParams.builder().model("my-model-id").build()
        val params2 = ChatCompletionListParams.builder().model(null).build()

        assertThat(params1.modelNameOrNull()).isNotNull()
        assertThat(params1.modelNameOrNull()).isEqualTo("my-model-id")

        assertThat(params2.modelNameOrNull()).isNull()
    }
}
