/**
 * 两个字符串数组a1,a2，输出满足如下条件的：
 * 1.a1中字符串是按字母表顺序排列的
 * 2.a1中字符串包含r
 * 3.a1中字符串是a2中字符串的substring
 * 4.空则输出[]
 * Created by zzc on 2017/7/12.
 */
public class Test20170712 {
    public String[] compare(String[] a1,String[] a2){
        int i = 0;
        String[] end = new String[a1.length];
        for (String a:a1){
            boolean isAlpha = true;
            boolean isR = false;
            char[] chars =a.toCharArray();
            char last = chars[0];
            for (char c:chars){
                if (c<last){
                    isAlpha = false;
                }
                last = c;
                if (c == 'r'){
                    isR = true;
                }
            }
            if (isAlpha&&isR){
                boolean isInB = false;
                for (String aa:a2){
                    if (aa.contains(a)){
                        isInB = true;
                    }
                }
                if (isInB){
                    end[i++] = a;
                }
            }
        }
        String[] ret = new String[i];
        System.arraycopy(end,0,ret,0,i);
        return ret;
    }

    public static void printString(String[] s){
        System.out.print("[");
        for (String s1:s){
            System.out.print('"'+s1+'"'+",");
        }
        System.out.println("]");
    }
    public static void main(String[] args) {
        long start = System.nanoTime();
        printString(new Test20170712().compare(new String[]{"abc","arc","acr","adrzz"}, new String[]{"aaaaa","bbbbbb","aaaxacr","wqeadrzz"}));
        System.out.println("耗时"+(System.nanoTime()-start)/100000+"毫秒");
    }
}
