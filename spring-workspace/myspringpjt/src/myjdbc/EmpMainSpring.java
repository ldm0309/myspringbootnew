package myjdbc;

import java.sql.Connection;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpMainSpring {
	public static void main(String[] args) throws Exception {
		int deptNo = 100;
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
		String[] nameList = context.getBeanDefinitionNames();
		for(String name : nameList) System.out.println(name);
		EmpService service = (EmpService) context.getBean("empService");
		List<Emp> empList = service.getEmpListByDeptNo(deptNo);
//		EmpDAO dao = new EmpDAO();
//		EmpService service = new EmpServiceImpl();
//		service.setDAO(dao);
//		List<Emp> empList = service.getEmpListByDeptNo(deptNo);
		for(Emp emp : empList) {
			System.out.println(emp);
		}
	}
}
