package Type_02_factoryMode.Type_01_simpleFactory;

/**
 * @Description: //TODO 汽车工厂
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/16 17:49
 */
class simpleFactory {
    // 工厂方法
    // 注意:返回类型为抽象产品角色
    public static Car produceCar(String carType) throws Exception {
        //判断逻辑，返回具体的产品角色给 Client
        if (carType.equalsIgnoreCase("奔驰")) { // 这些if，else是工厂方法的静态属性，在程序设计的时候应该避免。
            return new Benz();
        } else if (carType.equalsIgnoreCase("宝马")) {
            return new Bmw();
        } else {
            throw new Exception("没有此车！");
        }
    }
}