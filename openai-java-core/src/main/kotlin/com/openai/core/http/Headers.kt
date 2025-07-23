// File generated from our OpenAPI spec by Stainless.

package com.openai.core.http

import com.openai.core.JsonArray
import com.openai.core.JsonBoolean
import com.openai.core.JsonMissing
import com.openai.core.JsonNull
import com.openai.core.JsonNumber
import com.openai.core.JsonObject
import com.openai.core.JsonString
import com.openai.core.JsonValue
import com.openai.core.toImmutable
import java.util.TreeMap

class Headers
private constructor(
    private val map: Map<String, List<String>>,
    @get:JvmName("size") val size: Int,
) {

    fun isEmpty(): Boolean = map.isEmpty()

    fun names(): Set<String> = map.keys

    fun values(name: String): List<String> = map[name].orEmpty()

    fun toBuilder(): Builder = Builder().putAll(map)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder internal constructor() {

        private val map: MutableMap<String, MutableList<String>> =
            TreeMap(String.CASE_INSENSITIVE_ORDER)
        private var size: Int = 0

        fun put(name: String, value: JsonValue): Builder = apply {
            when (value) {
                is JsonMissing,
                is JsonNull -> {}
                is JsonBoolean -> put(name, value.value.toString())
                is JsonNumber -> put(name, value.value.toString())
                is JsonString -> put(name, value.value)
                is JsonArray -> value.values.forEach { put(name, it) }
                is JsonObject ->
                    value.values.forEach { (nestedName, value) -> put("$name.$nestedName", value) }
            }
        }

        fun put(name: String, value: String) = apply {
            map.getOrPut(name) { mutableListOf() }.add(value)
            size++
        }

        fun put(name: String, values: Iterable<String>) = apply { values.forEach { put(name, it) } }

        fun putAll(headers: Map<String, Iterable<String>>) = apply { headers.forEach(::put) }

        fun putAll(headers: Headers) = apply {
            headers.names().forEach { put(it, headers.values(it)) }
        }

        fun replace(name: String, value: String) = apply {
            remove(name)
            put(name, value)
        }

        fun replace(name: String, values: Iterable<String>) = apply {
            remove(name)
            put(name, values)
        }

        fun replaceAll(headers: Map<String, Iterable<String>>) = apply {
            headers.forEach(::replace)
        }

        fun replaceAll(headers: Headers) = apply {
            headers.names().forEach { replace(it, headers.values(it)) }
        }

        fun remove(name: String) = apply { size -= map.remove(name).orEmpty().size }

        fun removeAll(names: Set<String>) = apply { names.forEach(::remove) }

        fun clear() = apply {
            map.clear()
            size = 0
        }

        fun build() =
            Headers(
                map.mapValuesTo(TreeMap(String.CASE_INSENSITIVE_ORDER)) { (_, values) ->
                        values.toImmutable()
                    }
                    .toImmutable(),
                size,
            )
    }

    override fun hashCode(): Int = map.hashCode()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Headers && map == other.map
    }

    override fun toString(): String = "Headers{map=$map}"
}
