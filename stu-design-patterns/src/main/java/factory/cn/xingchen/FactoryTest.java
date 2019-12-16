package factory.cn.xingchen;

/**
 * @author chaiyunhao
 * @create 2019-07-30 17:49
 */
public class FactoryTest {

    public static void main(String[] args){

        CarFactory carFactory = new CarFactory();

        try {
            Car car =carFactory.createCar(CarType.BLUE);
            car.getColor();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
