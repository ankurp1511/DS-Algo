public class Solution {

    public static void main(String[] args) {
        int[] arr = new int[]{2,4,5,6,10,12};
        int[] output = new int[arr.length];

        for(int i=0 ; i< output.length; i++){
            output[i] = calculateOddDivisorSum(arr[i]);
        }

        int sum = 0;
        for(Integer num: output){
            System.out.print(num + " ");
            sum += num;
        }

        System.out.println(sum);

    }

    private static int calculateOddDivisorSum(int n){

        int sum = 1;
        if(n % 2 == 0){
            if((n/2) % 2 == 0){
                for(int i = 2; i < Math.sqrt(n) ; i++){
                    if(i % 2 != 0 && n % i == 0){
                        sum += i;
                    }
                }
            }
            else {
                for(int i = 2; i <= n/2 ; i++){
                    if(i % 2 != 0 && n % i == 0){
                        sum += i;
                    }
                }
            }
        }
        else {
            if(n > 3) {
                for (int i = 3; i < 2 * Math.sqrt(n); i++) {
                    if (i % 2 != 0 && n % i == 0) {
                        sum += i;
                    }
                }
            }
            sum += n;
        }

        return sum;
    }
}
