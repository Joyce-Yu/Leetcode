package 剑指offer;

class Solution58II {
    public String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();
        res.append(s.substring(n));
        res.append(s.substring(0,n));
        return res.toString();
    }

    public static void main(String[] args) {
        String a = "lrloseumgh";
        int n = 6;
        Solution58II solution58II = new Solution58II();
        System.out.println(solution58II.reverseLeftWords(a, n));
    }
}
