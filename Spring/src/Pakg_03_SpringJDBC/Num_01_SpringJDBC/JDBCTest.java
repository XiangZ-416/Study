package Pakg_03_SpringJDBC.Num_01_SpringJDBC;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: //TODO ʹ�� JdbcTemplate ʵ������ɾ���ġ���
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/4/23 17:53
 */
public class JDBCTest {

    private ApplicationContext ctx = null;
    JdbcTemplate jdbcTemplate = null;

    {
        ctx = new ClassPathXmlApplicationContext("ctx.xml");
        jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
    }




    /*
     * @Author ZX
     * @Description //TODO ��ȡ�����е�ֵ������ͳ�Ʋ�ѯ
     *                 ʹ�� public <T> T queryForObject(String sql, Class<T> requiredType) ����
     * @Date 21:20 2020/4/23
     **/
    @Test
    public void testQueryForObject() {

        String sql = "SELECT count(user) FROM user_table";
        long count = jdbcTemplate.queryForObject(sql, long.class);

        System.out.println(count);

    }

    /*
     * @Author ZX
     * @Description //TODO ��ѯʵ����ļ���
     *                      ע����õĲ��� queryForList����
     * @Date 21:10 2020/4/23
     **/
    @Test
    public void testQueryForList() {

        String sql = "SELECT user, password, balance FROM user_table WHERE balance = ?";
        RowMapper<userTable> RowMapper = new BeanPropertyRowMapper<>(userTable.class);
        List<userTable> userTables = jdbcTemplate.query(sql, RowMapper, 1000);

        System.out.println(userTables);
    }

    /*
     * @Author ZX
     * @Description //TODO �����ݿ��л�ȡһ����¼��ʵ�ʵõ���Ӧ��һ������
     *                 ע�⣺���ǵ��� public <T> T queryForObject(String sql, Class<T> requiredType, @Nullable Object... args) �������˷����Ƿ���һ���ֶ�ֵ
     *                       ��Ӧ��Ӧ�õ��� public <T> T queryForObject(String sql, @NotNull org.springframework.jdbc.core.RowMapper<T> rowMapper, @Nullable Object... args)
     *                       ע�⣺
     *                            1.���� RowMapper ָ�������ӳ���������У����õ�ʵ����Ϊ BeanPropertyRowMapper
     *                            2.ʹ�� SQL �е��еı����������������ӳ�䣬���磺user �� user
     *                            3.��֧�ּ������Ե�����
     * @Date 20:43 2020/4/23
     **/
    @Test
    public void testQuery() {

        String sql = "SELECT user, password, balance FROM user_table WHERE user = ?";

        RowMapper<userTable> RowMapper = new BeanPropertyRowMapper<>(userTable.class);
        userTable userTable = jdbcTemplate.queryForObject(sql, RowMapper, "AA");

        System.out.println(userTable);
    }

    /*
     * @Author ZX
     * @Description //TODO ���test���ݿ��е�user_table���������� ����ɾ����
     *                 ���һ�������� Object[] �� List����Ϊ�޸�һ����¼��Ҫһ�� Object ���飬��ô������¼���� Object ����ļ���
     * @Date 18:34 2020/4/23
     **/
    @Test
    public void testBatchUpdate() {
        String sql = "INSERT INTO user_table (user, password, balance) VALUES (?, ?, ?)";

        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(new Object[] {"ZL", 111, 20000});
        batchArgs.add(new Object[] {"ZX", 222, 30000});
        batchArgs.add(new Object[] {"ZZ", 333, 40000});

        jdbcTemplate.batchUpdate(sql, batchArgs);

    }

    /*
     * @Author ZX
     * @Description //TODO ���test���ݿ��е�user_table����������ɾ����
     * @Date 18:31 2020/4/23
     **/
    @Test
    public void testUpdate() {

        String sql = "INSERT INTO user_table (user, password, balance) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, "ZX", 1111, 1234);

        sql = "UPDATE user_table SET password = ? WHERE user = ?";
        jdbcTemplate.update(sql,  22222, "AA");

        sql = "Delete from user_table where user = ?";
        jdbcTemplate.update(sql, "ZX");

    }

    @Test
    public void test() {
        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        System.out.println(dataSource);
    }

}
