package striver;
//Binary search on answer->min(max) or max(min)
//Find the minimum possible maximum pages a student has to read when n books are divided contiguously among m students.
public class P21_BookAllocation {
    public static int countStudents(int[] nums,int pages){
        int n=nums.length;
        int students=1;
        int pagesStudent=0;
        for(int i=0;i<n;i++)
        {
            if(pagesStudent+nums[i]<=pages)
            {
                //Add pages to current student
                pagesStudent+=nums[i];
            }
            else
            {
                //Add pages to next student
                students++;
                pagesStudent=nums[i];
            }
        }
        return students;
    }
    public static int findPagesOptimal(int[] nums,int m)
    {
        int n = nums.length;

        // Book allocation impossible
        if (m > n) return -1;

        // Calculate the range for search
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int i = 0; i < n; i++){
            low = Math.max(low, nums[i]);
            high = high + nums[i];
        }

        // Binary search for minimum maximum pages
        while (low <= high) {
            int mid = (low + high) / 2;
            int students = countStudents(nums, mid);
            if (students > m) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return low;
    }
    //Time Complexity:O(N * (sum-max))
    //Space Complexity is O(1)
    public static int findPagesBrute(int[] nums,int m)
    {
        int n=nums.length;
        //Book allocation impossible
        if(m>n) return -1;
        //Calculate the search range
        int low=Integer.MIN_VALUE;
        int high=0;
        for(int i=0;i<n;i++)
        {
            low = Math.max(low, nums[i]);
            high = high + nums[i];
        }
        //Linear search for minimum max pages
        for(int pages=low;pages<=high;pages++)
        {
            // if books can assigned to less than k students then
            // it can be assigned to exactly k students as well
            if(countStudents(nums,pages)<=m)
                return pages;
        }
        return low;
    }
    public static void main(String[] args) {
        int[] arr = {25, 46, 28, 49, 24};
        int m = 4;
        int ans = findPagesBrute(arr, m);
        System.out.println("The answer is: " + ans);
    }
}
