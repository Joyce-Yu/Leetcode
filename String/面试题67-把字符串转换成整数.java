package 剑指offer;

class Solution67 {
    public int strToInt(String str) {
        str = str.trim();
        if (str.length() == 0){
            return 0;
        }
        int res = 0;
        int boundary = Integer.MAX_VALUE / 10;
        int sign = 1;
        int i = 1;
        if (str.charAt(0) == '-'){
            sign = -1;
        } else if (str.charAt(0) != '+'){
            i = 0;
        }

        for (int j = i; j < str.length(); j++){
            if (str.charAt(j)<'0' || str.charAt(j)>'9'){
                break;
            }
            if (res > boundary || res == boundary && str.charAt(j) > '7'){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (str.charAt(j) - '0');
        }

        return sign * res;

    }

    public static void main(String[] args) {
        Solution67 solution67 = new Solution67();
        String a = "2147483646";
        System.out.println(solution67.strToInt(a));
    }
}
