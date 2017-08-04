public class LeetCode_10 {

    public boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        int i = 0 ,j = 0;
        while (i<slen&&j<plen){
            char sc = s.charAt(i);
            char pc = p.charAt(j);
            if (sc == pc ||pc == '.'){
                i++;j++;
            }else if (pc == '*'){
                if ((j-1 > 0)&&(sc == p.charAt(j-1)||p.charAt(j-1) == '.')){
                    i++;
                }else {
                    j++;
                }
            }else if ((++j<plen )&& p.charAt(j) == '*'){
                j++;
            }else {
                return false;
            }
        }
        if (i<slen){
            return false;
        }
        while (j<plen){

        }

        return true;
    }
    public static void main(String[] args) {
        LeetCode_10 ll = new LeetCode_10();
        System.out.println(ll.isMatch("asdasd","a.*d"));
    }
}
