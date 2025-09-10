package myspring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class EmpDAO {

	SqlSession session;

	public EmpDAO(SqlSession session) {
		this.session = session;
	}

	//성, 명을 전달받아서 그 이름에 해당하는 사원정보를 리턴함
	public List<Emp> getEmpByFirstNLastName(String firstName, String lastName) throws Exception {
		Emp emp = new Emp();
		emp.lastName = lastName;
		emp.firstName = firstName;
		return session.selectList("getEmpByFirstNLastName", emp);
	}

	
	public List<Emp> getEmpListByDeptNo(int deptNo) throws Exception {
		return session.selectList("getEmpListByDeptNo", deptNo);
	}

	public static List<Emp> getEmpListByJobId(String jobId) throws Exception {
		List<Emp> result = new ArrayList<Emp>();
		Connection conn =
				DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		String sql = "select * from employees where job_id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, jobId);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Emp emp = new Emp();
			emp.employeeId = rs.getInt("employee_id");
			emp.lastName = rs.getString("last_name");
			emp.salary = rs.getInt("salary");
			result.add(emp);
		}
		return result;
	}
}
