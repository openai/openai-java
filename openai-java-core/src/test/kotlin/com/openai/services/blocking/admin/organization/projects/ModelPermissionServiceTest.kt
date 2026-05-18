// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization.projects

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.admin.organization.projects.modelpermissions.ModelPermissionUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ModelPermissionServiceTest {

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val modelPermissionService = client.admin().organization().projects().modelPermissions()

        val projectModelPermissions = modelPermissionService.retrieve("project_id")

        projectModelPermissions.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val modelPermissionService = client.admin().organization().projects().modelPermissions()

        val projectModelPermissions =
            modelPermissionService.update(
                ModelPermissionUpdateParams.builder()
                    .projectId("project_id")
                    .mode(ModelPermissionUpdateParams.Mode.ALLOW_LIST)
                    .addModelId("string")
                    .build()
            )

        projectModelPermissions.validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val modelPermissionService = client.admin().organization().projects().modelPermissions()

        val projectModelPermissionsDeleted = modelPermissionService.delete("project_id")

        projectModelPermissionsDeleted.validate()
    }
}
