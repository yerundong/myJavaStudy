package 接口.练习.用于比较对象的接口;

public class Main {
    public static void main(String[] args) {
        ComparableCircle c1 = new ComparableCircle(4);
        ComparableCircle c2 = new ComparableCircle(3.66);

        int c = c1.compareTo(c2);

        System.out.println(c);

        if(c == 0){
            System.out.println("c1和c2一样大");
        }else if (c > 0){
            System.out.println("c1比c2大");
        }else if (c < 0){
            System.out.println("c1比c2小");
        }

    }
}
