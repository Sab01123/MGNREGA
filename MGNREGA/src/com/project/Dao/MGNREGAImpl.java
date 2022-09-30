package com.project.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.project.bean.GMP;
import com.project.bean.Project;
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
			
	
			System.out.println(n);
		}
		if(n.equals(name)&&p.equals(password)) {
			flag = true;
		}
				
		} catch (SQLException e) {
			System.out.println("hello");
		}
		return flag;
		

	}

	@Override
	public Boolean GMPlogin(String name, String password) {
		String msg="not found";
		
		// TODO Auto-generated method stub
		return true;
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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TotalNOD> viewEmpWorkingonPro(String proName) {
		// TODO Auto-generated method stub
		return null;
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
					("insert into employee(empId,empName,empAddress,empW) values(?,?,?)");
			
			
			
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
					("select s.empId, s.empName,s.empAddress,k.wedges"
							+ "from  employee s INNER JOIN project c INNER JOIN proAssignToEmp cs  Inner Join wedgesdetail k"
							+ "ON s.empId = cs.empAId AND c.proID = cs.proAId AND s.empid=k.wid AND c.cname= ?");
			
			
//			ps.setString(1, student.getName());
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

}
