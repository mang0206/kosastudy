package mvclab;

import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		StudentController ctl = new StudentController();
		
		int select;
		while(flag) {
			System.out.println("1. 학생 정보 출력");
			System.out.println("2. 학생 정보 입력");
			System.out.println("3. 학생 정보 삭제");
			System.out.println("4. 학생 정보 수정");
			System.out.println("5. 학생 정보 확인");
			System.out.println("6. 종료");
			select = Integer.parseInt(sc.nextLine());
			switch(select) {
			case 1:
				ctl.printAll();
				break;
			case 2:
				System.out.println("이름, 점수 입력:");
				ctl.insert(sc.nextLine(), Integer.parseInt(sc.nextLine()));
				break;
			case 3:
				System.out.println("이름 입력:");
				ctl.delete(sc.nextLine());
				break;
			case 4:
				System.out.println("이름, 점수 입력:");
				ctl.update(sc.nextLine(), Integer.parseInt(sc.nextLine()));
				break;
			case 5:
				System.out.println("이름 입력:");
				ctl.printScore(sc.nextLine());
				break;
			default :
				System.out.println("수행 종료");
				flag = false;	
			}
			
		}
		sc.close();

	}

}
