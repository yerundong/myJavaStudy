package 反射.运行时类;

import lib.Tool;
import org.junit.jupiter.api.Test;
import 反射.lib.Son;
import 反射.lib.myAnno;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class 获取运行时类的相关信息及设置 {
    /**
     * @获取运行时类的构造器(所有)
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
    }

    /**
     * @获取运行时类的构造器(单个)
     */
    @Test
    public void getConstructor() throws Exception {
        // <M> public Constructor<T> getConstructor(Class<?>... parameterTypes)
        // <M> public Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)
        Class<Son> clazz = Son.class;
        Constructor<Son> constructor1 = clazz.getConstructor(String.class);
        Constructor<Son> constructor2 = clazz.getDeclaredConstructor(String.class, int.class, Tool.class);
        Son p1 = constructor1.newInstance("张三");
        Son p2 = constructor2.newInstance("李四", 18, new Tool("biu"));
        System.out.println(p1);
        System.out.println(p2);
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
     * @获取运行时类的类的全类名
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
     * @获取运行时类的类的注解（所有）
     */
    @Test
    public void getAnnotations() {
        Class<Son> clazz = Son.class;
        // 获取所有注解
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation anno : annotations) {
            System.out.println(anno);
        }
    }

    /**
     * @获取运行时类的类的注解（单个）
     */
    @Test
    public void getAnnotation() {
        Class<Son> clazz = Son.class;

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

        Class<Son> clazz = Son.class;
        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);
    }

    /**
     * @获取运行时类的带泛型的父类及泛型
     */
    @Test
    public void getGenericSuperclass() {
        // <M> public Type getGenericSuperclass()
        // <返> 获取运行时类带泛型的父类
        // <注> 只能获取继承时父类泛型已确定的父类泛型信息，如：public class Son extends Father<String>
        // 而保留的泛型参数是取不到的，如：public class Son<T> extends Father<T>
        Class<Son> clazz = Son.class;
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
     * @运行时类的属性（所有）
     */
    @Test
    public void getFields() throws Exception {
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

        for (Field f : declaredFields) {
            System.out.println(f);
        }
    }

    /**
     * @运行时类的属性（单个）
     */
    @Test
    public void getField() throws Exception {
        // <M> public Field getField(String name)
        // <M> public Field getDeclaredField(String name)
        Class<Son> clazz = Son.class;

        // 获取指定属性
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

        // 获取属性key
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
     * @运行时类的方法（所有）
     */
    @Test
    public void getMethods() throws Exception {
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
    }

    /**
     * @运行时类的方法（单个）
     */
    @Test
    public void getMethod() throws Exception {
        // <M> public Method getMethod(String name, Class<?>... parameterTypes)
        // <M> public Method getDeclaredMethod(String name, Class<?>... parameterTypes)
        Class<Son> clazz = Son.class;

        // 获取指定方法
        Method work = clazz.getMethod("work");
        Method fly = clazz.getDeclaredMethod("fly", String.class);
        System.out.println(work);
        System.out.println(fly);
    }

    /**
     * @运行时类的方法-注解（全部）
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
    }

    /**
     * @运行时类的方法-注解（单个）
     */
    @Test
    public void getMethod_getAnnotation() throws NoSuchMethodException {
        Class<Son> clazz = Son.class;
        Method eat = clazz.getMethod("eat");

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
