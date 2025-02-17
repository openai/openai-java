package com.openai.errors

import com.openai.core.http.Headers

class InternalServerException(statusCode: Int, headers: Headers, body: String, error: OpenAIError) :
    OpenAIServiceException(statusCode, headers, body, error)
