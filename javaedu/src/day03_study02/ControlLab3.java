package day03_study02;

public class ControlLab3 {

	public static void main(String[] args) {
		while(true) {
			int ran = (int)(Math.random() * 120) + 1;
			String s = "";
			String s2 = "";
			
			if(ran < 50) {
				if(ran % 10 == 3) {
					s2 = new String(ran + " : *듀크팀*\n");
				}
				s = new String("50 미만");
				
			} else if (ran <= 80) {
				if ( ran >= 70 & ran < 80) {
					s2 = new String(ran + " : *턱시팀*\n");
				}
				s = new String("50 이상 80 이하");
			} else if (ran <= 100) {
				continue;
			} else
				break;
			
			System.out.printf("%d : %s\n%s", ran, s, s2);
		}
	}

}
