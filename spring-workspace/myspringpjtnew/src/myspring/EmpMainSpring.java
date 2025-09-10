package myspring;

import java.sql.Connection;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpMainSpring {
	public static void main(String[] args) throws Exception {
		int deptNo = 100;
//		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		EmpService service = context.getBean(EmpService.class);
//		List<Emp> empList = service.getEmpListByDeptNo(deptNo);
//		for(Emp emp : empList) {
//			System.out.println(emp);
//		}
		String firstName = "Steven";
		String lastName = null;
		List<Emp> empList = service.getEmpByFirstNLastName(firstName, lastName);
		System.out.println(empList);
	}
}
