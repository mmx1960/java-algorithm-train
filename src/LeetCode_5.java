/**
 * Given a string s,
 * find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.
 */
public class LeetCode_5 {

    public String longestPalindrome(String s) {
        int len = s.length();
        int start = 0;int end = 0;
        for(int i=0; i<len-1; i++){
            int f1 = i;
            int f2 = i;
            int g1 = i;
            int g2 = i;
            if(s.charAt(i) == s.charAt(i+1)) {
                f2++;
                if ((end - start) < (f2 - f1)) {
                    start = f1;
                    end = f2;
                }
            }
            if(i>0&&s.charAt(i-1) == s.charAt(i+1)){
                g1--;
                g2++;
                if((end-start) <(g2-g1)){
                    start = g1;end  = g2;
                }

            }
            int lastg1 = g1;
            int lastf1 = f1;
            while((f1>=0&&f2<len)||(g1>0&&g2<len)){
                lastg1 = g1;
                lastf1 = f1;
                if((f1>=0&&f2<len)&&s.charAt(f1) == s.charAt(f2)){
                    if((end-start)<(f2-f1)){
                        start = f1;end = f2;
                    }
                    f1--;f2++;

                }
                if ((g1>=0&&g2<len)&&s.charAt(g1) == s.charAt(g2)){

                    if((end-start)<(g2-g1)){
                        start = g1;end = g2;
                    }
                    g1--;g2++;

                }
                if (lastf1 == f1 && lastg1 == g1){
                    break;
                }
            }


        }
        return s.substring(start,end+1);
    }
    public static void main(String[] args) {
        LeetCode_5 leet = new LeetCode_5();
        System.out.println(leet.longestPalindrome("jglknendplocymmvwtoxvebkekzfdhykknufqdkntnqvgfbahsljkobhbxkvyictzkqjqydczuxjkgecdyhixdttxfqmgksrkyvopwprsgoszftuhawflzjyuyrujrxluhzjvbflxgcovilthvuihzttzithnsqbdxtafxrfrblulsakrahulwthhbjcslceewxfxtavljpimaqqlcbrdgtgjryjytgxljxtravwdlnrrauxplempnbfeusgtqzjtzshwieutxdytlrrqvyemlyzolhbkzhyfyttevqnfvmpqjngcnazmaagwihxrhmcibyfkccyrqwnzlzqeuenhwlzhbxqxerfifzncimwqsfatudjihtumrtjtggzleovihifxufvwqeimbxvzlxwcsknksogsbwwdlwulnetdysvsfkonggeedtshxqkgbhoscjgpiel"));
    }

}
