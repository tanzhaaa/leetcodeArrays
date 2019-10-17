public class reverseInteger {
    public int reverse(int x){
        int result = 0;
        int digit = 1;
        boolean overFlow = false;


        while(x!=0){
            result *= 10;
            result += (x % 10);
            x /=10;
            if( (result > Integer.MAX_VALUE/10 && x>0) ||result < Integer.MIN_VALUE/10 && x<0 )
                overFlow = true;
            else if(result == Integer.MAX_VALUE/10 && x > 7)
                overFlow = true;
            if (result == Integer.MIN_VALUE / 10 && x < -8 )
                    overFlow = true;
            if(overFlow)
                break;
        }

        if(overFlow)
            result = 0;
        return result;
    }

    public static void main(String[] args) {
        reverseInteger r = new reverseInteger();
        System.out.println(r.reverse(Integer.MIN_VALUE));
    }
}
