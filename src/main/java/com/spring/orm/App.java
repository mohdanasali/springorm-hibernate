package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

import antlr.collections.List;


public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
       StudentDao studentDao= context.getBean("studentDao",StudentDao.class);
//       Student student = new Student(222,"Amit Kumar","Lucknow");
//       studentDao.insert(student);
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       boolean go =true;
       while(go) {
    	   System.out.println("Press 1 for add new student");
    	   System.out.println("Press 2 for display all student");
    	   System.out.println("Press 3 for get detail of single student");
    	   System.out.println("Press 4 for delete student");
    	   System.out.println("Press 5 for update the student");
    	   System.out.println("Press 6 for exit");
    	   try {
			Integer input = Integer.parseInt(br.readLine());
			switch (input) {
			case 1:
				//add new student
				Student student = new Student();
				    
				studentDao.insert(student);
				break;
			case 2:
				// display all student
			java.util.List<Student> allStudent= studentDao.getAllStudent();
			System.out.println(allStudent);
				break;
			case 3:
				//display single student
			Student oneStudent=	studentDao.getStudent(101);
			System.out.println(oneStudent);
				break;
			case 4:
				//delete student
				studentDao.deleteStudent(344);
				break;
			case 5:
				//update the student
				Student updateStudent = new Student(102,"Shariq","Jalandhar");
				studentDao.updateStudent(updateStudent);
				break;
			case 6:
				go = false;
				break;
		   default:
			   System.out.println("ERROR.Enter a valid option to continue");
			   break;
			}
		} catch (Exception e) {
			System.out.println("Invalid Input");
			System.out.println(e.getMessage());
		}
    	   
       }
    }
}
