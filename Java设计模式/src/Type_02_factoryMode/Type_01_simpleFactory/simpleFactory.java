package Type_02_factoryMode.Type_01_simpleFactory;

/**
 * @Description: //TODO �򵥹���ģʽ
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/16 17:49
 */
class simpleFactory {
    // ��������
    // ע��:��������Ϊ�����Ʒ��ɫ
    public static Car produceCar(String carType) throws Exception {
        //�ж��߼������ؾ���Ĳ�Ʒ��ɫ�� Client
        if (carType.equalsIgnoreCase("����")) {
            return new Benz();
        } else if (carType.equalsIgnoreCase("����")) {
            return new Bmw();
        } else {
            throw new Exception("û�д˳���");
        }
    }
}