# ��ͳDAO
    1.����ӳ��xml�ļ�����DAO�ӿ��е���ɾ�Ĳ鷽����sql�����DAO�ӿ��еķ���ӳ��
    2.����DAO�ӿڣ�����ʶ��ɾ�Ĳ鷽��
        Mapper�����淶��
         a����mapper.xml�� namespace ����mapper�ӿڵ�ַ
         b��mapper.java�ӿ��е� ������ ��mapper.xml��statement��idһ��
         c��mapper.java�ӿ��е� ��������������� ��mapper.xml��statement��parameterTypeָ��������һ�¡�
         d��mapper.java�ӿ��е� ��������ֵ���� ��mapper.xml��statement��resultTypeָ��������һ��
    3.SqlSession sqlSession = sqlSessionFactory.openSession();
      Code_01_UserMapper userMapper = sqlSession.getMapper(Code_01_UserMapper.class); ����DAO�ӿڵĴ��������
    4.�ڲ��Է�����ʹ�ô�����������DAO�ӿ��е���ɾ�Ĳ鷽��
    