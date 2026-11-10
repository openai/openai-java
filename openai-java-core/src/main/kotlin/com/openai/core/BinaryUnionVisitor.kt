// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.core

import com.openai.errors.OpenAIInvalidDataException

/** Fallback for union variants that carry binary uploads. */
interface BinaryUnionVisitor<out T> {
    /** Receives the original upload value. The SDK leaves its streams open and unread. */
    fun unknown(value: Any?): T = throw OpenAIInvalidDataException("Unknown binary union variant")
}
