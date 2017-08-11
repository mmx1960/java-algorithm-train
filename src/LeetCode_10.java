/**
 *  简单正则表达式引擎
 *  '.'代表匹配任意字符
 *  '*'代表匹配前面的字符0个或任意个
 */
public class LeetCode_10 {

    public boolean isMatch(String s, String p) {
        return match(s,p,0,0);
    }
    public boolean match(String s, String p,int i,int j) {
        boolean ret = false;
        if (i==s.length()&&j==p.length()){
            return true;
        }
        if ((j+1)<p.length()&&p.charAt(j+1)=='*'){
            ret = match(s,p,i,j+2);
        }
        if (i>=s.length()||j >= p.length()){
            return ret;
        }
        if (s.charAt(i) == p.charAt(j)||p.charAt(j) == '.'){
            if ((j+1)<p.length()&&p.charAt(j+1)=='*'){
                ret = ret || match(s, p, i + 1, j);
            }else {
                ret =  ret||match(s,p,i+1,j+1);
            }
        }else {
            return ret;
        }
        return ret;
    }
    public static void main(String[] args) {
        LeetCode_10 ll = new LeetCode_10();
        System.out.println(ll.isMatch("aa","aaa"));
    }
}
