package day03_study02;

public class ControlLab1 {

	public static void main(String[] args) {
		int cnt = 0;
		while(true) {
			int ran = (int)(Math.random()*11) + 10;
			
			if(ran % 3 == 0 || ran % 5 == 0) {
				int sum = 0;
				for(int i=1; i<=ran;i++)
					sum += i;
				System.out.println(sum);
				cnt++;
			} else if(ran == 11 || ran == 17 || ran == 19) {
				System.out.printf("%d회 반복함", cnt);
				break;
			} else {
				System.out.println("재수행");
			}
					
		}
	}

}
