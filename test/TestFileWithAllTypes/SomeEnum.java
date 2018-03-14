package test.TestFileWithAllTypes;

public class SomeEnum {
	public enum MyEnum {
		   ONE(1),
		   TWO(2);
		   private int value;
		   private MyEnum(int value) {
		      this.value = value;
		   }
		   public int getValue() {
		      return value;
		   }
	}
	enum X{} 
	
	MyEnum x = MyEnum.ONE;
}
