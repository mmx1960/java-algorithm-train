public class LeetCode_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i =0,j=0,k = 0;
        int[] all = new int[len1+len2];
        while (j<len1&&k<len2){
            if (nums1[j]<nums2[k]){
                all[i] = nums1[j++];
            }else {
                all[i] = nums2[k++];
            }
            i++;
        }

        while (j<len1){
            all[i] = nums1[j++];
            i++;
        }
        while (k<len2){
            all[i] = nums2[k++];
            i++;
        }
        int index = i>>1;
        double ret;
        if ((i&1) == 0){
            ret = (all[index-1]+all[index]+0.0)/2;
        }else {
            ret = all[index];
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_4().findMedianSortedArrays(new int[]{3,4,5},new int[]{1,2,6}));
    }
}
