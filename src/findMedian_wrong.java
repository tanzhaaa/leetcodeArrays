/*
* （注意:
* 1.本题中数组是有序数组
* 2.若数组中总数为双数，返回中间两个数的平均值，而不是中间的两数中前者的值
* ）
* 本算法的思想：{
* 1.whole作为记录当前遍历了多少个数字
* 2.比较数组1和2数字大小，数字小的那个数组指针向后进一位，同时记录总数的whole进一位
* 3.记中位数为 x x x A B x x x
* 4.A是leftMedian，B为rightMedian；
* 5.当whole为单数时，rightMedian向右移动一位；当whole为双数时，leftMedian向右移动一位；
* 6.最后处理某一数组多出来的数字
* }
* 最后，学会使用这两个方法：
*   public static boolean isEven(int num){
        return (num&1) != 1;                //
    }

    public static boolean isOdd(int num){
        return (num & 1) == 1;              //直接使用位运算，速度更快
    }
*
* */

public class findMedian_wrong {
    public static boolean isEven(int num){
        return (num&1) != 1;                //学会使用这两个方法
    }

    public static boolean isOdd(int num){
        return (num & 1) == 1;              //直接使用位运算，速度更快
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i = 0;      //数组1的遍历指针
        int j = 0;      //数组2的遍历指针
        int rightMedian = 0;
        int leftMedian = 0;
        double median;//记录当前中位数的值
        int whole = 0;//总共遍历数字的数量
        int iIndex = 0;//当前数组1中是中位数的位置
        int jIndex = 0;//当前数组2中是中位数的位置

        while (i < len1 && j < len2){
            if(nums1[i]<nums2[j]){
                i++;
            }
            else{
                j++;
            }
            whole++;

            if(isEven(whole))
                leftMedian = Math.min(nums1[iIndex], nums2[jIndex]);
            else
                rightMedian = Math.min(nums1[iIndex], nums2[jIndex]);
        }

        while(i < len1 ){
            i++;
            whole ++;
            if(isEven(whole))   leftMedian = Math.min(nums1[iIndex], nums2[jIndex]);
            else                rightMedian = Math.min(nums1[iIndex], nums2[jIndex]);
        }

        while(j < len2 ) {
            j++;
            whole ++;
            if(isEven(whole))   leftMedian = Math.min(nums1[iIndex], nums2[jIndex]);
            else                rightMedian = Math.min(nums1[iIndex], nums2[jIndex]);
        }

        if(leftMedian == rightMedian)
            return (double) rightMedian;
        else{
            median = (double)(leftMedian+rightMedian)/2;
            return median;
        }
    }

    public static void main(String[] args) {
        int [] nums1 = new int[]{1,3,5,7,9};
        int [] nums2 = new int[]{2,4,6,8,10};
        double median =  findMedianSortedArrays(nums1,nums2);
        System.out.println(median);

    }
}
