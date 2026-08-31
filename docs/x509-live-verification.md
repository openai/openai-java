# X.509 issuer-to-API verification

The Java SDK has two separate X.509 verification layers:

- `X509TransportTest` runs in ordinary CI with an ephemeral PKI and real TLS. It verifies the
  production `X509TokenExchange`, including issuer-provided token lifetimes above one hour, one
  fixed certificate alias on the issuer and API legs, exact SNI and authorities, the token-exchange
  wire shape, bearer placement, redirect refusal, hostname verification, server trust, and response
  cleanup.
- `X509LiveVerificationTest` is an explicitly enabled production probe. It performs the exact
  issuer exchange through the production `X509TokenExchange` and then calls
  `GET https://mtls.api.openai.com/v1/models` with both the returned bearer and the enrolled client
  certificate. It uses the existing fixed-origin transport capability, so it remains useful before
  higher-level X.509 client integration lands.

Ordinary tests never use live credentials. A skipped live test is **not** production evidence.

## Hosted setup (GitHub Actions)

Create a dedicated GitHub Actions environment named `x509-live-smoke`. It must:

- allow deployments only from protected `main`;
- require independent approval from the SDK team;
- prevent self-review;
- disable administrator bypass; and
- contain only the X.509 secrets listed below, not API keys or other shared CI credentials.

The organization and project must already be enrolled for X.509 workload identity. Use a dedicated
non-production project with no customer data, a short-lived test certificate, an exact
certificate-subject mapping, and a dedicated active service account with only the permission needed
to list models. Activate its public trust root only for the intended test project. Keep the root
private key and all client private material outside the repository and GitHub artifacts.

Configure these environment secrets:

| Secret | Purpose |
| --- | --- |
| `OPENAI_X509_KEYSTORE_P12_BASE64` | Base64-encoded PKCS#12 containing the client private key and complete certificate chain |
| `OPENAI_X509_KEYSTORE_PASSWORD` | PKCS#12 and private-key password |
| `OPENAI_X509_CERTIFICATE_ALIAS` | Exact static key entry selected for both TLS legs |
| `OPENAI_X509_IDENTITY_PROVIDER_ID` | Enrolled X.509 identity-provider identifier |
| `OPENAI_X509_SERVICE_ACCOUNT_ID` | Least-privilege mapped service-account identifier |

Never put secret values in workflow inputs, command-line arguments, Gradle properties, repository
files, issue or pull-request text, Slack, screenshots, or logs. Produce and store the single-line
PKCS#12 base64 value using approved secret tooling with shell tracing disabled.

## Manual workflow

1. Confirm the certificate is current, the exact provider mapping is active, the dedicated project
   contains no customer data, and the mapped account can list models.
2. Confirm the `x509-live-smoke` protection rules and secret names without reading secret values.
3. From `.github/workflows/x509-live-smoke.yml`, choose **Run workflow**, select `main`, and enable
   **Confirm the protected issuer-to-mTLS API verification**.
4. An independent reviewer approves the protected environment deployment.
5. Retain only the workflow conclusion and its emitted timestamp, exact SDK revision, Java runtime,
   and fixed two-stage completion statement. If a failure safely emits a sanitized request ID, keep
   it only when needed for diagnosis. Never retain response bodies or credential material.

The probe makes no issuer or API request until every required environment value is present and the
PKCS#12 identity, alias, chain, and JVM trust manager have loaded successfully. Both destinations are
hard-coded HTTPS origins, both clients are direct and non-redirecting, and every response is closed.

## Result meanings

- **NOT RUN**: a disabled dispatch completes successfully without running the protected job. If a
  requested protected run lacks required enrolled credentials, the job fails. Neither is a pass.
- **REQUESTED**: the canonical `main` run passed the non-secret guard and awaits or entered the
  protected job. A deployment blocked or cancelled before environment approval remains requested
  and is not a pass; GitHub cannot run a later summary step while approval is pending.
- **PASSED**: exactly one enabled live test obtained a valid bearer from the issuer and completed
  the approved mTLS model-list request. Only the protected job writes this result.
- Any other conclusion is a failure or infrastructure interruption and must not be reported as
  production verification.

The live probe intentionally reports only fixed stage names, HTTP status codes, and sanitized
`x-request-id` values. It does not read API error bodies and discards issuer response bytes after
closing the validated response.

## Local setup and commands

Use a trusted machine with JDK 21 and a clean checkout. With approved certificate tooling, create a
PKCS#12 outside every Git checkout that contains one client private key followed by its complete
leaf-to-root certificate chain. Give that key entry one exact, stable alias. Use an independent
password and inject the single-line base64 PKCS#12, password, alias, provider ID, and service-account
ID through an approved local secret boundary under the five environment names in the table above.
Do not place them in a repository `.env`, shell history, Gradle properties, or command-line
arguments, and keep shell tracing disabled.

Run deterministic real-TLS verification with no credentials:

```shell
./gradlew :openai-java-client-okhttp:test \
  --tests '*X509TransportTest' \
  --tests '*X509LiveVerificationDiagnosticsTest'
```

An authorized maintainer may run the live probe from a trusted machine after setting the five
environment values above through an approved local secret boundary:

```shell
date -u +'%Y-%m-%dT%H:%M:%SZ'
git rev-parse --verify HEAD
java -version
OPENAI_X509_LIVE_TEST=1 ./gradlew :openai-java-client-okhttp:test \
  --tests '*X509LiveVerificationTest' --no-build-cache --no-daemon --rerun-tasks
```

Without `OPENAI_X509_LIVE_TEST=1`, JUnit marks the probe skipped. Do not use a skipped or cached test
as launch evidence.

Expected hosted evidence is the PASSED summary with its timestamp, exact Git revision, Java runtime,
and fixed statement that both the issuer exchange and mTLS API request completed. For a local run,
retain the three non-secret command outputs above plus the non-skipped JUnit result and fixed success
message in
`openai-java-client-okhttp/build/test-results/test/TEST-com.openai.client.okhttp.X509LiveVerificationTest.xml`.
A skipped test, a successful issuer exchange without the API leg, or an API request that did not use
the enrolled client certificate is not end-to-end evidence.

## Safe teardown

For a one-off fixture, first disable the exact provider subject mapping or its dedicated service
account so that it cannot mint new bearers. Allow already issued credentials to expire according to
their issuer-provided lifetimes, which may exceed one hour, or follow the environment owner's
approved revocation procedure. Then remove the five secrets from `x509-live-smoke` and delete the
environment if it has no continuing owner.

Deactivate or remove the public trust root only after the environment owner confirms that no other
mapping, SDK, or test fixture depends on it; never tear down a shared root as part of this runbook.
Finally, destroy the local PKCS#12, leaf private key, and any disposable CA private key using the
approved secret-store or workstation procedure. Confirm that no workflow artifact, test report,
shell history, screenshot, or retained log contains credential material. Keep only the sanitized
evidence described above.

## Rotation and diagnosis

Rotate the short-lived leaf before expiry by replacing the protected PKCS#12 secret, then obtain a
fresh independently approved **PASSED** run before retiring the old identity. Root rotation requires
activating the replacement public root for the test project before replacing callers; remove the old
root only with explicit environment-owner approval.

For TLS failures, inspect certificate validity, chain order, key/alias matching, client-auth EKU,
SAN, project-scoped trust activation, and JVM server trust. For issuer authorization failures,
inspect the exact provider subject mapping and mapped account state. For API authorization failures,
inspect the mapped account's model-list permission. Do not enable wire logging or print certificates,
private keys, passwords, bearer values, request headers, or response bodies while diagnosing.
