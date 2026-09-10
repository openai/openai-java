package com.openai.services.beta.agents

import com.fasterxml.jackson.databind.JsonNode
import com.openai.client.OpenAIClientImpl
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.*
import com.openai.core.jsonMapper
import com.openai.models.beta.agents.*
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.time.Duration
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class AgentSessionStreamTest {
    private val mapper = jsonMapper()
    private val direct = Executor { it.run() }

    private fun turn(kind: String, id: String = "root", subagent: String? = null) =
        """{"type":"agent.session.turn.$kind","event_id":"$kind-$id","session_id":"s","turn_id":"$id","turn":{"id":"$id","subagent_id":${subagent?.let { "\"$it\"" } ?: "null"}}}"""

    private fun idle(id: String = "idle") =
        """{"type":"agent.session.idle","event_id":"$id","session":{"status":"idle"}}"""

    private fun call(
        id: String = "call",
        args: String = "{\"nested\":{\"value\":1}}",
        turn: String = "root",
        event: String = id,
        name: String = "tool",
    ) =
        """{"type":"agent.session.turn.item.added","event_id":"$event","session_id":"s","turn_id":"$turn","item":{"id":"i","type":"function_call","name":"$name","call_id":"$id","turn_id":"$turn","arguments":$args,"status":"in_progress"}}"""

    private inner class Transport(
        var events: List<String> = listOf(turn("created"), turn("completed"), idle())
    ) : HttpClient {
        val liveResponses = AtomicInteger()
        val retrieveStarted = java.util.concurrent.CountDownLatch(1)
        val inputStarted = java.util.concurrent.CountDownLatch(1)
        var deferredRetrieve: CompletableFuture<HttpResponse>? = null
        var deferredInput: CompletableFuture<HttpResponse>? = null
        var deferredInputFrom = 1
        var blockedPost = 0
        val postStarted = java.util.concurrent.CountDownLatch(1)
        val releasePost = java.util.concurrent.CountDownLatch(1)
        var inputResponse: HttpResponse? = null
        val requests = java.util.Collections.synchronizedList(mutableListOf<HttpRequest>())
        val options = java.util.Collections.synchronizedList(mutableListOf<RequestOptions>())
        val posts = java.util.Collections.synchronizedList(mutableListOf<JsonNode>())
        var status = "idle"
        var postError: String? = null
        var postErrors = 0
        var errorFromPost = 1
        var ambiguousFromPost = 0
        var ambiguousRemaining = 0
        var ambiguousIOException = false
        val openStarted = java.util.concurrent.CountDownLatch(1)
        val responseClosed = java.util.concurrent.CountDownLatch(1)
        var opened = false
        var streamClosed = false
        var deferredOpen: CompletableFuture<HttpResponse>? = null
        var streamBody: java.io.InputStream? = null

        fun response(body: String, code: Int = 200, stream: Boolean = false): HttpResponse =
            object : HttpResponse {
                val bodyIsClosed = java.util.concurrent.atomic.AtomicBoolean()
                val bytes =
                    object : ByteArrayInputStream(body.toByteArray()) {
                        override fun close() {
                            if (bodyIsClosed.compareAndSet(false, true))
                                liveResponses.decrementAndGet()
                            super.close()
                        }
                    }
                val responseIsClosed = java.util.concurrent.atomic.AtomicBoolean()

                init {
                    liveResponses.incrementAndGet()
                }

                override fun statusCode() = code

                override fun headers() =
                    Headers.builder()
                        .put(
                            "Content-Type",
                            if (stream) "text/event-stream" else "application/json",
                        )
                        .build()

                override fun body() = if (stream) streamBody ?: bytes else bytes

                override fun close() {
                    if (!responseIsClosed.compareAndSet(false, true)) return
                    bytes.close()
                    if (stream) {
                        streamBody?.close()
                        streamClosed = true
                        responseClosed.countDown()
                    }
                }
            }

        override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse {
            requests.add(request)
            options.add(requestOptions)
            return when {
                request.method == HttpMethod.POST -> {
                    check(opened) { "input submitted before subscription" }
                    val bytes = ByteArrayOutputStream()
                    request.body!!.writeTo(bytes)
                    posts.add(mapper.readTree(bytes.toByteArray()))
                    if (posts.size == blockedPost) {
                        postStarted.countDown()
                        check(releasePost.await(10, TimeUnit.SECONDS))
                    }
                    if (posts.size >= ambiguousFromPost && ambiguousRemaining-- > 0) {
                        if (ambiguousIOException)
                            throw java.io.IOException("synthetic ambiguous delivery")
                        return response(
                            """{"error":{"message":"synthetic ambiguous delivery","type":"server_error"}}""",
                            503,
                        )
                    }
                    if (posts.size >= errorFromPost && postErrors-- > 0) response(postError!!, 400)
                    else response("", 204)
                }
                request.pathSegments.last() == "events" -> {
                    opened = true
                    response(events.joinToString("") { "data: $it\n\n" }, stream = true)
                }
                else -> response("""{"status":"$status"}""")
            }
        }

        override fun executeAsync(
            request: HttpRequest,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> {
            if (
                request.method == HttpMethod.GET &&
                    request.pathSegments.last() != "events" &&
                    deferredRetrieve != null
            ) {
                requests.add(request)
                options.add(requestOptions)
                retrieveStarted.countDown()
                return deferredRetrieve!!
            }
            if (
                request.method == HttpMethod.POST &&
                    deferredInput != null &&
                    posts.size + 1 >= deferredInputFrom
            ) {
                inputResponse = execute(request, requestOptions)
                inputStarted.countDown()
                return deferredInput!!
            }
            if (
                request.method == HttpMethod.GET &&
                    request.pathSegments.last() == "events" &&
                    deferredOpen != null
            ) {
                requests.add(request)
                options.add(requestOptions)
                openStarted.countDown()
                return deferredOpen!!
            }
            return try {
                CompletableFuture.completedFuture(execute(request, requestOptions))
            } catch (error: Exception) {
                CompletableFuture<HttpResponse>().apply { completeExceptionally(error) }
            }
        }

        override fun close() {}

        fun client() =
            OpenAIClientImpl(
                ClientOptions.builder()
                    .httpClient(this)
                    .apiKey("synthetic")
                    .streamHandlerExecutor(direct)
                    .build()
            )
    }

    private fun params() = AgentSessionStreamParams.builder().sessionId("s").input("hello")

    private fun consume(
        t: Transport,
        async: Boolean,
        params: AgentSessionStreamParams = params().build(),
        requestTimeout: Duration = Duration.ofSeconds(9),
        completionTimeoutSeconds: Long = 10,
        action: (AgentSessionEvent) -> Unit = {},
    ): List<AgentSessionEvent> {
        val events = mutableListOf<AgentSessionEvent>()
        val options =
            RequestOptions.builder().timeout(requestTimeout).responseValidation(false).build()
        val client = t.client()
        if (async)
            client
                .async()
                .beta()
                .agents()
                .sessions()
                .stream(params, options)
                .subscribe {
                    events.add(it)
                    action(it)
                }
                .onCompleteFuture()
                .get(completionTimeoutSeconds, TimeUnit.SECONDS)
        else
            client.beta().agents().sessions().stream(params, options).use {
                it.stream().forEach {
                    events.add(it)
                    action(it)
                }
            }
        assertThat(t.liveResponses.get()).isZero()
        return events
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun lifecycleAndContext(async: Boolean) {
        for (ending in listOf("completed", "failed", "cancelled")) {
            val t =
                Transport(
                    listOf(
                        idle("initial"),
                        turn("created", "child", "sub"),
                        turn("completed", "child", "sub"),
                        idle("child-idle"),
                        turn("created"),
                        turn(ending),
                        idle(),
                        call(),
                    )
                )
            val p =
                params()
                    .idempotencyKey("named")
                    .putAdditionalHeader("iDeMpOtEnCy-KeY", "override")
                    .putAdditionalHeader("x-context", "kept")
                    .putAdditionalHeader("OpenAI-Beta", "custom")
                    .build()
            val events = consume(t, async, p)
            assertThat(events).hasSize(7)
            assertThat(events.last().isIdle()).isTrue()
            assertThat(t.posts.single().path("events").first().path("type").asText())
                .isEqualTo("agent.session.input.message")
            assertThat(t.streamClosed).isTrue()
            assertThat(t.requests.map { it.method })
                .containsExactly(HttpMethod.GET, HttpMethod.GET, HttpMethod.POST)
            t.requests.forEach {
                assertThat(it.headers.values("x-context")).containsExactly("kept")
                assertThat(it.headers.values("OpenAI-Beta")).containsExactly("custom")
            }
            assertThat(t.requests.last().headers.values("Idempotency-Key"))
                .containsExactly("override")
            assertThat(t.requests.first().headers.values("Idempotency-Key")).isEmpty()
            assertThat(t.options.map { it.timeout?.request() }).containsOnly(Duration.ofSeconds(9))
            assertThat(t.options.map { it.responseValidation }).containsOnly(false)
            assertThat(
                    t.posts
                        .single()
                        .path("events")
                        .first()
                        .path("input")
                        .first()
                        .path("content")
                        .first()
                        .path("text")
                        .asText()
                )
                .isEqualTo("hello")
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun toolsPreserveEventsAndDeduplicateFullCallIdentity(async: Boolean) {
        val count = AtomicInteger()
        val first = call()
        val t =
            Transport(
                listOf(
                    turn("created"),
                    first,
                    first,
                    call(event = "redelivery"),
                    call(turn = "child", event = "child"),
                    call(id = "manual", name = "unknown"),
                    turn("completed"),
                    idle(),
                )
            )
        val p =
            params()
                .putAdditionalHeader("Idempotency-Key", "input")
                .putAdditionalHeader("x-context", "kept")
                .toolHandler("tool") { args ->
                    count.incrementAndGet()
                    @Suppress("UNCHECKED_CAST")
                    val nested = args["nested"] as MutableMap<String, Any?>
                    nested["value"] = 99
                    mapOf("answer" to "done")
                }
                .build()
        val events = consume(t, async, p)
        assertThat(events).hasSize(7)
        assertThat(count.get()).isEqualTo(2)
        assertThat(
                mapper
                    .valueToTree<JsonNode>(events[1])
                    .path("item")
                    .path("arguments")
                    .path("nested")
                    .path("value")
                    .asInt()
            )
            .isEqualTo(1)
        assertThat(t.posts).hasSize(3)
        assertThat(t.posts.drop(1).map { it.path("events").first().path("type").asText() })
            .containsOnly("agent.session.input.tool_result")
        assertThat(t.posts[1].path("events").first().path("output").asText())
            .isEqualTo("{\"answer\":\"done\"}")
        val keys =
            t.requests
                .filter { it.method == HttpMethod.POST }
                .map { it.headers.values("Idempotency-Key").single() }
        assertThat(keys.toSet()).hasSize(3)
        t.requests.forEach { assertThat(it.headers.values("x-context")).containsExactly("kept") }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun invalidArgumentsAndHandlerFailuresAreRedacted(async: Boolean) {
        for (args in listOf("[]", "\"bad json\"", "null", "{\"valid\":true}")) {
            val t = Transport(listOf(turn("created"), call(args = args), turn("completed"), idle()))
            consume(
                t,
                async,
                params()
                    .toolHandler("tool") { throw IllegalStateException("secret fixture") }
                    .build(),
            )
            val result = t.posts.last().path("events").first()
            assertThat(result.path("success").asBoolean()).isFalse()
            assertThat(result.path("error").asText()).isEqualTo("Tool handler failed.")
            assertThat(result.toString()).doesNotContain("secret fixture")
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun eofAndNonIdleAndConsumerErrorsClose(async: Boolean) {
        val eof = Transport(listOf(turn("created")))
        assertThatThrownBy { consume(eof, async) }
            .hasStackTraceContaining("before the turn reached idle")
        assertThat(eof.streamClosed).isTrue()
        val busy = Transport().apply { status = "in_progress" }
        assertThatThrownBy { consume(busy, async) }
            .hasStackTraceContaining("requires an idle session")
        assertThat(busy.requests).hasSize(1)
        val consumer = Transport()
        assertThatThrownBy {
                consume(consumer, async) { throw IllegalStateException("consumer failed") }
            }
            .hasStackTraceContaining("consumer failed")
        assertThat(consumer.streamClosed).isTrue()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun inputFailureClosesAndSessionFailureIsVisible(async: Boolean) {
        val t =
            Transport().apply {
                postError =
                    """{"error":{"code":"bad","message":"input rejected","type":"invalid_request_error"}}"""
                postErrors = 1
            }
        assertThatThrownBy { consume(t, async) }.hasStackTraceContaining("input rejected")
        assertThat(t.streamClosed).isTrue()
        val failed =
            Transport(
                listOf(
                    """{"type":"agent.session.failed","event_id":"failed","session":{"status":"failed"}}"""
                )
            )
        assertThat(consume(failed, async).single().isFailed()).isTrue()
        assertThat(failed.streamClosed).isTrue()
    }

    @Test
    fun asyncWaitsForToolAndCancellationCloses() {
        val t =
            Transport(
                listOf(turn("created"), call(), call(id = "second"), turn("completed"), idle())
            )
        val result = CompletableFuture<String>()
        val invoked = AtomicInteger()
        val p =
            params()
                .asyncToolHandler("tool") {
                    invoked.incrementAndGet()
                    result
                }
                .build()
        val stream = t.client().async().beta().agents().sessions().stream(p)
        val events = java.util.Collections.synchronizedList(mutableListOf<AgentSessionEvent>())
        stream.subscribe { events.add(it) }
        val deadline = System.nanoTime() + TimeUnit.SECONDS.toNanos(10)
        while (invoked.get() == 0 && System.nanoTime() < deadline) Thread.yield()
        assertThat(invoked.get()).isEqualTo(1)
        assertThat(events).hasSize(2)
        stream.onCompleteFuture().cancel(true)
        assertThat(t.streamClosed).isTrue()
        assertThat(result.isCancelled).isTrue()
        assertThat(t.posts).hasSize(1)
    }

    @Test
    fun closingDuringAsyncOpenClosesLateResponse() {
        val t = Transport().apply { deferredOpen = CompletableFuture() }
        val stream = t.client().async().beta().agents().sessions().stream(params().build())
        stream.subscribe { fail<Unit>("No events expected") }
        assertThat(t.openStarted.await(10, TimeUnit.SECONDS)).isTrue()
        stream.close()
        t.deferredOpen!!.complete(t.response("", stream = true))
        assertThat(t.responseClosed.await(10, TimeUnit.SECONDS)).isTrue()
        assertThat(t.streamClosed).isTrue()
        assertThat(t.posts).isEmpty()
    }

    @Test
    fun closeBeforeSubscribeDoesNotStartRequests() {
        val t = Transport()
        val stream = t.client().async().beta().agents().sessions().stream(params().build())
        stream.close()
        assertThat(stream.onCompleteFuture().isDone).isTrue()
        assertThatThrownBy { stream.subscribe {} }.isInstanceOf(IllegalStateException::class.java)
        assertThat(t.requests).isEmpty()
    }

    @ParameterizedTest
    @ValueSource(strings = ["retrieve", "input"])
    fun closeDuringPendingRequestNotifiesOnceAndClosesLateResponse(stage: String) {
        val t =
            Transport().apply {
                if (stage == "retrieve") deferredRetrieve = CompletableFuture()
                else deferredInput = CompletableFuture()
            }
        val notifications = AtomicInteger()
        val notified = java.util.concurrent.CountDownLatch(1)
        val stream = t.client().async().beta().agents().sessions().stream(params().build())
        stream.subscribe(
            object : AsyncStreamResponse.Handler<AgentSessionEvent> {
                override fun onNext(value: AgentSessionEvent) {
                    fail<Unit>("No events expected")
                }

                override fun onComplete(error: java.util.Optional<Throwable>) {
                    assertThat(error).isEmpty()
                    notifications.incrementAndGet()
                    notified.countDown()
                }
            }
        )
        assertThat(
                (if (stage == "retrieve") t.retrieveStarted else t.inputStarted).await(
                    10,
                    TimeUnit.SECONDS,
                )
            )
            .isTrue()
        stream.close()
        assertThat(notified.await(10, TimeUnit.SECONDS)).isTrue()
        if (stage == "retrieve") t.deferredRetrieve!!.complete(t.response("""{"status":"idle"}"""))
        else {
            assertThat(t.streamClosed).isTrue()
            t.deferredInput!!.complete(t.inputResponse!!)
        }
        val deadline = System.nanoTime() + TimeUnit.SECONDS.toNanos(10)
        while (t.liveResponses.get() != 0 && System.nanoTime() < deadline) Thread.yield()
        assertThat(t.liveResponses.get()).isZero()
        assertThat(notifications.get()).isEqualTo(1)
        assertThat(t.posts).hasSize(if (stage == "retrieve") 0 else 1)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun closeDoesNotWaitForClaimedToolPostOrStartAnother(async: Boolean) {
        val t =
            Transport(listOf(turn("created"), call(), call("second"), turn("completed"), idle()))
        if (async) {
            t.deferredInput = CompletableFuture()
            t.deferredInputFrom = 2
        } else t.blockedPost = 2
        val invoked = AtomicInteger()
        val p =
            params()
                .toolHandler("tool") {
                    invoked.incrementAndGet()
                    "done"
                }
                .build()
        val executor = java.util.concurrent.Executors.newFixedThreadPool(2)
        val client = t.client()
        val stream: AutoCloseable
        val consumed: CompletableFuture<*>?
        val asyncStream: AsyncStreamResponse<AgentSessionEvent>?
        if (async) {
            asyncStream = client.async().beta().agents().sessions().stream(p)
            stream = AutoCloseable { asyncStream.close() }
            consumed = null
            asyncStream.subscribe {}
        } else {
            asyncStream = null
            val syncStream = client.beta().agents().sessions().stream(p)
            stream = syncStream
            consumed = CompletableFuture.runAsync({ syncStream.stream().forEach {} }, executor)
        }
        try {
            assertThat((if (async) t.inputStarted else t.postStarted).await(10, TimeUnit.SECONDS))
                .isTrue()
            executor.submit { stream.close() }.get(1, TimeUnit.SECONDS)
            assertThat(t.streamClosed).isTrue()
            assertThat(invoked.get()).isEqualTo(1)
            assertThat(t.posts).hasSize(2)
            if (async) {
                assertThat(asyncStream!!.onCompleteFuture().isDone).isTrue()
                t.deferredInput!!.complete(t.inputResponse!!)
            } else {
                t.releasePost.countDown()
                consumed!!.get(10, TimeUnit.SECONDS)
            }
            val deadline = System.nanoTime() + TimeUnit.SECONDS.toNanos(10)
            while (t.liveResponses.get() != 0 && System.nanoTime() < deadline) Thread.yield()
            assertThat(t.liveResponses.get()).isZero()
            assertThat(invoked.get()).isEqualTo(1)
            assertThat(t.posts).hasSize(2)
        } finally {
            t.releasePost.countDown()
            stream.close()
            executor.shutdownNow()
            client.close()
        }
    }

    @Test
    fun closingHungOpenNotifiesSubscriberWithoutWaitingForNetwork() {
        val t = Transport().apply { deferredOpen = CompletableFuture() }
        val completed = java.util.concurrent.CountDownLatch(1)
        val stream = t.client().async().beta().agents().sessions().stream(params().build())
        stream.subscribe(
            object : AsyncStreamResponse.Handler<AgentSessionEvent> {
                override fun onNext(value: AgentSessionEvent) {
                    fail<Unit>("No events expected")
                }

                override fun onComplete(error: java.util.Optional<Throwable>) {
                    assertThat(error).isEmpty()
                    completed.countDown()
                }
            }
        )
        assertThat(t.openStarted.await(10, TimeUnit.SECONDS)).isTrue()
        stream.close()
        assertThat(completed.await(10, TimeUnit.SECONDS)).isTrue()
        assertThat(t.deferredOpen!!.isDone).isFalse()
        t.deferredOpen!!.complete(t.response("", stream = true))
        assertThat(t.responseClosed.await(10, TimeUnit.SECONDS)).isTrue()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun registrationRaceAndAmbiguousDeliveryReuseDistinctKeys(async: Boolean) {
        val count = AtomicInteger()
        val t =
            Transport(listOf(turn("created"), call(), turn("completed"), idle())).apply {
                errorFromPost = 3
                postError =
                    """{"error":{"code":"invalid_request_error","message":"Unknown pending tool call: call","type":"invalid_request_error"}}"""
                postErrors = 2
                ambiguousFromPost = 1
                ambiguousRemaining = 1
            }
        consume(
            t,
            async,
            params()
                .toolHandler("tool") {
                    count.incrementAndGet()
                    "done"
                }
                .build(),
        )
        assertThat(count.get()).isEqualTo(1)
        val keys =
            t.requests
                .filter { it.method == HttpMethod.POST }
                .map { it.headers.values("Idempotency-Key").single() }
        assertThat(keys).hasSize(5)
        assertThat(keys[0]).isEqualTo(keys[1])
        assertThat(keys.drop(2).toSet()).hasSize(1)
        assertThat(keys[0]).isNotEqualTo(keys[2])
        assertThat(t.streamClosed).isTrue()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun unrelatedToolErrorsAreNotRetriedAndKnownRaceIsBounded(async: Boolean) {
        for (message in listOf("another failure", "Unknown pending tool call: call")) {
            val t =
                Transport(listOf(turn("created"), call(), turn("completed"), idle())).apply {
                    errorFromPost = 2
                    postError =
                        """{"error":{"code":"invalid_request_error","message":"$message","type":"invalid_request_error"}}"""
                    postErrors = 8
                }
            assertThatThrownBy { consume(t, async, params().toolHandler("tool") { null }.build()) }
                .hasStackTraceContaining(message)
            assertThat(t.posts).hasSize(if (message.startsWith("Unknown")) 5 else 2)
            assertThat(t.streamClosed).isTrue()
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun supportedToolOutputsAndFreshDefaultKeys(async: Boolean) {
        val outputs =
            listOf(
                null,
                "text",
                listOf(
                    InputContentParam.ofInputText(
                        InputContentParam.InputText.builder().text("block").build()
                    )
                ),
            )
        for (output in outputs) {
            val t =
                Transport(
                    listOf(
                        turn("created"),
                        call(args = "\"{\\\"a\\\":1}\""),
                        turn("completed"),
                        idle(),
                    )
                )
            consume(t, async, params().toolHandler("tool") { output }.build())
            assertThat(t.posts.last().path("events").first().path("success").asBoolean()).isTrue()
        }
        val p = params().build()
        val first = Transport()
        val second = Transport()
        consume(first, async, p)
        consume(second, async, p)
        assertThat(first.requests.last().headers.values("Idempotency-Key"))
            .isNotEqualTo(second.requests.last().headers.values("Idempotency-Key"))
    }

    @Test
    fun existingAsyncTransportIOExceptionPropagatesAndClosesHelper() {
        val t =
            Transport().apply {
                ambiguousFromPost = 1
                ambiguousRemaining = 1
                ambiguousIOException = true
            }
        assertThatThrownBy { consume(t, true) }
            .hasStackTraceContaining("synthetic ambiguous delivery")
        assertThat(t.streamClosed).isTrue()
        // Existing async transport doesn't unwrap CompletionException for its retry predicate.
        assertThat(t.posts).hasSize(1)
        assertThat(t.requests.last().headers.values("Idempotency-Key")).hasSize(1)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun toolAcceptedThen503ReusesKeyWithoutRepeatingHandler(async: Boolean) {
        val t =
            Transport(listOf(turn("created"), call(), turn("completed"), idle())).apply {
                ambiguousFromPost = 2
                ambiguousRemaining = 1
            }
        val invoked = AtomicInteger()
        consume(
            t,
            async,
            params()
                .toolHandler("tool") {
                    invoked.incrementAndGet()
                    "done"
                }
                .build(),
        )
        assertThat(invoked.get()).isEqualTo(1)
        val keys =
            t.requests
                .filter { it.method == HttpMethod.POST }
                .map { it.headers.values("Idempotency-Key").single() }
        assertThat(keys).hasSize(3)
        assertThat(keys[0]).isNotEqualTo(keys[1])
        assertThat(keys[1]).isEqualTo(keys[2])
    }

    @Test
    fun asyncHandlerCompletionResumesInOrder() {
        val t =
            Transport(
                listOf(turn("created"), call(), call(id = "second"), turn("completed"), idle())
            )
        val result = CompletableFuture<String>()
        val started = java.util.concurrent.CountDownLatch(1)
        val invoked = AtomicInteger()
        val p =
            params()
                .asyncToolHandler("tool") {
                    if (invoked.incrementAndGet() == 1) {
                        started.countDown()
                        result
                    } else CompletableFuture.completedFuture("second")
                }
                .build()
        val stream = t.client().async().beta().agents().sessions().stream(p)
        stream.subscribe {}
        assertThat(started.await(10, TimeUnit.SECONDS)).isTrue()
        assertThat(invoked.get()).isEqualTo(1)
        assertThat(t.posts).hasSize(1)
        result.complete("first")
        stream.onCompleteFuture().get(10, TimeUnit.SECONDS)
        assertThat(invoked.get()).isEqualTo(2)
        assertThat(t.posts.drop(1).map { it.path("events").first().path("output").asText() })
            .containsExactly("first", "second")
        assertThat(t.streamClosed).isTrue()
    }

    @Test
    fun syncIteratorDeliversCallBeforeInvokingHandler() {
        val t = Transport(listOf(turn("created"), call(), turn("completed"), idle()))
        val invoked = AtomicInteger()
        t.client()
            .beta()
            .agents()
            .sessions()
            .stream(
                params()
                    .toolHandler("tool") {
                        invoked.incrementAndGet()
                        null
                    }
                    .build()
            )
            .use {
                val iterator = it.stream().iterator()
                iterator.next()
                assertThat(iterator.next().isTurnItemAdded()).isTrue()
                assertThat(invoked.get()).isZero()
            }
        assertThat(invoked.get()).isZero()
        assertThat(t.streamClosed).isTrue()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun recentEventCacheStaysBoundedButCallDedupLastsWholeTurn(async: Boolean) {
        val count = AtomicInteger()
        val events =
            listOf(turn("created"), call()) +
                (1..1030).map { idle("idle-$it") } +
                listOf(call(), turn("completed"), idle())
        val t = Transport(events)
        assertThat(
                consume(
                    t,
                    async,
                    params()
                        .toolHandler("tool") {
                            count.incrementAndGet()
                            null
                        }
                        .build(),
                    requestTimeout = Duration.ofSeconds(60),
                    completionTimeoutSeconds = 70,
                )
            )
            .hasSize(events.size)
        assertThat(count.get()).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun consumersCannotMutateCallArgumentsOrRoute(async: Boolean) {
        val t = Transport(listOf(turn("created"), call(), turn("completed"), idle()))
        var seen: Any? = null
        consume(
            t,
            async,
            params()
                .toolHandler("tool") {
                    seen = (it["nested"] as Map<*, *>)["value"]
                    "done"
                }
                .build(),
        ) { event ->
            if (event.isTurnItemAdded()) {
                val call = event.asTurnItemAdded().item().asFunctionCall()
                @Suppress("UNCHECKED_CAST")
                val args =
                    call._arguments().asObject().get()
                        as MutableMap<String, com.openai.core.JsonValue>
                assertThatThrownBy { args.clear() }
                    .isInstanceOf(UnsupportedOperationException::class.java)
                @Suppress("UNCHECKED_CAST")
                val nested =
                    args.getValue("nested").asObject().get()
                        as MutableMap<String, com.openai.core.JsonValue>
                assertThatThrownBy { nested.clear() }
                    .isInstanceOf(UnsupportedOperationException::class.java)
                call.toBuilder().name("other").callId("other").turnId("other").build()
            }
        }
        assertThat(seen).isEqualTo(1)
        assertThat(t.posts.last().path("events").first().path("call_id").asText()).isEqualTo("call")
    }

    @Test
    fun asyncCloseUnblocksReadWithoutReportingEofError() {
        val reading = java.util.concurrent.CountDownLatch(1)
        val released = java.util.concurrent.CountDownLatch(1)
        val finished = java.util.concurrent.CountDownLatch(1)
        val t =
            Transport().apply {
                streamBody =
                    object : java.io.InputStream() {
                        override fun read(): Int {
                            reading.countDown()
                            check(released.await(10, TimeUnit.SECONDS))
                            return -1
                        }

                        override fun close() {
                            released.countDown()
                        }
                    }
            }
        val executor = java.util.concurrent.Executors.newSingleThreadExecutor()
        try {
            val stream = t.client().async().beta().agents().sessions().stream(params().build())
            var completionError: Throwable? = null
            stream.subscribe(
                object : AsyncStreamResponse.Handler<AgentSessionEvent> {
                    override fun onNext(value: AgentSessionEvent) {
                        fail<Unit>("No events expected")
                    }

                    override fun onComplete(error: java.util.Optional<Throwable>) {
                        completionError = error.orElse(null)
                        finished.countDown()
                    }
                },
                executor,
            )
            assertThat(reading.await(10, TimeUnit.SECONDS)).isTrue()
            stream.close()
            assertThat(finished.await(10, TimeUnit.SECONDS)).isTrue()
            assertThat(completionError).isNull()
            assertThat(t.streamClosed).isTrue()
        } finally {
            released.countDown()
            executor.shutdownNow()
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun cancelledHandlerStageProducesRedactedFailure(async: Boolean) {
        val t = Transport(listOf(turn("created"), call(), turn("completed"), idle()))
        consume(
            t,
            async,
            params()
                .asyncToolHandler("tool") { CompletableFuture<String>().apply { cancel(false) } }
                .build(),
        )
        val result = t.posts.last().path("events").first()
        assertThat(result.path("success").asBoolean()).isFalse()
        assertThat(result.path("error").asText()).isEqualTo("Tool handler failed.")
        assertThat(t.streamClosed).isTrue()
    }

    @Test
    fun simultaneousCloseAndSubscribeAlwaysCompletesAcceptedSubscriber() {
        val threads = java.util.concurrent.Executors.newFixedThreadPool(2)
        try {
            repeat(32) {
                val t = Transport().apply { deferredRetrieve = CompletableFuture() }
                val client = t.client()
                val stream = client.async().beta().agents().sessions().stream(params().build())
                val start = java.util.concurrent.CountDownLatch(1)
                val notified = java.util.concurrent.CountDownLatch(1)
                val notifications = AtomicInteger()
                val callback =
                    object : AsyncStreamResponse.Handler<AgentSessionEvent> {
                        override fun onNext(value: AgentSessionEvent) {
                            fail<Unit>("No events expected")
                        }

                        override fun onComplete(error: java.util.Optional<Throwable>) {
                            notifications.incrementAndGet()
                            notified.countDown()
                        }
                    }
                try {
                    val subscribing =
                        CompletableFuture.supplyAsync(
                            {
                                start.await()
                                try {
                                    stream.subscribe(callback)
                                    true
                                } catch (closed: IllegalStateException) {
                                    false
                                }
                            },
                            threads,
                        )
                    val closing =
                        CompletableFuture.runAsync(
                            {
                                start.await()
                                stream.close()
                            },
                            threads,
                        )
                    start.countDown()
                    val accepted = subscribing.get(10, TimeUnit.SECONDS)
                    closing.get(10, TimeUnit.SECONDS)
                    if (accepted) {
                        assertThat(notified.await(10, TimeUnit.SECONDS)).isTrue()
                        assertThat(notifications.get()).isEqualTo(1)
                    }
                    assertThat(stream.onCompleteFuture().isDone).isTrue()
                    if (t.requests.isNotEmpty())
                        t.deferredRetrieve!!.complete(t.response("""{"status":"idle"}"""))
                    assertThat(t.posts).isEmpty()
                } finally {
                    stream.close()
                    client.close()
                }
            }
        } finally {
            threads.shutdownNow()
        }
    }

    @Test
    fun outputTextIsPureAndIgnoresPhase() {
        val message =
            mapper.readValue(
                """{"id":"m","type":"message","role":"assistant","status":"completed","turn_id":"root","phase":"commentary","content":[{"type":"output_text","text":"a"},{"type":"input_text","text":"ignore"},{"type":"output_text","text":"b"}]}""",
                AgentSessionMessage::class.java,
            )
        val before = mapper.writeValueAsString(message)
        assertThat(AgentSessionMessages.outputText(message)).isEqualTo("ab")
        assertThat(mapper.writeValueAsString(message)).isEqualTo(before)
    }
}
