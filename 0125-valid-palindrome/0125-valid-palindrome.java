class Solution {
    public boolean checkIfPalindrome(int i, String s){
        if(i >= s.length() / 2) return true;

        if(s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;

        return checkIfPalindrome(i + 1, s);
    }
    public boolean isPalindrome(String s){
        
        String str = s.toLowerCase();
        str = str.replaceAll("[^a-z0-9]", "");
        boolean result = checkIfPalindrome(0, str);

        return result;
    }
}