package com.project.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.project.bean.Employee;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createProject(int proId, String proName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> viewAllProjects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createGMP(int gmpId, String gmpName, String gmpPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GMP> viewAllGMP() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String AllocateProToGMP(int proAId, int gmpAId) {
		// TODO Auto-generated method stub
		return null;
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

}
