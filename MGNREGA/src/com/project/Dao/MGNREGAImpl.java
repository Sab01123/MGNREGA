<<<<<<< HEAD
package com.project.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.project.bean.Employee;
import com.project.bean.EmployeeWedeges;
import com.project.bean.GMP;
import com.project.bean.Project;
import com.project.bean.TOD2;
import com.project.bean.TotalNOD;
import com.project.utility.DBUtil;

public class MGNREGAImpl implements MGNREGADao{

	@Override
	public Boolean BDOlogin(String name, String password) {

	Boolean flag = false;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			
			PreparedStatement ps= conn.prepareStatement("select BDOname,BDOpassword from BDO");			
			
			ResultSet rs= ps.executeQuery();
			String n="";
			String p="";
			
		if(rs.next()) {
			
			 n= rs.getString("BDOname");
			 p= rs.getString("BDOpassword");
			
	
//			System.out.println(n);
		}
		if(n.equals(name)&&p.equals(password)) {
			flag = true;
		}
				
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return flag;
		

	}

	@Override
	public Boolean GMPlogin(String name, String password) {
       Boolean flag = false;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			
			PreparedStatement ps= conn.prepareStatement("select gmpname,gmppassword from gmp");			
			
			ResultSet rs= ps.executeQuery();
			String n="";
			String p="";
			
		if(rs.next()) {
			 n= rs.getString("gmpName");
			 p= rs.getString("gmpPassword");
			
	
//			System.out.println(n);
		}
		if(n.equals(name)&&p.equals(password)) {
			flag = true;
		}
				
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}

	@Override
	public String createProject(Project pro) {
		String message = "Project Not Inserted..";
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement
					("insert into project(proId,proName) values(?,?)");
			
			
			ps.setInt(1,pro.getProId());
			ps.setString(2,pro.getProName());
			
			int x= ps.executeUpdate();
			
			
			if(x > 0)
				message = "Project Inserted Sucessfully !";
			
			
			
		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;
		
	}

	@Override
	public List<Project> viewAllProjects() {

		List<Project> pro= new ArrayList<>();
		
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("select * from project");
			
			
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				
				int r= rs.getInt("proId");
				String n= rs.getString("proName");
				
				
				
			Project student=new Project(r, n);	
				
			pro.add(student);

			}
				
		} catch (SQLException e) {
			System.out.println(e.getMessage());;
		}
		
		
		if(pro.size() == 0)
			System.out.println("zero projects");

		return pro;
	}

	@Override
	public String createGMP(int gmpId, String gmpName, String gmpPassword) {
		String message = "Not Inserted..";
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement
					("insert into GMP(gmpId,gmpName,gmppassword) values(?,?,?)");
			
			
			
			ps.setInt(1,gmpId);
			ps.setString(2,gmpName);
			ps.setString(3, gmpPassword);
			
			int x= ps.executeUpdate();
			
			
			if(x > 0)
				message = "GMP Registered Sucessfully !";
			
			
			
		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;
	}

	@Override
	public List<GMP> viewAllGMP() {

		List<GMP> gmpList= new ArrayList<>();
		
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("select * from gmp");
			
			
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				
				int r= rs.getInt("gmpId");
				String n= rs.getString("gmpName");
				String p= rs.getString("gmpPassword");
				
				
				
			GMP gmp=new GMP(r, n, p);	
				
			gmpList.add(gmp);

			}
				
		} catch (SQLException e) {
			System.out.println(e.getMessage());;
		}
		
		
		if(gmpList.size() == 0)
			System.out.println("GPM List is empty");

		return gmpList;
	}

	@Override
	public String AllocateProToGMP(int proAId, int gmpAId) {
      
		String message = "Not Inserted..";
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement
					("insert into GMPPRO(proAId,gmpAId) values(?,?)");
			
			
			
			ps.setInt(1,proAId);
			ps.setInt(2,gmpAId);
		
			
			int x= ps.executeUpdate();
			
			
			if(x > 0)
				message = "pro allocate Sucessfully !";
			
			
			
		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;
	}

	@Override
	public String AllocateProToEmp(int proAEId, int empAId) {
     
		String message = "Not Inserted..";
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement
					("insert into ProAssignToEmp(proAEId,empAId) values(?,?)");
			
			
			
			ps.setInt(1,proAEId);
			ps.setInt(2,empAId);
		
			
			int x= ps.executeUpdate();
			
			
			if(x > 0)
				message = "Project assigned to Employee Sucessfully !";
			
			
			
		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;
	}

	@Override
	public List<TOD2> viewEmpWorkingonPro(String empName) {

		List<TOD2> list= new ArrayList<>();
		
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("select w.NOD,w.Wedges from wedgesdetail w inner join employee p on w.wid=p.empId and p.empname=?");
			
			ps.setString(1,empName);
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				int r= rs.getInt("nOD");
				int o= rs.getInt("wedges");
	
			TOD2 t = new TOD2(r,o);	
				
			list.add(t);

			}
				
		} catch (SQLException e) {
			System.out.println(e.getMessage());;
		}
		
		
		if(list.size() == 0)
//			System.out.println("No employee found");
			System.out.println("Either the Employee is not registered or the employee have not allocated any project");

		
		return list;
	}

	

	@Override
	public String createEmployee(int empId, String empName, String empAddress) {
      
		String message = "Not Inserted..";
	
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement
					("insert into employee(empId,empName,empAddress) values(?,?,?)");
			
			
			ps.setInt(1,empId);
			ps.setString(2,empName);
			ps.setString(3, empAddress);
			
			int x= ps.executeUpdate();
			
			
			if(x > 0)
				message = "Employee Registered Sucessfully !";
			
			
			
		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;
	}

	@Override
	public List<EmployeeWedeges> empOnpro(String proName) {
		
		
		
		List<EmployeeWedeges> pro=new ArrayList<>();
		
try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement
					("select s.empId, s.empName,s.empAddress,k.wedges from  employee s INNER JOIN project c INNER JOIN proAssignToEmp cs  Inner Join wedgesdetail k ON s.empId = cs.empAId AND c.proID = cs.proAEId AND s.empid=k.wid And c.proname= ?");
			
			ps.setString(1,proName);
			
      	ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				
				int r= rs.getInt("empId");
				String n= rs.getString("empName");
				String q= rs.getString("empAddress");
				int o= rs.getInt("wedges");


				
				
				
			EmployeeWedeges employeeWedeges=new EmployeeWedeges(r, n, q, o);
				
			pro.add(employeeWedeges);

			}
			
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return pro;
	
	}

	@Override
	public List<Employee> viewAllEmployees() {

		List<Employee> emplist= new ArrayList<>();
		
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("select * from employee");
			
			
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				
				int r= rs.getInt("empId");
				String n= rs.getString("empName");
				String a= rs.getString("empAddress");
				
				
				
			Employee emp=new Employee(r, n, a);	
				
			emplist.add(emp);

			}
				
		} catch (SQLException e) {
			System.out.println(e.getMessage());;
		}
		
		
		if(emplist.size() == 0)
			System.out.println("zero projects");

		return emplist;
	}

}
=======
package com.project.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.project.bean.Employee;
import com.project.bean.EmployeeWedeges;
import com.project.bean.GMP;
import com.project.bean.Project;
import com.project.bean.TOD2;
import com.project.bean.TotalNOD;
import com.project.utility.DBUtil;

public class MGNREGAImpl implements MGNREGADao{

	@Override
	public Boolean BDOlogin(String name, String password) {

	Boolean flag = false;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			
			PreparedStatement ps= conn.prepareStatement("select BDOname,BDOpassword from BDO");			
			
			ResultSet rs= ps.executeQuery();
			String n="";
			String p="";
			
		if(rs.next()) {
			
			 n= rs.getString("BDOname");
			 p= rs.getString("BDOpassword");
			
	
//			System.out.println(n);
		}
		if(n.equals(name)&&p.equals(password)) {
			flag = true;
		}
				
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return flag;
		

	}

	@Override
	public Boolean GMPlogin(String name, String password) {
       Boolean flag = false;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			
			PreparedStatement ps= conn.prepareStatement("select gmpname,gmppassword from gmp");			
			
			ResultSet rs= ps.executeQuery();
//			int i= 0;
			String n="";
			String p="";
			
		if(rs.next()) {
//			 i = rs.getInt("gmpId");
			 n= rs.getString("gmpName");
			 p= rs.getString("gmpPassword");
			
	
//			System.out.println(n);
		}
		if(n.equals(name)&&p.equals(password)) {
			flag = true;
		}
				
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}

	@Override
	public String createProject(Project pro) {
		String message = "Project Not Inserted..";
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement
					("insert into project(proId,proName) values(?,?)");
			
			
//			ps.setString(1, student.getName());
			ps.setInt(1,pro.getProId());
			ps.setString(2,pro.getProName());
			
			int x= ps.executeUpdate();
			
			
			if(x > 0)
				message = "Project Inserted Sucessfully !";
			
			
			
		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;
		
	}

	@Override
	public List<Project> viewAllProjects() {

		List<Project> pro= new ArrayList<>();
		
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("select * from project");
			
			
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				
				int r= rs.getInt("proId");
				String n= rs.getString("proName");
				
				
				
			Project student=new Project(r, n);	
				
			pro.add(student);

			}
				
		} catch (SQLException e) {
			System.out.println(e.getMessage());;
		}
		
		
		if(pro.size() == 0)
			System.out.println("zero projects");

		return pro;
	}

	@Override
	public String createGMP(int gmpId, String gmpName, String gmpPassword) {
		String message = "Not Inserted..";
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement
					("insert into GMP(gmpId,gmpName,gmppassword) values(?,?,?)");
			
			
			
			ps.setInt(1,gmpId);
			ps.setString(2,gmpName);
			ps.setString(3, gmpPassword);
			
			int x= ps.executeUpdate();
			
			
			if(x > 0)
				message = "GMP Registered Sucessfully !";
			
			
			
		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;
	}

	@Override
	public List<GMP> viewAllGMP() {

		List<GMP> gmpList= new ArrayList<>();
		
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("select * from gmp");
			
			
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				
				int r= rs.getInt("gmpId");
				String n= rs.getString("gmpName");
				String p= rs.getString("gmpPassword");
				
				
				
			GMP gmp=new GMP(r, n, p);	
				
			gmpList.add(gmp);

			}
				
		} catch (SQLException e) {
			System.out.println(e.getMessage());;
		}
		
		
		if(gmpList.size() == 0)
			System.out.println("GPM List is empty");

		return gmpList;
	}

	@Override
	public String AllocateProToGMP(int proAId, int gmpAId) {
      
		String message = "Not Inserted..";
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement
					("insert into GMPPRO(proAId,gmpAId) values(?,?)");
			
			
			
			ps.setInt(1,proAId);
			ps.setInt(2,gmpAId);
		
			
			int x= ps.executeUpdate();
			
			
			if(x > 0)
				message = "pro allocate Sucessfully !";
			
			
			
		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;
	}

	@Override
	public String AllocateProToEmp(int proAEId, int empAId) {
     
		String message = "Not Inserted..";
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement
					("insert into ProAssignToEmp(proAEId,empAId) values(?,?)");
			
			
			
			ps.setInt(1,proAEId);
			ps.setInt(2,empAId);
		
			
			int x= ps.executeUpdate();
			
			
			if(x > 0)
				message = "Project assigned to Employee Sucessfully !";
			
			
			
		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;
	}

	@Override
	public List<TOD2> viewEmpWorkingonPro(String empName) {

		List<TOD2> list= new ArrayList<>();
		
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("select w.NOD,w.Wedges from wedgesdetail w inner join employee p on w.wid=p.empId and p.empname=?");
			
			ps.setString(1,empName);
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				int r= rs.getInt("nOD");
				int o= rs.getInt("wedges");
	
			TOD2 t = new TOD2(r,o);	
				
			list.add(t);

			}
				
		} catch (SQLException e) {
			System.out.println(e.getMessage());;
		}
		
		
		if(list.size() == 0)
//			System.out.println("No employee found");
			System.out.println("Either the Employee is not registered or the employee have not allocated any project");

		
		return list;
	}

	@Override
	public String createWedges(int wId, int NOD, int wedges) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createEmployee(int empId, String empName, String empAddress) {
      
		String message = "Not Inserted..";
	
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement
					("insert into employee(empId,empName,empAddress) values(?,?,?)");
			
			//???????????/
			
			ps.setInt(1,empId);
			ps.setString(2,empName);
			ps.setString(3, empAddress);
			
			int x= ps.executeUpdate();
			
			
			if(x > 0)
				message = "Employee Registered Sucessfully !";
			
			
			
		} catch (SQLException e) {
			message = e.getMessage();
		}

		return message;
	}

	@Override
	public List<EmployeeWedeges> empOnpro(String proName) {
		
		
		
		List<EmployeeWedeges> pro=new ArrayList<>();
		
try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement
					("select s.empId, s.empName,s.empAddress,k.wedges from  employee s INNER JOIN project c INNER JOIN proAssignToEmp cs  Inner Join wedgesdetail k ON s.empId = cs.empAId AND c.proID = cs.proAEId AND s.empid=k.wid And c.proname= ?");
			
			ps.setString(1,proName);
			
      	ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				
				int r= rs.getInt("empId");
				String n= rs.getString("empName");
				String q= rs.getString("empAddress");
				int o= rs.getInt("wedges");


				
				
				
			EmployeeWedeges employeeWedeges=new EmployeeWedeges(r, n, q, o);
				
			pro.add(employeeWedeges);

			}
			
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return pro;
	
	}

	@Override
	public List<Employee> viewAllEmployees() {

		List<Employee> emplist= new ArrayList<>();
		
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("select * from employee");
			
			
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				
				int r= rs.getInt("empId");
				String n= rs.getString("empName");
				String a= rs.getString("empAddress");
				
				
				
			Employee emp=new Employee(r, n, a);	
				
			emplist.add(emp);

			}
				
		} catch (SQLException e) {
			System.out.println(e.getMessage());;
		}
		
		
		if(emplist.size() == 0)
			System.out.println("zero projects");

		return emplist;
	}

}
>>>>>>> 8cb2144ddfd0482c344e30e8781c086d363e6fb5
