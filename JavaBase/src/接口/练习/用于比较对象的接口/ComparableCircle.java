package 接口.练习.用于比较对象的接口;

public class ComparableCircle extends Circle implements CompareObject {

    public ComparableCircle(double radius) {
        super(radius);
    }

    @Override
    public int compareTo(Object o) {
        if(this == o)
            return 0;

        if(o instanceof Circle){
            Circle c = (Circle)o;

            // if(getRadius() > c.getRadius()){
            //     return 1;
            // }else if (getRadius() < c.getRadius()){
            //     return -1;
            // }else{
            //     return 0;
            // }

            // Double包装类的内置比较方法
            return getRadius().compareTo(c.getRadius());
        }else{
            throw new RuntimeException("传入必须是Circle类型对象");
        }
    }
}
