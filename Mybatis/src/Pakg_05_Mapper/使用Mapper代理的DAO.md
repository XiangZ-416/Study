# 传统DAO
    1.创建映射xml文件，将DAO接口中的增删改查方法的sql语句与DAO接口中的方法映射
    2.创建DAO接口，并标识增删改查方法
        Mapper开发规范：
         a、在mapper.xml中 namespace 等于mapper接口地址
         b、mapper.java接口中的 方法名 和mapper.xml中statement的id一致
         c、mapper.java接口中的 方法输入参数类型 和mapper.xml中statement的parameterType指定的类型一致。
         d、mapper.java接口中的 方法返回值类型 和mapper.xml中statement的resultType指定的类型一致
    3.SqlSession sqlSession = sqlSessionFactory.openSession();
      Code_01_UserMapper userMapper = sqlSession.getMapper(Code_01_UserMapper.class); 创建DAO接口的代理类对象
    4.在测试方法中使用代理类对象调用DAO接口中的增删改查方法
    