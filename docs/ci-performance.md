# CI timing investigation — 2026-10-16

Sample: the latest 20 runs of `.github/workflows/ci.yml` when this investigation started,
across pull requests, merge groups, and main pushes. GitHub job/step timestamps and
logs were retrieved with `gh run list`, the Actions jobs API, and `gh run view --log`.
This is the CI workflow, not all workflows combined.

19 runs succeeded; one failed. Successful end-to-end time (creation to final update)
had median **14m09s**, range **8m20s–18m41s**. Initial runner wait was median **4s**,
maximum **5s**. End-to-end time includes reruns; run 38835592306 was restarted, so
its 16m24s is not a single-attempt execution duration.

| Job | Median execution | Maximum | Successful samples |
| --- | ---: | ---: | ---: |
| CI / tests | 7m39s | 9m21s | 19 |
| CI / build | 5m32s | 9m44s | 20 |
| CI / API compatibility | 5m28s | 6m05s | 16 |
| CI / Jackson compatibility | 3m27s | 4m10s | 20 |
| CI / lint | 3m12s | 3m52s | 20 |
| CI / build logic | 2m07s | 2m19s | 20 |
| CI / runtime compatibility / Java 8 | 2m07s | 2m24s | 20 |
| CI / runtime compatibility / Java 25 | 2m04s | 2m39s | 20 |
| CI / version support matrix | 1m50s | 2m33s | 20 |

## Bottleneck and experiment

The build → tests chain dominates. Tests were the last non-gate job to complete
in 16/19 successful runs; API compatibility was last twice, Jackson once.
Median `Run tests` step time was 7m26s; median `Build SDK` was 4m37s.
Exact-run artifact downloads took seconds, and downstream compilation restored
from cache in the inspected latest PR and main logs.

The latest successful PR run (38879311623) spent 5m50s inside Gradle tests.
Core test output appeared at 09:28:03 UTC, while the last shrinker smoke test
appeared at 09:31:49. Main run 38879253575 spent 8m23s inside Gradle tests and
also finished with shrinkers. Gradle task banners are buffered with parallel
execution: these gaps identify the tail but are not precise per-task profiles.

Experiment: split the existing test job into SDK, ProGuard, and R8 matrix legs.
All three consume the same immutable compilation artifact. SDK tests still rerun
against Steady; both shrinker smoke tests execute explicitly on separate runners.
The required gate depends on the complete matrix, with fail-fast disabled.
No tests, payload sizes, permissions, dependency versions, or cache trust policies
are relaxed. The cost is two extra runner setups and duplicate class restoration/
shadow JAR assembly. Hosted before/after timing must establish whether this tradeoff
reduces elapsed time; no speedup is assumed from the workflow change alone.

## Sample

| Run | Event | Result | End-to-end |
| --- | --- | --- | ---: |
| [38919490403](https://github.com/openai/openai-java/actions/runs/38919490403) | pull_request | failure | 10m10s |
| [38879311623](https://github.com/openai/openai-java/actions/runs/38879311623) | pull_request | success | 15m42s |
| [38879253575](https://github.com/openai/openai-java/actions/runs/38879253575) | push | success | 18m41s |
| [38877174446](https://github.com/openai/openai-java/actions/runs/38877174446) | merge_group | success | 17m46s |
| [38873596173](https://github.com/openai/openai-java/actions/runs/38873596173) | pull_request | success | 17m03s |
| [38860243824](https://github.com/openai/openai-java/actions/runs/38860243824) | pull_request | success | 14m33s |
| [38858322789](https://github.com/openai/openai-java/actions/runs/38858322789) | pull_request | success | 11m15s |
| [38858277572](https://github.com/openai/openai-java/actions/runs/38858277572) | push | success | 10m22s |
| [38857490212](https://github.com/openai/openai-java/actions/runs/38857490212) | merge_group | success | 8m20s |
| [38845586029](https://github.com/openai/openai-java/actions/runs/38845586029) | pull_request | success | 11m18s |
| [38839800519](https://github.com/openai/openai-java/actions/runs/38839800519) | push | success | 14m11s |
| [38839458104](https://github.com/openai/openai-java/actions/runs/38839458104) | pull_request | success | 11m18s |
| [38838530219](https://github.com/openai/openai-java/actions/runs/38838530219) | merge_group | success | 14m09s |
| [38836116036](https://github.com/openai/openai-java/actions/runs/38836116036) | pull_request | success | 11m16s |
| [38835592306](https://github.com/openai/openai-java/actions/runs/38835592306) | pull_request | success | 16m24s |
| [38830750889](https://github.com/openai/openai-java/actions/runs/38830750889) | pull_request | success | 13m51s |
| [38830698565](https://github.com/openai/openai-java/actions/runs/38830698565) | push | success | 14m53s |
| [38829445349](https://github.com/openai/openai-java/actions/runs/38829445349) | merge_group | success | 12m51s |
| [38821237182](https://github.com/openai/openai-java/actions/runs/38821237182) | pull_request | success | 16m44s |
| [38813952030](https://github.com/openai/openai-java/actions/runs/38813952030) | pull_request | success | 12m51s |
