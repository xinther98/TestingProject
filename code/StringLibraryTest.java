import static org.junit.Assert.*;  
import org.junit.Test;  

public class StringLibraryTest {
	public static StringLibrary sl = new StringLibrary();
	
	@Test
	public void reverseWordsTest() {
		String t1 = "the sky is blue";
		String o1 = "blue is sky the";
		String t2 = "  hello world  ";
		String o2 = "world hello";
		String t3 = "a good   example";
		String o3 = "example good a";

		assertEquals(o1, sl.reverseWords(t1));
		assertEquals(o2, sl.reverseWords(t2));
		assertEquals(o3, sl.reverseWords(t3));
	}

	@Test
	public void longestPalindromTest() {
		String t1 = "babad";
		String o1 = "aba";
		String t2 = "cbbd";
		String o2 = "bb";

		assertEquals(o1, sl.longestPalindrom(t1));
		assertEquals(o2, sl.longestPalindrom(t2));
	}

	@Test
	public void romanToIntTest() {
		String t1 = "III";
		int o1 = 3;
		String t2 = "LVIII";
		int o2 = 58;
		String t3 = "MCMXCIV";
		int o3 = 1994;

		assertEquals(o1, sl.romanToInt(t1));
		assertEquals(o2, sl.romanToInt(t2));
		assertEquals(o3, sl.romanToInt(t3));
	}

	@Test
	public void atoiTest() {
		String t1 = "42";
		int o1 = 42;
		String t2 = "   -42";
		int o2 = -42;
		String t3 = "4193 with words";
		int o3 = 4193;

		assertEquals(o1, sl.atoi(t1));
		assertEquals(o2, sl.atoi(t2));
		assertEquals(o3, sl.atoi(t3));
	}

	@Test
	public void longestCommonPrefixTest() {
		String[] t1 = {"flower","flow","flight"};
		String o1 = "fl";
		String[] t2 = {"dog","racecar","car"};
		String o2 = "";

		assertEquals(o1, sl.longestCommonPrefix(t1));
		assertEquals(o2, sl.longestCommonPrefix(t2));
	}

	@Test
	public void firstOccurenceTest() {
		String t1a = "heyhowarehoware";
		String t1b = "how";
		int o1 = 3;

		String t2a = "heyhowarehoware";
		String t2b = "hew";
		int o2 = -1;

		assertEquals(o1, sl.firstOccurence(t1a, t1b));
		assertEquals(o2, sl.firstOccurence(t2a, t2b));
	}

	@Test
	public void editDistanceTest() {
		String t1a = "horse";
		String t1b = "ros";
		int o1 = 3;

		String t2a = "intention";
		String t2b = "execution";
		int o2 = 5;

		assertEquals(o1, sl.editDistance(t1a, t1b));
		assertEquals(o2, sl.editDistance(t2a, t2b));
	}

	@Test
	public void longestCommonSubsequenceTest() {
		String t1a = "abcde";
		String t1b = "ace";
		int o1 = 3;

		String t2a = "abc";
		String t2b = "abc";
		int o2 = 3;

		String t3a = "abc";
		String t3b = "def";
		int o3 = 0;

		assertEquals(o1, sl.longestCommonSubsequence(t1a, t1b));
		assertEquals(o2, sl.longestCommonSubsequence(t2a, t2b));
		assertEquals(o3, sl.longestCommonSubsequence(t3a, t3b));
	}

	@Test
	public void palindromePartitioningTest() {
		String t1 = "BABABCBADCEDE";
		int o1 = 4;

		String t2a = "NITIN";
		int o2 = 0;

		String t3a = "ABBAC";
		int o3 = 1;

		assertEquals(o1, sl.palindromePartioning(t1));
		assertEquals(o2, sl.palindromePartioning(t2));
		assertEquals(o3, sl.palindromePartioning(t3));
	}
}