package com.openai.core.http

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.openai.core.*
import java.util.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SerializerTest {
    @JsonDeserialize(builder = ClassWithBooleanFieldPrefixedWithIs.Builder::class)
    @NoAutoDetect
    class ClassWithBooleanFieldPrefixedWithIs
    private constructor(
        private val isActive: JsonField<Boolean>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {
        private var validated: Boolean = false

        private var hashCode: Int = 0

        fun isActive(): Boolean? = isActive.getNullable("is_active")

        @JsonProperty("is_active") @ExcludeMissing fun _isActive() = isActive

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate() = apply {
            if (!validated) {
                isActive()
                validated = true
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ClassWithBooleanFieldPrefixedWithIs &&
                isActive == other.isActive &&
                additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode = Objects.hash(isActive, additionalProperties)
            }
            return hashCode
        }

        override fun toString() =
            "MyClass{isActive=$isActive, additionalProperties=$additionalProperties}"

        companion object {
            fun builder() = Builder()
        }

        @NoAutoDetect
        class Builder internal constructor() {

            private var isActive: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            fun isActive(isActive: Boolean) = isActive(JsonField.of(isActive))

            @JsonProperty("is_active")
            @ExcludeMissing
            fun isActive(isActive: JsonField<Boolean>) = apply { this.isActive = isActive }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                this.additionalProperties.putAll(additionalProperties)
            }

            @JsonAnySetter
            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun build(): ClassWithBooleanFieldPrefixedWithIs =
                ClassWithBooleanFieldPrefixedWithIs(isActive, additionalProperties.toImmutable())
        }
    }

    @Test
    fun serializeBooleanPrefixedWithIs() {
        val value = ClassWithBooleanFieldPrefixedWithIs.builder().isActive(true).build()
        assertThat(jsonMapper().writeValueAsString(value)).isEqualTo("{\"is_active\":true}")
    }
}
