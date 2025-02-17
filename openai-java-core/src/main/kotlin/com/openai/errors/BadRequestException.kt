package com.openai.errors

import com.openai.core.http.Headers

class BadRequestException(headers: Headers, body: String, error: OpenAIError) :
    OpenAIServiceException(400, headers, body, error)
