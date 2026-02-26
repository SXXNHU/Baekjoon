class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int i=1; i<=yellow;i++){
            if(yellow%i != 0) continue;
            if(brown == (yellow/i)*2 + 2*i +4){
                answer = new int[]{(yellow/i)+2,i+2};
                break;
            }
        }
        return answer;
    }
}