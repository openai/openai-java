@file:JvmName("ObjectMappers")

package com.openai.core

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.kotlinModule
import java.io.InputStream

fun jsonMapper(): JsonMapper =
    JsonMapper.builder()
        .addModule(kotlinModule())
        .addModule(Jdk8Module())
        .addModule(JavaTimeModule())
        .addModule(SimpleModule().addSerializer(InputStreamJsonSerializer))
        .serializationInclusion(JsonInclude.Include.NON_ABSENT)
        .disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE)
        .disable(SerializationFeature.FLUSH_AFTER_WRITE_VALUE)
        .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        .disable(SerializationFeature.WRITE_DURATIONS_AS_TIMESTAMPS)
        .disable(MapperFeature.ALLOW_COERCION_OF_SCALARS)
        .disable(MapperFeature.AUTO_DETECT_CREATORS)
        .disable(MapperFeature.AUTO_DETECT_FIELDS)
        .disable(MapperFeature.AUTO_DETECT_GETTERS)
        .disable(MapperFeature.AUTO_DETECT_IS_GETTERS)
        .disable(MapperFeature.AUTO_DETECT_SETTERS)
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
