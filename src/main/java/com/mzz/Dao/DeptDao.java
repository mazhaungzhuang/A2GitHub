package com.mzz.Dao;

import com.mzz.po.Dept;
import org.apache.ibatis.annotations.*;
import java.util.List;

public interface DeptDao {
    /**
     *
     * @return
     */
    @Select("select * from dept")
   // @ResultMap("deptResult")
    List<Dept> selectAll();

    /**
     *
     * @param dept_id
     * @return
     */
    @Select("select * from dept where dept_id=#{dept_id}")
    /*@Results(id ="deptResult",value={
            @Result(id=true,property = "id", column="dept_id"),
            @Result(property = "name",column = "dept_name")
    })*/
    Dept selectOne(int dept_id);


    @Insert("insert into dept(dept_name) values(#{dept_name})")

    int insert(Dept dept);

    @Update("update dept set dept_name=#{dept_name} where dept_id=#{dept_id}")
    int update(Dept dept);
    @Delete("delete from dept where dept_id=#{dept_id}")
    int delete(Dept dept);


}
