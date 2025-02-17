package com.openai.errors

import com.openai.core.http.Headers

class PermissionDeniedException(headers: Headers, body: String, error: OpenAIError) :
    OpenAIServiceException(403, headers, body, error)
