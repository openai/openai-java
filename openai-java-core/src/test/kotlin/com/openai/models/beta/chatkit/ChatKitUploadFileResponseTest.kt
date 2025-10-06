// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.chatkit

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class ChatKitUploadFileResponseTest {

    @Test
    fun ofFile() {
        val file =
            FilePart.builder()
                .id("id")
                .mimeType("mime_type")
                .name("name")
                .uploadUrl("upload_url")
                .build()

        val chatkitUploadFileResponse = ChatKitUploadFileResponse.ofFile(file)

        assertThat(chatkitUploadFileResponse.file()).contains(file)
        assertThat(chatkitUploadFileResponse.image()).isEmpty
    }

    @Test
    fun ofFileRoundtrip() {
        val jsonMapper = jsonMapper()
        val chatkitUploadFileResponse =
            ChatKitUploadFileResponse.ofFile(
                FilePart.builder()
                    .id("id")
                    .mimeType("mime_type")
                    .name("name")
                    .uploadUrl("upload_url")
                    .build()
            )

        val roundtrippedChatKitUploadFileResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatkitUploadFileResponse),
                jacksonTypeRef<ChatKitUploadFileResponse>(),
            )

        assertThat(roundtrippedChatKitUploadFileResponse).isEqualTo(chatkitUploadFileResponse)
    }

    @Test
    fun ofImage() {
        val image =
            ImagePart.builder()
                .id("id")
                .mimeType("mime_type")
                .name("name")
                .previewUrl("preview_url")
                .uploadUrl("upload_url")
                .build()

        val chatkitUploadFileResponse = ChatKitUploadFileResponse.ofImage(image)

        assertThat(chatkitUploadFileResponse.file()).isEmpty
        assertThat(chatkitUploadFileResponse.image()).contains(image)
    }

    @Test
    fun ofImageRoundtrip() {
        val jsonMapper = jsonMapper()
        val chatkitUploadFileResponse =
            ChatKitUploadFileResponse.ofImage(
                ImagePart.builder()
                    .id("id")
                    .mimeType("mime_type")
                    .name("name")
                    .previewUrl("preview_url")
                    .uploadUrl("upload_url")
                    .build()
            )

        val roundtrippedChatKitUploadFileResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(chatkitUploadFileResponse),
                jacksonTypeRef<ChatKitUploadFileResponse>(),
            )

        assertThat(roundtrippedChatKitUploadFileResponse).isEqualTo(chatkitUploadFileResponse)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val chatkitUploadFileResponse =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<ChatKitUploadFileResponse>())

        val e = assertThrows<OpenAIInvalidDataException> { chatkitUploadFileResponse.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
