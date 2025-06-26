package com.openai.errors

class InvalidWebhookSignatureException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) : OpenAIException(message, cause)
