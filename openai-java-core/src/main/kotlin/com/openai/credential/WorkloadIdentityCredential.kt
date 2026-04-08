package com.openai.credential

import com.openai.auth.WorkloadIdentityAuth

class WorkloadIdentityCredential
internal constructor(private val workloadIdentityAuth: WorkloadIdentityAuth) : Credential {

    @JvmSynthetic internal fun getAuth(): WorkloadIdentityAuth = workloadIdentityAuth
}
