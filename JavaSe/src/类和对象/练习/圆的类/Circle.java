package 类和对象.练习.圆的类;

public class Circle {
    // 半径
    private double radius = 0;
    // 直径
    private double diameter = 0;
    // 周长
    private double perimeter = 0;
    // 面积
    private double area = 0;
    // 长度单位
    private String length_unit = "";
    private String length_unit_EN = "";
    // 面积单位
    private String area_unit = "";
    private String area_unit_EN = "";

    public Circle(double radius) {
        this.radius = radius;
        this.diameter = 2 * radius;
        this.perimeter = this.diameter * Math.PI;
        this.area = Math.PI * Math.pow(this.radius, 2);
    }

    public Circle(double radius, String length_unit) {
        this(radius);
        this.length_unit = length_unit;
        this.area_unit = "平方" + length_unit;
    }

    public Circle(double radius, String length_unit, String length_unit_EN) {
        this(radius);
        this.length_unit = length_unit;
        this.length_unit_EN = length_unit_EN;
        this.area_unit = "平方" + length_unit;
        this.area_unit_EN = length_unit_EN + "²";
    }

    public double getRadius() {
        return radius;
    }

    public double getDiameter() {
        return diameter;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }

    public String getLength_unit() {
        return length_unit;
    }

    public String getLength_unit_EN() {
        return length_unit_EN;
    }

    public String getArea_unit() {
        return area_unit;
    }

    public String getArea_unit_EN() {
        return area_unit_EN;
    }
}
