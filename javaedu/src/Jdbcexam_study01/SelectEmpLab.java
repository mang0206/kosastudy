package Jdbcexam_study01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class SelectEmpLab {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);){
			Random ran = new Random();
			Statement stmt = conn.createStatement();
			ResultSet rs;
			if(ran.nextBoolean()) {
				rs = stmt.executeQuery("select ename, format(sal,0) S from emp");
				while (rs.next()) {
						System.out.printf("%-7s 직원의 월급은 %s 달러 입니다.\n", 
								rs.getString("ename"), rs.getString("S")); 
				}
			} else {
				rs = stmt.executeQuery("select ename, hiredate from emp order by hiredate");

				while (rs.next()) {
						System.out.printf("%-7s 직원은 %2$tY년 %2$tm월 %2$td일에 입사하였습니다.\n", 
								rs.getString("ename"), rs.getDate("hiredate"));
				}
			}
			
			rs.close();
			stmt.close();
			
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}

	}

}
