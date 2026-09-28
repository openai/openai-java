package com.openai.helpers

import com.openai.core.JsonNull
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.helpers.LiveTranscriptGrouper.CloseReason
import com.openai.helpers.LiveTranscriptGrouper.Speaker
import com.openai.helpers.LiveTranscriptGrouper.Update
import com.openai.models.live.InputTranscriptDeltaEvent
import com.openai.models.live.OutputTranscriptDeltaEvent
import com.openai.models.live.ServerEvent
import com.openai.models.live.SessionClosedEvent
import com.openai.models.live.forks.ForkServerEvent
import java.time.Duration
import java.util.Collections
import java.util.concurrent.ConcurrentLinkedQueue
import java.util.concurrent.CountDownLatch
import java.util.concurrent.FutureTask
import java.util.concurrent.RejectedExecutionException
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException
import java.util.function.Consumer
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class LiveTranscriptGrouperTest {
    private fun input(id: String, text: String, start: Long, end: Long) =
        InputTranscriptDeltaEvent.builder()
            .eventId(id)
            .delta(text)
            .startMs(start)
            .endMs(end)
            .build()

    private fun output(id: String, text: String, start: Long, end: Long) =
        OutputTranscriptDeltaEvent.builder()
            .eventId(id)
            .delta(text)
            .startMs(start)
            .endMs(end)
            .build()

    private fun updates() = Collections.synchronizedList(mutableListOf<Update>())

    private fun displayed(events: List<Update>) = events.filter { !it.closeReason().isPresent }

    private fun finalized(events: List<Update>) = events.filter { it.closeReason().isPresent }

    private fun closed() =
        SessionClosedEvent.builder()
            .eventId("close")
            .reason(SessionClosedEvent.Reason.CLOSE_REQUESTED)
            .session(JsonNull.of())
            .usage(JsonNull.of())
            .build()

    @Test
    fun stableIdsAndImmutableSnapshots() {
        val events = updates()
        val grouper = LiveTranscriptGrouper.create { events.add(it) }
        grouper.push(ServerEvent.ofSessionInputTranscriptDelta(input("1", "Hello", 0, 100)))
        grouper.push(input("2", " world", 100, 200))
        assertThat(displayed(events)).hasSize(2)
        val first = displayed(events)[0].segment()
        val second = displayed(events)[1].segment()
        assertThat(first.text()).isEqualTo("Hello")
        assertThat(second.text()).isEqualTo("Hello world")
        assertThat(first.id()).isEqualTo(second.id())
        assertThat(first.endMs()).isEqualTo(100)
        assertThat(second.endMs()).isEqualTo(200)
        assertThat(first.previousId()).isEmpty
        grouper.close()
        assertThat(finalized(events)).hasSize(1)
        assertThat(finalized(events)[0].segment().text()).isEqualTo("Hello world")
        assertThat(finalized(events)[0].closeReason()).contains(CloseReason.MANUAL)
    }

    @Test
    fun alternateSpeakerAndForkUseSamePreviousChain() {
        val events = updates()
        val grouper = LiveTranscriptGrouper.create { events.add(it) }
        grouper.push(input("1", "question", 0, 50))
        grouper.push(
            ForkServerEvent.ofSessionOutputTranscriptDelta(output("2", "answer", 1500, 2000))
        )
        grouper.close()
        val segments = finalized(events).map { it.segment() }
        assertThat(segments.map { it.speaker() }).containsExactly(Speaker.USER, Speaker.ASSISTANT)
        assertThat(segments.map { it.text() }).containsExactly("question", "answer")
        assertThat(segments[1].previousId()).contains(segments[0].id())
        assertThat(finalized(events)[0].closeReason()).contains(CloseReason.SPEAKER_CHANGE)
    }

    @Test
    fun overlapPrefersUserEvenWhenAssistantArrivesFirst() {
        val events = updates()
        val grouper = LiveTranscriptGrouper.create { events.add(it) }
        grouper.push(output("ack", "Okay", 0, 100))
        grouper.push(input("speech", "I want", 0, 100))
        grouper.push(input("continued", " to book", 100, 600))
        grouper.close()
        assertThat(finalized(events).map { it.segment().speaker() }).containsExactly(Speaker.USER)
        assertThat(finalized(events).single().segment().text()).isEqualTo("I want to book")
    }

    @Test
    fun unequalInitialAssistantOverlapAlsoPrefersUser() {
        val events = updates()
        LiveTranscriptGrouper.create { events.add(it) }
            .use { grouper ->
                grouper.push(output("ack", "Okay", 0, 100))
                grouper.push(input("speech", "I want", 0, 500))
                grouper.push(input("continued", " to book", 500, 700))
            }
        assertThat(finalized(events).map { it.segment().speaker() }).containsExactly(Speaker.USER)
        assertThat(finalized(events).single().segment().text()).isEqualTo("I want to book")
    }

    @Test
    fun pointAtSameStartOverlapsButAdjacentIntervalsDoNot() {
        val simultaneous = updates()
        LiveTranscriptGrouper.create { simultaneous.add(it) }
            .use {
                it.push(output("a", "okay", 0, 0))
                it.push(input("u1", "hel", 0, 500))
                it.push(input("u2", "lo", 500, 700))
            }
        assertThat(finalized(simultaneous).map { it.segment().text() }).containsExactly("hello")

        val adjacent = updates()
        LiveTranscriptGrouper.create { adjacent.add(it) }
            .use {
                it.push(output("a", "okay", 0, 100))
                it.push(input("u1", "hel", 100, 500))
                it.push(input("u2", "lo", 500, 700))
            }
        assertThat(finalized(adjacent).map { it.segment().text() }).containsExactly("okay", "hello")
    }

    @Test
    fun delayedAdjacentAcknowledgmentIsPreservedAfterIsolation() {
        val events = updates()
        LiveTranscriptGrouper.builder { events.add(it) }
            .backchannelIsolation(Duration.ofMillis(10))
            .build()
            .use {
                it.push(input("u1", "hello", 100, 500))
                it.push(input("u2", " there", 500, 550))
                it.push(output("a", "okay", 0, 100))
                it.push(input("u3", "continue", 1500, 1550))
            }
        assertThat(finalized(events).map { it.segment().text() })
            .containsExactly("hello there", "okay", "continue")
    }

    @Test
    fun fragmentedInitialAcknowledgmentWaitsForAnOverlappingUser() {
        for (userStart in listOf(0L, 60L)) {
            val events = updates()
            LiveTranscriptGrouper.create { events.add(it) }
                .use {
                    it.push(output("a1", "o", 0, 50))
                    it.push(output("a2", "kay", 50, 100))
                    it.push(input("u1", "hel", userStart, 500))
                    it.push(input("u2", "lo", 500, 600))
                }
            assertThat(finalized(events).map { it.segment().text() }).containsExactly("hello")
        }
    }

    @Test
    fun substantiveBufferedTurnPromotesAtTheExactSeparationDeadline() {
        for (start in listOf(600L, 601L)) {
            val events = updates()
            LiveTranscriptGrouper.create { events.add(it) }
                .use {
                    it.push(input("u1", "first", 0, 100))
                    it.push(output("a1", "a substantive answer", 0, 100))
                    it.push(input("u2", "second", start, start + 100))
                    it.push(input("u3", " continued", start + 100, start + 200))
                }
            val segments = finalized(events).map { it.segment() }
            assertThat(segments.map { it.text() })
                .containsExactly("first", "a substantive answer", "second continued")
            assertThat(segments[1].previousId()).contains(segments[0].id())
            assertThat(segments[2].previousId()).contains(segments[1].id())
        }
    }

    @Test
    fun userContinuationEndingWithAcknowledgmentSuppressesBeforeIsolationTimeout() {
        val events = updates()
        LiveTranscriptGrouper.create { events.add(it) }
            .use {
                it.push(input("u1", "hel", 0, 100))
                it.push(output("a1", "okay", 0, 200))
                it.push(input("u2", "lo", 100, 200))
                it.push(ServerEvent.ofSessionClosed(closed()))
            }
        assertThat(finalized(events).single().segment().text()).isEqualTo("hello")
        assertThat(finalized(events).single().closeReason()).contains(CloseReason.SESSION_CLOSED)
    }

    @Test
    fun longTrimmedEdgesStillSuppressButInteriorPunctuationIsPreserved() {
        val ack = updates()
        LiveTranscriptGrouper.create { ack.add(it) }
            .use { grouper ->
                grouper.push(input("u", "question", 0, 10))
                repeat(3000) { n ->
                    grouper.push(output("before$n", " .", 0, (n % 2 + 1).toLong()))
                }
                grouper.push(output("word", "okay", 0, 5))
                repeat(3000) { n -> grouper.push(output("after$n", " -", 0, (n % 2 + 6).toLong())) }
                grouper.push(input("u2", " continues", 10, 20))
            }
        assertThat(finalized(ack).map { it.segment().text() }).containsExactly("question continues")

        val interior = updates()
        val punctuation = ".".repeat(3000)
        LiveTranscriptGrouper.create { interior.add(it) }
            .use {
                it.push(input("u", "question", 0, 10))
                it.push(output("a1", "o", 0, 3))
                it.push(output("a2", punctuation, 0, 4))
                it.push(output("a3", "kay", 0, 5))
                it.push(input("u2", " continues", 10, 20))
            }
        assertThat(finalized(interior).map { it.segment().text() })
            .containsExactly("question continues", "o" + punctuation + "kay")
    }

    @Test
    fun streamedDeltasReconstructNormalizedOverlapSnapshots() {
        val events = updates()
        val streamed = mutableMapOf<String, StringBuilder>()
        LiveTranscriptGrouper.create { update ->
                events.add(update)
                streamed.getOrPut(update.segment().id()) { StringBuilder() }.append(update.delta())
                if (update.closeReason().isPresent) {
                    assertThat(streamed[update.segment().id()].toString())
                        .isEqualTo(update.segment().text())
                    assertThat(update.delta()).isEmpty()
                }
            }
            .use { grouper ->
                grouper.push(output("a1", " OKAY! ", 0, 80))
                grouper.push(input("u1", "bon", 0, 200))
                grouper.push(input("u2", "jour", 200, 300))
                grouper.push(output("a2", "Your", 1900, 2100))
                grouper.push(output("a3", " answer", 2100, 2200))
            }
        val segments = finalized(events).map { it.segment() }
        assertThat(segments.map { it.text() }).containsExactly("bonjour", "Your answer")
        assertThat(streamed.values.map { it.toString() }).containsExactly("bonjour", "Your answer")
        assertThat(segments[1].previousId()).contains(segments[0].id())
    }

    @Test
    fun earlierStartingOppositeSpeakerDoesNotResetTheSession() {
        val events = updates()
        val grouper = LiveTranscriptGrouper.create { events.add(it) }
        grouper.push(input("u1", "I want", 1000, 1500))
        grouper.push(input("u2", " to book", 1500, 1600))
        val displayedId = displayed(events).first().segment().id()
        // Different intervals (not a simultaneous batch). The ack belongs to the overlap.
        grouper.push(output("delayed-ack", "okay", 900, 1100))
        grouper.push(input("u3", " a table", 1600, 1700))
        grouper.close()
        assertThat(finalized(events)).hasSize(1)
        assertThat(finalized(events).single().closeReason()).contains(CloseReason.MANUAL)
        val final = finalized(events).single().segment()
        assertThat(final.id()).isEqualTo(displayedId)
        assertThat(final.text()).isEqualTo("I want to book a table")
        assertThat(final.speaker()).isEqualTo(Speaker.USER)
    }

    @Test
    fun suppressionCanBeDisabledAndIdsNeverReferenceSuppressedTurn() {
        val withSuppression = updates()
        val muted = LiveTranscriptGrouper.create { withSuppression.add(it) }
        muted.push(input("u1", "continue", 0, 100))
        muted.push(output("ack", "yeah", 0, 100))
        muted.push(input("u2", " please", 101, 700))
        muted.push(output("a2", "finished", 1800, 2500))
        muted.close()
        val mutedSegments = finalized(withSuppression).map { it.segment() }
        assertThat(mutedSegments.map { it.text() }).containsExactly("continue please", "finished")
        assertThat(mutedSegments.last().previousId()).contains(mutedSegments.first().id())

        val withoutSuppression = updates()
        val unmuted =
            LiveTranscriptGrouper.builder { withoutSuppression.add(it) }
                .backchannelMaxDuration(Duration.ZERO)
                .build()
        unmuted.push(input("u1", "continue", 0, 100))
        unmuted.push(output("ack", "yeah", 0, 100))
        unmuted.push(input("u2", " please", 101, 700))
        unmuted.close()
        assertThat(finalized(withoutSuppression).map { it.segment().text() })
            .containsExactly("continue please", "yeah")
    }

    @Test
    fun additionalAcknowledgmentsAreCopiedAndNormalized() {
        val phrases = mutableListOf("  D'ACCORD! ")
        val events = updates()
        val grouper =
            LiveTranscriptGrouper.builder { events.add(it) }
                .additionalAcknowledgments(phrases)
                .build()
        phrases.clear()
        grouper.push(input("u", "bon", 0, 100))
        grouper.push(output("a", "D'ACCORD!", 0, 100))
        grouper.push(input("u2", "jour", 100, 500))
        grouper.close()
        assertThat(finalized(events).map { it.segment().speaker() }).containsExactly(Speaker.USER)
        assertThat(finalized(events).single().segment().text()).isEqualTo("bonjour")
    }

    @Test
    fun additionalAcknowledgmentsBoundNormalizedUnicodeRatherThanUtf16OrRawEdges() {
        val phrase = "👍".repeat(128)
        val events = updates()
        LiveTranscriptGrouper.builder { events.add(it) }
            .additionalAcknowledgments(listOf("((  $phrase  ))"))
            .build()
            .use {
                it.push(input("u1", "hel", 0, 100))
                it.push(output("a1", phrase, 0, 100))
                it.push(input("u2", "lo", 100, 200))
            }
        assertThat(finalized(events).map { it.segment().text() }).containsExactly("hello")
        assertThatThrownBy {
                LiveTranscriptGrouper.builder { _ -> }
                    .additionalAcknowledgments(listOf(phrase + "👍"))
            }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("128 normalized Unicode code points")
    }

    @Test
    fun overlappingPrefixCanCompleteAsSubstantiveTextOrAsAnAcknowledgment() {
        val substantive = updates()
        val streamed = mutableMapOf<String, StringBuilder>()
        LiveTranscriptGrouper.create { update ->
                substantive.add(update)
                streamed.getOrPut(update.segment().id()) { StringBuilder() }.append(update.delta())
            }
            .use { grouper ->
                grouper.push(input("u1", "hel", 0, 100))
                grouper.push(output("a1", "o", 0, 100))
                grouper.push(input("u2", "lo", 100, 200))
                grouper.push(output("a2", "utstanding", 200, 300))
            }
        val segments = finalized(substantive).map { it.segment() }
        assertThat(segments.map { it.text() }).containsExactly("hello", "outstanding")
        assertThat(streamed.values.map { it.toString() }).containsExactly("hello", "outstanding")
        assertThat(segments.map { it.speaker() }).containsExactly(Speaker.USER, Speaker.ASSISTANT)
        assertThat(segments[1].previousId()).contains(segments[0].id())

        val acknowledgment = updates()
        LiveTranscriptGrouper.create { acknowledgment.add(it) }
            .use { grouper ->
                grouper.push(input("u1", "hel", 0, 100))
                grouper.push(output("a1", "o", 0, 100))
                grouper.push(input("u2", "lo", 100, 200))
                grouper.push(output("a2", "kay", 200, 300))
                grouper.push(input("u3", " there", 300, 400))
            }
        assertThat(finalized(acknowledgment).map { it.segment().text() })
            .containsExactly("hello there")
    }

    @Test
    fun anUnfinishedAcknowledgmentPrefixIsNotSilentlyDiscardedOnClose() {
        val events = updates()
        LiveTranscriptGrouper.create { events.add(it) }
            .use { grouper ->
                grouper.push(input("u1", "I can", 0, 100))
                grouper.push(output("a1", "o", 0, 100))
                grouper.push(input("u2", " speak", 100, 200))
            }
        assertThat(finalized(events).map { it.segment().text() })
            .containsExactly("I can speak", "o")
    }

    @Test
    fun leadingPunctuationDoesNotRuleOutAFragmentedAcknowledgment() {
        val events = updates()
        LiveTranscriptGrouper.create { events.add(it) }
            .use { grouper ->
                grouper.push(input("u1", "I can", 0, 100))
                grouper.push(output("a1", " \"", 0, 100))
                grouper.push(input("u2", " speak", 100, 200))
                grouper.push(output("a2", "okay\"", 200, 300))
                grouper.push(input("u3", " for myself", 300, 400))
            }
        assertThat(finalized(events).map { it.segment().text() })
            .containsExactly("I can speak for myself")
    }

    @Test
    fun closingOneGrouperDoesNotCancelAnotherSessionDeadline() {
        val first = LiveTranscriptGrouper.create {}
        val events = updates()
        val completed = CountDownLatch(1)
        val second =
            LiveTranscriptGrouper.builder {
                    events.add(it)
                    if (it.closeReason().orElse(null) == CloseReason.INACTIVITY)
                        completed.countDown()
                }
                .assistantSilence(Duration.ofMillis(20))
                .build()
        first.use {
            second.use {
                first.push(input("u1", "pending", 0, 100))
                second.push(output("a1", "independent", 0, 100))
                first.close()
                assertThat(completed.await(2, TimeUnit.SECONDS)).isTrue()
                assertThat(finalized(events).map { it.segment().text() })
                    .containsExactly("independent")
            }
        }
    }

    @Test
    fun blockedListenersDoNotPreventOtherSessionsFromFlushing() {
        val entered = CountDownLatch(2)
        val release = CountDownLatch(1)
        val completed = CountDownLatch(1)
        val blockers =
            List(2) {
                LiveTranscriptGrouper.create { update ->
                    if (!update.closeReason().isPresent) {
                        entered.countDown()
                        assertThat(release.await(10, TimeUnit.SECONDS)).isTrue()
                    }
                }
            }
        val third =
            LiveTranscriptGrouper.builder {
                    if (it.closeReason().orElse(null) == CloseReason.INACTIVITY)
                        completed.countDown()
                }
                .assistantSilence(Duration.ofMillis(20))
                .build()
        try {
            blockers.forEachIndexed { index, grouper ->
                grouper.push(input("blocked-$index", "waiting", 0, 100))
            }
            assertThat(entered.await(2, TimeUnit.SECONDS)).isTrue()
            third.push(output("third", "independent", 0, 100))
            assertThat(completed.await(2, TimeUnit.SECONDS)).isTrue()
        } finally {
            release.countDown()
            blockers.forEach { it.close() }
            third.close()
        }
    }

    @Test
    fun queuedTimerDeliveryCoalescesUntilCallerExecutorRunsIt() {
        val queued = ConcurrentLinkedQueue<Runnable>()
        val submitted = CountDownLatch(1)
        val events = updates()
        LiveTranscriptGrouper.builder { events.add(it) }
            .assistantSilence(Duration.ofMillis(300))
            .asyncCallbackExecutor {
                queued.add(it)
                submitted.countDown()
            }
            .build()
            .use { grouper ->
                grouper.push(output("a", "answer", 0, 100))
                assertThat(submitted.await(2, TimeUnit.SECONDS)).isTrue()
                // Allow the silence deadline to expire while the caller executor has not run.
                Thread.sleep(550)
                assertThat(events).isEmpty()
                assertThat(queued).hasSize(1)
                queued.remove().run()
                assertThat(finalized(events).single().closeReason())
                    .contains(CloseReason.INACTIVITY)
                assertThat(finalized(events).single().segment().text()).isEqualTo("answer")
                assertThat(queued).isEmpty()
            }
        assertThat(finalized(events)).hasSize(1)
    }

    @Test
    fun rejectedTimerDeliveryCanRetryAndCloseWithoutLosingText() {
        val attempts = CountDownLatch(2)
        val events = updates()
        LiveTranscriptGrouper.builder { events.add(it) }
            .assistantSilence(Duration.ofMillis(300))
            .asyncCallbackExecutor {
                attempts.countDown()
                throw RejectedExecutionException()
            }
            .build()
            .use { grouper ->
                grouper.push(output("a", "answer", 0, 100))
                assertThat(attempts.await(2, TimeUnit.SECONDS)).isTrue()
                assertThat(events).isEmpty()
            }
        assertThat(displayed(events).single().segment().text()).isEqualTo("answer")
        assertThat(finalized(events).single().closeReason()).contains(CloseReason.INACTIVITY)
    }

    @Test
    fun pushAndCloseFlushBeforeADelayedAsyncDrainAndItCannotRedeliver() {
        val queued = ConcurrentLinkedQueue<Runnable>()
        val submitted = CountDownLatch(1)
        val events = updates()
        LiveTranscriptGrouper.builder { events.add(it) }
            .assistantSilence(Duration.ofSeconds(10))
            .asyncCallbackExecutor {
                queued.add(it)
                submitted.countDown()
            }
            .build()
            .use {
                it.push(output("a1", "first", 0, 100))
                assertThat(submitted.await(2, TimeUnit.SECONDS)).isTrue()
                it.push(output("a2", " second", 100, 200))
            }
        assertThat(displayed(events).map { it.segment().text() })
            .containsExactly("first", "first second")
        assertThat(finalized(events).single().segment().text()).isEqualTo("first second")
        assertThat(finalized(events).single().closeReason()).contains(CloseReason.MANUAL)
        while (queued.isNotEmpty()) queued.remove().run()
        assertThat(events).hasSize(3)
    }

    @Test
    fun closeWaitsForAlreadyDispatchedCallbacksAndFinishesBeforeReturning() {
        val entered = CountDownLatch(1)
        val release = CountDownLatch(1)
        val events = updates()
        val grouper =
            LiveTranscriptGrouper.create { update ->
                events.add(update)
                if (!update.closeReason().isPresent) {
                    entered.countDown()
                    assertThat(release.await(10, TimeUnit.SECONDS)).isTrue()
                }
            }
        try {
            grouper.push(input("u", "pending", 0, 100))
            assertThat(entered.await(2, TimeUnit.SECONDS)).isTrue()
            val closed = FutureTask { grouper.close() }
            Thread(closed, "test-close-live-grouper").apply { isDaemon = true }.start()
            assertThatThrownBy { closed.get(100, TimeUnit.MILLISECONDS) }
                .isInstanceOf(TimeoutException::class.java)
            release.countDown()
            closed.get(2, TimeUnit.SECONDS)
            assertThat(finalized(events).single().segment().text()).isEqualTo("pending")
            assertThat(finalized(events).single().closeReason()).contains(CloseReason.MANUAL)
        } finally {
            release.countDown()
            grouper.close()
        }
    }

    @Test
    fun listenerCanDriveABurstWithoutRecursiveDelivery() {
        val events = updates()
        lateinit var grouper: LiveTranscriptGrouper
        var depth = 0
        var maxDepth = 0
        var next = 2L
        grouper =
            LiveTranscriptGrouper.create { update ->
                depth++
                maxDepth = maxOf(maxDepth, depth)
                try {
                    events.add(update)
                    if (!update.closeReason().isPresent && next < 512) {
                        val start = next++
                        grouper.push(input("i$start", "x", start, start + 1))
                    }
                } finally {
                    depth--
                }
            }
        grouper.use {
            it.push(input("i0", "x", 0, 1))
            it.push(input("i1", "x", 1, 2))
        }
        assertThat(maxDepth).isEqualTo(1)
        assertThat(displayed(events).map { it.segment().endMs() })
            .containsExactlyElementsOf(1L..512L)
        assertThat(finalized(events).single().segment().text()).isEqualTo("x".repeat(512))
    }

    @Test
    fun finalizedEventIdsAreRetiredWhileTheCurrentTurnStillDeduplicates() {
        val events = updates()
        LiveTranscriptGrouper.create { events.add(it) }
            .use { grouper ->
                grouper.push(input("retired", "first", 0, 100))
                grouper.push(output("a1", "answer", 1200, 1300))
                grouper.push(output("a2", " complete", 1300, 1400))
                grouper.push(input("retired", "new turn", 3000, 3300))
                grouper.push(input("retired", "duplicate", 3000, 3300))
            }
        assertThat(finalized(events).map { it.segment().text() })
            .containsExactly("first", "answer complete", "new turn")
    }

    @Test
    fun substantiveOverlappingAssistantSpeechIsNotSuppressed() {
        val events = updates()
        val grouper = LiveTranscriptGrouper.create { events.add(it) }
        grouper.push(input("u", "please", 0, 100))
        grouper.push(output("a", "I need your date of birth", 0, 100))
        grouper.push(input("u2", " continue", 100, 500))
        grouper.close()
        assertThat(finalized(events).map { it.segment().speaker() })
            .containsExactly(Speaker.USER, Speaker.ASSISTANT)
    }

    @Test
    fun sessionClosedFlushesOnceAndFurtherEventsFail() {
        val events = updates()
        val grouper = LiveTranscriptGrouper.create { events.add(it) }
        grouper.push(input("u", "pending", 0, 500))
        grouper.push(ServerEvent.ofSessionClosed(closed()))
        val afterTerminal = events.toList()
        grouper.close()
        assertThat(events).containsExactlyElementsOf(afterTerminal)
        assertThat(finalized(events).single().closeReason()).contains(CloseReason.SESSION_CLOSED)
        assertThatThrownBy { grouper.push(input("late", "late", 501, 502)) }
            .isInstanceOf(IllegalStateException::class.java)
        assertThatThrownBy { grouper.push(ServerEvent.ofSessionClosed(closed())) }
            .isInstanceOf(IllegalStateException::class.java)
    }

    @Test
    fun forkClosedHasSameTerminalBehavior() {
        val events = updates()
        val grouper = LiveTranscriptGrouper.create { events.add(it) }
        grouper.push(ForkServerEvent.ofSessionInputTranscriptDelta(input("u", "fork", 10, 15)))
        grouper.push(ForkServerEvent.ofSessionClosed(closed()))
        assertThat(finalized(events).single().segment().text()).isEqualTo("fork")
        assertThat(finalized(events).single().closeReason()).contains(CloseReason.SESSION_CLOSED)
    }

    @Test
    fun duplicatesInvalidFieldsAndEmptyTextDoNotCorruptState() {
        val events = updates()
        val grouper = LiveTranscriptGrouper.create { events.add(it) }
        grouper.push(input("good", "original", 1, 100))
        assertThatThrownBy { grouper.push(input("bad", "backwards", 9, 2)) }
            .isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { grouper.push(input("typed", "bad", -1, 10)) }
            .isInstanceOf(IllegalArgumentException::class.java)
        grouper.push(input("good", "duplicate", 1, 100))
        grouper.push(input("bad", " fixed", 100, 200))
        grouper.push(input("empty", "", 900, 1000))
        grouper.push(input("empty", " text", 200, 300))
        grouper.close()
        assertThat(finalized(events).single().segment().text()).isEqualTo("original fixed text")
        assertThat(finalized(events).single().segment().endMs()).isEqualTo(300)
    }

    @Test
    fun rawUnknownEventRemainsAvailableAfterHelperClose() {
        val events = updates()
        val mapper = jsonMapper()
        val raw = """{"type":"session.future","future":{"extension":42}}"""
        val unknown = mapper.readValue(raw, ServerEvent::class.java)
        val retained = mapper.writeValueAsString(unknown)
        LiveTranscriptGrouper.create { events.add(it) }
            .use { grouper ->
                grouper.push(unknown)
                grouper.push(input("u", "text", 0, 100))
            }
        assertThat(mapper.writeValueAsString(unknown)).isEqualTo(retained)
        assertThat(unknown._json())
            .contains(
                JsonValue.from(
                    mapOf("type" to "session.future", "future" to mapOf("extension" to 42))
                )
            )
        assertThat(finalized(events).single().segment().text()).isEqualTo("text")
    }

    @Test
    fun timestampResetClosesPreviousProjectionWithCorrectReason() {
        val events = updates()
        val grouper = LiveTranscriptGrouper.create { events.add(it) }
        grouper.push(input("first", "past", 1000, 1100))
        grouper.push(input("reset", "new session time", 0, 100))
        grouper.close()
        assertThat(finalized(events).map { it.closeReason().get() })
            .containsExactly(CloseReason.TIMESTAMP_RESET, CloseReason.MANUAL)
        assertThat(finalized(events).map { it.segment().text() })
            .containsExactly("past", "new session time")
    }

    @Test
    fun fullRangeLongTimestampsKeepRelativeIntervalsAndDoNotSpin() {
        val events = updates()
        val grouper = LiveTranscriptGrouper.create { events.add(it) }
        val offset = Long.MAX_VALUE - 10_000
        grouper.push(input("u", "question", offset, offset + 100))
        grouper.push(output("a", "answer", offset + 1500, offset + 2000))
        grouper.close()
        val segments = finalized(events).map { it.segment() }
        assertThat(segments.map { it.text() }).containsExactly("question", "answer")
        assertThat(segments[0].startMs()).isEqualTo(offset)
        assertThat(segments[1].endMs()).isEqualTo(offset + 2000)
    }

    @Test
    fun inactivityUsesFractionalThresholdAndCallbackMayReenterClose() {
        val events = updates()
        val final = CountDownLatch(1)
        lateinit var grouper: LiveTranscriptGrouper
        grouper =
            LiveTranscriptGrouper.builder(
                    Consumer {
                        events.add(it)
                        if (it.closeReason().orElse(null) == CloseReason.INACTIVITY) {
                            grouper.close()
                            final.countDown()
                        }
                    }
                )
                .assistantSilence(Duration.ofNanos(1_500_000))
                .build()
        grouper.push(output("assistant", "unprompted", 0, 0))
        assertThat(final.await(2, TimeUnit.SECONDS)).isTrue()
        val received = events.toList()
        assertThat(finalized(received).single().closeReason()).contains(CloseReason.INACTIVITY)
        grouper.close()
        assertThat(events).containsExactlyElementsOf(received)
    }

    @Test
    fun nanosecondThresholdAfterLargeElapsedTimeMakesSynchronousProgress() {
        // Bound a regression that previously looped under the state lock. The daemon cannot keep
        // a failed test JVM alive, and this calls only public events and APIs.
        val task = FutureTask {
            val events = updates()
            val grouper =
                LiveTranscriptGrouper.builder { events.add(it) }
                    .assistantSilence(Duration.ofNanos(1))
                    .build()
            grouper.push(input("u0", "origin", 0, 1))
            val longElapsed = 30_000_000_000L
            grouper.push(output("a", "later answer", longElapsed, longElapsed + 10))
            grouper.push(input("u1", "new question", longElapsed + 20, longElapsed + 21))
            grouper.push(input("u2", " more", longElapsed + 22, longElapsed + 23))
            grouper.close()
            finalized(events)
        }
        Thread(task, "test-live-grouper-progress").apply { isDaemon = true }.start()
        val complete = task.get(2, TimeUnit.SECONDS)
        assertThat(complete.map { it.segment().text() })
            .containsExactly("origin", "later answer", "new question more")
        assertThat(complete.map { it.closeReason().get() })
            .containsExactly(CloseReason.SPEAKER_CHANGE, CloseReason.INACTIVITY, CloseReason.MANUAL)
    }

    @Test
    fun validatesNegativeAndOverflowingThresholds() {
        assertThatThrownBy {
                LiveTranscriptGrouper.builder {}.assistantSilence(Duration.ofNanos(-1))
            }
            .isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy {
                LiveTranscriptGrouper.builder {}
                    .backchannelMaxDuration(Duration.ofSeconds(Long.MAX_VALUE))
            }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
