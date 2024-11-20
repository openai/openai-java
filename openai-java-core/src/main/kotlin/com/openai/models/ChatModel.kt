// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.openai.core.Enum
import com.openai.core.JsonField
import com.openai.core.JsonValue
import com.openai.errors.OpenAIInvalidDataException

class ChatModel
@JsonCreator
private constructor(
    private val value: JsonField<String>,
) : Enum {

    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatModel && value == other.value /* spotless:on */
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()

    companion object {

        @JvmField val O1_PREVIEW = ChatModel(JsonField.of("o1-preview"))

        @JvmField val O1_PREVIEW_2024_09_12 = ChatModel(JsonField.of("o1-preview-2024-09-12"))

        @JvmField val O1_MINI = ChatModel(JsonField.of("o1-mini"))

        @JvmField val O1_MINI_2024_09_12 = ChatModel(JsonField.of("o1-mini-2024-09-12"))

        @JvmField val GPT_4O = ChatModel(JsonField.of("gpt-4o"))

        @JvmField val GPT_4O_2024_11_20 = ChatModel(JsonField.of("gpt-4o-2024-11-20"))

        @JvmField val GPT_4O_2024_08_06 = ChatModel(JsonField.of("gpt-4o-2024-08-06"))

        @JvmField val GPT_4O_2024_05_13 = ChatModel(JsonField.of("gpt-4o-2024-05-13"))

        @JvmField val GPT_4O_REALTIME_PREVIEW = ChatModel(JsonField.of("gpt-4o-realtime-preview"))

        @JvmField
        val GPT_4O_REALTIME_PREVIEW_2024_10_01 =
            ChatModel(JsonField.of("gpt-4o-realtime-preview-2024-10-01"))

        @JvmField val GPT_4O_AUDIO_PREVIEW = ChatModel(JsonField.of("gpt-4o-audio-preview"))

        @JvmField
        val GPT_4O_AUDIO_PREVIEW_2024_10_01 =
            ChatModel(JsonField.of("gpt-4o-audio-preview-2024-10-01"))

        @JvmField val CHATGPT_4O_LATEST = ChatModel(JsonField.of("chatgpt-4o-latest"))

        @JvmField val GPT_4O_MINI = ChatModel(JsonField.of("gpt-4o-mini"))

        @JvmField val GPT_4O_MINI_2024_07_18 = ChatModel(JsonField.of("gpt-4o-mini-2024-07-18"))

        @JvmField val GPT_4_TURBO = ChatModel(JsonField.of("gpt-4-turbo"))

        @JvmField val GPT_4_TURBO_2024_04_09 = ChatModel(JsonField.of("gpt-4-turbo-2024-04-09"))

        @JvmField val GPT_4_0125_PREVIEW = ChatModel(JsonField.of("gpt-4-0125-preview"))

        @JvmField val GPT_4_TURBO_PREVIEW = ChatModel(JsonField.of("gpt-4-turbo-preview"))

        @JvmField val GPT_4_1106_PREVIEW = ChatModel(JsonField.of("gpt-4-1106-preview"))

        @JvmField val GPT_4_VISION_PREVIEW = ChatModel(JsonField.of("gpt-4-vision-preview"))

        @JvmField val GPT_4 = ChatModel(JsonField.of("gpt-4"))

        @JvmField val GPT_4_0314 = ChatModel(JsonField.of("gpt-4-0314"))

        @JvmField val GPT_4_0613 = ChatModel(JsonField.of("gpt-4-0613"))

        @JvmField val GPT_4_32K = ChatModel(JsonField.of("gpt-4-32k"))

        @JvmField val GPT_4_32K_0314 = ChatModel(JsonField.of("gpt-4-32k-0314"))

        @JvmField val GPT_4_32K_0613 = ChatModel(JsonField.of("gpt-4-32k-0613"))

        @JvmField val GPT_3_5_TURBO = ChatModel(JsonField.of("gpt-3.5-turbo"))

        @JvmField val GPT_3_5_TURBO_16K = ChatModel(JsonField.of("gpt-3.5-turbo-16k"))

        @JvmField val GPT_3_5_TURBO_0301 = ChatModel(JsonField.of("gpt-3.5-turbo-0301"))

        @JvmField val GPT_3_5_TURBO_0613 = ChatModel(JsonField.of("gpt-3.5-turbo-0613"))

        @JvmField val GPT_3_5_TURBO_1106 = ChatModel(JsonField.of("gpt-3.5-turbo-1106"))

        @JvmField val GPT_3_5_TURBO_0125 = ChatModel(JsonField.of("gpt-3.5-turbo-0125"))

        @JvmField val GPT_3_5_TURBO_16K_0613 = ChatModel(JsonField.of("gpt-3.5-turbo-16k-0613"))

        @JvmStatic fun of(value: String) = ChatModel(JsonField.of(value))
    }

    enum class Known {
        O1_PREVIEW,
        O1_PREVIEW_2024_09_12,
        O1_MINI,
        O1_MINI_2024_09_12,
        GPT_4O,
        GPT_4O_2024_11_20,
        GPT_4O_2024_08_06,
        GPT_4O_2024_05_13,
        GPT_4O_REALTIME_PREVIEW,
        GPT_4O_REALTIME_PREVIEW_2024_10_01,
        GPT_4O_AUDIO_PREVIEW,
        GPT_4O_AUDIO_PREVIEW_2024_10_01,
        CHATGPT_4O_LATEST,
        GPT_4O_MINI,
        GPT_4O_MINI_2024_07_18,
        GPT_4_TURBO,
        GPT_4_TURBO_2024_04_09,
        GPT_4_0125_PREVIEW,
        GPT_4_TURBO_PREVIEW,
        GPT_4_1106_PREVIEW,
        GPT_4_VISION_PREVIEW,
        GPT_4,
        GPT_4_0314,
        GPT_4_0613,
        GPT_4_32K,
        GPT_4_32K_0314,
        GPT_4_32K_0613,
        GPT_3_5_TURBO,
        GPT_3_5_TURBO_16K,
        GPT_3_5_TURBO_0301,
        GPT_3_5_TURBO_0613,
        GPT_3_5_TURBO_1106,
        GPT_3_5_TURBO_0125,
        GPT_3_5_TURBO_16K_0613,
    }

    enum class Value {
        O1_PREVIEW,
        O1_PREVIEW_2024_09_12,
        O1_MINI,
        O1_MINI_2024_09_12,
        GPT_4O,
        GPT_4O_2024_11_20,
        GPT_4O_2024_08_06,
        GPT_4O_2024_05_13,
        GPT_4O_REALTIME_PREVIEW,
        GPT_4O_REALTIME_PREVIEW_2024_10_01,
        GPT_4O_AUDIO_PREVIEW,
        GPT_4O_AUDIO_PREVIEW_2024_10_01,
        CHATGPT_4O_LATEST,
        GPT_4O_MINI,
        GPT_4O_MINI_2024_07_18,
        GPT_4_TURBO,
        GPT_4_TURBO_2024_04_09,
        GPT_4_0125_PREVIEW,
        GPT_4_TURBO_PREVIEW,
        GPT_4_1106_PREVIEW,
        GPT_4_VISION_PREVIEW,
        GPT_4,
        GPT_4_0314,
        GPT_4_0613,
        GPT_4_32K,
        GPT_4_32K_0314,
        GPT_4_32K_0613,
        GPT_3_5_TURBO,
        GPT_3_5_TURBO_16K,
        GPT_3_5_TURBO_0301,
        GPT_3_5_TURBO_0613,
        GPT_3_5_TURBO_1106,
        GPT_3_5_TURBO_0125,
        GPT_3_5_TURBO_16K_0613,
        _UNKNOWN,
    }

    fun value(): Value =
        when (this) {
            O1_PREVIEW -> Value.O1_PREVIEW
            O1_PREVIEW_2024_09_12 -> Value.O1_PREVIEW_2024_09_12
            O1_MINI -> Value.O1_MINI
            O1_MINI_2024_09_12 -> Value.O1_MINI_2024_09_12
            GPT_4O -> Value.GPT_4O
            GPT_4O_2024_11_20 -> Value.GPT_4O_2024_11_20
            GPT_4O_2024_08_06 -> Value.GPT_4O_2024_08_06
            GPT_4O_2024_05_13 -> Value.GPT_4O_2024_05_13
            GPT_4O_REALTIME_PREVIEW -> Value.GPT_4O_REALTIME_PREVIEW
            GPT_4O_REALTIME_PREVIEW_2024_10_01 -> Value.GPT_4O_REALTIME_PREVIEW_2024_10_01
            GPT_4O_AUDIO_PREVIEW -> Value.GPT_4O_AUDIO_PREVIEW
            GPT_4O_AUDIO_PREVIEW_2024_10_01 -> Value.GPT_4O_AUDIO_PREVIEW_2024_10_01
            CHATGPT_4O_LATEST -> Value.CHATGPT_4O_LATEST
            GPT_4O_MINI -> Value.GPT_4O_MINI
            GPT_4O_MINI_2024_07_18 -> Value.GPT_4O_MINI_2024_07_18
            GPT_4_TURBO -> Value.GPT_4_TURBO
            GPT_4_TURBO_2024_04_09 -> Value.GPT_4_TURBO_2024_04_09
            GPT_4_0125_PREVIEW -> Value.GPT_4_0125_PREVIEW
            GPT_4_TURBO_PREVIEW -> Value.GPT_4_TURBO_PREVIEW
            GPT_4_1106_PREVIEW -> Value.GPT_4_1106_PREVIEW
            GPT_4_VISION_PREVIEW -> Value.GPT_4_VISION_PREVIEW
            GPT_4 -> Value.GPT_4
            GPT_4_0314 -> Value.GPT_4_0314
            GPT_4_0613 -> Value.GPT_4_0613
            GPT_4_32K -> Value.GPT_4_32K
            GPT_4_32K_0314 -> Value.GPT_4_32K_0314
            GPT_4_32K_0613 -> Value.GPT_4_32K_0613
            GPT_3_5_TURBO -> Value.GPT_3_5_TURBO
            GPT_3_5_TURBO_16K -> Value.GPT_3_5_TURBO_16K
            GPT_3_5_TURBO_0301 -> Value.GPT_3_5_TURBO_0301
            GPT_3_5_TURBO_0613 -> Value.GPT_3_5_TURBO_0613
            GPT_3_5_TURBO_1106 -> Value.GPT_3_5_TURBO_1106
            GPT_3_5_TURBO_0125 -> Value.GPT_3_5_TURBO_0125
            GPT_3_5_TURBO_16K_0613 -> Value.GPT_3_5_TURBO_16K_0613
            else -> Value._UNKNOWN
        }

    fun known(): Known =
        when (this) {
            O1_PREVIEW -> Known.O1_PREVIEW
            O1_PREVIEW_2024_09_12 -> Known.O1_PREVIEW_2024_09_12
            O1_MINI -> Known.O1_MINI
            O1_MINI_2024_09_12 -> Known.O1_MINI_2024_09_12
            GPT_4O -> Known.GPT_4O
            GPT_4O_2024_11_20 -> Known.GPT_4O_2024_11_20
            GPT_4O_2024_08_06 -> Known.GPT_4O_2024_08_06
            GPT_4O_2024_05_13 -> Known.GPT_4O_2024_05_13
            GPT_4O_REALTIME_PREVIEW -> Known.GPT_4O_REALTIME_PREVIEW
            GPT_4O_REALTIME_PREVIEW_2024_10_01 -> Known.GPT_4O_REALTIME_PREVIEW_2024_10_01
            GPT_4O_AUDIO_PREVIEW -> Known.GPT_4O_AUDIO_PREVIEW
            GPT_4O_AUDIO_PREVIEW_2024_10_01 -> Known.GPT_4O_AUDIO_PREVIEW_2024_10_01
            CHATGPT_4O_LATEST -> Known.CHATGPT_4O_LATEST
            GPT_4O_MINI -> Known.GPT_4O_MINI
            GPT_4O_MINI_2024_07_18 -> Known.GPT_4O_MINI_2024_07_18
            GPT_4_TURBO -> Known.GPT_4_TURBO
            GPT_4_TURBO_2024_04_09 -> Known.GPT_4_TURBO_2024_04_09
            GPT_4_0125_PREVIEW -> Known.GPT_4_0125_PREVIEW
            GPT_4_TURBO_PREVIEW -> Known.GPT_4_TURBO_PREVIEW
            GPT_4_1106_PREVIEW -> Known.GPT_4_1106_PREVIEW
            GPT_4_VISION_PREVIEW -> Known.GPT_4_VISION_PREVIEW
            GPT_4 -> Known.GPT_4
            GPT_4_0314 -> Known.GPT_4_0314
            GPT_4_0613 -> Known.GPT_4_0613
            GPT_4_32K -> Known.GPT_4_32K
            GPT_4_32K_0314 -> Known.GPT_4_32K_0314
            GPT_4_32K_0613 -> Known.GPT_4_32K_0613
            GPT_3_5_TURBO -> Known.GPT_3_5_TURBO
            GPT_3_5_TURBO_16K -> Known.GPT_3_5_TURBO_16K
            GPT_3_5_TURBO_0301 -> Known.GPT_3_5_TURBO_0301
            GPT_3_5_TURBO_0613 -> Known.GPT_3_5_TURBO_0613
            GPT_3_5_TURBO_1106 -> Known.GPT_3_5_TURBO_1106
            GPT_3_5_TURBO_0125 -> Known.GPT_3_5_TURBO_0125
            GPT_3_5_TURBO_16K_0613 -> Known.GPT_3_5_TURBO_16K_0613
            else -> throw OpenAIInvalidDataException("Unknown ChatModel: $value")
        }

    fun asString(): String = _value().asStringOrThrow()
}
