/* These are all the solutions I used for String3 on codingbat.com. They are great practice questions for getting into java. Most of these can be reworked and made more efficient or generally better. */
public class String3 {
	
	/* Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count, but not the 'y' in "yellow" (not case sensitive). 
	 * We'll say that a y or z is at the end of a word if there is not an alphabetic letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.) */
	public int countYZ(String str) {
		int count = 0;
		str = str.toLowerCase();
		  
		for (int i =0; i < str.length(); i++){
		    char current = str.charAt(i);
		    
		    if(current == 'y' || current== 'z'){
		    	if (str.length()==i+1 || !Character.isLetter(str.charAt(i+1))){
		    		count ++;
		    	}
		    }
		    
		}
		  
		return count;
	}
	
	/* Given two strings, base and remove, return a version of the base string where all instances of the remove string have been removed (not case sensitive). 
	 * You may assume that the remove string is length 1 or more. Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x". */
	public String withoutString(String base, String remove) {
		String working = base;
		  
		while (working.toLowerCase().indexOf(remove.toLowerCase())!=-1){
		    String lowerWorking = working.toLowerCase();
		    int index = lowerWorking.indexOf(remove.toLowerCase());
		    
		    working = working.substring(0,index) + working.substring(index+(remove.length()));
		}
		  
		return working;
	}
	
	/* Given a string, return true if the number of appearances of "is" anywhere in the string is equal to the number of appearances of "not" anywhere in the string (case sensitive). */
	public boolean equalIsNot(String str) {
		int notCount = 0;
		int isCount = 0;
		  
		for (int i = 0; i < str.length()-2; i++){
		    if (str.substring(i, i+3).equals("not")) notCount++;
		}
		  
		for (int i = 0; i < str.length()-1; i++){
		    if (str.substring(i, i+2).equals("is")) isCount++;
		}
		  
		return notCount == isCount;
	}
	
	/* We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right. Return true if all the g's in the given string are happy. */
	public boolean gHappy(String str) {
		if (str.length() < 2 && str.indexOf("g")!= -1) return false;
		  
		for (int i =1; i < str.length()-1; i++){
		    if (str.charAt(i)=='g' && !(str.charAt(i-1) == 'g' || str.charAt(i+1) == 'g')){
		    	return false;
		    }
		}
		  
		if (str.length()>1 && str.charAt(str.length()-1) == 'g' && str.charAt(str.length()-2) != 'g') return false;
		  
		return true;
	}
	
	/* We'll say that a "triple" in a string is a char appearing three times in a row. Return the number of triples in the given string. The triples may overlap. */
	public int countTriple(String str) {
		int count = 0;
		  
		for (int i = 1; i< str.length()-1; i++){
		    char first = str.charAt(i-1);
		    char second = str.charAt(i);
		    char third = str.charAt(i+1);
		    
		    if (first == second && second == third) count++;
		}
		  
		return count;
	}
	
	/* Given a string, return the sum of the digits 0-9 that appear in the string, ignoring all other characters. Return 0 if there are no digits in the string. (Note: Character.isDigit(char) tests if a char is one of the chars '0', '1', .. '9'. 
	 * Integer.parseInt(string) converts a string to an int.) */
	public int sumDigits(String str) {
		int sum =0;
		  
		for(int i =0; i <str.length(); i++){
		    char c = str.charAt(i);
		    
		    if (Character.isDigit(c)){
		    	sum += Integer.valueOf(str.substring(i,i+1));
		    } 
		}
		  
		return sum;
	}
	
	/* Given a string, return the longest substring that appears at both the beginning and end of the string without overlapping. For example, sameEnds("abXab") is "ab". */
	public String sameEnds(String str) {
		String returnable = "";
		  
		for (int i =1; i <= (str.length()/2); i ++){
		    String start = str.substring(0,i);
		    String end = str.substring(str.length()-i);
		    
		    if (start.equals(end)){
		    	returnable= start;
		    }
		}
		  
		return returnable;
	}
	
	/* Given a string, look for a mirror image (backwards) string at both the beginning and end of the given string. In other words, zero or more characters at the very begining of the given string, and at the very end of the string in reverse order 
	 * (possibly overlapping). For example, the string "abXYZba" has the mirror end "ab". */
	public String mirrorEnds(String str) {
		String returnable = "";
		  
		String str2 = "";
		  
		for (int i =str.length()-1; i >=0; i--){
		    str2 += str.substring(i,i+1);
		}
		  
		for (int i =1; i <= str.length(); i ++){
		    String start = str.substring(0,i);
		    String end = str2.substring(0,i);
		    
		    if (start.equals(end)){
		    	returnable= start;
		    }
		}
		  
		return returnable;
	}
	
	/* Given a string, return the length of the largest "block" in the string. A block is a run of adjacent chars that are the same. */
	public int maxBlock(String str) {
		int blockMax = 0;
		  
		int currentBlock = 1;
		  
		if (str.length() == 0) return 0;
		  
		char workingChar = str.charAt(0);
		  
		for (int i =1; i <str.length(); i++){
		    if (str.charAt(i) == workingChar){
		    	currentBlock ++;
		    }else{
		    	workingChar = str.charAt(i);
		    	currentBlock = 1;
		    }
		    if (currentBlock > blockMax) blockMax = currentBlock;
		}
		  
		return blockMax;
	}
	

	/* Given a string, return the sum of the numbers appearing in the string, ignoring all other characters. A number is a series of 1 or more digit chars in a row. (Note: Character.isDigit(char) tests if a char is one of the chars '0', '1', .. '9'. 
	 * Integer.parseInt(string) converts a string to an int.) */
	public int sumNumbers(String str) {
		int sum = 0;
		  
		for (int i =0; i < str.length(); i ++){
		    char currChar = str.charAt(i);
		    
		    if (Character.isDigit(currChar)){
		    	int j = i;
		      
		    	while (j < str.length() && Character.isDigit(str.charAt(j))){
		    		j++;
		    	}
		      
		    	sum += Integer.parseInt(str.substring(i, j));
		      
		    	i=j;
		    }
		    
		}
		
		return sum;
	}
	
	/* Given a string, return a string where every appearance of the lowercase word "is" has been replaced with "is not". The word "is" should not be immediately preceeded or followed by a letter -- so for example the "is" in "this" does not count. 
	 * (Note: Character.isLetter(char) tests if a char is a letter.) */
	public String notReplace(String str) {
		if (str.length() < 2){
		    return str;
		}
		  
		if (str.equals("is")){
		    return "is not";
		}
		  
		if (str.substring(0,2).equals("is") && !Character.isLetter(str.charAt(2))) str = "is not" + str.substring(2);
		  
		for(int i = 1; i < str.length() - 2; i ++){
		    char prior = str.charAt(i-1);
		    char post = str.charAt(i+2);
		    
		    boolean isPrior = Character.isLetter(prior);
		    boolean isPost = Character.isLetter(post);
		    
		    if (str.substring(i, i+2).equals("is") && !isPost && !isPrior){
		    	str = str.substring(0,i-1) + " is not" + str.substring(i+2);
		    }
		}
		  
		  if (str.substring(str.length()-2,str.length()).equals("is") && !Character.isLetter(str.charAt(str.length()-3))){
			  str = str + " not";
		  }
		  
		return str;
	}
}
