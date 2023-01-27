/*
 * samflag.scala
 *
 * A SAM flag decoder
 *
 * License: MIT
 *
*/

import util.control.Breaks._

def samflag_decode(f: Int, K: List[Int]): Array[Int] = {
    var flag = f;

    var W = Array[Int]();

    if (K.contains(flag)) {
        W = W :+ flag;
        return W;
    }

    def floor_K(n: Int): Int = {
        var r = 0;
        breakable {
            for (i <- K) {
                if (i < n) {
                    r = i;
                    break;
                }
            }
        }
        return r;
    }

    breakable {
        while (true) {
            if(K.contains(flag)) {
                W = W :+ flag;
                break;
            }
            val x = floor_K(flag);
            W = W :+ x;
            flag = flag - x;
        }
    }
    return W;
}

def print_help(): Unit = {
        printf("\n");
        printf(" Usage:\n\n");
        printf("  ~$ java -jar samflag.jar listflags\n");
        printf("      or..\n");
        printf("  ~$ java -jar samflag.jar describe <flag>\n");
        printf("\n");
        System.exit(0);
}

@main
def main(args: String*): Unit = {

    val flagdef = scala.collection.mutable.Map (
        1 -> "Read paired (0x1, 1)",
        2 -> "Read mapped in proper pair (0x2, 2)",  // needs 1
        4 -> "Read unmapped (0x4, 4)",
        8 -> "Mate unmapped (0x8, 8)",  // needs 1
        16 -> "Read reverse strand (0x10, 16)",
        32 -> "Mate reverse strand (0x20, 32)",  // needs 1
        64 -> "First in pair (0x40, 64)",  // needs 1
        128 -> "Second in pair (0x80, 128)",  // needs 1
        256 -> "Not primary alignment (0x100, 256)",
        512 -> "Read fails platform/vendor quality checks (0x200, 512)",
        1024 -> "Read is PCR or optical duplicate (0x400, 1024)",
        2048 -> "Supplementary alignment (0x800, 2048)",
    );

    val flags = List(2048, 1024, 512, 256,128, 64, 32, 16, 8, 4, 2, 1);

    if ((args.length < 1) | (args.length > 2)) {
        print_help();
    }

    if (args(0) == "describe") {
        try {
            val decoded = samflag_decode(args(1).toInt, flags);
            printf("\n");
            for (f <- decoded) {
                printf("  %s\t%s\n", f, flagdef(f));
            }
            printf("\n");
        } catch {
            case _: Throwable => print_help();
        }
    } else if (args(0) == "listflags") {
        if (args.length != 1) {
            print_help();
        }
        printf("\n");
        for (f <- flags) {
            printf("  %s\t%s\n", f, flagdef(f));
        }
        printf("\n");
    } else {
        print_help();
    }
}
