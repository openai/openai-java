package com.openai.errors

/**
 * Thrown when the workload identity authentication flow fails to obtain the subject token from the
 * provider.
 *
 * For example, this is thrown by [com.openai.auth.K8sServiceAccountTokenProvider] when the service
 * account token file cannot be found at the configured path.
 */
class SubjectTokenProviderException(
    @get:JvmName("provider") val provider: String,
    message: String,
    cause: Throwable? = null,
) : OpenAIException("$provider provider error: $message", cause)
