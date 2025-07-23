// File generated from our OpenAPI spec by Stainless.

package com.openai.models.images

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class ImageGenStreamEventTest {

    @Test
    fun ofGenerationPartialImage() {
        val generationPartialImage =
            ImageGenPartialImageEvent.builder()
                .b64Json("b64_json")
                .background(ImageGenPartialImageEvent.Background.TRANSPARENT)
                .createdAt(0L)
                .outputFormat(ImageGenPartialImageEvent.OutputFormat.PNG)
                .partialImageIndex(0L)
                .quality(ImageGenPartialImageEvent.Quality.LOW)
                .size(ImageGenPartialImageEvent.Size._1024X1024)
                .build()

        val imageGenStreamEvent =
            ImageGenStreamEvent.ofGenerationPartialImage(generationPartialImage)

        assertThat(imageGenStreamEvent.generationPartialImage()).contains(generationPartialImage)
        assertThat(imageGenStreamEvent.generationCompleted()).isEmpty
    }

    @Test
    fun ofGenerationPartialImageRoundtrip() {
        val jsonMapper = jsonMapper()
        val imageGenStreamEvent =
            ImageGenStreamEvent.ofGenerationPartialImage(
                ImageGenPartialImageEvent.builder()
                    .b64Json("b64_json")
                    .background(ImageGenPartialImageEvent.Background.TRANSPARENT)
                    .createdAt(0L)
                    .outputFormat(ImageGenPartialImageEvent.OutputFormat.PNG)
                    .partialImageIndex(0L)
                    .quality(ImageGenPartialImageEvent.Quality.LOW)
                    .size(ImageGenPartialImageEvent.Size._1024X1024)
                    .build()
            )

        val roundtrippedImageGenStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(imageGenStreamEvent),
                jacksonTypeRef<ImageGenStreamEvent>(),
            )

        assertThat(roundtrippedImageGenStreamEvent).isEqualTo(imageGenStreamEvent)
    }

    @Test
    fun ofGenerationCompleted() {
        val generationCompleted =
            ImageGenCompletedEvent.builder()
                .b64Json("b64_json")
                .background(ImageGenCompletedEvent.Background.TRANSPARENT)
                .createdAt(0L)
                .outputFormat(ImageGenCompletedEvent.OutputFormat.PNG)
                .quality(ImageGenCompletedEvent.Quality.LOW)
                .size(ImageGenCompletedEvent.Size._1024X1024)
                .usage(
                    ImageGenCompletedEvent.Usage.builder()
                        .inputTokens(0L)
                        .inputTokensDetails(
                            ImageGenCompletedEvent.Usage.InputTokensDetails.builder()
                                .imageTokens(0L)
                                .textTokens(0L)
                                .build()
                        )
                        .outputTokens(0L)
                        .totalTokens(0L)
                        .build()
                )
                .build()

        val imageGenStreamEvent = ImageGenStreamEvent.ofGenerationCompleted(generationCompleted)

        assertThat(imageGenStreamEvent.generationPartialImage()).isEmpty
        assertThat(imageGenStreamEvent.generationCompleted()).contains(generationCompleted)
    }

    @Test
    fun ofGenerationCompletedRoundtrip() {
        val jsonMapper = jsonMapper()
        val imageGenStreamEvent =
            ImageGenStreamEvent.ofGenerationCompleted(
                ImageGenCompletedEvent.builder()
                    .b64Json("b64_json")
                    .background(ImageGenCompletedEvent.Background.TRANSPARENT)
                    .createdAt(0L)
                    .outputFormat(ImageGenCompletedEvent.OutputFormat.PNG)
                    .quality(ImageGenCompletedEvent.Quality.LOW)
                    .size(ImageGenCompletedEvent.Size._1024X1024)
                    .usage(
                        ImageGenCompletedEvent.Usage.builder()
                            .inputTokens(0L)
                            .inputTokensDetails(
                                ImageGenCompletedEvent.Usage.InputTokensDetails.builder()
                                    .imageTokens(0L)
                                    .textTokens(0L)
                                    .build()
                            )
                            .outputTokens(0L)
                            .totalTokens(0L)
                            .build()
                    )
                    .build()
            )

        val roundtrippedImageGenStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(imageGenStreamEvent),
                jacksonTypeRef<ImageGenStreamEvent>(),
            )

        assertThat(roundtrippedImageGenStreamEvent).isEqualTo(imageGenStreamEvent)
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
        val imageGenStreamEvent =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<ImageGenStreamEvent>())

        val e = assertThrows<OpenAIInvalidDataException> { imageGenStreamEvent.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
