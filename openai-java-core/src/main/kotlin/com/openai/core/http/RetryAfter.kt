package com.openai.core.http

import java.math.BigDecimal
import java.math.RoundingMode
import java.time.Clock
import java.time.Duration
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.util.concurrent.TimeUnit

/** Parses the server minimum, including an oversized duration that callers must not sleep. */
internal fun retryAfterDelay(headers: Headers?, clock: Clock): Duration? {
    return headers
        ?.let { headers ->
            headers.values("Retry-After-Ms").getOrNull(0)?.let {
                parseNumericDelay(it, TimeUnit.MILLISECONDS.toNanos(1))
            }
                ?: headers.values("Retry-After").getOrNull(0)?.let { retryAfter ->
                    parseNumericDelay(retryAfter, TimeUnit.SECONDS.toNanos(1))
                        ?: try {
                            Duration.between(
                                OffsetDateTime.now(clock),
                                OffsetDateTime.parse(
                                    retryAfter,
                                    DateTimeFormatter.RFC_1123_DATE_TIME,
                                ),
                            )
                        } catch (e: DateTimeParseException) {
                            null
                        }
                }
        }
        ?.takeUnless { it.isNegative }
}

private fun parseNumericDelay(value: String, nanosPerUnit: Long): Duration? {
    val text = value.trim()
    if (!DECIMAL_DELAY.matches(text) || text.startsWith("-")) return null
    val number =
        text.toBigDecimalOrNull()
            ?: return if (text.toDoubleOrNull() == Double.POSITIVE_INFINITY) {
                Duration.ofSeconds(Long.MAX_VALUE)
            } else {
                // A positive decimal too small for BigDecimal's exponent range still has a
                // minimum representable wait of one nanosecond.
                Duration.ofNanos(
                    if (text.substringBefore('e', text).substringBefore('E').any { it in '1'..'9' })
                        1
                    else 0
                )
            }
    val nanos = number.multiply(BigDecimal.valueOf(nanosPerUnit))
    if (nanos > BigDecimal.valueOf(Long.MAX_VALUE)) return Duration.ofSeconds(Long.MAX_VALUE)
    if (nanos < BigDecimal.ONE)
        return if (nanos.signum() == 0) Duration.ZERO else Duration.ofNanos(1)
    return Duration.ofNanos(nanos.setScale(0, RoundingMode.CEILING).longValueExact())
}

private val DECIMAL_DELAY = Regex("[+-]?(?:[0-9]+(?:\\.[0-9]*)?|\\.[0-9]+)(?:[eE][+-]?[0-9]+)?")
