public class _33isPalindrome {
    public boolean isPalindrome(int x){
        boolean result = true;
        if(x<0)
            return false;
        else{
            int i = 0;
            int [] nums = new int[32];
            while( x > 0 ){
                nums [i++] = x%10;
                x /= 10;
            }
            int j = i - 1 ;
            i = 0;
            while((i < j) && result){
                if( nums[i] != nums[j]){
                    result = false;
                }
                i++;
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _33isPalindrome r = new _33isPalindrome();
        System.out.println(r.isPalindrome(121));
        System.out.println(r.isPalindrome(-121));
        System.out.println(r.isPalindrome(122));
    }
}
