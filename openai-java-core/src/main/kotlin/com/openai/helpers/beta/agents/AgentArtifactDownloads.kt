package com.openai.helpers.beta.agents

import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponse
import com.openai.models.beta.agents.sessions.artifacts.ArtifactContentParams
import com.openai.models.beta.agents.sessions.artifacts.ArtifactListParams
import com.openai.models.beta.agents.sessions.artifacts.SessionArtifact
import com.openai.services.async.beta.agents.sessions.ArtifactServiceAsync
import com.openai.services.beta.agents.AgentTurnResult
import com.openai.services.blocking.beta.agents.sessions.ArtifactService
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption.REPLACE_EXISTING
import java.util.concurrent.CompletableFuture
import java.util.concurrent.atomic.AtomicReference

/** Lazy, turn-scoped downloads of immutable beta Agents artifacts. */
class AgentArtifactDownloads
private constructor(
    private val service: ArtifactService,
    private val sessionId: String,
    private val turnId: String,
) {
    companion object {
        @JvmStatic
        fun forResult(service: ArtifactService, result: AgentTurnResult) =
            AgentArtifactDownloads(service, result.sessionId(), result.turnId())

        @JvmStatic
        fun forResult(service: ArtifactServiceAsync, result: AgentTurnResult) =
            Async(service, result.sessionId(), result.turnId())

        private fun match(
            current: SessionArtifact?,
            candidate: SessionArtifact,
            sessionId: String,
            turnId: String,
            path: String,
        ): SessionArtifact? {
            if (
                candidate.sessionId() != sessionId ||
                    candidate.turnId() != turnId ||
                    candidate.path() != path
            )
                return current
            check(current == null || current.id() == candidate.id()) {
                "More than one artifact matches this turn and path"
            }
            return candidate
        }
    }

    /** Returns the exact turn/path response. The caller owns and must close it. */
    @JvmOverloads
    fun content(path: String, options: RequestOptions = RequestOptions.none()): HttpResponse =
        openContent(findArtifact(path, options), options)

    /** Streams to an application-owned destination, replacing that file. */
    @JvmOverloads
    fun download(
        path: String,
        destination: Path,
        options: RequestOptions = RequestOptions.none(),
    ): SessionArtifact {
        val artifact = findArtifact(path, options)
        openContent(artifact, options).use { Files.copy(it.body(), destination, REPLACE_EXISTING) }
        return artifact
    }

    private fun openContent(artifact: SessionArtifact, options: RequestOptions) =
        service.content(
            ArtifactContentParams.builder().sessionId(sessionId).artifactId(artifact.id()).build(),
            options,
        )

    private fun findArtifact(path: String, options: RequestOptions): SessionArtifact {
        var selected: SessionArtifact? = null
        var params = ArtifactListParams.builder().sessionId(sessionId).build()
        while (true) {
            val page = service.list(params, options)
            page.data().forEach { selected = match(selected, it, sessionId, turnId, path) }
            if (!page.hasNextPage()) break
            params = page.nextPageParams()
        }
        return checkNotNull(selected) { "No artifact matches this turn and path" }
    }

    class Async
    internal constructor(
        private val service: ArtifactServiceAsync,
        private val sessionId: String,
        private val turnId: String,
    ) {
        /** Returns the exact turn/path response. The caller owns and must close it. */
        @JvmOverloads
        fun content(
            path: String,
            options: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> = withContent(path, options) { _, response -> response }

        /** Streams to an application-owned destination, replacing that file. */
        @JvmOverloads
        fun download(
            path: String,
            destination: Path,
            options: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<SessionArtifact> =
            withContent(path, options) { artifact, response ->
                response.use { Files.copy(it.body(), destination, REPLACE_EXISTING) }
                artifact
            }

        private fun <T> withContent(
            path: String,
            options: RequestOptions,
            consume: (SessionArtifact, HttpResponse) -> T,
        ): CompletableFuture<T> {
            val result = CompletableFuture<T>()
            val response = AtomicReference<HttpResponse?>()
            // Native service futures are dependent stages: canceling them does not abort their
            // transport and can suppress delivery of a response that still needs closing.
            result.whenComplete { _, _ -> if (result.isCancelled) response.get()?.close() }
            var selected: SessionArtifact? = null
            fun downloadSelected() {
                if (result.isDone) return
                val artifact = checkNotNull(selected) { "No artifact matches this turn and path" }
                service
                    .content(
                        ArtifactContentParams.builder()
                            .sessionId(sessionId)
                            .artifactId(artifact.id())
                            .build(),
                        options,
                    )
                    .whenComplete { content, failure ->
                        if (failure != null) result.completeExceptionally(failure)
                        else {
                            response.set(content)
                            try {
                                if (result.isDone) content.close()
                                else if (!result.complete(consume(artifact, content)))
                                    content.close()
                            } catch (error: Throwable) {
                                runCatching { content.close() }
                                result.completeExceptionally(error)
                            } finally {
                                response.set(null)
                            }
                        }
                    }
            }
            fun next(params: ArtifactListParams) {
                if (result.isDone) return
                try {
                    service.list(params, options).whenComplete { page, failure ->
                        if (failure != null) result.completeExceptionally(failure)
                        else if (!result.isDone) {
                            try {
                                page.data().forEach {
                                    selected = match(selected, it, sessionId, turnId, path)
                                }
                                if (page.hasNextPage()) next(page.nextPageParams())
                                else downloadSelected()
                            } catch (error: Throwable) {
                                result.completeExceptionally(error)
                            }
                        }
                    }
                } catch (error: Throwable) {
                    result.completeExceptionally(error)
                }
            }
            next(ArtifactListParams.builder().sessionId(sessionId).build())
            return result
        }
    }
}
