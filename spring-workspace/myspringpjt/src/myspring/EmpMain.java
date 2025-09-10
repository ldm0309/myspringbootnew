package myspring;

import java.sql.Connection;
import java.util.List;

public class EmpMain {
	public static void main(String[] args) throws Exception {
		int deptNo = 100;
		EmpDAO dao = new EmpDAO();
		EmpService service = new EmpServiceImpl();
		service.setDAO(dao);
		List<Emp> empList = service.getEmpListByDeptNo(deptNo);
		for(Emp emp : empList) {
			System.out.println(emp);
		}
	}
}
