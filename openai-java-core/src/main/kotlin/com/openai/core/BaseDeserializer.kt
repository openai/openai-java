package com.openai.core

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.BeanProperty
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JavaType
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonMappingException
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.deser.ContextualDeserializer
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import kotlin.reflect.KClass

abstract class BaseDeserializer<T : Any>(type: KClass<T>) :
    StdDeserializer<T>(type.java), ContextualDeserializer {

    override fun createContextual(
        context: DeserializationContext,
        property: BeanProperty?,
    ): JsonDeserializer<T> {
        return this
    }

    override fun deserialize(parser: JsonParser, context: DeserializationContext): T {
        return parser.codec.deserialize(parser.readValueAsTree())
    }

    protected abstract fun ObjectCodec.deserialize(node: JsonNode): T

    protected fun <T> ObjectCodec.tryDeserialize(
        node: JsonNode,
        type: TypeReference<T>,
        validate: (T) -> Unit = {},
    ): T? {
        return try {
            readValue(treeAsTokens(node), type).apply(validate)
        } catch (e: JsonMappingException) {
            null
        } catch (e: RuntimeException) {
            null
        }
    }

    protected fun <T> ObjectCodec.tryDeserialize(
        node: JsonNode,
        type: JavaType,
        validate: (T) -> Unit = {},
    ): T? {
        return try {
            readValue<T>(treeAsTokens(node), type).apply(validate)
        } catch (e: JsonMappingException) {
            null
        } catch (e: RuntimeException) {
            null
        }
    }
}
