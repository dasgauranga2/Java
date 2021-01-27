
public class quicksort {

    // QUICKSORT
    // TIME COMPLEXITY : O(N*log(N))
    public static void sort(int[] nums, int low, int high) {
        if (low < high) {
            int pi = partition(nums ,low, high);

            sort(nums, low, pi-1);
            sort(nums, pi+1, high);
        }
    }

    public static int partition(int[] array,int low, int high) {

        // Select the pivot element
        int pivot = array[high];
        int i = (low - 1);

        // Put the elements smaller than pivot on the left and 
        // greater than pivot on the right of pivot
        for (int j = low; j < high; j++) {
        if (array[j] <= pivot) {
            i++;
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return (i + 1);
    }

    public static void main(String[] args) {

        int[] nums = {9,5,1,4,3,11,15,6};
        
        sort(nums,0,nums.length-1);

        for (int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}