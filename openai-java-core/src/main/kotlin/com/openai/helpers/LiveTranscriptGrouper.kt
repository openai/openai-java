package com.openai.helpers

import com.openai.models.live.InputTranscriptDeltaEvent
import com.openai.models.live.OutputTranscriptDeltaEvent
import com.openai.models.live.ServerEvent
import com.openai.models.live.forks.ForkServerEvent
import java.time.Duration
import java.util.ArrayDeque
import java.util.Locale
import java.util.Optional
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicLong
import java.util.function.Consumer
import kotlin.math.ceil

/**
 * Groups Live transcript deltas into display segments. Pass raw events to [push]; the caller still
 * owns the raw event stream and connection. A segment is a local projection, not an API
 * conversation item, VAD, or audio playback state. Replace the displayed text on each update with
 * the same ID.
 *
 * Brief, overlapping assistant acknowledgments may be suppressed. Set
 * [Builder.backchannelMaxDuration] to Duration.ZERO to disable suppression. Only the two transcript
 * delta types and session.closed are consumed. Other events, including unknown variants, are
 * ignored without validating them.
 *
 * Use one instance per session and close it on disconnect. Close flushes remaining segments once
 * and cancels only this helper's timer. Push after close fails. Callbacks are serialized outside
 * the state lock and may call push or close; timer-driven callbacks run on a daemon thread. Delayed
 * event delivery can affect grouping because inactivity uses the local monotonic clock.
 */
class LiveTranscriptGrouper private constructor(builder: Builder) : AutoCloseable {
    enum class Speaker {
        USER,
        ASSISTANT,
    }

    enum class CloseReason {
        SPEAKER_CHANGE,
        INACTIVITY,
        TIMESTAMP_RESET,
        SESSION_CLOSED,
        MANUAL,
    }

    /** Immutable display snapshot. A suppressed segment never appears in the previous-ID chain. */
    class Segment
    internal constructor(
        private val id: String,
        private val previousId: String?,
        private val speaker: Speaker,
        text: StringBuilder,
        length: Int,
        private val startMs: Long,
        private val endMs: Long,
    ) {
        // Text is append-only, so the captured prefix stays immutable. Do not copy a growing
        // transcript on the event thread unless the consumer actually reads this snapshot.
        private val frozenText by lazy { synchronized(text) { text.substring(0, length) } }

        fun id(): String = id

        fun previousId(): Optional<String> = Optional.ofNullable(previousId)

        fun speaker(): Speaker = speaker

        fun text(): String = frozenText

        fun startMs(): Long = startMs

        fun endMs(): Long = endMs
    }

    /** A segment snapshot, optionally marked final with its close reason. */
    class Update
    internal constructor(private val segment: Segment, private val reason: CloseReason? = null) {
        fun segment(): Segment = segment

        fun closeReason(): Optional<CloseReason> = Optional.ofNullable(reason)
    }

    class Builder internal constructor(private val listener: Consumer<Update>) {
        private var minTurnSeparation = Duration.ofMillis(500)
        private var assistantSilence = Duration.ofSeconds(2)
        private var backchannelMaxDuration = Duration.ofSeconds(1)
        private var backchannelIsolation = Duration.ofSeconds(2)
        private var acknowledgments: List<String> = emptyList()

        fun minTurnSeparation(value: Duration) = apply { minTurnSeparation = checked(value) }

        fun assistantSilence(value: Duration) = apply { assistantSilence = checked(value) }

        fun backchannelMaxDuration(value: Duration) = apply {
            backchannelMaxDuration = checked(value)
        }

        fun backchannelIsolation(value: Duration) = apply { backchannelIsolation = checked(value) }

        fun additionalAcknowledgments(value: List<String>) = apply {
            acknowledgments = value.toList()
        }

        fun build(): LiveTranscriptGrouper = LiveTranscriptGrouper(this)

        private fun checked(value: Duration): Duration {
            require(!value.isNegative && value <= Duration.ofMillis(Int.MAX_VALUE.toLong())) {
                "Transcript thresholds must be between zero and 2147483647 milliseconds"
            }
            return value
        }

        internal fun separationMs() = minTurnSeparation.toNanos() / 1_000_000.0

        internal fun silenceMs() = assistantSilence.toNanos() / 1_000_000.0

        internal fun maxDurationMs() = backchannelMaxDuration.toNanos() / 1_000_000.0

        internal fun isolationMs() = backchannelIsolation.toNanos() / 1_000_000.0

        internal fun phrases() = acknowledgments

        internal fun listener() = listener
    }

    companion object {
        @JvmStatic fun builder(listener: Consumer<Update>): Builder = Builder(listener)

        @JvmStatic
        fun create(listener: Consumer<Update>): LiveTranscriptGrouper = builder(listener).build()

        private val nextGrouper = AtomicLong()
        // Like WebSocket timeouts, transcript timers are shared across sessions. Each grouper
        // cancels only its own future. Threads are daemonized and start only when work is
        // scheduled.
        private val scheduler =
            ScheduledThreadPoolExecutor(2) { work ->
                    Thread(work, "openai-live-transcripts").apply { isDaemon = true }
                }
                .apply { removeOnCancelPolicy = true }
        private val punctuation = ".,!?;:\"'()[]{}"
        private val whitespace =
            Regex(
                "[\\t\\n\\u000B\\u000C\\r \\u00A0\\u1680\\u2000-\\u200A\\u2028\\u2029\\u202F\\u205F\\u3000\\uFEFF]+"
            )

        private fun normalize(value: String): String =
            whitespace.replace(value.lowercase(Locale.ROOT).replace('-', ' '), " ").trim {
                it == ' ' || it in punctuation
            }
    }

    private data class Fragment(
        val speaker: Speaker,
        val text: String,
        val start: Long,
        val end: Long,
        val received: Double,
    )

    private class Turn(val id: String, fragment: Fragment) {
        val speaker = fragment.speaker
        val start = fragment.start
        var end = fragment.end
        val text = StringBuilder(fragment.text)
        var previous: String? = null
        var emitted = false
        var canDrop = true

        fun snapshot() = Segment(id, previous, speaker, text, text.length, start, end)
    }

    private val separation = builder.separationMs()
    private val silence = builder.silenceMs()
    private val maxDuration = builder.maxDurationMs()
    private val isolation = builder.isolationMs()
    private val listener = builder.listener()
    private val acknowledgments =
        (listOf(
                "aha",
                "alright",
                "gotcha",
                "hm",
                "hmm",
                "mhm",
                "mm",
                "mm hmm",
                "okay",
                "ok",
                "right",
                "sure",
                "uh huh",
                "yeah",
                "yep",
                "yes",
            ) + builder.phrases().map(::normalize).filter(String::isNotEmpty))
            .toSet()
    private val prefix = "segment_${nextGrouper.getAndIncrement()}"
    private var nextId = 0L
    private var lastId: String? = null
    private var current: Turn? = null
    private var buffered: Turn? = null
    private var lastAssistantEnd: Long? = null
    private val seen = mutableSetOf<String>()
    private val pending = mutableListOf<Fragment>()
    private var anchorTime = 0.0
    private var anchorReceived = 0.0
    // Work relative to the session interval, keeping millisecond differences precise even when
    // public Long timestamps are close to Long.MAX_VALUE.
    private var timelineOrigin = 0L
    private val lastStarts = mutableMapOf<Speaker, Long>()
    private val lock = Any()
    private val updates = ArrayDeque<Update>()
    private var dispatching = false
    private var closed = false
    private var timerGeneration = 0L
    private var timer: ScheduledFuture<*>? = null

    fun push(event: ServerEvent) {
        when {
            event.isSessionInputTranscriptDelta() -> push(event.asSessionInputTranscriptDelta())
            event.isSessionOutputTranscriptDelta() -> push(event.asSessionOutputTranscriptDelta())
            event.isSessionClosed() -> finish(CloseReason.SESSION_CLOSED)
            else -> synchronized(lock) { check(!closed) { "Transcript grouper is closed" } }
        }
    }

    fun push(event: ForkServerEvent) {
        when {
            event.isSessionInputTranscriptDelta() -> push(event.asSessionInputTranscriptDelta())
            event.isSessionOutputTranscriptDelta() -> push(event.asSessionOutputTranscriptDelta())
            event.isSessionClosed() -> finish(CloseReason.SESSION_CLOSED)
            else -> synchronized(lock) { check(!closed) { "Transcript grouper is closed" } }
        }
    }

    fun push(event: InputTranscriptDeltaEvent) =
        receive(event.eventId(), Speaker.USER, event.delta(), event.startMs(), event.endMs())

    fun push(event: OutputTranscriptDeltaEvent) =
        receive(event.eventId(), Speaker.ASSISTANT, event.delta(), event.startMs(), event.endMs())

    private fun receive(id: String, speaker: Speaker, text: String, start: Long, end: Long) {
        synchronized(lock) {
            check(!closed) { "Transcript grouper is closed" }
            require(id.isNotEmpty() && start >= 0 && end >= start) {
                "Invalid Live transcript delta ID or interval"
            }
            if (!seen.add(id) || text.isEmpty()) return
            val fragment = Fragment(speaker, text, start, end, now())
            val first = pending.firstOrNull()
            if (first != null && first.start == start && first.end == end) {
                pending.add(fragment)
                if (pending.any { it.speaker != speaker }) flushPending()
            } else {
                flushPending()
                if (current?.speaker == speaker) commit(listOf(fragment)) else pending.add(fragment)
            }
            schedule()
        }
        dispatch()
    }

    override fun close() = finish(CloseReason.MANUAL)

    private fun finish(reason: CloseReason) {
        synchronized(lock) {
            if (reason == CloseReason.SESSION_CLOSED) {
                check(!closed) { "Transcript grouper is closed" }
            }
            if (closed) return
            closed = true
            flushPending()
            closeTurns(sourceNow(), reason)
            seen.clear()
            timerGeneration++
            timer?.cancel(false)
        }
        dispatch()
    }

    private fun now() = System.nanoTime() / 1_000_000.0

    private fun sourceNow() = anchorTime + (now() - anchorReceived).coerceAtLeast(0.0)

    private fun flushPending() {
        if (pending.isEmpty()) return
        val fragments = pending.toList()
        pending.clear()
        commit(fragments)
    }

    private fun commit(fragments: List<Fragment>) {
        val first = fragments.first()
        if (lastStarts.isEmpty()) timelineOrigin = first.start
        // An overlapping speaker may arrive after the later-starting speaker. A clock reset
        // requires a speaker's own timestamps to go backwards, not just cross-speaker reordering.
        if (fragments.any { part -> lastStarts[part.speaker]?.let { part.start < it } == true }) {
            closeTurns(sourceNow(), CloseReason.TIMESTAMP_RESET)
            timelineOrigin = first.start
            anchorTime = 0.0
            lastStarts.clear()
        }
        fragments.forEach { lastStarts[it.speaker] = it.start }
        anchorTime = maxOf(anchorTime, (fragments.maxOf { it.end } - timelineOrigin).toDouble())
        anchorReceived = fragments.maxOf { it.received }
        val preferred = current?.speaker ?: Speaker.USER
        val ordered =
            fragments.filter { it.speaker == preferred } +
                fragments.filter { it.speaker != preferred }
        var deadline = deadline()
        while (deadline != null && deadline < ordered.first().start - timelineOrigin) {
            advance(deadline)
            deadline = deadline()
        }
        if (current != null && ordered.none { it.speaker == current?.speaker }) {
            advance(
                (first.start - timelineOrigin).toDouble(),
                ordered.any { it.speaker == Speaker.USER },
            )
        }
        ordered.forEach(::ingest)
    }

    private fun deadline(): Double? {
        val turn = current ?: return null
        val waiting = buffered
        if (waiting != null) {
            val next = (turn.end - timelineOrigin) + separation
            return if (mightDrop() && waiting.canDrop && !userContinued() && !recentAssistant())
                maxOf(next, (waiting.end - timelineOrigin) + isolation)
            else next
        }
        return if (turn.speaker == Speaker.ASSISTANT) (turn.end - timelineOrigin) + silence
        else null
    }

    private fun advance(time: Double, hasIncomingUser: Boolean = false) {
        val turn = current ?: return
        val waiting = buffered
        if (
            waiting != null &&
                time >= (turn.end - timelineOrigin) + separation &&
                !(mightDrop() &&
                    waiting.canDrop &&
                    !userContinued() &&
                    !recentAssistant() &&
                    time < (waiting.end - timelineOrigin) + isolation)
        ) {
            buffered = maybeDrop(time)
            if (buffered != null) {
                promote()
                return
            }
        }
        if (
            turn.speaker == Speaker.ASSISTANT &&
                !hasIncomingUser &&
                time >= (turn.end - timelineOrigin) + silence
        ) {
            finishCurrent(CloseReason.INACTIVITY)
        }
    }

    private fun ingest(fragment: Fragment) {
        val turn = current
        if (turn == null) {
            current = newTurn(fragment)
            emit(current!!)
        } else if (fragment.speaker == turn.speaker) {
            append(turn, fragment)
            emit(turn)
        } else {
            val waiting = buffered
            if (turn.speaker == Speaker.ASSISTANT) {
                buffer(fragment)
                promote()
            } else if (fragment.start - turn.end < separation) {
                val canDrop =
                    waiting?.canDrop != false &&
                        fragment.end - (waiting?.start ?: fragment.start) < maxDuration &&
                        normalize((waiting?.text?.toString() ?: "") + fragment.text).let { text ->
                            // Leading whitespace or punctuation can still precede an
                            // acknowledgment.
                            text.isEmpty() || acknowledgments.any { it.startsWith(text) }
                        }
                buffer(fragment, canDrop)
            } else if (
                waiting?.canDrop != false &&
                    fragment.end - (waiting?.start ?: fragment.start) < maxDuration &&
                    normalize((waiting?.text?.toString() ?: "") + fragment.text) in acknowledgments
            ) {
                buffer(fragment, waiting != null)
            } else {
                buffered = maybeDrop(next = fragment)
                finishCurrent(CloseReason.SPEAKER_CHANGE)
                current = buffered?.also { append(it, fragment) } ?: newTurn(fragment)
                buffered = null
                emit(current!!)
            }
        }
    }

    private fun newTurn(fragment: Fragment) = Turn("${prefix}_${nextId++}", fragment)

    private fun append(turn: Turn, fragment: Fragment) {
        synchronized(turn.text) { turn.text.append(fragment.text) }
        turn.end = maxOf(turn.end, fragment.end)
    }

    private fun buffer(fragment: Fragment, canDrop: Boolean? = null) {
        buffered?.let { append(it, fragment) } ?: run { buffered = newTurn(fragment) }
        if (canDrop != null) buffered!!.canDrop = canDrop
    }

    private fun promote() {
        val waiting = buffered ?: return
        finishCurrent(CloseReason.SPEAKER_CHANGE)
        current = waiting
        buffered = null
        emit(waiting)
    }

    private fun finishCurrent(reason: CloseReason) {
        current?.let { finishTurn(it, reason) }
        current = null
    }

    private fun finishTurn(turn: Turn, reason: CloseReason) {
        if (turn.speaker == Speaker.ASSISTANT) lastAssistantEnd = turn.end
        if (turn.emitted) updates.add(Update(turn.snapshot(), reason))
    }

    private fun emit(turn: Turn) {
        if (!turn.emitted) {
            turn.previous = lastId
            lastId = turn.id
            turn.emitted = true
        }
        updates.add(Update(turn.snapshot()))
    }

    private fun mightDrop(): Boolean {
        val turn = current ?: return false
        val waiting = buffered ?: return false
        return turn.speaker == Speaker.USER &&
            waiting.speaker == Speaker.ASSISTANT &&
            waiting.end - waiting.start < maxDuration
    }

    private fun userContinued(): Boolean =
        mightDrop() && buffered!!.canDrop && current!!.end > buffered!!.end

    private fun recentAssistant(): Boolean {
        val lastEnd = lastAssistantEnd ?: return false
        val turn = current ?: return false
        val waiting = buffered ?: return false
        return waiting.start - lastEnd < isolation && waiting.start <= turn.start
    }

    private fun maybeDrop(time: Double? = null, next: Fragment? = null): Turn? {
        val waiting = buffered ?: return null
        // A prefix is worth buffering, but must not be suppressed before it becomes a complete
        // acknowledgment. It may still grow into substantive speech after a user delta.
        if (
            !waiting.canDrop ||
                !mightDrop() ||
                normalize(waiting.text.toString()) !in acknowledgments
        )
            return waiting
        if (userContinued()) return null
        if (recentAssistant()) return waiting
        if (next != null && next.start - waiting.end < isolation) return waiting
        if (next == null && (time == null || time < (waiting.end - timelineOrigin) + isolation))
            return waiting
        return if (waiting.canDrop) null else waiting
    }

    private fun closeTurns(time: Double, reason: CloseReason) {
        val waiting = maybeDrop(time)
        finishCurrent(reason)
        buffered = null
        if (waiting != null && waiting.text.isNotEmpty()) {
            emit(waiting)
            finishTurn(waiting, reason)
        }
        if (reason == CloseReason.TIMESTAMP_RESET) lastAssistantEnd = null
    }

    private fun schedule() {
        timer?.cancel(false)
        val generation = ++timerGeneration
        if (closed) return
        val delay =
            pending.firstOrNull()?.let { it.received + 50 - now() }
                ?: deadline()?.let { it - sourceNow() }
                ?: return
        // Ceil to milliseconds so fractional thresholds cannot spin on a zero-duration timer.
        timer =
            scheduler.schedule(
                tick@{
                    synchronized(lock) {
                        if (closed || generation != timerGeneration) return@tick
                        flushPending()
                        advance(sourceNow())
                        schedule()
                    }
                    dispatch()
                },
                ceil(delay.coerceAtLeast(0.0)).toLong(),
                TimeUnit.MILLISECONDS,
            )
    }

    private fun dispatch() {
        synchronized(lock) {
            if (dispatching) return
            dispatching = true
        }
        try {
            while (true) {
                val update =
                    synchronized(lock) {
                        if (updates.isEmpty()) {
                            dispatching = false
                            return
                        }
                        updates.removeFirst()
                    }
                listener.accept(update)
            }
        } catch (t: Throwable) {
            synchronized(lock) { dispatching = false }
            throw t
        }
    }
}
