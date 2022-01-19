public class Solution {

    public static void main(String[] args) {

        int[] arr = new int[]{38, 27, 43, 3,9, 82,10};

        mergeSort(arr, 0, arr.length - 1);

        for (int i=0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void mergeSort(int[] arr, int l, int r) {

        if (l >= r) {
            return;
        }
        int mid = l + (r  - l)/ 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);

        merge(arr, l, r, mid);
    }

    private static void merge(int[] arr, int l, int r, int mid) {

        int i = 0;
        int j = 0;

        int n1 = mid - l + 1;
        int n2 = r - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int m = 0 ; m < n1; m++) {
            L[m] = arr[l + m];
        }

        for (int n = 0; n < n2; n++) {
            R[n] = arr[mid + 1 + n];
        }

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else if (R[j] < L[i]) {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i<n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
