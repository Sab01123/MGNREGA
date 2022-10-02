
package com.project.Dao;

import java.util.List;

import com.project.bean.Employee;
import com.project.bean.EmployeeWedeges;
import com.project.bean.GMP;
import com.project.bean.Project;
import com.project.bean.TOD2;
import com.project.bean.TotalNOD;

public interface MGNREGADao {

	public  Boolean  BDOlogin(String name, String password);
	
	public  Boolean  GMPlogin(String name, String password);
	
	 public String createProject(Project pro);
	

	 
	 public List<Project> viewAllProjects();
	 
	 public List<Employee> viewAllEmployees();
	 
	 public String createGMP(int gmpId, String gmpName, String gmpPassword);
	 
	 public List<GMP> viewAllGMP();
	 
	 public String AllocateProToGMP(int proAId, int gmpAId);
	 
	 public String AllocateProToEmp(int proAEId, int empAId);
	 
//	 public List<TotalNOD> viewEmpWorkingonPro(String proName);
	 public List<TOD2> viewEmpWorkingonPro(String empName);
	 
//	 public String createWedges(int wId, int NOD, int wedges);
	 
	 public String createEmployee(int empId, String empName, String empAddress);
	 
	 public List<EmployeeWedeges> empOnpro(String proName);
	
	 
}

