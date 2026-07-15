package com.openai.auth

import com.fasterxml.jackson.databind.json.JsonMapper
import com.openai.core.http.HttpClient
import com.openai.errors.SubjectTokenProviderException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors
import java.util.concurrent.ThreadFactory
import java.util.concurrent.atomic.AtomicLong

private const val DEFAULT_K8S_TOKEN_PATH = "/var/run/secrets/kubernetes.io/serviceaccount/token"

/**
 * A [SubjectTokenProvider] that reads a Kubernetes service account JWT from the filesystem.
 *
 * By default, reads the token from `/var/run/secrets/kubernetes.io/serviceaccount/token`, which is
 * the default path Kubernetes mounts service account tokens to. A custom path can be provided via
 * the builder.
 */
class K8sServiceAccountTokenProvider
private constructor(private val tokenPath: String = DEFAULT_K8S_TOKEN_PATH) :
    SubjectTokenProvider, AutoCloseable {

    private val executor =
        Executors.newSingleThreadExecutor(
            object : ThreadFactory {

                private val threadFactory: ThreadFactory = Executors.defaultThreadFactory()
                private val count = AtomicLong(0)

                override fun newThread(runnable: Runnable): Thread =
                    threadFactory.newThread(runnable).also {
                        it.name = "openai-k8s-token-reader-${count.getAndIncrement()}"
                    }
            }
        )

    override fun tokenType(): SubjectTokenType = SubjectTokenType.JWT

    override fun getToken(httpClient: HttpClient, jsonMapper: JsonMapper): String {
        val token =
            try {
                String(Files.readAllBytes(Paths.get(tokenPath))).trim()
            } catch (e: Exception) {
                throw SubjectTokenProviderException(
                    provider = "kubernetes",
                    message = "failed to read service account token from $tokenPath",
                    cause = e,
                )
            }
        if (token.isEmpty()) {
            throw SubjectTokenProviderException(
                provider = "kubernetes",
                message = "service account token is empty",
            )
        }
        return token
    }

    override fun getTokenAsync(
        httpClient: HttpClient,
        jsonMapper: JsonMapper,
    ): CompletableFuture<String> =
        CompletableFuture.supplyAsync({ getToken(httpClient, jsonMapper) }, executor)

    override fun close() {
        executor.shutdown()
    }

    companion object {
        @JvmStatic fun builder() = Builder()
    }

    class Builder internal constructor() {

        private var tokenPath: String = DEFAULT_K8S_TOKEN_PATH

        fun tokenPath(tokenPath: Path) = apply { this.tokenPath = tokenPath.toString() }

        fun tokenPath(tokenPath: String) = apply { this.tokenPath = tokenPath }

        fun build(): K8sServiceAccountTokenProvider = K8sServiceAccountTokenProvider(tokenPath)
    }
}
