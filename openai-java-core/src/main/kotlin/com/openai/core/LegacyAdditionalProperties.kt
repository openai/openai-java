package com.openai.core

import java.util.Collections

/** Preserve raw lookups for explicitly migrated fields without changing their typed accessors. */
@JvmSynthetic
fun legacyAdditionalProperties(
    extras: Map<String, JsonValue>,
    fields: Map<String, JsonField<*>>,
): Map<String, JsonValue> {
    val properties = extras.toMutableMap()
    fields.forEach { (name, field) ->
        if (!field.isMissing()) {
            properties[name] = field.asUnknown().orElseGet { JsonValue.from(field.asKnown().get()) }
        }
    }
    return Collections.unmodifiableMap(properties)
}

/**
 * Typed fields own their JSON keys; retain legacy builder entries only when the field is missing.
 */
@JvmSynthetic
fun serializableAdditionalProperties(
    extras: Map<String, JsonValue>,
    fields: Map<String, JsonField<*>>,
): Map<String, JsonValue> = extras.filterKeys { fields[it]?.isMissing() != false }
