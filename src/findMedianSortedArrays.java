public class findMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1+len2;
        int [] num = new int[len+1];
        int i = 0;      //数组1的遍历指针
        int j = 0;      //数组2的遍历指针
        int whole = 0;//总共遍历数字的数量
        double median ;

        while (i < len1 && j < len2) {
            whole++;
            if (nums1[i] < nums2[j]) {
                num[whole] = nums1[i];
                i++;
            } else {
                num[whole] = nums2[j];
                j++;
            }
        }

        //如果还有数组没有被遍历完
        while(i < len1 ){
            whole ++;
            num[whole] = nums1[i];
            i++;
         }

        while(j < len2 ) {
            whole ++;
            num[whole] = nums2[j];
            j++;
        }


        if((whole&1)==1)
            median =  num[whole/2+1];
        else
            median = (double) (num[whole/2]+num[whole/2+1])/2;
        return median;
    }

    public static void main(String[] args) {
        int [] nums1 = new int[]{1,3,5,7,9};
        int [] nums2 = new int[]{2,4,6,8};
        double median =  findMedianSortedArrays(nums1,nums2);
        System.out.println(median);
    }
}
