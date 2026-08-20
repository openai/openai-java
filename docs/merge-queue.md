# Merge queue rollout

The workflows are ready for a GitHub merge queue, but merging this change does not enable one or
change repository settings. Enable it separately after the checks below pass on `main` and the
SDK CODEOWNERS have approved the rollout.

## Required checks

Keep `CI / required` and add `Analyze Java and Kotlin`, both from GitHub Actions. The aggregate CI
check requires lint, the SDK build and Jackson compatibility tests, unit tests, API compatibility,
and the supported-Java runtime compatibility matrix. On both pull requests and merge groups, API
compatibility must succeed against the event's exact base commit; a skipped job must not pass the
aggregate gate. CodeQL already runs on `merge_group` and reports `Analyze Java and Kotlin`.

This matches the coverage used by the Python and Node SDKs: lint, build, tests, breaking-change
detection, and CodeQL. Java's aggregate check avoids coupling branch protection to individual
runtime-matrix entries. Preserve the existing CODEOWNER review, code-quality, code-scanning, and
linear-history rules.

## Later settings change

After merging and validating these workflows, require a merge queue on `main` and disable the
strict up-to-date-branch requirement. Match the Python and Node queue settings: squash merge,
require every queued PR to pass (`ALLGREEN`), build concurrency 5, check timeout 60 minutes, and
merge one PR at a time (minimum and maximum 1; minimum-group wait 5 minutes).

Queue one approved PR and verify that both required checks report success on the synthetic merge
group SHA before relying on the queue. If queue validation cannot complete, restore strict branch
freshness before disabling the queue. Do not remove required checks to unblock a stuck queue.
