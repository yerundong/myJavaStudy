package package1.p2.p3;

public class HelloWorld {
    public static void main(String[] args) {
//        System.out.println(isSame(2, 2));
//        getSum();
        String str = "yrddddd";
        System.out.println(str);
    }

    public static boolean isSame(int a, int  b){
        return a == b;
    }

    public static void getSum(){
        int sum = 0;
        int i = 1;
        while (i <= 100){
            sum += i;
            i++;
        }
        System.out.println(sum);
    }
}


