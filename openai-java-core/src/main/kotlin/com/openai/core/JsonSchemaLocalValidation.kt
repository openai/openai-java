package com.openai.core

/**
 * Options for local validation of JSON schemas derived from arbitrary classes before a request is
 * executed.
 */
enum class JsonSchemaLocalValidation {
    /**
     * Validate the JSON schema locally before the request is executed. The remote AI model will
     * also validate the JSON schema.
     */
    YES,

    /**
     * Do not validate the JSON schema locally before the request is executed. The remote AI model
     * will always validate the JSON schema.
     */
    NO,
}
