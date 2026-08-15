# OpenAI on Amazon Bedrock

The optional `openai-java-bedrock` artifact configures the standard OpenAI Java client for the
OpenAI-compatible Amazon Bedrock Mantle and Runtime endpoints. It uses the AWS SDK for Java 2.x
credential chain and signs the final HTTP request with SigV4 on every attempt. Existing clients
continue to use Mantle by default.

## Installation

Use this artifact instead of adding AWS dependencies to the base OpenAI package yourself.

<!-- x-release-please-start-version -->

```kotlin
implementation("com.openai:openai-java-bedrock:4.51.0")
```

```xml
<dependency>
  <groupId>com.openai</groupId>
  <artifactId>openai-java-bedrock</artifactId>
  <version>4.51.0</version>
</dependency>
```

<!-- x-release-please-end -->

## Bedrock Runtime

Select `BedrockEndpoint.RUNTIME` to use the Bedrock Runtime OpenAI-compatible endpoint. This
selects the regional `bedrock-runtime` hostname and the `bedrock` SigV4 signing service while
retaining the standard OpenAI Chat Completions and Responses APIs:

```java
import com.openai.bedrock.BedrockEndpoint;
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.BedrockOpenAIOkHttpClient;
import com.openai.models.chat.completions.ChatCompletionCreateParams;

OpenAIClient client = BedrockOpenAIOkHttpClient.builder()
        .endpoint(BedrockEndpoint.RUNTIME)
        .awsRegion("us-east-1")
        .build();

ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model("us.openai.gpt-5.6-sol")
        .addUserMessage("Say hello from Amazon Bedrock Runtime")
        .build();

client.chat().completions().create(params).choices().stream()
        .flatMap(choice -> choice.message().content().stream())
        .forEach(System.out::println);
```

Use the cross-region inference-profile identifier configured for your AWS account and region.
Examples include `us.openai.gpt-5.6-sol`, `us.openai.gpt-5.6-terra`, and
`us.openai.gpt-5.6-luna`; AWS rejects bare model identifiers for these deployments. Availability,
global inference-profile access, supported API routes, authentication methods, streaming behavior,
and model permissions depend on AWS account configuration and the selected model.

The default Runtime URL is `https://bedrock-runtime.{region}.amazonaws.com/openai/v1` in standard
AWS regions. The SDK selects the appropriate DNS suffix automatically for China, European Sovereign
Cloud, and ISO partitions. Canonical Runtime URLs, including FIPS and dual-stack URLs, also infer
Runtime mode when passed to `baseUrl(...)` or `AWS_BEDROCK_BASE_URL`.

Run the included example with your existing AWS credentials:

```shell
AWS_REGION=us-east-1 BEDROCK_MODEL=us.openai.gpt-5.6-sol \
  ./gradlew :openai-java-example:run -Pexample=BedrockRuntimeChat
```

Set `BEDROCK_STREAM=true` to stream Chat Completions. Set `BEDROCK_AUTH=bearer` and
`AWS_BEARER_TOKEN_BEDROCK` to use a Bedrock bearer token instead of SigV4. Set `AWS_PROFILE` to
select an explicit AWS profile and ensure a stale environment bearer token does not take precedence.

An opt-in live test exercises Sol, Terra, and Luna inference profiles using real AWS credentials:

```shell
BEDROCK_LIVE_TEST=1 AWS_REGION=us-east-1 \
  ./gradlew :openai-java-bedrock:test --tests '*BedrockRuntimeLiveTest'
```

Set `BEDROCK_LIVE_AUTH=bearer`, `BEDROCK_LIVE_API=responses`, or
`BEDROCK_LIVE_STREAM=true` to choose the authentication mode, API, and streaming behavior. Use
`BEDROCK_LIVE_MODELS` to provide a comma-separated set of account-enabled inference profiles.

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
3. the regional endpoint selected by `endpoint(...)`:
   - Mantle: `https://bedrock-mantle.{region}.api.aws/openai/v1`
   - Runtime: `https://bedrock-runtime.{region}.amazonaws.com/openai/v1`

Mantle requests use the `bedrock-mantle` SigV4 service name. Runtime requests use the `bedrock`
SigV4 service name. Bedrock's OpenAI-compatible route is model-dependent: models such as
`openai.gpt-5.5` use `/openai/v1`, while `openai.gpt-oss-120b` uses `/v1`. Both endpoint families
default to `/openai/v1`; configure the model's documented route explicitly when it differs:

```java
OpenAIClient client = BedrockOpenAIOkHttpClient.builder()
        .awsRegion("us-east-1")
        .baseUrl("https://bedrock-mantle.us-east-1.api.aws/v1")
        .build();
```

Runtime deployments that require the `/v1` route can be configured similarly:

```java
OpenAIClient client = BedrockOpenAIOkHttpClient.builder()
        .endpoint(BedrockEndpoint.RUNTIME)
        .awsRegion("us-east-1")
        .baseUrl("https://bedrock-runtime.us-east-1.amazonaws.com/v1")
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

If a shell contains a stale `AWS_BEARER_TOKEN_BEDROCK`, default-chain authentication will use that
token instead of signing with SigV4. Unset the variable, or select an explicit AWS profile,
credentials provider, or static credentials to force SigV4.

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
- Canonical AWS Bedrock URLs require HTTPS. Their endpoint family and region must match the
  selected endpoint and configured signing region.
- An explicitly selected endpoint is required when signing requests for a custom proxy or test
  server. This prevents an ambiguous hostname from selecting the wrong SigV4 service.
- Do not log access keys, secret keys, session tokens, bearer tokens, or signed authorization
  headers. The SDK redacts `Authorization` and `X-Amz-Security-Token` from its HTTP logs.
- OpenAI workload identity federation and AWS Bedrock SigV4 are separate authentication systems.
