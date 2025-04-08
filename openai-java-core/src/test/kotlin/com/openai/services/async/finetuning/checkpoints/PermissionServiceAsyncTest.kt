// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.finetuning.checkpoints

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.finetuning.checkpoints.permissions.PermissionCreateParams
import com.openai.models.finetuning.checkpoints.permissions.PermissionDeleteParams
import com.openai.models.finetuning.checkpoints.permissions.PermissionRetrieveParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class PermissionServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val permissionServiceAsync = client.fineTuning().checkpoints().permissions()

        val pageFuture =
            permissionServiceAsync.create(
                PermissionCreateParams.builder()
                    .fineTunedModelCheckpoint("ft:gpt-4o-mini-2024-07-18:org:weather:B7R9VjQd")
                    .addProjectId("string")
                    .build()
            )

        val page = pageFuture.get()
        page.response().validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val permissionServiceAsync = client.fineTuning().checkpoints().permissions()

        val permissionFuture =
            permissionServiceAsync.retrieve(
                PermissionRetrieveParams.builder()
                    .fineTunedModelCheckpoint("ft-AF1WoRqd3aJAHsqc9NY7iL8F")
                    .after("after")
                    .limit(0L)
                    .order(PermissionRetrieveParams.Order.ASCENDING)
                    .projectId("project_id")
                    .build()
            )

        val permission = permissionFuture.get()
        permission.validate()
    }

    @Disabled("OpenAPI spec is slightly incorrect")
    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val permissionServiceAsync = client.fineTuning().checkpoints().permissions()

        val permissionFuture =
            permissionServiceAsync.delete(
                PermissionDeleteParams.builder()
                    .fineTunedModelCheckpoint("ft:gpt-4o-mini-2024-07-18:org:weather:B7R9VjQd")
                    .build()
            )

        val permission = permissionFuture.get()
        permission.validate()
    }
}
