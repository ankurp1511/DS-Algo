public class Solution {

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,1,5,2,5};

        solve(arr);
    }

    private static void solve(int[] arr) {

        int i = 0;
        while (i < arr.length){
            if(arr[i] != i + 1){
                if(arr[i] != arr[arr[i] - 1]){
                    int temp = arr[i];
                    arr[i] = arr[arr[i] - 1];
                    arr[temp - 1] = temp;
                }else {
                    i++;
                }
            }else {
                i++;
            }
        }

        for(int j = 0; j< arr.length; j++){
            if(arr[j] != j+1){
                System.out.println("Missing No. is : " + (j+1));
                System.out.println("Duplicate No. is : " + (arr[j]));
            }
        }
    }
}
