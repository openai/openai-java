package com.openai.models.vectorstores.filebatches

import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class VectorStoreFileBatchCompatibilityTest {

    private val mapper = jsonMapper()

    private fun payload(value: String): String =
        """{
            "id": "vsfb_test", "object": "$value", "created_at": 123,
            "file_counts": {"cancelled": 0, "completed": 1, "failed": 0, "in_progress": 0, "total": 1},
            "status": "completed", "vector_store_id": "vs_test",
            "future_field": {"preserved": true}
        }"""

    private fun decode(json: String): VectorStoreFileBatch =
        mapper.readValue(json, VectorStoreFileBatch::class.java)

    @ParameterizedTest
    @ValueSource(strings = ["vector_store.file_batch", "vector_store.files_batch"])
    fun acceptsKnownSpellingsWithoutRewriting(value: String) {
        val json = payload(value)
        val batch = decode(json)
        assertThat(batch.validate()).isSameAs(batch)
        assertThat(batch.isValid()).isTrue()
        assertThat(batch._object_()).isEqualTo(JsonValue.from(value))
        assertThat(mapper.readTree(mapper.writeValueAsString(batch)))
            .isEqualTo(mapper.readTree(json))
        assertThat(batch.toBuilder().build()).isEqualTo(batch)
    }

    @ParameterizedTest
    @ValueSource(strings = ["\"unknown\"", "null", "123"])
    fun rejectsInvalidValuesButPreservesRawData(value: String) {
        val json = payload("vector_store.file_batch").replace("\"vector_store.file_batch\"", value)
        val batch = decode(json)
        assertThrows<OpenAIInvalidDataException> { batch.validate() }
        assertThat(batch.isValid()).isFalse()
        assertThat(mapper.readTree(mapper.writeValueAsString(batch)))
            .isEqualTo(mapper.readTree(json))
    }

    @Test
    fun preservesDefaultAndOtherValidation() {
        val json = payload("vector_store.files_batch")
        val missing = decode(json.replace("\"object\": \"vector_store.files_batch\",", ""))
        assertThrows<OpenAIInvalidDataException> { missing.validate() }
        val source = decode(json)
        val built =
            VectorStoreFileBatch.builder()
                .id(source.id())
                .createdAt(source.createdAt())
                .fileCounts(source.fileCounts())
                .status(source.status())
                .vectorStoreId(source.vectorStoreId())
                .build()
        assertThat(built._object_()).isEqualTo(JsonValue.from("vector_store.files_batch"))
        built.validate()
        val invalid =
            decode(payload("vector_store.file_batch").replace("\"completed\",", "\"unknown\","))
        assertThrows<OpenAIInvalidDataException> { invalid.validate() }
    }
}
