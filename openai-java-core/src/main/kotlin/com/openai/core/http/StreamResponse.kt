package com.openai.core.http

import java.util.stream.Stream

interface StreamResponse<T> : AutoCloseable {

    fun stream(): Stream<T>
}