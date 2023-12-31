package mvclab;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbcexam.mvc.MySQLConnUtil;

public class StudentDAO {
	
	public boolean insertStudent(StudentDTO dto) {
		boolean result = false;
		Connection conn = MySQLConnUtil.connect();
		try (PreparedStatement pstmt = conn
				.prepareStatement("insert into student (name, score) values (?, ?)")) {
			
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getScore());
			pstmt.executeUpdate();
			result = true;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
		MySQLConnUtil.close(conn);
		return result;
	}

	public List<StudentDTO> getAllStudent() {
		Connection conn = MySQLConnUtil.connect();
		List<StudentDTO> slist = null;
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT NAME, SCORE FROM STUDENT");
			slist = new ArrayList<StudentDTO>();
			while (rs.next()) {
				StudentDTO sd = new StudentDTO();
				sd.setName(rs.getString("NAME"));
				sd.setScore(Integer.parseInt(rs.getString("SCORE")));
				slist.add(sd);
			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
		MySQLConnUtil.close(conn);
		return slist;
	}
	
	public int getScore(StudentDTO dto) {
		Connection conn = MySQLConnUtil.connect();
		int score = -1;
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT SCORE FROM STUDENT "
					+ "WHERE NAME = '" + dto.getName() +"'");
			if(rs.next())
				score = rs.getInt("SCORE");
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
		return score;
	}
	
	public boolean updateStudent(StudentDTO dto) {
		boolean result = false;
		Connection conn = MySQLConnUtil.connect();
		try (PreparedStatement pstmt = conn.prepareStatement("UPDATE STUDENT SET SCORE = ? WHERE NAME = ?")) {
			pstmt.setString(2, dto.getName());
			pstmt.setInt(1, dto.getScore());
			pstmt.executeUpdate();		
			result = true;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
		MySQLConnUtil.close(conn);
		return result;
	}
	
	public boolean deleteStudent(StudentDTO dto) {
		boolean result = false;
		Connection conn = MySQLConnUtil.connect();
		try (PreparedStatement pstmt = conn.prepareStatement("DELETE FROM STUDENT WHERE NAME = ?")) {
			pstmt.setString(1, dto.getName());
			System.out.println(pstmt.executeUpdate());
			result = true;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
		MySQLConnUtil.close(conn);
		return result;
	}
}
