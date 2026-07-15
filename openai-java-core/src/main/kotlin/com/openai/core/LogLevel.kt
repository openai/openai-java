// File generated from our OpenAPI spec by Stainless.

package com.openai.core

/** The level at which to log request and response information. */
enum class LogLevel {
    /** No logging. */
    OFF,
    /** Minimal request and response summary logs. No headers or bodies are logged. */
    INFO,
    /** [INFO] logs plus details about request failures. */
    ERROR,
    /**
     * Full request and response logs. Sensitive headers are redacted, but sensitive data in request
     * and response bodies may still be visible.
     */
    DEBUG;

    /** Returns whether this level is at or higher than the given [level]. */
    fun shouldLog(level: LogLevel): Boolean = ordinal >= level.ordinal

    companion object {

        /** Returns a [LogLevel] based on the `OPENAI_LOG` environment variable. */
        fun fromEnv() =
            when (System.getenv("OPENAI_LOG")?.lowercase()) {
                "info" -> INFO
                "error" -> ERROR
                "debug" -> DEBUG
                else -> OFF
            }
    }
}
