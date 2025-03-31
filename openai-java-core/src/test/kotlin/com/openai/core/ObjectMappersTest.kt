package com.openai.core

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.exc.MismatchedInputException
import kotlin.reflect.KClass
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Test
import org.junitpioneer.jupiter.cartesian.CartesianTest

internal class ObjectMappersTest {

    internal class ClassWithBooleanFieldPrefixedWithIs(private val isActive: JsonField<Boolean>) {

        @JsonProperty("is_active") @ExcludeMissing fun _isActive() = isActive
    }

    @Test
    fun write_whenFieldPrefixedWithIs_keepsPrefix() {
        val value = ClassWithBooleanFieldPrefixedWithIs(JsonField.of(true))

        val json = jsonMapper().writeValueAsString(value)

        assertThat(json).isEqualTo("{\"is_active\":true}")
    }

    internal class Class(@get:JsonProperty("field") @JsonProperty("field") val field: String)

    enum class ShapeTestCase(val value: Any, val kClass: KClass<*>) {
        STRING("Hello World!", String::class),
        BOOLEAN(true, Boolean::class),
        FLOAT(3.14F, Float::class),
        DOUBLE(3.14, Double::class),
        INTEGER(42, Int::class),
        LONG(42L, Long::class),
        MAP(mapOf("property" to "value"), Map::class),
        CLASS(Class("Hello World!"), Class::class),
        LIST(listOf(1, 2, 3), List::class);

        companion object {
            val VALID_CONVERSIONS =
                listOf(
                    FLOAT to DOUBLE,
                    FLOAT to INTEGER,
                    FLOAT to LONG,
                    DOUBLE to FLOAT,
                    DOUBLE to INTEGER,
                    DOUBLE to LONG,
                    INTEGER to FLOAT,
                    INTEGER to DOUBLE,
                    INTEGER to LONG,
                    LONG to FLOAT,
                    LONG to DOUBLE,
                    LONG to INTEGER,
                    CLASS to MAP,
                    // These aren't actually valid, but coercion configs don't work for String until
                    // v2.14.0: https://github.com/FasterXML/jackson-databind/issues/3240
                    // We currently test on v2.13.4.
                    BOOLEAN to STRING,
                    FLOAT to STRING,
                    DOUBLE to STRING,
                    INTEGER to STRING,
                    LONG to STRING,
                )
        }
    }

    @CartesianTest
    fun read(@CartesianTest.Enum shape1: ShapeTestCase, @CartesianTest.Enum shape2: ShapeTestCase) {
        val jsonMapper = jsonMapper()
        val json = jsonMapper.writeValueAsString(shape1.value)

        val e = catchThrowable { jsonMapper.readValue(json, shape2.kClass.java) }

        if (shape1 == shape2 || shape1 to shape2 in ShapeTestCase.VALID_CONVERSIONS) {
            assertThat(e).isNull()
        } else {
            assertThat(e).isInstanceOf(MismatchedInputException::class.java)
        }
    }
}
