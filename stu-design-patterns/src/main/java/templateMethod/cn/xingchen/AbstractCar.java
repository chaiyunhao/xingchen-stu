package templateMethod.cn.xingchen;

/**
 * @author chaiyunhao
 * @create 2019-07-30 17:43
 */
public abstract class AbstractCar {


    protected abstract void start();

    protected abstract void stop();


    public final void run(){
        start();
        stop();
    }
}
