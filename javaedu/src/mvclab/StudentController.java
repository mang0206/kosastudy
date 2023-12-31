package mvclab;

import java.util.List;

public class StudentController {
	public void printAll() {
		StudentDAO sd = new StudentDAO();
		List<StudentDTO> slist = sd.getAllStudent();
		if(slist.size() > 0) {
			for(StudentDTO tmpS : slist) {
				System.out.println(tmpS);
			}
		} else
			System.out.println("학생 정보가 없습니다");
	}
	
	public void printScore(String name) {
		StudentDAO sd = new StudentDAO();
		StudentDTO st = new StudentDTO(name);
		int score = sd.getScore(st);
		if(score < 0)
			System.out.println(name + " 학생은 존재하지 않습니다.");
		else
			System.out.printf("%s 학생의 점수는 %d 입니다.\n", name, score);
	}
	
	public void insert(String name, int score) {
		StudentDAO sd = new StudentDAO();
		StudentDTO st = new StudentDTO(name, score);
		boolean flag = sd.insertStudent(st);
		
		if(flag)
			System.out.println("입력 성공");
		else
			System.out.println("입력 실패");
	}
	
	public void update(String name, int score) {
		StudentDAO sd = new StudentDAO();
		StudentDTO st = new StudentDTO(name, score);
		boolean flag = sd.updateStudent(st);
		
		if(flag)
			System.out.println(name + " 학생의 점수를 변경했습니다.");
		else
			System.out.println(name + " 학생은 존재하지 않습니다.");
	}
	
	public void delete(String name) {
		StudentDAO sd = new StudentDAO();
		StudentDTO st = new StudentDTO(name);
		boolean flag = sd.deleteStudent(st);
		
		if(flag)
			System.out.println(name + " 학생의 데이터를 삭제했습니다.");
		else
			System.out.println(name + " 학생은 존재하지 않습니다.");
	}
}
