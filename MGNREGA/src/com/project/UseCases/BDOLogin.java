package com.project.UseCases;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.project.Dao.EmployeeWedeges;
import com.project.Dao.MGNREGADao;
import com.project.Dao.MGNREGAImpl;
import com.project.bean.Project;

public class BDOLogin {

	public static void main(String[] args) {
Scanner sc= new Scanner(System.in);

     System.out.println("who are you?");
     System.out.println("BDO");
     System.out.println("GPM");
     String admi=sc.next();
		MGNREGADao dao = new MGNREGAImpl();

     if(admi.equalsIgnoreCase("bdo")) {
    	 
    	 
    	 System.out.println("Enter Username:");
 		String uname = sc.next();
 		
 		System.out.println("Enter Password:");
 		String pass = sc.next();
 		
// 		StudentDao dao = new StudentDaoImpl();
 	
 		Boolean a1=dao.BDOlogin(uname,pass);
// 		System.out.println(a1);
 		if(a1==true) {
 			
 			System.out.println("Login successful...");
 			System.out.println("select the operation number"+"\n"+
 			                   "1 Create a project");
 			System.out.println("2 View List Of Project.");
 			System.out.println("3 Create new Gram Panchayat Member(GPM)..");
 			System.out.println("4 View all the GPM.");
 			System.out.println("5 Allocate  Project to GPM");
 			System.out.println("6 See List of Employee working on that Project and their wages.");
 			
 			int opt = sc.nextInt();
			if(opt==1) {
				System.out.println("enter id");
 				int proid= sc.nextInt();
 				
 				System.out.println("enter name");
 				String proname = sc.next();
 	          
 				String str1 =dao.createProject(new Project(proid, proname));
 				System.out.println(str1);
 			}
			else if(opt == 2) {
			List<Project> li = 	dao.viewAllProjects();
			for(Project i:li) {
				System.out.println(i);
			}
			
			}
			else if(opt==3) {
				  System.out.println("enter gmpid");
	 				  int p2=sc.nextInt();
	 				  
	 				  System.out.println("enter gmp name");
	 				  String s3= sc.next();
	 				  
	 				  System.out.println("enter gmp password");
	 				  String s4= sc.next();
	 				  
	 				
	 			String str3 =dao.createGMP(p2, s3, s4);
	 				System.out.println(str3);
			}
			
//			----------
			
			else if(opt==5) {
				System.out.println("pro id and gmp id must match");
				System.out.println("enter pro id");
				int a = sc.nextInt();
				System.out.println("enter gmp id to which u w allo");
				int b = sc.nextInt();

			String string =	dao.AllocateProToGMP(a, b);
			System.out.println(string);
			}
			
			else if(opt==6) {
				System.out.println("Enter name");
				String cname= sc.next();
			List<EmployeeWedeges> liemp = dao.empOnpro(cname);
				for(EmployeeWedeges i:liemp) {
					System.out.println(i);
				}
			}
			
 			else {
 				System.out.println("not authorized");
 			}
 		}
 		}
 		else {
 			System.out.println("are you new GPM?");
 			System.out.println("enter y or n");
 			String g=sc.next();
 			if(g.equalsIgnoreCase("y")) {
 				System.out.println("enter id");
 				int gid= sc.nextInt();
 				
 				System.out.println("enter name");
 				String gmpname = sc.next();
 				
 				System.out.println("enter password");
 				String gmppass = sc.next();
 				
 			String msg1 = 	dao.createGMP(gid,gmpname , gmppass);
 			System.out.println(msg1);
 			}
 			else {
 				System.out.println("enter name");
 				String name = sc.next();
 				
 				System.out.println("enter password");
 				String pass1 = sc.next();
 				
 			 Boolean b1 = dao.GMPlogin(name, pass1);
 			 if(b1==true) {
 				 System.out.println("Successfully logid as GMP");
 				System.out.println("select the operation number"+"\n"+"1 Create a Employee");
 	 			System.out.println("2 View the Details of Employee.");
 	 			System.out.println("3 Assign Employee to a Project.");
 	 			System.out.println("4 View total number of days Employee worked in a project and also their wages.");
 	 			
 	 			int opt = sc.nextInt();
 	 			
 	 			if(opt==1) {
 	 				  System.out.println("enter empid");
 	 				  int p1=sc.nextInt();
 	 				  
 	 				  System.out.println("enter emp name");
 	 				  String s1= sc.next();
 	 				  
 	 				  System.out.println("enter emp address");
 	 				  String s2= sc.next();
 	 				  
 	 				
 	 			String str =dao.createEmployee(p1, s1, s2);
 	 				System.out.println(str);
 	 				
 	 			}
 	 			
 			 }
 			}
 		}
    	 
 		}
    	 
    	 
    	 
     }
     
		
		
			
			
		

	


