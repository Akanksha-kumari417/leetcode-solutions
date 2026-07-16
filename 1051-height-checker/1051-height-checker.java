class Solution {
    public int heightChecker(int[] heights) { 
        int[] freq = new int[101];
        for(int height : heights){  
            freq[height]++;   
        }                   
        int count =0;  
        int expectedHeight =1;
        for(int i=0; i<heights.length; i++){
            while(freq[expectedHeight] == 0) expectedHeight++;
            if(heights[i] != expectedHeight){
                count++;
            }
            freq[expectedHeight]--;
        }
        return count;
    }    
}