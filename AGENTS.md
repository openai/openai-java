# Agent instructions

Read [CONTRIBUTING.md](CONTRIBUTING.md) and [SECURITY.md](SECURITY.md) before making changes.

Most SDK sources are generated; `.castiron.stats.yml` records generation metadata. Check whether the
generator owns the code you are changing, preserve existing generated behavior, and update the
authoritative source when it is available. The `openai-java-example/` directory is not modified by
the generator.

## Security requirements

- Never commit OpenAI API keys, bearer tokens, AWS/Bedrock credentials, Sonatype tokens, GPG private
  keys or passphrases, or any other secrets. Read credentials from environment variables such as
  `OPENAI_API_KEY`; use obviously fake values in examples, JUnit/WireMock fixtures, recordings, and
  snapshots. Keep ordinary unit and pull-request tests offline and free of real credentials.
  Purpose-built, explicitly opt-in live integration tests such as `BedrockRuntimeLiveTest` may use
  dedicated, least-privilege credentials and synthetic inputs; never log credentials or customer
  data.
- Keep credentials, authorization or cookie headers, signed requests, and real customer data out of
  default or uncontrolled logs, errors, traces, and test output. Preserve documented diagnostics,
  including `OpenAIServiceException.body()`, API-error and validation messages, and explicitly
  enabled `DEBUG` request/response body logging. Warn before enabling sensitive diagnostics, use
  sanitized fixtures, and redact before forwarding data to untrusted sinks.
- Review direct and transitive Maven dependencies, Gradle plugins and repositories, the Gradle
  wrapper and distribution integrity, dependency locks, and build/install/download scripts before
  changing them. Avoid untrusted artifacts, repositories, and executable installation hooks.
- Pin third-party GitHub Actions to full immutable commit SHAs and review updates. Keep workflow and
  publishing permissions minimal, disable persisted checkout credentials, never expose secrets to
  untrusted pull requests, and keep GitHub App tokens, Sonatype credentials, and GPG signing material
  within their protected release or publishing environments.
- Require security-focused review for changes to API-key or Bedrock/AWS authentication; OkHttp
  transport, base URLs, redirects, proxies, TLS, or header forwarding; file uploads and path
  handling; Jackson serialization/deserialization or polymorphic types; and signing, release, or
  publication logic. Add focused JUnit/WireMock regression tests for changed security boundaries.
- Report suspected vulnerabilities privately through [SECURITY.md](SECURITY.md). Do not open public
  issues, discussions, or pull requests containing vulnerability details or secrets.
