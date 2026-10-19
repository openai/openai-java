# Java generated/custom transition tasks

See [the measured plan and per-file inventory](plan.md). User authorization covers
implementation and PR submission; normal review and compiler-before-promotion
gates remain in effect. No developer-facing breaking changes are allowed.

## Foundation

- [x] Verify current public generated snapshot and measure every mixed file.
- [x] Classify runtime, models, services, tests, and tooling with exact patch counts.
- [x] Record compiler ownership, compatibility gates, parallel work and dependencies.
- [ ] Publish inventory/plan PR and record its URL here.
- [ ] Add full public/protected JAR API comparison and previously compiled consumer
  linkage coverage before broad model/service regeneration. Preserve existing
  compatibility policy and test manifests. Verify deliberate binary incompatibility
  is caught and unchanged artifacts pass.

## Independent initial slices

- [ ] C1: Generate telemetry provenance bridge in the OpenAI profile. Preserve
  Stainless fixtures. Verify both clients and explicit headers/clones/toggles;
  submit compiler Delta, merge, then regenerate SDK. Target: 2 files / 4 lines.
- [ ] C2: Generate async multipart mapping from semantic facts. Preserve runtime
  ownership and old fixture profile. Enumerate newly affected endpoints and test
  cancellation/cleanup/error boundaries before promotion. Submit separate compiler
  Delta; SDK regeneration depends on compiler merge and runtime validation.
- [ ] C13: Restore exact generated tooling comment; verify Python AST equivalence,
  offline reporter/budget tests and unchanged gate behavior. Separate SDK PR.
- [ ] C12: Move handwritten credential diagnostic assertions into the existing
  handwritten regression suite and restore generated smoke test. Preserve every
  assertion; run both focused test classes. Separate SDK PR.

## Model and parameter slices

- [ ] C5: Preserve legacy api-key expiry and additional-property accessors with
  typed facts, roundtrips and old-consumer linkage. Separate accessor contracts
  from enum/factory aliases; no return-type or missing/null behavior changes.
- [ ] C6: Preserve embedding List<Float> public API with base64 storage/decoding;
  test both encodings and omitted defaults before compiler adoption.
- [ ] C7: Generate backward-compatible union visitor defaults. Run old visitor
  fixtures and unknown/new-variant tests; preserve aliases and JSON representation.
- [ ] C8: Generate existing diagnostic redaction using sensitivity facts. Coordinate
  with C7 in shared union templates; run raw-JSON/visitor/diagnostic tests and obtain
  security-focused maintainer review before promotion.
- [ ] C4: Generate structured-output builder/service overloads as thin helper
  delegates. Preserve JVM descriptors and defaults; run manifest, whole-JAR and
  Java/Kotlin consumer checks. Coordinate shared model templates with C5-C8.

## Service and generated-test slices

- [ ] C3: Generate audio response-format handler dispatch; run existing audio media
  tests for blocking/async, text/JSON, validation and closure. Depends on C2 method
  view integration; no multipart lifecycle regression.
- [ ] C9: Generate existing Responses WebSocket bridges and stream validation;
  run lifecycle, cancellation, large-payload and old service-implementation tests.
  Coordinate ResponseService interface with C4.
- [ ] C10: Generate Agent session/tool-handler delegates and retry-stable environment
  idempotency. Preserve unsupported-service messages, executor and terminal behavior.
  Verify agent orchestration/pagination/credential suites.
- [ ] C11: Generate legacy beta Realtime subservice and current operation credential
  selection from authoritative inputs. Retain deprecated entrypoints and obtain
  security-focused review for auth changes.
- [ ] C14: Generate current WebhookVerificationParams entrypoints and verifier
  delegates. Preserve payload-byte, timestamp and parse behavior; run existing
  signature/unwrap suites and obtain security-focused review.
- [ ] C12: Emit deterministic streaming/server fixtures and canonical model samples;
  retain response fixture consolidation and independent pagination WireMock suite.
  Split into feature-sized PRs with matching model/service slices. No new disabled
  coverage, redundant giant fixtures or weaker assertions.

## Per-slice landing checkpoint

- [ ] Compiler implementation and focused tests reviewed; immutable fixtures pass.
- [ ] Draft output reviewed against shipped SDK; public APIs/behavior preserved.
- [ ] Compiler merged before promotion; generation used verified merged binary.
- [ ] SDK checks, security review where applicable, and normal approval satisfied.
- [ ] Trusted report shows actual mixed-file/line reduction; refresh inventory.

## Completion

- [ ] All generated-owned files match verified generation, including tests/tooling.
- [ ] Regeneration is repeatable; handwritten runtime and regression tests retained.
- [ ] Zero mixed files and zero custom patch lines verified on merged SDK main.
- [ ] Submit any budget decrease/strict policy activation as its own policy-only PR.

## PR/Delta ledger

Record URL, exact current head, validation result, review state, compiler dependency,
and merge state here as work is published. Never record a proposed reduction as
landed merely because its compiler change exists or CI is green.
