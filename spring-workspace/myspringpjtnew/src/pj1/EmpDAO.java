package pj1;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmpDAO {

    @Autowired
    DataSource dataSource;

    @Autowired
    SqlSession Session;
    
	public  List<Emp> findEmpByYear(int year) throws Exception {
		 return Session.selectList("findEmpByYear", year);
	}
	public  List<Emp> findEmpByDeptId(int deptId) throws Exception {
		 return Session.selectList("findEmpByDeptId", deptId);
	}
	
}
	
