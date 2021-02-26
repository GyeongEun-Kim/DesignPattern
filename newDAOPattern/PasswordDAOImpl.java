package newDAOPattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import daoPattern.Password;

public class PasswordDAOImpl implements PasswordDAO {
	final static String DB_FILE_NAME = "test.db";
	final static String DB_TABLE_NAME= "passwordinfo";
	
	Connection connection=null;
	Statement statement=null;
	ResultSet rs= null;
	
	public PasswordDAOImpl ()  {
		try {
		
			connection = DriverManager.getConnection(
					"jdbc:sqlite:" + DB_FILE_NAME);
			statement = connection.createStatement();// set timeout to 30 sec	.
			statement.setQueryTimeout(30);  
		
			final String table = " (url text primary key,"
								+ " id text, "
								+ "password text)";
			// create table
			
			statement.executeUpdate("DROP TABLE IF EXISTS " + DB_TABLE_NAME);
			statement.executeUpdate("CREATE TABLE " + DB_TABLE_NAME + table);
			}
		
		catch (SQLException e) {	
			e.printStackTrace();
			}


	}

	@Override
	public void insert(PasswordInfo p) {
		try {
			String fmt = "INSERT INTO %s VALUES('%s','%s','%s')";
			String q = String.format(fmt, DB_TABLE_NAME,p.getUrl(),p.getId(),p.getPassword());
	
			statement.executeUpdate(q);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
		// TODO Auto-generated method stub
		

	@Override
	public void findAll() {
		ResultSet rs;
		System.out.println("---전체 출력 ---");
		try {
			rs= statement.executeQuery("SELECT * FROM "+ DB_TABLE_NAME);
			while (rs.next()) {
				System.out.println(rs.getString("url")+" "+rs.getString("id")+" "+rs.getString("password"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}	
		// TODO Auto-generated method stub


	@Override
	public PasswordInfo findByKey(String url) {
		PasswordInfo ps=null;
		System.out.println("---key값으로 검색---");
		try {
			ResultSet rs;
			
			String fmt = "SELECT * FROM %s WHERE url = '%s'";
			String q = String.format(fmt, DB_TABLE_NAME,url);
			rs=statement.executeQuery(q);
			while (rs.next()) {
				ps=new PasswordInfo(rs.getString("url"),rs.getString("id"),rs.getString("password"));
				//System.out.println(rs.getString("url")+" "+rs.getString("id")+" "+rs.getString("password"));
				
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}

	@Override
	public void update(String newId, PasswordInfo p) {
		
		try {
			String fmt = "UPDATE %s SET id='%s' WHERE url='%s'";
			String q = String.format(fmt, DB_TABLE_NAME,newId, p.getUrl());

			statement.executeUpdate(q);
			System.out.println("--정보 업데이트 완료---");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String url) {
		
		try {
			String fmt = "DELETE FROM %s WHERE url='%s'";
			String q = String.format(fmt, DB_TABLE_NAME,url);
			
			statement.executeUpdate(q);
			System.out.println("---정보 삭제 완료---");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
		// TODO Auto-generated method stub
		


	@Override
	public void delete(PasswordInfo p) {
		
		// TODO Auto-generated method stub
		
	}
	

}
