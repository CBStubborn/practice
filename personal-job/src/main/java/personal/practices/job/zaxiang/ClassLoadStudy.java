package personal.practices.job.zaxiang;

/**
 * Created by CBStubborn on 2017/11/9.
 */


/**
 * 虚拟机规范严格规定了有且只有5中情况（jdk1.7）必须对类进行“初始化”（而加载、验证、准备自然需要在此之前开始）：
 * <p>
 * 1. 遇到new,getstatic,putstatic,invokestatic这失调字节码指令时，如果类没有进行过初始化，
 * 则需要先触发其初始化。生成这4条指令的最常见的Java代码场景是：使用new关键字实例化对象的时候、
 * 读取或设置一个类的静态字段（被final修饰、已在编译器把结果放入常量池的静态字段除外）的时候，
 * 以及调用一个类的静态方法的时候。
 * 2. 使用java.lang.reflect包的方法对类进行反射调用的时候，如果类没有进行过初始化，则需要先触发其初始化。
 * 3. 当初始化一个类的时候，如果发现其父类还没有进行过初始化，则需要先触发其父类的初始化。
 * 4. 当虚拟机启动时，用户需要指定一个要执行的主类（包含main()方法的那个类），虚拟机会先初始化这个主类。
 * 5. 当使用jdk1.7动态语言支持时，如果一个java.lang.invoke.MethodHandle实例最后的解析结果REF_getstatic,
 * REF_putstatic,REF_invokeStatic的方法句柄，并且这个方法句柄所对应的类没有进行初始化，则需要先出触发其初始化。
 * </p>
 */
class SSClass {
    static {
        System.out.println("SSClass");
    }
}

class SuperClass extends SSClass {
    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 123;

    public SuperClass() {
        System.out.println("init SuperClass");
    }
}

class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init");
    }

    static int a = 3;

    public static final String HELLOWORLD = "hello world";

    public SubClass() {
        System.out.println("init SubClass");
    }
}

public class ClassLoadStudy {

    public static void main(String[] args) {
        //TODO 注意观察这四条语句的输出
        //System.out.println(SubClass.a);
        //对于静态字段，只有直接定义这个字段的类才会被初始化，
        // 因此通过其子类来引用父类中定义的静态字段，
        // 只会触发父类的初始化而不会触发子类的初始化。
        //System.out.println(SubClass.value);
        //常量在编译阶段会存入调用类的常量池中，本质上并没有直接引用到定义常量的类，
        // 因此不会触发定义常量的类的初始化
        //System.out.println(SubClass.HELLOWORLD);
        //通过数组定义来引用类，不会触发此类的初始化
        //SuperClass[] sca = new SuperClass[10];
    }
}
