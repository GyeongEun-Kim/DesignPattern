package newDAOPattern;
import java.sql.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PasswordInfo p;
		
		PasswordDAOImpl passwordDAOImpl = new PasswordDAOImpl();
		
		p=new PasswordInfo("https://www.smu.ac.kr", "smu", "abcde");
		passwordDAOImpl.insert(p);
		
		p=new PasswordInfo("https://www.smu2.ac.kr", "smu2", "abcde");
		passwordDAOImpl.insert(p);
		
	
		passwordDAOImpl.findAll(); 
		passwordDAOImpl.update("smu1", p);//id smu2를smu1으로 수정
		System.out.println(passwordDAOImpl.findByKey("https://www.smu2.ac.kr")); //id가 smu1인 데이터가 있는지 출력해서 확인
		passwordDAOImpl.delete("https://www.smu2.ac.kr"); //
		
		passwordDAOImpl.findAll();
			

		
	}
}
