package day03_study02;

public class ControlLab2 {

	public static void main(String[] args) {
		for(int i=1; i<=10;i++) {
			if(i%3==0 | i%4==0)
				continue;
			System.out.println(i);
		}

	}

}
