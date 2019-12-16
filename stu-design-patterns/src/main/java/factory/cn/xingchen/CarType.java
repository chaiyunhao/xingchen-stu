package factory.cn.xingchen;

/**
 * @author chaiyunhao
 * @create 2019-07-29 14:50
 */
public enum CarType {

    /**
     * BLUE
     */
    BLUE(1),
    /**
     * RED
     */
    RED(2);

    private int type;

    private CarType(int type){
        this.type = type;
    }
}
