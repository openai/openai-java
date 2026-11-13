package com.openai.services.blocking

import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.okJson
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.finetuning.jobs.FineTuningJob
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class LifecycleCompatibilityFineTuningTest {
    private fun job(status: String, fields: String) =
        """{
            "object":"fine_tuning.job", "id":"ft_test", "created_at":1, "model":"base",
            "hyperparameters":{}, "organization_id":"org_test", "result_files":[],
            "training_file":"file_train", "status":"$status", $fields
        }"""

    @Test
    fun retrievesJobsBeforeAndAfterASeedIsAvailable(server: WireMockRuntimeInfo) {
        val path = "/fine_tuning/jobs/ft_test"
        server.withStrictClient { client ->
            val jobs = client.fineTuning().jobs()
            val queued = job("queued", """"seed":null""")
            server.wireMock.register(get(path).willReturn(okJson(queued)))
            val pending = jobs.retrieve("ft_test")
            assertThat(pending.seed()).isEmpty
            assertThat(pending._seed().isNull()).isTrue()
            assertWireJson(pending, queued)

            val succeeded =
                job("succeeded", """"seed":0,"fine_tuned_model":"ft_model","finished_at":4""")
            server.wireMock.register(get(path).willReturn(okJson(succeeded)))
            val completed = jobs.retrieve("ft_test")
            assertThat(completed.seed()).contains(0L)
            assertThat(completed.fineTunedModel()).contains("ft_model")
            assertWireJson(completed, succeeded)
        }
    }

    @Test
    fun rawSeedDistinguishesAnOmissionFromExplicitNull() {
        val json = job("running", """"trained_tokens":30""")
        val result = jsonMapper().readValue(json, FineTuningJob::class.java)
        assertThat(result._seed().isMissing()).isTrue()
        assertWireJson(result, json)
    }

    @Test
    fun preservesMalformedSeedForInspection() {
        val json = job("failed", """"seed":{"unexpected":42}""")
        val result = jsonMapper().readValue(json, FineTuningJob::class.java)
        assertThat(result._seed().asObject().get()).containsKey("unexpected")
        assertThrows<OpenAIInvalidDataException> { result.seed() }
        assertThrows<OpenAIInvalidDataException> { result.validate() }
        assertWireJson(result, json)
    }
}
