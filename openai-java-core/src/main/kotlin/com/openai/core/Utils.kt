@file:JvmName("Utils")

package com.openai.core

import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.SortedMap

@JvmSynthetic
internal fun <T : Any> T?.getOrThrow(name: String): T =
    this ?: throw OpenAIInvalidDataException("`${name}` is not present")

@JvmSynthetic
internal fun <T> List<T>.toImmutable(): List<T> =
    if (isEmpty()) Collections.emptyList() else Collections.unmodifiableList(toList())

@JvmSynthetic
internal fun <K, V> Map<K, V>.toImmutable(): Map<K, V> =
    if (isEmpty()) immutableEmptyMap() else Collections.unmodifiableMap(toMap())

@JvmSynthetic internal fun <K, V> immutableEmptyMap(): Map<K, V> = Collections.emptyMap()

@JvmSynthetic
internal fun <K : Comparable<K>, V> SortedMap<K, V>.toImmutable(): SortedMap<K, V> =
    if (isEmpty()) Collections.emptySortedMap()
    else Collections.unmodifiableSortedMap(toSortedMap(comparator()))

@JvmSynthetic
internal fun isAzureEndpoint(baseUrl: String): Boolean {
    // Azure Endpoint should be in the format of `https://<region>.openai.azure.com`.
    // Or `https://<region>.azure-api.net` for Azure OpenAI Management URL.
    return baseUrl.endsWith(".openai.azure.com", true) || baseUrl.endsWith(".azure-api.net", true)
}

internal interface Enum
