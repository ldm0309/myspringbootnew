package pj1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// EmpServiceImpl이 EmpDAO를 의존하고 있구나.
@Component("empService")
public class EmpServiceImpl implements EmpService {

    // repository를 못 찾으면 autowired 주입 실패
    @Autowired
    EmpDAO dao;

    @Override
    public void setDao(EmpDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<Emp> findEmpByDeptId(int deptId) throws Exception {
        return dao.findEmpByDeptId(deptId);
    }

    public List<Emp> findEmpByYear(int year) throws Exception {
        return dao.findEmpByYear(year);
    }
}





