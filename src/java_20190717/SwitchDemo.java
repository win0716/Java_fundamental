package java_20190717;

public class SwitchDemo {
	
	public static void main(String[] args) {
		int month = Integer.parseInt(args[0]);
		String season = null;
		//case 평가값은 유일해야 한다.
		/*switch(month) {
		case 12 : season = "겨울"; break;
		case 1 : season = "겨울"; break;
		case 2 : season = "겨울"; break;
		case 3 : season = "봄"; break;
		case 4 : season = "봄"; break;
		case 5 : season = "여름"; break;
		case 6 : season = "여름"; break;
		case 7 : season = "여름"; break;
		case 8 : season = "여름"; break;
		case 9 : season = "가을"; break;
		case 10 : season = "가을"; break;
		case 11 : season = "가을"; break;
		default : season = "없는 계절";
		*/
		switch(month) {
		case 12 : 
		case 1 : 
		case 2 : season = "겨울"; break;
		case 3 : 
		case 4 : 
		case 5 : season = "봄"; break;
		case 6 : 
		case 7 : 
		case 8 : season = "여름"; break;
		case 9 : 
		case 10 : 
		case 11 : season = "가을"; break;
		default : season = "없는 계절";
	    }
		System.out.printf("%d월은 %s 입니다.",month,season);
		
	}

}
