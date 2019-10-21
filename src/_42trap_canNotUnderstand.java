import static java.lang.Math.max;
import static java.lang.Math.min;

public class _42trap_canNotUnderstand<res> {


    public int trap(int[] height) {
        int ans = 0;
        int size = height.length;
        for (int i = 1; i < size - 1; i++) {
            int max_left = 0, max_right = 0;
            for (int j = i; j >= 0; j--) { //Search the left part for max bar size
                max_left = max(max_left, height[j]);
            }
            //Search the right part for max bar size
            for (int j = i; j < size; j++) max_right = max(max_right, height[j]);
            ans += min(max_left, max_right) - height[i];
        }
        return ans;

    }


    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        _42trap_canNotUnderstand r = new _42trap_canNotUnderstand();
        System.out.println(r.trap(height));
    }
}
