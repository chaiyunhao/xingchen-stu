package factory.cn.xingchen;

/**
 * @author chaiyunhao
 * @create 2019-07-29 14:47
 */
public class BlueCar implements Car{
    @Override
    public void getColor() {
        System.out.println("color is blue");
    }
}
