package day06_study01;

public class MethodLab9 {
	static boolean isRightTriangle(int width, int height, int hypo) {
		if(width*width + height*height == hypo*hypo)
			return true;
		
		return false;
			
	}
	
	static void printTrueFalse(boolean flag) {
		if(flag)
			System.out.println("true");
		else
			System.out.println("false");
	
	}
	
	public static void main(String[] args) {
		printTrueFalse(isRightTriangle(3,4,5));
		printTrueFalse(isRightTriangle(1,2,3));
	}

}
