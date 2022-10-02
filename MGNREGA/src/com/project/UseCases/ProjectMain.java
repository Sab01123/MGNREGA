<<<<<<< HEAD
package com.project.UseCases;

import java.util.List;
import java.util.Scanner;

import com.project.Dao.MGNREGADao;
import com.project.Dao.MGNREGAImpl;
import com.project.bean.Employee;
import com.project.bean.EmployeeWedeges;
import com.project.bean.GMP;
import com.project.bean.Project;
import com.project.bean.TOD2;

public class ProjectMain {

	public static void main(String[] args) {
Scanner sc= new Scanner(System.in);

System.out.println("Welcome to MGNREGA");

       while(true) {
System.out.println("You can login as BDO or GPM");
     System.out.println("Who are you?");
     System.out.println("BDO");
     System.out.println("GPM");
     String admi=sc.next();
		MGNREGADao dao = new MGNREGAImpl();

     if(admi.equalsIgnoreCase("bdo")) {
    	 
    	 
    	 System.out.println("Enter Username:");
 		String uname = sc.next();
 		
 		System.out.println("Enter Password:");
 		String pass = sc.next();
 		
 	
 		Boolean a1=dao.BDOlogin(uname,pass);
 		if(a1==true) {
 			
 			System.out.println("Login as BDO successful...");
 			while(true) {
 				
 			
 			System.out.println("select the operation number"+"\n"+
 			                   "* 1 Create a project");
 			System.out.println("* 2 View List Of Project.");
 			System.out.println("* 3 Create new Gram Panchayat Member(GPM)..");
 			System.out.println("* 4 View all the GPM.");
 			System.out.println("* 5 Allocate  Project to GPM");
 			System.out.println("* 6 See List of Employee working on that Project and their wages.");
 			
 			int opt = sc.nextInt();
			if(opt==1) {
				System.out.println("enter project id");
 				int proid= sc.nextInt();
 				
 				System.out.println("enter project name");
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
				  System.out.println("enter GMP id");
	 				  int p2=sc.nextInt();
	 				  
	 				  System.out.println("enter GMP name");
	 				  String s3= sc.next();
	 				  
	 				  System.out.println("enter GMP password");
	 				  String s4= sc.next();
	 				  
	 				
	 			String str3 =dao.createGMP(p2, s3, s4);
	 				System.out.println(str3);
			}
			

			else if(opt==4) {
				
				List<GMP> allgmp = 	dao.viewAllGMP();
				for(GMP i:allgmp) {
					System.out.println(i);
				}
				
			}
			
			else if(opt==5) {
				System.out.println("** Project id and gmp id must match to their respective table **");
				System.out.println("enter pro id");
				int a = sc.nextInt();
				System.out.println("enter gmp id");
				int b = sc.nextInt();

			String string =	dao.AllocateProToGMP(a, b);
			System.out.println(string);
			}
			
			else if(opt==6) {
				System.out.println("Enter project name");
				
				String cname= sc.next();
				
			List<EmployeeWedeges> liemp = dao.empOnpro(cname);
			System.out.println("Employee Details working on: "+cname);
				for(EmployeeWedeges i:liemp) {
					System.out.println(i);
				}
			}
 			
 			else {
 				System.out.println("not authorized");
 			}
			System.out.println("   "+"\n"+"-->Do you want to execute any other operations ? Enter Y or N");
			System.out.println("(if you will select N you will be logout)");
			String ans = sc.next();
			if(ans.equalsIgnoreCase("n")) {
				System.out.println("You are successfully logged out");
				break;
			}
 		}
 		}
 		else {
 			System.out.println("Incorrect BDO name or Password");
 		}
 		
 		}
     
 		else if(admi.equalsIgnoreCase("GPM")) {
 			System.out.println("Are you a new GPM?");
 			System.out.println("Enter Y or N");
 			System.out.println("Y: Register as new GPM");
 			System.out.println("N: Login as existing GPM");
 			String g=sc.next();
 			if(g.equalsIgnoreCase("y")) {
 				System.out.println("Enter new id");
 				int gid= sc.nextInt();
 				
 				System.out.println("Enter name");
 				String gmpname = sc.next();
 				
 				System.out.println("Enter password");
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
 				 System.out.println("Successfully login as GPM");
 				 while(true) {
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
 	 			else if(opt==2) {
 	 				List<Employee> li =	dao.viewAllEmployees();
 	 				for(Employee i:li) {
 	 					System.out.println(i);
 	 				}
 	 			}
 	 			else if(opt==3) {
 	 				System.out.println("Pro id and emp id must match their respective table");
 					System.out.println("enter project id");
 					int a = sc.nextInt();
 					System.out.println("enter employee id");
 					int b = sc.nextInt();

 				String string =	dao.AllocateProToEmp(a, b);
 				System.out.println(string);
 	 			}
 	 			else if(opt==4) {
// 	 				System.out.println("enter project name to view total number of days Employee worked in a project and also their wages.");
 	 				System.out.println("enter employee name");
 	 				String empname = sc.next();
 	 				List<TOD2> li =	dao.viewEmpWorkingonPro(empname);
 	 				for(TOD2 i:li) {
 	 					System.out.println(i);
 	 				}
 	 				
 	 			}
 	 			System.out.println("   "+"\n"+"-->Do you want to execute any other operations ? Enter Y or N");
 				System.out.println("(if you will select N you will be logout)");
 				String ans = sc.next();
 				if(ans.equalsIgnoreCase("n")) {
 					System.out.println("You are successfully logged out");
 					break;
 				}
 			 }
 				 
 			 }
 			}
 		}
    	 
     System.out.println("Do you want to Exit Y or N");
     String exit = sc.next();
     if(exit.equalsIgnoreCase("y")) {
    	 System.out.println("Thank you for visting MGNREGA");
    	 break;
     }
 		}
       
	}
     }
     
		
		
			
			
		

	


=======
package com.project.UseCases;

import java.util.List;
import java.util.Scanner;

import com.project.Dao.MGNREGADao;
import com.project.Dao.MGNREGAImpl;
import com.project.bean.Employee;
import com.project.bean.EmployeeWedeges;
import com.project.bean.GMP;
import com.project.bean.Project;
import com.project.bean.TOD2;

public class ProjectMain {

	public static void main(String[] args) {
Scanner sc= new Scanner(System.in);

System.out.println("Welcome to MGNREGA");

       while(true) {
System.out.println("You can login as BDO or GPM");
     System.out.println("Who are you?");
     System.out.println("BDO");
     System.out.println("GPM");
     String admi=sc.next();
		MGNREGADao dao = new MGNREGAImpl();

     if(admi.equalsIgnoreCase("bdo")) {
    	 
    	 
    	 System.out.println("Enter Username:");
 		String uname = sc.next();
 		
 		System.out.println("Enter Password:");
 		String pass = sc.next();
 		
 	
 		Boolean a1=dao.BDOlogin(uname,pass);
 		if(a1==true) {
 			
 			System.out.println("Login as BDO successful...");
 			while(true) {
 				
 			
 			System.out.println("select the operation number"+"\n"+
 			                   "* 1 Create a project");
 			System.out.println("* 2 View List Of Project.");
 			System.out.println("* 3 Create new Gram Panchayat Member(GPM)..");
 			System.out.println("* 4 View all the GPM.");
 			System.out.println("* 5 Allocate  Project to GPM");
 			System.out.println("* 6 See List of Employee working on that Project and their wages.");
 			
 			int opt = sc.nextInt();
			if(opt==1) {
				System.out.println("enter project id");
 				int proid= sc.nextInt();
 				
 				System.out.println("enter project name");
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
				  System.out.println("enter GMP id");
	 				  int p2=sc.nextInt();
	 				  
	 				  System.out.println("enter GMP name");
	 				  String s3= sc.next();
	 				  
	 				  System.out.println("enter GMP password");
	 				  String s4= sc.next();
	 				  
	 				
	 			String str3 =dao.createGMP(p2, s3, s4);
	 				System.out.println(str3);
			}
			

			else if(opt==4) {
				
				List<GMP> allgmp = 	dao.viewAllGMP();
				for(GMP i:allgmp) {
					System.out.println(i);
				}
				
			}
			
			else if(opt==5) {
				System.out.println("** Project id and gmp id must match to their respective table **");
				System.out.println("enter pro id");
				int a = sc.nextInt();
				System.out.println("enter gmp id");
				int b = sc.nextInt();

			String string =	dao.AllocateProToGMP(a, b);
			System.out.println(string);
			}
			
			else if(opt==6) {
				System.out.println("Enter project name");
				
				String cname= sc.next();
				
			List<EmployeeWedeges> liemp = dao.empOnpro(cname);
			System.out.println("Employee Details working on: "+cname);
				for(EmployeeWedeges i:liemp) {
					System.out.println(i);
				}
			}
 			
 			else {
 				System.out.println("not authorized");
 			}
			System.out.println("   "+"\n"+"-->Do you want to execute any other operations ? Enter Y or N");
			System.out.println("(if you will select N you will be logout)");
			String ans = sc.next();
			if(ans.equalsIgnoreCase("n")) {
				System.out.println("You are successfully logged out");
				break;
			}
 		}
 		}
 		else {
 			System.out.println("Incorrect BDO name or Password");
 		}
 		
 		}
     
 		else if(admi.equalsIgnoreCase("GPM")) {
 			System.out.println("Are you a new GPM?");
 			System.out.println("Enter Y or N");
 			System.out.println("Y: Register as new GPM");
 			System.out.println("N: Login as existing GPM");
 			String g=sc.next();
 			if(g.equalsIgnoreCase("y")) {
 				System.out.println("Enter new id");
 				int gid= sc.nextInt();
 				
 				System.out.println("Enter name");
 				String gmpname = sc.next();
 				
 				System.out.println("Enter password");
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
 				 System.out.println("Successfully login as GPM");
 				 while(true) {
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
 	 			else if(opt==2) {
 	 				List<Employee> li =	dao.viewAllEmployees();
 	 				for(Employee i:li) {
 	 					System.out.println(i);
 	 				}
 	 			}
 	 			else if(opt==3) {
 	 				System.out.println("Pro id and emp id must match their respective table");
 					System.out.println("enter project id");
 					int a = sc.nextInt();
 					System.out.println("enter employee id");
 					int b = sc.nextInt();

 				String string =	dao.AllocateProToEmp(a, b);
 				System.out.println(string);
 	 			}
 	 			else if(opt==4) {
// 	 				System.out.println("enter project name to view total number of days Employee worked in a project and also their wages.");
 	 				System.out.println("enter employee name");
 	 				String empname = sc.next();
 	 				List<TOD2> li =	dao.viewEmpWorkingonPro(empname);
 	 				for(TOD2 i:li) {
 	 					System.out.println(i);
 	 				}
 	 				
 	 			}
 	 			System.out.println("   "+"\n"+"-->Do you want to execute any other operations ? Enter Y or N");
 				System.out.println("(if you will select N you will be logout)");
 				String ans = sc.next();
 				if(ans.equalsIgnoreCase("n")) {
 					System.out.println("You are successfully logged out");
 					break;
 				}
 			 }
 				 
 			 }
 			}
 		}
    	 
     System.out.println("Do you want to Exit Y or N");
     String exit = sc.next();
     if(exit.equalsIgnoreCase("y")) {
    	 System.out.println("Thank you for visting MGNREGA");
    	 break;
     }
 		}
       
	}
     }
     
		
		
			
			
		

	


>>>>>>> 8cb2144ddfd0482c344e30e8781c086d363e6fb5
