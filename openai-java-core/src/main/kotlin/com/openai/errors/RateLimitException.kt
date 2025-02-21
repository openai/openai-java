package com.openai.errors

import com.openai.core.http.Headers

class RateLimitException(headers: Headers, body: String, error: OpenAIError) :
    OpenAIServiceException(429, headers, body, error)
