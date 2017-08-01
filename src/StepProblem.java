/**
 * 阶梯问题，
 * 一共n级阶梯，每次只能前进一格或两格
 * 求出所有解法
 */
public class StepProblem {
    public int step(int[][] all,int[] curr,int rest,int index){
        if (rest < 0){
            return index;
        }
        if (rest == 0){
            all[index] = new int[curr.length];
            System.arraycopy(curr,0,all[index],0,curr.length);
            index++;
            return index;
        }
        int[] now = new int[curr.length+1];
        System.arraycopy(curr,0,now,0,curr.length);
        now[now.length-1] = 1;
        rest--;
        index = step(all,now,rest,index);
        now[now.length-1] = 2;
        rest--;
        index = step(all,now,rest,index);
        return index;
    }
    public String[] getStep(int n){
        int[][] all = new int[n*n][];
        int[] curr = new int[1];
        curr[0] = 1;
        int index = step(all,curr,n-1,0);
        curr[0] = 2;
        index = step(all,curr,n-2,index);
        String[] ret = new String[index];
        for (int i = 0;i<index;i++){
            int len = all[i].length;
            StringBuffer sb = new StringBuffer();
            sb.append("[");
            int j  = 0;
            for (j  = 0; j< len-1 ; j++){
                sb.append(all[i][j]).append(",");
            }
            sb.append(all[i][j]).append("]");
            ret[i] = sb.toString();
        }
        return ret;
    }

    public static void main(String[] args) {
        StepProblem st = new StepProblem();
        long start = System.nanoTime();
        String[] rets = st.getStep(10);
        long end = System.nanoTime();
        System.out.println("计算耗时："+(end-start)/100000+"毫秒");
        System.out.println("总路径："+rets.length+"种");
        for (String s: rets){
            System.out.println(s);
        }
    }
}
