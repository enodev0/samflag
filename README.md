# samflag

This is my personal CLI tool to decode SAM flags.

### Usage
```bash
~$ samflag listflags                                                                                                                       22:14:50

1       Read paired (0x1, 1)
2       Read mapped in proper pair (0x2, 2)
4       Read unmapped (0x4, 4)
8       Mate unmapped (0x8, 8)
16      Read reverse strand (0x10, 16)
32      Mate reverse strand (0x20, 32)
64      First in pair (0x40, 64)
128     Second in pair (0x80, 128)
256     Not primary alignment (0x100, 256)
512     Read fails platform/vendor quality checks (0x200, 512)
1024    Read is PCR or optical duplicate (0x400, 1024)
2048    Supplementary alignment (0x800, 2048)

```
or 
```bash
~$ blast2gff convert crick alignment_reverse_strand.aln > crick.gff
```
we can then merge as follows
```bash
~$ blast2gff merge watson.gff crick.gff > transcript_annotation.gff
```

### License
MIT
