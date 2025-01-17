@file:JvmName("StreamHandler")

package com.openai.core.handlers

import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.PhantomReachableClosingStreamResponse
import com.openai.core.http.StreamResponse
import java.util.stream.Stream
import kotlin.streams.asStream

@JvmSynthetic
internal fun <T> streamHandler(
    block: suspend SequenceScope<T>.(lines: Sequence<String>) -> Unit
): Handler<StreamResponse<T>> =
    object : Handler<StreamResponse<T>> {
        override fun handle(response: HttpResponse): StreamResponse<T> {
            val reader = response.body().bufferedReader()
            val sequence = sequence { reader.useLines { block(it) } }.constrainOnce()

            return PhantomReachableClosingStreamResponse(
                object : StreamResponse<T> {
                    override fun stream(): Stream<T> = sequence.asStream()

                    override fun close() {
                        reader.close()
                        response.close()
                    }
                }
            )
        }
    }
