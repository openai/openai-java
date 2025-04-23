// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.finetuning.checkpoints

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.finetuning.checkpoints.permissions.PermissionCreateParams
import com.openai.models.finetuning.checkpoints.permissions.PermissionDeleteParams
import com.openai.models.finetuning.checkpoints.permissions.PermissionRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class PermissionServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val permissionService = client.fineTuning().checkpoints().permissions()

        val page =
            permissionService.create(
                PermissionCreateParams.builder()
                    .fineTunedModelCheckpoint("ft:gpt-4o-mini-2024-07-18:org:weather:B7R9VjQd")
                    .addProjectId("string")
                    .build()
            )

        page.response().validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val permissionService = client.fineTuning().checkpoints().permissions()

        val permission =
            permissionService.retrieve(
                PermissionRetrieveParams.builder()
                    .fineTunedModelCheckpoint("ft-AF1WoRqd3aJAHsqc9NY7iL8F")
                    .after("after")
                    .limit(0L)
                    .order(PermissionRetrieveParams.Order.ASCENDING)
                    .projectId("project_id")
                    .build()
            )

        permission.validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val permissionService = client.fineTuning().checkpoints().permissions()

        val permission =
            permissionService.delete(
                PermissionDeleteParams.builder()
                    .fineTunedModelCheckpoint("ft:gpt-4o-mini-2024-07-18:org:weather:B7R9VjQd")
                    .permissionId("cp_zc4Q7MP6XxulcVzj4MZdwsAB")
                    .build()
            )

        permission.validate()
    }
}
