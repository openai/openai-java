package com.openai.helpers.beta.agents

import com.openai.core.jsonMapper
import com.openai.models.beta.agents.AgentSessionEvent
import com.openai.services.beta.agents.AgentTurnCollector
import com.openai.services.beta.agents.AgentTurnResultException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class AgentBudgetCollectorTest {
    private val mapper = jsonMapper()
    private val domainError =
        """{"type":"error","event_id":"error","session_id":"s","error":{"type":"server_error","code":"session_error","message":"Session error."}}"""

    private fun budget(sessionId: String = "s") =
        """{"type":"agent.session.budget_reached","event_id":"budget-$sessionId","session":{"id":"$sessionId","status":"budget_reached"}}"""

    private fun turn(status: String) =
        """{"type":"agent.session.turn.$status","event_id":"$status","session_id":"s","turn_id":"root","turn":{"id":"root","session_id":"s","status":"${if (status == "created") "in_progress" else status}"}}"""

    private fun collect(events: List<String>) =
        AgentTurnCollector().apply {
            enable()
            events.forEach { accept(mapper.readValue(it, AgentSessionEvent::class.java)) }
        }

    @Test
    fun `matching budget completes an authoritative completed turn`() {
        val collector = collect(listOf(turn("created"), turn("completed"), domainError, budget()))

        assertThat(collector.finalResult().turnId()).isEqualTo("root")
        assertThat(collector.isReady()).isTrue()
    }

    @ParameterizedTest
    @ValueSource(strings = ["failed", "cancelled"])
    fun `budget does not erase a failed or cancelled turn`(status: String) {
        val collector = collect(listOf(turn("created"), turn(status), budget()))

        val failure = catchThrowable { collector.finalResult() } as AgentTurnResultException
        assertThat(failure.reason())
            .isEqualTo(
                if (status == "failed") AgentTurnResultException.Reason.TURN_FAILED
                else AgentTurnResultException.Reason.TURN_CANCELLED
            )
        assertThat(collector.isReady()).isFalse()
    }

    @Test
    fun `budget does not complete an unfinished turn`() {
        val collector = collect(listOf(turn("created"), budget()))

        val failure = catchThrowable { collector.finalResult() } as AgentTurnResultException
        assertThat(failure.reason()).isEqualTo(AgentTurnResultException.Reason.INCOMPLETE_STREAM)
        assertThat(collector.isReady()).isFalse()
    }

    @Test
    fun `another session budget does not complete the collected turn`() {
        val collector = collect(listOf(turn("created"), turn("completed"), budget("other")))

        val failure = catchThrowable { collector.finalResult() } as AgentTurnResultException
        assertThat(failure.reason()).isEqualTo(AgentTurnResultException.Reason.INCOMPLETE_STREAM)
        assertThat(collector.isReady()).isFalse()
    }

    @Test
    fun `budget does not erase a failed session`() {
        val failed =
            """{"type":"agent.session.failed","event_id":"failed","session":{"id":"s","status":"failed"}}"""
        val collector = collect(listOf(turn("created"), failed, budget()))

        val failure = catchThrowable { collector.finalResult() } as AgentTurnResultException
        assertThat(failure.reason()).isEqualTo(AgentTurnResultException.Reason.TURN_FAILED)
        assertThat(collector.isReady()).isFalse()
    }
}
