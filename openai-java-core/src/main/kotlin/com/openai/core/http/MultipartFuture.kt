package com.openai.core.http

import java.util.concurrent.CompletableFuture

/** Keeps upload ownership attached to the futures returned by public async services. */
@JvmSynthetic
internal fun <T : AutoCloseable, R> CompletableFuture<T>.mapMultipartResponse(
    request: CompletableFuture<HttpRequest>? = (this as? MultipartFuture<*>)?.request,
    transform: (T) -> R,
): CompletableFuture<R> {
    if (request == null) return thenApply(transform)
    val result = MultipartFuture<R>(request)
    whenComplete { response, failure ->
        if (failure != null) {
            result.completeExceptionally(failure)
        } else if (result.isCancelled) {
            response.close()
        } else {
            try {
                val mapped = transform(response)
                if (!result.complete(mapped)) (mapped as? AutoCloseable)?.close()
            } catch (failure: Throwable) {
                result.completeExceptionally(failure)
            }
        }
    }
    // Keep observing the upstream result after cancellation so a late response is closed rather
    // than discarded by CompletableFuture. Cancellation gates future transport handoffs before
    // releasing upload inputs.
    return result
}

private class MultipartFuture<T>(request: CompletableFuture<HttpRequest>) :
    CompletableFuture<T>(), MultipartUploadCancellation {
    @Volatile
    var request: CompletableFuture<HttpRequest>? = request
        private set

    override fun cancelUpload() {
        cancel(true)
    }

    init {
        whenComplete { _, failure ->
            val pendingRequest = this.request
            this.request = null
            if (isCancelled) {
                pendingRequest?.thenAccept { it.body.cancelMultipart(failure) }
            }
        }
    }
}
