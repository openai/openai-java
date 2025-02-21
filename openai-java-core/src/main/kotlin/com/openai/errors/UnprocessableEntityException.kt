package com.openai.errors

import com.openai.core.http.Headers

class UnprocessableEntityException(headers: Headers, body: String, error: OpenAIError) :
    OpenAIServiceException(422, headers, body, error)
