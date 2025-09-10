package myjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//입사년도를 입력받아서 그 해에 입사한 사원목록을 리턴함.

public class EmpDAO {
	static List<Emp> getEmpListByDeptNo(int deptNo) throws Exception {
		List<Emp> result = new ArrayList<Emp>();

		Connection conn = 
				DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
		System.out.println(conn.getClass().getName());
		Statement stmt = conn.createStatement();

		String sql = "select * from employees where department_id = " + deptNo;
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			Emp emp = new Emp();
			
			emp.id = rs.getInt("employee_id");
			emp.last_name = rs.getString("last_name");
			emp.salary = rs.getInt("salary");
			
			result.add(emp);
			
		}
		
		return result;
	}

//	public static List<Emp> getEmpListDeptNo(String jobId) throws Exception {
//		List<Emp> result = new ArrayList<Emp>();
//
//		Connection conn = 
//				DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
//		String sql = "select * from employees where department_id = "; 
//		PreparedStatement stmt = conn.prepareStatement(sql);
//		stmt.setString(1, jobId);
//		
//		ResultSet rs = stmt.executeQuery();
//		
//		while(rs.next()) {
//			Emp emp = new Emp();
//			
//			emp.id = rs.getInt("employee_id");
//			emp.salary = rs.getInt("salary");
//			
//			result.add(emp);
//			
//		}
//		
//		return result;
//		
//	}
	
	
//	public static List<Emp> getEMPListDeptNo(String jobId) throws Exception {
//		List<Emp> result = new ArrayList<Emp>();
//		
//		Connection conn = 
//				DriverManager.getConnection("jdbc:mysql://localhost:3306/newhr", "root", "rootroot");
//		
//		Statement stmt = conn.createStatement();
//		
//		String sql = "select * from employees where department_id = " + jobId + "'"; // ITFROG
//		ResultSet rs = stmt.executeQuery(sql);
//		
//		while(rs.next()) {
//			Emp emp = new Emp();
//			
//			emp.id = rs.getInt("employee_id");
//			emp.lastName = rs.getString("last_name");
//			emp.salary = rs.getInt("salary");
//			
//			result.add(emp);
//			
//		}
//		
//		return result;
//		
//	}


}
