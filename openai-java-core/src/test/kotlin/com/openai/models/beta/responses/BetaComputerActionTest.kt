// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class BetaComputerActionTest {

    @Test
    fun ofClick() {
        val click =
            BetaComputerAction.Click.builder()
                .button(BetaComputerAction.Click.Button.LEFT)
                .x(0L)
                .y(0L)
                .addKey("string")
                .build()

        val betaComputerAction = BetaComputerAction.ofClick(click)

        assertThat(betaComputerAction.click()).contains(click)
        assertThat(betaComputerAction.doubleClick()).isEmpty
        assertThat(betaComputerAction.drag()).isEmpty
        assertThat(betaComputerAction.keypress()).isEmpty
        assertThat(betaComputerAction.move()).isEmpty
        assertThat(betaComputerAction.screenshot()).isEmpty
        assertThat(betaComputerAction.scroll()).isEmpty
        assertThat(betaComputerAction.type()).isEmpty
        assertThat(betaComputerAction.wait()).isEmpty
    }

    @Test
    fun ofClickRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaComputerAction =
            BetaComputerAction.ofClick(
                BetaComputerAction.Click.builder()
                    .button(BetaComputerAction.Click.Button.LEFT)
                    .x(0L)
                    .y(0L)
                    .addKey("string")
                    .build()
            )

        val roundtrippedBetaComputerAction =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaComputerAction),
                jacksonTypeRef<BetaComputerAction>(),
            )

        assertThat(roundtrippedBetaComputerAction).isEqualTo(betaComputerAction)
    }

    @Test
    fun ofDoubleClick() {
        val doubleClick =
            BetaComputerAction.DoubleClick.builder().addKey("string").x(0L).y(0L).build()

        val betaComputerAction = BetaComputerAction.ofDoubleClick(doubleClick)

        assertThat(betaComputerAction.click()).isEmpty
        assertThat(betaComputerAction.doubleClick()).contains(doubleClick)
        assertThat(betaComputerAction.drag()).isEmpty
        assertThat(betaComputerAction.keypress()).isEmpty
        assertThat(betaComputerAction.move()).isEmpty
        assertThat(betaComputerAction.screenshot()).isEmpty
        assertThat(betaComputerAction.scroll()).isEmpty
        assertThat(betaComputerAction.type()).isEmpty
        assertThat(betaComputerAction.wait()).isEmpty
    }

    @Test
    fun ofDoubleClickRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaComputerAction =
            BetaComputerAction.ofDoubleClick(
                BetaComputerAction.DoubleClick.builder().addKey("string").x(0L).y(0L).build()
            )

        val roundtrippedBetaComputerAction =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaComputerAction),
                jacksonTypeRef<BetaComputerAction>(),
            )

        assertThat(roundtrippedBetaComputerAction).isEqualTo(betaComputerAction)
    }

    @Test
    fun ofDrag() {
        val drag =
            BetaComputerAction.Drag.builder()
                .addPath(BetaComputerAction.Drag.Path.builder().x(0L).y(0L).build())
                .addKey("string")
                .build()

        val betaComputerAction = BetaComputerAction.ofDrag(drag)

        assertThat(betaComputerAction.click()).isEmpty
        assertThat(betaComputerAction.doubleClick()).isEmpty
        assertThat(betaComputerAction.drag()).contains(drag)
        assertThat(betaComputerAction.keypress()).isEmpty
        assertThat(betaComputerAction.move()).isEmpty
        assertThat(betaComputerAction.screenshot()).isEmpty
        assertThat(betaComputerAction.scroll()).isEmpty
        assertThat(betaComputerAction.type()).isEmpty
        assertThat(betaComputerAction.wait()).isEmpty
    }

    @Test
    fun ofDragRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaComputerAction =
            BetaComputerAction.ofDrag(
                BetaComputerAction.Drag.builder()
                    .addPath(BetaComputerAction.Drag.Path.builder().x(0L).y(0L).build())
                    .addKey("string")
                    .build()
            )

        val roundtrippedBetaComputerAction =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaComputerAction),
                jacksonTypeRef<BetaComputerAction>(),
            )

        assertThat(roundtrippedBetaComputerAction).isEqualTo(betaComputerAction)
    }

    @Test
    fun ofKeypress() {
        val keypress = BetaComputerAction.Keypress.builder().addKey("string").build()

        val betaComputerAction = BetaComputerAction.ofKeypress(keypress)

        assertThat(betaComputerAction.click()).isEmpty
        assertThat(betaComputerAction.doubleClick()).isEmpty
        assertThat(betaComputerAction.drag()).isEmpty
        assertThat(betaComputerAction.keypress()).contains(keypress)
        assertThat(betaComputerAction.move()).isEmpty
        assertThat(betaComputerAction.screenshot()).isEmpty
        assertThat(betaComputerAction.scroll()).isEmpty
        assertThat(betaComputerAction.type()).isEmpty
        assertThat(betaComputerAction.wait()).isEmpty
    }

    @Test
    fun ofKeypressRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaComputerAction =
            BetaComputerAction.ofKeypress(
                BetaComputerAction.Keypress.builder().addKey("string").build()
            )

        val roundtrippedBetaComputerAction =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaComputerAction),
                jacksonTypeRef<BetaComputerAction>(),
            )

        assertThat(roundtrippedBetaComputerAction).isEqualTo(betaComputerAction)
    }

    @Test
    fun ofMove() {
        val move = BetaComputerAction.Move.builder().x(0L).y(0L).addKey("string").build()

        val betaComputerAction = BetaComputerAction.ofMove(move)

        assertThat(betaComputerAction.click()).isEmpty
        assertThat(betaComputerAction.doubleClick()).isEmpty
        assertThat(betaComputerAction.drag()).isEmpty
        assertThat(betaComputerAction.keypress()).isEmpty
        assertThat(betaComputerAction.move()).contains(move)
        assertThat(betaComputerAction.screenshot()).isEmpty
        assertThat(betaComputerAction.scroll()).isEmpty
        assertThat(betaComputerAction.type()).isEmpty
        assertThat(betaComputerAction.wait()).isEmpty
    }

    @Test
    fun ofMoveRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaComputerAction =
            BetaComputerAction.ofMove(
                BetaComputerAction.Move.builder().x(0L).y(0L).addKey("string").build()
            )

        val roundtrippedBetaComputerAction =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaComputerAction),
                jacksonTypeRef<BetaComputerAction>(),
            )

        assertThat(roundtrippedBetaComputerAction).isEqualTo(betaComputerAction)
    }

    @Test
    fun ofScreenshot() {
        val betaComputerAction = BetaComputerAction.ofScreenshot()

        assertThat(betaComputerAction.click()).isEmpty
        assertThat(betaComputerAction.doubleClick()).isEmpty
        assertThat(betaComputerAction.drag()).isEmpty
        assertThat(betaComputerAction.keypress()).isEmpty
        assertThat(betaComputerAction.move()).isEmpty
        assertThat(betaComputerAction.screenshot())
            .contains(JsonValue.from(mapOf("type" to "screenshot")))
        assertThat(betaComputerAction.scroll()).isEmpty
        assertThat(betaComputerAction.type()).isEmpty
        assertThat(betaComputerAction.wait()).isEmpty
    }

    @Test
    fun ofScreenshotRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaComputerAction = BetaComputerAction.ofScreenshot()

        val roundtrippedBetaComputerAction =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaComputerAction),
                jacksonTypeRef<BetaComputerAction>(),
            )

        assertThat(roundtrippedBetaComputerAction).isEqualTo(betaComputerAction)
    }

    @Test
    fun ofScroll() {
        val scroll =
            BetaComputerAction.Scroll.builder()
                .scrollX(0L)
                .scrollY(0L)
                .x(0L)
                .y(0L)
                .addKey("string")
                .build()

        val betaComputerAction = BetaComputerAction.ofScroll(scroll)

        assertThat(betaComputerAction.click()).isEmpty
        assertThat(betaComputerAction.doubleClick()).isEmpty
        assertThat(betaComputerAction.drag()).isEmpty
        assertThat(betaComputerAction.keypress()).isEmpty
        assertThat(betaComputerAction.move()).isEmpty
        assertThat(betaComputerAction.screenshot()).isEmpty
        assertThat(betaComputerAction.scroll()).contains(scroll)
        assertThat(betaComputerAction.type()).isEmpty
        assertThat(betaComputerAction.wait()).isEmpty
    }

    @Test
    fun ofScrollRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaComputerAction =
            BetaComputerAction.ofScroll(
                BetaComputerAction.Scroll.builder()
                    .scrollX(0L)
                    .scrollY(0L)
                    .x(0L)
                    .y(0L)
                    .addKey("string")
                    .build()
            )

        val roundtrippedBetaComputerAction =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaComputerAction),
                jacksonTypeRef<BetaComputerAction>(),
            )

        assertThat(roundtrippedBetaComputerAction).isEqualTo(betaComputerAction)
    }

    @Test
    fun ofType() {
        val type = BetaComputerAction.Type.builder().text("text").build()

        val betaComputerAction = BetaComputerAction.ofType(type)

        assertThat(betaComputerAction.click()).isEmpty
        assertThat(betaComputerAction.doubleClick()).isEmpty
        assertThat(betaComputerAction.drag()).isEmpty
        assertThat(betaComputerAction.keypress()).isEmpty
        assertThat(betaComputerAction.move()).isEmpty
        assertThat(betaComputerAction.screenshot()).isEmpty
        assertThat(betaComputerAction.scroll()).isEmpty
        assertThat(betaComputerAction.type()).contains(type)
        assertThat(betaComputerAction.wait()).isEmpty
    }

    @Test
    fun ofTypeRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaComputerAction =
            BetaComputerAction.ofType(BetaComputerAction.Type.builder().text("text").build())

        val roundtrippedBetaComputerAction =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaComputerAction),
                jacksonTypeRef<BetaComputerAction>(),
            )

        assertThat(roundtrippedBetaComputerAction).isEqualTo(betaComputerAction)
    }

    @Test
    fun ofWait() {
        val betaComputerAction = BetaComputerAction.ofWait()

        assertThat(betaComputerAction.click()).isEmpty
        assertThat(betaComputerAction.doubleClick()).isEmpty
        assertThat(betaComputerAction.drag()).isEmpty
        assertThat(betaComputerAction.keypress()).isEmpty
        assertThat(betaComputerAction.move()).isEmpty
        assertThat(betaComputerAction.screenshot()).isEmpty
        assertThat(betaComputerAction.scroll()).isEmpty
        assertThat(betaComputerAction.type()).isEmpty
        assertThat(betaComputerAction.wait()).contains(JsonValue.from(mapOf("type" to "wait")))
    }

    @Test
    fun ofWaitRoundtrip() {
        val jsonMapper = jsonMapper()
        val betaComputerAction = BetaComputerAction.ofWait()

        val roundtrippedBetaComputerAction =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaComputerAction),
                jacksonTypeRef<BetaComputerAction>(),
            )

        assertThat(roundtrippedBetaComputerAction).isEqualTo(betaComputerAction)
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
        val betaComputerAction =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<BetaComputerAction>())

        val e = assertThrows<OpenAIInvalidDataException> { betaComputerAction.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
