public class Solution {

    public static void main(String[] args) {

        String word1 = "bbabacaa";
        String word2 = "cccababab";
        int [][] t = new int[word1.length() + 1][word2.length() + 1];
        lcs(word1.length(), word2.length(), word1, word2, t);
        System.out.println(longestCommonSubsequence(word1.length(), word2.length(), word1, word2, t));
        System.out.println(shortestCommongsubsequence(word1.length(), word2.length(), word1, word2, t));
    }

    private static void lcs(int n, int m, String word1, String word2, int[][] t) {

        for (int i = 1; i < n+1; i++) {
            for (int j= 1; j< m+1; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    t[i][j] = 1 + t[i-1][j-1];
                } else {
                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
                }
            }
        }
    }

    private static String longestCommonSubsequence(int n, int m, String word1, String word2, int[][] t) {
        StringBuilder stringBuilder = new StringBuilder();
        while (n > 0 && m > 0) {
            if (word1.charAt(n-1) == word2.charAt(m-1)) {
                stringBuilder.append(word1.charAt(n-1));
                n--;
                m--;
            } else if (t[n][m-1] > t[n-1][m]) {
                m--;
            } else {
                n--;
            }
        }

        return stringBuilder.reverse().toString();
    }

    private static String shortestCommongsubsequence(int n, int m, String word1, String word2, int[][] t) {
        StringBuilder strBuilder = new StringBuilder();

        while(n>0 && m>0) {

            if(word1.charAt(n-1) == word2.charAt(m-1)) {
                strBuilder.append(word1.charAt(n-1));
                n--;
                m--;
            } else if (t[n-1][m] > t[n][m-1]) {
                strBuilder.append(word1.charAt(n-1));
                n--;
            } else {
                strBuilder.append(word2.charAt(m-1));
                m--;
            }
        }

        while (n >0) {
            strBuilder.append(word1.charAt(n-1));
            n--;
        }
        while (m >0) {
            strBuilder.append(word2.charAt(m-1));
            m--;
        }
        return strBuilder.reverse().toString();
    }
}
