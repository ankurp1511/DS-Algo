public class Solution {

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12};

        int k = 3;

        int gcd = gcd(arr.length, k);
        System.out.println(gcd);

        int j;
        int d;

        for(int i =0; i < gcd; i++){
            j = i;
            int temp = arr[i];
            while (true){

                d = (j + k) % arr.length;

                if( d == i){
                    break;
                }
                arr[j] = arr[d];
                j = d;
            }
            arr[j] = temp;
        }

        for (int num: arr){
            System.out.print(num + " ");
        }


    }

    private static int gcd(int a, int b){

        if(b == 0){
            return a;
        }else {
            return gcd(b, a%b);
        }

    }
}
