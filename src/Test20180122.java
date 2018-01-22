public class Test20180122 {
    public static void main(String[] args) {
        final  int N = 10;
        int[] testArray = {2,3,5,7,8,1,4,9,10,5,6};
        //随机生成题目数组（待实现

        int[] arrays = new int[N+1];
        int out = 0;
        for (int i = 0;i <N+1;i++){
           int data = arrays[testArray[i]];
            if (data == 1) {
                out = testArray[i];
                break;
            }
            else{
                arrays[testArray[i]] = 1;
            }
        }
        System.out.println(out);

    }
}
