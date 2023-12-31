package jdbcexam_study02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectBookLab {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				Statement stmt = conn.createStatement();
				Scanner sc = new Scanner(System.in);){

			int select;
			ResultSet rs;
			String aws;
			while(true) {
				System.out.println("1.모두 출력하기");
				System.out.println("2.가격이 높은 순으로 출력하기");
				System.out.println("3.20000 이상의 도서들만 출력하기");
				System.out.println("4.웹 프로그래밍 도서들만 출력하기");
				System.out.println("5.데이터베이스와 인프라 도서들만 출력하기");
				System.out.println("6.도서명에 '자바'를 포함하는 도서들만 출력하기");
				System.out.println("7.분류별 도서 가격의 평군을 출력하기");
				select = sc.nextInt();
				
				switch(select) {
				case 1:
					rs = stmt.executeQuery("SELECT TITLE, FORMAT(PRICE,0), KIND FROM BOOK");
					break;
				case 2:
					rs = stmt.executeQuery("SELECT TITLE, FORMAT(PRICE,0), KIND FROM BOOK ORDER BY PRICE DESC");
					break;
				case 3:
					rs = stmt.executeQuery("SELECT TITLE, FORMAT(PRICE,0), '' FROM BOOK WHERE PRICE >= 20000");
					break;
				case 4:
					rs = stmt.executeQuery("SELECT TITLE, FORMAT(PRICE,0), KIND FROM BOOK "
							+ "WHERE KIND = 'b02'");
					break;
				case 5:
					rs = stmt.executeQuery("SELECT TITLE, FORMAT(PRICE,0), '' FROM BOOK "
							+ "WHERE KIND IN ('b04', 'b05')");
					break;
				case 6:
					rs = stmt.executeQuery("SELECT TITLE, FORMAT(PRICE,0), KIND FROM BOOK "
							+ "WHERE TITLE LIKE '%자바%'");
					break; 
				default:
					rs = stmt.executeQuery("SELECT KIND, FORMAT(AVG(PRICE),0) AVG FROM BOOK GROUP BY KIND");
					String kind;
					while(rs.next()) {
						switch(rs.getString(1)) {
						case "b01":
							kind = "프로그래밍 언어";
							break;
						case "b02":
							kind = "웹 프로그래밍";
							break;
						case "b03":
							kind = "빅데이터";
							break;
						case "b04":
							kind = "데이터베이스";
							break;
						default:
							kind = "인프라";
						}
							
						System.out.printf("%s 도서들의 가격 평균은 %s원 입니다.\n",kind,rs.getString(2));
					}
				}
				
				if(select != 7)
					SelectBookLab.printInfo(rs);
				
				System.out.print("계속 입력하겠습니까?(y/n)");
				aws = sc.next();
				if (aws.equalsIgnoreCase("y")) {
					continue;
				} 
				System.out.println("종료합니다.");
				break;
			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} 

	}
	static void printInfo(ResultSet rs) {
		try {
			while(rs.next()){
				if(rs.getString(3).equals(""))
					System.out.printf("책 제목: %-30s 가격 : %s원\n",rs.getString(1),rs.getString(2));
				else
					System.out.printf("책 제목: %-30s 가격 : %s원 분류 : %s\n",
							rs.getString(1),rs.getString(2), rs.getString(3));
			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} 
	}

}
