package singleton.cn.xingchen;

/**
 * 饿汉式
 * @author chaiyunhao
 * @create 2019-07-22 17:39
 */
public class Singleton {

    private static Singleton singleton = new Singleton();

    /**
     * 首先保证构造方法私有，不能被访问
     */
    private Singleton() {

    }


    public static Singleton getInstance() {
        return singleton;
    }


}
