# samflag

A CLI tool to decode SAM flags.

### Build
This is known to compile with `Scala 3.2`. To build, first make sure that `sbt` is installed; then run `sbt assembly` at the root of the repo. You should find the JAR file under `targets/scala-3.x.x/`.

### Example
```
~$ java -jar samflag.jar describe 99

  64    First in pair (0x40, 64)
  32    Mate reverse strand (0x20, 32)
  2     Read mapped in proper pair (0x2, 2)
  1     Read paired (0x1, 1)

```
or

```
~$ java -jar samflag.jar listflags

  2048  Supplementary alignment (0x800, 2048)
  1024  Read is PCR or optical duplicate (0x400, 1024)
  512   Read fails platform/vendor quality checks (0x200, 512)
  256   Not primary alignment (0x100, 256)
  128   Second in pair (0x80, 128)
  64    First in pair (0x40, 64)
  32    Mate reverse strand (0x20, 32)
  16    Read reverse strand (0x10, 16)
  8     Mate unmapped (0x8, 8)
  4     Read unmapped (0x4, 4)
  2     Read mapped in proper pair (0x2, 2)
  1     Read paired (0x1, 1)

```

### License
MIT
