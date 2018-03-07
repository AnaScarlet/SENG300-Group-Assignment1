package temp.src.Assign3;



//1) javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar *.java
//2) java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore NumbersTest

public class Numbers{

  private int[] nums;

  public Numbers(int [] numsArray){
    nums =  new int[numsArray.length];

    for (int count = 0; count < numsArray.length; count++){
			nums[count] = numsArray[count];
		}
	}



  public static String getID(){
  return "00332036";
  }

  public int[] getNums(){
    int[] temp = new int[nums.length];

  for (int count = 0; count < nums.length; count++){
      temp[count] = nums[count];
    }

    return temp;
  }

  public int sum(){
    int sum = 0;
    for (int count = 0; count < nums.length; count++){
      sum = sum + nums[count];
    }

    return sum;
  }


  public void reset(){
    nums = new int[10];
    nums[0] = 0;
    nums[1] = 1;
    nums[2] = 2;
    nums[3] = 3;
    nums[4] = 4;
    nums[5] = 5;
    nums[6] = 6;
    nums[7] = 7;
    nums[8] = 8;
    nums[9] = 9;


  }

}
