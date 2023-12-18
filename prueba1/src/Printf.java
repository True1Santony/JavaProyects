
public class Printf {

	public static void main(String[] args) {
		System.out.printf("%d %(d %+d %05d\n", 3, -3, 3, 3);

	    System.out.printf("Default floating-point format: %f\n", 1234567.123);
	    System.out.printf("Floating-point with commas: %,f\n", 1234567.123);
	    System.out.printf("Negative floating-point default: %,f\n", -1234567.123);
	    System.out.printf("Negative floating-point option: %,(f\n", -1234567.123);

	    System.out.printf("Line-up positive and negative values:\n");
	    System.out.printf("% ,.2f\n% ,.2f\n", 1234567.123, -1234567.123);
	  }
	}


