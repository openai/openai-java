// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.admin.organization.projects

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.admin.organization.projects.servicetiersettings.ServiceTierSettingUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ServiceTierSettingServiceTest {

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val serviceTierSettingService =
            client.admin().organization().projects().serviceTierSettings()

        val projectServiceTierSettings = serviceTierSettingService.retrieve("project_id")

        projectServiceTierSettings.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val serviceTierSettingService =
            client.admin().organization().projects().serviceTierSettings()

        val projectServiceTierSettings =
            serviceTierSettingService.update(
                ServiceTierSettingUpdateParams.builder()
                    .projectId("project_id")
                    .default_(ServiceTierSettingUpdateParams.Default.STANDARD)
                    .enabledTiersAll()
                    .build()
            )

        projectServiceTierSettings.validate()
    }
}
