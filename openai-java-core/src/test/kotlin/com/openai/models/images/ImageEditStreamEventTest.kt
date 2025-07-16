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

internal class ImageEditStreamEventTest {

    @Test
    fun ofPartialImage() {
        val partialImage =
            ImageEditPartialImageEvent.builder()
                .b64Json("b64_json")
                .background(ImageEditPartialImageEvent.Background.TRANSPARENT)
                .createdAt(0L)
                .outputFormat(ImageEditPartialImageEvent.OutputFormat.PNG)
                .partialImageIndex(0L)
                .quality(ImageEditPartialImageEvent.Quality.LOW)
                .size(ImageEditPartialImageEvent.Size._1024X1024)
                .build()

        val imageEditStreamEvent = ImageEditStreamEvent.ofPartialImage(partialImage)

        assertThat(imageEditStreamEvent.partialImage()).contains(partialImage)
        assertThat(imageEditStreamEvent.completed()).isEmpty
    }

    @Test
    fun ofPartialImageRoundtrip() {
        val jsonMapper = jsonMapper()
        val imageEditStreamEvent =
            ImageEditStreamEvent.ofPartialImage(
                ImageEditPartialImageEvent.builder()
                    .b64Json("b64_json")
                    .background(ImageEditPartialImageEvent.Background.TRANSPARENT)
                    .createdAt(0L)
                    .outputFormat(ImageEditPartialImageEvent.OutputFormat.PNG)
                    .partialImageIndex(0L)
                    .quality(ImageEditPartialImageEvent.Quality.LOW)
                    .size(ImageEditPartialImageEvent.Size._1024X1024)
                    .build()
            )

        val roundtrippedImageEditStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(imageEditStreamEvent),
                jacksonTypeRef<ImageEditStreamEvent>(),
            )

        assertThat(roundtrippedImageEditStreamEvent).isEqualTo(imageEditStreamEvent)
    }

    @Test
    fun ofCompleted() {
        val completed =
            ImageEditCompletedEvent.builder()
                .b64Json("b64_json")
                .background(ImageEditCompletedEvent.Background.TRANSPARENT)
                .createdAt(0L)
                .outputFormat(ImageEditCompletedEvent.OutputFormat.PNG)
                .quality(ImageEditCompletedEvent.Quality.LOW)
                .size(ImageEditCompletedEvent.Size._1024X1024)
                .usage(
                    ImageEditCompletedEvent.Usage.builder()
                        .inputTokens(0L)
                        .inputTokensDetails(
                            ImageEditCompletedEvent.Usage.InputTokensDetails.builder()
                                .imageTokens(0L)
                                .textTokens(0L)
                                .build()
                        )
                        .outputTokens(0L)
                        .totalTokens(0L)
                        .build()
                )
                .build()

        val imageEditStreamEvent = ImageEditStreamEvent.ofCompleted(completed)

        assertThat(imageEditStreamEvent.partialImage()).isEmpty
        assertThat(imageEditStreamEvent.completed()).contains(completed)
    }

    @Test
    fun ofCompletedRoundtrip() {
        val jsonMapper = jsonMapper()
        val imageEditStreamEvent =
            ImageEditStreamEvent.ofCompleted(
                ImageEditCompletedEvent.builder()
                    .b64Json("b64_json")
                    .background(ImageEditCompletedEvent.Background.TRANSPARENT)
                    .createdAt(0L)
                    .outputFormat(ImageEditCompletedEvent.OutputFormat.PNG)
                    .quality(ImageEditCompletedEvent.Quality.LOW)
                    .size(ImageEditCompletedEvent.Size._1024X1024)
                    .usage(
                        ImageEditCompletedEvent.Usage.builder()
                            .inputTokens(0L)
                            .inputTokensDetails(
                                ImageEditCompletedEvent.Usage.InputTokensDetails.builder()
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

        val roundtrippedImageEditStreamEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(imageEditStreamEvent),
                jacksonTypeRef<ImageEditStreamEvent>(),
            )

        assertThat(roundtrippedImageEditStreamEvent).isEqualTo(imageEditStreamEvent)
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
        val imageEditStreamEvent =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<ImageEditStreamEvent>())

        val e = assertThrows<OpenAIInvalidDataException> { imageEditStreamEvent.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
