// File generated from our OpenAPI spec by Stainless.

package com.openai.models.webhooks

import com.openai.core.checkRequired
import com.openai.core.http.Headers
import java.nio.charset.StandardCharsets
import java.time.Duration
import java.util.Objects
import java.util.Optional

/** Parameters for webhook signature verification. */
public class WebhookVerificationParams
private constructor(
    /** The webhook payload as a byte array */
    @get:JvmName("payload") val payload: ByteArray,

    /** The webhook headers */
    @get:JvmName("headers") val headers: Headers,

    /** The webhook secret (optional, will use client secret if not provided) */
    @get:JvmName("secret") val secret: Optional<String>,

    /** Maximum age of the webhook (default: 5 minutes) */
    @get:JvmName("tolerance") val tolerance: Duration,
) {
    companion object {
        @JvmStatic fun builder(): Builder = Builder()
    }

    class Builder {
        private var payload: ByteArray? = null
        private var headers: Headers? = null
        private var secret: Optional<String> = Optional.empty()
        private var tolerance: Duration = Duration.ofMinutes(5)

        /** The webhook payload as a string */
        fun payload(payload: String): Builder = apply {
            this.payload = payload.toByteArray(StandardCharsets.UTF_8)
        }

        /** The webhook payload as a byte array */
        fun payload(payload: ByteArray): Builder = apply { this.payload = payload }

        /** The webhook headers */
        fun headers(headers: Headers): Builder = apply { this.headers = headers }

        /** The webhook secret (optional, will use client secret if not provided) */
        fun secret(secret: String): Builder = apply { this.secret = Optional.of(secret) }

        /** The webhook secret (optional, will use client secret if not provided) */
        fun secret(secret: Optional<String>): Builder = apply { this.secret = secret }

        /** Maximum age of the webhook (default: 5 minutes) */
        fun tolerance(tolerance: Duration): Builder = apply { this.tolerance = tolerance }

        /** Maximum age of the webhook in seconds (default: 300 = 5 minutes) */
        fun tolerance(toleranceSeconds: Int): Builder = apply {
            this.tolerance = Duration.ofSeconds(toleranceSeconds.toLong())
        }

        fun build(): WebhookVerificationParams =
            WebhookVerificationParams(
                checkRequired("payload", payload),
                checkRequired("headers", headers),
                secret,
                tolerance,
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is WebhookVerificationParams &&
            payload contentEquals other.payload &&
            headers == other.headers &&
            secret == other.secret &&
            tolerance == other.tolerance
    }

    override fun hashCode(): Int =
        Objects.hash(payload.contentHashCode(), headers, secret, tolerance)
}
