@file:JvmName("ObjectMappers")

package com.openai.core

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.cfg.CoercionAction.Fail
import com.fasterxml.jackson.databind.cfg.CoercionInputShape.Integer
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonMapperBuilder
import com.openai.errors.OpenAIException
import com.openai.errors.OpenAIInvalidDataException
import java.io.InputStream

fun jsonMapper(): JsonMapper =
    jacksonMapperBuilder()
        .addModule(Jdk8Module())
        .addModule(JavaTimeModule())
        .addModule(SimpleModule().addSerializer(InputStreamJsonSerializer))
        .serializationInclusion(JsonInclude.Include.NON_ABSENT)
        .disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE)
        .disable(SerializationFeature.FLUSH_AFTER_WRITE_VALUE)
        .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        .disable(SerializationFeature.WRITE_DURATIONS_AS_TIMESTAMPS)
        .withCoercionConfig(String::class.java) { it.setCoercion(Integer, Fail) }
        .build()

private object InputStreamJsonSerializer : BaseSerializer<InputStream>(InputStream::class) {

    override fun serialize(
        value: InputStream?,
        gen: JsonGenerator?,
        serializers: SerializerProvider?,
    ) {
        if (value == null) {
            gen?.writeNull()
        } else {
            value.use { gen?.writeBinary(it.readBytes()) }
        }
    }
}

@JvmSynthetic
internal fun enhanceJacksonException(fallbackMessage: String, e: Exception): Exception {
    // These exceptions should only happen if our code is wrong OR if the user is using a binary
    // incompatible version of `com.fasterxml.jackson.core:jackson-databind`:
    // https://javadoc.io/static/com.fasterxml.jackson.core/jackson-databind/2.18.1/index.html
    val isUnexpectedException =
        e is UnrecognizedPropertyException || e is InvalidDefinitionException
    if (!isUnexpectedException) {
        return OpenAIInvalidDataException(fallbackMessage, e)
    }

    val jacksonVersion = JsonMapper::class.java.`package`.implementationVersion
    if (jacksonVersion.isNullOrEmpty() || jacksonVersion == COMPILED_JACKSON_VERSION) {
        return OpenAIInvalidDataException(fallbackMessage, e)
    }

    return OpenAIException(
        """
            Jackson threw an unexpected exception and its runtime version ($jacksonVersion) mismatches the version the SDK was compiled with ($COMPILED_JACKSON_VERSION).

            You may be using a version of `com.fasterxml.jackson.core:jackson-databind` that's not binary compatible with the SDK.

            This can happen if you are either:
            1. Directly depending on a different Jackson version
            2. Depending on some library that depends on a different Jackson version, potentially transitively

            Double-check that you are depending on a compatible Jackson version.
        """
            .trimIndent(),
        e,
    )
}

const val COMPILED_JACKSON_VERSION = "2.18.1"
