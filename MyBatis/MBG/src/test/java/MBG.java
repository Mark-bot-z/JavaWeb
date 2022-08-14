import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mybatis.daos.mapper.EmployeeMapper;
import com.mybatis.daos.pojo.Employee;
import com.mybatis.daos.pojo.EmployeeExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MBG {

    static EmployeeMapper mapper;

    static {
        try {
            InputStream is = Resources.getResourceAsStream("static/MyBatis-Config.xml");
            SqlSession sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(true);
            mapper = sqlSession.getMapper(EmployeeMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testMBG() throws IOException {
        EmployeeExample empExample = new EmployeeExample();
        //创建条件对象，通过andXXX方法为SQL添加查询添加，每个条件之间是and关系
        empExample.createCriteria().andSexEqualTo("男");
        //将之前添加的条件通过or拼接其他条件
        empExample.or().andAgeGreaterThan(60);
        mapper.selectByExample(empExample)
                .forEach(employee -> System.out.println(employee.toString()));
    }

    @Test
    public void testPagePlugin(){
//        EmployeeExample employeeExample = new EmployeeExample();
//        employeeExample.createCriteria()
//                .andDidIsNotNull();
//        开启分页
        PageHelper.startPage(3,2);
        List<Employee> employees = mapper.selectByExample(null);
//        获取分页细节
        PageInfo<Employee> info = new PageInfo<>(employees,2);
        System.out.println(employees);
        System.out.println(info);
    }

}
