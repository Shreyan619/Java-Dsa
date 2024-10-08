public class reverse {
    public static void main(String[] args) {
        String s="gary";
        System.out.println(rev(s));
    }
    static String rev(String s){
        String ch="";
        for(int i=s.length()-1;i>=0;i--){
            ch+=(s.charAt(i));
        }
        return ch;
    }
}
