/**
 * 快速排序
 * 递归版
 * Created by zzc on 2017/7/12.
 */
public class QuickSort {
    public void quicksort(int[] array,int left,int right){
        int i = left;
        int j = right;
        if (i >= j){
            return;
        }
        int cur = array[i];
        while (i < j){
            while (array[j]>cur&&i < j){
                j--;
            }
            if (array[j]<cur&&i < j){
                array[i++] = array[j];
            }
            while (array[i]<cur&&i < j){
                i++;
            }
            if(array[i]>cur&&i < j){
                array[j--] = array[i];
            }
        }
        array[j]=cur;
        quicksort(array, left, i - 1);
        quicksort(array, i + 1, right);
        return;
    }

    public static void main(String[] args) {
        int[] array = new int[]{3,4,1,22,11,13,5,8,2};
        new QuickSort().quicksort(array, 0, array.length - 1);
        for (int a:array){
            System.out.print(a+",");
        }
    }

}
