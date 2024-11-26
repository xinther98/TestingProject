import java.util.*;

public class StringLibrary {

    public String reverseWords(String s) {
        s = s.trim();
        char[] carr = s.toCharArray();
        int n = s.length();

        for(int i = 0; i < n/2; i++) {
        	char tmp = carr[i];
        	carr[i] = carr[n-1-i];
        	carr[n-1-i] = tmp;
        }

        int f = 0, b = 0;
        for(f = 0; f < n; f++) {
            if(f!=0 && carr[f] == ' ' && carr[f-1] == ' ') {
                continue;
            }
            else {
                carr[b++] = carr[f];
            }
        }

        n = b;
        
        int l = 0;
        while(l < n) {

            int r = l;
            while(r < n && carr[r] != ' ') r++;

            for(int i = l; i < l + (r-l)/2; i++) {
	        	char tmp = carr[i];
	        	carr[i] = carr[r-1-(i-l)];
	        	carr[r-1-(i-l)] = tmp;
	        }
                
            l = r+1;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(carr[i]);
        }
        
        return sb.toString();
    }

    public String longestPalindrome(String s) {
        
        int n = s.length();
        
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < n; j++) {
        		dp[i][j] = -1;
        	}
        }

        for(int i = 0; i < n; i++) {
            dp[i][i] = 1;
            if(i < n-1) dp[i+1][i] = 0;
        }
        
        int besti = 0, bestlen = 1;
        for(int l = 2; l <= n; l++) {
            
            for(int i = 0; i < n-l+1; i++) {
                if(s.charAt(i) == s.charAt(i+l-1) && dp[i+1][i+l-2] != -1) {
                    dp[i][i+l-1] = 2 + dp[i+1][i+l-2];
                    
                    bestlen = l;
                    besti = i;
                }
            }
        }
        
        return s.substring(besti, besti+bestlen);
    }

	public int romanToInt(String s) {
        
		int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        int ans = 0;
        
        // First check for the 2 length strings 
        for(int i = 0; i < n-1; i++) {
            if(sb.charAt(i) == 'I' && sb.charAt(i+1) == 'V') {
                ans += 4;
            }
            else if(sb.charAt(i) == 'I' && sb.charAt(i+1) == 'X') {
                ans += 9;
            }
            else if(sb.charAt(i) == 'X' && sb.charAt(i+1) == 'L') {
                ans += 40;
            }
            else if(sb.charAt(i) == 'X' && sb.charAt(i+1) == 'C') {
                ans += 90;
            }
            else if(sb.charAt(i) == 'C' && sb.charAt(i+1) == 'D') {
                ans += 400;
            }
            else if(sb.charAt(i) == 'C' && sb.charAt(i+1) == 'M') {
                ans += 900;
            }
            else {
                continue;
            }
            
            sb.setCharAt(i, '*'); 
            sb.setCharAt(i+1, '*'); 
        }

        for(int i = 0; i < n; i++) {
            if(sb.charAt(i) == 'I') {
                ans += 1;
            }
            else if(sb.charAt(i) == 'V') {
                ans += 5;
            }
            else if(sb.charAt(i) == 'X') {
                ans += 10;
            }
            else if(sb.charAt(i) == 'L') {
                ans += 50;
            }
            else if(sb.charAt(i) == 'C') {
                ans += 100;
            }
            else if(sb.charAt(i) == 'D') {
                ans += 500;
            }
            else if(sb.charAt(i) == 'M') {
                ans += 1000;
            }
        }
        
        return ans;
    }

    public int atoi(String s) {
        
		StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        while(sb.length() != 0 && sb.charAt(sb.length()-1) == ' ') sb.deleteCharAt(sb.length()-1);
        
        int sign = 1;
        if(sb.length() != 0 && sb.charAt(sb.length()-1) == '-') {
            sign = -1;
            sb.deleteCharAt(sb.length()-1);
        }
        else if(sb.length() != 0 && sb.charAt(sb.length()-1) == '+') {
            sign = 1;
            sb.deleteCharAt(sb.length()-1);
        }
        
        while(sb.length() != 0 && sb.charAt(sb.length()-1) == '0') sb.deleteCharAt(sb.length()-1);
        
        int len = 0;
        int l = sb.length()-1;
        while(l >= 0 && sb.charAt(l) >= '0' && sb.charAt(l) <= '9') {
            len++;
            l--;
        }
        
        if(len == 0) return 0;
        
        sb.reverse();
        while(sb.length() > len) {
            sb.deleteCharAt(sb.length()-1);
        }
        
        
        if(len >= 12) {
            if(sign == 1) return Integer.MAX_VALUE;
            else return Integer.MIN_VALUE;
        }
        
        long conv = 0;
        long pow = 1;
        for(int i = len-1; i >= 0; i--) {
            conv += pow * (sb.charAt(i)-'0');
            pow = pow * 10;
        }
        
        conv *= sign;
        
        if(conv < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        
        if(conv > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        
        return (int)conv;
    }

    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        
        int l = 1, r = strs[0].length();
        int saved = 0;
        while(l <= r) {
            int mid = (l+r)/2;
            String pref = strs[0].substring(0, mid);
            
            boolean ispref = true;
            for(int i = 1; i < n; i++) {
                for(int j = 0; j < mid; j ++) {
                    if(strs[i].charAt(j) != pref.charAt(j)) ispref = false;
                }
            }
            
            if(ispref != false) {
                saved = mid;
                l = mid+1;
            }
            else {
                r = mid-1;
            }
        }
        
        if(saved == 0) {
            return "";
        }
        else {
            return strs[0].substring(0, saved);
        }
    }

	public int[] z_function(String s) {
		int n = s.length();
		int[] z = new int[n];

		for(int i = 0; i < n; i++) {
			z[i] = 0;
		}

		int l = 0, r = 0;
		for(int i = 1; i < n; i++) {
			if(i >= r) {
				l = i; r = i;
				while(r < n && s.charAt(r) == s.charAt(0+r-l)) {
					r++;
					z[i]++;
				}
			}
			else {
				z[i] = Math.min(z[i-l], r-i);
				int p = i+z[i];
				while(p < n && s.charAt(p) == s.charAt(p-i)) {
					z[i]++;
					p++;
					if(p >= r) {
						r = p;
					}
				}
			}
		}

		return z;
	}

	public int[] prefix_function(String s) {
		int n = s.length();
		int[] kmp = new int[n];

		for(int i = 0; i < n; i++) {
			kmp[i] = 0;
		}

		for(int i = 1; i < n; i++) {
			int v = i-1;
			while(v > -1 && s.charAt(kmp[v]) != s.charAt(i)) {
				v = kmp[v] - 1;
			}

			if(v <= -1) continue;
			kmp[i] = kmp[v]+1;
		}

		return kmp;
	}

    public int firstOccurrence(String haystack, String needle) {
        String comb = needle + "#" + haystack;
        int[] prefarray = prefix_function(comb);
        
        int ns = needle.length(), hs = haystack.length();
        for(int i = ns+1; i < comb.length(); i++) {
            if(prefarray[i] == ns) {
                return i-(ns+1)-ns+1;
            }
        }
        return -1;
    }

    public int editDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];

        for(int i = 0; i <= m; i++) {
        	for(int j = 0; j <= n; j++) {
        		dp[i][j] = -1;
        	}
        }
        
        for(int i = 0; i <= m; i++) dp[i][0] = i;
        for(int j = 0; j <= n; j++) dp[0][j] = j;
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                dp[i][j] = 1 + dp[i][j-1];
                dp[i][j] = Math.min(dp[i][j], 1 + dp[i-1][j]);
                dp[i][j] = Math.min(dp[i][j], ((word1.charAt(i-1) == word2.charAt(j-1))? 0 : 1) + dp[i-1][j-1]);
            }
        }
        
        return dp[m][n];
    }

    public int longestCommonSubsequence(String text1, String text2) { 
        
        int maxn = 1010;
    	int[][] dp = new int[maxn][maxn];
        int m = text1.length();
        int n = text2.length();
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                dp[i][j] = dp[i-1][j];
                dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
                if(text1.charAt(i-1) == text2.charAt(j-1)) dp[i][j] = Math.max(dp[i][j], 1 + dp[i-1][j-1]);
            }
        }
        
        return dp[m][n];
    }

    public int palindromePartitioning(String str) {
	    
        int n = str.length();
        int[] dp = new int[n+1];

        for(int i = 0; i <= n; i++) {
            dp[i] = 1000000000;
        }

        dp[n] = -1;
        for(int i = n-1; i >= 0; i--) {
            for(int j = i; j < n; j++) {
                boolean ispalin = true;
                for(int k = i; k < i + (j-i+1)/2; k++) {
                    if(str.charAt(k) != str.charAt(j-(k-i))) ispalin = false;
                }
                
                if(ispalin) {
                    dp[i] = Math.min(dp[i], 1 + dp[j+1]);
                }
            }
        }
        
        return dp[0];
	}

	public boolean checkPangram(String str) {
        boolean done[] = new boolean[26];

        for(int i = 0; i < str.length(); i++) {
            if('a' <= str.charAt(i) && str.charAt(i) <= 'z') {
                done[str.charAt(i) - 'a'] = true;
            }
            else if('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
                done[str.charAt(i) - 'A'] = true;
            }
        }

        for(int i = 0; i < 26; i++) {
        	if(!done[i]) {
        		return false;
        	}
        }

        return true;
    }

    public String toLowercase(String str) {
    	String ans = "";

    	for(int i = 0; i < str.length(); i++) {
    		if(str.charAt(i) <= 'Z' && str.charAt(i) >= 'A') {
    			ans = ans + (char)(str.charAt(i) - 'A' + 'a');
    		}
    		else {
    			ans = ans + str.charAt(i);
    		}
    	}

    	return ans;
    }

    public String toUppercase(String str) {
    	String ans = "";

    	for(int i = 0; i < str.length(); i++) {
    		if(str.charAt(i) <= 'z' && str.charAt(i) >= 'a') {
    			ans = ans + (char)(str.charAt(i) - 'a' + 'A');
    		}
    		else {
    			ans = ans + str.charAt(i);
    		}
    	}

    	return ans;
    }

    public boolean areAnagrams(String str1, String str2) {
    	char[] arr1 = str1.toCharArray();
    	char[] arr2 = str2.toCharArray();
    	Arrays.sort(arr1);
    	Arrays.sort(arr2);

    	boolean ans = Arrays.equals(arr1, arr2);
    	return ans;
    }

    public int countOccurences(String str1, String str2) {
    	int cnt = 0;

    	String mrg = str1 + "#" + str2;
    	int[] pf = prefix_function(mrg);

    	for(int i = 0; i < pf.length; i++) {
    		if(pf[i] == str1.length()) {
    			cnt++;
    		}
    	} 

    	return cnt;
    }

    public int countWords(String str) {
        int onWord = 0;
        int wc = 0; 
        int i = 0;

        while(i < str.length()) {
            if(str.charAt(i) == ' ' || str.charAt(i) == '\n' || str.charAt(i) == '\t') {
                onWord = 0;
            }
            else if(onWord == 0) {
                onWord = 1;
                ++wc;
            }
      
            ++i;
        }

        return wc;
    }

    public int countCharacters(String str) {
        int cc = 0; 

        for(int i = 0; i < str.length(); i++) {
            if(!(str.charAt(i) == ' ' || str.charAt(i) == '\n' || str.charAt(i) == '\t')) {
                ++cc;
            }
        }
        
        return cc;
    }

	public String minLengthWord(String str) {
        str=str.trim();
         
        int len = str.length();
        int si = 0, ei = 0;
        int min_length = len, min_start_index = 0;

        while(ei <= len) {
            if (ei < len && str.charAt(ei) != ' ')
            {
                ei++;
            }
            else
            {
                int curr_length = ei - si;
 
                if (curr_length < min_length)
                {
                    min_length = curr_length;
                    min_start_index = si;
                }

                ei++;
                si = ei;
            }
        }

        return str.substring(min_start_index, min_start_index + min_length);
    }


	public String maxLengthWord(String str) {
        str=str.trim();
         
        int len = str.length();
        int si = 0, ei = 0;
        int max_length = 0, max_start_index = 0;

        while(ei <= len) {
            if (ei < len && str.charAt(ei) != ' ')
            {
                ei++;
            }
            else
            {
                int curr_length = ei - si;
 
                if (curr_length > max_length)
                {
                    max_length = curr_length;
                    max_start_index = si;
                }

                ei++;
                si = ei;
            }
        }

        return str.substring(max_start_index, max_start_index + max_length);
    }

	public boolean issubsequence(String s1, String s2) {
	    int n = s1.length(), m = s2.length();
	    int i = 0, j = 0;
	    while (i < n && j < m) {
	        if (s1.charAt(i) == s2.charAt(j)) {
	            i++;
	        }
	        j++;
	    }

	    return (i == n);
	}

	String reverseString(String str) {

		char[] carr = str.toCharArray();
		int n = carr.length;

		for(int i = 0; i < n/2; i++) {
			char tmp = carr[i];
			carr[i] = carr[n-i-1];
			carr[n-i-1] = tmp;
		}

		return new String(carr);
	}

	public static void main(String[] args) {
		StringLibrary sl = new StringLibrary();
		System.out.println(Arrays.toString(sl.prefix_function("abbabbcad")));
		System.out.println(Arrays.toString(sl.z_function("abbabbcad")));
		System.out.println(sl.countOccurences("ab", "abbabbcadab"));
		System.out.println(sl.countWords("ab gs ashg sdf tye"));
		System.out.println(sl.maxLengthWord("abgs gsddsf ashg sdf tye"));
		System.out.println(sl.reverseString("abcdef"));
	}
}