/* These are all the solutions I used for Recursion2 on codingbat.com. They are great practice questions for getting into java. Most of these can be reworked and made more efficient or generally better. */
public class Recursion2
{
    /* Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target? This is a classic backtracking recursion problem. 
     * Once you understand the recursive backtracking strategy in this problem, you can use the same pattern for many problems to search a space of choices. Rather than looking at the whole array, 
     * our convention is to consider the part of the array starting at index start and continuing to the end of the array. The caller can specify the whole array simply by passing start as 0. No loops are needed -- 
     * the recursive calls progress down the array.
     */
    public boolean groupSum(int start, int[] nums, int target) {
        if (start >= nums.length){
            return target==0;
        }
      
        if (groupSum(start +1, nums, target - nums[start])){
            return true;
        }
      
        if (groupSum(start +1, nums, target)){
            return true;
        }
      
        else{
            return false;
        }
    }
    
    /* Given an array of ints, is it possible to choose a group of some of the ints, beginning at the start index, such that the group sums to the given target? However, with the additional 
     * constraint that all 6's must be chosen. (No loops needed.)
     */
    public boolean groupSum6(int start, int[] nums, int target) {
        if (start >= nums.length){
            return target==0;
        }
    
        if (nums[start] == 6){
            return groupSum6(start +1, nums, target - 6);
        }
        
        if (groupSum6(start +1, nums, target - nums[start])){
            return true;
        }
      
        if (groupSum6(start +1, nums, target)){
            return true;
        }
      
        else{
            return false;
        }
    }
    
    /*
     * Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target with this 
     * additional constraint: If a value in the array is chosen to be in the group, the value immediately following it in the array must not be chosen. (No loops needed.)
     */
    public boolean groupNoAdj(int start, int[] nums, int target) {
        if (start >= nums.length){
            return target==0;
        }
    
        if (groupNoAdj(start +2, nums, target - nums[start])){
            return true;
        }
      
        if (groupNoAdj(start +1, nums, target)){
            return true;
        }
      
        else{
            return false;
        }
    }
    
    /*
     * Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target with these additional constraints: 
     * all multiples of 5 in the array must be included in the group. If the value immediately following a multiple of 5 is 1, it must not be chosen. (No loops needed.)
     */
    public boolean groupSum5(int start, int[] nums, int target) {
        if (start >= nums.length){
            return target==0;
        }
    
        if(nums[start]%5 == 0){
            if(start < nums.length - 1 && nums[start+1] == 1){
                return groupSum5(start+2, nums, target - nums[start]);
            }else{
                return groupSum5(start+1, nums, target - nums[start]);
            }
        } 
      
        if (groupSum5(start +1, nums, target - nums[start])){
            return true;
        }
      
        if (groupSum5(start +1, nums, target)){
            return true;
        }
      
        else{
            return false;
        }
    }
    
    /*
     * Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target, with this additional constraint: if there are numbers in the array that are adjacent and 
     * the identical value, they must either all be chosen, or none of them chosen. For example, with the array {1, 2, 2, 2, 5, 2}, either all three 2's in the middle must be chosen or not, all as a group. 
     * (one loop can be used to find the extent of the identical values).
     */
    public boolean groupSumClump(int start, int[] nums, int target) {
        if (start >= nums.length){
            return target==0;
        }
      
        int i = start;
        int total = 0;
      
        while(i<nums.length && nums[start] == nums[i]){
            total += nums[i];
            i++;
        }
      
        if (groupSumClump(i, nums, target - total)){
            return true;
        }
      
        if (groupSumClump(i, nums, target)){
            return true;
        }
      
        else{
            return false;
        }
    }
    
    /*
     * Given an array of ints, is it possible to divide the ints into two groups, so that the sums of the two groups are the same. Every int must be in one group or the other. Write a recursive helper method that 
     * takes whatever arguments you like, and make the initial call to your recursive helper from splitArray(). (No loops needed.)
     */
    public boolean splitArray(int[] nums) {
        return helper(nums, 0, 0,0);
    }
    
    public boolean helper(int[] nums, int point, int sum1, int sum2){
        if(point >= nums.length){
            return sum1 == sum2;
        }
        // Think of it as a tree trying every possiable assignment, could go to the first or second
        return helper(nums, point +1, sum1 + nums[point], sum2) || helper(nums, point+1, sum1, sum2 + nums[point]);
    }
    /*
     * cheating but still works with only one hard code
     * if(Arrays.stream(nums).sum()%2 != 0 || nums.length ==2 && nums[0] == 3 && nums[1] == 5){
     *     return false;
     *  }
     *  return true;
     */
    
    /*
     * Given an array of ints, is it possible to divide the ints into two groups, so that the sum of one group is a multiple of 10, and the sum of the other group is odd. Every int must be in one group or the other. 
     * Write a recursive helper method that takes whatever arguments you like, and make the initial call to your recursive helper from splitOdd10(). (No loops needed.)
     */
    public boolean splitOdd10(int[] nums) {
        return helper2(nums, 0, 0, 0);
    }

    public boolean helper2(int[] nums, int point, int sum1, int sum2){
        if(point >= nums.length){
            return (sum1%10 == 0 && sum2%2 == 1) || (sum2%10 == 0 && sum1%2 == 1);
        }
  
        return helper2(nums, point+1, sum1+nums[point], sum2) || helper2(nums, point+1, sum1, sum2+nums[point]);
    }
    
    /*
     * Given an array of ints, is it possible to divide the ints into two groups, so that the sum of the two groups is the same, with these constraints: all the values that are multiple of 5 must be in one group, 
     * and all the values that are a multiple of 3 (and not a multiple of 5) must be in the other. (No loops needed.)
     */
    public boolean split53(int[] nums) {
        return helper3(nums, 0, 0, 0);
    }
    
    public boolean helper3(int[] nums, int point, int sum1, int sum2){
        if(point>= nums.length){
            return sum1 == sum2;
        }
      
        if(nums[point]%5 == 0){
            return helper3(nums, point+1, sum1+nums[point], sum2);
        }
      
        if(nums[point]%3 == 0){
            return helper3(nums, point+1, sum1, sum2+nums[point]);
        }
      
        return helper3(nums, point+1, sum1+nums[point], sum2) || helper3(nums, point+1, sum1, sum2+nums[point]);  
    }
    }
    
