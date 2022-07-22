package com.lec.ch16.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.ch16.dao.DeptDao;
import com.lec.ch16.dao.EmpDao;
import com.lec.ch16.dto.Dept;
import com.lec.ch16.dto.Emp;
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
	public List<Emp> empList(Emp schEmp) { 
		if(schEmp.getEname()!=null) {
			schEmp.setEname(schEmp.getEname().toUpperCase());// Ename 무조건 대문자로 세팅
		}
		if(schEmp.getJob()!=null) {
			schEmp.setJob(schEmp.getJob().toUpperCase());// Job 무조건 대문자로 세팅
		}
		return empDao.empList(schEmp);
	}

}
