/* These are all the solutions I used for Array2 on codingbat.com. They are great practice questions for getting into java. Most of these can be reworked and made more efficient or generally better. */
public class Array2
{
  /*
   *Return the number of even ints in the given array. Note: the % "mod" operator computes the remainder, e.g. 5 % 2 is 1.
   */
  public int countEvens(int[] nums) {
    int count = 0;
    for (int j: nums){
        if (j%2 == 0){
          count++;
        }
    }
    return count;
  }
  
  /*
   *Given an array length 1 or more of ints, return the difference between the largest and smallest values in the array. 
   *Note: the built-in Math.min(v1, v2) and Math.max(v1, v2) methods return the smaller or larger of two values.
   */
  public int bigDiff(int[] nums) {
    int max = nums[0];
    int min = nums[0];

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > max) max = nums[i];  
      if (nums[i] <= min) min = nums[i];
    }
    return max - min;
  }
  
  /*
   *Return the "centered" average of an array of ints, which we'll say is the mean average of the values, except ignoring the 
   *largest and smallest values in the array. If there are multiple copies of the smallest value, ignore just one copy, and 
   *likewise for the largest value. Use int division to produce the final average. You may assume that the array is length 3 or more.
   */
  public int centeredAverage(int[] nums) {
    int max = nums[0];
      int min = nums[0];
      int sum = 0;

      for (int j: nums) {
          sum += j;
          if (j > max){
             max = j;
          }else if (j < min){
             min = j;
          }
      }
      return (sum - (max + min)) / (nums.length - 2);
  }
  
  /*
   * Return the sum of the numbers in the array, returning 0 for an empty array. Except the number 13 is very unlucky, 
   * so it does not count and numbers that come immediately after a 13 also do not count.
   */
  public int sum13(int[] nums) {
    int sum = 0;

    for (int i = 0; i <nums.length; i++){
      if (nums[i] != 13){
        sum += nums[i];
      }else if (i <= nums.length - 1){
        i++;
      }
    }

    return sum;
  }

  /*
   * Return the sum of the numbers in the array, except ignore sections of numbers starting with a 6 and extending to the next 7 
   * (every 6 will be followed by at least one 7). Return 0 for no numbers.
   */
  public int sum67(int[] nums) {
    int sum = 0;

    for (int i = 0; i<nums.length; i++){
      if (nums[i] != 6){
        sum += nums[i];
      }else{
        while (nums[i] != 7){
          i++;
        }
      }
    }

    return sum;
  }

  /*
   * Given an array of ints, return true if the array contains a 2 next to a 2 somewhere.
   */
  public boolean has22(int[] nums) {
    for (int i = 0; i < nums.length -1; i ++){
      if (nums[i]==2 && nums[i + 1] == 2){
        return true;
      }
    }
    return false;
  }
  
  /*
   * Given an array of ints, return true if the array contains no 1's and no 3's
   */
  public boolean lucky13(int[] nums) {
    for (int j: nums){
      if (j == 3 || j == 1){
        return false;
      }
    }
    return true;
  }
  
  /*
   *  Given an array of ints, return true if the sum of all the 2's in the array is exactly 8.
   */
  public boolean sum28(int[] nums) {
    int count = 0;

    for (int j: nums){
      if (j == 2){
        count += 2;
      }
    }

    return count==8;
  }
  
  /*
   * Given an array of ints, return true if the number of 1's is greater than the number of 4's
   */
  public boolean more14(int[] nums) {
    int countone = 0;
    int countfour = 0;

    for (int j: nums){
      if (j == 1){
        countone ++;
      }else if (j == 4){
        countfour ++;
      }
    }

    return countone>countfour;
  }
  
  /*
   *Given a number n, create and return a new int array of length n, containing the numbers 0, 1, 2, ... n-1. 
   *The given n may be 0, in which case just return a length 0 array. You do not need a separate if-statement for the 
   *length-0 case; the for-loop should naturally execute 0 times in that case, so it just works. The syntax to make a new 
   *int array is: new int[desired_length]
   */
  public int[] fizzArray(int n) {
    int[] x = new int[n];

    for (int i = 0; i <x.length; i++){
      x[i] = i;
    }

    return x;
  }

  /*
   *Given an array of ints, return true if every element is a 1 or a 4
   */
  public boolean only14(int[] nums) {
    for (int j: nums){
      if (!(j == 1 || j == 4)){
        return false;
      }
    }
    return true;
  }
  
  /*
   *Given a number n, create and return a new string array of length n, containing the strings "0", "1" "2" .. 
   *through n-1. N may be 0, in which case just return a length 0 array. Note: String.valueOf(xxx) will make the String 
   *form of most types. The syntax to make a new string array is: new String[desired_length] 
   */
  public String[] fizzArray2(int n) {
    String[] x = new String[n];
    for (int i = 0; i<n; i++){
      x[i] = Integer.toString(i);
    }
    return x;
  }

  /*
   * Given an array of ints, return true if it contains no 1's or it contains no 4's.
   */
  public boolean no14(int[] nums) {
    String numss = Arrays.toString(nums);

    if(numss.indexOf("1")!= -1 && numss.indexOf("4") != -1){
      return false;
    }

    return true;  
  }
  
  /*
   * We'll say that a value is "everywhere" in an array if for every pair of adjacent elements in the array, at least 
   * one of the pair is that value. Return true if the given value is everywhere in the array.
   */
  public boolean isEverywhere(int[] nums, int val) {
    for (int i = 1; i < nums.length; i ++){
      if (!(nums[i-1] == val || nums[i] == val)){
        return false;
      }
    }
    return true;
  }

  /*
   * Given an array of ints, return true if the array contains a 2 next to a 2 or a 4 next to a 4, but not both.
   */
  public boolean either24(int[] nums) {
    boolean fourseen = false;
    boolean twoseen = false;

    for (int i= 1; i<nums.length; i++){
      if (nums[i-1] == 4 && nums[i] == 4){
        fourseen= true;
      }else if (nums[i-1] == 2 && nums[i] == 2){
        twoseen= true;
      }
    }

    return fourseen ^ twoseen;
  }

  /*
   * Given arrays nums1 and nums2 of the same length, for every element in nums1, consider the corresponding element in 
   * nums2 (at the same index). Return the count of the number of times that the two elements differ by 2 or less, but are 
   * not equal
   */
  public int matchUp(int[] nums1, int[] nums2) {
    int count = 0;

    for (int i = 0; i<nums1.length; i++){
      if (Math.abs(nums2[i]-nums1[i])<3 && nums2[i] != nums1[i]){
        count += 1;
      }
    }
    return count;
  }
  
  /*
   * Given an array of ints, return true if the array contains two 7's next to each other, or there are two 7's separated by one element, such as with {7, 1, 7}.
   */
  public boolean has77(int[] nums) {
    for (int i = 2; i < nums.length; i++){
      if (nums[i-2] == 7 && nums[i-1] ==7 || nums[i-2] == 7 && nums[i] ==7 || nums[i-1] == 7 && nums[i] ==7 ){
        return true;
      }
    }
    return false;
  }

  /*
   * Given an array of ints, return true if there is a 1 in the array with a 2 somewhere later in the array
   */
  public boolean has12(int[] nums) {
    boolean oneseen = false;
    boolean twoseen = false;

    for (int j: nums){
      if (j == 1){
        oneseen = true;
      }else if (j == 2 && oneseen){
        twoseen = true;
      }
    }

    return (oneseen && twoseen);  
  }

  /*
   * Given an array of ints, return true if the array contains either 3 even or 3 odd values all next to each other.
   */
  public boolean modThree(int[] nums) {
    boolean threeodd = false;
    boolean threeeven= false;

    for (int i =2; i<nums.length; i++){
      if (nums[i-2]%2 == 0 && nums[i-1]%2 == 0 && nums[i]%2== 0){
        threeeven = true;
      }else if (nums[i-2]%2 == 1 && nums[i-1]%2 == 1 && nums[i]%2== 1){

        threeodd = true;
      }
    }
    return (threeodd || threeeven);
  }

  /*
   * Given an array of ints, return true if the value 3 appears in the array exactly 3 times, and no 3's are next to each other.
   */
  public boolean haveThree(int[] nums) {
    int threecount = 0;
    boolean prevthree = false;

    for (int j: nums){
      if (j == 3 && !prevthree){
        threecount++;
        prevthree = true;
      }else if (j == 3 && prevthree){
        return false;
      }else{
        prevthree = false;
      }
    }

    return (threecount == 3);
  }

  /*
   * Given an array of ints, return true if every 2 that appears in the array is next to another 2.
   */
  public boolean twoTwo(int[] nums) {
    boolean doubletwo = true;

    for (int i = 1; i<nums.length; i++){
      if (nums[i] == 2){
        if (i+1<nums.length){
          if (!(nums[i-1] == 2 || nums[i+1] == 2)){
            doubletwo = false;
          }
        }else{
          if (!(nums[i-1] == 2)){
            doubletwo = false;
          }
        }
      }
    }

    if (nums.length  == 1 && nums[0] ==2){
      doubletwo = false;
    }

    return doubletwo;
  }
  
  /* 
   * Return true if the group of N numbers at the start and end of the array are the same. For example, with 
   * {5, 6, 45, 99, 13, 5, 6}, the ends are the same for n=0 and n=2, and false for n=1 and n=3. You may assume that n 
   * is in the range 0..nums.length inclusive.
   */
  public boolean sameEnds(int[] nums, int len) {
    for (int i = len-1; i >=0; i--){
      if (nums[(len-1)-i] != nums[(nums.length-1)-i]){
        return false;
      }
    }

    return true;
  }
  
  /*
   * Return true if the array contains, somewhere, three increasing adjacent numbers like .... 4, 5, 6, ... or 23, 24, 25.
   */
  public boolean tripleUp(int[] nums) {
    boolean trip = false;
    int nums1 = 0;
    int nums2 = 0;
    int nums3 = 0;

    for (int i = 2; i<nums.length; i++){
        if (nums[i-2] +1 == nums[i-1] && nums[i-1] +1 == nums[i]){
          trip = true;
        }
    }

    return trip;
  }
  
  /*
   * Given start and end numbers, return a new array containing the sequence of integers from start up to but not including 
   * end, so start=5 and end=10 yields {5, 6, 7, 8, 9}. The end number will be greater or equal to the start number. Note that 
   * a length-0 array is valid.
   */
  public int[] fizzArray3(int start, int end) {
    int[] x = new int[end-start];
    int z = 0;

    while (z < x.length){
      x[z] = start + z;
      z++;
    }

    return x;
  }
  
  /*
   * Return an array that is "left shifted" by one -- so {6, 2, 5, 3} returns {2, 5, 3, 6}. You may modify and return the given array, or return a new array.
   */
  public int[] shiftLeft(int[] nums) {
    if (nums.length>1){
      int start = nums[0];
      for (int i =0; i<nums.length; i++){
        if (i == nums.length-1){
          nums[i] = start;
        }else
          nums[i] = nums[i +1];
      }
    }

    return nums;
  }
  
  /*
   * For each multiple of 10 in the given array, change all the values following it to be that multiple of 10, until encountering another multiple of 
   * 10. So {2, 10, 3, 4, 20, 5} yields {2, 10, 10, 10, 20, 20}.
   */
  public int[] tenRun(int[] nums) {
    boolean tenseen = false;
    int ten = 0;

    for (int i = 0; i < nums.length; i++){
      if (nums[i]%10 == 0){
        tenseen = true;
        ten = nums[i];
      }else if (tenseen){  
        nums[i] = ten;
      }
    }

    return nums;
  }

  /*
   * Given a non-empty array of ints, return a new array containing the elements from the original array that come before the first 4 in the original array. 
   * The original array will contain at least one 4. Note that it is valid in java to create an array of length 0.
   */
  public int[] pre4(int[] nums) {
    boolean seen4 = false;

    int i = 0;
    while (!seen4){
      if (nums[i] == 4){
        break;
      }
      i ++;
    }

    int[] x = new int[i];
    seen4 = false;

    i=0;
    while (i<x.length){
      x[i]= nums[i];
      i ++;
    }
    return x;
  }

  /*
   * Given a non-empty array of ints, return a new array containing the elements from the original array that come after the last 4 
   * in the original array. The original array will contain at least one 4. Note that it is valid in java to create an array of 
   * length 0.
   */
  public int[] post4(int[] nums) {
    boolean seen4 = false;
    int i = nums.length-1;
    int counter = 0;

    while (!seen4){
      if (nums[i] == 4){
        seen4 = true;
      }else{
        counter++;
        i--;
      }
    }
    int downcounter = nums.length-1;
    int[] x = new int[counter];

    while (counter>0){
      x[counter-1]= nums[downcounter];
      downcounter --;
      counter --;
    }

    return x;
  }

  /*
   * We'll say that an element in an array is "alone" if there are values before and after it, and those values are different 
   * from it. Return a version of the given array where every instance of the given value which is alone is replaced by whichever 
   * value to its left or right is larger.
   */
  public int[] notAlone(int[] nums, int val) {
    for (int i = 0; i < nums.length; i++){
      if (i >= 1 && i< nums.length- 1 && nums[i] == val && nums[i-1] != val && nums[i+1] != val){
        if (nums[i+1] >= nums[i-1]){
          nums[i] = nums[i+1];
        }else{
          nums[i] = nums[i-1];
        }
      }
    }

    return nums;
  }

  /*
   * Return an array that contains the exact same numbers as the given array, but rearranged so that all the zeros are 
   * grouped at the start of the array. The order of the non-zero numbers does not matter. So {1, 0, 0, 1} becomes {0 ,0, 1, 1}. 
   * You may modify and return the given array or make a new array.
   */
  public int[] zeroFront(int[] nums) {
    int[] x = new int[nums.length];
    int othercount = 1;
    for (int i =0; i<nums.length; i++){
      if (nums[i] != 0){
        x[x.length-othercount] = nums[i];
        othercount ++;
      }
    }
    return x;
  }
  
  /*
   * Return a version of the given array where all the 10's have been removed. The remaining elements should shift 
   * left towards the start of the array as needed, and the empty spaces a the end of the array should be 0. So {1, 10, 10, 2} 
   * yields {1, 2, 0, 0}. You may modify and return the given array or make a new array.
   */
  public int[] withoutTen(int[] nums) {
    int[] x = new int[nums.length];
    int tencount = 0;
    int backcount = 1;
    for (int i =0; i<x.length; i++){
      if (nums[i] == 10){
        x[x.length-backcount] = 0;
        backcount++;
        tencount ++;
      }else{
        x[i-tencount] = nums[i];
      }
    }
    return x;
  }

  /*
   * Return a version of the given array where each zero value in the array is replaced by the largest odd value to the right of 
   * the zero in the array. If there is no odd value to the right of the zero, leave the zero as a zero.
   */
  public int[] zeroMax(int[] nums) {
    int largeodd = 0;
    int[] x = new int[nums.length];

    for (int i = nums.length-1; i>=0; i--){
      if (nums[i] == 0){
        x[i] = largeodd;
      }else{
        if (nums[i]%2 == 1 && nums[i]>largeodd){
          largeodd = nums[i];
        }
        x[i] = nums[i];
      }
    }
    return x;
  }
  
  /*
   * Return an array that contains the exact same numbers as the given array, but rearranged so that all the even numbers come 
   * before all the odd numbers. Other than that, the numbers can be in any order. You may modify and return the given array,
   * or make a new array.
   */
  public int[] evenOdd(int[] nums) {
    int oddcount = 0;
    int evencount = 0;
    int[] x = new int[nums.length];

    for (int i = 0; i < nums.length; i ++){
      if (nums[i]%2== 1){
        x[x.length-(oddcount+1)]= nums[i];
        oddcount++;
      }else{
        x[evencount] = nums[i];
        evencount++;
      }
    }

    return x;
  }
  
  /*
   * This is slightly more difficult version of the famous FizzBuzz problem which is sometimes given as a first problem for 
   * job interviews. (See also: FizzBuzz Code.) Consider the series of numbers beginning at start and running up to but not 
   * including end, so for example start=1 and end=5 gives the series 1, 2, 3, 4. Return a new String[] array containing the 
   * string form of these numbers, except for multiples of 3, use "Fizz" instead of the number, for multiples of 5 use "Buzz", 
   * and for multiples of both 3 and 5 use "FizzBuzz". In Java, String.valueOf(xxx) will make the String form of an int or other 
   * type. This version is a little more complicated than the usual version since you have to allocate and index into an array 
   * instead of just printing, and we vary the start/end instead of just always doing 1..100
   */
  public String[] fizzBuzz(int start, int end) {
    String[] x = new String[end-start];

    int i = 0;
    int counter = start;
    while (i<x.length){
      if (counter%3 == 0 && counter%5 ==0){
        x[i]= "FizzBuzz";
      }else if (counter%3 ==0){
        x[i]= "Fizz";
      }else if (counter%5 ==0){
        x[i]= "Buzz";
      }else{
        x[i]= String.valueOf(counter);
      }
      counter ++;
      i ++;
    }

    return x;
  }
}
