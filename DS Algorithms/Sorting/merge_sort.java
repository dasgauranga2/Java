
public class merge_sort {

    // MERGE SORT
    // TIME COMPLEXITY : O(N*log(N))
    public static void sort(int[] nums, int l, int r) {
        if (l < r) {
            int m = (l+r)/2;

            sort(nums, l, m);
            sort(nums, m+1, r);

            merge(nums, l, m, r);
        }
    }

    public static void merge(int[] arr, int p, int q, int r) {

        // Create L ← A[p..q] and M ← A[q+1..r]
        int n1 = q - p + 1;
        int n2 = r - q;

        int L[] = new int[n1];
        int M[] = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[p + i];
        }
        for (int j = 0; j < n2; j++) {
            M[j] = arr[q + 1 + j];
        }
        
        // Maintain current index of sub-arrays and main array
        int i, j, k;
        i = 0;
        j = 0;
        k = p;

        // Until we reach either end of either L or M, pick larger among
        // elements L and M and place them in the correct position at A[p..r]
        while (i < n1 && j < n2) {
            if (L[i] <= M[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = M[j];
                j++;
            }
            k++;
        }

        // When we run out of elements in either L or M,
        // pick up the remaining elements and put in A[p..r]
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = M[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {

        int[] nums = {9,5,1,4,3,11,15,6};
        
        sort(nums,0,nums.length-1);

        for (int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}