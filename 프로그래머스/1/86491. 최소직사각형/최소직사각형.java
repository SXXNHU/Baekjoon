class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int maxW = 0;
        int maxH = 0;
        
        for(int[] card : sizes){
            int a = card[0];
            int b = card[1];
            
            int w = Math.max(a,b);
            int h = Math.min(a,b);
            
            maxW = Math.max(maxW,w);
            maxH = Math.max(maxH,h);
        }
        
        answer = maxW*maxH;
        return answer;
    }
}