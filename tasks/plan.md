# Java generated/custom code transition

Status: executing. Baseline measured on 2026-10-19. This is a compatibility-preserving
maintenance project: **no developer-facing breaking changes are permitted**.

## Measured baseline

The audited SDK commit is `caa95e12459e3cca6e85403dd3727f5eacd9a9d5`.
The public pure-generated snapshot is `0350fd6fb7b54ef210e0701e987ca35bda2ce407`,
generation `c951a9fc-cdc1-4f8f-8f09-fca90b82c501`, with verified content hash
`f7bdb28a83b26a9c631714ff703a6591774ac1f819d66f16e5e7aa81a5fdc817`.

| Area | Mixed files | Added lines | Deleted lines | Custom patch lines | Current physical lines |
| --- | ---: | ---: | ---: | ---: | ---: |
| Client implementations | 2 | 2 | 2 | 4 | 888 |
| Models and parameters | 37 | 584 | 273 | 857 | 115,168 |
| Service interfaces and implementations | 33 | 600 | 68 | 668 | 10,345 |
| Generated tests | 26 | 145 | 355 | 500 | 6,743 |
| Reporting tooling | 1 | 1 | 1 | 2 | 737 |
| **Total** | **99** | **1,332** | **699** | **2,031** | **133,881** |

The audited ceiling is 3,000 custom patch lines, with 969 lines of baseline headroom.
Added plus deleted lines measure the *entire remaining patch* against generated
output, including deletions and comments. They are not an estimate of newly
written logic. Physical lines include comments and blanks. The appendix also
provides nonblank lines for each file; neither measure is a language-aware SLOC
count. All counts refer to the pinned commit, not a moving main branch.

Ownership comes from the verified snapshot, not generated-file headers or blame.
As a completeness cross-check, all 3,807 entries in the generated ownership
manifest were compared with current file contents: the same 99 files differ and
no additional manifest-owned files differ. The two generated custom-code
workflows match their recorded hashes; they add no hidden workflow customizations
outside the reporter's workflow exclusion.
Most runtime code is already wholly handwritten: `ClientOptions`, transport,
authentication, WebSocket connections, structured-output utilities, and most
helpers are absent from this snapshot. Moving those files does not reduce this
inventory. `DataResidency.kt` and `MultipartEncoding.kt` are generated and currently
unmodified. Examples are explicitly outside generator ownership.

## Landed progress

On 2026-10-19, #1235 merged as `479972a1ee2a7cd181f67f478c95aad9d1d1e261`
and #1237 merged as `d445a6a2db03d6f0979efb2d8355452029f08a00`.
The reporter was rerun at the latter merged SDK commit with generated hashes
required. It verifies **97 mixed files and 2,025 custom patch lines**
(1,328 additions + 697 deletions): two files and six patch lines removed from the
pinned baseline above. All 97 remaining customizations are classified unchanged.
The generated reporting comment and credential smoke test now match generation;
the credential diagnostic assertions remain in the handwritten regression suite.

This merged SDK uses generated snapshot `796d4eb4ee6b79f8c52b573d4639abe3d824ed8c`,
generation `4b2c79c9-7da9-402a-972f-15915bc1b58e`, with verified content hash
`4694ab8bc5b55e700ffe78cd2eb1cfb0f0cc5bb1659880bf2f14edd824006a1d`.
The appendix remains the original audited baseline, including the two now-restored
files; the task ledger records landed slices separately. These counts describe
this exact merged commit, not future main or pending compiler/SDK candidates.

## Compiler compatibility evidence

The initial inventory, comparator and two cleanup PRs have all merged. Compiler
work is still pending review and integration; its projected reductions are not
included in the landed counts above. See the dated [task ledger](todo.md) for
exact heads and separate post-merge CI results.

C1's complete Java renderer suite passes 789 tests with eight existing ignored.
Both actual client sources drafted from authoritative inputs compile against the
shipped SDK and pass 92 public-client cases / 128 loopback requests, including
telemetry overrides, retries, clones and explicit User-Agent removal/replacement.
Class-location assertions require the newly compiled clients. A supplemental
comparison of both client class families finds no potential JVM incompatibilities
(116 classfiles per side, four exported API classes). This is scoped evidence;
human helper-contract review and SDK regeneration/compatibility gates still apply.

C2's actual generated implementations for five additional service groups pass
62 lifecycle cases covering cancellation, HTTP/transport failures, validated
typed success, raw response ownership, malformed JSON and body-read failures.
The committed opt-in runner checks the loaded service classes and preserves
close-once and diagnostic assertions. Audio format/streaming integration remains
pending, so the compiler Delta stays draft and SDK promotion remains blocked.

The next compiler foundations preserve two contracts that cannot be inferred
from optionality or media types alone:

- Transcription treats `diarized_json` and `verbose_json` with explicit parsers;
  `json` and absent/null/non-string format values use union JSON, while every
  other string uses text. Translation uses text only for `text`, `srt` and `vtt`;
  other values use union JSON. Retain the existing handwritten handlers and
  effective multipart-body selection; keep SSE handling unchanged. A shared
  JSON/text classifier would change behavior. Preserve the existing synthetic
  `AudioResponseFormat.isJson` JVM member and behavior even though current
  sources do not call it.
- API-key expiry retains its legacy `Long` getter and separate optional getter,
  including shipped missing/null handling and validation. Its source property is
  optional, and lowered method properties may retain source identity through
  `schema_paths` provenance rather than their own `oas_ref`. Preserve wire
  requiredness and resolve explicit accessor policy through that provenance.

These foundations use explicit typed policies from authoritative inputs, with
absent policies preserving existing output. They must not select behavior from
resource-name allowlists or rewrite immutable Stainless fixtures.

## Intended boundary

Generate models, public service/client surfaces, and thin calls into handwritten
helpers. Keep transport, credential providers, schema reflection, stream/session
orchestration, verification algorithms, and their dedicated regression tests in
SDK-owned files. Public members, including existing public synthetic JVM members,
must stay in their current owning classes and interfaces: replacing Java-callable
members with Kotlin extensions is a breaking change. Preserve all existing
deprecations and compatibility aliases.

Compiler work belongs in the authoritative Castiron source, currently
`api/castiron` in the compiler monorepo. The standalone Castiron repository is
archived. The relevant Java renderer is `crates/castiron-render-java`; typed facts
originate in `crates/castiron-compiler`. Input/schema changes belong in the API
reference and SDK configuration that feed the compiler, not in an output patch.

For intentional divergence, use the existing OpenAI codegen profile and preserve
Stainless-parity output and immutable fixture expectations. Do not introduce
compatibility epochs, per-fixture switches, output rewriting, or resource-name
allowlists to reproduce patches. Add semantic facts where general rendering lacks
the information it needs.

## Workstreams and compiler changes

The IDs below classify appendix rows. A file may require multiple workstreams;
do not sum overlapping estimates as if they were independent reductions.

| ID | Current customization | Authoritative change and retained handwritten boundary | Acceptance evidence |
| --- | --- | --- | --- |
| C1 | Sync/async default User-Agent provenance | `templates/client.kt.askama`, `templates.rs` and `rendering/generated_files.rs`: emit `defaultUserAgent(...)` rather than caller-header insertion in the OpenAI profile. Keep the explicit-header guard and original options passed to peer clients. | Both impls match shipped source; `TelemetryTest` covers toggles, explicit headers, clones, retries, and isolated system properties. Exactly 2 files / 4 patch lines can disappear after regeneration. |
| C2 | Async multipart result mapping | `services.rs`, `views.rs`, `templates/service_impl_method.kt.askama`, `templates/service_impl_raw_method.kt.askama`: select cancellation/cleanup-aware mapping from multipart facts. Keep `MultipartFuture.kt` and multipart runtime handwritten. | Cover cancellation before preparation, while executing, after response arrival, parse failure, and successful body ownership. Five current files account for 53 patch lines; validate the seven additional affected services before promotion. |
| C3 | Audio response-format dispatch | Derive text/JSON response handling from response-format and response-content facts. Generate dispatch into `AudioResponseHandlers.kt` for transcription/translation in blocking and async methods. | Existing audio media tests preserve text formats, JSON variants, validation and resource cleanup. Do not turn valid non-JSON responses into parse errors. |
| C4 | Structured-output overloads and convenience builders | Model/service templates must emit current `Class<T>` overloads, generic wrappers, `@JvmOverloads`, and conversions; keep reflection/schema logic and accumulators handwritten. | Structured-output public API manifests, prior Java/Kotlin consumer compilation and linkage, current structured-output tests. Covers Responses/Chat interfaces, create params, text config and function/tool helpers. |
| C5 | Legacy public accessors, aliases and JSON shape | Add typed accessor/storage compatibility facts. Preserve required `expiresInSeconds(): Long` plus optional accessor; preserve legacy additional-property lookups without serializing duplicate known fields; preserve tool-search model aliases, enum constants, nullable builder defaults, accepted object tags and duration strings. | Api-key, error/enum, tool-search, and webhook model compatibility tests; JVM descriptors and JSON roundtrips. Regenerating the currently incompatible baseline is prohibited. |
| C6 | Embedding decoding/default encoding | Emit union-backed storage with the existing `embedding(): List<Float>` API, compatible builders, and base64-aware decoding/default facts. Keep decoding helpers handwritten where appropriate. | Float/base64 fixtures, malformed data behavior, finite numbers, prior compiled consumers, and omitted versus explicit encoding. |
| C7 | Evolving union visitors and response conveniences | Union templates emit backward-compatible default visitor methods and stable factories/aliases; object templates retain current output/usage convenience methods. | Existing visitor compatibility tests, including old visitor implementations and unknown/new variants; preserve serializable JSON. |
| C8 | Diagnostic redaction | Carry sensitivity semantics through typed schema facts to object/union diagnostic rendering, including unknown variants and additional properties. Keep raw JSON, equality, custom visitors and explicit serialization unchanged. | Credential/environment/webhook redaction tests with synthetic values; exact nonsecret diagnostic compatibility. Security-focused maintainer review. |
| C9 | Responses WebSocket/stream validation | Emit existing `connect` overloads/default fallbacks and implementation bridges; generate calls to `validateForStream` while keeping connection lifecycle and validation helpers handwritten. | Responses WebSocket lifecycle tests, stream validation, cancellation, cleanup and large-payload tests. Keep `@MustBeClosed` and interface JVM default methods. |
| C10 | Agent stream orchestration and idempotency | Emit existing session stream/tool-handler entrypoints as thin calls into `AgentSessionStream`, async counterpart, and `AgentTurnResults`; preserve caller-provided environment idempotency headers and retry-stable generated keys. | Agent stream/turn/pagination and environment credential tests; sync/async executor and terminal-event behavior; preserve unsupported-service diagnostics. |
| C11 | Legacy beta subservice and auth selection | Model retained deprecated subservices in configuration/typed resource facts; render existing beta Realtime bridge. Preserve current permission-operation credential selection through input/security facts. | Existing beta callers still compile/link; operation-level authorization tests and maintainer security review. Do not remove deprecated APIs as cleanup. |
| C12 | Generated test fidelity and cost | Generator-owned streaming tests need deterministic SSE fixtures rather than unsupported mock responses. Preserve agent WireMock setup, webhook verification expectations, canonical model samples, consolidated response fixture, and isolated pagination suite. | Same or stronger assertions, offline execution, existing shard/lock isolation and compilation cost. Do not restore redundant giant fixtures or duplicate server tests solely to lower the metric. |
| C13 | Tooling-only drift | Restore the generated lint-annotation comment if it changes no executable Python or lint result. | AST equivalence and custom-code tests; exact generated blob match. 1 file / 2 patch lines. |
| C14 | Webhook verification entrypoints | `templates/service_webhook_helper.kt.askama` and `service_impl_webhook_helper.kt.askama` must emit current `WebhookVerificationParams`, signature-verification methods and async delegates. Keep verification algorithms in `WebhookVerification.kt`. | Signature/unwrap tests for payload bytes, timestamp tolerance, headers and parse errors; preserve public descriptors and security-focused maintainer review. |

### Model-specific contracts

The general templates need the following distinctions; a blanket regeneration or
schema-requiredness change cannot replace these contracts.

* `Response` and `BetaResponse` initialize newly required nullable `accessPrograms`
  builder fields to JSON null so older builders remain valid.
* `ResponseError`, `BetaResponseError` and `VideoCreateError` retain old
  `_additionalProperties()` lookups for newly typed `type`/`param`; nested Realtime
  status errors do the same for `message`. Serialization uses a separate,
  collision-safe accessor.
* Tool-search output parameters use canonical `Tool`/`BetaTool` lists and helper
  overloads while retaining the generated nested `Tool` class for linkage. The
  canonical list types also flow through inject events, conversation/item builders
  and Live response-item helpers.
* `ResponseFunctionWebSearch` must keep shipped `Action.Find`, `ofFind` and
  `visitFind` names even though the current generated baseline says `FindInPage`.
* `VectorStoreFileBatch` accepts both longstanding plural and current singular
  object tags; `Video` accepts arbitrary duration strings while retaining the
  `VideoSeconds` API and raw serialization.
* `AudioResponseFormat.isJson` is an existing synthetic JVM compatibility member
  to retain in its current enum class with its current behavior. C3 service
  dispatch uses the handwritten audio handlers, not that classifier.
* The four compaction stream/server union patches are visitor documentation only;
  don't count them as missing visitor implementations.
* Chat params retain Class-based format/tool methods but suppress unshipped
  prediction convenience aliases. Function-call models provide `arguments(Class)`;
  tool message and response function-output builders provide JSON convenience
  methods. These need distinct typed helper capabilities.
* Credential diagnostics redact known/unknown secret-bearing shapes and typed
  accessor failures while preserving raw payloads and custom visitors. Their
  visitor defaults and diagnostic policies are separate compiler facts.
* Current Castiron already has union visitor default policy support in
  `visitor_policy.rs`, `model_union.kt.askama` and `union_class.kt.askama`. Check
  canonical configuration/facts before adding renderer machinery. Existing support
  is union-wide: matching the selective credential/webhook defaults needs typed
  per-variant selection, without changing existing abstract/default member status.
  Retain the existing stream/multipart/deprecated-visitor safety gates. Existing
  support is not proof that a particular snapshot contains the behavior.

The model field pipeline runs through
`schema/matching_http_type_alias.rs`, `views.rs::ObjectFieldView`, and
`templates/object_class.kt.askama`; request bodies additionally use `params.rs`
and the `model_body_param_*` templates. Add accessor/default/accepted-value/
sensitivity facts there rather than matching output strings. Union naming comes
from `schema/object_view_memo_key.rs`; canonical tool-list overloads flow through
`object_union_builder_aliases.kt.askama`,
`object_list_item_union_builder_aliases.kt.askama` and
`body_param_union_builder_aliases.kt.askama`. Preserve nested declarations.

`AudioResponseFormat.isJson` is Kotlin-internal and `@JvmSynthetic`, but it emits
an existing public JVM member. The compiler must generate that same member in
`AudioResponseFormat`, preserving its descriptor, visibility/annotations and
behavior; moving it into an adapter or removing it is not part of this migration.
The enum remains in the mixed-file inventory until compiler support reproduces
that member. Keep service response dispatch in the existing audio handlers,
including their distinct format fallbacks; do not change the classifier to drive
dispatch or count an adapter-only change as removal of the enum patch.

### Important coupled cases

* `ResponseService{Async}` each combine structured outputs with WebSocket methods;
  their implementations combine WebSockets with streaming validation. One compiler
  patch alone will not make these files pure generated.
* Transcription and translation combine response dispatch with async request-body
  handling. A general multipart rule can affect more endpoints than today's custom
  patch. New output needs runtime tests even when public signatures are unchanged.
  The five currently patched async services are Images, Skills, Videos, audio
  Voices and skill Versions. The additional services are Files, ContentProvenance
  Checks, container Files, Realtime Calls, upload Parts, Transcriptions and
  Translations. Nonmultipart methods such as video content download remain outside
  that rule. High-level void-return methods retain their existing `thenAccept`
  behavior; raw multipart HTTP responses still use the mapper. Current inputs have
  no high-level void multipart endpoints. Compile probes must use the generator's
  actual nullable `Void?` signature rather than assume a nonnullable return type.
* Credential union files combine default visitor methods and diagnostic redaction.
  Tool-search output models combine public type aliases and visitor compatibility.
* The largest patch, `ResponseTest.kt` (+1/-235), consolidates duplicate large
  fixtures. `SkillServiceTest.kt` (-88) moves pagination coverage into an independent
  handwritten WireMock test to avoid shared server locks. Preserve those outcomes
  in generation; restoring old output would undo deliberate improvements.
* `@Disabled` streaming tests are existing debt, not a target pattern. Compiler
  cleanup must replace unsupported mock behavior with working offline coverage.

## Compatibility gates for every reduction

1. Record the exact SDK base, compiler source/binary revision, generated snapshot,
   and ownership report. Compare final integrated output with both current shipped
   SDK code and its pure-generated snapshot. Review unrelated generated changes.
2. Preserve all public/protected JVM descriptors, generic signatures, constructors,
   nested classes, overloads, static factories, checked exceptions and annotations
   that consumers rely on. Preserve Kotlin defaults, Java interface default methods,
   and downstream implementations. Run `scripts/detect-breaking-changes <base>`.
3. Expand verification beyond the current structured-output manifest: compare the
   public/protected API of prior and proposed JARs and run previously compiled Java
   and Kotlin consumers against proposed artifacts. Existing prior-test compilation
   and artifact-inventory checks alone do not prove complete binary compatibility.
4. Preserve request/response JSON, absent/null distinction, aliases, validation
   timing, exception diagnostics, pagination, retry/idempotency behavior, resource
   ownership and cancellation. Use focused existing tests plus boundary regression
   cases for newly affected paths. Security-sensitive work receives maintainer review.
5. Keep normal tests offline with synthetic data. Run supported runtime/artifact
   checks from `gradle/version-support.properties`. Keep large JSON/SSE regression
   probes sequential; do not shrink fixtures, raise limits, or add rejection limits.
6. Run the unchanged trusted custom-code checker. No budget increase, exclusion
   expansion, generated-manifest edits, metadata manipulation, or ownership changes
   may be used to claim a reduction. Keep the current budget unchanged in this transition. Any later decrease
   requires a separately authorized policy-only project and justified headroom.

## Execution and parallelism

The user clarified the delivery ceiling on 2026-10-19: **at most ten public Java
SDK PRs and at most ten compiler Deltas; internal generation PRs are unlimited**.
Six public SDK PRs have merged and ten compiler Deltas were opened. These are
planning counts, not platform quotas. The compiler split created excessive review
overhead. Consolidate those ten open reviews into the three existing reviews
below; do not create replacement Deltas. Internal PRs still follow normal
ownership, compatibility and promotion requirements.

The earlier micro-PR plan is superseded. Workstream IDs describe implementation
and acceptance evidence; they do not each require a PR. Use ordinary commits for
bounded testable steps, integrate related changes, and request review on complete
bundles. Additional test fixes, fact/consumer steps and inventory updates stay
within their bundle. Do not create replacement PRs to evade either ceiling.

### Public SDK allocation: six opened, four remaining

| Slot | Existing review or reserved batch | Scope |
| ---: | --- | --- |
| 1 | [Java #1234](https://github.com/openai/openai-java/pull/1234) | Merged baseline inventory and transition plan |
| 2 | [Java #1235](https://github.com/openai/openai-java/pull/1235) | Merged generated reporting-comment restoration |
| 3 | [Java #1236](https://github.com/openai/openai-java/pull/1236) | Merged supplemental JVM comparator and regressions |
| 4 | [Java #1237](https://github.com/openai/openai-java/pull/1237) | Merged credential assertion ownership cleanup |
| 5 | [Java #1238](https://github.com/openai/openai-java/pull/1238) | Merged documentation checkpoint; post-merge workflows verified successful |
| 6 | [Java #1239](https://github.com/openai/openai-java/pull/1239) | Merged as `19971184f9686ba3ccbebead8f9bf1e7e1d377c3`; handwritten expiry compatibility regressions and revised delivery plan; Conductor verified post-merge CI, examples smoke and release workflows successful |
| 7 | Reserved compatible runtime/model rollout | Batch ready client, multipart/audio and legacy-accessor/model cleanup after its compiler changes merge |
| 8 | Reserved model/structured-output rollout | Batch compatible params/helpers, embeddings, visitors, diagnostics and model fixture reuse after their compiler changes merge |
| 9 | Reserved service/helper and test-fidelity rollout | Batch Responses/agent/legacy/auth/webhook delegates, extracted handwritten streaming/pagination regressions, generated service fixtures and final inventory |
| 10 | Reserved optional policy-only completion | After trusted zero customizations and generated ownership verification, a separate `.castiron-ratchet.json`-only PR may enable zero-budget strict ownership |

These are capacity reservations, not a requirement to open four more PRs. Combine
ready batches where it reduces review cycles without delaying independent work.
Normal Castiron promotion creates or updates public candidate PRs; use that
supported workflow rather than manually attaching generated output to #1239.
No generated rollout is public before its compiler prerequisites merge.

Complete code, test and inventory changes within slots 7–9. Budget or strict-policy
changes cannot share a PR with those files: repository guidance requires the
entire policy PR to contain only `.castiron-ratchet.json`. Slot 10 preserves that
option without exceeding the public cap. Do not change policy until trusted
measurement proves zero, and do not use an additional PR outside the cap.

### Compiler consolidation: ten open reviews to three existing reviews

The ten-review split is superseded. Implementation steps belong in commits inside
coherent reviews. Prepare and verify these replacements before closing any source
review; the count remains ten open until those closures actually occur.

| Kept review | Consolidated scope | Reviews to supersede after verification |
| --- | --- | --- |
| Compiler Delta 2566856 | Shared policies, clients/telemetry, multipart/audio, Responses bridges and remaining services/auth/webhooks | 2565485, 2565512, 2568196, 2571652 |
| Compiler Delta 2572073 | Legacy accessors/raw properties/enums, embeddings/defaults, Visitor/diagnostics and remaining model/structured helpers | 2566858, 2568122, 2568148 |
| Compiler Delta 2568349 | Generated test fidelity and handwritten regression ownership | None |

Keep the original source commits and evidence. Transfer every unresolved finding,
test obligation and human review requirement into the kept review's replacement
matrix. In particular, C1's human helper-contract review and security-focused
auth, webhook and serialization reviews remain required. Superseding a review
does not resolve its feedback. Verify the exact combined source, generation
impact, old consumers and API surfaces before publishing the expanded heads.
Close the seven superseded reviews with links to their verified replacements,
then deduplicate review requests and update the root SDK review post.

Historical publication inventory (all currently open at consolidation start):

| Slot | Existing review or reserved bundle | Scope |
| ---: | --- | --- |
| 1 | Compiler Delta 2565485 | C1 client/telemetry compatibility; retain human helper-contract review |
| 2 | Compiler Delta 2565512 | C2 multipart plus integrated C3 transcription/translation dispatch and lifecycle evidence |
| 3 | Compiler Delta 2566856 | Shared typed helper/model/test ownership policies and compiler validation, including existing audio facts |
| 4 | Compiler Delta 2566858 | Ready C5 expiry accessor, raw-property lookup and enum-predicate consumers; retain the published checkpoint's scope |
| 5 | Compiler Delta 2572073 | C4 public service/parameter helpers and remaining C5 alias, accepted-value and validation contracts; address findings within this review |
| 6 | Compiler Delta 2568196 | C9 WebSocket/stream validation delegates; complete composed Chat/Responses/Agent API and frozen-runtime proof retained |
| 7 | Compiler Delta 2568122 | C6 representation, decoder/accessor and builder-default contracts |
| 8 | Compiler Delta 2568148 | C7 individual Visitor defaults and C8 existing diagnostic contracts; remaining alias/documentation work stays in the model bundle |
| 9 | Compiler Delta 2571652 | C10 agent/idempotency, C11 retained legacy/auth selection and C14 webhook entrypoints; address findings within this review |
| 10 | Compiler Delta 2568349 | C12 fixture reuse, isolated pagination ownership, deterministic streaming/server fixtures and canonical model samples |

Public SDK documentation identifies private compiler reviews by Delta number.
Shared facts land before their consumers, with explicit integration drafts proving
the combined behavior. Use separate worktrees for service, model, embedding,
visitor/diagnostic and test-fixture work; coordinate shared view/import/config
files. Review related fact and consumer commits together for contract coherence,
then publish within the three kept compiler reviews. Avoid cycles between
foundation and consumer reviews. Internal checkpoints may be created through the
standard workflow without additional public or compiler review publications.

All compiler changes must merge to compiler mainline **before** SDK output that
depends on them is promoted. After each ready compiler batch, run normal
checkpoint generation and promotion and review the complete SDK diff. Preserve
old compiled Java/Kotlin consumers, whole-artifact API checks, source and behavior
regressions, maintainer security review where applicable, normal CI and trusted
ownership accounting on the exact integrated head. Do not carry unrelated API
churn into this maintenance project.

Neither PR limit relaxes compatibility, security, ownership, approval or merge
queue gates. Preserve every public/protected and synthetic JVM contract,
JSON/default/error behavior and resource lifecycle. Keep the current budget and
exclusions unchanged. Budget-policy activation is outside the current rollout
allocation; it must not consume an unreserved eleventh public SDK PR.

Implementation and submission are authorized without routine confirmation.
Handle Conductor events on the exact head, deduplicate requests and address
feedback in place. Earlier approvals and CI do not authorize a changed candidate;
run required checks and obtain current review before protected merge. Do not poll
when an update says no polling is requested.

Success remains zero mixed generated-owned files and zero custom patch lines on
merged SDK main, repeatable generation and unchanged developer contracts. The
verified baseline and appendix are retained unchanged.

## Reproduce the baseline

Use the reporter from a trusted checkout with these exact committed revisions:

```sh
git fetch --no-tags origin caa95e12459e3cca6e85403dd3727f5eacd9a9d5
python3 scripts/castiron/custom_code_report.py report \
  --base caa95e12459e3cca6e85403dd3727f5eacd9a9d5 \
  --head caa95e12459e3cca6e85403dd3727f5eacd9a9d5 \
  --public --fetch --require-head-hash --out /tmp/java-transition-audit
```

`report.json` identifies every remaining mixed file and its added/deleted counts;
`custom-code.patch` contains the full verified patch. Count appendix physical and
nonblank lines from `git show <SDK-commit>:<path>`, not a changed working tree.
Refresh the inventory after each promoted generation, retaining this dated
baseline for comparison. Include any newly mixed file rather than silently
dropping it from a fixed allowlist.

## Per-file baseline inventory

Paths are relative to the repository root. `+` and `-` are generated-to-integrated
diff counts; patch is their sum. Workstream IDs refer to the table above.

| File | Physical lines | Nonblank lines | + | - | Patch | Workstream |
| --- | ---: | ---: | ---: | ---: | ---: | --- |
| `openai-java-core/src/main/kotlin/com/openai/client/OpenAIClientAsyncImpl.kt` | 456 | 336 | 1 | 1 | 2 | C1 |
| `openai-java-core/src/main/kotlin/com/openai/client/OpenAIClientImpl.kt` | 432 | 312 | 1 | 1 | 2 | C1 |
| `openai-java-core/src/main/kotlin/com/openai/models/admin/organization/projects/apikeys/ApiKeyUpdateParams.kt` | 606 | 504 | 17 | 7 | 24 | C5 |
| `openai-java-core/src/main/kotlin/com/openai/models/audio/AudioResponseFormat.kt` | 183 | 156 | 11 | 0 | 11 | C3 |
| `openai-java-core/src/main/kotlin/com/openai/models/beta/agents/environments/EnvironmentCreateParams.kt` | 2,341 | 1,993 | 4 | 7 | 11 | C8 |
| `openai-java-core/src/main/kotlin/com/openai/models/beta/agents/vaults/credentials/CredentialAuth.kt` | 1,514 | 1,306 | 19 | 4 | 23 | C7, C8 |
| `openai-java-core/src/main/kotlin/com/openai/models/beta/agents/vaults/credentials/CredentialAuthCreateParam.kt` | 1,761 | 1,535 | 29 | 5 | 34 | C7, C8 |
| `openai-java-core/src/main/kotlin/com/openai/models/beta/agents/vaults/credentials/CredentialAuthRotateParam.kt` | 1,343 | 1,149 | 29 | 5 | 34 | C7, C8 |
| `openai-java-core/src/main/kotlin/com/openai/models/beta/responses/BetaResponse.kt` | 11,691 | 10,186 | 2 | 3 | 5 | C5 |
| `openai-java-core/src/main/kotlin/com/openai/models/beta/responses/BetaResponseError.kt` | 1,227 | 1,041 | 10 | 2 | 12 | C5 |
| `openai-java-core/src/main/kotlin/com/openai/models/beta/responses/BetaResponseInjectEvent.kt` | 614 | 531 | 1 | 1 | 2 | C5 |
| `openai-java-core/src/main/kotlin/com/openai/models/beta/responses/BetaResponseInjectFailedEvent.kt` | 1,079 | 930 | 1 | 1 | 2 | C5 |
| `openai-java-core/src/main/kotlin/com/openai/models/beta/responses/BetaResponseStreamEvent.kt` | 3,228 | 2,793 | 2 | 0 | 2 | C7 |
| `openai-java-core/src/main/kotlin/com/openai/models/beta/responses/BetaResponseToolSearchOutputItemParam.kt` | 8,377 | 7,236 | 57 | 56 | 113 | C5, C7 |
| `openai-java-core/src/main/kotlin/com/openai/models/beta/responses/BetaResponsesServerEvent.kt` | 5,597 | 4,809 | 2 | 0 | 2 | C7 |
| `openai-java-core/src/main/kotlin/com/openai/models/chat/completions/ChatCompletionCreateParams.kt` | 9,239 | 8,046 | 42 | 57 | 99 | C4 |
| `openai-java-core/src/main/kotlin/com/openai/models/chat/completions/ChatCompletionMessageFunctionToolCall.kt` | 499 | 426 | 17 | 0 | 17 | C4 |
| `openai-java-core/src/main/kotlin/com/openai/models/chat/completions/ChatCompletionToolMessageParam.kt` | 542 | 468 | 9 | 0 | 9 | C4 |
| `openai-java-core/src/main/kotlin/com/openai/models/conversations/ConversationCreateParams.kt` | 1,260 | 1,054 | 2 | 2 | 4 | C5 |
| `openai-java-core/src/main/kotlin/com/openai/models/conversations/items/ItemCreateParams.kt` | 1,117 | 941 | 2 | 2 | 4 | C5 |
| `openai-java-core/src/main/kotlin/com/openai/models/embeddings/Embedding.kt` | 322 | 279 | 53 | 17 | 70 | C6 |
| `openai-java-core/src/main/kotlin/com/openai/models/embeddings/EmbeddingCreateParams.kt` | 1,272 | 1,079 | 2 | 1 | 3 | C6 |
| `openai-java-core/src/main/kotlin/com/openai/models/live/ResponseItemCreateEvent.kt` | 529 | 450 | 1 | 1 | 2 | C5 |
| `openai-java-core/src/main/kotlin/com/openai/models/realtime/RealtimeResponseStatus.kt` | 786 | 663 | 8 | 2 | 10 | C5 |
| `openai-java-core/src/main/kotlin/com/openai/models/responses/Response.kt` | 8,754 | 7,536 | 2 | 3 | 5 | C5 |
| `openai-java-core/src/main/kotlin/com/openai/models/responses/ResponseCreateParams.kt` | 7,953 | 6,872 | 76 | 0 | 76 | C4 |
| `openai-java-core/src/main/kotlin/com/openai/models/responses/ResponseError.kt` | 1,227 | 1,041 | 10 | 2 | 12 | C5 |
| `openai-java-core/src/main/kotlin/com/openai/models/responses/ResponseFunctionToolCall.kt` | 1,106 | 952 | 16 | 0 | 16 | C4 |
| `openai-java-core/src/main/kotlin/com/openai/models/responses/ResponseFunctionWebSearch.kt` | 1,704 | 1,452 | 22 | 22 | 44 | C5 |
| `openai-java-core/src/main/kotlin/com/openai/models/responses/ResponseInputItem.kt` | 17,901 | 15,341 | 9 | 0 | 9 | C4 |
| `openai-java-core/src/main/kotlin/com/openai/models/responses/ResponseStreamEvent.kt` | 2,773 | 2,338 | 2 | 0 | 2 | C7 |
| `openai-java-core/src/main/kotlin/com/openai/models/responses/ResponseTextConfig.kt` | 433 | 371 | 23 | 0 | 23 | C4 |
| `openai-java-core/src/main/kotlin/com/openai/models/responses/ResponseToolSearchOutputItemParam.kt` | 8,157 | 7,051 | 63 | 56 | 119 | C5, C7 |
| `openai-java-core/src/main/kotlin/com/openai/models/responses/ResponsesServerEvent.kt` | 5,119 | 4,382 | 2 | 0 | 2 | C7 |
| `openai-java-core/src/main/kotlin/com/openai/models/vectorstores/filebatches/VectorStoreFileBatch.kt` | 880 | 761 | 8 | 2 | 10 | C5 |
| `openai-java-core/src/main/kotlin/com/openai/models/videos/Video.kt` | 875 | 766 | 3 | 1 | 4 | C5 |
| `openai-java-core/src/main/kotlin/com/openai/models/videos/VideoCreateError.kt` | 1,127 | 951 | 10 | 2 | 12 | C5 |
| `openai-java-core/src/main/kotlin/com/openai/models/webhooks/UnwrapWebhookEvent.kt` | 1,485 | 1,253 | 17 | 11 | 28 | C7 |
| `openai-java-core/src/main/kotlin/com/openai/models/webhooks/WebhookEndpointWithSecret.kt` | 547 | 483 | 1 | 1 | 2 | C8 |
| `openai-java-core/src/main/kotlin/com/openai/services/async/BetaServiceAsync.kt` | 96 | 77 | 11 | 0 | 11 | C11 |
| `openai-java-core/src/main/kotlin/com/openai/services/async/BetaServiceAsyncImpl.kt` | 118 | 86 | 18 | 0 | 18 | C11 |
| `openai-java-core/src/main/kotlin/com/openai/services/async/ImageServiceAsyncImpl.kt` | 304 | 280 | 9 | 6 | 15 | C2 |
| `openai-java-core/src/main/kotlin/com/openai/services/async/ResponseServiceAsync.kt` | 584 | 498 | 65 | 0 | 65 | C4, C9 |
| `openai-java-core/src/main/kotlin/com/openai/services/async/ResponseServiceAsyncImpl.kt` | 424 | 385 | 9 | 2 | 11 | C9 |
| `openai-java-core/src/main/kotlin/com/openai/services/async/SkillServiceAsyncImpl.kt` | 306 | 274 | 3 | 2 | 5 | C2 |
| `openai-java-core/src/main/kotlin/com/openai/services/async/VideoServiceAsyncImpl.kt` | 513 | 475 | 13 | 10 | 23 | C2 |
| `openai-java-core/src/main/kotlin/com/openai/services/async/WebhookServiceAsync.kt` | 526 | 447 | 13 | 3 | 16 | C14 |
| `openai-java-core/src/main/kotlin/com/openai/services/async/WebhookServiceAsyncImpl.kt` | 400 | 364 | 6 | 2 | 8 | C14 |
| `openai-java-core/src/main/kotlin/com/openai/services/async/audio/TranscriptionServiceAsyncImpl.kt` | 158 | 143 | 10 | 5 | 15 | C3 |
| `openai-java-core/src/main/kotlin/com/openai/services/async/audio/TranslationServiceAsyncImpl.kt` | 97 | 85 | 10 | 5 | 15 | C3 |
| `openai-java-core/src/main/kotlin/com/openai/services/async/audio/VoiceServiceAsyncImpl.kt` | 92 | 80 | 3 | 2 | 5 | C2 |
| `openai-java-core/src/main/kotlin/com/openai/services/async/beta/agents/EnvironmentServiceAsyncImpl.kt` | 233 | 205 | 10 | 0 | 10 | C10 |
| `openai-java-core/src/main/kotlin/com/openai/services/async/beta/agents/SessionServiceAsync.kt` | 477 | 402 | 32 | 0 | 32 | C10 |
| `openai-java-core/src/main/kotlin/com/openai/services/async/beta/agents/SessionServiceAsyncImpl.kt` | 472 | 417 | 41 | 1 | 42 | C10 |
| `openai-java-core/src/main/kotlin/com/openai/services/async/beta/agents/sessions/TurnServiceAsync.kt` | 180 | 151 | 4 | 2 | 6 | C10 |
| `openai-java-core/src/main/kotlin/com/openai/services/async/chat/ChatCompletionServiceAsync.kt` | 471 | 410 | 48 | 0 | 48 | C4 |
| `openai-java-core/src/main/kotlin/com/openai/services/async/finetuning/checkpoints/PermissionServiceAsyncImpl.kt` | 277 | 256 | 4 | 4 | 8 | C11 |
| `openai-java-core/src/main/kotlin/com/openai/services/async/skills/VersionServiceAsyncImpl.kt` | 267 | 242 | 3 | 2 | 5 | C2 |
| `openai-java-core/src/main/kotlin/com/openai/services/blocking/BetaService.kt` | 96 | 77 | 11 | 0 | 11 | C11 |
| `openai-java-core/src/main/kotlin/com/openai/services/blocking/BetaServiceImpl.kt` | 115 | 83 | 18 | 0 | 18 | C11 |
| `openai-java-core/src/main/kotlin/com/openai/services/blocking/ResponseService.kt` | 583 | 497 | 66 | 0 | 66 | C4, C9 |
| `openai-java-core/src/main/kotlin/com/openai/services/blocking/ResponseServiceImpl.kt` | 382 | 343 | 9 | 2 | 11 | C9 |
| `openai-java-core/src/main/kotlin/com/openai/services/blocking/WebhookService.kt` | 517 | 438 | 12 | 1 | 13 | C14 |
| `openai-java-core/src/main/kotlin/com/openai/services/blocking/WebhookServiceImpl.kt` | 396 | 359 | 26 | 3 | 29 | C14 |
| `openai-java-core/src/main/kotlin/com/openai/services/blocking/audio/TranscriptionServiceImpl.kt` | 146 | 131 | 10 | 5 | 15 | C3 |
| `openai-java-core/src/main/kotlin/com/openai/services/blocking/audio/TranslationServiceImpl.kt` | 93 | 81 | 10 | 5 | 15 | C3 |
| `openai-java-core/src/main/kotlin/com/openai/services/blocking/beta/agents/EnvironmentServiceImpl.kt` | 222 | 194 | 10 | 0 | 10 | C10 |
| `openai-java-core/src/main/kotlin/com/openai/services/blocking/beta/agents/SessionService.kt` | 475 | 400 | 35 | 0 | 35 | C10 |
| `openai-java-core/src/main/kotlin/com/openai/services/blocking/beta/agents/SessionServiceImpl.kt` | 423 | 368 | 25 | 0 | 25 | C10 |
| `openai-java-core/src/main/kotlin/com/openai/services/blocking/beta/agents/sessions/TurnService.kt` | 175 | 146 | 4 | 2 | 6 | C10 |
| `openai-java-core/src/main/kotlin/com/openai/services/blocking/chat/ChatCompletionService.kt` | 465 | 404 | 48 | 0 | 48 | C4 |
| `openai-java-core/src/main/kotlin/com/openai/services/blocking/finetuning/checkpoints/PermissionServiceImpl.kt` | 262 | 241 | 4 | 4 | 8 | C11 |
| `openai-java-core/src/test/kotlin/com/openai/models/admin/organization/projects/apikeys/ApiKeyUpdateParamsTest.kt` | 55 | 44 | 1 | 1 | 2 | C5, C12 |
| `openai-java-core/src/test/kotlin/com/openai/models/beta/agents/vaults/credentials/CredentialAuthTest.kt` | 153 | 129 | 3 | 1 | 4 | C8, C12 |
| `openai-java-core/src/test/kotlin/com/openai/models/beta/responses/BetaResponseToolSearchOutputItemParamTest.kt` | 130 | 122 | 1 | 1 | 2 | C5, C12 |
| `openai-java-core/src/test/kotlin/com/openai/models/responses/ResponseTest.kt` | 501 | 494 | 1 | 235 | 236 | C12 |
| `openai-java-core/src/test/kotlin/com/openai/models/responses/ResponseToolSearchOutputItemParamTest.kt` | 114 | 106 | 1 | 1 | 2 | C5, C12 |
| `openai-java-core/src/test/kotlin/com/openai/services/async/CompletionServiceAsyncTest.kt` | 117 | 108 | 2 | 0 | 2 | C12 |
| `openai-java-core/src/test/kotlin/com/openai/services/async/ImageServiceAsyncTest.kt` | 199 | 181 | 3 | 0 | 3 | C12 |
| `openai-java-core/src/test/kotlin/com/openai/services/async/ResponseServiceAsyncTest.kt` | 438 | 414 | 3 | 0 | 3 | C12 |
| `openai-java-core/src/test/kotlin/com/openai/services/async/WebhookServiceAsyncTest.kt` | 280 | 246 | 20 | 6 | 26 | C14 |
| `openai-java-core/src/test/kotlin/com/openai/services/async/audio/TranscriptionServiceAsyncTest.kt` | 92 | 83 | 2 | 0 | 2 | C12 |
| `openai-java-core/src/test/kotlin/com/openai/services/async/beta/ThreadServiceAsyncTest.kt` | 417 | 396 | 2 | 0 | 2 | C12 |
| `openai-java-core/src/test/kotlin/com/openai/services/async/beta/agents/SessionServiceAsyncTest.kt` | 348 | 321 | 12 | 4 | 16 | C12 |
| `openai-java-core/src/test/kotlin/com/openai/services/async/beta/agents/sessions/EventServiceAsyncTest.kt` | 95 | 86 | 22 | 4 | 26 | C12 |
| `openai-java-core/src/test/kotlin/com/openai/services/async/beta/threads/RunServiceAsyncTest.kt` | 398 | 365 | 3 | 0 | 3 | C12 |
| `openai-java-core/src/test/kotlin/com/openai/services/async/chat/ChatCompletionServiceAsyncTest.kt` | 506 | 479 | 2 | 0 | 2 | C12 |
| `openai-java-core/src/test/kotlin/com/openai/services/blocking/CompletionServiceTest.kt` | 114 | 105 | 2 | 0 | 2 | C12 |
| `openai-java-core/src/test/kotlin/com/openai/services/blocking/ImageServiceTest.kt` | 192 | 174 | 3 | 0 | 3 | C12 |
| `openai-java-core/src/test/kotlin/com/openai/services/blocking/ResponseServiceTest.kt` | 428 | 405 | 3 | 0 | 3 | C12 |
| `openai-java-core/src/test/kotlin/com/openai/services/blocking/SkillServiceTest.kt` | 100 | 82 | 0 | 88 | 88 | C12 |
| `openai-java-core/src/test/kotlin/com/openai/services/blocking/WebhookServiceTest.kt` | 266 | 232 | 18 | 6 | 24 | C14 |
| `openai-java-core/src/test/kotlin/com/openai/services/blocking/audio/TranscriptionServiceTest.kt` | 89 | 80 | 2 | 0 | 2 | C12 |
| `openai-java-core/src/test/kotlin/com/openai/services/blocking/beta/ThreadServiceTest.kt` | 410 | 389 | 2 | 0 | 2 | C12 |
| `openai-java-core/src/test/kotlin/com/openai/services/blocking/beta/agents/SessionServiceTest.kt` | 335 | 308 | 11 | 4 | 15 | C12 |
| `openai-java-core/src/test/kotlin/com/openai/services/blocking/beta/agents/sessions/EventServiceTest.kt` | 89 | 81 | 21 | 4 | 25 | C12 |
| `openai-java-core/src/test/kotlin/com/openai/services/blocking/beta/threads/RunServiceTest.kt` | 383 | 350 | 3 | 0 | 3 | C12 |
| `openai-java-core/src/test/kotlin/com/openai/services/blocking/chat/ChatCompletionServiceTest.kt` | 494 | 467 | 2 | 0 | 2 | C12 |
| `scripts/castiron/custom_code_budget.py` | 737 | 692 | 1 | 1 | 2 | C13 |
