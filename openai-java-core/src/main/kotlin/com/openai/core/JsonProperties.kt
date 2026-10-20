// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.core

import java.util.Collections

/** Builds a JSON-property snapshot without changing the storage used by Jackson or builders. */
@JvmSynthetic
internal fun collectAllProperties(
    additionalProperties: Map<String, JsonValue>,
    vararg declaredProperties: Pair<String, JsonField<*>>,
): Map<String, JsonValue> {
    val properties = additionalProperties.filterValues { !it.isMissing() }.toMutableMap()
    for ((name, field) in declaredProperties) {
        if (!field.isMissing()) {
            properties[name] = JsonValue.from(field)
        }
    }
    return Collections.unmodifiableMap(properties)
}
