package 反射.Class类;

import org.junit.jupiter.api.Test;
import 反射.lib.Son;
import 反射.lib.myAnno;
import 示例.Person;
import 示例.Tool;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.reflect.*;

public class Base {
    /**
     * @获取运行时类-Class类实例的方式
     */
    @Test
    public void getInstance() throws Exception {
        // 1.class属性：若已知具体的类，通过类的class属性获取，该方法最为安全可靠，程序性能最高
        Class<Person> clazz1 = Person.class;

        // 2.getClass方法：已知某个类的实例，调用该实例的getClass()方法获取Class对象
        Person p2 = new Person("方舟子", 54, (byte) 1);
        Class<? extends Person> clazz2 = p2.getClass();
        Class clazz2_ = this.getClass();

        // 3.forName方法：已知一个类的全类名，且该类在类路径下，可通过Class类的静态方法forName()获取，可能抛出ClassNotFoundException
        Class<?> clazz3 = Class.forName("示例.Person");

        // 4.ClassLoader
        ClassLoader cl = this.getClass().getClassLoader();
        Class<?> clazz4 = cl.loadClass("示例.Person");

        System.out.println(clazz1);
        System.out.println(clazz2);
        System.out.println(clazz3);
        System.out.println(clazz4);

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);
        System.out.println(clazz1 == clazz4);

    }

    /**
     * @各种运行时类对比
     */
    @Test
    public void getInstance2() throws Exception {

        Class<Object> clazz1 = Object.class;
        Class<Comparable> clazz2 = Comparable.class;
        Class<String> clazz3 = String.class;
        Class<String[]> clazz4 = String[].class;
        Class<int[]> clazz5 = int[].class;
        Class<? extends int[]> clazz5_ = new int[]{1, 2, 3}.getClass();
        Class<int[][]> clazz6 = int[][].class;
        Class<ElementType> clazz7 = ElementType.class;
        Class<Override> clazz8 = Override.class;
        Class<Void> clazz9 = void.class;
        Class<Class> clazz10 = Class.class;

        // 数组只要类型和维度一样，它们的Class的就是一样的
        System.out.println(clazz5 == clazz5_);// true
    }

    /**
     * @获取运行时类加载器
     */
    @Test
    public void getClassLoader() throws Exception {
        // <M> public ClassLoader getClassLoader()
        // <返> 返回该类的类加载器。如果该类由引导类加载器加载，则此方法在这类实现中将返回 null。
        Class clazz = this.getClass();
        ClassLoader classLoader = clazz.getClassLoader();
    }

    /**
     * @创建运行时类的类的（已废弃）
     */
    @Test
    public void newInstance() throws Exception {
        // <M> public T newInstance()
        // <返> 创建此 Class 对象所表示的类的一个新实例。
        // <注>
        // 1.newInstance只能调用无参构造器，所以运行时类必须提供空参构造器
        // 2.空参构造器访问权限必须能够满足访问
        // 3.该方法在jdk9以后不建议使用了
        Class<Person> clazz = Person.class;
        Person person = clazz.newInstance();
        System.out.println(person);
    }

    /**
     * @获取运行时类的构造器，然后使用构造器创建运行时对象
     */
    @Test
    public void getConstructors() throws Exception {
        // <M> public Constructor<?>[] getConstructors()
        // <返> 获取运行时类的权限是 public 构造器

        // <M> public Constructor<?>[] getDeclaredConstructors()
        // <返> 获取运行时类的所有的构造器

        Class<Son> clazz = Son.class;
        Constructor[] constructors1 = clazz.getConstructors();
        Constructor[] constructors2 = clazz.getDeclaredConstructors();

        for (Constructor c : constructors1) {
            System.out.println(c);
        }
        System.out.println("-------------------");
        for (Constructor c : constructors2) {
            System.out.println(c);
        }

        System.out.println("-------------------");

        Constructor<Son> constructor1 = clazz.getConstructor(String.class);
        Constructor<Son> constructor2 = clazz.getDeclaredConstructor(String.class, int.class, Tool.class);

        Son p1 = constructor1.newInstance("张三");
        Son p2 = constructor2.newInstance("李四", 18, new Tool("biu"));
        System.out.println(p1);
        System.out.println(p2);
    }

    /**
     * @获取运行时类的类的名称
     */
    @Test
    public void getName() {
        Class<Son> clazz = Son.class;
        String name = clazz.getName();
        System.out.println(name);
    }

    /**
     * @获取运行时类的类的修饰符
     */
    @Test
    public void getModifiers() {
        Class<Son> clazz = Son.class;
        int modifiers = clazz.getModifiers();
        System.out.println(Modifier.toString(modifiers));
    }

    /**
     * @获取运行时类的类的注解
     */
    @Test
    public void getAnnotations() {
        Class<Son> clazz = Son.class;
        // 获取所有注解
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation anno : annotations) {
            System.out.println(anno);
        }

        // 获取指定注解
        myAnno annotation = clazz.getAnnotation(myAnno.class);
        System.out.println(annotation);
    }

    /**
     * @获取运行时类的父类
     */
    @Test
    public void getSuperclass() {
        // <M> public native Class<? super T> getSuperclass()
        // <返> 获取运行时类的父类

        // <M> public Type getGenericSuperclass()
        // <返> 获取运行时类带泛型的父类
        Class<Son> clazz = Son.class;
        Class<? super Son> superclass = clazz.getSuperclass();
        System.out.println(superclass);

        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);

        // 获取父类泛型
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (Type actualTypeArgument : actualTypeArguments) {
            System.out.println(actualTypeArgument);
        }
    }

    /**
     * @获取运行时类的实现的接口
     */
    @Test
    public void getInterfaces() {
        Class<Son> clazz = Son.class;
        Class[] interfaces = clazz.getInterfaces();
        for (Class i : interfaces) {
            System.out.println(i);
        }
    }

    /**
     * @获取运行时类的所在的包
     */
    @Test
    public void getPackage() {
        Class<Son> clazz = Son.class;
        Package aPackage = clazz.getPackage();
        System.out.println(aPackage);
    }

    /**
     * @运行时类的属性
     */
    @Test
    public void getField() throws Exception {
        // <M> public Field[] getFields()
        // <返> 获取所有的自身和继承的public属性

        // public Field[] getDeclaredFields()
        // <返> 获取所有的自身的属性
        Class<Son> clazz = Son.class;
        Field[] fields = clazz.getFields();
        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field f : fields) {
            System.out.println(f);
        }

        System.out.println("-------------------");
        for (Field f : declaredFields) {
            System.out.println(f);
        }

        // 获取指定属性
        System.out.println("-------------------");
        Field hobby = clazz.getField("hobby");
        Field girlFriend = clazz.getDeclaredField("girlFriend");
        System.out.println(hobby);
        System.out.println(girlFriend);
    }

    /**
     * @运行时类的属性_属性值的获取和设置
     */
    @Test
    public void getField_get_set() throws Exception {
        Class<Son> clazz = Son.class;
        // 构造器
        Constructor<Son> Son = clazz.getDeclaredConstructor(String.class);
        // 实例
        Son son = Son.newInstance("汪酱");
        System.out.println(son);

        // 属性key
        Field name = clazz.getField("name");
        System.out.println(name);

        // 获取属性value，需要传入实例
        String nameValue = (String) name.get(son);
        System.out.println(nameValue);

        // 设置属性value，需要传入实例
        name.set(son, "喵酱");
        String nameValue2 = (String) name.get(son);
        System.out.println(nameValue2);
    }

    /**
     * @运行时类的属性-名称
     */
    @Test
    public void getField_getName() {
        Class<Son> clazz = Son.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
            System.out.println(f.getName());
        }
    }

    /**
     * @运行时类的属性-类型
     */
    @Test
    public void getField_getType() {
        Class<Son> clazz = Son.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
            Class type = f.getType();
            System.out.println(type);
        }
    }

    /**
     * @运行时类的属性-修饰符
     */
    @Test
    public void getField_getModifiers() {
        Class<Son> clazz = Son.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
            int mod = f.getModifiers();
            String s = Modifier.toString(mod);
            System.out.println(f.getName() + " 修饰符:" + s);
        }
    }

    /**
     * @运行时类的方法
     */
    @Test
    public void getMethod() throws Exception {
        // <M> public Method[] getMethods()
        // <返> 获取运行时类及其父类所有public权限的方法

        // <M> public Method[] getDeclaredMethods()
        // <返> 获取运行时类中声明的所有方法，不包含父类的
        Class<Son> clazz = Son.class;
        Method[] methods = clazz.getMethods();
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println(m);
        }

        System.out.println("-------------------");
        for (Method f : declaredMethods) {
            System.out.println(f);
        }

        // 获取指定方法
        System.out.println("-------------------");
        Method work = clazz.getMethod("work");
        Method fly = clazz.getDeclaredMethod("fly", String.class);
        System.out.println(work);
        System.out.println(fly);
    }

    /**
     * @运行时类的方法-注解
     */
    @Test
    public void getMethod_getAnnotations() throws NoSuchMethodException {
        Class<Son> clazz = Son.class;
        Method eat = clazz.getMethod("eat");
        // 注意：注解必须是@Retention(RetentionPolicy.RUNTIME)才能被反射获取到
        Annotation[] annotations = eat.getAnnotations();
        for (Annotation anno : annotations) {
            System.out.println(anno);
        }

        // 获取指定注解
        myAnno annotation = eat.getAnnotation(myAnno.class);
        System.out.println(annotation);
    }

    /**
     * @运行时类的方法-权限
     */
    @Test
    public void getMethod_getModifiers() {
        Class<Son> clazz = Son.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method f : methods) {
            System.out.println(f.getName() + " : " + Modifier.toString(f.getModifiers()));
        }
    }

    /**
     * @运行时类的方法-返回类型
     */
    @Test
    public void getMethod_getReturnType() {
        Class<Son> clazz = Son.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method f : methods) {
            System.out.println(f.getReturnType());
        }
    }

    /**
     * @运行时类的方法-形参
     */
    @Test
    public void getMethod_getParameterTypes() throws Exception {
        Class<Son> clazz = Son.class;
        Method fly = clazz.getDeclaredMethod("fly", String.class);
        Class[] parameterTypes = fly.getParameterTypes();
        for (Class p : parameterTypes) {
            System.out.println(p.getName());
        }
    }

    /**
     * @运行时类的方法-异常
     */
    @Test
    public void getMethod_getExceptionTypes() throws Exception {
        Class<Son> clazz = Son.class;
        Method shout = clazz.getDeclaredMethod("shout");
        Class[] exceptionTypes = shout.getExceptionTypes();
        for (Class e : exceptionTypes) {
            System.out.println(e);
        }
    }

    /**
     * @运行时类的方法_执行方法
     */
    @Test
    public void invoke() throws Exception {
        // <M> public Object invoke(Object obj, Object... args)

        Class<Son> clazz = Son.class;
        // 构造器
        Constructor<Son> Son = clazz.getDeclaredConstructor(String.class);
        // 实例
        Son son = Son.newInstance("张三");
        System.out.println(son);

        // 方法
        Method fly = clazz.getDeclaredMethod("fly", String.class);

        // 执行方法，需要实例和参数
        String flyReturn = (String) fly.invoke(son, "flyflyflyflyfly~");
        System.out.println(flyReturn);

        // 静态方法执行
        Method jump = clazz.getDeclaredMethod("jump");
        jump.invoke(Son);
    }

    /**
     * @设置运行时类的访问权限
     */
    @Test
    public void setAccessible() throws Exception {
        Class<Son> clazz = Son.class;

        // 获得构造器，但此构造器是private的
        Constructor<Son> constructor = clazz.getDeclaredConstructor(String.class, String.class);

        // 将Accessible设置为true，则非public的构造器也能执行，否则报错 IllegalAccessException
        // 默认是false，如果构造器本身默认是public，则不用执行此项
        constructor.setAccessible(true);

        // 实例化
        Son son = constructor.newInstance("a", "b");

        // 属性、方法（非public）
        Field phrase = clazz.getDeclaredField("phrase");
        Method kick = clazz.getDeclaredMethod("kick");

        // 同样，如果属性、方法权限不够，也需要开通权限
        phrase.setAccessible(true);
        kick.setAccessible(true);

        // 操作属性值
        String ph = (String) phrase.get(son);
        phrase.set(son, "c");

        // 方法执行
        kick.invoke(son);
    }
}
