// Curated from LiveDecisionsOmittedListTest at 3d194e30df1ed215a3292dacf9ffe13fc50a6266.
// Preserve all unaffected consumer expressions for the next-major Live migration.
// Only the intentionally replaced item/question constructors use wire-shaped values.
// The ordinary current SDK tests retain typed-constructor and runtime coverage.
package com.openai.models.live

import com.openai.core.jsonMapper
import com.openai.models.live.sessions.SessionAcceptParams
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalStateException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LiveDecisionsOmittedListCompatibility {
    private val trigger =
        DecisionTrigger.builder()
            .decisions(DecisionTrigger.Decisions.builder().addPredicateQuestion("Ready?").build())
            .eventType(DecisionTrigger.EventType.SESSION_INPUT_TRANSCRIPT_DELTA)
            .build()

    @Test
    fun builtConfigCopyPreservesOmissionUntilFirstTrigger() {
        val config = SessionUpdateConfig.builder().build()

        assertThat(config.toBuilder().build()._triggers().isMissing()).isTrue()
        assertThat(config.toBuilder().addTrigger(trigger).build().triggers())
            .contains(listOf(trigger))
    }

    @Test
    fun acceptedSessionCopyAcceptsFirstTrigger() {
        val session =
            SessionAcceptParams.Session.builder()
                .model(SessionAcceptParams.Session.Model.GPT_LIVE_1)
                .build()

        assertThat(session.toBuilder().addTrigger(trigger).build().triggers())
            .contains(listOf(trigger))
    }

    @Test
    fun deserializedConfigCopyPreservesOmissionUntilFirstQuestion() {
        val config = jsonMapper().readValue("{}", DecisionsDelegationUpdateConfig::class.java)
        val question =
            jsonMapper()
                .readValue(
                    """{"questions":[{"type":"predicate","instructions":"Ready?"}]}""",
                    DecisionsDelegationUpdateConfig::class.java,
                )
                .questions()
                .get()
                .first()

        assertThat(config.toBuilder().build()._questions().isMissing()).isTrue()
        assertThat(config.toBuilder().addQuestion(question).build().questions())
            .contains(listOf(question))
    }

    @ParameterizedTest
    @ValueSource(strings = ["null", "\"not a list\""])
    fun copiedNonListTriggerValueRejectsAppend(jsonValue: String) {
        val config =
            jsonMapper().readValue("""{"triggers":$jsonValue}""", SessionUpdateConfig::class.java)

        assertThatIllegalStateException().isThrownBy { config.toBuilder().addTrigger(trigger) }
    }
}
