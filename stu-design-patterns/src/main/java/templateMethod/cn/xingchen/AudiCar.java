package templateMethod.cn.xingchen;

/**
 * @author chaiyunhao
 * @create 2019-07-30 17:47
 */
public class AudiCar extends AbstractCar{
    @Override
    protected void start() {
        System.out.println("AudiCar is start");
    }

    @Override
    protected void stop() {
        System.out.println("AudiCar is stop");
    }
}
