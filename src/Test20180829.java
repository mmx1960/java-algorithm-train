/**
 * Created by Administrator on 2018/8/29.
 */
public class Test20180829 {
    public static String[][] findCollection(String[] input,int num){
        int length = input.length;
        //计算数组大小
        int p = 1;
        int c = 1;
        for (int i = 0;i < num;i++){
            p *= (length - i);
            c *= (i+1);
        }
        int total = p/c;
        int start = 0;
        //初始化结果数组
        String[][] child = new String[total][num];
        //构建结果
        for(int i = 0; i+num <= length;i++){
            start = calc(input,child,num,start,length,i,0,null,0);
        }
        return child;
    }
    public static int calc(String[] input,String[][] child,int num,int start,int length,int i,int current,String[] last,int len){
        int second = 1;
        int first = num - second;
        while (first > 0){
            String[] curr = new String[len + first];
            if (last != null){
                System.arraycopy(last, 0 , curr, 0, len);
            }
            if (current == 0){
                current+=i;
            }
            System.arraycopy(input,current , curr, len, first);
            int currLen = len + first;
            for (int j= current+first,k = current+first;j+second <= length;j++,k++){
                if (second > 1){
                    if (j == k){
                        j++;
                    }
                    start = calc(input,child,second,start,length,i,j,curr,currLen);
                }else {
                    System.arraycopy(curr, 0, child[start], 0, currLen);
                    System.arraycopy(input, j, child[start], currLen, second);
                    start++;
                }

            }
            first--;
            second++;
        }
        return start;
    }

    public static void main(String[] args) {

        String[][] collection = findCollection(new String[]{"a", "b", "c", "d" ,"e","f"}, 3);
        //拼装结果
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0;i < collection.length;i++){
            sb.append("[");
            for (int j = 0;j < collection[i].length;j++){
                sb.append(collection[i][j]);
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() -1);
            sb.append("]");
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() -1);
        sb.append("}");
        System.out.println(sb);
    }
}
