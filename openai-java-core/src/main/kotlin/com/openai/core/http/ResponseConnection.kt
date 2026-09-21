package com.openai.core.http

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.errors.OpenAIIoException
import com.openai.models.responses.ResponsesClientEvent
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ExecutionException

/** Blocking view of a managed Responses WebSocket connection. */
class ResponseConnection private constructor(private val connection: AsyncResponseConnection) :
    AutoCloseable {
    companion object {
        @JvmStatic
        @JvmOverloads
        @MustBeClosed
        fun connect(
            clientOptions: ClientOptions,
            options: ResponseWebSocketOptions = ResponseWebSocketOptions.defaults(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ) =
            ResponseConnection(
                await(AsyncResponseConnection.connect(clientOptions, options, requestOptions))
            )

        private fun <T> await(future: CompletableFuture<T>): T {
            var interrupted = false
            try {
                while (true) {
                    try {
                        return future.get()
                    } catch (e: InterruptedException) {
                        interrupted = true
                        // An assigned event (or opened connection) already belongs to this
                        // caller. Return it rather than discard it behind an interruption.
                        val canceled =
                            if (future is InterruptibleResponseFuture) future.interrupt(e)
                            else future.cancel(false)
                        if (canceled) throw OpenAIIoException("WebSocket operation interrupted", e)
                    } catch (e: ExecutionException) {
                        val cause = e.cause ?: e
                        throw when (cause) {
                            is RuntimeException -> cause
                            is Error -> cause
                            else -> OpenAIIoException("WebSocket operation failed", cause)
                        }
                    }
                }
            } finally {
                if (interrupted) Thread.currentThread().interrupt()
            }
        }
    }

    fun receive() = await(connection.receive())

    fun send(event: ResponsesClientEvent) = connection.send(event)

    fun finalResponse() = await(connection.finalResponse())

    fun reconnect() {
        await(connection.reconnect())
    }

    fun reconnect(options: ResponseWebSocketOptions) {
        await(connection.reconnect(options))
    }

    fun lane(streamId: String) = Lane(connection.lane(streamId))

    class Lane internal constructor(private val lane: AsyncResponseConnection.Lane) :
        AutoCloseable {
        fun receive() = await(lane.receive())

        fun send(event: ResponsesClientEvent) = lane.send(event)

        fun finalResponse() = await(lane.finalResponse())

        override fun close() = lane.close()
    }

    override fun close() = connection.close()
}
