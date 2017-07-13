/**
 * Created by SHUA on 2017/7/13.
 */
public class MergeSort {
    public void merge(int[] array, int s, int s1, int e){
        int[] temp = new int[e-s+1];
        int i = s;
        int j =s1;
        int t = 0;
        while (i<s1&&j<=e){
            if (array[i]<array[j]){
                temp[t++] = array[i];
                i++;
            }else {
                temp[t++] = array[j];
                j++;
            }
        }
        while (i<s1){
            temp[t++]=array[i++];
        }
        while (j<=e){
            temp[t++] = array[j++];
        }
        System.arraycopy(temp,0,array,s,t);
    }

    public void mergeSort(int[] array,int len){

        int length = array.length;
        int clen = len<<1;
        int rlen = length&(clen-1);
        int mid = length/clen;
        if (mid == 0){
            return;
        }
        for (int i=0 ;i<mid;i++){
            merge(array,i*clen,i*clen+len,i*clen+clen-1);
        }
        if (rlen != 0)
            merge(array, length-rlen-clen, length-rlen,length-1);
        mergeSort(array,clen);
        return;
    }



    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 1, 22, 11,13,5,8,2};
        new MergeSort().mergeSort(array,1);
        for (int a:array){
            System.out.print(a+",");
        }
    }

}
