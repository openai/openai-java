# JVM binary API comparison

Use this supplemental, conservative check before changing generated SDK APIs or
moving custom code into Castiron. It compares all declared public/protected JVM
classes, constructors, methods, and fields in a baseline JAR with a replacement
JAR. It reads class files without loading or executing their code and has no
third-party dependencies. Python 3.10+ is required.

```sh
python3 scripts/compatibility/check_binary_api.py \
  /path/to/previous/openai-java-core.jar \
  /path/to/proposed/openai-java-core.jar
```

Run separately for each published artifact containing classes (`openai-java-core`,
`openai-java-client-okhttp`, and `openai-java-bedrock`), using corresponding actual
release and proposed JARs. The aggregate `openai-java` artifact has no classes and
is not an input to this checker. Preserve artifact coordinates and dependency
compatibility separately. Inputs are local JARs; this tool downloads nothing.

Exit status is `0` for no detected changes, `1` for potential incompatibilities,
and `2` for unsupported, unreadable, malformed, or empty exported API inputs.
Findings are sorted and include exact JVM descriptors, including return types.
Do not treat an error or an unsupported input as a passing comparison.
Unsupported ZIP compression, encrypted class entries, and corrupt compressed data
(DEFLATE, BZIP2 or LZMA) are input errors (status `2`), with a diagnostic instead
of an uncaught traceback. Valid archives using these codecs remain supported
when their standard-library compression modules are available; LZMA is optional
and is not required to compare ordinary stored/DEFLATE JARs.

The comparison reports:

- Removal or narrowing of class/member visibility, including protected nested
  classes, and removal of public synthetic bridge methods.
- Method, constructor, and field descriptor changes (reported as removed old
  descriptors), and static/instance changes.
- Class/interface kind changes, superclass changes, direct interface changes,
  class modifier changes, increased class file versions (including preview
  minor versions), and members becoming final or abstract.
- New abstract methods on existing classes or interfaces, and interface default
  methods becoming abstract. Existing consumer implementations may lack a body
  for those methods.

This is a declared-surface comparison, not a complete JVM method resolution
implementation. Moving a method to a superclass or removing an abstract
declaration already inherited can produce conservative findings requiring review.
Every added direct interface is reported, including marker interfaces: an added
superinterface can impose abstract methods on previously compiled implementations,
and this tool does not resolve its inherited obligations.
Public/protected nested classes inside inaccessible outer classes are also
included conservatively. All public/protected JVM declarations are included,
even Kotlin `internal` declarations emitted as public bytecode.
For nested classes, visibility and static membership come from `InnerClasses`;
JVM modifiers such as final, abstract and interface remain authoritative in the
class header, including when a bytecode transformer leaves the attribute stale.

It does **not** prove compatibility of behavior, Java/Kotlin source, generics,
Kotlin metadata, nullability, checked exceptions, annotations, inlined constants,
serialization, reflection, dependency versions, JPMS, sealed classes, or
inherited/default-method conflict resolution. Multi-release and modular JARs
are rejected rather than partially checked. Class file parsing checks structure,
not all bytecode legality. Increased class file versions are conservative findings;
the supported runtime matrix remains authoritative. Keep the existing
`scripts/detect-breaking-changes` source compilation, runtime compatibility
fixtures, and behavior tests. This tool does not change CI or existing policy.

## Offline verification

Requires a JDK supporting `javac --release 8` (the development JDK 21 works):

```sh
python3 -m unittest discover -s scripts/compatibility -p 'test_*.py'
```

Fixtures compile synthetic APIs with `javac`, create JARs with Python's standard
library, and verify both additive and incompatible changes. Consumer fixtures
compile **only against the old JAR**, then run the unchanged consumers with
replacement JARs. They succeed for compatible replacements and reproduce
`NoSuchMethodError` for a changed return descriptor and `AbstractMethodError` for
an added superinterface obligation. The comparator reports both changes.
These fixtures validate detection of real linkage failures; they are not an old
SDK consumer suite. For an SDK migration, also run representative
consumers compiled against the selected release with the proposed SDK JARs and
their complete runtime dependencies, without recompiling the consumers.
