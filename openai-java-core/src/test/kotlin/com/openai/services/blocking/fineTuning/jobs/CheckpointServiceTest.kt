// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.fineTuning.jobs

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.FineTuningJobCheckpointListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class CheckpointServiceTest {

    @Test
    fun callList() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val checkpointService = client.fineTuning().jobs().checkpoints()
        val listFineTuningJobCheckpointsResponse =
            checkpointService.list(
                FineTuningJobCheckpointListParams.builder()
                    .fineTuningJobId("ft-AF1WoRqd3aJAHsqc9NY7iL8F")
                    .build()
            )
        println(listFineTuningJobCheckpointsResponse)
        listFineTuningJobCheckpointsResponse.data().forEach { it.validate() }
    }
}
