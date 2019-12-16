package templateMethod.cn.xingchen;

/**
 * @author chaiyunhao
 * @create 2019-07-30 17:47
 */
public class TemplateMethodTest {

    public static void main(String[] args){
        AudiCar audiCar = new AudiCar();
        audiCar.run();

        BenzCar benzCar = new BenzCar();
        benzCar.run();
    }
}
