package com.openai.errors

import com.openai.core.http.Headers

class NotFoundException(headers: Headers, body: String, error: OpenAIError) :
    OpenAIServiceException(404, headers, body, error)
