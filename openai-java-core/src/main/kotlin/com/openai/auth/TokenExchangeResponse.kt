package com.openai.auth

import com.fasterxml.jackson.annotation.JsonProperty

internal data class TokenExchangeResponse(
    @JsonProperty("access_token") val accessToken: String,
    @JsonProperty("issued_token_type") val issuedTokenType: String,
    @JsonProperty("token_type") val tokenType: String,
    @JsonProperty("expires_in") val expiresIn: Int?,
)
