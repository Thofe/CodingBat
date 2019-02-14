/* These are all the solutions I used for String2 on codingbat.com. They are great practice questions for getting into java. Most of these can be reworked and made more efficient or generally better. */
public class String2 {
	
	/* Given a string, return a string where for every char in the original, there are two chars. */
	public String doubleChar(String str) {
		String sum = "";
		  
		for (int i = 0; i < str.length(); i++){
		    sum = sum + str.substring(i, (i+1)) + str.substring(i, (i+1));
		}
		  
		return sum;
	}
	
	/* Return the number of times that the string "hi" appears anywhere in the given string. */
	public int countHi(String str) {
		int count = 0;
		  
		for (int i = 0; i <str.length()-1; i++){
			if ((str.substring(i, i+2)).equals("hi")){
		      count ++;
		    }
		 }
		  
		 return count;
	}
	
	/* Return true if the string "cat" and "dog" appear the same number of times in the given string. */
	public boolean catDog(String str) {
		int catcount = 0;
		int dogcount = 0;
		  
		for (int i = 0; i<str.length() -2; i ++){
			if ((str.substring(i, i+3)).equals("cat")){
				catcount++;
		    }else if ((str.substring(i, i+3)).equals("dog")){
		        dogcount++;
		    }
		}
		  
		return catcount == dogcount;
	}
	
	/* Return the number of times that the string "code" appears anywhere in the given string, except we'll accept any letter for the 'd', so "cope" and "cooe" count. */
	public int countCode(String str) {
		int count = 0;
		  
		for (int i =0; i<str.length()- 3; i++){
			if ((str.substring(i, i+2) + str.substring(i+3, i+4)).equals("coe")){
		      count++;
		    }
		}
		  
		return count;
	}
	
	/*Given two strings, return true if either of the strings appears at the very end of the other string, ignoring upper/lower case differences (in other words, the computation should not be "case sensitive"). 
	 * Note: str.toLowerCase() returns the lowercase version of a string. */
	
	public boolean endOther(String a, String b) {
		a = a.toLowerCase();
		b = b.toLowerCase();
		  
		if (a.length() == b.length()){
			if ((a.substring(a.length()-b.length(), a.length()).equals(b)) || (b.substring(b.length()-a.length(), b.length()).equals(a))){
		    	return true;
		    }
		}else if (a.length() > b.length()){
		    if (a.substring(a.length()-b.length(), a.length()).equals(b)){
		    	return true;
		    }
		}else if (b.length() > a.length()){
		    if ((b.substring(b.length()-a.length(), b.length()).equals(a))){
		    	return true;
		    }
		}
		  
		return false;
	}
	
	/* Return true if the given string contains an appearance of "xyz" where the xyz is not directly preceeded by a period (.). So "xxyz" counts but "x.xyz" does not. */
	public boolean xyzThere(String str) {
		if (str.length()>=3 && str.substring(0,3).equals("xyz")){
		    return true;
		}

		for (int i =1; i < str.length()-2; i++){
		    if (str.substring(i, i+3).equals("xyz") && (!(str.substring(i-1,i).equals(".")))){
		    	return true;
		    }
		}  

		return false;
	}
	
	/* Return true if the given string contains a "bob" string, but where the middle 'o' char can be any char. */
	public boolean bobThere(String str) {
		if (str.length()>=3){
			for (int i =0; i < str.length()-2; i++){
		    	if (str.substring(i,i+1).equals("b") && str.substring(i+2, i+3).equals("b")){
		    		return true;
		    	}
		    }
		}
		  
		return false;
	}
	
	/* We'll say that a String is xy-balanced if for all the 'x' chars in the string, there exists a 'y' char somewhere later in the string. So "xxy" is balanced, but "xyx" is not. One 'y' can balance multiple 'x's. 
	 * Return true if the given string is xy-balanced. */
	public boolean xyBalance(String str) {
		boolean ythere= false;
		  
		for (int i  = str.length()-1;i>=0; i--){
		    if (str.substring(i, i+1).equals("y")){
		    	ythere=true;
		    }else if (str.substring(i, i+1).equals("x")  && !ythere){
		    	return false;
		    }
		}
		  
		return true;
	}
	
	/* Given two strings, a and b, create a bigger string made of the first char of a, the first char of b, the second char of a, the second char of b, and so on. Any leftover chars go at the end of the result. */
	public String mixString(String a, String b) {
		String mix = "";
		int big = a.length();
		  
		if (b.length()>big){
		    big = b.length();
		}
		  
		for(int i = 0; i<big; i++){
		    if (i >= a.length()){
		    	mix = mix + b.substring(i, b.length());
		    	break;
		    }else if ( i >= b.length()){
		    	mix = mix + a.substring(i, a.length());
		    	break;
		    }else{
		    	mix = mix + a.substring(i, i+1) + b.substring(i, i+1);
		    }
		}
		  
		return mix;
	}
	
	/* Given a string and an int n, return a string made of n repetitions of the last n characters of the string. You may assume that n is between 0 and the length of the string, inclusive. */
	public String repeatEnd(String str, int n) {
		String returnable = "";
		String end = str.substring(str.length()-(n), str.length());
		  
		int i = 0;
		  
		while (i<n){
		    returnable = returnable + end;
		    i++;
		}
		  
		return returnable;
	}
	
	/* Given a string and an int n, return a string made of the first n characters of the string, followed by the first n-1 characters of the string, and so on. 
	 * You may assume that n is between 0 and the length of the string, inclusive (i.e. n >= 0 and n <= str.length()). */
	public String repeatFront(String str, int n) {
		String returnable = "";
		int nstart = n;
		int i =0;
		  
		while (i<nstart){
		    returnable = returnable + (str.substring(0,n));
		    n--;
		    i++;
		}
		  
		return returnable;
	}
	
	/* Given two strings, word and a separator sep, return a big string made of count occurrences of the word, separated by the separator string. */
	public String repeatSeparator(String word, String sep, int count) {
		String returnable = "";
		  
		int i = 0;
		  
		while (i<count){
		    if (i == count-1){
		    	returnable = returnable + word;
		    }else{
		    	returnable = returnable + word + sep;
		    }
		    i++;
		}
		  
		return returnable;
	}
	
	/* Given a string, consider the prefix string made of the first N chars of the string. Does that prefix string appear somewhere else in the string? Assume that the string is not empty and that N is in the range 1..str.length().*/
	public boolean prefixAgain(String str, int n) {
		String prefix = str.substring(0,n);
		  
		for (int i = n; i<=str.length() - n; i++){
		    if (str.substring(i, i+n).equals(prefix)){
		    	return true;
		    }
		}
		  
		return false;
	}
	
	/* Given a string, does "xyz" appear in the middle of the string? To define middle, we'll say that the number of chars to the left and right of the "xyz" must differ by at most one. This problem is harder than it looks. */
	public boolean xyzMiddle(String str) {
		int length = str.length();
		  
		if (length >=3){
		    if (length%2  != 0){
		    	return str.substring(length/2 -1,  length/2 +2).equals("xyz");
		    }else{
		    	return str.substring(length/2 -2 , length/2 +1).equals("xyz") || str.substring(length/2 -1 , length/2 +2).equals("xyz");
		    }
		}else{
		    return false;
		}
	}
	
	/* A sandwich is two pieces of bread with something in between. Return the string that is between the first and last appearance of "bread" in the given string, or return the empty string "" if there are not two pieces of bread. */
	public String getSandwich(String str) {
		int bread1 = str.indexOf("bread");
		int bread2 = str.lastIndexOf("bread");
		  
		if (bread1 != bread2){
		    return str.substring(bread1 +5, bread2);
		}
		  
		return "";
	}

	/* Returns true if for every '*' (star) in the string, if there are chars both immediately before and after the star, they are the same. */
	public boolean sameStarChar(String str) {
		boolean stargood = true;
		  
		for (int i = 1; i <str.length()-1; i++){
		    if (str.substring(i,i+1).equals("*") && !(str.substring(i-1, i).equals(str.substring(i+1, i+2)))){
		    	stargood = false;
		    }
		}
		  
		return stargood;
	}
	
	/* Given a string, compute a new string by moving the first char to come after the next two chars, so "abc" yields "bca". Repeat this process for each subsequent group of 3 chars, so "abcdef" yields "bcaefd". 
	 * Ignore any group of fewer than 3 chars at the end. */
	public String oneTwo(String str) {
		String temp = str;
		String edited = "";
		  
		while (temp.length() >=3){
		    edited = edited + temp.substring(1,3) + temp.substring(0,1);
		    temp = temp.substring(3,temp.length());
		}
		  
		return edited;
	}
	
	/* Look for patterns like "zip" and "zap" in the string -- length-3, starting with 'z' and ending with 'p'. Return a string where for all such words, the middle letter is gone, so "zipXzap" yields "zpXzp". */
	public String zipZap(String str) {
		for (int i = 0; i<str.length() -2; i++){
		    if (str.substring(i,i+1).equals("z") && str.substring(i+2, i+3).equals("p")){
		    	str = str.substring(0,i+1) + str.substring(i+2,str.length());
		    }
		}
		  
		return str;
	}

	/* Return a version of the given string, where for every star (*) in the string the star and the chars immediately to its left and right are gone. So "ab*cd" yields "ad" and "ab**cd" also yields "ad". */
	public String starOut(String str) {
		int count = 0;
		  
		for (int i = 0; i<str.length(); i++){
		    if (str.substring(i,i+1).equals("*")){
		    	count++;
		    }
		}
		  
		int[] a = new int[count];
		int c = 0;
		  
		for (int i = 0; i<str.length(); i++){
		    if (str.substring(i,i+1).equals("*")){
		    	a[c] = i;
		    	c++;
		    }
		}
		 
		String returnable = "";
		  
		for (int i =0; i<str.length(); i++){
		    if (isOk(i, a)){
		    	returnable = returnable + str.substring(i,i+1);
		    }
		}
		  
		return returnable;
	}

	public boolean isOk(int index, int[] a){
		for (int i =0; i<a.length; i++){
			if (index == a[i] || index +1 == a[i] || index-1 == a[i]){
				return false;
		    }	
		}
		return true;
	}
	
	/* Given a string and a non-empty word string, return a version of the original String where all chars have been replaced by pluses ("+"), except for appearances of the word string which are preserved unchanged. */
	public String plusOut(String str, String word) {
		int n = word.length();
		String returnable = "";
		  
		for (int i=0; i<str.length();i++){
		    if (i<= str.length()-n){
		    	if(str.substring(i, i+n).equals(word)){
		    		returnable = returnable + word;
		    		i+= n-1;
		    	}else{
		    		returnable = returnable + "+";
		    	}
		    }else{
		    	returnable = returnable + "+";
		    }
		}
		  
		return returnable;
	}
	
	/* Given a string and a non-empty word string, return a string made of each char just before and just after every appearance of the word in the string. 
	 * Ignore cases where there is no char before or after the word, and a char may be included twice if it is between two words. */
	public String wordEnds(String str, String word) {
		int n = word.length();
		int len = str.length();
		String returnable = "";
		  
		for (int i=0; i<len-n+1; i++){
		    if (i>0 && str.substring(i,i+n).equals(word)){
		    	returnable = returnable + str.substring(i-1, i);
		    }
		    if ( i< len- n && str.substring(i,i+n).equals(word)){
		    	returnable = returnable + str.substring(i+n, i+n+1);
		    }
		}
		  
		return returnable;
	}
}
