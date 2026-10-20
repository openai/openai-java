package com.openai.bedrock

/** Selects an Amazon Bedrock endpoint family and its matching AWS SigV4 signing service. */
enum class BedrockEndpoint {
    /** Uses the existing Bedrock Mantle endpoint and the `bedrock-mantle` signing service. */
    MANTLE,

    /** Uses the regional Bedrock Runtime endpoint and the `bedrock` signing service. */
    RUNTIME;

    internal val signingService: String
        get() = if (this == RUNTIME) "bedrock" else "bedrock-mantle"
}
