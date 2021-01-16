package 剑指offer;

class Solution58 {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder res = new StringBuilder();

        int i = s.length() - 1;
        int j = s.length() - 1;
        while (i >= 0){
            while (i >= 0 && s.charAt(i) != ' '){
                i--;
            }
            //注意下方的index，从i+1,到j+1。由于i时已经指向了空格，所以需要i+1， j+1是因为substring方法后半边取不到
            res.append(s.substring(i+1, j+1)+' ');
            while (i >= 0 && s.charAt(i) == ' '){
                i--;
            }
            j = i;
        }

        return res.toString().trim();
    }

    public static void main(String[] args) {
        String words = "  hello world! hi nice yu  123";
        Solution58 solution58 = new Solution58();
        System.out.println(solution58.reverseWords(words));
    }
}
