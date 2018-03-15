/**
 * @author zhangzc
 */
public class HeapSort {

    public static void maxHeapify(int[] x,int i,int heapSize){
        int left = i << 1;
        int right = left + 1;
        if(left <= heapSize){
            if (x[left-1] > x[i-1]){
                int tmp = x[i-1];
                x[i-1] = x[left-1];
                x[left-1] = tmp;
            }
            maxHeapify(x,left,heapSize);

        }
        if (right <= heapSize){
            if (x[right-1] > x[i-1]){
                int tmp = x[i-1];
                x[i-1] = x[right-1];
                x[right-1] = tmp;
            }
            maxHeapify(x,right,heapSize);
        }
    }

    public static void buildMaxHeap(int[] x,int heapSize){
        for(int i = heapSize>>>1;i>0;i--){
            maxHeapify(x,i,heapSize);
        }
    }

    public static void heapSort(int[] x,int heapSize,boolean asc){
        if (heapSize<1){
            return;
        }
        int tmp = x[0];
        x[0] = x[heapSize-1];
        x[heapSize-1] = tmp;
        if (asc){
            maxHeapify(x,1,heapSize-1);
        }else {
            minHeapify(x,1,heapSize-1);
        }
        heapSort(x,heapSize-1,asc);
    }

    public static void minHeapify(int[] x,int i,int heapSize){
        int left =  i << 1;
        int right = left + 1;

        if (left <= heapSize){
            if (x[i-1] > x[left-1]){
                int tmp = x[i-1];
                x[i-1] = x[left-1];
                x[left-1] = tmp;
            }
            minHeapify(x,left,heapSize);
        }
        if (right <= heapSize){
            if (x[i-1] > x[right-1]){
                int tmp = x[i-1];
                x[i-1] = x[right-1];
                x[right-1] = tmp;
            }
            minHeapify(x,right,heapSize);
        }
    }

    public static void buildMinHeap(int[] x,int heapSize){
        for(int i = heapSize>>>1;i>0;i--){
            minHeapify(x,i,heapSize);
        }
    }

    public static void main(String[] args) {
        int[] heap = new int[]{3,7,2,5,1,6,9,4,10};
        buildMinHeap(heap,heap.length);
        heapSort(heap,heap.length,false);
        for (int i : heap){
            System.out.println(i);
        }
    }
}
