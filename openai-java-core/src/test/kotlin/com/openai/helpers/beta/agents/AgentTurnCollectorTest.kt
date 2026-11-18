package com.openai.helpers.beta.agents

import com.openai.core.jsonMapper
import com.openai.models.beta.agents.AgentSessionEvent
import com.openai.services.beta.agents.AgentTurnCollector
import com.openai.services.beta.agents.AgentTurnResultException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Test

internal class AgentTurnCollectorTest {
    private val mapper = jsonMapper()
    private val domainError =
        """{"type":"error","event_id":"error","session_id":"s","error":{"type":"server_error","code":"session_error","message":"Session error."}}"""
    private val idle =
        """{"type":"agent.session.idle","event_id":"idle","session":{"id":"s","status":"idle"}}"""

    private fun turn(status: String) =
        """{"type":"agent.session.turn.$status","event_id":"$status","session_id":"s","turn_id":"root","turn":{"id":"root","session_id":"s","status":"${if (status == "created") "in_progress" else status}"}}"""

    private fun collect(events: List<String>) =
        AgentTurnCollector().apply {
            enable()
            events.forEach { accept(mapper.readValue(it, AgentSessionEvent::class.java)) }
        }

    @Test
    fun `domain error does not discard a completed turn before the idle boundary`() {
        val collector = collect(listOf(turn("created"), turn("completed"), domainError, idle))

        assertThat(collector.finalResult().turnId()).isEqualTo("root")
        assertThat(collector.isReady()).isTrue()
    }

    @Test
    fun `domain error and idle do not complete an unfinished turn`() {
        val collector = collect(listOf(turn("created"), domainError, idle))

        val failure = catchThrowable { collector.finalResult() } as AgentTurnResultException
        assertThat(failure.reason()).isEqualTo(AgentTurnResultException.Reason.INCOMPLETE_STREAM)
        assertThat(collector.isReady()).isFalse()
    }

    @Test
    fun `domain error and idle do not erase a failed turn`() {
        val collector = collect(listOf(turn("created"), turn("failed"), domainError, idle))

        val failure = catchThrowable { collector.finalResult() } as AgentTurnResultException
        assertThat(failure.reason()).isEqualTo(AgentTurnResultException.Reason.TURN_FAILED)
        assertThat(collector.isReady()).isFalse()
    }

    @Test
    fun `domain error and idle do not erase a failed session`() {
        val sessionFailed =
            """{"type":"agent.session.failed","event_id":"failed","session":{"id":"s","status":"failed"}}"""
        val collector = collect(listOf(turn("created"), sessionFailed, domainError, idle))

        val failure = catchThrowable { collector.finalResult() } as AgentTurnResultException
        assertThat(failure.reason()).isEqualTo(AgentTurnResultException.Reason.TURN_FAILED)
        assertThat(collector.isReady()).isFalse()
    }
}
