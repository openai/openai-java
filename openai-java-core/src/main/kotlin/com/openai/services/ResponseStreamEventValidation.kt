package com.openai.services

import com.openai.core.JsonValue
import com.openai.models.responses.ResponseStreamEvent
import kotlin.jvm.optionals.getOrNull

/**
 * Validates a Responses API stream event while allowing the transport-level heartbeat emitted for
 * long-running requests. The heartbeat remains an unknown event for forwards compatibility, but it
 * must not terminate an otherwise valid stream. All other unknown events retain the existing strict
 * validation behavior.
 */
@JvmSynthetic
internal fun ResponseStreamEvent.validateForStream(): ResponseStreamEvent =
    if (_json().getOrNull().isKeepalive()) this else validate()

private fun JsonValue?.isKeepalive(): Boolean =
    this?.asObject()?.getOrNull()?.get("type")?.asString()?.getOrNull() == "keepalive"
