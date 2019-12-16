package templateMethod.cn.xingchen;

/**
 * @author chaiyunhao
 * @create 2019-07-30 17:46
 */
public class BenzCar extends AbstractCar{
    @Override
    protected void start() {
        System.out.println("BenzCar is start");
    }

    @Override
    protected void stop() {
        System.out.println("BenzCar is stop");
    }
}
