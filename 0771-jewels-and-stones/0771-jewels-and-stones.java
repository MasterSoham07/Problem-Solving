class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        
        int count = 0;

        for(int i=0; i<jewels.length(); i++){
            for(int j=0; j<stones.length(); j++){
                if (stones.charAt(j) == jewels.charAt(i)) {
                    count++;
                }
            }
        }
        return count;
    }
}