import java.util.ArrayList;
import java.util.List;
/*
* 导致这道题错的原因如下：
* 1.对java内存使用机制的不熟悉，在此题表现在List上：List<Integer> 得到的list不能对他使用clear，因为List<List<Integer>>对list的使用是基于内存的；
* 2.对Array数组的操作不熟悉：通过Array.sort(nums)就可以对数组进行排序
* 3.无法处理数组重复问题
* */

public class threeSum_wrong {
    public List<List<Integer>> threeSum(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> listOfList = new ArrayList<>();
        for(int i = 0; i < nums.length -2; i++){
            for(int j = i + 1; j < nums.length - 1; j++){
                for(int k = j + 1; k < nums.length; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        listOfList.add(list);
                        break;
                    }
                }
            }
        }

        return listOfList;
    }



    public static void main(String[] args) {
//        threeSum r = new threeSum();
//        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
//        System.out.println(r.threeSum(nums));
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> listOfList = new ArrayList<>();

        list.add(-1);
        list.add(0);
        listOfList.add(list);


        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(0);
        listOfList.add(list2);

        List<Integer> list3 = new ArrayList<>();
        list3.add(3);
        list3.add(0);
        listOfList.add(list3);


        System.out.println(listOfList);
        System.out.println(listOfList.get(0).get(0));


    }
}
