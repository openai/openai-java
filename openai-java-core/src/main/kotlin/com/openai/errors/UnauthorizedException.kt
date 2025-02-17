package com.openai.errors

import com.openai.core.http.Headers

class UnauthorizedException(headers: Headers, body: String, error: OpenAIError) :
    OpenAIServiceException(401, headers, body, error)
