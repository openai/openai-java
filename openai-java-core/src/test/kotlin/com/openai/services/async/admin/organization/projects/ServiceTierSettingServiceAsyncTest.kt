// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.admin.organization.projects

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.admin.organization.projects.servicetiersettings.ServiceTierSettingUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ServiceTierSettingServiceAsyncTest {

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val serviceTierSettingServiceAsync =
            client.admin().organization().projects().serviceTierSettings()

        val projectServiceTierSettingsFuture = serviceTierSettingServiceAsync.retrieve("project_id")

        val projectServiceTierSettings = projectServiceTierSettingsFuture.get()
        projectServiceTierSettings.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val serviceTierSettingServiceAsync =
            client.admin().organization().projects().serviceTierSettings()

        val projectServiceTierSettingsFuture =
            serviceTierSettingServiceAsync.update(
                ServiceTierSettingUpdateParams.builder()
                    .projectId("project_id")
                    .default_(ServiceTierSettingUpdateParams.Default.STANDARD)
                    .enabledTiersAll()
                    .build()
            )

        val projectServiceTierSettings = projectServiceTierSettingsFuture.get()
        projectServiceTierSettings.validate()
    }
}
