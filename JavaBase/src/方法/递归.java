package 方法;
/**
@递归方法 （recursive method）：一个方法在内部调用自己。递归方法会实现一种隐式循环，重复某段代码。
    但这种循环必须有终止条件，否则将变成无穷递归

*/
public class 递归 {
    public static void main(String[] args) {
        // recursion1(1);
        // System.out.println(recursion2(1));
        System.out.println(getSum(1, 100, 0));
        System.out.println(getSum2(1,100));
    }

    public static void recursion1(int i){
        System.out.println(i);
        if(i < 10){
            recursion1(++i);
        }
    }

    public static int recursion2(int i){
        // System.out.println(i);
        if(i < 10){
            return recursion2(++i);
        }
        return i;
    }

    // 求和递归
    public static int getSum(int starNum, int endNum, int sum){
        sum = sum + starNum;
        starNum += 1;
        if(starNum <= endNum){
            return getSum(starNum, endNum, sum);
        }else{
            return sum;
        }
    }

    public static int getSum2(int starNum, int endNum){
        if(endNum > starNum){
            return getSum2(starNum,endNum - 1) + endNum;
        }else{
            return starNum;
        }
    }
}
