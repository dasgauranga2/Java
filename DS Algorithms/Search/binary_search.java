
public class binary_search {

    // BINARY SEARCH 
    public static int search(int[] nums, int x) {

        int start = 0;
        int end = nums.length-1;
        int mid;

        while (start <= end) {
            mid = (start+end)/2;

            if (nums[mid] == x) {
                return mid;
            }
            else if (x < nums[mid]) {
                end = mid-1;
            }
            else if (x > nums[mid]) {
                start = mid+1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int arr[] = {1,2,4,7,9,11,14,15};
        
        for(int i=1; i<20 ;i++) {
            System.out.println(i + " " + search(arr, i));
        }
    }
}