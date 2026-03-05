// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class ComputerActionTest {

    @Test
    fun ofClick() {
        val click =
            ComputerAction.Click.builder()
                .button(ComputerAction.Click.Button.LEFT)
                .x(0L)
                .y(0L)
                .build()

        val computerAction = ComputerAction.ofClick(click)

        assertThat(computerAction.click()).contains(click)
        assertThat(computerAction.doubleClick()).isEmpty
        assertThat(computerAction.drag()).isEmpty
        assertThat(computerAction.keypress()).isEmpty
        assertThat(computerAction.move()).isEmpty
        assertThat(computerAction.screenshot()).isEmpty
        assertThat(computerAction.scroll()).isEmpty
        assertThat(computerAction.type()).isEmpty
        assertThat(computerAction.wait()).isEmpty
    }

    @Test
    fun ofClickRoundtrip() {
        val jsonMapper = jsonMapper()
        val computerAction =
            ComputerAction.ofClick(
                ComputerAction.Click.builder()
                    .button(ComputerAction.Click.Button.LEFT)
                    .x(0L)
                    .y(0L)
                    .build()
            )

        val roundtrippedComputerAction =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(computerAction),
                jacksonTypeRef<ComputerAction>(),
            )

        assertThat(roundtrippedComputerAction).isEqualTo(computerAction)
    }

    @Test
    fun ofDoubleClick() {
        val doubleClick = ComputerAction.DoubleClick.builder().x(0L).y(0L).build()

        val computerAction = ComputerAction.ofDoubleClick(doubleClick)

        assertThat(computerAction.click()).isEmpty
        assertThat(computerAction.doubleClick()).contains(doubleClick)
        assertThat(computerAction.drag()).isEmpty
        assertThat(computerAction.keypress()).isEmpty
        assertThat(computerAction.move()).isEmpty
        assertThat(computerAction.screenshot()).isEmpty
        assertThat(computerAction.scroll()).isEmpty
        assertThat(computerAction.type()).isEmpty
        assertThat(computerAction.wait()).isEmpty
    }

    @Test
    fun ofDoubleClickRoundtrip() {
        val jsonMapper = jsonMapper()
        val computerAction =
            ComputerAction.ofDoubleClick(ComputerAction.DoubleClick.builder().x(0L).y(0L).build())

        val roundtrippedComputerAction =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(computerAction),
                jacksonTypeRef<ComputerAction>(),
            )

        assertThat(roundtrippedComputerAction).isEqualTo(computerAction)
    }

    @Test
    fun ofDrag() {
        val drag =
            ComputerAction.Drag.builder()
                .addPath(ComputerAction.Drag.Path.builder().x(0L).y(0L).build())
                .build()

        val computerAction = ComputerAction.ofDrag(drag)

        assertThat(computerAction.click()).isEmpty
        assertThat(computerAction.doubleClick()).isEmpty
        assertThat(computerAction.drag()).contains(drag)
        assertThat(computerAction.keypress()).isEmpty
        assertThat(computerAction.move()).isEmpty
        assertThat(computerAction.screenshot()).isEmpty
        assertThat(computerAction.scroll()).isEmpty
        assertThat(computerAction.type()).isEmpty
        assertThat(computerAction.wait()).isEmpty
    }

    @Test
    fun ofDragRoundtrip() {
        val jsonMapper = jsonMapper()
        val computerAction =
            ComputerAction.ofDrag(
                ComputerAction.Drag.builder()
                    .addPath(ComputerAction.Drag.Path.builder().x(0L).y(0L).build())
                    .build()
            )

        val roundtrippedComputerAction =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(computerAction),
                jacksonTypeRef<ComputerAction>(),
            )

        assertThat(roundtrippedComputerAction).isEqualTo(computerAction)
    }

    @Test
    fun ofKeypress() {
        val keypress = ComputerAction.Keypress.builder().addKey("string").build()

        val computerAction = ComputerAction.ofKeypress(keypress)

        assertThat(computerAction.click()).isEmpty
        assertThat(computerAction.doubleClick()).isEmpty
        assertThat(computerAction.drag()).isEmpty
        assertThat(computerAction.keypress()).contains(keypress)
        assertThat(computerAction.move()).isEmpty
        assertThat(computerAction.screenshot()).isEmpty
        assertThat(computerAction.scroll()).isEmpty
        assertThat(computerAction.type()).isEmpty
        assertThat(computerAction.wait()).isEmpty
    }

    @Test
    fun ofKeypressRoundtrip() {
        val jsonMapper = jsonMapper()
        val computerAction =
            ComputerAction.ofKeypress(ComputerAction.Keypress.builder().addKey("string").build())

        val roundtrippedComputerAction =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(computerAction),
                jacksonTypeRef<ComputerAction>(),
            )

        assertThat(roundtrippedComputerAction).isEqualTo(computerAction)
    }

    @Test
    fun ofMove() {
        val move = ComputerAction.Move.builder().x(0L).y(0L).build()

        val computerAction = ComputerAction.ofMove(move)

        assertThat(computerAction.click()).isEmpty
        assertThat(computerAction.doubleClick()).isEmpty
        assertThat(computerAction.drag()).isEmpty
        assertThat(computerAction.keypress()).isEmpty
        assertThat(computerAction.move()).contains(move)
        assertThat(computerAction.screenshot()).isEmpty
        assertThat(computerAction.scroll()).isEmpty
        assertThat(computerAction.type()).isEmpty
        assertThat(computerAction.wait()).isEmpty
    }

    @Test
    fun ofMoveRoundtrip() {
        val jsonMapper = jsonMapper()
        val computerAction =
            ComputerAction.ofMove(ComputerAction.Move.builder().x(0L).y(0L).build())

        val roundtrippedComputerAction =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(computerAction),
                jacksonTypeRef<ComputerAction>(),
            )

        assertThat(roundtrippedComputerAction).isEqualTo(computerAction)
    }

    @Test
    fun ofScreenshot() {
        val computerAction = ComputerAction.ofScreenshot()

        assertThat(computerAction.click()).isEmpty
        assertThat(computerAction.doubleClick()).isEmpty
        assertThat(computerAction.drag()).isEmpty
        assertThat(computerAction.keypress()).isEmpty
        assertThat(computerAction.move()).isEmpty
        assertThat(computerAction.screenshot())
            .contains(JsonValue.from(mapOf("type" to "screenshot")))
        assertThat(computerAction.scroll()).isEmpty
        assertThat(computerAction.type()).isEmpty
        assertThat(computerAction.wait()).isEmpty
    }

    @Test
    fun ofScreenshotRoundtrip() {
        val jsonMapper = jsonMapper()
        val computerAction = ComputerAction.ofScreenshot()

        val roundtrippedComputerAction =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(computerAction),
                jacksonTypeRef<ComputerAction>(),
            )

        assertThat(roundtrippedComputerAction).isEqualTo(computerAction)
    }

    @Test
    fun ofScroll() {
        val scroll = ComputerAction.Scroll.builder().scrollX(0L).scrollY(0L).x(0L).y(0L).build()

        val computerAction = ComputerAction.ofScroll(scroll)

        assertThat(computerAction.click()).isEmpty
        assertThat(computerAction.doubleClick()).isEmpty
        assertThat(computerAction.drag()).isEmpty
        assertThat(computerAction.keypress()).isEmpty
        assertThat(computerAction.move()).isEmpty
        assertThat(computerAction.screenshot()).isEmpty
        assertThat(computerAction.scroll()).contains(scroll)
        assertThat(computerAction.type()).isEmpty
        assertThat(computerAction.wait()).isEmpty
    }

    @Test
    fun ofScrollRoundtrip() {
        val jsonMapper = jsonMapper()
        val computerAction =
            ComputerAction.ofScroll(
                ComputerAction.Scroll.builder().scrollX(0L).scrollY(0L).x(0L).y(0L).build()
            )

        val roundtrippedComputerAction =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(computerAction),
                jacksonTypeRef<ComputerAction>(),
            )

        assertThat(roundtrippedComputerAction).isEqualTo(computerAction)
    }

    @Test
    fun ofType() {
        val type = ComputerAction.Type.builder().text("text").build()

        val computerAction = ComputerAction.ofType(type)

        assertThat(computerAction.click()).isEmpty
        assertThat(computerAction.doubleClick()).isEmpty
        assertThat(computerAction.drag()).isEmpty
        assertThat(computerAction.keypress()).isEmpty
        assertThat(computerAction.move()).isEmpty
        assertThat(computerAction.screenshot()).isEmpty
        assertThat(computerAction.scroll()).isEmpty
        assertThat(computerAction.type()).contains(type)
        assertThat(computerAction.wait()).isEmpty
    }

    @Test
    fun ofTypeRoundtrip() {
        val jsonMapper = jsonMapper()
        val computerAction =
            ComputerAction.ofType(ComputerAction.Type.builder().text("text").build())

        val roundtrippedComputerAction =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(computerAction),
                jacksonTypeRef<ComputerAction>(),
            )

        assertThat(roundtrippedComputerAction).isEqualTo(computerAction)
    }

    @Test
    fun ofWait() {
        val computerAction = ComputerAction.ofWait()

        assertThat(computerAction.click()).isEmpty
        assertThat(computerAction.doubleClick()).isEmpty
        assertThat(computerAction.drag()).isEmpty
        assertThat(computerAction.keypress()).isEmpty
        assertThat(computerAction.move()).isEmpty
        assertThat(computerAction.screenshot()).isEmpty
        assertThat(computerAction.scroll()).isEmpty
        assertThat(computerAction.type()).isEmpty
        assertThat(computerAction.wait()).contains(JsonValue.from(mapOf("type" to "wait")))
    }

    @Test
    fun ofWaitRoundtrip() {
        val jsonMapper = jsonMapper()
        val computerAction = ComputerAction.ofWait()

        val roundtrippedComputerAction =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(computerAction),
                jacksonTypeRef<ComputerAction>(),
            )

        assertThat(roundtrippedComputerAction).isEqualTo(computerAction)
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
        val computerAction =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<ComputerAction>())

        val e = assertThrows<OpenAIInvalidDataException> { computerAction.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
