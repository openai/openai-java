// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization.projects

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.admin.organization.projects.modelpermissions.ModelPermissionUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ModelPermissionServiceAsyncTest {

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val modelPermissionServiceAsync =
            client.admin().organization().projects().modelPermissions()

        val projectModelPermissionsFuture = modelPermissionServiceAsync.retrieve("project_id")

        val projectModelPermissions = projectModelPermissionsFuture.get()
        projectModelPermissions.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val modelPermissionServiceAsync =
            client.admin().organization().projects().modelPermissions()

        val projectModelPermissionsFuture =
            modelPermissionServiceAsync.update(
                ModelPermissionUpdateParams.builder()
                    .projectId("project_id")
                    .mode(ModelPermissionUpdateParams.Mode.ALLOW_LIST)
                    .addModelId("string")
                    .build()
            )

        val projectModelPermissions = projectModelPermissionsFuture.get()
        projectModelPermissions.validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val modelPermissionServiceAsync =
            client.admin().organization().projects().modelPermissions()

        val projectModelPermissionsDeletedFuture = modelPermissionServiceAsync.delete("project_id")

        val projectModelPermissionsDeleted = projectModelPermissionsDeletedFuture.get()
        projectModelPermissionsDeleted.validate()
    }
}
