package com.iiitb.in;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringLibraryTest
{
    public static StringLibrary sl = new StringLibrary();

    @Test
    public void reverseWordsTest()
    {
        String t1 = "  this is programming   ";
        String o1 = "programming is this";
        String t2 = "h  ";
        String o2 = "h";
        String t3 = " hello how      are     you ";
        String o3 = "you are how hello";
        String t4 = "  this is a dog  ";
        String o4 = "dog a is this";
        String t5 = "ab b c d";
        String o5 = "d c b ab";

        assertEquals(o1, sl.reverseWords(t1));
        assertEquals(o2, sl.reverseWords(t2));
        assertEquals(o3, sl.reverseWords(t3));
        assertEquals(o4, sl.reverseWords(t4));
        assertEquals(o5, sl.reverseWords(t5));
    }

    @Test
    public void longestPalindromeTest()
    {
        String t1 = "abbaggbasggaggba";
        String o1 = "ggagg";
        String t2 = "a";
        String o2 = "a";
        String t3 = "baccbaccbaaab";
        String o3 = "baaab";
        String t4 = "ababcb";
        String o4 = "bcb";
        String t5 = "abba";
        String o5 = "abba";

        assertEquals(o1, sl.longestPalindrome(t1));
        assertEquals(o2, sl.longestPalindrome(t2));
        assertEquals(o3, sl.longestPalindrome(t3));
        assertEquals(o4, sl.longestPalindrome(t4));
        assertEquals(o5, sl.longestPalindrome(t5));
    }

    @Test
    public void romanToIntTest()
    {
        String t1 = "CMXCIX";
        int o1 = 999;
        String t2 = "CDXCIX";
        int o2 = 499;
        String t3 = "CDXCIV";
        int o3 = 494;
        String t4 = "CDXLIX";
        int o4 = 449;
        String t5 = "MMXXIII";
        int o5 = 2023;
        String t6 = "MCCCXIV";
        int o6 = 1314;
        String t7 = "DLV";
        int o7 = 555;

        assertEquals(o1, sl.romanToInt(t1));
        assertEquals(o2, sl.romanToInt(t2));
        assertEquals(o3, sl.romanToInt(t3));
        assertEquals(o4, sl.romanToInt(t4));
        assertEquals(o5, sl.romanToInt(t5));
        assertEquals(o6, sl.romanToInt(t6));
        assertEquals(o7, sl.romanToInt(t7));
    }

    @Test
    public void atoiTest()
    {
        String t1 = "  42535    ";
        String t2 = " -25343 ";
        String t3 = "   +000325324";
        String t4 = " -  000";
        String t5 = " +  0";
        String t6 = " 0000053";
        String t7 = "0293483900483053";
        String t8 = "-53829473873874";
        String t9 = "8347 SFDF GDHF";

        int o1 = 42535;
        int o2 = -25343;
        int o3 = 325324;
        int o4 = 0;
        int o5 = 0;
        int o6 = 53;
        int o7 = 2147483647;
        int o8 = -2147483648;
        int o9 = 8347;

        assertEquals(o1, sl.atoi(t1));
        assertEquals(o2, sl.atoi(t2));
        assertEquals(o3, sl.atoi(t3));
        assertEquals(o4, sl.atoi(t4));
        assertEquals(o5, sl.atoi(t5));
        assertEquals(o6, sl.atoi(t6));
        assertEquals(o7, sl.atoi(t7));
        assertEquals(o8, sl.atoi(t8));
        assertEquals(o9, sl.atoi(t9));
    }

    @Test
    public void longestCommonPrefixTest()
    {
        String[] t1 = {"pregsg","presgsd","pregggsss", "praasg"};
        String o1 = "pr";
        String[] t2 = {"hey", "how", "who"};
        String o2 = "";
        String[] t3 = {"animal", "animal", "animal"};
        String o3 = "animal";

        assertEquals(o1, sl.longestCommonPrefix(t1));
        assertEquals(o2, sl.longestCommonPrefix(t2));
        assertEquals(o3, sl.longestCommonPrefix(t3));
    }

    @Test
    public void prefixFunctionTest() {
        String t1 = "abcdaabddababcdeabcdsaaadbdcc";
        String t2 = "hhsfsdfhhghheahhshgdfhhsfhsdf";
        String t3 = "sdfhgdfdlgadesg";
        String t4 = "abababababababcdababa";

        int[] o1 = {0, 0, 0, 0, 1, 1, 2, 0, 0, 1, 2, 1, 2, 3, 4, 0, 1, 2, 3, 4, 0, 1, 1, 1, 0, 0, 0, 0, 0};
        int[] o2 = {0, 1, 0, 0, 0, 0, 0, 1, 2, 0, 1, 2, 0, 0, 1, 2, 3, 1, 0, 0, 0, 1, 2, 3, 4, 1, 0, 0, 0};
        int[] o3 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0};
        int[] o4 = {0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 0, 0, 1, 2, 3, 4, 5};

        assertArrayEquals(o1, sl.prefix_function(t1));
        assertArrayEquals(o2, sl.prefix_function(t2));
        assertArrayEquals(o3, sl.prefix_function(t3));
        assertArrayEquals(o4, sl.prefix_function(t4));
    }

    @Test
    public void zFunctionTest() {
        String t1 = "abcdaabddababcdeabcdsaaadbdcc";
        String t2 = "hhsfsdfhhghheahhshgdfhhsfhsdf";
        String t3 = "sdfhgdfdlgadesg";
        String t4 = "abababababababcdababa";
        String t5 = "aabbaaccaabaabbaaccaabbaaccaab";

        int[] o1 = {0, 0, 0, 0, 1, 2, 0, 0, 0, 2, 0, 4, 0, 0, 0, 0, 4, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0};
        int[] o2 = {0, 1, 0, 0, 0, 0, 0, 2, 1, 0, 2, 1, 0, 0, 3, 1, 0, 1, 0, 0, 0, 4, 1, 0, 0, 1, 0, 0, 0};
        int[] o3 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0};
        int[] o4 = {0, 0, 12, 0, 10, 0, 8, 0, 6, 0, 4, 0, 2, 0, 0, 0, 5, 0, 3, 0, 1};
        int[] o5 = {0, 1, 0, 0, 2, 1, 0, 0, 3, 1, 0, 11, 1, 0, 0, 2, 1, 0, 0, 11, 1, 0, 0, 2, 1, 0, 0, 3, 1, 0};

        assertArrayEquals(o1, sl.z_function(t1));
        assertArrayEquals(o2, sl.z_function(t2));
        assertArrayEquals(o3, sl.z_function(t3));
        assertArrayEquals(o4, sl.z_function(t4));
        assertArrayEquals(o5, sl.z_function(t5));
    }

    @Test
    public void firstOccurrenceTest()
    {
        String t1a = "heyhowarehoware";
        String t1b = "how";
        int o1 = 3;

        String t2a = "heyhowarehoware";
        String t2b = "hew";
        int o2 = -1;

        assertEquals(o1, sl.firstOccurrence(t1a, t1b));
        assertEquals(o2, sl.firstOccurrence(t2a, t2b));
    }

    @Test
    public void editDistanceTest()
    {

        String t1a = "abcasdgsd";
        String t1b = "ahdsfbbcsdsf";
        String t2a = "dsgsdfdsgh";
        String t2b = "fusdf";
        String t3a = "s";
        String t3b = "dsfsd";
        String t4a = "";
        String t4b = "gdsf";

        int o1 = 8;
        int o2 = 7;
        int o3 = 4;
        int o4 = 4;

        assertEquals(o1, sl.editDistance(t1a, t1b));
        assertEquals(o2, sl.editDistance(t2a, t2b));
        assertEquals(o3, sl.editDistance(t3a, t3b));
        assertEquals(o4, sl.editDistance(t4a, t4b));
    }

    @Test
    public void longestCommonSubsequenceTest()
    {
        String t1a = "abcasdgsd";
        String t1b = "ahdsfbbcsdsf";
        String t2a = "dsgsdfdsgh";
        String t2b = "fusdf";
        String t3a = "s";
        String t3b = "dsfsd";
        String t4a = "a";
        String t4b = "gdsf";

        int o1 = 6;
        int o2 = 3;
        int o3 = 1;
        int o4 = 0;

        assertEquals(o1, sl.longestCommonSubsequence(t1a, t1b));
        assertEquals(o2, sl.longestCommonSubsequence(t2a, t2b));
        assertEquals(o3, sl.longestCommonSubsequence(t3a, t3b));
        assertEquals(o4, sl.longestCommonSubsequence(t4a, t4b));
    }

    @Test
    public void palindromePartitioningTest()
    {

        String t1 = "abbcccdgab";
        String t2 = "aabcdef";
        String t3 = "ddedgakga";
        String t4 = "uteyhddhhhdsg";
        String t5 = "e";

        int o1 = 6;
        int o2 = 5;
        int o3 = 6;
        int o4 = 8;
        int o5 = 0;

        assertEquals(o1, sl.palindromePartitioning(t1));
        assertEquals(o2, sl.palindromePartitioning(t2));
        assertEquals(o3, sl.palindromePartitioning(t3));
        assertEquals(o4, sl.palindromePartitioning(t4));
        assertEquals(o5, sl.palindromePartitioning(t5));
    }

    @Test
    public void checkPangramTest()
    {

        String t1 = "AbcdefghijkLmnopqrstUVwxyz";
        String t2 = "aafamssmctocnnJueecqfiqqioidvvprwpxddllyyZZbhbaggkkk";
        String t3 = "ddeDgakga";
        String t4 = "uteUUYhddhhhdsg";

        boolean o1 = true;
        boolean o2 = true;
        boolean o3 = false;
        boolean o4 = false;

        assertEquals(o1, sl.checkPangram(t1));
        assertEquals(o2, sl.checkPangram(t2));
        assertEquals(o3, sl.checkPangram(t3));
        assertEquals(o4, sl.checkPangram(t4));
    }

    @Test
    public void toLowercaseTest()
    {

        String t1 = "abUkdfASZ";
        String t2 = "ghdkdf";
        String t3 = "AFGGDF";
        String t4 = "Udjsfhdc..";

        String o1 = "abukdfasz";
        String o2 = "ghdkdf";
        String o3 = "afggdf";
        String o4 = "udjsfhdc..";

        assertEquals(o1, sl.toLowercase(t1));
        assertEquals(o2, sl.toLowercase(t2));
        assertEquals(o3, sl.toLowercase(t3));
        assertEquals(o4, sl.toLowercase(t4));
    }
    
    @Test
    public void toUppercaseTest()
    {

        String t1 = "abUkdfASz";
        String t2 = "ghdkdf";
        String t3 = "AFGGDF";
        String t4 = "Udjsfhdc..";

        String o1 = "ABUKDFASZ";
        String o2 = "GHDKDF";
        String o3 = "AFGGDF";
        String o4 = "UDJSFHDC..";

        assertEquals(o1, sl.toUppercase(t1));
        assertEquals(o2, sl.toUppercase(t2));
        assertEquals(o3, sl.toUppercase(t3));
        assertEquals(o4, sl.toUppercase(t4));
    }

    @Test
    public void areAnagramsTest()
    {

        String t1a = "ggadabbsa";
        String t1b = "abbadgags";
        String t2a = "sdfsdgs";
        String t2b = "sgseeee";
        String t3a = "aabbccdd";
        String t3b = "abbbccdd";

        boolean o1 = true;
        boolean o2 = false;
        boolean o3 = false;

        assertEquals(o1, sl.areAnagrams(t1a, t1b));
        assertEquals(o2, sl.areAnagrams(t2a, t2b));
        assertEquals(o3, sl.areAnagrams(t3a, t3b));
    }

    @Test
    public void countOccurrencesTest()
    {

        String t1a = "abcdabcabcabcabcd";
        String t1b = "abc";
        String t2a = "aabdcadsfagd";
        String t2b = "ze";
        String t3a = "abababaaaabbb";
        String t3b = "aba";

        int o1 = 5;
        int o2 = 0;
        int o3 = 3;

        assertEquals(o1, sl.countOccurrences(t1a, t1b));
        assertEquals(o2, sl.countOccurrences(t2a, t2b));
        assertEquals(o3, sl.countOccurrences(t3a, t3b));
    }

    @Test
    public void countWordsTest()
    {

        String t1 = "gdsf    gsdf   ffsd sdfds hgdsds gsdf gsdg asdg";
        String t2 = "jfh yi a  sdf hgd";
        String t3 = "fdg";
        String t4 = ".sdfsd   gsdfds.dsfsd";

        int o1 = 8;
        int o2 = 5;
        int o3 = 1;
        int o4 = 2;

        assertEquals(o1, sl.countWords(t1));
        assertEquals(o2, sl.countWords(t2));
        assertEquals(o3, sl.countWords(t3));
        assertEquals(o4, sl.countWords(t4));
    }

    @Test
    public void countCharactersTest()
    {

        String t1 = "gdsf    gsdf   ffsd sdfds hgdsds gsdf gsdg asdg";
        String t2 = "jfh yi a  sdf hgd";
        String t3 = "fdg";
        String t4 = ".sdfsd   gsdfds.dsfsd";

        int o1 = 35;
        int o2 = 12;
        int o3 = 3;
        int o4 = 18;

        assertEquals(o1, sl.countCharacters(t1));
        assertEquals(o2, sl.countCharacters(t2));
        assertEquals(o3, sl.countCharacters(t3));
        assertEquals(o4, sl.countCharacters(t4));
    }

    @Test
    public void minLengthWordTest()
    {

        String t1 = "gdsf    gsdf   ffsd sdfds hgdsds gsdf gsdg asdg";
        String t2 = "jfh yi a  sdf hgd";
        String t3 = "fdg";
        String t4 = "sdfsd   gsdfds dsfsd";

        String o1 = "gdsf";
        String o2 = "a";
        String o3 = "fdg";
        String o4 = "sdfsd";

        assertEquals(o1, sl.minLengthWord(t1));
        assertEquals(o2, sl.minLengthWord(t2));
        assertEquals(o3, sl.minLengthWord(t3));
        assertEquals(o4, sl.minLengthWord(t4));
    }

    @Test
    public void maxLengthWordTest()
    {

        String t1 = "gdsf    gsdf   ffsd sdfds hgdsds gsdf gsdg asdg";
        String t2 = "jfh yi a  sdf hgd";
        String t3 = "fdg";
        String t4 = "sdfsd   gsdfds dsfsd";

        String o1 = "hgdsds";
        String o2 = "jfh";
        String o3 = "fdg";
        String o4 = "gsdfds";

        assertEquals(o1, sl.maxLengthWord(t1));
        assertEquals(o2, sl.maxLengthWord(t2));
        assertEquals(o3, sl.maxLengthWord(t3));
        assertEquals(o4, sl.maxLengthWord(t4));
    }

    @Test
    public void issubsequenceTest()
    {
        String t1a = "abc";
        String t1b = "abbadgagsc";
        String t2a = "ret";
        String t2b = "sgseeee";
        String t3a = "aabbccdd";
        String t3b = "ababbccdd";
        String t4a = "aabbccddaa";
        String t4b = "ababbccdd";
        String t5a = "";
        String t5b = "ababbccdd";

        boolean o1 = true;
        boolean o2 = false;
        boolean o3 = true;
        boolean o4 = false;
        boolean o5 = true;

        assertEquals(o1, sl.issubsequence(t1a, t1b));
        assertEquals(o2, sl.issubsequence(t2a, t2b));
        assertEquals(o3, sl.issubsequence(t3a, t3b));
        assertEquals(o4, sl.issubsequence(t4a, t4b));
        assertEquals(o5, sl.issubsequence(t5a, t5b));
    }

    @Test
    public void reverseStringTest()
    {

        String t1 = "Udjsfhdc..";
        String t2 = "g";
        String t3 = "AFGGDF";
        String t4 = "aaaa";

        String o1 = "..cdhfsjdU";
        String o2 = "g";
        String o3 = "FDGGFA";
        String o4 = "aaaa";

        assertEquals(o1, sl.reverseString(t1));
        assertEquals(o2, sl.reverseString(t2));
        assertEquals(o3, sl.reverseString(t3));
        assertEquals(o4, sl.reverseString(t4));
    }
}

