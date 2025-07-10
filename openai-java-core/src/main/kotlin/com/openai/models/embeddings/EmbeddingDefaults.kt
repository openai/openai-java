// File generated from our OpenAPI spec by Stainless.

package com.openai.models.embeddings

import com.openai.models.embeddings.EmbeddingCreateParams.EncodingFormat

/**
 * Configuration object for default embedding behavior. This allows users to change the default
 * encoding format globally.
 *
 * By default, Base64 encoding is used for optimal performance and reduced network bandwidth. Users
 * can explicitly choose float encoding when direct float access is needed.
 */
object EmbeddingDefaults {

    @JvmStatic
    @get:JvmName("getDefaultEncodingFormat")
    @set:JvmName("setDefaultEncodingFormat")
    var defaultEncodingFormat: EncodingFormat = EncodingFormat.BASE64 // Default is Base64
        private set

    /**
     * Set the default encoding format for embeddings. This will be applied when no explicit format
     * is specified in EmbeddingCreateParams.
     *
     * @param format the encoding format to use as default
     */
    @JvmStatic
    fun setDefaultEncodingFormat(format: EncodingFormat) {
        defaultEncodingFormat = format
    }

    /**
     * Reset the default encoding format to Base64 (the recommended default). Base64 encoding
     * provides better performance and reduced network bandwidth usage.
     */
    @JvmStatic
    fun resetToDefaults() {
        defaultEncodingFormat = EncodingFormat.BASE64
    }

    /**
     * Configure the system to use float encoding as default. This is primarily for backward
     * compatibility scenarios. Note: Float encoding uses more network bandwidth and may impact
     * performance. For most use cases, the default base64 encoding is recommended.
     */
    @JvmStatic
    fun enableLegacyFloatDefaults() {
        defaultEncodingFormat = EncodingFormat.FLOAT
    }

    /** Returns true if the current default encoding format is BASE64. */
    @JvmStatic fun isUsingBase64Defaults(): Boolean = defaultEncodingFormat == EncodingFormat.BASE64

    /** Returns true if the current default encoding format is FLOAT. */
    @JvmStatic fun isUsingFloatDefaults(): Boolean = defaultEncodingFormat == EncodingFormat.FLOAT
}
