package com.openai.errors

/**
 * A resource ID is empty or exactly `.` or `..` and cannot be used as a URL path segment.
 *
 * SDK service calls reject these IDs locally, before transport. Blocking calls throw this
 * exception; asynchronous calls complete their future exceptionally. This exception is an
 * [IllegalArgumentException], not an [OpenAIServiceException], and has no HTTP response.
 */
class InvalidResourceIdException :
    IllegalArgumentException(
        "Invalid resource ID: resource IDs cannot be empty or exactly '.' or '..'."
    )
