package jdbcexam_study02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertBookLab {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement("INSERT INTO BOOK (TITLE, PRICE, KIND) VALUES (?, ?, ?)");
				Scanner scan = new Scanner(System.in);){
			String bookName;
			int price;
			String kind;
			
			int cnt = 1;
			while(true) {
				System.out.print("도서명을 입력하세요 : ");
				bookName = scan.nextLine();
				System.out.print("가격을 입력하세요 : ");
				price = Integer.parseInt(scan.nextLine());
				System.out.println("도서분류에 대한 넘버를 입력하세요.");
				System.out.println("1.프로그래밍 언어");
				System.out.println("2.웹 프로그래밍");
				System.out.println("3.빅데이터");
				System.out.println("4.데이터베이스");
				System.out.println("5.인프라");
				System.out.println("선택(1~5)");
				kind = scan.nextLine();

				pstmt.setString(1, bookName);
				pstmt.setInt(2, price);
				pstmt.setString(3, "b0"+kind);
				pstmt.executeUpdate();
				
				System.out.println("정보가 입력되었습니다.");
				System.out.print("계속 입력하겠습니까?(y/n)");
				String aws = scan.nextLine();
				if (aws.equalsIgnoreCase("y")) {
					cnt++;
					continue;
				} 
				System.out.println(cnt + "개의 데이터 입력 완료!");
				break;
			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} 

	}

}
