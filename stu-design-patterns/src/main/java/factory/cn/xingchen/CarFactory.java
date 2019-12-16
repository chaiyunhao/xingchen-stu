package factory.cn.xingchen;

/**
 * @author chaiyunhao
 * @create 2019-07-29 14:49
 */
public class CarFactory {


    public <T extends Car> T createCar(CarType carType) throws Exception {

        Car car;

        switch (carType){
            case RED:
                car = new RedCar();
                break;
            case BLUE:
                car = new BlueCar();
                break;
            default:
                throw new Exception("car type error");
        }

        return (T)car;

    }

}
