import java.util.Arrays;
/* These are all the solutions I used for Array3 on codingbat.com. They are great practice questions for getting into java. Most of these can be reworked and made more efficient or generally better. */
public class Array3
{
    /*
     * Consider the leftmost and righmost appearances of some value in an array. We'll say that the "span" is the number of elements between the two inclusive. A single value has a span of 1.
     * Returns the largest span found in the given array. (Efficiency is not a priority.)
     */
    public int maxSpan(int[] nums) {
        int max = 0;
      
        for (int i =0; i < nums.length; i++){
            int furthest = 1;
        
            for (int j = 0; j < nums.length; j++){
                if (nums[i] == nums[j]){
                    if (furthest < (j - i) + 1) furthest = (j-i) + 1;
                }
            }
        
            if (furthest > max) max = furthest;
        }
      
        return max;
    }

    /*
     * Return an array that contains exactly the same numbers as the given array, but rearranged so that every 3 is immediately followed by a 4. Do not move the 3's, but every other number may move. 
     * The array contains the same number of 3's and 4's, every 3 has a number after it that is not a 3, and a 3 appears in the array before any 4.
     */
    public int[] fix34(int[] nums) {
      
        for(int i =0; i < nums.length-1; i++){
            if (nums[i] == 3 && nums[i+1]!= 4){
                int indexOfNext4 = 0;
          
                for(int j = 0; j < nums.length; j++){
                    if(nums[j] == 4 && nums[j-1] != 3){
                        indexOfNext4 = j;
                        break;
                    }
                }
          
                int holder = nums[i+1];
                nums[i+1] = nums[indexOfNext4];
                nums[indexOfNext4] = holder;
            }
        }
      
        return nums;
    }

    /*
     * (This is a slightly harder version of the fix34 problem.) Return an array that contains exactly the same numbers as the given array, but rearranged so that every 4 is immediately followed by a 5. Do not move the 4's, 
     * but every other number may move. The array contains the same number of 4's and 5's, and every 4 has a number after it that is not a 4. In this version, 5's may appear anywhere in the original array.
     */
    public int[] fix45(int[] nums) {
        for(int i =0; i < nums.length-1; i++){
            if (nums[i] == 4 && nums[i+1] != 5){
                int usable4 = 0;
          
                for(int j = 1; j < nums.length; j++){
                    if(nums[j] == 5 && nums[j-1] != 4){
                        usable4 = j;
                        break;
                    }
                }
          
                int holder = nums[i+1];
                nums[i+1] = nums[usable4];
                nums[usable4] = holder;
            }
        }
      
        return nums;
    }

    /*
     * Given a non-empty array, return true if there is a place to split the array so that the sum of the numbers on one side is equal to the sum of the numbers on the other side.
     */
    public boolean canBalance(int[] nums) {
      
        for (int i =0; i<nums.length; i++){
            int currentFirstSum = 0;
            int currentSecondSum=0;
        
            for (int j=0; j<i; j++){
                currentFirstSum += nums[j]; 
            }
        
            for (int j=i; j<nums.length; j++){
                currentSecondSum += nums[j]; 
            }
        
            if(currentSecondSum == currentFirstSum){
                return true;
            }
        }
      
        return false;
    }

    /*
     * Given two arrays of ints sorted in increasing order, outer and inner, return true if all of the numbers in inner appear in outer. The best solution makes only a single "linear" pass of both arrays, 
     * taking advantage of the fact that both arrays are already in sorted order.
     */
    public boolean linearIn(int[] outer, int[] inner) {
      
        for (int i =0; i < inner.length; i++){
            if (Arrays.binarySearch(outer, inner[i]) < 0){
                return false;
            }
        }
      
        return true;
    }

    /*
     * Given n>=0, create an array length n*n with the following pattern, shown here for n=3 : {0, 0, 1,    0, 2, 1,    3, 2, 1} (spaces added to show the 3 groups).
     */
    public int[] squareUp(int n) {
        int[] returnable = new int[n*n];
  
        int currentGap = n-1;
  
        for(int i = 0; i<returnable.length; i=i){
            int digits = n- currentGap;
            int zeroCount = 0;
    
            while(zeroCount < currentGap){
                returnable[i] = 0;
                i++;
                zeroCount++;
            }   
    
            while(digits>0){
                returnable[i] = digits;
                i++;
                digits--;
            }
    
            currentGap--;
        }
  
        return returnable;
    }  
    
    /*
     * Given n>=0, create an array with the pattern {1,    1, 2,    1, 2, 3,   ... 1, 2, 3 .. n} (spaces added to show the grouping). Note that the length of the array will be 1 + 2 + 3 ... + n, 
     * which is known to sum to exactly n*(n + 1)/2.
     */
    public int[] seriesUp(int n) {
        int[] returnable = new int[n*(n+1)/2];
      
        int currentSeries = 1;
        int i =0;
      
        while(currentSeries <= n){
            int counter = 0;
        
            while(counter < currentSeries){
                counter++;
                returnable[i] = counter;
                i++;
            }
        
            currentSeries++;
        }
      
        return returnable;
    }

    /*
     * We'll say that a "mirror" section in an array is a group of contiguous elements such that somewhere in the array, the same group appears in reverse order. For example, the largest mirror section in 
     * {1, 2, 3, 8, 9, 3, 2, 1} is length 3 (the {1, 2, 3} part). Return the size of the largest mirror section found in the given array.
     */
    public int maxMirror(int[] nums) {
        int max = 0;
      
        for (int i =0; i <nums.length; i++){
        
            for(int j = nums.length-1; j >= i; j--){
                int len= 0;
                boolean isGood = nums[i] == nums[j];
          
                while (isGood){
                    len++;
            
                    int front = i+ len;
                    int back = j - len;
            
                    isGood = front< nums.length && back >= 0 && nums[front] == nums[back];
                }
          
                if(len > max) max = len;
            }
        
        
        }
      
        return max;
    }

    /*
     * Say that a "clump" in an array is a series of 2 or more adjacent elements of the same value. Return the number of clumps in the given array.
     */
    public int countClumps(int[] nums) {
        int count = 0;
        int i = 0;
      
        while (i < nums.length-1){
            int clumpStart = i;
            int clumpLen = 1;
            i++;
        
            while(i<nums.length && nums[i] == nums[clumpStart]){
                clumpLen++;
                i++;
            }
        
            if (clumpLen > 1){
              count++;
            }
        }
      
        return count;
    }

}