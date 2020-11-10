package 循环语句;

/**
 *
 */
public class For {
    public static void main(String[] args) {

        // @ General format
        for (int i = 0; i < 10; i++) {
            // System.out.println(i);
        }

        // 无限制条件
        for (int i = 0; ; i++) {
            // System.out.println(i);
            if(i>15){
                break;
            }
        }

        // 无限循环
        // for (;;) {
        //
        // }

        // @ for (type item : ite)
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        for (int item : arr1) {
            // System.out.println(item);
        }


        // flag for
        a:for (int i = 0; ; i++) {
            b:for (int j = 0; ; j++) {
                System.out.println(i);
                if(j > 5){
                    break a;
                }
            }
        }

    }
}
