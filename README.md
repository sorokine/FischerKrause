Fischer-Krause ordered permutation generator.
=============================================

This is a Java implementation of Fischer-Krause ordered permutation 
algorithm.  The code was ported from perlfaq4 (http://perldoc.perl.org/perlfaq4.html#How-do-I-permute-N-elements-of-a-list%3f). 
See javadoc for details.

Usage example:
--------------

    	public static void main(String[] argv) {
		
		for (FischerKrause fk = new FischerKrause(argv.length); fk.hasNext(); ) {
			int idx[] = fk.next();
			System.out.print(Arrays.toString(idx) + " =>");
			for (int i = 0; i < idx.length; i++) {
				System.out.print(" "+argv[idx[i]]);
			}
			System.out.println();
		}

Running the class as
    
    java info.sorokine.utils.FischerKrause a b c d e
    
will result in the following output:

    [0, 1, 2, 3, 4] => a b c d e
    [0, 1, 2, 4, 3] => a b c e d
    [0, 1, 3, 2, 4] => a b d c e
    [0, 1, 3, 4, 2] => a b d e c
    [0, 1, 4, 2, 3] => a b e c d
    [0, 1, 4, 3, 2] => a b e d c
    [0, 2, 1, 3, 4] => a c b d e
    [0, 2, 1, 4, 3] => a c b e d
    [0, 2, 3, 1, 4] => a c d b e
    [0, 2, 3, 4, 1] => a c d e b
    [0, 2, 4, 1, 3] => a c e b d
    [0, 2, 4, 3, 1] => a c e d b
    [0, 3, 1, 2, 4] => a d b c e
    [0, 3, 1, 4, 2] => a d b e c
    [0, 3, 2, 1, 4] => a d c b e
    [0, 3, 2, 4, 1] => a d c e b
    [0, 3, 4, 1, 2] => a d e b c
    [0, 3, 4, 2, 1] => a d e c b
    [0, 4, 1, 2, 3] => a e b c d
    [0, 4, 1, 3, 2] => a e b d c
    [0, 4, 2, 1, 3] => a e c b d
    [0, 4, 2, 3, 1] => a e c d b
    [0, 4, 3, 1, 2] => a e d b c
    [0, 4, 3, 2, 1] => a e d c b
    [1, 0, 3, 2, 4] => b a d c e
    [1, 0, 3, 4, 2] => b a d e c
    [1, 0, 4, 2, 3] => b a e c d
	[1, 0, 4, 3, 2] => b a e d c
	[1, 2, 0, 3, 4] => b c a d e
	[1, 2, 0, 4, 3] => b c a e d
	[1, 2, 3, 0, 4] => b c d a e
	[1, 2, 3, 4, 0] => b c d e a
	[1, 2, 4, 0, 3] => b c e a d
	[1, 2, 4, 3, 0] => b c e d a
	[1, 3, 0, 2, 4] => b d a c e
	[1, 3, 0, 4, 2] => b d a e c
	[1, 3, 2, 0, 4] => b d c a e
	[1, 3, 2, 4, 0] => b d c e a
	[1, 3, 4, 0, 2] => b d e a c
	[1, 3, 4, 2, 0] => b d e c a
	[1, 4, 0, 2, 3] => b e a c d
	[1, 4, 0, 3, 2] => b e a d c
	[1, 4, 2, 0, 3] => b e c a d
	[1, 4, 2, 3, 0] => b e c d a
	[1, 4, 3, 0, 2] => b e d a c
	[1, 4, 3, 2, 0] => b e d c a
	[3, 0, 1, 2, 4] => d a b c e
	[3, 0, 1, 4, 2] => d a b e c
	[3, 0, 2, 1, 4] => d a c b e
	[3, 0, 2, 4, 1] => d a c e b
	[3, 0, 4, 1, 2] => d a e b c
	[3, 0, 4, 2, 1] => d a e c b
	[3, 1, 0, 2, 4] => d b a c e
	[3, 1, 0, 4, 2] => d b a e c
	[3, 1, 2, 0, 4] => d b c a e
	[3, 1, 2, 4, 0] => d b c e a
	[3, 1, 4, 0, 2] => d b e a c
	[3, 1, 4, 2, 0] => d b e c a
	[3, 2, 0, 1, 4] => d c a b e
	[3, 2, 0, 4, 1] => d c a e b
	[3, 2, 1, 0, 4] => d c b a e
	[3, 2, 1, 4, 0] => d c b e a
	[3, 2, 4, 0, 1] => d c e a b
	[3, 2, 4, 1, 0] => d c e b a
	[3, 4, 0, 1, 2] => d e a b c
	[3, 4, 0, 2, 1] => d e a c b
	[3, 4, 1, 0, 2] => d e b a c
	[3, 4, 1, 2, 0] => d e b c a
	[3, 4, 2, 0, 1] => d e c a b
	[3, 4, 2, 1, 0] => d e c b a
	[4, 0, 2, 1, 3] => e a c b d
	[4, 0, 2, 3, 1] => e a c d b
	[4, 0, 3, 1, 2] => e a d b c
	[4, 0, 3, 2, 1] => e a d c b
	[4, 1, 0, 2, 3] => e b a c d
	[4, 1, 0, 3, 2] => e b a d c
	[4, 1, 2, 0, 3] => e b c a d
	[4, 1, 2, 3, 0] => e b c d a
	[4, 1, 3, 0, 2] => e b d a c
	[4, 1, 3, 2, 0] => e b d c a
	[4, 2, 0, 1, 3] => e c a b d
	[4, 2, 0, 3, 1] => e c a d b
	[4, 2, 1, 0, 3] => e c b a d
	[4, 2, 1, 3, 0] => e c b d a
	[4, 2, 3, 0, 1] => e c d a b
	[4, 2, 3, 1, 0] => e c d b a
	[4, 3, 0, 1, 2] => e d a b c
	[4, 3, 0, 2, 1] => e d a c b
	[4, 3, 1, 0, 2] => e d b a c
	[4, 3, 1, 2, 0] => e d b c a
	[4, 3, 2, 0, 1] => e d c a b
	[4, 3, 2, 1, 0] => e d c b a
    