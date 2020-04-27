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
 * @Description: //TODO 使用 JdbcTemplate 实现增、删、改、查
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/23 17:53
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
     * @Description //TODO 获取单个列的值，或做统计查询
     *                 使用 public <T> T queryForObject(String sql, Class<T> requiredType) 方法
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
     * @Description //TODO 查询实体类的集合
     *                      注意调用的不是 queryForList方法
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
     * @Description //TODO 从数据库中获取一条记录，实际得到对应的一个对象
     *                 注意：不是调用 public <T> T queryForObject(String sql, Class<T> requiredType, @Nullable Object... args) 方法，此方法是返回一个字段值
     *                       而应该应该调用 public <T> T queryForObject(String sql, @NotNull org.springframework.jdbc.core.RowMapper<T> rowMapper, @Nullable Object... args)
     *                       注意：
     *                            1.其中 RowMapper 指定如何区映射结果集的行，常用的实现类为 BeanPropertyRowMapper
     *                            2.使用 SQL 中的列的别名和类的属性名的映射，例如：user 和 user
     *                            3.不支持级联属性的配置
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
     * @Description //TODO 针对test数据库中的user_table表做：批量 增、删、改
     *                 最后一个参数是 Object[] 的 List：因为修改一条记录需要一个 Object 数组，那么多条记录就是 Object 数组的集合
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
     * @Description //TODO 针对test数据库中的user_table表做：增、删、改
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
