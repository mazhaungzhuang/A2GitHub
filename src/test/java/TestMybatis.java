import com.mzz.Dao.DeptDao;
import com.mzz.po.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    private InputStream is;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private DeptDao dd;

    @Before
    public void before() throws IOException {
        is= Resources.getResourceAsStream("Mybatis-config1.xml");
        //
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
        //
         sqlSession=sqlSessionFactory.openSession(true);
         dd=sqlSession.getMapper(DeptDao.class);
    }
    @org.junit.Test
    public void test(){
        //
        dd.selectAll().forEach(System.out::println);

    }
    @org.junit.Test
    public void test1(){
        //
        Dept dept=dd.selectOne(5);
        System.out.println("dept = " + dept);

    }
    @org.junit.Test
    public void test2(){
        //
        Dept dept=new Dept();
        dept.setDept_name("后勤部");
        int insert = dd.insert(dept);
        System.out.println("insert = " + insert);

    }
    @org.junit.Test
    public void TestUpdate(){
        //
        Dept dept=new Dept();
        dept.setDept_id(4);
        dept.setDept_name("傻子部");
        int insert = dd.update(dept);
        System.out.println("insert = " + insert);

    }
    @org.junit.Test
    public void TestDelete(){
        //
        Dept dept=new Dept();
        dept.setDept_id(7);
        int insert = dd.delete(dept);
        System.out.println("insert = " + insert);

    }
}
