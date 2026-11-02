package com.openai.helpers

import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import com.openai.core.ClientOptions
import com.openai.core.JsonArray
import com.openai.core.JsonObject
import com.openai.core.JsonValue
import com.openai.core.RequestOptions
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.WebSocketClient
import com.openai.core.http.WebSocketWriteNotAttempted
import com.openai.core.jsonMapper
import com.openai.helpers.RealtimeConnection.ResponseInput
import com.openai.models.realtime.ConversationItem
import com.openai.models.realtime.RealtimeClientEvent
import com.openai.models.realtime.RealtimeConversationItemFunctionCallOutput
import com.openai.models.realtime.RealtimeResponseCreateParams
import com.openai.models.realtime.ResponseCreateEvent
import java.io.File
import java.io.IOException
import java.io.StringWriter
import java.nio.file.Files
import java.nio.file.Path
import java.time.Duration
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CountDownLatch
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import javax.tools.ToolProvider
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout
import org.junit.jupiter.api.io.TempDir
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@Timeout(20)
class RealtimeResponseInputTest {
    private val mapper = jsonMapper()
    private val configurations = mutableListOf<ClientOptions>()

    @AfterEach
    fun closeConfigurations() {
        configurations.forEach { it.close() }
    }

    private fun ordinary() =
        ConversationItem.ofFunctionCallOutput(
            RealtimeConversationItemFunctionCallOutput.builder()
                .callId("call_1")
                .output("tool result λ")
                .build()
        )

    private fun options(peer: Peer, activeMapper: JsonMapper = mapper) =
        ClientOptions.builder()
            .httpClient(peer)
            .apiKey("fake-reference-test-key")
            .jsonMapper(activeMapper)
            .build()
            .also { configurations.add(it) }

    @Test
    fun mixedInputsReplaceOnlyEffectiveInputAndEmptyListClearsIt() {
        val event =
            mapper.readValue(
                """{"type":"response.create","event_id":"evt_1","future":{"ok":true},"response":{"instructions":"retain","input":[{"old":true}],"extra":{"count":3}}}""",
                ResponseCreateEvent::class.java,
            )
        val before = mapper.writeValueAsString(event)
        val peer = Peer()
        RealtimeConnection.connect(options(peer)).use { connection ->
            connection.sendResponseCreate(
                event,
                listOf(ResponseInput.ofReference("item_prior-1"), ResponseInput.ofItem(ordinary())),
            )
            assertThat(mapper.readTree(peer.messages.poll(5, TimeUnit.SECONDS)))
                .isEqualTo(
                    mapper.readTree(
                        """{"type":"response.create","event_id":"evt_1","future":{"ok":true},"response":{"instructions":"retain","input":[{"type":"item_reference","id":"item_prior-1"},{"type":"function_call_output","call_id":"call_1","output":"tool result λ","object":"realtime.item"}],"extra":{"count":3}}}"""
                    )
                )
            connection.sendResponseCreate(event, emptyList())
            val empty = mapper.readTree(peer.messages.poll(5, TimeUnit.SECONDS))
            assertThat(empty.path("response").path("input")).isEqualTo(mapper.createArrayNode())
            assertThat(empty.path("event_id").asText()).isEqualTo("evt_1")
            assertThat(mapper.writeValueAsString(event)).isEqualTo(before)
            assertThat(peer.messages).isEmpty()
        }
    }

    private fun configuredMapper(onSerialize: () -> Unit): JsonMapper =
        mapper.copy().apply {
            registerModule(
                SimpleModule()
                    .addSerializer(
                        RealtimeConversationItemFunctionCallOutput::class.java,
                        object :
                            StdSerializer<RealtimeConversationItemFunctionCallOutput>(
                                RealtimeConversationItemFunctionCallOutput::class.java
                            ) {
                            override fun serialize(
                                value: RealtimeConversationItemFunctionCallOutput,
                                out: JsonGenerator,
                                provider: SerializerProvider,
                            ) {
                                onSerialize()
                                out.writeStartObject()
                                out.writeStringField("type", "function_call_output")
                                out.writeStringField("call_id", value.callId())
                                out.writeStringField("output", value.output())
                                out.writeBooleanField("custom_mapper", true)
                                out.writeEndObject()
                            }
                        },
                    )
            )
        }

    @Test
    fun ordinaryInputUsesTheActiveMapper() {
        val calls = AtomicInteger()
        val peer = Peer()
        RealtimeConnection.connect(options(peer, configuredMapper { calls.incrementAndGet() }))
            .use {
                it.sendResponseCreate(
                    ResponseCreateEvent.builder().build(),
                    listOf(ResponseInput.ofItem(ordinary())),
                )
                val input =
                    mapper
                        .readTree(peer.messages.poll(5, TimeUnit.SECONDS))
                        .path("response")
                        .path("input")
                        .get(0)
                assertThat(input.path("custom_mapper").asBoolean()).isTrue()
                assertThat(input.path("output").asText()).isEqualTo("tool result λ")
                assertThat(calls.get()).isEqualTo(1)
            }
    }

    @Test
    fun unusedKnownInputIsNotSerializedAndTheOriginalEventIsRetained() {
        val old = ordinary()
        val event =
            ResponseCreateEvent.builder()
                .eventId("replace")
                .response(
                    RealtimeResponseCreateParams.builder()
                        .instructions("retain")
                        .input(listOf(old))
                        .build()
                )
                .build()
        val calls = AtomicInteger()
        val peer = Peer()
        val active = configuredMapper {
            calls.incrementAndGet()
            throw IOException("old ordinary input must not be evaluated")
        }
        RealtimeConnection.connect(options(peer, active)).use { connection ->
            connection.sendResponseCreate(event, listOf(ResponseInput.ofReference("item_prior")))
            assertThat(mapper.readTree(peer.messages.poll(5, TimeUnit.SECONDS)))
                .isEqualTo(
                    mapper.readTree(
                        """{"type":"response.create","event_id":"replace","response":{"instructions":"retain","input":[{"type":"item_reference","id":"item_prior"}]}}"""
                    )
                )
            assertThat(calls.get()).isZero()
            assertThat(event.response().get().input().get()).containsExactly(old)
            assertThat(
                    mapper
                        .readTree(mapper.writeValueAsString(event))
                        .at("/response/input/0/output")
                        .asText()
                )
                .isEqualTo("tool result λ")
            assertThat(peer.messages).isEmpty()
        }
    }

    @Test
    fun onlyTheKnownInputExtraIsDiscardedWithoutEvaluatingItsSerializer() {
        val oldInput = JsonArray.of(listOf(JsonValue.from("old")))
        val original =
            RealtimeResponseCreateParams.builder()
                .instructions("retain")
                .putAdditionalProperty("input", oldInput)
                .putAdditionalProperty("future_text", JsonValue.from("still here"))
                .build()
        val event = ResponseCreateEvent.builder().eventId("extra").response(original).build()
        val peer = Peer()
        RealtimeConnection.connect(options(peer, failingMapper(JsonArray::class.java))).use {
            connection ->
            connection.sendResponseCreate(event, listOf(ResponseInput.ofReference("item_prior")))
            assertThat(mapper.readTree(peer.messages.poll(5, TimeUnit.SECONDS)))
                .isEqualTo(
                    mapper.readTree(
                        """{"type":"response.create","event_id":"extra","response":{"instructions":"retain","future_text":"still here","input":[{"type":"item_reference","id":"item_prior"}]}}"""
                    )
                )
            assertThat(event._response().asKnown().get()).isSameAs(original)
            assertThat(original._additionalProperties())
                .containsEntry("input", oldInput)
                .containsEntry("future_text", JsonValue.from("still here"))
            assertThat(peer.messages).isEmpty()
        }

        // The same supported encoder must still fail for an effective, unrelated extra field.
        val effective =
            event
                .toBuilder()
                .response(
                    original
                        .toBuilder()
                        .removeAdditionalProperty("input")
                        .putAdditionalProperty("future_array", oldInput)
                        .build()
                )
                .build()
        val refused = Peer()
        RealtimeConnection.connect(options(refused, failingMapper(JsonArray::class.java))).use {
            connection ->
            assertThatThrownBy {
                    connection.sendResponseCreate(
                        effective,
                        listOf(ResponseInput.ofReference("item_prior")),
                    )
                }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("deliberate active serializer failure")
            assertThat(refused.messages).isEmpty()
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun rawObjectOnlyDiscardsInputAndStillUsesWholeObjectAndEffectiveSerializers(
        responseViaEventExtras: Boolean
    ) {
        val oldInput = JsonArray.of(listOf(JsonValue.from("old")))
        val raw =
            JsonObject.of(
                mapOf(
                    "input" to oldInput,
                    "instructions" to JsonValue.from("retain"),
                    "future_text" to JsonValue.from("still here"),
                )
            )
        val event =
            ResponseCreateEvent.builder()
                .eventId("raw")
                .apply {
                    if (responseViaEventExtras) putAdditionalProperty("response", raw)
                    else response(raw)
                }
                .build()
        val peer = Peer()
        RealtimeConnection.connect(options(peer, failingMapper(JsonArray::class.java))).use {
            connection ->
            connection.sendResponseCreate(event, listOf(ResponseInput.ofReference("item_prior")))
            assertThat(mapper.readTree(peer.messages.poll(5, TimeUnit.SECONDS)))
                .isEqualTo(
                    mapper.readTree(
                        """{"type":"response.create","event_id":"raw","response":{"instructions":"retain","future_text":"still here","input":[{"type":"item_reference","id":"item_prior"}]}}"""
                    )
                )
            assertThat(
                    if (responseViaEventExtras) event._additionalProperties()["response"]
                    else event._response().asUnknown().get()
                )
                .isSameAs(raw)
            assertThat(raw.values).containsEntry("input", oldInput)
            assertThat(peer.messages).isEmpty()
        }
        val effective = JsonObject.of(raw.values - "input" + ("future_array" to oldInput))
        val withEffective =
            event
                .toBuilder()
                .apply {
                    if (responseViaEventExtras) putAdditionalProperty("response", effective)
                    else response(effective)
                }
                .build()
        for ((active, toSend) in
            listOf(
                failingMapper(JsonArray::class.java) to withEffective,
                failingMapper(JsonObject::class.java) to event,
            )) {
            val refused = Peer()
            RealtimeConnection.connect(options(refused, active)).use { connection ->
                assertThatThrownBy {
                        connection.sendResponseCreate(
                            toSend,
                            listOf(ResponseInput.ofReference("item_prior")),
                        )
                    }
                    .isInstanceOf(IllegalArgumentException::class.java)
                    .hasMessageContaining("deliberate active serializer failure")
                assertThat(refused.messages).isEmpty()
            }
        }
    }

    private fun <T> failingMapper(type: Class<T>): JsonMapper =
        mapper.copy().apply {
            registerModule(
                SimpleModule()
                    .addSerializer(
                        type,
                        object : StdSerializer<T>(type) {
                            override fun serialize(
                                value: T,
                                out: JsonGenerator,
                                provider: SerializerProvider,
                            ) {
                                throw IOException("deliberate active serializer failure")
                            }
                        },
                    )
            )
        }

    @Test
    fun effectiveInputAndWholeEventAndResponseSerializerFailuresAreNotRecovered() {
        val event =
            ResponseCreateEvent.builder()
                .response(RealtimeResponseCreateParams.builder().instructions("retain").build())
                .build()
        val cases =
            listOf(
                failingMapper(RealtimeConversationItemFunctionCallOutput::class.java) to
                    listOf(ResponseInput.ofItem(ordinary())),
                failingMapper(ResponseCreateEvent::class.java) to
                    listOf(ResponseInput.ofReference("prior")),
                failingMapper(RealtimeResponseCreateParams::class.java) to
                    listOf(ResponseInput.ofReference("prior")),
            )
        for ((active, inputs) in cases) {
            val peer = Peer()
            RealtimeConnection.connect(options(peer, active)).use { connection ->
                assertThatThrownBy { connection.sendResponseCreate(event, inputs) }
                    .isInstanceOf(IllegalArgumentException::class.java)
                    .hasMessageContaining("deliberate active serializer failure")
                assertThat(peer.messages).isEmpty()
            }
        }
    }

    @Test
    fun closedAndBusyAdmissionPrecedeInputSerialization() {
        val entered = CountDownLatch(1)
        val release = CountDownLatch(1)
        val calls = AtomicInteger()
        val active = configuredMapper {
            calls.incrementAndGet()
            entered.countDown()
            check(release.await(5, TimeUnit.SECONDS))
        }
        val peer = Peer()
        RealtimeConnection.connect(options(peer, active)).use { connection ->
            val event = ResponseCreateEvent.builder().build()
            val input = listOf(ResponseInput.ofItem(ordinary()))
            val sending = CompletableFuture.runAsync { connection.sendResponseCreate(event, input) }
            try {
                assertThat(entered.await(5, TimeUnit.SECONDS)).isTrue()
                assertThatThrownBy { connection.sendResponseCreate(event, input) }
                    .isInstanceOf(WebSocketWriteNotAttempted.Busy::class.java)
                assertThatThrownBy { connection.send(RealtimeClientEvent.ofResponseCreate(event)) }
                    .isInstanceOf(WebSocketWriteNotAttempted.Busy::class.java)
                assertThat(calls.get()).isEqualTo(1)
            } finally {
                release.countDown()
            }
            sending.get(5, TimeUnit.SECONDS)
            assertThat(peer.messages).hasSize(1)
            connection.close()
            assertThatThrownBy { connection.sendResponseCreate(event, input) }
                .isInstanceOf(WebSocketWriteNotAttempted.Closed::class.java)
            assertThat(calls.get()).isEqualTo(1)
        }
    }

    @Test
    fun invalidResponseProjectionDoesNotPoisonAdmission() {
        val peer = Peer()
        RealtimeConnection.connect(options(peer)).use { connection ->
            for (raw in listOf("null", "[]", "\"value\"")) {
                val event =
                    mapper.readValue(
                        """{"type":"response.create","response":$raw}""",
                        ResponseCreateEvent::class.java,
                    )
                assertThatThrownBy { connection.sendResponseCreate(event, emptyList()) }
                    .isInstanceOf(IllegalArgumentException::class.java)
                    .hasMessageContaining("must encode an object")
            }
            connection.sendResponseCreate(
                ResponseCreateEvent.builder().build(),
                listOf(ResponseInput.ofReference("item_prior-1")),
            )
            assertThat(peer.messages).hasSize(1)
        }
    }

    @Test
    fun cancelledReceiveDoesNotCancelReferenceSendOrNextReceive() {
        val peer = Peer()
        RealtimeConnection.connect(options(peer)).use { connection ->
            assertThat(connection.receiveAsync().cancel(false)).isTrue()
            val next = connection.receiveAsync()
            connection.sendResponseCreate(
                ResponseCreateEvent.builder().build(),
                listOf(ResponseInput.ofReference("item_prior-1")),
            )
            peer.listener.onMessage(
                """{"type":"input_audio_buffer.cleared","event_id":"after-cancel"}"""
            )
            assertThat(next.get(5, TimeUnit.SECONDS).asInputAudioBufferCleared().eventId())
                .isEqualTo("after-cancel")
            assertThat(peer.messages).hasSize(1)
        }
    }

    @Test
    fun epochChangeDuringEncodingRetainsOneCommandForExplicitFlush() {
        val peer = Peer()
        val replacement = CompletableFuture<WebSocketClient.Connection>()
        peer.replacement = replacement
        val restored = CompletableFuture<RealtimeConnection>()
        val calls = AtomicInteger()
        val active =
            mapper.copy().apply {
                registerModule(
                    SimpleModule()
                        .addSerializer(
                            ResponseCreateEvent::class.java,
                            object :
                                StdSerializer<ResponseCreateEvent>(
                                    ResponseCreateEvent::class.java
                                ) {
                                override fun serialize(
                                    value: ResponseCreateEvent,
                                    out: JsonGenerator,
                                    provider: SerializerProvider,
                                ) {
                                    if (calls.incrementAndGet() == 1) {
                                        peer.listener.onFailure(
                                            IOException("initial connection lost")
                                        )
                                    }
                                    out.writeStartObject()
                                    out.writeStringField("type", "response.create")
                                    out.writeStringField("event_id", "epoch-control")
                                    out.writeEndObject()
                                }
                            },
                        )
                )
            }
        val settings =
            RealtimeWebSocketOptions.builder()
                .reconnect(true)
                .reconnectDelayMillis(1)
                .maxPendingBytes(4096)
                .onReconnected {
                    try {
                        it.flushPending()
                        restored.complete(it)
                    } catch (error: Throwable) {
                        restored.completeExceptionally(error)
                        throw error
                    }
                }
                .build()
        RealtimeConnection.connect(options(peer, active), settings).use { connection ->
            connection.sendResponseCreate(
                ResponseCreateEvent.builder().eventId("epoch-control").build(),
                emptyList(),
            )
            assertThat(peer.messages).isEmpty()
            replacement.complete(peer.socket())
            assertThat(restored.get(5, TimeUnit.SECONDS)).isSameAs(connection)
            val actual = mapper.readTree(peer.messages.poll(5, TimeUnit.SECONDS))
            assertThat(actual.path("event_id").asText()).isEqualTo("epoch-control")
            assertThat(actual.path("response").path("input")).isEqualTo(mapper.createArrayNode())
            assertThat(calls.get()).isEqualTo(1)
            assertThat(connection.takePending()).isEmpty()
            assertThat(peer.messages).isEmpty()
        }
    }

    @Test
    fun recoveryPendingByteBudgetRejectsWithoutWritingOrRetaining() {
        val peer = Peer()
        peer.replacement = CompletableFuture()
        val settings =
            RealtimeWebSocketOptions.builder()
                .reconnect(true)
                .reconnectDelayMillis(1)
                .maxPendingBytes(1)
                .build()
        RealtimeConnection.connect(options(peer), settings).use { connection ->
            peer.listener.onFailure(IOException("initial connection lost"))
            assertThatThrownBy {
                    connection.sendResponseCreate(
                        ResponseCreateEvent.builder().build(),
                        emptyList(),
                    )
                }
                .isInstanceOf(WebSocketWriteNotAttempted.Busy::class.java)
                .hasMessageContaining("queue is full")
            assertThat(connection.takePending()).isEmpty()
            assertThat(peer.messages).isEmpty()
        }
    }

    @Test
    fun rejectedWriteCanRetryButUncertainWriteIsTerminal() {
        val peer = Peer()
        RealtimeConnection.connect(options(peer)).use { connection ->
            val event = ResponseCreateEvent.builder().build()
            val inputs = listOf(ResponseInput.ofReference("item_prior-1"))
            val rejection = WebSocketWriteNotAttempted.Busy("peer has no capacity")
            peer.sendError = rejection
            assertThatThrownBy { connection.sendResponseCreate(event, inputs) }.isSameAs(rejection)
            assertThat(peer.messages).isEmpty()
            peer.sendError = null
            connection.sendResponseCreate(event, inputs)
            assertThat(peer.messages).hasSize(1)
            val uncertain = IOException("write outcome unknown")
            peer.sendError = uncertain
            assertThatThrownBy { connection.sendResponseCreate(event, inputs) }.isSameAs(uncertain)
            assertThatThrownBy { connection.sendResponseCreate(event, inputs) }
                .isInstanceOf(WebSocketWriteNotAttempted.Closed::class.java)
            assertThat(peer.messages).hasSize(1)
        }
    }

    @Test
    fun java8ConsumerPreservesLegacyTypesAndCannotAccessPayload(@TempDir directory: Path) {
        val classpath =
            listOf(
                    RealtimeConnection::class.java,
                    Metadata::class.java,
                    JsonNode::class.java,
                    ObjectMapper::class.java,
                    JsonFactory::class.java,
                    com.fasterxml.jackson.annotation.JsonProperty::class.java,
                )
                .map { File(it.protectionDomain.codeSource.location.toURI()).path }
                .distinct()
                .joinToString(File.pathSeparator)
        fun compile(name: String, body: String): Pair<Boolean, String> {
            val source = directory.resolve("$name.java")
            Files.write(
                source,
                ("import com.openai.helpers.RealtimeConnection;\n" +
                        "import com.openai.helpers.RealtimeConnection.ResponseInput;\n" +
                        "import com.openai.models.realtime.*;\n" +
                        "public class $name { $body }")
                    .toByteArray(),
            )
            val diagnostics = StringWriter()
            val compiler = ToolProvider.getSystemJavaCompiler()
            compiler.getStandardFileManager(null, null, null).use { manager ->
                val passed =
                    compiler
                        .getTask(
                            diagnostics,
                            manager,
                            null,
                            listOf(
                                "--release",
                                "8",
                                "-classpath",
                                classpath,
                                "-d",
                                directory.toString(),
                            ),
                            null,
                            manager.getJavaFileObjects(source.toFile()),
                        )
                        .call()
                return passed to diagnostics.toString()
            }
        }
        val positive =
            compile(
                "TypedConsumer",
                """
            void send(RealtimeConnection c, ConversationItem item, ResponseCreateEvent event) {
                java.util.List<ConversationItem> legacy = java.util.Arrays.asList(item);
                RealtimeResponseCreateParams.builder().input(legacy).build();
                ConversationItemCreateEvent.builder().item(item).build();
                c.sendResponseCreate(event, java.util.Arrays.asList(
                    ResponseInput.ofItem(item), ResponseInput.ofReference("item_prior-1")));
            }
        """,
            )
        assertThat(positive.first).withFailMessage(positive.second).isTrue()
        val bridge =
            ResponseInput::class.java.declaredMethods.single { it.name.startsWith("toJson") }
        assertThat(bridge.isSynthetic).isTrue()
        val negatives =
            listOf(
                "ReaderBoundary" to
                    "ConversationItem item = ResponseInput.ofReference(\"item_prior-1\");",
                "CreateBoundary" to
                    "Object event = ConversationItemCreateEvent.builder().item(ResponseInput.ofReference(\"item_prior-1\")).build();",
                "ClosedValueBoundary" to "Object input = new ResponseInput(new Object());",
                "HiddenBridgeBoundary" to
                    "Object read(ResponseInput value) { return value.${bridge.name}(null); }",
            )
        negatives.forEach { (name, body) ->
            val result = compile(name, body)
            assertThat(result.first).withFailMessage("$name unexpectedly compiled").isFalse()
            assertThat(result.second).contains("error:")
        }
    }

    private class Peer : HttpClient, WebSocketClient {
        val messages = LinkedBlockingQueue<String>()
        lateinit var listener: WebSocketClient.Listener
        val openings = AtomicInteger()
        var replacement: CompletableFuture<WebSocketClient.Connection>? = null
        var sendError: Throwable? = null

        override fun connectWebSocket(
            request: HttpRequest,
            options: RequestOptions,
            maxMessageBytes: Int,
            listener: WebSocketClient.Listener,
        ): CompletableFuture<WebSocketClient.Connection> {
            this.listener = listener
            return if (openings.incrementAndGet() > 1 && replacement != null) replacement!!
            else CompletableFuture.completedFuture(socket())
        }

        fun socket(): WebSocketClient.Connection =
            object : WebSocketClient.WritableConnection {
                override fun awaitWritable(timeout: Duration) {}

                override fun send(text: String) {
                    sendError?.let { throw it }
                    messages.add(text)
                }

                override fun close() {}
            }

        override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse =
            error("HTTP is not used by this local WebSocket peer")

        override fun executeAsync(
            request: HttpRequest,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> = error("HTTP is not used by this local WebSocket peer")

        override fun close() {}
    }
}
