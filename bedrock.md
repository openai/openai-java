# OpenAI on Amazon Bedrock

The optional `openai-java-bedrock` artifact configures the standard OpenAI Java client for the
OpenAI-compatible Amazon Bedrock Mantle endpoint. It uses the AWS SDK for Java 2.x credential chain
and signs the final HTTP request with SigV4 on every attempt.

## Installation

Use this artifact instead of adding AWS dependencies to the base OpenAI package yourself.

<!-- x-release-please-start-version -->

```kotlin
implementation("com.openai:openai-java-bedrock:4.41.0")
```

```xml
<dependency>
  <groupId>com.openai</groupId>
  <artifactId>openai-java-bedrock</artifactId>
  <version>4.41.0</version>
</dependency>
```

<!-- x-release-please-end -->

## Standard AWS credentials

Configure AWS credentials as you normally would, then provide the region:

```java
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.BedrockOpenAIOkHttpClient;

OpenAIClient client = BedrockOpenAIOkHttpClient.builder()
        .awsRegion("us-east-1")
        .build();
```

The default AWS chain supports system properties, `AWS_ACCESS_KEY_ID`,
`AWS_SECRET_ACCESS_KEY`, `AWS_SESSION_TOKEN`, `~/.aws/credentials`, `~/.aws/config`,
`AWS_PROFILE`, IAM Identity Center (SSO), assume-role and web-identity profiles, container
credentials, and instance-profile credentials. The SDK resolves fresh credentials and signs again
before every retry.

Region resolution follows this order:

1. `awsRegion(...)`
2. `AWS_REGION`
3. `AWS_DEFAULT_REGION`
4. the AWS SDK's default region provider chain

Base URL resolution follows this order:

1. `baseUrl(...)`
2. `AWS_BEDROCK_BASE_URL`
3. `https://bedrock-mantle.{region}.api.aws/openai/v1`

The `bedrock-mantle` SigV4 service name is intentional. Bedrock's OpenAI-compatible route is
model-dependent: models such as `openai.gpt-5.5` use `/openai/v1`, while
`openai.gpt-oss-120b` uses `/v1`. The builder defaults to `/openai/v1`; configure the
model's documented route explicitly when it differs:

```java
OpenAIClient client = BedrockOpenAIOkHttpClient.builder()
        .awsRegion("us-east-1")
        .baseUrl("https://bedrock-mantle.us-east-1.api.aws/v1")
        .build();
```

## Named profile

```java
OpenAIClient client = BedrockOpenAIOkHttpClient.builder()
        .awsRegion("us-east-1")
        .awsProfile("production")
        .build();
```

## Explicit temporary credentials

Prefer profiles and workload roles in production. Explicit credentials are useful for tests and
short-lived credentials obtained elsewhere:

```java
OpenAIClient client = BedrockOpenAIOkHttpClient.builder()
        .awsRegion("us-east-1")
        .awsAccessKeyId(accessKeyId)
        .awsSecretAccessKey(secretAccessKey)
        .awsSessionToken(sessionToken)
        .build();
```

For refreshable credentials, pass an AWS SDK `AwsCredentialsProvider`:

```java
OpenAIClient client = BedrockOpenAIOkHttpClient.builder()
        .awsRegion("us-east-1")
        .awsCredentialsProvider(credentialsProvider)
        .build();
```

## Bearer-token compatibility

`AWS_BEARER_TOKEN_BEDROCK` remains supported for compatibility and takes precedence over the
default AWS chain. An explicit AWS credential mode takes precedence over that environment
variable. You can also provide a bearer credential directly:

```java
OpenAIClient client = BedrockOpenAIOkHttpClient.builder()
        .awsRegion("us-east-1")
        .apiKey(bedrockBearerToken)
        .build();
```

Explicit bearer and AWS credential modes are mutually exclusive.

## Async and streaming responses

The same client configuration supports asynchronous and streaming calls:

```java
OpenAIClientAsync client = BedrockOpenAIOkHttpClient.builder()
        .awsRegion("us-east-1")
        .build()
        .async();
```

Response streaming is supported. SigV4 request bodies must be replayable so the SDK can hash them
and safely retry; one-shot streaming request bodies are rejected before network I/O. Asynchronous
bearer-token and SigV4 authentication work runs on a dedicated client-owned executor by default;
pass `authenticationExecutor(...)` to use a caller-owned executor instead.

## Security

- Do not ship AWS credentials in browser or untrusted client applications.
- Prefer temporary credentials, roles, profiles, and workload identities over long-lived keys.
- Do not log access keys, secret keys, session tokens, bearer tokens, or signed authorization
  headers. The SDK redacts `Authorization` and `X-Amz-Security-Token` from its HTTP logs.
- OpenAI workload identity federation and AWS Bedrock SigV4 are separate authentication systems.
