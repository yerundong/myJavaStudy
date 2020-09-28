package System类;

public class Print {
    public static void main(String[] args) {
        byte byt = 1;
        short sht = 2;
        int num = 3;
        long lon = 4;
        float flo = 5;
        double dou = 6;
        char chr = 'c';
        boolean boo = true;

        int[] intArr = new int[]{1,2,3};
        char[] charArr = new char[]{'a','b','c'};
        byte[] byteArr = new byte[]{1,2,3};
        short[] shortArr = new short[]{1,2,3};
        double[] doubleArr = new double[]{1,2,3};
        boolean[] booleanArr = new boolean[]{true, false};


        System.out.println(byt);
        System.out.println(sht);
        System.out.println(num);
        System.out.println(lon);
        System.out.println(flo);
        System.out.println(dou);
        System.out.println(chr);
        System.out.println(boo);

        System.out.println(intArr);// 地址值
        System.out.println(byteArr);// 地址值
        System.out.println(shortArr);// 地址值
        System.out.println(doubleArr);// 地址值
        System.out.println(booleanArr);// 地址值
        System.out.println(charArr);// abc(特别)

    }
}
