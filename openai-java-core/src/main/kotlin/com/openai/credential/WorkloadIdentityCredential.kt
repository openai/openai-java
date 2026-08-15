package com.openai.credential

import com.fasterxml.jackson.databind.json.JsonMapper
import com.openai.auth.WorkloadIdentityAuth
import com.openai.core.Sleeper
import com.openai.core.http.HttpClient
import java.time.Clock

class WorkloadIdentityCredential
internal constructor(private val workloadIdentityAuth: WorkloadIdentityAuth) : Credential {

    @JvmSynthetic internal fun getAuth(): WorkloadIdentityAuth = workloadIdentityAuth

    @JvmSynthetic
    internal fun withDependencies(
        httpClient: HttpClient,
        jsonMapper: JsonMapper,
        sleeper: Sleeper,
        clock: Clock,
        maxRetries: Int,
    ): WorkloadIdentityCredential =
        if (workloadIdentityAuth.uses(httpClient, jsonMapper, sleeper, clock, maxRetries)) {
            this
        } else {
            WorkloadIdentityCredential(
                WorkloadIdentityAuth(
                    config = workloadIdentityAuth.config,
                    httpClient = httpClient,
                    jsonMapper = jsonMapper,
                    sleeper = sleeper,
                    clock = clock,
                    maxRetries = maxRetries,
                )
            )
        }
}
