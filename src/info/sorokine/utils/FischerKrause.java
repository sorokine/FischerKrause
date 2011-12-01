/**
 * 
 */
package info.sorokine.utils;


import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Fischer-Krause ordered permutation generator.  
 * Ported to java from perfaq4.
 * 
 * @see http://perldoc.perl.org/perlfaq4.html#How-do-I-permute-N-elements-of-a-list%3f
 * @author Alex Sorokine <alex@sorokine.info>
 *
 */
public class FischerKrause {

	/**
	 * Array of indices, index variables
	 */
	int idx[], p, q;
	
	/**
	 * Creates a new permutation object for an array of size <i>size</i>.  
	 * Result of permutation is an array of indices ranging from 0 to <i>size</i>-1.
	 * 
	 * @param size size of the array to be permuted
	 */
	public FischerKrause(int size) {

		idx = new int[size];
		for (int i = 0; i < size; i++) {
			idx[i] = i;
		}
		
		p = q = 1;
	}
	
	/**
	 * Checks if any permutations left.
	 * @return true if any permutations left
	 */
	public boolean hasNext() {
		return p > 0;
	}

	/**
	 * Returns the a permutation and advances to the next one.
	 * 
	 * @return a new array containing current permutation
	 * @throws NoSuchElementException if no permutations left
	 */
	public int[] next() {
		
		if (!hasNext()) throw new NoSuchElementException("p="+p);
		
		//System.out.println("1*" + Arrays.toString(idx) + " p=" + p + " q=" + q);
		int res[] = idx.clone();
		
		p = idx.length - 1;
		while (p > 0 && idx[p-1] > idx[p]) { --p; } 
		
		if (p > 0) {
			q = p;
			
			// push @idx, reverse splice @idx, $p
			for (int i = p; i < idx.length - 1; i++) {
				swap_elements(idx, i, idx.length - 1 + p - i);
			}
			
			while (idx[p-1] > idx[q]) { ++q; } 
			
			// @idx[$p-1,$q]=@idx[$q,$p-1]
			for (int i = p-1; i < q; i++) {
				swap_elements(idx, i, q - i + p - 1);
			}
		}
		
		return res;
	}
	
	/**
	 * Usage example and test.
	 * @param args a list of arguments to be permuted
	 */
	public static void main(String[] argv) {
		
		for (FischerKrause fk = new FischerKrause(argv.length); fk.hasNext(); ) {
			int idx[] = fk.next();
			System.out.print(Arrays.toString(idx) + " =>");
			for (int i = 0; i < idx.length; i++) {
				System.out.print(" "+argv[idx[i]]);
			}
			System.out.println();
		}
		
	}

	/**
	 * Swaps two elements of an array.
	 * 
	 * @param ar array to work on
	 * @param e1 index of element one
	 * @param e2 index of element two
	 */
	private static void swap_elements(int ar[], int e1, int e2) {
		int b = ar[e1];
		ar[e1] = ar[e2];
		ar[e2] = b;
	}	
}
