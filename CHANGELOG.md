# Changelog

## 2.12.1 (2025-07-08)

Full Changelog: [v2.12.0...v2.12.1](https://github.com/openai/openai-java/compare/v2.12.0...v2.12.1)

### Chores

* **ci:** ensure docs generation always succeeds ([54de202](https://github.com/openai/openai-java/commit/54de202443c8dd3c112bc0521a29649f87acb7c9))

## 2.12.0 (2025-07-01)

Full Changelog: [v2.11.0...v2.12.0](https://github.com/openai/openai-java/compare/v2.11.0...v2.12.0)

### Features

* support new schema constraints for structured outputs ([#520](https://github.com/openai/openai-java/issues/520)) ([5c41ac5](https://github.com/openai/openai-java/commit/5c41ac5f1c8ed986e887e06adc3da73ec7e6b5e5))


### Bug Fixes

* **ci:** correct conditional ([a8c7a16](https://github.com/openai/openai-java/commit/a8c7a16184376d0dcfc8dd6f954c303c02888b40))
* **client:** don't close client on `withOptions` usage when original is gc'd ([e0890e3](https://github.com/openai/openai-java/commit/e0890e398aef9a8b6c14aba23b0b2a3d802ced8f))


### Chores

* **ci:** only run for pushes and fork pull requests ([8dc0179](https://github.com/openai/openai-java/commit/8dc0179eeb96772c73e035668904201a86e245c5))


### Documentation

* fix readme typoe ([#521](https://github.com/openai/openai-java/issues/521)) ([eb83a83](https://github.com/openai/openai-java/commit/eb83a83d5b32376497dbad8b74b15347a69ce1dd))


### Refactors

* **internal:** minor `ClientOptionsTest` change ([a7379a2](https://github.com/openai/openai-java/commit/a7379a239d4f93fe631224df81787fdec08d14bd))

## 2.11.0 (2025-06-27)

Full Changelog: [v2.10.0...v2.11.0](https://github.com/openai/openai-java/compare/v2.10.0...v2.11.0)

### Features

* **api:** add realtime data models ([38d8e89](https://github.com/openai/openai-java/commit/38d8e893a15a9d9c2619ed28ed83cf149a8203a8))


### Chores

* add deploymentModel ([60ffc59](https://github.com/openai/openai-java/commit/60ffc59870c76d72a75e16897146663c46c3d0c7))

## 2.10.0 (2025-06-26)

Full Changelog: [v2.9.1...v2.10.0](https://github.com/openai/openai-java/compare/v2.9.1...v2.10.0)

### Features

* **api:** webhook and deep research support ([79859a1](https://github.com/openai/openai-java/commit/79859a13346bceec6b6ebd9c32a984dcc0e7b2ed))


### Bug Fixes

* **ci:** release-doctor — report correct token name ([da7f492](https://github.com/openai/openai-java/commit/da7f492db2a39a7c025e3320bcf79fda6a0702bd))
* **client:** fix webhooks errors ([8051535](https://github.com/openai/openai-java/commit/8051535acfe621614716bc874ae73c31df121b76))


### Chores

* **api:** remove unsupported property ([2102d96](https://github.com/openai/openai-java/commit/2102d962596fb31067aa85c88515c318448e42c0))
* **client:** sync structured outputs features ([cb5c638](https://github.com/openai/openai-java/commit/cb5c638863d56577e6bae9e0787b7fc4633428cb))
* **docs:** update README to include links to docs on Webhooks ([5698e53](https://github.com/openai/openai-java/commit/5698e53e9f5666036eab58811bffc97e357d9dcb))

## 2.9.1 (2025-06-25)

Full Changelog: [v2.9.0...v2.9.1](https://github.com/openai/openai-java/compare/v2.9.0...v2.9.1)

### Chores

* **internal:** add tests for breaking change detection ([b0a6eeb](https://github.com/openai/openai-java/commit/b0a6eebc67688d38769809efaef7ebc23f519969))
* updated readme link ([c0992cd](https://github.com/openai/openai-java/commit/c0992cdf475ce4a7f5225d849affb1b449c37cf1))

## 2.9.0 (2025-06-23)

Full Changelog: [v2.8.1...v2.9.0](https://github.com/openai/openai-java/compare/v2.8.1...v2.9.0)

### Features

* **api:** make model and inputs not required to create response ([87dd646](https://github.com/openai/openai-java/commit/87dd64658da6cec7564f3b571e15ec0e2db0660b))
* **api:** update api shapes for usage and code interpreter ([c003f8d](https://github.com/openai/openai-java/commit/c003f8d34388f2a78f60dd3daae63495650c3038))


### Bug Fixes

* **client:** bump max requests per host to max requests (5 -&gt; 64) ([a36d9f6](https://github.com/openai/openai-java/commit/a36d9f647dc82f8e39591179b87a128038ce7acb))

## 2.8.1 (2025-06-18)

Full Changelog: [v2.8.0...v2.8.1](https://github.com/openai/openai-java/compare/v2.8.0...v2.8.1)

### Bug Fixes

* **client:** consider cognitiveservices.azure.com as azure ([#470](https://github.com/openai/openai-java/issues/470)) ([551bfc2](https://github.com/openai/openai-java/commit/551bfc20022d13326da79a73a4ca71fa4bfff437))

## 2.8.0 (2025-06-17)

Full Changelog: [v2.7.0...v2.8.0](https://github.com/openai/openai-java/compare/v2.7.0...v2.8.0)

### Features

* **api:** add reusable prompt IDs ([0767a2b](https://github.com/openai/openai-java/commit/0767a2b50d853feff84748fed3eb6cf544bec6fb))
* **api:** manual updates ([ec235f7](https://github.com/openai/openai-java/commit/ec235f7f311ca1866ae8a05e9a622ab588062071))
* **client:** implement per-endpoint base URL support ([c87f1af](https://github.com/openai/openai-java/commit/c87f1af80b1f3d898a5a1553be48ee87ea4e7b4f))


### Bug Fixes

* **client:** update StructuredResponse with Prompt details ([a47219b](https://github.com/openai/openai-java/commit/a47219b0247dcb4d25b3bf0f33ba6b392c61cd38))
* **internal:** run formatter ([5757aa6](https://github.com/openai/openai-java/commit/5757aa6af407d749a7bba6e1f0714eec850d4369))
* **tests:** fix required prop in test ([e820c6f](https://github.com/openai/openai-java/commit/e820c6f115ff392b567abb355f11ce5acfcab537))


### Chores

* **ci:** enable for pull requests ([9c90b16](https://github.com/openai/openai-java/commit/9c90b16585ebe3ffc031e0df598a27b5b6a85bb8))
* **internal:** codegen related update ([3597aee](https://github.com/openai/openai-java/commit/3597aee95ae1956afbe8bd62b5a6946dd62256b3))
* run formatter ([426527b](https://github.com/openai/openai-java/commit/426527b76371e7e0a66e368b0ddbb8da806fae2b))
* run formatter ([426527b](https://github.com/openai/openai-java/commit/426527b76371e7e0a66e368b0ddbb8da806fae2b))
* run formatter ([899f79c](https://github.com/openai/openai-java/commit/899f79c88b9a79ada33982af0d2ee64f96445230))

## 2.7.0 (2025-06-10)

Full Changelog: [v2.6.0...v2.7.0](https://github.com/openai/openai-java/compare/v2.6.0...v2.7.0)

### Features

* **api:** Add o3-pro model IDs ([48a685f](https://github.com/openai/openai-java/commit/48a685f51f2db7499d9e47d6641b80acb14155a8))

## 2.6.0 (2025-06-09)

Full Changelog: [v2.5.0...v2.6.0](https://github.com/openai/openai-java/compare/v2.5.0...v2.6.0)

### Features

* **api:** Add tools and structured outputs to evals ([f9d593c](https://github.com/openai/openai-java/commit/f9d593c74e08686f28e99fe2b2cb033cc506e552))

## 2.5.0 (2025-06-06)

Full Changelog: [v2.4.0...v2.5.0](https://github.com/openai/openai-java/compare/v2.4.0...v2.5.0)

### Features

* **client:** automatic schema generation and arg parsing for function calling ([#497](https://github.com/openai/openai-java/issues/497)) ([800dc8f](https://github.com/openai/openai-java/commit/800dc8fcf1e7109c419fb6125f6ad2822b6d6748))

## 2.4.0 (2025-06-03)

Full Changelog: [v2.3.2...v2.4.0](https://github.com/openai/openai-java/compare/v2.3.2...v2.4.0)

### Features

* **api:** add new realtime and audio models, realtime session options ([898d2ad](https://github.com/openai/openai-java/commit/898d2ad33f780e060dff902b755f3456ae0c12ed))


### Chores

* **internal:** minor formatting change ([f68c491](https://github.com/openai/openai-java/commit/f68c491cb41e22a25d498b18919e8e7a657d753a))

## 2.3.2 (2025-06-02)

Full Changelog: [v2.3.1...v2.3.2](https://github.com/openai/openai-java/compare/v2.3.1...v2.3.2)

### Bug Fixes

* **api:** Fix evals and code interpreter interfaces ([d7e2747](https://github.com/openai/openai-java/commit/d7e27475e917613beda0022725a1d9551ed2a278))

## 2.3.1 (2025-06-02)

Full Changelog: [v2.3.0...v2.3.1](https://github.com/openai/openai-java/compare/v2.3.0...v2.3.1)

### Bug Fixes

* **client:** `hasNextPage` impl for some classes ([32e968f](https://github.com/openai/openai-java/commit/32e968f096ec8d16ef98f8152b729a5d82daea34))

## 2.3.0 (2025-05-29)

Full Changelog: [v2.2.1...v2.3.0](https://github.com/openai/openai-java/compare/v2.2.1...v2.3.0)

### Features

* **api:** Config update for pakrym-stream-param ([55ae767](https://github.com/openai/openai-java/commit/55ae767021a1d03a2c8bc4184163acd56ee64d41))


### Bug Fixes

* **client:** add missing deployment model param ([#704](https://github.com/openai/openai-java/issues/704)) ([37aa563](https://github.com/openai/openai-java/commit/37aa563789f34de917758519d859f17d9c1a98fc))
* **client:** correctly send streaming discriminator param ([b27559f](https://github.com/openai/openai-java/commit/b27559fa7d1c097ada40da12e55d1def372f5dce))
* **client:** optional image deployment model param ([a507f84](https://github.com/openai/openai-java/commit/a507f8446a2270ee3e9c5e5295a9a57b59c633eb))
* **client:** remove `@MustBeClosed` for future returning methods ([2988157](https://github.com/openai/openai-java/commit/2988157933dfe2ec7f9f2b626d0fa9eb184db27d))
* **client:** return binary content from `get /containers/{container_id}/files/{file_id}/content` ([787e12b](https://github.com/openai/openai-java/commit/787e12b4ac3d33f46aa31c165241c26f927e92dc))

## 2.2.1 (2025-05-27)

Full Changelog: [v2.2.0...v2.2.1](https://github.com/openai/openai-java/compare/v2.2.0...v2.2.1)

### Bug Fixes

* **client:** don't throw on absent error message ([0d1e325](https://github.com/openai/openai-java/commit/0d1e325ee02af89f713db9cc7fb360676d942d6d))

## 2.2.0 (2025-05-23)

Full Changelog: [v2.1.0...v2.2.0](https://github.com/openai/openai-java/compare/v2.1.0...v2.2.0)

### Features

* **api:** remove deprecated endpoints from Java client ([7b5acb5](https://github.com/openai/openai-java/commit/7b5acb54d52352521e86e7e0f6f878ca67a7b53e))


### Bug Fixes

* **examples:** remove old examples ([8fe838c](https://github.com/openai/openai-java/commit/8fe838cdade6fb04aba70ae82bab0e81d061ca43))


### Chores

* **internal:** fix release workflows ([c66f725](https://github.com/openai/openai-java/commit/c66f7258d8df4000b1013aa35140bef50de852fe))

## 2.1.0 (2025-05-22)

Full Changelog: [v2.0.0...v2.1.0](https://github.com/openai/openai-java/compare/v2.0.0...v2.1.0)

### Features

* **api:** new streaming helpers for background responses ([a82279d](https://github.com/openai/openai-java/commit/a82279dfafef8a6a6276de104a5b58cffac63559))


### Bug Fixes

* **internal:** fix issues with new items in structured responses ([931f7b8](https://github.com/openai/openai-java/commit/931f7b8ce3a83dfbbbd46d34bf99a66fa7e888e3))
* **tests:** fix file test ([a82adfd](https://github.com/openai/openai-java/commit/a82adfd42bbb06da2c3c18f12cafd6b8ee38cc85))

## 2.0.0 (2025-05-21)

Full Changelog: [v1.6.1...v2.0.0](https://github.com/openai/openai-java/compare/v1.6.1...v2.0.0)

### ⚠ BREAKING CHANGES

* **client:** change precision of some numeric types
* **client:** extract auto pagination to shared classes
* **client:** **Migration:** - If you were referencing the `AutoPager` class on a specific `*Page` or `*PageAsync` type, then you should instead reference the shared `AutoPager` and `AutoPagerAsync` types, under the `core` package
    - `AutoPagerAsync` now has different usage. You can call `.subscribe(...)` on the returned object instead to get called back each page item. You can also call `onCompleteFuture()` to get a future that completes when all items have been processed. Finally, you can call `.close()` on the returned object to stop auto-paginating early
    - If you were referencing `getNextPage` or `getNextPageParams`:
       - Swap to `nextPage()` and `nextPageParams()`
       - Note that these both now return non-optional types (use `hasNextPage()` before calling these, since they will throw if it's impossible to get another page)

### Features

* **api:** Add reinforcement fine-tuning api support ([3a9fcbb](https://github.com/openai/openai-java/commit/3a9fcbb2d47a6b106d963a4243c255d55123ff9c))
* **api:** further updates for evals API ([2b9d5bc](https://github.com/openai/openai-java/commit/2b9d5bc92d4e67cfc5b48343bd999ccbe87ca2e7))
* **api:** manual updates ([005a643](https://github.com/openai/openai-java/commit/005a6439977311990dca20e75783657e90aa3898))
* **api:** responses x eval api ([66327c5](https://github.com/openai/openai-java/commit/66327c540652f63147158fc9ae8ffdd5e75cbca4))
* **api:** Updating Assistants and Evals API schemas ([02c6df6](https://github.com/openai/openai-java/commit/02c6df6457c3e03a8ae87d8b895a4838809947f3))
* **client:** allow providing some params positionally ([1c6e875](https://github.com/openai/openai-java/commit/1c6e8759bf7e6b8a7e3b245c5a2365edf2388fca))
* **client:** extract auto pagination to shared classes ([855d571](https://github.com/openai/openai-java/commit/855d571da1cc772b31493f6a36032934772c3757))
* **client:** type safe structured outputs ([#463](https://github.com/openai/openai-java/issues/463)) ([e123fdd](https://github.com/openai/openai-java/commit/e123fdd3f75980b7edea84eaf6f6c101cb9a2ea2))


### Bug Fixes

* add missing `deploymentModel` params ([d9af1fb](https://github.com/openai/openai-java/commit/d9af1fbe5309ae7da0522895596573fc36162387))
* **client:** properly support srt and vtt in audio transcriptions. ([#472](https://github.com/openai/openai-java/issues/472)) ([1e5bf3d](https://github.com/openai/openai-java/commit/1e5bf3d36cb100d1b1ad8ac328b99cc50d16e4da))
* merge conflict ([bf7e961](https://github.com/openai/openai-java/commit/bf7e961819911f28f5ad0aaa03cda05ccfa5dbed))
* missing validity ([301a38a](https://github.com/openai/openai-java/commit/301a38adfa5782238e407f9ea22dd9635baa4e4b))


### Chores

* **docs:** grammar improvements ([13b0fbc](https://github.com/openai/openai-java/commit/13b0fbc79ec365433ac33ccd7c5fef3e9b858fae))
* **internal:** fix custom code ([567c86e](https://github.com/openai/openai-java/commit/567c86e958acf5898ee0be7547cfa0da34f07eb2))


### Documentation

* remove or fix invalid readme examples ([fa9f7fc](https://github.com/openai/openai-java/commit/fa9f7fc1e68b8754a50373c455cad45f59b9bda3))


### Refactors

* **client:** change precision of some numeric types ([291b0f4](https://github.com/openai/openai-java/commit/291b0f4ac12f61f31c40a80a46db2cffc9012a9a))

## 1.6.1 (2025-05-08)

Full Changelog: [v1.6.0...v1.6.1](https://github.com/openai/openai-java/compare/v1.6.0...v1.6.1)

### Chores

* **internal:** remove flaky `-Xbackend-threads=0` option ([1aec858](https://github.com/openai/openai-java/commit/1aec858db61e87065fa5d3f7fba94f601f71b3ac))

## 1.6.0 (2025-05-02)

Full Changelog: [v1.5.1...v1.6.0](https://github.com/openai/openai-java/compare/v1.5.1...v1.6.0)

### Features

* **api:** add image sizes, reasoning encryption ([a4a7d53](https://github.com/openai/openai-java/commit/a4a7d5390245ba11afe1cbd8665e0e39af3ca16f))


### Chores

* **internal:** update java toolchain ([eef415d](https://github.com/openai/openai-java/commit/eef415d067c9dd6ac6d4b8c825f4d068a6c4a63c))


### Documentation

* add `ImageGenerationExample` ([#457](https://github.com/openai/openai-java/issues/457)) ([286b7d5](https://github.com/openai/openai-java/commit/286b7d52d8cb917130579352a89afd5f8c839894))

## 1.5.1 (2025-04-27)

Full Changelog: [v1.5.0...v1.5.1](https://github.com/openai/openai-java/compare/v1.5.0...v1.5.1)

### Bug Fixes

* **client:** add missing convenience methods ([616d69a](https://github.com/openai/openai-java/commit/616d69a27a914e30d6cb2c4fa96613bf64488742))


### Chores

* **ci:** only use depot for staging repos ([7835140](https://github.com/openai/openai-java/commit/78351404be50f6e535028a98d14d64257eeb2002))
* **ci:** run on more branches and use depot runners ([8b7a805](https://github.com/openai/openai-java/commit/8b7a805083123a222ebc623e4c405d2f1ccf228b))
* **internal:** java 17 -&gt; 21 on ci ([9f690e4](https://github.com/openai/openai-java/commit/9f690e42c91642bcda690bd398803ba401958397))
* **internal:** use `byteInputStream()` in tests ([616d69a](https://github.com/openai/openai-java/commit/616d69a27a914e30d6cb2c4fa96613bf64488742))
* run formatter ([5e78fa5](https://github.com/openai/openai-java/commit/5e78fa544ddc7942795bf5055c2010f9b42b198e))


### Documentation

* add responses input file example ([#446](https://github.com/openai/openai-java/issues/446)) ([b94d404](https://github.com/openai/openai-java/commit/b94d4044ba764de789af3d19ac406ad8667c029d))

## 1.5.0 (2025-04-23)

Full Changelog: [v1.4.1...v1.5.0](https://github.com/openai/openai-java/compare/v1.4.1...v1.5.0)

### Features

* **api:** adding new image model support ([545b900](https://github.com/openai/openai-java/commit/545b9004c09de82f1aa1ee12333d5fa7bb67ecd5))


### Chores

* **ci:** add timeout thresholds for CI jobs ([579da9b](https://github.com/openai/openai-java/commit/579da9b321ee3a6360c0c7aca39fb4ffbd12fc3b))

## 1.4.1 (2025-04-17)

Full Changelog: [v1.4.0...v1.4.1](https://github.com/openai/openai-java/compare/v1.4.0...v1.4.1)

### Bug Fixes

* **internal:** release flow ([777a756](https://github.com/openai/openai-java/commit/777a7565f14d86c00611880ee143b522a9af2698))
* **internal:** test compilation error ([544a4ce](https://github.com/openai/openai-java/commit/544a4cebb5b34a55354e06431dd4a966a5213aa2))

## 1.4.0 (2025-04-17)

Full Changelog: [v1.3.1...v1.4.0](https://github.com/openai/openai-java/compare/v1.3.1...v1.4.0)

### Features

* **api:** add o3 and o4-mini model IDs ([069db4f](https://github.com/openai/openai-java/commit/069db4f94021cfc2f8d3a5a969453efae5f126a1))


### Performance Improvements

* **internal:** improve compilation+test speed ([ef38b5b](https://github.com/openai/openai-java/commit/ef38b5bfd278774e056d21a795845fb5c3a99f0a))


### Documentation

* explain http client customization ([da22f7d](https://github.com/openai/openai-java/commit/da22f7d3f717882c555fbb6626ec842fc953def4))
* explain jackson compat in readme ([6bc1dbd](https://github.com/openai/openai-java/commit/6bc1dbd2d95d2fb235bb9506a766b9f083017bc2))

## 1.3.1 (2025-04-16)

Full Changelog: [v1.3.0...v1.3.1](https://github.com/openai/openai-java/compare/v1.3.0...v1.3.1)

### Documentation

* **client:** update jackson compat error message ([e928c2d](https://github.com/openai/openai-java/commit/e928c2d9d607a40d363297e2b675a3ffc48a3cea))
* update documentation links to be more uniform ([e9bb6bf](https://github.com/openai/openai-java/commit/e9bb6bf7b8f42e1bed10d6029d957b06a0c149e5))

## 1.3.0 (2025-04-14)

Full Changelog: [v1.2.0...v1.3.0](https://github.com/openai/openai-java/compare/v1.2.0...v1.3.0)

### Features

* **api:** adding gpt-4.1 family of model IDs ([cdddc6a](https://github.com/openai/openai-java/commit/cdddc6a4b7447a75983cd4eede5759f2594a4a59))


### Chores

* **internal:** reduce CI branch coverage ([ac1f4e9](https://github.com/openai/openai-java/commit/ac1f4e909381ac8d93256b90417d119d062c87c4))

## 1.2.0 (2025-04-09)

Full Changelog: [v1.1.1...v1.2.0](https://github.com/openai/openai-java/compare/v1.1.1...v1.2.0)

### Features

* **client:** make pagination robust to missing data ([cbccde5](https://github.com/openai/openai-java/commit/cbccde5bbbea40289a7143d40ce5e8c7ac7643ff))


### Documentation

* add comments for page methods ([cbccde5](https://github.com/openai/openai-java/commit/cbccde5bbbea40289a7143d40ce5e8c7ac7643ff))


### Refactors

* **client:** deduplicate page response classes ([#433](https://github.com/openai/openai-java/issues/433)) ([cbccde5](https://github.com/openai/openai-java/commit/cbccde5bbbea40289a7143d40ce5e8c7ac7643ff))
* **client:** migrate pages to builder pattern ([#435](https://github.com/openai/openai-java/issues/435)) ([8cb8878](https://github.com/openai/openai-java/commit/8cb8878becd07e31844f981bafd147c630606c07))

## 1.1.1 (2025-04-09)

Full Changelog: [v1.1.0...v1.1.1](https://github.com/openai/openai-java/compare/v1.1.0...v1.1.1)

### Bug Fixes

* **client:** bump to better jackson version ([#432](https://github.com/openai/openai-java/issues/432)) ([b4ec1d1](https://github.com/openai/openai-java/commit/b4ec1d17e9cace4971d330b945925a299a04aa38))


### Chores

* **internal:** expand CI branch coverage ([#429](https://github.com/openai/openai-java/issues/429)) ([7ecece7](https://github.com/openai/openai-java/commit/7ecece7d4cd6ed495ca4fd2daa1f7d726954695a))

## 1.1.0 (2025-04-09)

Full Changelog: [v1.0.0...v1.1.0](https://github.com/openai/openai-java/compare/v1.0.0...v1.1.0)

### Features

* **client:** support setting base URL via env var ([#427](https://github.com/openai/openai-java/issues/427)) ([d462b34](https://github.com/openai/openai-java/commit/d462b3476e032ea02fa45c4afde19e1b62455224))

## 1.0.0 (2025-04-09)

Full Changelog: [v0.45.0...v1.0.0](https://github.com/openai/openai-java/compare/v0.45.0...v1.0.0)

### Chores

* workaround build errors ([6c6faa0](https://github.com/openai/openai-java/commit/6c6faa0e8273f10ed9d85378f4cb9d2ef8fc360c))


### Documentation

* remove beta readme note ([829fb0a](https://github.com/openai/openai-java/commit/829fb0a8a307659e00defc3a6c39e72b7cf4dab7))

## 0.45.0 (2025-04-09)

Full Changelog: [v0.44.5...v0.45.0](https://github.com/openai/openai-java/compare/v0.44.5...v0.45.0)

### Features

* **api:** Add evalapi to sdk ([b567998](https://github.com/openai/openai-java/commit/b56799843d71a81b8d99fae6fb04c0dff731afce))


### Bug Fixes

* **client:** trim '/' and empty character in base URL ([#424](https://github.com/openai/openai-java/issues/424)) ([37370df](https://github.com/openai/openai-java/commit/37370df673921c01a511dab2f87e0fe62107a151))


### Chores

* add missing `deploymentModel` ([acb132e](https://github.com/openai/openai-java/commit/acb132e45467fd74f5860c54d93a66ad8e1216a3))
* **tests:** improve enum examples ([#416](https://github.com/openai/openai-java/issues/416)) ([a698758](https://github.com/openai/openai-java/commit/a69875817d67a60a612df14bf3ea06352e2fa265))

## 0.44.5 (2025-04-08)

Full Changelog: [v0.44.4...v0.44.5](https://github.com/openai/openai-java/compare/v0.44.4...v0.44.5)

### Bug Fixes

* **client:** fix some bad identifiers ([#413](https://github.com/openai/openai-java/issues/413)) ([e567213](https://github.com/openai/openai-java/commit/e56721365c94ae68daf307f49eeb00e151f67c94))

## 0.44.4 (2025-04-07)

Full Changelog: [v0.44.3...v0.44.4](https://github.com/openai/openai-java/compare/v0.44.3...v0.44.4)

### Chores

* **internal:** only run examples workflow in main repo ([#410](https://github.com/openai/openai-java/issues/410)) ([058008a](https://github.com/openai/openai-java/commit/058008a7901d476097bb93171c38924880024a25))

## 0.44.3 (2025-04-06)

Full Changelog: [v0.44.2...v0.44.3](https://github.com/openai/openai-java/compare/v0.44.2...v0.44.3)

### Bug Fixes

* **client:** return `Optional&lt;T&gt;` instead of `Optional<? extends T>` ([#407](https://github.com/openai/openai-java/issues/407)) ([73eee4f](https://github.com/openai/openai-java/commit/73eee4fcf4859a48bb16c02dbcbc46adb9c691b1))


### Chores

* **internal:** add more `streamHandler` tests ([#404](https://github.com/openai/openai-java/issues/404)) ([a29b341](https://github.com/openai/openai-java/commit/a29b341b228c8cb28c9cfc18521a15697ee18649))
* **internal:** swap from `getNullable` to `getOptional` ([#406](https://github.com/openai/openai-java/issues/406)) ([32b54f9](https://github.com/openai/openai-java/commit/32b54f95a356922fa0b3f1c5bddfefab19dde7a7))


### Documentation

* add comments to `JsonField` classes ([73eee4f](https://github.com/openai/openai-java/commit/73eee4fcf4859a48bb16c02dbcbc46adb9c691b1))
* document how to forcibly omit required field ([a51c184](https://github.com/openai/openai-java/commit/a51c1840dd41682a4f9e7025058e0b6a1b8e7205))
* swap examples used in readme ([#408](https://github.com/openai/openai-java/issues/408)) ([a51c184](https://github.com/openai/openai-java/commit/a51c1840dd41682a4f9e7025058e0b6a1b8e7205))

## 0.44.2 (2025-04-04)

Full Changelog: [v0.44.1...v0.44.2](https://github.com/openai/openai-java/compare/v0.44.1...v0.44.2)

### Bug Fixes

* **client:** support responses API for Azure ([#387](https://github.com/openai/openai-java/issues/387)) ([f7f09aa](https://github.com/openai/openai-java/commit/f7f09aa1a3dd77f5565083ece85f8056b53e2e54))

## 0.44.1 (2025-04-04)

Full Changelog: [v0.44.0...v0.44.1](https://github.com/openai/openai-java/compare/v0.44.0...v0.44.1)

### Bug Fixes

* **client:** accumulation of tool call functions ([#382](https://github.com/openai/openai-java/issues/382)) ([#399](https://github.com/openai/openai-java/issues/399)) ([943e6fb](https://github.com/openai/openai-java/commit/943e6fbd65a5f318ebbb7895bdd8c68f6d8babe4))

## 0.44.0 (2025-04-04)

Full Changelog: [v0.43.0...v0.44.0](https://github.com/openai/openai-java/compare/v0.43.0...v0.44.0)

### Features

* **api:** manual updates ([331ec66](https://github.com/openai/openai-java/commit/331ec66baf6add46ec79ba56842f31065dffff33))


### Bug Fixes

* **client:** translate streaming `IOException` into custom exception ([#397](https://github.com/openai/openai-java/issues/397)) ([bc5c577](https://github.com/openai/openai-java/commit/bc5c57721fd7115800d7a9fd2e38631e695caa25))


### Performance Improvements

* **client:** cached parsed type in `HttpResponseFor` ([#395](https://github.com/openai/openai-java/issues/395)) ([259b75a](https://github.com/openai/openai-java/commit/259b75a9e3a3f6de2e123b171bd739facdecd819))

## 0.43.0 (2025-04-02)

Full Changelog: [v0.42.0...v0.43.0](https://github.com/openai/openai-java/compare/v0.42.0...v0.43.0)

### Features

* **api:** manual updates ([9679525](https://github.com/openai/openai-java/commit/967952553d5fd2e7f47cd7c82fac45cc9dcef43e))
* **client:** expose request body setter and getter ([#392](https://github.com/openai/openai-java/issues/392)) ([eaa0bc9](https://github.com/openai/openai-java/commit/eaa0bc96ba8898e064709a571e97d6b99f478597))


### Chores

* **internal:** codegen related update ([#389](https://github.com/openai/openai-java/issues/389)) ([b0e9d31](https://github.com/openai/openai-java/commit/b0e9d316bde7866f0d6c9381a5bec5a6667f46f6))

## 0.42.0 (2025-04-02)

Full Changelog: [v0.41.1...v0.42.0](https://github.com/openai/openai-java/compare/v0.41.1...v0.42.0)

### Features

* **api:** manual updates ([0440105](https://github.com/openai/openai-java/commit/0440105162ce52cd187ce8ab8d5d1dc20682a4ed))
* **client:** add enum validation method ([a641218](https://github.com/openai/openai-java/commit/a6412183ccea1ac3e9105793372693d5ec8c6d72))
* **client:** make union deserialization more robust ([#385](https://github.com/openai/openai-java/issues/385)) ([a641218](https://github.com/openai/openai-java/commit/a6412183ccea1ac3e9105793372693d5ec8c6d72))


### Chores

* **client:** remove unnecessary json state from some query param classes ([a641218](https://github.com/openai/openai-java/commit/a6412183ccea1ac3e9105793372693d5ec8c6d72))
* **internal:** add invalid json deserialization tests ([a641218](https://github.com/openai/openai-java/commit/a6412183ccea1ac3e9105793372693d5ec8c6d72))
* **internal:** add json roundtripping tests ([a641218](https://github.com/openai/openai-java/commit/a6412183ccea1ac3e9105793372693d5ec8c6d72))

## 0.41.1 (2025-04-01)

Full Changelog: [v0.41.0...v0.41.1](https://github.com/openai/openai-java/compare/v0.41.0...v0.41.1)

### Chores

* Remove deprecated/unused remote spec feature ([4d3b56e](https://github.com/openai/openai-java/commit/4d3b56eb9f0e9f180c1304b66c3b8fe2e999e75f))

## 0.41.0 (2025-03-31)

Full Changelog: [v0.40.1...v0.41.0](https://github.com/openai/openai-java/compare/v0.40.1...v0.41.0)

### Features

* **client:** improve some method names ([#379](https://github.com/openai/openai-java/issues/379)) ([895f99a](https://github.com/openai/openai-java/commit/895f99acaee6f8e38165c72da1de18e3d7682321))


### Bug Fixes

* **client:** limit json deserialization coercion ([#377](https://github.com/openai/openai-java/issues/377)) ([5234cf9](https://github.com/openai/openai-java/commit/5234cf94a540191ae051e3123b7d1be088655100))

## 0.40.1 (2025-03-28)

Full Changelog: [v0.40.0...v0.40.1](https://github.com/openai/openai-java/compare/v0.40.0...v0.40.1)

### Bug Fixes

* **client:** don't call `validate()` during deserialization if we don't have to ([#372](https://github.com/openai/openai-java/issues/372)) ([1dae9bf](https://github.com/openai/openai-java/commit/1dae9bfe33d1cdd78bf47d47c62c1db0c4e5ca53))


### Documentation

* add comment on response header methods ([#374](https://github.com/openai/openai-java/issues/374)) ([80bba20](https://github.com/openai/openai-java/commit/80bba200247fa7620cbd63a44f452c2ad3d83a87))
* document request IDs ([3e2fec3](https://github.com/openai/openai-java/commit/3e2fec36597a15ab56960f4f40096dc779013cca))

## 0.40.0 (2025-03-27)

Full Changelog: [v0.39.0...v0.40.0](https://github.com/openai/openai-java/compare/v0.39.0...v0.40.0)

### Features

* **api:** add `get /responses/{response_id}/input_items` endpoint ([#367](https://github.com/openai/openai-java/issues/367)) ([c569175](https://github.com/openai/openai-java/commit/c569175e0427273707d0bee2535da0bf616e9b7c))
* **client:** add new responses endpoint ([#369](https://github.com/openai/openai-java/issues/369)) ([f15b5ee](https://github.com/openai/openai-java/commit/f15b5eeb2bab3534daa41b56c2f7b05cd5791c97))


### Bug Fixes

* deploymentModel arg ([139c062](https://github.com/openai/openai-java/commit/139c06287a82a80a06968b0b8826d9c2c5116dde))

## 0.39.0 (2025-03-27)

Full Changelog: [v0.38.0...v0.39.0](https://github.com/openai/openai-java/compare/v0.38.0...v0.39.0)

### Features

* **api:** add `get /chat/completions` endpoint ([#364](https://github.com/openai/openai-java/issues/364)) ([8591689](https://github.com/openai/openai-java/commit/85916892043caeb1cca862d18820aaaae0788514))


### Bug Fixes

* add missing `deploymentModel` ([40c568f](https://github.com/openai/openai-java/commit/40c568f3113553c91ab85d911b5340aa28e41a91))

## 0.38.0 (2025-03-27)

Full Changelog: [v0.37.0...v0.38.0](https://github.com/openai/openai-java/compare/v0.37.0...v0.38.0)

### Features

* **client:** add chat completion streaming helper ([#354](https://github.com/openai/openai-java/issues/354)) ([561c085](https://github.com/openai/openai-java/commit/561c0853b8a06814dba873e942629dff050b325d))


### Bug Fixes

* **client:** map deserialization bug ([caa79a2](https://github.com/openai/openai-java/commit/caa79a267a79845eee3a49b22bcbe66849d9cf4e))


### Chores

* add hash of OpenAPI spec/config inputs to .stats.yml ([d27646c](https://github.com/openai/openai-java/commit/d27646c179082f6bcba9b5df6b333134968adc95))
* **api:** updates to supported Voice IDs ([#361](https://github.com/openai/openai-java/issues/361)) ([fd0d45a](https://github.com/openai/openai-java/commit/fd0d45a6f74e6571f1553231a69621db5720580f))
* **internal:** delete unused methods and annotations ([#362](https://github.com/openai/openai-java/issues/362)) ([caa79a2](https://github.com/openai/openai-java/commit/caa79a267a79845eee3a49b22bcbe66849d9cf4e))

## 0.37.0 (2025-03-25)

Full Changelog: [v0.36.0...v0.37.0](https://github.com/openai/openai-java/compare/v0.36.0...v0.37.0)

### Features

* **client:** support a lower jackson version ([#357](https://github.com/openai/openai-java/issues/357)) ([13a3c67](https://github.com/openai/openai-java/commit/13a3c672ef093f4a0e9110ce716086f4a3ea4329))
* **client:** throw on incompatible jackson version ([13a3c67](https://github.com/openai/openai-java/commit/13a3c672ef093f4a0e9110ce716086f4a3ea4329))


### Chores

* **internal:** fix example formatting ([#348](https://github.com/openai/openai-java/issues/348)) ([44a7df9](https://github.com/openai/openai-java/commit/44a7df9af13ab14947fd50b37a7d26b1d9c5d0df))
* **internal:** remove unnecessary import ([#349](https://github.com/openai/openai-java/issues/349)) ([661a906](https://github.com/openai/openai-java/commit/661a9060183a645b9ec7f9687fa0786adb224283))


### Documentation

* minor readme tweak ([#351](https://github.com/openai/openai-java/issues/351)) ([28a1116](https://github.com/openai/openai-java/commit/28a111615345011335e73f2894f1f54672493cdf))
* responses image url example ([d84abd4](https://github.com/openai/openai-java/commit/d84abd426d220b1c248bc31cf9f47dfeb9e25509))
* update readme exception docs ([#350](https://github.com/openai/openai-java/issues/350)) ([b441223](https://github.com/openai/openai-java/commit/b441223dc8c26d7fc023614f6b15610b8f7af35d))

## 0.36.0 (2025-03-21)

Full Changelog: [v0.35.1...v0.36.0](https://github.com/openai/openai-java/compare/v0.35.1...v0.36.0)

### ⚠ BREAKING CHANGES

* **client:** refactor exception structure and methods ([#336](https://github.com/openai/openai-java/issues/336))

### Features

* **api:** new models for TTS, STT, + new audio features for Realtime ([#340](https://github.com/openai/openai-java/issues/340)) ([630d63c](https://github.com/openai/openai-java/commit/630d63c5751dee259e2263e57deed3780e363234))
* **api:** o1-pro now available through the API ([#337](https://github.com/openai/openai-java/issues/337)) ([93a7949](https://github.com/openai/openai-java/commit/93a79492bb960cbf0691a4139cf9acadafb8a7a2))


### Bug Fixes

* add missing deployment models ([0f5c072](https://github.com/openai/openai-java/commit/0f5c0727d9507c2103cd3c0fcfffd1032219448a))
* **client:** compilation error in adding streaming discriminator ([#342](https://github.com/openai/openai-java/issues/342)) ([f26276e](https://github.com/openai/openai-java/commit/f26276eb97cf36dad03c6782ad8f1bb5f5434384))
* **client:** remove duplicate types ([#341](https://github.com/openai/openai-java/issues/341)) ([e6b3e76](https://github.com/openai/openai-java/commit/e6b3e766b5e10117adae557e162b9daa3cf0a50f))


### Chores

* **client:** refactor exception structure and methods ([#336](https://github.com/openai/openai-java/issues/336)) ([552fcf2](https://github.com/openai/openai-java/commit/552fcf26b56912c6322319de0673d13c2885ae4d))
* **internal:** add missing release please block ([#335](https://github.com/openai/openai-java/issues/335)) ([3312a39](https://github.com/openai/openai-java/commit/3312a3945e4c34b4073b7c5a0735a61baf22f8af))
* **internal:** make multipart assertions more robust ([badd931](https://github.com/openai/openai-java/commit/badd931f4b959905ca81c816cf91e030c56ea842))
* **internal:** remove unnecessary `assertNotNull` calls ([badd931](https://github.com/openai/openai-java/commit/badd931f4b959905ca81c816cf91e030c56ea842))
* **internal:** version bump ([#333](https://github.com/openai/openai-java/issues/333)) ([7f09373](https://github.com/openai/openai-java/commit/7f0937367f01b10ee0eaa18e66c238b484b80608))


### Documentation

* refine comments on multipart params ([#343](https://github.com/openai/openai-java/issues/343)) ([badd931](https://github.com/openai/openai-java/commit/badd931f4b959905ca81c816cf91e030c56ea842))

## 0.35.1 (2025-03-18)

Full Changelog: [v0.35.0...v0.35.1](https://github.com/openai/openai-java/compare/v0.35.0...v0.35.1)

### Bug Fixes

* **api:** correct some Responses types ([#328](https://github.com/openai/openai-java/issues/328)) ([efc79c0](https://github.com/openai/openai-java/commit/efc79c002003f3beaf74c2c3d13aada6235481e2))
* **client:** support kotlin 1.8 runtime ([#330](https://github.com/openai/openai-java/issues/330)) ([5179a4e](https://github.com/openai/openai-java/commit/5179a4e4ea67797477cfdb9141e6d39eab9abd6a))
* **types:** improve responses type names ([#332](https://github.com/openai/openai-java/issues/332)) ([517c500](https://github.com/openai/openai-java/commit/517c500d74e7d8c0f340b2607a574d8096390877))


### Chores

* **internal:** add back release workflow ([7893465](https://github.com/openai/openai-java/commit/7893465dbd929e290a2e46dfc877c3ef8a889056))
* **internal:** codegen related update ([#327](https://github.com/openai/openai-java/issues/327)) ([7030355](https://github.com/openai/openai-java/commit/7030355dc8e511647e7a6221143ca94426ac24bf))
* **internal:** refactor enum query param serialization ([#331](https://github.com/openai/openai-java/issues/331)) ([c5ef44d](https://github.com/openai/openai-java/commit/c5ef44dbf1c894f63bf213db391d09f5a800f825))


### Documentation

* responses conversation example ([fde5110](https://github.com/openai/openai-java/commit/fde5110a014a73e6e5e98fdb49e82506f04c4463))
* show function calling conversation ([#227](https://github.com/openai/openai-java/issues/227)) ([ff7905a](https://github.com/openai/openai-java/commit/ff7905a22b217b370452e7a978b9153ae7487ebd))

## 0.35.0 (2025-03-18)

Full Changelog: [v0.34.1...v0.35.0](https://github.com/openai/openai-java/compare/v0.34.1...v0.35.0)

### Features

* **client:** don't require params for some service methods ([#325](https://github.com/openai/openai-java/issues/325)) ([3ed7cf8](https://github.com/openai/openai-java/commit/3ed7cf88c11b95003b5962f94f848af3511f0525))


### Chores

* **internal:** add generated comment ([#318](https://github.com/openai/openai-java/issues/318)) ([44a46b5](https://github.com/openai/openai-java/commit/44a46b5e6651a3cf38f4b5321020a9fa52c5976c))
* **internal:** add some tests for union classes ([#326](https://github.com/openai/openai-java/issues/326)) ([bd92f57](https://github.com/openai/openai-java/commit/bd92f577231430115d4976a3f4740ef8f09baa07))
* **internal:** delete duplicate tests ([f95f8bc](https://github.com/openai/openai-java/commit/f95f8bc083cebbfeef127b62d8c5dbaffa2083ed))
* **internal:** generate more tests ([a05b899](https://github.com/openai/openai-java/commit/a05b899d056538f47a238cac0e6357ce2688861a))
* **internal:** make test classes internal ([#317](https://github.com/openai/openai-java/issues/317)) ([f9a25b4](https://github.com/openai/openai-java/commit/f9a25b4be4daa5184b9d19896f4e2009285759be))
* **internal:** refactor query param serialization impl and tests ([#322](https://github.com/openai/openai-java/issues/322)) ([93558fc](https://github.com/openai/openai-java/commit/93558fcecc463b7d6a4f976c2a7889b1c691dc52))
* **internal:** refactor some test assertions ([f95f8bc](https://github.com/openai/openai-java/commit/f95f8bc083cebbfeef127b62d8c5dbaffa2083ed))
* **internal:** reformat some tests ([#324](https://github.com/openai/openai-java/issues/324)) ([a05b899](https://github.com/openai/openai-java/commit/a05b899d056538f47a238cac0e6357ce2688861a))
* **internal:** remove CI condition ([#310](https://github.com/openai/openai-java/issues/310)) ([1cb3294](https://github.com/openai/openai-java/commit/1cb3294f74fa75bca443aaa6f0f3d9127ed7ea14))
* **internal:** rename `getPathParam` ([#323](https://github.com/openai/openai-java/issues/323)) ([f95f8bc](https://github.com/openai/openai-java/commit/f95f8bc083cebbfeef127b62d8c5dbaffa2083ed))
* **internal:** reorder some params methodsc ([f95f8bc](https://github.com/openai/openai-java/commit/f95f8bc083cebbfeef127b62d8c5dbaffa2083ed))
* **internal:** update release workflows ([2b0d392](https://github.com/openai/openai-java/commit/2b0d392b57acc03b393c1052e39326606d9ad2b0))


### Documentation

* add `build` method comments ([#321](https://github.com/openai/openai-java/issues/321)) ([31a8e9e](https://github.com/openai/openai-java/commit/31a8e9e507d0242098fc280ad03cb40ab92dcf83))
* deduplicate and refine comments ([#313](https://github.com/openai/openai-java/issues/313)) ([3e0b2f5](https://github.com/openai/openai-java/commit/3e0b2f5ebea908879f2215bb648027d60e491374))
* image url example ([39695e4](https://github.com/openai/openai-java/commit/39695e4702c10171e02fb426bc66db61599c365a))

## 0.34.1 (2025-03-11)

Full Changelog: [v0.34.0...v0.34.1](https://github.com/openai/openai-java/compare/v0.34.0...v0.34.1)

### Bug Fixes

* **responses:** correct computer use enum value ([#298](https://github.com/openai/openai-java/issues/298)) ([5ad3f2a](https://github.com/openai/openai-java/commit/5ad3f2a947bd67ce9260b0f25afa4c675d91ebdd))
* **responses:** correct reasoning output type ([#300](https://github.com/openai/openai-java/issues/300)) ([77572c6](https://github.com/openai/openai-java/commit/77572c64b8712ea61f789fd42fb51a535a1512d0))

## 0.34.0 (2025-03-11)

Full Changelog: [v0.33.0...v0.34.0](https://github.com/openai/openai-java/compare/v0.33.0...v0.34.0)

### ⚠ BREAKING CHANGES

* **client:** move classes into subpackages and shorten names ([#294](https://github.com/openai/openai-java/issues/294))

### Features

* **api:** add /v1/responses and built-in tools ([#296](https://github.com/openai/openai-java/issues/296)) ([3216ffa](https://github.com/openai/openai-java/commit/3216ffa635b2d5ee337a9e62abef88f3faf3735e))


### Chores

* add `deploymentModel` to new endpoints ([2d98165](https://github.com/openai/openai-java/commit/2d981657dca3782cd03f2b19118ec01835dd6490))
* **client:** move classes into subpackages and shorten names ([#294](https://github.com/openai/openai-java/issues/294)) ([1a65445](https://github.com/openai/openai-java/commit/1a65445fbed70d1f1cde1d5e6e9db299fff3dbb3))
* **internal:** add `.kotlin` to `.gitignore` ([#285](https://github.com/openai/openai-java/issues/285)) ([46c9b3a](https://github.com/openai/openai-java/commit/46c9b3af9d2593b679fa359df4123516a36f5c25))
* **internal:** don't use `JvmOverloads` in interfaces ([9b04bb9](https://github.com/openai/openai-java/commit/9b04bb90bdacc38e926560e72244a677ced99991))
* **internal:** reenable warnings as errors ([#288](https://github.com/openai/openai-java/issues/288)) ([9b04bb9](https://github.com/openai/openai-java/commit/9b04bb90bdacc38e926560e72244a677ced99991))
* **internal:** use `getOrNull` instead of `orElse(null)` ([#287](https://github.com/openai/openai-java/issues/287)) ([8eeec84](https://github.com/openai/openai-java/commit/8eeec8405630759ffd7c02b30d4dd78b0d7df4d7))


### Documentation

* document `JsonValue` construction in readme ([#292](https://github.com/openai/openai-java/issues/292)) ([4453173](https://github.com/openai/openai-java/commit/4453173cf4916bd880be12b20bfbba23cd2370d2))
* fix examples ([0dfd4b1](https://github.com/openai/openai-java/commit/0dfd4b17e36ab12c9b37cc0a2f45170a89cea8ea))
* make URL purpose clearer in readme ([#289](https://github.com/openai/openai-java/issues/289)) ([88df036](https://github.com/openai/openai-java/commit/88df03664adae72f9d1fb9318a11ce73aa2c7b1e))
* responses examples ([589ea32](https://github.com/openai/openai-java/commit/589ea32fcdd3b1effcf3860d005987415eaab48e))
* revise readme docs about nested params ([#291](https://github.com/openai/openai-java/issues/291)) ([d3df21f](https://github.com/openai/openai-java/commit/d3df21f3f9dac58e896817c9619ab0c6e83419b7))

## 0.33.0 (2025-03-06)

Full Changelog: [v0.32.0...v0.33.0](https://github.com/openai/openai-java/compare/v0.32.0...v0.33.0)

### Features

* **client:** detect binary incompatible jackson versions ([#282](https://github.com/openai/openai-java/issues/282)) ([10eca3f](https://github.com/openai/openai-java/commit/10eca3f728726b0022d7f851a3784548764ede6c))


### Chores

* **ci:** run more examples ([4815776](https://github.com/openai/openai-java/commit/48157762da46b6bca6169a79adbfd7c07a701496))

## 0.32.0 (2025-03-06)

Full Changelog: [v0.31.1...v0.32.0](https://github.com/openai/openai-java/compare/v0.31.1...v0.32.0)

### Features

* **client:** accept `InputStream` and `Path` for file params ([3fda365](https://github.com/openai/openai-java/commit/3fda365a9d1b228ec4799a57137a288c25441dc7))
* **client:** accept `InputStream` and `Path` for file params ([#277](https://github.com/openai/openai-java/issues/277)) ([04f2d3c](https://github.com/openai/openai-java/commit/04f2d3c1042187fe2b52ec132ff3a0529f5b1316))


### Documentation

* document file uploads in readme ([#279](https://github.com/openai/openai-java/issues/279)) ([96e4969](https://github.com/openai/openai-java/commit/96e4969a322da35f6ac13324f69d9170c7280aff))

## 0.31.1 (2025-03-05)

Full Changelog: [v0.31.0...v0.31.1](https://github.com/openai/openai-java/compare/v0.31.0...v0.31.1)

### Bug Fixes

* **api:** add missing file rank enum + more metadata ([#276](https://github.com/openai/openai-java/issues/276)) ([e92512f](https://github.com/openai/openai-java/commit/e92512f551df43f994ec6a29cfb7ef918e203324))


### Chores

* **client:** expose `Optional`, not nullable, from `ClientOptions` ([#274](https://github.com/openai/openai-java/issues/274)) ([c029310](https://github.com/openai/openai-java/commit/c029310f6f31d5a78767585a9f4ece4ba076fe2e))


### Documentation

* add audio transcription example ([2c6a1aa](https://github.com/openai/openai-java/commit/2c6a1aa334dec5625a771ddd40452a7ffe32439b))
* embeddings example ([#263](https://github.com/openai/openai-java/issues/263)) ([e1b68de](https://github.com/openai/openai-java/commit/e1b68de090359c4272435b2236fd021d616331a2))
* note required fields in `builder` javadoc ([#272](https://github.com/openai/openai-java/issues/272)) ([603b5c9](https://github.com/openai/openai-java/commit/603b5c955ad383fa3ec358c91ce034cbbf7d1446))

## 0.31.0 (2025-03-04)

Full Changelog: [v0.30.0...v0.31.0](https://github.com/openai/openai-java/compare/v0.30.0...v0.31.0)

### Features

* **client:** add file upload endpoints ([#268](https://github.com/openai/openai-java/issues/268)) ([456274d](https://github.com/openai/openai-java/commit/456274d2dc572ad4711d2fc3640c7e01aa08f4b8))
* **client:** allow configuring timeouts granularly ([#266](https://github.com/openai/openai-java/issues/266)) ([c3bc6e4](https://github.com/openai/openai-java/commit/c3bc6e4fb9717c7f6146f864ce3cc2451619c9f0))


### Chores

* **internal:** refactor `ErrorHandlingTest` ([#264](https://github.com/openai/openai-java/issues/264)) ([2472f85](https://github.com/openai/openai-java/commit/2472f859b49f49cf14539e787cf15e8f863f5dac))
* **internal:** run example files in CI ([#271](https://github.com/openai/openai-java/issues/271)) ([8da7851](https://github.com/openai/openai-java/commit/8da785184c3e039ea4b9d2b26c6d14b607291750))


### Documentation

* add raw response readme documentation ([#269](https://github.com/openai/openai-java/issues/269)) ([2839903](https://github.com/openai/openai-java/commit/28399031c60eed8899475c5d1d38677c2eaa2284))
* update URLs from stainlessapi.com to stainless.com ([#259](https://github.com/openai/openai-java/issues/259)) ([b824bf3](https://github.com/openai/openai-java/commit/b824bf39a44251e15c7c8b5b14bc6cbf9133dff5))

## 0.30.0 (2025-02-27)

Full Changelog: [v0.29.0...v0.30.0](https://github.com/openai/openai-java/compare/v0.29.0...v0.30.0)

### Features

* **api:** add gpt-4.5-preview ([#258](https://github.com/openai/openai-java/issues/258)) ([27d1e7f](https://github.com/openai/openai-java/commit/27d1e7f6565ab00161d322bf04a8cb1e70c31694))


### Chores

* **client:** use deep identity methods for primitive array types ([#255](https://github.com/openai/openai-java/issues/255)) ([fac8678](https://github.com/openai/openai-java/commit/fac86783373355488b81a7a1452bc8ba2a74066f))
* **internal:** add async service tests ([#253](https://github.com/openai/openai-java/issues/253)) ([147872a](https://github.com/openai/openai-java/commit/147872a570403c78059fb785d9860003a5187583))
* **internal:** improve sync service tests ([147872a](https://github.com/openai/openai-java/commit/147872a570403c78059fb785d9860003a5187583))
* **internal:** refactor `ServiceParamsTest` ([#257](https://github.com/openai/openai-java/issues/257)) ([9cb1929](https://github.com/openai/openai-java/commit/9cb19297c372976fa331d5945c028017392b2d5d))


### Documentation

* readme parameter tweaks ([147872a](https://github.com/openai/openai-java/commit/147872a570403c78059fb785d9860003a5187583))

## 0.29.0 (2025-02-26)

Full Changelog: [v0.28.0...v0.29.0](https://github.com/openai/openai-java/compare/v0.28.0...v0.29.0)

### Features

* **client:** allow omitting params object when none required ([#249](https://github.com/openai/openai-java/issues/249)) ([e77a6c3](https://github.com/openai/openai-java/commit/e77a6c35a1940bd6f1ef37f08a524974b28f17ac))


### Bug Fixes

* **client:** add missing `@JvmStatic` ([#252](https://github.com/openai/openai-java/issues/252)) ([06231c2](https://github.com/openai/openai-java/commit/06231c26727f09fd2065f2ebe9670b8149fcee84))


### Chores

* **internal:** remove unused variable ([#251](https://github.com/openai/openai-java/issues/251)) ([b41bc4e](https://github.com/openai/openai-java/commit/b41bc4ebbe38a216e1276e0b15fd3fe54fe37353))


### Documentation

* switch to `.list()` without arguments in examples ([d1480f1](https://github.com/openai/openai-java/commit/d1480f1c85c0e2704c2095298525401b76cec2e5))

## 0.28.0 (2025-02-24)

Full Changelog: [v0.27.0...v0.28.0](https://github.com/openai/openai-java/compare/v0.27.0...v0.28.0)

### Features

* **api:** add latest stable/preview version helper methods ([#226](https://github.com/openai/openai-java/issues/226)) ([9766b7c](https://github.com/openai/openai-java/commit/9766b7c93928c9837fa13cbab5969a883ccec22a))


### Documentation

* add source file links to readme ([#247](https://github.com/openai/openai-java/issues/247)) ([d9b67d7](https://github.com/openai/openai-java/commit/d9b67d7ef7552112774039acf951a582c3eeefea))

## 0.27.0 (2025-02-24)

Full Changelog: [v0.26.1...v0.27.0](https://github.com/openai/openai-java/compare/v0.26.1...v0.27.0)

### Features

* docs: moderations example ([#245](https://github.com/openai/openai-java/issues/245)) ([3108fee](https://github.com/openai/openai-java/commit/3108feeb0fd17cce70d77fb3c6e858ea53f465e6))

## 0.26.1 (2025-02-21)

Full Changelog: [v0.26.0...v0.26.1](https://github.com/openai/openai-java/compare/v0.26.0...v0.26.1)

### Documentation

* add immutability explanation to readme ([#243](https://github.com/openai/openai-java/issues/243)) ([5826fb0](https://github.com/openai/openai-java/commit/5826fb0fafa06c647a520f82847319a32ddcbbbb))

## 0.26.0 (2025-02-20)

Full Changelog: [v0.25.0...v0.26.0](https://github.com/openai/openai-java/compare/v0.25.0...v0.26.0)

### Features

* **client:** add an `AsyncStreamResponse#onCompleteFuture()` method ([#239](https://github.com/openai/openai-java/issues/239)) ([9aeddf8](https://github.com/openai/openai-java/commit/9aeddf88f724c3f6dbb648f539d4daaa82f3fa8f))


### Bug Fixes

* **client:** mark some request bodies as optional ([#242](https://github.com/openai/openai-java/issues/242)) ([e3c5d67](https://github.com/openai/openai-java/commit/e3c5d679a1be7f5857ad321eb23fc566759e3083))
* **client:** prevent `IOException` when closing stream early ([#241](https://github.com/openai/openai-java/issues/241)) ([1e174e3](https://github.com/openai/openai-java/commit/1e174e3e255f679ec4785c1fe0a2b5794e99c802))


### Chores

* **docs:** add faq to readme ([#240](https://github.com/openai/openai-java/issues/240)) ([6bb4122](https://github.com/openai/openai-java/commit/6bb4122014424d9efaf1b0b7628495bf17ec22e6))
* **internal:** remove unnecessary non-null asserts in tests ([e3c5d67](https://github.com/openai/openai-java/commit/e3c5d679a1be7f5857ad321eb23fc566759e3083))
* **internal:** use `assertNotNull` in tests for type narrowing ([e3c5d67](https://github.com/openai/openai-java/commit/e3c5d679a1be7f5857ad321eb23fc566759e3083))


### Documentation

* add more documentation to `AsyncStreamResponse` ([9aeddf8](https://github.com/openai/openai-java/commit/9aeddf88f724c3f6dbb648f539d4daaa82f3fa8f))
* add stream cancellation example ([ddeabe0](https://github.com/openai/openai-java/commit/ddeabe054d02ade542a2555f45b819b090ce1a08))
* remove unnecessary catch clauses in readme ([#238](https://github.com/openai/openai-java/issues/238)) ([8c86b99](https://github.com/openai/openai-java/commit/8c86b997c5a84d74a71df7f7c5c4a863718f779a))
* remove unnecessary checked exception signatures ([e26ee05](https://github.com/openai/openai-java/commit/e26ee0569c6cb7289d35b920695b12e9826d8f93))
* use `onCompleteFuture()` in examples ([c244f17](https://github.com/openai/openai-java/commit/c244f17207f48414437d0558255a91af40f9a647))

## 0.25.0 (2025-02-20)

Full Changelog: [v0.24.1...v0.25.0](https://github.com/openai/openai-java/compare/v0.24.1...v0.25.0)

### Features

* **client:** get rid of annoying checked exceptions ([#236](https://github.com/openai/openai-java/issues/236)) ([4c60942](https://github.com/openai/openai-java/commit/4c6094218ed32bc8fc669703e2f1d94b318c7307))


### Chores

* **ci:** update gradle actions to v4 ([#234](https://github.com/openai/openai-java/issues/234)) ([fbcf865](https://github.com/openai/openai-java/commit/fbcf865056c37a022fd905147e1763b96d2ec26a))

## 0.24.1 (2025-02-20)

Full Changelog: [v0.24.0...v0.24.1](https://github.com/openai/openai-java/compare/v0.24.0...v0.24.1)

### Bug Fixes

* **client:** add missing `streamHandlerExecutor` method ([#230](https://github.com/openai/openai-java/issues/230)) ([d53a08a](https://github.com/openai/openai-java/commit/d53a08a02d256b702b53734e99d25c7394a8f5db))


### Chores

* **docs:** add binary responses info to readme ([#231](https://github.com/openai/openai-java/issues/231)) ([6ae25b4](https://github.com/openai/openai-java/commit/6ae25b4c6e7ee2186b905fb68ee05cb5ad470174))
* **docs:** add streaming info to readme ([d53a08a](https://github.com/openai/openai-java/commit/d53a08a02d256b702b53734e99d25c7394a8f5db))
* **docs:** reorganize readme ([#228](https://github.com/openai/openai-java/issues/228)) ([7d92206](https://github.com/openai/openai-java/commit/7d92206374def33c43591e59f33ecc558e4ecf2f))
* **internal:** get rid of configuration cache ([#233](https://github.com/openai/openai-java/issues/233)) ([d95c380](https://github.com/openai/openai-java/commit/d95c380af1cb3cdb1a94fbd2c65bfaf4d0bf5805))

## 0.24.0 (2025-02-18)

Full Changelog: [v0.23.1...v0.24.0](https://github.com/openai/openai-java/compare/v0.23.1...v0.24.0)

### Features

* **client:** support `JsonField#asX()` for known values ([#225](https://github.com/openai/openai-java/issues/225)) ([31c0663](https://github.com/openai/openai-java/commit/31c06634ead5ffcd54e0a9208e39ac9880df6574))
* **client:** update enum `asX` methods ([#224](https://github.com/openai/openai-java/issues/224)) ([b06a749](https://github.com/openai/openai-java/commit/b06a7496f016b3e7541d9f4e5082ada4a1a5b39d))


### Chores

* **internal:** make body class constructors private ([7c6739c](https://github.com/openai/openai-java/commit/7c6739c254ef5a06020fbdbfb6b1d470377e34fc))
* **internal:** make body classes for multipart requests ([7c6739c](https://github.com/openai/openai-java/commit/7c6739c254ef5a06020fbdbfb6b1d470377e34fc))
* **internal:** misc formatting changes ([7c6739c](https://github.com/openai/openai-java/commit/7c6739c254ef5a06020fbdbfb6b1d470377e34fc))
* **internal:** optimize build and test perf ([fc6bcd7](https://github.com/openai/openai-java/commit/fc6bcd742b042e9e8338cc7c8bceb6b1e3be6b38))
* **internal:** rename internal body classes ([7c6739c](https://github.com/openai/openai-java/commit/7c6739c254ef5a06020fbdbfb6b1d470377e34fc))
* **internal:** update formatter ([#220](https://github.com/openai/openai-java/issues/220)) ([fc6bcd7](https://github.com/openai/openai-java/commit/fc6bcd742b042e9e8338cc7c8bceb6b1e3be6b38))
* **internal:** update some formatting in `Values.kt` ([31c0663](https://github.com/openai/openai-java/commit/31c06634ead5ffcd54e0a9208e39ac9880df6574))
* **internal:** use better test example values ([#222](https://github.com/openai/openai-java/issues/222)) ([7c6739c](https://github.com/openai/openai-java/commit/7c6739c254ef5a06020fbdbfb6b1d470377e34fc))

## 0.23.1 (2025-02-15)

Full Changelog: [v0.23.0...v0.23.1](https://github.com/openai/openai-java/compare/v0.23.0...v0.23.1)

### Bug Fixes

* add missing argument ([5a6d2a2](https://github.com/openai/openai-java/commit/5a6d2a21be7bffabe335da4d13b6d2813c17ba7b))

## 0.23.0 (2025-02-14)

Full Changelog: [v0.22.1...v0.23.0](https://github.com/openai/openai-java/compare/v0.22.1...v0.23.0)

### Features

* **api:** add support for storing chat completions ([#216](https://github.com/openai/openai-java/issues/216)) ([68a7883](https://github.com/openai/openai-java/commit/68a7883782574f1af0d724c1d838fd70a99f2958))

## 0.22.1 (2025-02-12)

Full Changelog: [v0.22.0...v0.22.1](https://github.com/openai/openai-java/compare/v0.22.0...v0.22.1)

### Documentation

* function calling example ([#213](https://github.com/openai/openai-java/issues/213)) ([89700ec](https://github.com/openai/openai-java/commit/89700ecff1ec8e0d952bc7c77fcc3e2dd20b8a63))

## 0.22.0 (2025-02-06)

Full Changelog: [v0.21.1...v0.22.0](https://github.com/openai/openai-java/compare/v0.21.1...v0.22.0)

### Features

* **api:** Add more new Azure service versions ([#208](https://github.com/openai/openai-java/issues/208)) ([a117892](https://github.com/openai/openai-java/commit/a11789220599540173f09d6cc9583365abe5f4e0))
* **pagination:** avoid fetching when has_more: false ([#209](https://github.com/openai/openai-java/issues/209)) ([183b132](https://github.com/openai/openai-java/commit/183b132bba24beb90168fa77df84a93f0ea92fbe))


### Bug Fixes

* **api:** add missing `@MustBeClosed` annotations ([#205](https://github.com/openai/openai-java/issues/205)) ([0a60b9a](https://github.com/openai/openai-java/commit/0a60b9a40ad7f97ed51be3f6a70d674a6a9f1854))
* **api:** add missing reasoning effort + model enums ([#207](https://github.com/openai/openai-java/issues/207)) ([8eb2394](https://github.com/openai/openai-java/commit/8eb2394b4ea937b19720d97dae84ed56660845c0))
* **api:** switch `CompletableFuture&lt;Void&gt;` to `CompletableFuture<Void?>` ([0a60b9a](https://github.com/openai/openai-java/commit/0a60b9a40ad7f97ed51be3f6a70d674a6a9f1854))
* **client:** add missing validation calls on response ([0a60b9a](https://github.com/openai/openai-java/commit/0a60b9a40ad7f97ed51be3f6a70d674a6a9f1854))
* **client:** always provide a body for `PATCH` methods ([0a60b9a](https://github.com/openai/openai-java/commit/0a60b9a40ad7f97ed51be3f6a70d674a6a9f1854))
* deploymentModel arg ([3ab4110](https://github.com/openai/openai-java/commit/3ab41105d8b3fbb3db24ee96e825611f27713bb2))


### Chores

* **internal:** minor formatting/style changes ([0a60b9a](https://github.com/openai/openai-java/commit/0a60b9a40ad7f97ed51be3f6a70d674a6a9f1854))
* **internal:** rename some tests ([0a60b9a](https://github.com/openai/openai-java/commit/0a60b9a40ad7f97ed51be3f6a70d674a6a9f1854))

## 0.21.1 (2025-02-05)

Full Changelog: [v0.21.0...v0.21.1](https://github.com/openai/openai-java/compare/v0.21.0...v0.21.1)

### Bug Fixes

* **api/types:** correct audio duration & role types ([#199](https://github.com/openai/openai-java/issues/199)) ([5b57a0d](https://github.com/openai/openai-java/commit/5b57a0df88804deed4486d0271f0e62c1ea8c130))

## 0.21.0 (2025-02-05)

Full Changelog: [v0.20.0...v0.21.0](https://github.com/openai/openai-java/compare/v0.20.0...v0.21.0)

### Features

* **api:** add file content endpoint ([#198](https://github.com/openai/openai-java/issues/198)) ([3dd469f](https://github.com/openai/openai-java/commit/3dd469f393b1c33348e6e709687d328154d0aa84))
* **client:** send client-side timeout headers ([#196](https://github.com/openai/openai-java/issues/196)) ([03706d4](https://github.com/openai/openai-java/commit/03706d4a1f37936e83cb97dd53d815ce12933061))


### Bug Fixes

* add deploymentModel ([38e173d](https://github.com/openai/openai-java/commit/38e173d262dae86658355c69052a135398192d80))

## 0.20.0 (2025-01-31)

Full Changelog: [v0.19.0...v0.20.0](https://github.com/openai/openai-java/compare/v0.19.0...v0.20.0)

### Features

* **api:** add o3-mini ([#192](https://github.com/openai/openai-java/issues/192)) ([e10c532](https://github.com/openai/openai-java/commit/e10c532340e9d1022db2927678a5223d1d8c6f5b))


### Bug Fixes

* **types:** correct metadata type + other fixes ([e10c532](https://github.com/openai/openai-java/commit/e10c532340e9d1022db2927678a5223d1d8c6f5b))

## 0.19.0 (2025-01-30)

Full Changelog: [v0.18.1...v0.19.0](https://github.com/openai/openai-java/compare/v0.18.1...v0.19.0)

### Features

* **client:** helpers for discriminated classes with one required prop ([#189](https://github.com/openai/openai-java/issues/189)) ([adbf4b0](https://github.com/openai/openai-java/commit/adbf4b0dd8d978586842e97ba628f8cf4e3484de))


### Documentation

* fix incorrect additional properties info ([#190](https://github.com/openai/openai-java/issues/190)) ([3d443f7](https://github.com/openai/openai-java/commit/3d443f7e545036484b571f1893aa058725ca57f6))
* update breaking change expectations ([ee4ee2b](https://github.com/openai/openai-java/commit/ee4ee2b876ac5e956fbd35a4e10ed4f21668ae03))

## 0.18.1 (2025-01-29)

Full Changelog: [v0.18.0...v0.18.1](https://github.com/openai/openai-java/compare/v0.18.0...v0.18.1)

### Bug Fixes

* **client:** don't leak responses when retrying ([#185](https://github.com/openai/openai-java/issues/185)) ([a13f967](https://github.com/openai/openai-java/commit/a13f967d4406cb447b14260c5435f77d91b6b1be))

## 0.18.0 (2025-01-29)

Full Changelog: [v0.17.0...v0.18.0](https://github.com/openai/openai-java/compare/v0.17.0...v0.18.0)

### Features

* **client:** helpers for discriminated union variants with one required prop ([#182](https://github.com/openai/openai-java/issues/182)) ([ec756b9](https://github.com/openai/openai-java/commit/ec756b9788629dfc36bb56d59d9f17f4d0d8cc35))


### Chores

* **internal:** improve `RetryingHttpClientTest` ([#180](https://github.com/openai/openai-java/issues/180)) ([b7ebe5d](https://github.com/openai/openai-java/commit/b7ebe5d44b2797618905614b51a27b73906e4271))
* **internal:** simplify object construction ([#183](https://github.com/openai/openai-java/issues/183)) ([3d5a59d](https://github.com/openai/openai-java/commit/3d5a59dccc425e351a365f9dbdf2ae52244086ae))


### Documentation

* simpliy param construction ([2c2ccbc](https://github.com/openai/openai-java/commit/2c2ccbc83a053e525ad0d8df1506de5be4fda46c))

## 0.17.0 (2025-01-29)

Full Changelog: [v0.16.0...v0.17.0](https://github.com/openai/openai-java/compare/v0.16.0...v0.17.0)

### Features

* **client:** add `_queryParams` and `_headers` methods ([#177](https://github.com/openai/openai-java/issues/177)) ([2d67005](https://github.com/openai/openai-java/commit/2d67005735b554440ed0578de6a182a73b129ffa))


### Refactors

* **internal:** extract request preparation logic ([2d67005](https://github.com/openai/openai-java/commit/2d67005735b554440ed0578de6a182a73b129ffa))

## 0.16.0 (2025-01-28)

Full Changelog: [v0.15.1...v0.16.0](https://github.com/openai/openai-java/compare/v0.15.1...v0.16.0)

### Features

* **client:** add some more builder helpers ([#173](https://github.com/openai/openai-java/issues/173)) ([f314e68](https://github.com/openai/openai-java/commit/f314e68915560703970c9acc16e96030202de9d1))


### Chores

* **internal:** shorten `model` method impl ([f314e68](https://github.com/openai/openai-java/commit/f314e68915560703970c9acc16e96030202de9d1))


### Documentation

* mark more methods as deprecated ([f314e68](https://github.com/openai/openai-java/commit/f314e68915560703970c9acc16e96030202de9d1))
* more examples and cleanup ([#159](https://github.com/openai/openai-java/issues/159)) ([fa2a1fc](https://github.com/openai/openai-java/commit/fa2a1fc2983131bac40988049dd3b0e7c730442c))

## 0.15.1 (2025-01-27)

Full Changelog: [v0.15.0...v0.15.1](https://github.com/openai/openai-java/compare/v0.15.0...v0.15.1)

### Documentation

* builder, enum, and union comments ([#171](https://github.com/openai/openai-java/issues/171)) ([37acbbd](https://github.com/openai/openai-java/commit/37acbbd239d6b540a461084240bc266ad0491e9c))

## 0.15.0 (2025-01-27)

Full Changelog: [v0.14.1...v0.15.0](https://github.com/openai/openai-java/compare/v0.14.1...v0.15.0)

### Features

* **client:** add `close` method ([#164](https://github.com/openai/openai-java/issues/164)) ([f32975f](https://github.com/openai/openai-java/commit/f32975f523bcab55faa54568982b884ba7d1d381))


### Bug Fixes

* **client:** make some classes and constructors non-public ([#169](https://github.com/openai/openai-java/issues/169)) ([20fb5a1](https://github.com/openai/openai-java/commit/20fb5a1eef19b59c9dd152f132e2a980d20b039d))


### Chores

* **internal:** remove some unnecessary `constructor` keywords ([20fb5a1](https://github.com/openai/openai-java/commit/20fb5a1eef19b59c9dd152f132e2a980d20b039d))


### Documentation

* `async` and `sync` method comments ([#167](https://github.com/openai/openai-java/issues/167)) ([6f11e5d](https://github.com/openai/openai-java/commit/6f11e5d88a70631f18b86c7f24e91042330f39ec))
* add client documentation ([#166](https://github.com/openai/openai-java/issues/166)) ([4344883](https://github.com/openai/openai-java/commit/434488395fb95e59933242113b5d14b610ef5ec5))

## 0.14.1 (2025-01-25)

Full Changelog: [v0.14.0...v0.14.1](https://github.com/openai/openai-java/compare/v0.14.0...v0.14.1)

### Bug Fixes

* **client:** async streaming flakiness ([#162](https://github.com/openai/openai-java/issues/162)) ([247c05a](https://github.com/openai/openai-java/commit/247c05a70fecad0bc1498d5aa56e13310f36eb96))


### Chores

* add max retries to test ([#160](https://github.com/openai/openai-java/issues/160)) ([7c4a4e0](https://github.com/openai/openai-java/commit/7c4a4e034c5edaea804435972f558df6a9326220))
* **internal:** fix release ([#163](https://github.com/openai/openai-java/issues/163)) ([987fa44](https://github.com/openai/openai-java/commit/987fa4409a86636bbe87fee77522a1659e263f3b))

## 0.14.0 (2025-01-24)

Full Changelog: [v0.13.0...v0.14.0](https://github.com/openai/openai-java/compare/v0.13.0...v0.14.0)

### ⚠ BREAKING CHANGES

* **client:** better union variant method and variable names ([#157](https://github.com/openai/openai-java/issues/157))

### Features

* **client:** better union variant method and variable names ([#157](https://github.com/openai/openai-java/issues/157)) ([da5bce5](https://github.com/openai/openai-java/commit/da5bce5d00af53d7297133af09352a7176c2f83e))


### Bug Fixes

* examples ([3473781](https://github.com/openai/openai-java/commit/3473781ca26d25531f368485291f9972e600631b))


### Chores

* **internal:** swap `checkNotNull` to `checkRequired` ([#156](https://github.com/openai/openai-java/issues/156)) ([d6f65f7](https://github.com/openai/openai-java/commit/d6f65f7c0e25adbce97b22f7a649f6c3eaeb61ed))


### Documentation

* move up requirements section ([#154](https://github.com/openai/openai-java/issues/154)) ([48fc646](https://github.com/openai/openai-java/commit/48fc646957ad4ff69c93b40d59ea9d5e8a22eece))
* update readme ([#152](https://github.com/openai/openai-java/issues/152)) ([293dc47](https://github.com/openai/openai-java/commit/293dc47b242e204b6c6e419002dbb560cb455169))

## 0.13.0 (2025-01-22)

Full Changelog: [v0.12.0...v0.13.0](https://github.com/openai/openai-java/compare/v0.12.0...v0.13.0)

### Features

* **api:** update enum values, comments, examples, and constants ([#149](https://github.com/openai/openai-java/issues/149)) ([4bfa305](https://github.com/openai/openai-java/commit/4bfa3055d017aa23cc8cc41827012dc773cbf508))


### Bug Fixes

* **examples:** remove now unneeded role param ([045f141](https://github.com/openai/openai-java/commit/045f141a7956d13a2ac35af30e64c5160252ee6b))

## 0.12.0 (2025-01-22)

Full Changelog: [v0.11.10...v0.12.0](https://github.com/openai/openai-java/compare/v0.11.10...v0.12.0)

### Features

* **client:** make it easy to roundtrip messages ([#148](https://github.com/openai/openai-java/issues/148)) ([f4a1617](https://github.com/openai/openai-java/commit/f4a1617148ffc276a324ed9a59654091f57222d2))


### Bug Fixes

* **client:** bad assistants v2 deserialization ([#146](https://github.com/openai/openai-java/issues/146)) ([59d6de8](https://github.com/openai/openai-java/commit/59d6de8cf5857a4b46eeece4f3c8d930d67103d6))

## 0.11.10 (2025-01-21)

Full Changelog: [v0.11.9...v0.11.10](https://github.com/openai/openai-java/compare/v0.11.9...v0.11.10)

### Bug Fixes

* **client:** add missing default headers ([#145](https://github.com/openai/openai-java/issues/145)) ([18d5270](https://github.com/openai/openai-java/commit/18d5270326561ca8e5f10b5a671da1d30ced5993))

## 0.11.9 (2025-01-21)

Full Changelog: [v0.11.8...v0.11.9](https://github.com/openai/openai-java/compare/v0.11.8...v0.11.9)

### Bug Fixes

* **client:** make service impl constructors internal ([#141](https://github.com/openai/openai-java/issues/141)) ([da35557](https://github.com/openai/openai-java/commit/da35557895e233dd5e490e139043faad92173782))

## 0.11.8 (2025-01-17)

Full Changelog: [v0.11.7...v0.11.8](https://github.com/openai/openai-java/compare/v0.11.7...v0.11.8)

### Documentation

* fix javadoc.io link ([ba07770](https://github.com/openai/openai-java/commit/ba07770369a44a7487a7a7fae9e85da6600204ce))
* fix javadoc.io link again ([0d2b8ce](https://github.com/openai/openai-java/commit/0d2b8ce0894ae592047e6014ff82876060152ee7))

## 0.11.7 (2025-01-17)

Full Changelog: [v0.11.6...v0.11.7](https://github.com/openai/openai-java/compare/v0.11.6...v0.11.7)

### Chores

* **internal:** upgrade kotlin compiler and gradle ([#132](https://github.com/openai/openai-java/issues/132)) ([61a0b0d](https://github.com/openai/openai-java/commit/61a0b0debfd50646fc9fe310b5decc2e891f48d0))


### Documentation

* add javadoc.io badge ([#135](https://github.com/openai/openai-java/issues/135)) ([e905ce5](https://github.com/openai/openai-java/commit/e905ce509aabe1b9db9519b6ff77a79fc95434e1))
* add more documentation ([#134](https://github.com/openai/openai-java/issues/134)) ([893eafc](https://github.com/openai/openai-java/commit/893eafcb367b4ea96331c6deccb71c865eb67d4b))

## 0.11.6 (2025-01-17)

Full Changelog: [v0.11.5...v0.11.6](https://github.com/openai/openai-java/compare/v0.11.5...v0.11.6)

### Chores

* **internal:** move `StreamResponse` method ([#131](https://github.com/openai/openai-java/issues/131)) ([5888e39](https://github.com/openai/openai-java/commit/5888e398597b68a520b4bb3953d96403023331fd))
* **internal:** refactor streaming implementation ([#129](https://github.com/openai/openai-java/issues/129)) ([d2831ec](https://github.com/openai/openai-java/commit/d2831ec587d37a2c2d51332f5f2f62ba3dd1181d))

## 0.11.5 (2025-01-16)

Full Changelog: [v0.11.4...v0.11.5](https://github.com/openai/openai-java/compare/v0.11.4...v0.11.5)

### Bug Fixes

* **internal:** publishing error ([73e22ea](https://github.com/openai/openai-java/commit/73e22eae2e905919172ab4d7e3b18b44d435205e))

## 0.11.4 (2025-01-16)

Full Changelog: [v0.11.3...v0.11.4](https://github.com/openai/openai-java/compare/v0.11.3...v0.11.4)

### Chores

* **internal:** add and tweak check functions ([#117](https://github.com/openai/openai-java/issues/117)) ([627cb56](https://github.com/openai/openai-java/commit/627cb568af9ff28a570de4d9ebae04a2ba5c46d7))
* **internal:** extract a `checkRequired` function ([#113](https://github.com/openai/openai-java/issues/113)) ([b63b2b1](https://github.com/openai/openai-java/commit/b63b2b159bd6c9d01d22a64980a13bfcc3f64863))
* **internal:** fix tests ([61ada05](https://github.com/openai/openai-java/commit/61ada05fe8d4a3509fc59c6626611e5dbc308aff))
* **internal:** remove space ([#125](https://github.com/openai/openai-java/issues/125)) ([27bfcec](https://github.com/openai/openai-java/commit/27bfcec6deccf7d000a305e630b4eda012154222))
* **internal:** remove unused gradle task ([#121](https://github.com/openai/openai-java/issues/121)) ([0b4e59a](https://github.com/openai/openai-java/commit/0b4e59abac5343abe8cda697864fe8afa9fe1774))
* **internal:** tweak client options nullability handling ([627cb56](https://github.com/openai/openai-java/commit/627cb568af9ff28a570de4d9ebae04a2ba5c46d7))
* simplify examples involving lists ([#118](https://github.com/openai/openai-java/issues/118)) ([557c071](https://github.com/openai/openai-java/commit/557c0713590c7e0556dd68e77e4179fde8923c86))
* simplify examples involving unions ([#119](https://github.com/openai/openai-java/issues/119)) ([7c7795c](https://github.com/openai/openai-java/commit/7c7795c852c09bca6ab23b22435fd7846730e95c))
* **types:** rename vector store chunking strategy ([#116](https://github.com/openai/openai-java/issues/116)) ([387935f](https://github.com/openai/openai-java/commit/387935fa16873ae252522aa926d3ed701186a292))


### Documentation

* don't mention a non-existent SDK ([#120](https://github.com/openai/openai-java/issues/120)) ([23eb658](https://github.com/openai/openai-java/commit/23eb6584b4ba7dfd8e5a9147d815ab01e364726e))

## 0.11.3 (2025-01-14)

Full Changelog: [v0.11.2...v0.11.3](https://github.com/openai/openai-java/compare/v0.11.2...v0.11.3)

### Bug Fixes

* **streaming:** support assistants ([#106](https://github.com/openai/openai-java/issues/106)) ([bebfa9c](https://github.com/openai/openai-java/commit/bebfa9c39172655e76c7c3fea45757eef705e931))


### Chores

* **internal:** fix up root `build.gradle.kts` formatting ([#109](https://github.com/openai/openai-java/issues/109)) ([54a806f](https://github.com/openai/openai-java/commit/54a806fa6bdd9ff4ef0957324cc36380241c6b82))
* **internal:** remove unused Gradle imports ([#110](https://github.com/openai/openai-java/issues/110)) ([22502eb](https://github.com/openai/openai-java/commit/22502eb53d52a35237ea364d5d8c89bc1ced62bd))
* **internal:** remove unused or unnecessary Gradle imports ([#111](https://github.com/openai/openai-java/issues/111)) ([8d95893](https://github.com/openai/openai-java/commit/8d95893e22b7f55bc65bad3cafcb0bf78569fd83))
* **tests:** add more tests for streaming ([#108](https://github.com/openai/openai-java/issues/108)) ([5dec143](https://github.com/openai/openai-java/commit/5dec143db64f4efd3c1f3f1cd55d1fdee280d695))


### Documentation

* publish dokka javadoc ([#112](https://github.com/openai/openai-java/issues/112)) ([5521ffc](https://github.com/openai/openai-java/commit/5521ffc83b4a2adae49e9a226c5c745e64bbbc56))

## 0.11.2 (2025-01-10)

Full Changelog: [v0.11.1...v0.11.2](https://github.com/openai/openai-java/compare/v0.11.1...v0.11.2)

### Bug Fixes

* **client:** add some missing `validate()` calls ([#101](https://github.com/openai/openai-java/issues/101)) ([dec2d6b](https://github.com/openai/openai-java/commit/dec2d6b25cccc2547e576c8658116d2bba12f100))


### Chores

* **internal:** refactor `validate` methods ([dec2d6b](https://github.com/openai/openai-java/commit/dec2d6b25cccc2547e576c8658116d2bba12f100))

## 0.11.1 (2025-01-09)

Full Changelog: [v0.11.0...v0.11.1](https://github.com/openai/openai-java/compare/v0.11.0...v0.11.1)

### Chores

* **internal:** add some missing newlines between methods ([#100](https://github.com/openai/openai-java/issues/100)) ([afc2998](https://github.com/openai/openai-java/commit/afc2998ac124a26fe3ec92207f5ff4c9614ff673))
* **internal:** spec update ([#97](https://github.com/openai/openai-java/issues/97)) ([0cff792](https://github.com/openai/openai-java/commit/0cff79271c63be46f5502a138ce1ad67a146724f))


### Documentation

* update some builder method javadocs ([#99](https://github.com/openai/openai-java/issues/99)) ([192965a](https://github.com/openai/openai-java/commit/192965abf73b9868d808c407bfc9fb73a507def7))

## 0.11.0 (2025-01-08)

Full Changelog: [v0.10.0...v0.11.0](https://github.com/openai/openai-java/compare/v0.10.0...v0.11.0)

### Features

* **client:** add more builder convenience methods for lists ([#96](https://github.com/openai/openai-java/issues/96)) ([9ee703b](https://github.com/openai/openai-java/commit/9ee703b13e8c467a71e7787d420a131bc1910e4f))


### Documentation

* **readme:** fix misplaced period ([#94](https://github.com/openai/openai-java/issues/94)) ([c6242ba](https://github.com/openai/openai-java/commit/c6242bad2b917fb419d9a69ad65cebbda9b56b51))

## 0.10.0 (2025-01-08)

Full Changelog: [v0.9.1...v0.10.0](https://github.com/openai/openai-java/compare/v0.9.1...v0.10.0)

### Features

* **client:** add various convenience setters to models ([#91](https://github.com/openai/openai-java/issues/91)) ([9b3eb17](https://github.com/openai/openai-java/commit/9b3eb17270075587ac9c2701b0e41a7debf17bec))
* **client:** allow passing null or optional for nullable fields ([#84](https://github.com/openai/openai-java/issues/84)) ([8a8f2f9](https://github.com/openai/openai-java/commit/8a8f2f9ac5f6555c372a81acc196b3ab04fd9555))
* **client:** allow setting arbitrary JSON for top-level body params ([9b3eb17](https://github.com/openai/openai-java/commit/9b3eb17270075587ac9c2701b0e41a7debf17bec))
* **client:** expose getters for `JsonField` of body params ([9b3eb17](https://github.com/openai/openai-java/commit/9b3eb17270075587ac9c2701b0e41a7debf17bec))


### Bug Fixes

* **client:** consistently throw on omitting required fields ([9b3eb17](https://github.com/openai/openai-java/commit/9b3eb17270075587ac9c2701b0e41a7debf17bec))
* **client:** convert `JsonField` containing list type to mutable in builder ([9b3eb17](https://github.com/openai/openai-java/commit/9b3eb17270075587ac9c2701b0e41a7debf17bec))


### Documentation

* add params class javadocs ([#90](https://github.com/openai/openai-java/issues/90)) ([9a33c1c](https://github.com/openai/openai-java/commit/9a33c1cf22e30e1878d739acfab4258321c6a9f8))


### Styles

* **internal:** explicitly add some method return types ([9b3eb17](https://github.com/openai/openai-java/commit/9b3eb17270075587ac9c2701b0e41a7debf17bec))
* **internal:** move headers and query params setters below others ([9b3eb17](https://github.com/openai/openai-java/commit/9b3eb17270075587ac9c2701b0e41a7debf17bec))
* **internal:** simplify existing convenience setters on params ([9b3eb17](https://github.com/openai/openai-java/commit/9b3eb17270075587ac9c2701b0e41a7debf17bec))

## 0.9.1 (2025-01-06)

Full Changelog: [v0.9.0...v0.9.1](https://github.com/openai/openai-java/compare/v0.9.0...v0.9.1)

### Styles

* **internal:** sort fields ([#82](https://github.com/openai/openai-java/issues/82)) ([219b48f](https://github.com/openai/openai-java/commit/219b48f7c6ff25eae8a9a082f8193c41aa18d0ac))

## 0.9.0 (2025-01-03)

Full Changelog: [v0.8.1...v0.9.0](https://github.com/openai/openai-java/compare/v0.8.1...v0.9.0)

### ⚠ BREAKING CHANGES

* **client:** switch query params objects to use `QueryParams` ([#64](https://github.com/openai/openai-java/issues/64))

### Features

* **client:** add beta endpoints ([#79](https://github.com/openai/openai-java/issues/79)) ([8584a20](https://github.com/openai/openai-java/commit/8584a2029ec5402b205ce485e96702da0a692b76))
* **client:** put body field in params, add more convenience methods, and add missing docs ([#77](https://github.com/openai/openai-java/issues/77)) ([0c74350](https://github.com/openai/openai-java/commit/0c74350f0e5d1f0a30ae9b27c50a306ca081b1a7))


### Chores

* bump license year ([#74](https://github.com/openai/openai-java/issues/74)) ([769175d](https://github.com/openai/openai-java/commit/769175d3c42b6679e8ea91847e1fba32ab76d9a6))


### Documentation

* add some missing javadocs ([#78](https://github.com/openai/openai-java/issues/78)) ([d153ef9](https://github.com/openai/openai-java/commit/d153ef99dff3a201bf5674ee4154f3a3d276f608))


### Refactors

* **client:** switch query params objects to use `QueryParams` ([#64](https://github.com/openai/openai-java/issues/64)) ([4e9c3eb](https://github.com/openai/openai-java/commit/4e9c3eb9351f308ed3d842bd4aa2d860c23d568e))
* **internal:** use constructor to deserialize json ([#66](https://github.com/openai/openai-java/issues/66)) ([27389cd](https://github.com/openai/openai-java/commit/27389cd377ce9a109a4aa25f78f70c36ca62de14))

## 0.8.1 (2024-12-21)

Full Changelog: [v0.8.0...v0.8.1](https://github.com/openai/openai-java/compare/v0.8.0...v0.8.1)

### Chores

* **docs:** add example project ([#59](https://github.com/openai/openai-java/issues/59)) ([045c7ba](https://github.com/openai/openai-java/commit/045c7badc319be2df3fac123df3daafc61b40473))
* **docs:** fix code block language ([#61](https://github.com/openai/openai-java/issues/61)) ([4301693](https://github.com/openai/openai-java/commit/4301693dac3c53e80225a91087ddb890e1419f76))
* **docs:** update readme ([#58](https://github.com/openai/openai-java/issues/58)) ([ef3dcd5](https://github.com/openai/openai-java/commit/ef3dcd543892f092899dcc57b1788ea8d07f6de4))
* format example ([892bb69](https://github.com/openai/openai-java/commit/892bb697138f56c2e9783c1a413db5873385cc9b))
* **internal:** spec update ([#55](https://github.com/openai/openai-java/issues/55)) ([768138f](https://github.com/openai/openai-java/commit/768138fcc6d6101efc08b8ebc001d45f8d6a96a1))
* update parameter examples in tests and docs ([#57](https://github.com/openai/openai-java/issues/57)) ([afe3e0e](https://github.com/openai/openai-java/commit/afe3e0e2591818bcc8cfb14bb6a956a0d1d3fff0))


### Documentation

* add note about feedback ([1a5517f](https://github.com/openai/openai-java/commit/1a5517f823a04e4523c0a4b45482f223048e0c31))

## 0.8.0 (2024-12-17)

Full Changelog: [v0.7.5...v0.8.0](https://github.com/openai/openai-java/compare/v0.7.5...v0.8.0)

### Features

* **api:** new o1 and GPT-4o models + preference fine-tuning ([#46](https://github.com/openai/openai-java/issues/46)) ([4f2fac5](https://github.com/openai/openai-java/commit/4f2fac59587836e6a34ed4b313589abbf8153963))


### Chores

* **internal:** spec update ([#48](https://github.com/openai/openai-java/issues/48)) ([777165c](https://github.com/openai/openai-java/commit/777165c5344891ae7816be6606d9413550a578b5))

## 0.7.5 (2024-12-13)

Full Changelog: [v0.7.4...v0.7.5](https://github.com/openai/openai-java/compare/v0.7.4...v0.7.5)

### Chores

* **internal:** remove unused and expand used wildcard imports ([#43](https://github.com/openai/openai-java/issues/43)) ([39bfc4e](https://github.com/openai/openai-java/commit/39bfc4e4a15ce52c029ed31253afff9d9de36cc1))
* **internal:** remove unused and expand used wildcard imports ([#44](https://github.com/openai/openai-java/issues/44)) ([7f7e131](https://github.com/openai/openai-java/commit/7f7e1313bde6827cd9067b712f3d7992ddeeaa6f))
* **test:** use `JsonValue` instead of `JsonString` ([#41](https://github.com/openai/openai-java/issues/41)) ([8d2dd03](https://github.com/openai/openai-java/commit/8d2dd030899ad807a4712e00a33426c7484bcab5))

## 0.7.4 (2024-12-12)

Full Changelog: [v0.7.3...v0.7.4](https://github.com/openai/openai-java/compare/v0.7.3...v0.7.4)

### Chores

* **test:** remove unused imports ([#39](https://github.com/openai/openai-java/issues/39)) ([1ce3035](https://github.com/openai/openai-java/commit/1ce303537ed133fea41a7d4dbd2ebf9e53c8f594))

## 0.7.3 (2024-12-11)

Full Changelog: [v0.7.2...v0.7.3](https://github.com/openai/openai-java/compare/v0.7.2...v0.7.3)

### Chores

* **internal:** remove unused imports ([#38](https://github.com/openai/openai-java/issues/38)) ([021177f](https://github.com/openai/openai-java/commit/021177f995fb11e9a17ebf3950e0d46591e3c354))


### Styles

* **internal:** make enum value definitions less verbose ([#35](https://github.com/openai/openai-java/issues/35)) ([1effd49](https://github.com/openai/openai-java/commit/1effd49f5c1585c54e46454945df3fe2314ef05d))
* **internal:** move enum identity methods to bottom of class ([#37](https://github.com/openai/openai-java/issues/37)) ([7a9d27a](https://github.com/openai/openai-java/commit/7a9d27a7ef5d59f78479e1af83a980eb52097fcc))

## 0.7.2 (2024-12-11)

Full Changelog: [v0.7.1...v0.7.2](https://github.com/openai/openai-java/compare/v0.7.1...v0.7.2)

### Chores

* update example values in tests and docs ([#33](https://github.com/openai/openai-java/issues/33)) ([e74f2b5](https://github.com/openai/openai-java/commit/e74f2b571857879b6a40351c572ab063eb1f18f5))

## 0.7.1 (2024-12-09)

Full Changelog: [v0.7.0...v0.7.1](https://github.com/openai/openai-java/compare/v0.7.0...v0.7.1)

### Chores

* **internal:** configure sonatype ([#30](https://github.com/openai/openai-java/issues/30)) ([5d7816a](https://github.com/openai/openai-java/commit/5d7816afb9cf70189aa04dfd18a8f77f25094dcf))

## 0.7.0 (2024-12-04)

Full Changelog: [v0.6.0...v0.7.0](https://github.com/openai/openai-java/compare/v0.6.0...v0.7.0)

### Features

* **api:** updates ([#29](https://github.com/openai/openai-java/issues/29)) ([a3122af](https://github.com/openai/openai-java/commit/a3122af22767760b4f73880815d138e7493e381c))


### Chores

* bump openapi url ([#28](https://github.com/openai/openai-java/issues/28)) ([24d8461](https://github.com/openai/openai-java/commit/24d8461a14cb0a5b831cd821a129f995a3988856))


### Documentation

* add missing parameter to code snippet ([#26](https://github.com/openai/openai-java/issues/26)) ([8e7421f](https://github.com/openai/openai-java/commit/8e7421faa2ef8a6fd17757080f49bb5e1c0606c3))

## 0.6.0 (2024-11-27)

Full Changelog: [v0.5.1...v0.6.0](https://github.com/openai/openai-java/compare/v0.5.1...v0.6.0)

### ⚠ BREAKING CHANGES

* **client:** remove duplicated classes

### Features

* derive gpg release key's id via gpg itself ([#25](https://github.com/openai/openai-java/issues/25)) ([6aad041](https://github.com/openai/openai-java/commit/6aad041b56bc39ee8e9c48e48738081652bf4ed2))


### Bug Fixes

* **client:** remove duplicated classes ([8a8f11f](https://github.com/openai/openai-java/commit/8a8f11fc20c415877f1f673ec0be3948126d1c11))

## 0.5.1 (2024-11-26)

Full Changelog: [v0.5.0...v0.5.1](https://github.com/openai/openai-java/compare/v0.5.0...v0.5.1)

### Chores

* **internal:** update example values ([#21](https://github.com/openai/openai-java/issues/21)) ([2270e67](https://github.com/openai/openai-java/commit/2270e676a013d9c00012757b86d9d86010c09a20))

## 0.5.0 (2024-11-25)

Full Changelog: [v0.4.0...v0.5.0](https://github.com/openai/openai-java/compare/v0.4.0...v0.5.0)

### Features

* **client:** add logging when debug env is set ([#18](https://github.com/openai/openai-java/issues/18)) ([017aae7](https://github.com/openai/openai-java/commit/017aae7a1795fe933e0ea9e8ee2c8d059c6746f4))


### Documentation

* add note that we're in alpha ([#19](https://github.com/openai/openai-java/issues/19)) ([d49cc28](https://github.com/openai/openai-java/commit/d49cc28f0a621df658a3c83a880735ebd7cc1acc))
* **readme:** add Microsoft Azure section ([#17](https://github.com/openai/openai-java/issues/17)) ([8f8165f](https://github.com/openai/openai-java/commit/8f8165fd33780e3ee0609df7e7e171c8e7f10029))
* swap example from `.completions()` to `.chat().completions()` ([#20](https://github.com/openai/openai-java/issues/20)) ([f0423a7](https://github.com/openai/openai-java/commit/f0423a7e9e20d5c1e528077fbb4e87baa822079a))


### Styles

* **internal:** reorder some params methods and improve consistency of implementations ([#15](https://github.com/openai/openai-java/issues/15)) ([8592cda](https://github.com/openai/openai-java/commit/8592cdad178325e3a8994ef44e854ee5b4853c45))

## 0.4.0 (2024-11-21)

Full Changelog: [v0.3.0...v0.4.0](https://github.com/openai/openai-java/compare/v0.3.0...v0.4.0)

### Features

* **azure:** Add HttpRequest.Builder extension methods ([#9](https://github.com/openai/openai-java/issues/9)) ([097c7c9](https://github.com/openai/openai-java/commit/097c7c91d23ff3bafdb4c01baea0df9beeadcd74))


### Bug Fixes

* **azure:** add missing azure changes ([656d3b5](https://github.com/openai/openai-java/commit/656d3b5a6d1c2d68733d5139d3a2982b04009f2a))

## 0.3.0 (2024-11-20)

Full Changelog: [v0.2.0...v0.3.0](https://github.com/openai/openai-java/compare/v0.2.0...v0.3.0)

### Features

* **api:** add gpt-4o-2024-11-20 model ([#13](https://github.com/openai/openai-java/issues/13)) ([3263126](https://github.com/openai/openai-java/commit/3263126a59cb63be0b6842fa16b0466feb71d44b))


### Styles

* **internal:** move identity methods to bottom of error class ([#12](https://github.com/openai/openai-java/issues/12)) ([f3ff42a](https://github.com/openai/openai-java/commit/f3ff42a3c4d3821949af7ad43e03dac8b061825b))
* **internal:** reduce verbosity of identity methods ([#10](https://github.com/openai/openai-java/issues/10)) ([9ef03ed](https://github.com/openai/openai-java/commit/9ef03eda541a878b4ef9df0c3845a63e1f9cc44d))

## 0.2.0 (2024-11-20)

Full Changelog: [v0.1.0...v0.2.0](https://github.com/openai/openai-java/compare/v0.1.0...v0.2.0)

### Features

* **client:** add async streaming methods ([#6](https://github.com/openai/openai-java/issues/6)) ([f805972](https://github.com/openai/openai-java/commit/f805972d9cafdf3ad8a974e660c62587e2b65c06))
* initial commit ([fa016ee](https://github.com/openai/openai-java/commit/fa016ee58dba10add81cefddbdf1483bfa24d058))


### Performance Improvements

* **tests:** remove unused dependencies ([#3](https://github.com/openai/openai-java/issues/3)) ([4c94984](https://github.com/openai/openai-java/commit/4c949841e4eed67b82bfe1f40370a0a3db8f2d43))


### Chores

* **deps:** bump jackson to 2.18.1 ([#7](https://github.com/openai/openai-java/issues/7)) ([9262ca7](https://github.com/openai/openai-java/commit/9262ca7a55c2bdb3dff69f9df328376e23bb11df))
* **internal:** spec update ([#5](https://github.com/openai/openai-java/issues/5)) ([0df36a4](https://github.com/openai/openai-java/commit/0df36a497f88407e35ca79bacb72f30f2d1350da))


### Documentation

* bump models in example snippets to gpt-4o ([#4](https://github.com/openai/openai-java/issues/4)) ([359c100](https://github.com/openai/openai-java/commit/359c10065f9615a73e30573b1dea80d5027288a6))

## 0.1.0 (2024-11-08)

Full Changelog: [v0.0.1...v0.1.0](https://github.com/openai/openai-java/compare/v0.0.1...v0.1.0)

### ⚠ BREAKING CHANGES

* **client:** simplify structure of strings with presets
* **client:** replace multimaps with custom types
* **client:** add/rename methods for headers/query params
* **client:** rename header and query params builder methods
* **client:** union and builder method naming conflicts
* **client:** don't generate default variant field/method names with underscores

### Features

* add example ([ff05dec](https://github.com/openai/openai-java/commit/ff05dec4c50a23498218ad1b3f7850aaf59e3998))
* add SSE and many other major updates ([6eb3f62](https://github.com/openai/openai-java/commit/6eb3f62e530d5b98e1a46164a680798d1c4299db))
* **api:** add chatgpt-4o-latest model ([f0d7c9a](https://github.com/openai/openai-java/commit/f0d7c9ae3c51c85ede0b34b59c5f43270b4d907b))
* **api:** add file search result details to run steps ([9ec089e](https://github.com/openai/openai-java/commit/9ec089e418ab71c19368c70a671fbef7fd3a9365))
* **api:** add gpt-4o-audio-preview model for chat completions ([e81ac84](https://github.com/openai/openai-java/commit/e81ac8426a0d84fa52028bd6ee3daa54695945e5))
* **api:** add new gpt-4o-mini models ([a5a855e](https://github.com/openai/openai-java/commit/a5a855e85ded4f483506f4d35aeef8aee43a3adc))
* **api:** add new, expressive voices for Realtime and Audio in Chat Completions ([c4d5fbd](https://github.com/openai/openai-java/commit/c4d5fbd7707d1b1cd13a72b13c48a767f0fd95b1))
* **api:** add o1 models ([b9db26a](https://github.com/openai/openai-java/commit/b9db26a0d021be09a4b201ba15570e049cb2939f))
* **api:** add omni-moderation model ([5935c8c](https://github.com/openai/openai-java/commit/5935c8c91cfdb22f0d204f4a11541201657bcf65))
* **api:** add support for predicted outputs ([a72d1ea](https://github.com/openai/openai-java/commit/a72d1eacfdd66d2e7ae43d345fc6d5c08ed45bcf))
* **api:** add uploads endpoints ([9963139](https://github.com/openai/openai-java/commit/996313982969078f06f9af393dfb4c2f28dced76))
* **api:** support storing chat completions, enabling evals and model distillation in the dashboard ([670e73f](https://github.com/openai/openai-java/commit/670e73f06813b9b56e424dafb98fec6d3a5249d2))
* **api:** updates ([c818fda](https://github.com/openai/openai-java/commit/c818fda81b7919c6f253046252913920d827c2c3))
* **client:** add `Headers` class ([339e93c](https://github.com/openai/openai-java/commit/339e93c34e573b114f2eee15f57b1baa42987d89))
* **client:** add `Headers` class ([02b56b3](https://github.com/openai/openai-java/commit/02b56b36df73fe9678453af31fbd75e02f7d59bc))
* **client:** add `QueryParams` class ([bf7b4a2](https://github.com/openai/openai-java/commit/bf7b4a2115acac93c0b13b0d85187ef06179263a))
* **client:** add `User-Agent` header ([5bab5cc](https://github.com/openai/openai-java/commit/5bab5cc526b2781d1a4c6775803fc9ebe83e4ced))
* **client:** add more endpoints ([48a86ca](https://github.com/openai/openai-java/commit/48a86caae55cafff11f162c0aef66801b04c6036))
* **client:** add streaming ([e8fc6aa](https://github.com/openai/openai-java/commit/e8fc6aa620dddcde92a5aaedb7aa90ae1b3ac852))
* **client:** add/rename methods for headers/query params ([80ca5d9](https://github.com/openai/openai-java/commit/80ca5d90b7295388a1e9db40b9dd57ceaca2e579))
* **client:** added structured fields to errors ([ffc1d7a](https://github.com/openai/openai-java/commit/ffc1d7aff146e486fa307e60b39fe38f26cb6a57))
* **client:** clean up resource leaks when the resource becomes phantom reachable ([3ab123c](https://github.com/openai/openai-java/commit/3ab123c55f24d59174f89ec5e2d3fc05656ae574))
* **client:** improve binary return values ([40e6b7c](https://github.com/openai/openai-java/commit/40e6b7cd2576956d802422f052b7acf038134d27))
* **client:** more additional body param setters ([07262da](https://github.com/openai/openai-java/commit/07262daa6840d39e87fd83e71fa95a89830175f1))
* **client:** propagate headers/query params methods to client builders ([ed455e3](https://github.com/openai/openai-java/commit/ed455e353ac3b6b8fbedffeb3f6d9bc0521b2d81))
* **client:** replace multimaps with custom types ([c92580f](https://github.com/openai/openai-java/commit/c92580fdee8777878f7cfa39aabfa91cfdd6d123))
* **client:** send retry count header ([8058647](https://github.com/openai/openai-java/commit/8058647cf019c5c8721cdc11e482990d54a27d29))
* **client:** set `X-Stainless-Runtime` header ([1576020](https://github.com/openai/openai-java/commit/157602059951cb48b1a8128650d6d47135a221c0))
* **client:** simplify structure of strings with presets ([c6f3499](https://github.com/openai/openai-java/commit/c6f349985ec2e9a4e50d558aa0dc9e286beec606))
* **client:** support error property ([aef3473](https://github.com/openai/openai-java/commit/aef347380dcd087c9186751d0cb85075d557bb81))
* **client:** support union discriminators in deserialization ([fd0e4bd](https://github.com/openai/openai-java/commit/fd0e4bddc34d7f8080d58b6b184876defe43295e))
* extract out `ImageModel`, `AudioModel`, `SpeechModel` ([7c23848](https://github.com/openai/openai-java/commit/7c23848e3b1b6ad8285a2681690463c96ccbd568))
* make enums not nominal ([dce0b9e](https://github.com/openai/openai-java/commit/dce0b9e8e306d67d4dd80f96c9a5ae49c0490eb2))
* updates ([4fbb12b](https://github.com/openai/openai-java/commit/4fbb12ba26202ec7ce987cc6e526ae37ad317e7d))
* updates ([303b5f2](https://github.com/openai/openai-java/commit/303b5f2597ec12e3d42d5d2e99a8dd6cebe1e443))
* updates ([#4](https://github.com/openai/openai-java/issues/4)) ([af9f9a2](https://github.com/openai/openai-java/commit/af9f9a2718b2710e0a0e0c514600e3833c1274d3))
* **vector store:** improve chunking strategy type names ([1e5d0cd](https://github.com/openai/openai-java/commit/1e5d0cd558b977710779816931c0ebe73630c7cc))


### Bug Fixes

* **audio:** correct response_format translations type ([f84b960](https://github.com/openai/openai-java/commit/f84b960b3f16381339d9f0aea31efcae7967743c))
* **client:** accidental double-wrapping with `RetryingHttpClient` ([c96911b](https://github.com/openai/openai-java/commit/c96911bcf018c6092e8418f004eaae7edceb7373))
* **client:** add `@JvmOverloads` to `HttpClient` methods ([95344ef](https://github.com/openai/openai-java/commit/95344ef8e6a2cc4ebe66ad055cd40d5a626ea122))
* **client:** correct types for transcriptions / translations ([5207123](https://github.com/openai/openai-java/commit/520712379713a5584b1e1e19ed1f558e11296c8c))
* **client:** disallow reusing stream response ([6eb1979](https://github.com/openai/openai-java/commit/6eb197996ddf43c8c83178a9991e179f4dd6ffb3))
* **client:** don't generate default variant field/method names with underscores ([c49334f](https://github.com/openai/openai-java/commit/c49334f0afe7dd14294057ab89caee5a6033a24d))
* **client:** ensure constructed objects are immutable ([ef4d884](https://github.com/openai/openai-java/commit/ef4d884b2a588ef4783715f9892e166884de2b98))
* **client:** ensure SSE `BufferedReader` gets closed ([685553f](https://github.com/openai/openai-java/commit/685553fe2baeb2aa5910420f91e52dd7f1d2ca43))
* **client:** error class `toBuilder` not copying fields ([92b5889](https://github.com/openai/openai-java/commit/92b5889eae621f3a0631baf267728bea6f76ebb8))
* **client:** escape keywords reserved in java, but not in kotlin, for the java sdk ([12e0cc6](https://github.com/openai/openai-java/commit/12e0cc6779a068ff4ebddd9c24b61ee4c4e2e6d3))
* **client:** implement `hashCode` for `IsMissing` ([b841254](https://github.com/openai/openai-java/commit/b84125494eaddec9be09fb99565e08a37e642ae5))
* **client:** naming of some variants ([3a764f2](https://github.com/openai/openai-java/commit/3a764f217901daff48327bbc420a3240b89c58ed))
* **client:** naming of some variants ([881affb](https://github.com/openai/openai-java/commit/881affb889a401935e654c21b58fbf32623c4aca))
* **client:** union and builder method naming conflicts ([3566be1](https://github.com/openai/openai-java/commit/3566be107efe17b175078a8263323e8fda46f77f))
* **docs:** use correct putAdditionalProperty value ([babeb82](https://github.com/openai/openai-java/commit/babeb8279765a9cb723504bb7fa90cf3583e8574))
* example for preset simplification ([#150](https://github.com/openai/openai-java/issues/150)) ([1c63b4b](https://github.com/openai/openai-java/commit/1c63b4bfeef3ee7da7503b90695c925268b055f0))
* improve schema definitions ([6beee8a](https://github.com/openai/openai-java/commit/6beee8a45a0a4d223a79d65f9109a85717c62509))
* **internal:** remove unnecessary error handler in client ([fe5be51](https://github.com/openai/openai-java/commit/fe5be514a8376791f845135cdd0ba8f3526c6056))
* **internal:** remove unnecessary error handlers ([205ee00](https://github.com/openai/openai-java/commit/205ee00386acea1d9d3fea5ca8daadaa7d1fb153))
* remove additionalBodyProperties from methods that don't support request bodies ([df81636](https://github.com/openai/openai-java/commit/df81636724f6cc92415ea6943f488e1f6e0c56af))


### Chores

* **ci:** bump prism mock server version ([16fcad2](https://github.com/openai/openai-java/commit/16fcad24cc484d1547c9d2bb94a77deb61b623ed))
* **ci:** codeowners file ([0e29d12](https://github.com/openai/openai-java/commit/0e29d123be1658404828bbffa7b35a1501031f6d))
* **ci:** run tests in CI ([7a8cd60](https://github.com/openai/openai-java/commit/7a8cd60add562cc099d4c44ea22f512d60a9ffd6))
* **docs:** fix maxium typo ([c6258a2](https://github.com/openai/openai-java/commit/c6258a2f74aefbd97a0c43f5ca8fd4999d6c3475))
* **internal:** delete unused function ([54eb041](https://github.com/openai/openai-java/commit/54eb0415e37598ed9b17f0d6fd3ec8d51f330b9e))
* **internal:** omit unnecessary code ([e87d4ec](https://github.com/openai/openai-java/commit/e87d4eca8b4de770f7055ee6242666c32421ab3f))
* **internal:** remove unnecessary `.buffered()` call ([2e43707](https://github.com/openai/openai-java/commit/2e4370738232c796d370988e95ed6a99e5fe1ad3))
* **internal:** remove unnecessary `[@file](https://github.com/file):Suppress("OVERLOADS_INTERFACE")` ([0c219ed](https://github.com/openai/openai-java/commit/0c219edda523212d2460df8360ccd79763442e0d))
* **internal:** remove unnecessary `[@file](https://github.com/file):Suppress("OVERLOADS_INTERFACE")` ([fbf13e1](https://github.com/openai/openai-java/commit/fbf13e114830c38de0652db237066ea9f9923fa9))
* **internal:** remove unnecessary `[@file](https://github.com/file):Suppress("OVERLOADS_INTERFACE")` ([b8ab775](https://github.com/openai/openai-java/commit/b8ab7759736a611eceb0717e7a459386a9246d5e))
* **internal:** remove unused test file ([24d08bb](https://github.com/openai/openai-java/commit/24d08bb4e10bce76c9b9cc2dd69a2acf89ee1335))
* **internal:** remove useless `[@file](https://github.com/file):JvmSynthetic` ([046092d](https://github.com/openai/openai-java/commit/046092d8b8fc67bf2a2c267b9559be767174c0af))
* **internal:** update spec link ([a3b99f8](https://github.com/openai/openai-java/commit/a3b99f80f03d2b262e0a2d466c9ceef1efbe5cbe))
* **internal:** update spec url ([6d8a32d](https://github.com/openai/openai-java/commit/6d8a32d32396bec8941a8f4a021d593a9bf6613e))
* sync openapi url ([1868ddd](https://github.com/openai/openai-java/commit/1868ddd67b3735fd46d9c236e468771532d9865d))
* **tests:** add tests for services ([c58ba71](https://github.com/openai/openai-java/commit/c58ba718a77ab92724ee1e30576fe045b264925a))
* **tests:** update prism version ([f7cb198](https://github.com/openai/openai-java/commit/f7cb19834c7fb1a89d1a5a34241037f95433d683))
* **types:** define FilePurpose enum ([e2c15b1](https://github.com/openai/openai-java/commit/e2c15b12f2c0e3bb91b0cc4287676c4223980514))
* unknown commit message ([6eb1979](https://github.com/openai/openai-java/commit/6eb197996ddf43c8c83178a9991e179f4dd6ffb3))
* unknown commit message ([c6f3499](https://github.com/openai/openai-java/commit/c6f349985ec2e9a4e50d558aa0dc9e286beec606))
* unknown commit message ([92b5889](https://github.com/openai/openai-java/commit/92b5889eae621f3a0631baf267728bea6f76ebb8))
* unknown commit message ([07262da](https://github.com/openai/openai-java/commit/07262daa6840d39e87fd83e71fa95a89830175f1))
* unknown commit message ([c92580f](https://github.com/openai/openai-java/commit/c92580fdee8777878f7cfa39aabfa91cfdd6d123))
* unknown commit message ([c6089f1](https://github.com/openai/openai-java/commit/c6089f14f4317f224de4996d0e0c59042c733738))
* unknown commit message ([a72d1ea](https://github.com/openai/openai-java/commit/a72d1eacfdd66d2e7ae43d345fc6d5c08ed45bcf))
* unknown commit message ([80ca5d9](https://github.com/openai/openai-java/commit/80ca5d90b7295388a1e9db40b9dd57ceaca2e579))
* unknown commit message ([4fd6c23](https://github.com/openai/openai-java/commit/4fd6c23c05fe8f16bd9648f2bb2db81e4ffa7b7c))
* unknown commit message ([ed455e3](https://github.com/openai/openai-java/commit/ed455e353ac3b6b8fbedffeb3f6d9bc0521b2d81))
* unknown commit message ([bf7b4a2](https://github.com/openai/openai-java/commit/bf7b4a2115acac93c0b13b0d85187ef06179263a))
* unknown commit message ([02b56b3](https://github.com/openai/openai-java/commit/02b56b36df73fe9678453af31fbd75e02f7d59bc))
* unknown commit message ([93141d4](https://github.com/openai/openai-java/commit/93141d47a05c71148459877d0baee76ae1a6e2f8))
* unknown commit message ([ef4d884](https://github.com/openai/openai-java/commit/ef4d884b2a588ef4783715f9892e166884de2b98))
* unknown commit message ([505c349](https://github.com/openai/openai-java/commit/505c349f3aa299235437ce1e836ce7249db3e082))
* unknown commit message ([54eb041](https://github.com/openai/openai-java/commit/54eb0415e37598ed9b17f0d6fd3ec8d51f330b9e))
* unknown commit message ([44ab47a](https://github.com/openai/openai-java/commit/44ab47af71058241516a6998c0fcfc9e84db7074))
* unknown commit message ([c4d5fbd](https://github.com/openai/openai-java/commit/c4d5fbd7707d1b1cd13a72b13c48a767f0fd95b1))
* unknown commit message ([3ab123c](https://github.com/openai/openai-java/commit/3ab123c55f24d59174f89ec5e2d3fc05656ae574))
* unknown commit message ([685553f](https://github.com/openai/openai-java/commit/685553fe2baeb2aa5910420f91e52dd7f1d2ca43))
* unknown commit message ([d86694a](https://github.com/openai/openai-java/commit/d86694a85e2afb3179970e8e269f4e8c5c4f4801))
* unknown commit message ([2e43707](https://github.com/openai/openai-java/commit/2e4370738232c796d370988e95ed6a99e5fe1ad3))
* unknown commit message ([c96911b](https://github.com/openai/openai-java/commit/c96911bcf018c6092e8418f004eaae7edceb7373))
* unknown commit message ([5bab5cc](https://github.com/openai/openai-java/commit/5bab5cc526b2781d1a4c6775803fc9ebe83e4ced))
* unknown commit message ([1576020](https://github.com/openai/openai-java/commit/157602059951cb48b1a8128650d6d47135a221c0))
* unknown commit message ([48a86ca](https://github.com/openai/openai-java/commit/48a86caae55cafff11f162c0aef66801b04c6036))
* unknown commit message ([b841254](https://github.com/openai/openai-java/commit/b84125494eaddec9be09fb99565e08a37e642ae5))
* unknown commit message ([aef3473](https://github.com/openai/openai-java/commit/aef347380dcd087c9186751d0cb85075d557bb81))
* unknown commit message ([734939c](https://github.com/openai/openai-java/commit/734939c9668d8a431d1554752e1fe48a77180166))
* unknown commit message ([95344ef](https://github.com/openai/openai-java/commit/95344ef8e6a2cc4ebe66ad055cd40d5a626ea122))
* unknown commit message ([0c219ed](https://github.com/openai/openai-java/commit/0c219edda523212d2460df8360ccd79763442e0d))
* unknown commit message ([046092d](https://github.com/openai/openai-java/commit/046092d8b8fc67bf2a2c267b9559be767174c0af))
* unknown commit message ([f0bc243](https://github.com/openai/openai-java/commit/f0bc243a7836cdf17c479ac569c102fbc361de6d))
* unknown commit message ([86e3988](https://github.com/openai/openai-java/commit/86e39880b82056625a3b91a5412b7b298777a54f))
* unknown commit message ([b8ab775](https://github.com/openai/openai-java/commit/b8ab7759736a611eceb0717e7a459386a9246d5e))
* unknown commit message ([2d98a2c](https://github.com/openai/openai-java/commit/2d98a2cc9298d35195569b391e6bead608cf9ad6))
* unknown commit message ([c58ba71](https://github.com/openai/openai-java/commit/c58ba718a77ab92724ee1e30576fe045b264925a))
* unknown commit message ([881affb](https://github.com/openai/openai-java/commit/881affb889a401935e654c21b58fbf32623c4aca))
* unknown commit message ([0b8b5a8](https://github.com/openai/openai-java/commit/0b8b5a8d01b40eab8c4ad106fa921011490fc1a0))
* unknown commit message ([a804776](https://github.com/openai/openai-java/commit/a804776306e32cea48ac739506d5abfa940fb528))
* unknown commit message ([e8fc6aa](https://github.com/openai/openai-java/commit/e8fc6aa620dddcde92a5aaedb7aa90ae1b3ac852))
* unknown commit message ([fd0e4bd](https://github.com/openai/openai-java/commit/fd0e4bddc34d7f8080d58b6b184876defe43295e))
* unknown commit message ([3566be1](https://github.com/openai/openai-java/commit/3566be107efe17b175078a8263323e8fda46f77f))
* unknown commit message ([fe5be51](https://github.com/openai/openai-java/commit/fe5be514a8376791f845135cdd0ba8f3526c6056))
* unknown commit message ([205ee00](https://github.com/openai/openai-java/commit/205ee00386acea1d9d3fea5ca8daadaa7d1fb153))
* unknown commit message ([e87d4ec](https://github.com/openai/openai-java/commit/e87d4eca8b4de770f7055ee6242666c32421ab3f))
* unknown commit message ([b8509fb](https://github.com/openai/openai-java/commit/b8509fb3e890fb04169e38eed53ae53e065e285c))
* unknown commit message ([f8eceaa](https://github.com/openai/openai-java/commit/f8eceaac33a5e7ff8c1b6709a340cdfd4340f7b9))
* unknown commit message ([3989402](https://github.com/openai/openai-java/commit/3989402436c2861ff3bfeba3ca9acb42dbabf97c))
* unknown commit message ([c49334f](https://github.com/openai/openai-java/commit/c49334f0afe7dd14294057ab89caee5a6033a24d))
* unknown commit message ([c6e40de](https://github.com/openai/openai-java/commit/c6e40de655bd30d0b1f14e3af1fd1ff1dfed89ae))
* unknown commit message ([12e0cc6](https://github.com/openai/openai-java/commit/12e0cc6779a068ff4ebddd9c24b61ee4c4e2e6d3))
* unknown commit message ([9ec34a8](https://github.com/openai/openai-java/commit/9ec34a8db82f710beff43591dbf1e6e74b87346e))
* unknown commit message ([670e73f](https://github.com/openai/openai-java/commit/670e73f06813b9b56e424dafb98fec6d3a5249d2))
* unknown commit message ([5207123](https://github.com/openai/openai-java/commit/520712379713a5584b1e1e19ed1f558e11296c8c))
* unknown commit message ([8058647](https://github.com/openai/openai-java/commit/8058647cf019c5c8721cdc11e482990d54a27d29))
* unknown commit message ([6d8a32d](https://github.com/openai/openai-java/commit/6d8a32d32396bec8941a8f4a021d593a9bf6613e))
* unknown commit message ([b9db26a](https://github.com/openai/openai-java/commit/b9db26a0d021be09a4b201ba15570e049cb2939f))
* unknown commit message ([ffc1d7a](https://github.com/openai/openai-java/commit/ffc1d7aff146e486fa307e60b39fe38f26cb6a57))
* unknown commit message ([5d05171](https://github.com/openai/openai-java/commit/5d0517135e5d2b404e81fad598865df188aaed57))
* unknown commit message ([1e5d0cd](https://github.com/openai/openai-java/commit/1e5d0cd558b977710779816931c0ebe73630c7cc))
* unknown commit message ([b72a723](https://github.com/openai/openai-java/commit/b72a7235865640e600ebaa3c8a739392c24c944d))
* unknown commit message ([df81636](https://github.com/openai/openai-java/commit/df81636724f6cc92415ea6943f488e1f6e0c56af))
* unknown commit message ([babeb82](https://github.com/openai/openai-java/commit/babeb8279765a9cb723504bb7fa90cf3583e8574))
* unknown commit message ([e2c15b1](https://github.com/openai/openai-java/commit/e2c15b12f2c0e3bb91b0cc4287676c4223980514))
* unknown commit message ([1868ddd](https://github.com/openai/openai-java/commit/1868ddd67b3735fd46d9c236e468771532d9865d))
* unknown commit message ([16fcad2](https://github.com/openai/openai-java/commit/16fcad24cc484d1547c9d2bb94a77deb61b623ed))
* unknown commit message ([0e29d12](https://github.com/openai/openai-java/commit/0e29d123be1658404828bbffa7b35a1501031f6d))
* unknown commit message ([c818fda](https://github.com/openai/openai-java/commit/c818fda81b7919c6f253046252913920d827c2c3))
* unknown commit message ([dce0b9e](https://github.com/openai/openai-java/commit/dce0b9e8e306d67d4dd80f96c9a5ae49c0490eb2))
* unknown commit message ([7c23848](https://github.com/openai/openai-java/commit/7c23848e3b1b6ad8285a2681690463c96ccbd568))
* unknown commit message ([7a8cd60](https://github.com/openai/openai-java/commit/7a8cd60add562cc099d4c44ea22f512d60a9ffd6))
* unknown commit message ([40e6b7c](https://github.com/openai/openai-java/commit/40e6b7cd2576956d802422f052b7acf038134d27))
* unknown commit message ([24d08bb](https://github.com/openai/openai-java/commit/24d08bb4e10bce76c9b9cc2dd69a2acf89ee1335))
* unknown commit message ([f7cb198](https://github.com/openai/openai-java/commit/f7cb19834c7fb1a89d1a5a34241037f95433d683))
* unknown commit message ([a5a855e](https://github.com/openai/openai-java/commit/a5a855e85ded4f483506f4d35aeef8aee43a3adc))
* unknown commit message ([303b5f2](https://github.com/openai/openai-java/commit/303b5f2597ec12e3d42d5d2e99a8dd6cebe1e443))
* update repo name ([11c62f2](https://github.com/openai/openai-java/commit/11c62f225705c5314cb4044f9a0ac2dfa878ee14))
* use headless jdk for containers ([b72a723](https://github.com/openai/openai-java/commit/b72a7235865640e600ebaa3c8a739392c24c944d))


### Documentation

* adjust additional properties example ([5d05171](https://github.com/openai/openai-java/commit/5d0517135e5d2b404e81fad598865df188aaed57))


### Styles

* **client:** disable formatting for java boilerplate ([c6e40de](https://github.com/openai/openai-java/commit/c6e40de655bd30d0b1f14e3af1fd1ff1dfed89ae))
* **client:** make toString methods consistent ([0b8b5a8](https://github.com/openai/openai-java/commit/0b8b5a8d01b40eab8c4ad106fa921011490fc1a0))
* **client:** move equals, hashCode, and toString to the bottom of entity files ([9ec34a8](https://github.com/openai/openai-java/commit/9ec34a8db82f710beff43591dbf1e6e74b87346e))
* **internal:** improve `OkHttpClient` formatting ([70f673c](https://github.com/openai/openai-java/commit/70f673cc64082ee7218377dc3439cc1aef404aa3))
* **internal:** improve `OkHttpClient` formatting ([86e3988](https://github.com/openai/openai-java/commit/86e39880b82056625a3b91a5412b7b298777a54f))
* **internal:** improve `RetryingHttpClient` formatting ([734939c](https://github.com/openai/openai-java/commit/734939c9668d8a431d1554752e1fe48a77180166))
* **internal:** improve terseness of handlers ([3989402](https://github.com/openai/openai-java/commit/3989402436c2861ff3bfeba3ca9acb42dbabf97c))
* **internal:** improve terseness of Properties.kt ([f8eceaa](https://github.com/openai/openai-java/commit/f8eceaac33a5e7ff8c1b6709a340cdfd4340f7b9))
* **internal:** make `getOrThrow` terse and consistent ([44ab47a](https://github.com/openai/openai-java/commit/44ab47af71058241516a6998c0fcfc9e84db7074))
* **internal:** move Handlers.kt and HttpRequestBodies.kt to core ([b8509fb](https://github.com/openai/openai-java/commit/b8509fb3e890fb04169e38eed53ae53e065e285c))
* **internal:** rename `streamingResponse` to `streamResponse` ([d86694a](https://github.com/openai/openai-java/commit/d86694a85e2afb3179970e8e269f4e8c5c4f4801))
* **internal:** simplify client build method ([f0bc243](https://github.com/openai/openai-java/commit/f0bc243a7836cdf17c479ac569c102fbc361de6d))
* **internal:** update comment formatting ([2d98a2c](https://github.com/openai/openai-java/commit/2d98a2cc9298d35195569b391e6bead608cf9ad6))
* **internal:** use `if` and `if-else` instead of `when` idiomatically ([a804776](https://github.com/openai/openai-java/commit/a804776306e32cea48ac739506d5abfa940fb528))


### Refactors

* **client:** http request methods ([c6089f1](https://github.com/openai/openai-java/commit/c6089f14f4317f224de4996d0e0c59042c733738))
* **client:** rename header and query params builder methods ([4fd6c23](https://github.com/openai/openai-java/commit/4fd6c23c05fe8f16bd9648f2bb2db81e4ffa7b7c))
* **internal:** inline `MoreExecutors` usage ([505c349](https://github.com/openai/openai-java/commit/505c349f3aa299235437ce1e836ce7249db3e082))
* **internal:** polish `ClientOptions` ([13c9038](https://github.com/openai/openai-java/commit/13c90382eb033c19724039f8bf143757f38f5df0))
* **internal:** polish `ClientOptions` ([93141d4](https://github.com/openai/openai-java/commit/93141d47a05c71148459877d0baee76ae1a6e2f8))
