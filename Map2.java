import java.util.HashMap;
import java.util.Map;
/* These are all the solutions I used for Map1 on codingbat.com. They are great practice questions for getting into java. Most of these can be reworked and made more efficient or generally better. */
public class Map2
{
    /*
     * Given an array of strings, return a Map<String, Integer> containing a key for every different string in the array, always with the value 0. 
     * For example the string "hello" makes the pair "hello":0. We'll do more complicated counting later, but for this problem the value is simply 0.
     */
    public Map<String, Integer> word0(String[] strings) {
        Map<String, Integer> map = new HashMap<String, Integer>();
      
        for (String s: strings){
            if (!map.containsKey(s)){
                map.put(s, 0);
            }
        }
      
        return map;
    }

    /*
     * Given an array of strings, return a Map<String, Integer> containing a key for every different string in the array, and the value is that string's length.
     */
    public Map<String, Integer> wordLen(String[] strings) {
        Map<String, Integer> map = new HashMap<String, Integer>();
      
        for (String s: strings){
            if (!map.containsKey(s)){
                map.put(s, s.length());
            }
        }
      
        return map;
    }

    /*
     * Given an array of non-empty strings, create and return a Map<String, String> as follows: for each string add its first character as a key with its last character as the value.
     */
    public Map<String, String> pairs(String[] strings) {
        Map<String, String> map = new HashMap<String, String>();
  
        for (String s: strings){
            String first = s.substring(0,1);
            String last = s.substring(s.length()-1);
            map.put(first, last);
        }
    
        return map;
    }
    
    /*
     * The classic word-count algorithm: given an array of strings, return a Map<String, Integer> with a key for each different string, with the value the number of times that string appears in the array.
     */
    public Map<String, Integer> wordCount(String[] strings) {
        Map<String, Integer> map = new HashMap<String, Integer>();
  
        for (String s: strings){
            if (!map.containsKey(s)){
                map.put(s, 1);
            }else{
                map.put(s, map.get(s)+1);
            }
        }
  
        return map;
    }

    /*
     * Given an array of non-empty strings, return a Map<String, String> with a key for every different first character seen, 
     * with the value of all the strings starting with that character appended together in the order they appear in the array.
     */
    public Map<String, String> firstChar(String[] strings) {
        Map<String, String> map = new HashMap<String, String>();
  
        for (String s: strings){
            String first = s.substring(0,1);

            if (map.containsKey(first)){
                map.put(first, map.get(first) + s);
            }else{
                map.put(first, s);
            }
        }
  
        return map;
    }

    /*
     * Loop over the given array of strings to build a result string like this: when a string appears the 2nd, 4th, 6th, etc. time in the array, append the string to the result. Return the empty string if no string appears a 2nd time.
     */
    public String wordAppend(String[] strings) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        String returnable = "";
      
        for (String s: strings){
            if (!map.containsKey(s)){
                map.put(s, 1);
            }else{
                returnable += s;
                map.remove(s);
            }
        }
      
        return returnable;
    }

    /*
     * Given an array of strings, return a Map<String, Boolean> where each different string is a key and its value is true if that string appears 2 or more times in the array.
     */
    public Map<String, Boolean> wordMultiple(String[] strings) {
        Map<String, Boolean> map = new HashMap<String, Boolean>();
      
        for (String s: strings){
            if (!map.containsKey(s)){
                map.put(s, false);
            }else{
                map.put(s, true);
            }
        }
      
        return map;
    }
    
    /*
     * We'll say that 2 strings "match" if they are non-empty and their first chars are the same. Loop over and then return the given array of non-empty strings as follows: if a string matches an earlier string in the array, 
     * swap the 2 strings in the array. When a position in the array has been swapped, it no longer matches anything. Using a map, this can be solved making just one pass over the array. More difficult than it looks.
     */
    public String[] allSwap(String[] strings) {
        Map<String, Integer> map = new HashMap<String, Integer>();
  
        for (int i =0; i < strings.length; i++){
            if (!map.containsKey(strings[i].substring(0,1))){
                map.put(strings[i].substring(0,1), i);
            }else{
                String temp = strings[map.get(strings[i].substring(0,1))];
                strings[map.get(strings[i].substring(0,1))] = strings[i];
                strings[i] = temp;
                map.remove(strings[i].substring(0,1));
            }
        }
  
        return strings;
    }

    /*
     * We'll say that 2 strings "match" if they are non-empty and their first chars are the same. Loop over and then return the given array of non-empty strings as follows: if a string matches an earlier string in the array, 
     * swap the 2 strings in the array. A particular first char can only cause 1 swap, so once a char has caused a swap, its later swaps are disabled. Using a map, this can be solved making just one pass over the array. 
     * More difficult than it looks.
     */
    public String[] firstSwap(String[] strings) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        Map<String, Boolean> map2 = new HashMap<String, Boolean>();
      
        for (int i =0; i < strings.length; i++){
            if (!map.containsKey(strings[i].substring(0,1))){
                map.put(strings[i].substring(0,1), i);
            }else if (!map2.containsKey(strings[i].substring(0,1))){
                String temp = strings[map.get(strings[i].substring(0,1))];
                strings[map.get(strings[i].substring(0,1))] = strings[i];
                strings[i] = temp;
                map.remove(strings[i].substring(0,1));
                map2.put(strings[i].substring(0,1), true);
            }
        }
      
        return strings;
    }
}
