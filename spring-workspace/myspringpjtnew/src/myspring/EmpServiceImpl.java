package myspring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("empService") 
public class EmpServiceImpl implements EmpService {

	EmpDAO dao;
	
	public EmpServiceImpl(EmpDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<Emp> getEmpListByDeptNo(int deptNo) throws Exception {
		return dao.getEmpListByDeptNo(deptNo);
	}

	@Override
	public List<Emp> getEmpByFirstNLastName(String firstName, String lastName) throws Exception {
		return dao.getEmpByFirstNLastName(firstName, lastName);
	}

}
