public class Solution {

    public static void main(String[] args) {
        char[] charArr = new char[]{'a','b','c','d','f','h'};
        char nextAlphabet = findNextAlphabet(charArr, 'b');
        System.out.println(nextAlphabet);
    }

    private static char findNextAlphabet(char[] charArr, char k) {
        int start = 0, end = charArr.length - 1;
        int mid;
        char answer = 'z';

        while (start <= end) {
            mid = start + (end - start);

            if(charArr[mid] == k) {
                start = mid + 1;
            } else if (charArr[mid] > k) {
                answer = charArr[mid];
                end = mid - 1;
            } else if (charArr[mid] < k) {
                start = mid + 1;
            }
        }
        return answer;
    }
}
