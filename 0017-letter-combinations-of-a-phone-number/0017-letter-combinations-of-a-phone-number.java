class Solution {
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List output = new ArrayList();

    private void letterCombinations(String digits,StringBuffer sb,int pos){  
    
    if (sb.length() == digits.length()) {
         output.add(sb.toString());
        return;
     }
   
    Character digit = digits.charAt(pos);

    String comb = phone.get(digit.toString());
 
    for(int i=0;i<comb.length();i++){
      letterCombinations(digits,sb.append(comb.charAt(i)),pos+1);
      sb.deleteCharAt(sb.length()-1);
    }
 
}
    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
      letterCombinations(digits,new StringBuffer(),0);
      
       return output;
    }

}