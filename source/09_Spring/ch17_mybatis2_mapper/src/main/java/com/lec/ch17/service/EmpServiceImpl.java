package com.lec.ch17.service;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.ch17.dao.DeptDao;
import com.lec.ch17.dao.EmpDao;
import com.lec.ch17.model.Dept;
import com.lec.ch17.model.Emp;
import com.lec.ch17.util.Paging;

@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private DeptDao deptDao;
	@Autowired
	private EmpDao empDao;
	@Override
	public List<Dept> deptList() { 
		return deptDao.deptList();  
	}

	@Override
	public List<Emp> empList(String pageNum) {
		Paging paging = new Paging(empDao.totCnt(), pageNum, 10, 5); // 사원 목록 한페이지에 10개 블록은 5개
		Emp emp = new Emp();
		emp.setStartRow(paging.getStartRow());
		emp.setEndRow(paging.getEndRow());
		return  empDao.empList(emp) ;
	}

	@Override
	public List<Emp> empDeptList(String pageNum) {
		Paging paging = new Paging(empDao.totCnt(), pageNum, 10, 5);
		Emp emp = new Emp();
		emp.setStartRow(paging.getStartRow());
		emp.setEndRow(paging.getEndRow());
		return empDao.empDeptList(emp) ;
	}

	@Override
	public int totCnt() {
		 
		return empDao.totCnt();
	}

	@Override
	public Emp detail(int empno) {
		// TODO Auto-generated method stub
		return empDao.detail(empno);
	}

	@Override
	public List<Emp> managerList() {
		// TODO Auto-generated method stub
		return empDao.managerList();
	}

	@Override
	public int insert(Emp emp) { 
		return empDao.insert(emp) ;
	}

	@Override
	public int update(Emp emp) { 
		return empDao.update(emp);
	}

	@Override
	public int delete(int empno) { 
		return empDao.delete(empno);
	}

	@Override
	public void dummyDataInsert50() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object detail(Emp emp) {
		// TODO Auto-generated method stub
		return null;
	}  

}
