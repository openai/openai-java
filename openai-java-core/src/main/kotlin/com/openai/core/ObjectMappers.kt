@file:JvmName("ObjectMappers")

package com.openai.core

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.cfg.CoercionAction
import com.fasterxml.jackson.databind.cfg.CoercionInputShape
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.databind.type.LogicalType
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.kotlinModule
import java.io.InputStream
import java.time.DateTimeException
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoField

fun jsonMapper(): JsonMapper =
    JsonMapper.builder()
        .addModule(kotlinModule())
        .addModule(Jdk8Module())
        .addModule(JavaTimeModule())
        .addModule(
            SimpleModule()
                .addSerializer(InputStreamSerializer)
                .addDeserializer(LocalDateTime::class.java, LenientLocalDateTimeDeserializer())
        )
        .withCoercionConfig(LogicalType.Boolean) {
            it.setCoercion(CoercionInputShape.Integer, CoercionAction.Fail)
                .setCoercion(CoercionInputShape.Float, CoercionAction.Fail)
                .setCoercion(CoercionInputShape.String, CoercionAction.Fail)
                .setCoercion(CoercionInputShape.Array, CoercionAction.Fail)
                .setCoercion(CoercionInputShape.Object, CoercionAction.Fail)
        }
        .withCoercionConfig(LogicalType.Integer) {
            it.setCoercion(CoercionInputShape.Boolean, CoercionAction.Fail)
                .setCoercion(CoercionInputShape.String, CoercionAction.Fail)
                .setCoercion(CoercionInputShape.Array, CoercionAction.Fail)
                .setCoercion(CoercionInputShape.Object, CoercionAction.Fail)
        }
        .withCoercionConfig(LogicalType.Float) {
            it.setCoercion(CoercionInputShape.Boolean, CoercionAction.Fail)
                .setCoercion(CoercionInputShape.String, CoercionAction.Fail)
                .setCoercion(CoercionInputShape.Array, CoercionAction.Fail)
                .setCoercion(CoercionInputShape.Object, CoercionAction.Fail)
        }
        .withCoercionConfig(LogicalType.Textual) {
            it.setCoercion(CoercionInputShape.Boolean, CoercionAction.Fail)
                .setCoercion(CoercionInputShape.Integer, CoercionAction.Fail)
                .setCoercion(CoercionInputShape.Float, CoercionAction.Fail)
                .setCoercion(CoercionInputShape.Array, CoercionAction.Fail)
                .setCoercion(CoercionInputShape.Object, CoercionAction.Fail)
        }
        .withCoercionConfig(LogicalType.Array) {
            it.setCoercion(CoercionInputShape.Boolean, CoercionAction.Fail)
                .setCoercion(CoercionInputShape.Integer, CoercionAction.Fail)
                .setCoercion(CoercionInputShape.Float, CoercionAction.Fail)
                .setCoercion(CoercionInputShape.String, CoercionAction.Fail)
                .setCoercion(CoercionInputShape.Object, CoercionAction.Fail)
        }
        .withCoercionConfig(LogicalType.Collection) {
            it.setCoercion(CoercionInputShape.Boolean, CoercionAction.Fail)
                .setCoercion(CoercionInputShape.Integer, CoercionAction.Fail)
                .setCoercion(CoercionInputShape.Float, CoercionAction.Fail)
                .setCoercion(CoercionInputShape.String, CoercionAction.Fail)
                .setCoercion(CoercionInputShape.Object, CoercionAction.Fail)
        }
        .withCoercionConfig(LogicalType.Map) {
            it.setCoercion(CoercionInputShape.Boolean, CoercionAction.Fail)
                .setCoercion(CoercionInputShape.Integer, CoercionAction.Fail)
                .setCoercion(CoercionInputShape.Float, CoercionAction.Fail)
                .setCoercion(CoercionInputShape.String, CoercionAction.Fail)
                .setCoercion(CoercionInputShape.Object, CoercionAction.Fail)
        }
        .withCoercionConfig(LogicalType.POJO) {
            it.setCoercion(CoercionInputShape.Boolean, CoercionAction.Fail)
                .setCoercion(CoercionInputShape.Integer, CoercionAction.Fail)
                .setCoercion(CoercionInputShape.Float, CoercionAction.Fail)
                .setCoercion(CoercionInputShape.String, CoercionAction.Fail)
                .setCoercion(CoercionInputShape.Array, CoercionAction.Fail)
        }
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

/** A serializer that serializes [InputStream] to bytes. */
private object InputStreamSerializer : BaseSerializer<InputStream>(InputStream::class) {

    private fun readResolve(): Any = InputStreamSerializer

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

/**
 * A deserializer that can deserialize [LocalDateTime] from datetimes, dates, and zoned datetimes.
 */
private class LenientLocalDateTimeDeserializer :
    StdDeserializer<LocalDateTime>(LocalDateTime::class.java) {

    companion object {

        private val DATE_TIME_FORMATTERS =
            listOf(
                DateTimeFormatter.ISO_LOCAL_DATE_TIME,
                DateTimeFormatter.ISO_LOCAL_DATE,
                DateTimeFormatter.ISO_ZONED_DATE_TIME,
            )
    }

    override fun logicalType(): LogicalType = LogicalType.DateTime

    override fun deserialize(p: JsonParser, context: DeserializationContext?): LocalDateTime {
        val exceptions = mutableListOf<Exception>()

        for (formatter in DATE_TIME_FORMATTERS) {
            try {
                val temporal = formatter.parse(p.text)

                return when {
                    !temporal.isSupported(ChronoField.HOUR_OF_DAY) ->
                        LocalDate.from(temporal).atStartOfDay()
                    !temporal.isSupported(ChronoField.OFFSET_SECONDS) ->
                        LocalDateTime.from(temporal)
                    else -> ZonedDateTime.from(temporal).toLocalDateTime()
                }
            } catch (e: DateTimeException) {
                exceptions.add(e)
            }
        }

        throw JsonParseException(p, "Cannot parse `LocalDateTime` from value: ${p.text}").apply {
            exceptions.forEach { addSuppressed(it) }
        }
    }
}
