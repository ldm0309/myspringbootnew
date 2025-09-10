package pj1;

import java.util.List;

public interface EmpService {
	void setDao(EmpDAO dao);
	public List<Emp>findEmpByYear(int year) throws Exception;
	public List<Emp>findEmpByDeptId(int deptId) throws Exception;

}
