class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer>seen = new HashSet<>();
       
        while(n != 1 && !seen.contains(n)){
            seen.add(n);
             int sum = 0;
             int temp = n;
             while(temp > 0){
            int digit = temp % 10;
            sum += (digit * digit);
             temp = temp/10;
             }
            
            n = sum;
        }
        return n==1;
    }
}