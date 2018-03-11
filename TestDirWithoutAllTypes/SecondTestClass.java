package TestDirWithoutAllTypes;

public class SecondTestClass {

	@Deprecated	
	public static void a_Test_Method_Dir2() {
		ATestClass newTestRef = new ATestClass();
	}
	
	@SuppressWarnings(value = { })
	public static void a_Test_Dir2() {
		SecondTestClass myTester = new SecondTestClass();
	}
}
