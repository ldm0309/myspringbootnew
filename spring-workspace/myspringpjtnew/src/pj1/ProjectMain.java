package pj1;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import pj1.Emp;
import pj1.EmpService;
@Component
public class ProjectMain {

    private final EmpDAO empDAO;

    ProjectMain(EmpDAO empDAO) {
        this.empDAO = empDAO;
    }
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in); 
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context2.xml");
		EmpService service = (EmpService) context.getBean(EmpService.class);
		  int way=10;
	      while(way!=0) {
	         System.out.println("<원하는 검색방법 번호를 입력하세요>(0 입력시 종료됩니다)");
	         System.out.println("1.이름 2.입사년도 3. 부서번호 4. 도시이름 5.통계자료 6. 부서장이름을 통한 부서원검색");
	         try {
	         way = scan.nextInt();
	         } catch (InputMismatchException e) {
	             System.out.println("숫자로 다시 입력해주세요.");
	             scan.nextLine();
	             continue;
	         }
	         switch(way) {
	         case 1:
	           // searchByName();
	            break;
	         case 2:
	        	    System.out.println("입사년도 입력 : ");
	        	    int year = scan.nextInt();
	        	    while (year != 0) {
	        	        List<Emp> empList = service.findEmpByYear(year);
	        	        for (Emp emp : empList) {
	        	            System.out.println(emp.toString());
	        	        }
	        	        year = scan.nextInt();
	        	    }
	        	    break;
	         case 3:
	        	 System.out.println("부서번호 입력 : ");
	     		int deptId = scan.nextInt();
	     		while(deptId != 0) {
	     			List<Emp> empList = service.findEmpByDeptId(deptId);
	     			for(Emp emp : empList) {
	     				System.out.println(emp.toString());
	     			}
	     			deptId = scan.nextInt();
	     		}
	     		break;
	         case 4:
	           // searchByCity();
	            break;
	         case 5:
	          // EmpDAO.printStat();
	            break;
	         case 6:
	        	 //
	            break;
	         }
	      }
	      System.out.println("-프로그램 종료-");
	

	
	
	
	      
	      }
	}
	   
	   