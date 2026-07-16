public class Solution extends GuessGame{
    public int guessNumber(int n){
        int st=0;
        int end=n;
        while(st<=end){
            int mid = st+(end -st)/2;
            if(guess(mid)==0){
                return mid;


            }
            else if(guess(mid)<0){
                end = mid-1;

            }
            else{
                st=mid+1;
            }
        }
        return st;
    }
}                                                   