	/**
	 *  @authors			    Anastasiya Lazarenko, Matthew Buhler, Zachary Hull 
	 */





package src.Assign3;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class TestDecAndRefCounter {
	
	private static String BASEDIR = "C:\\GNU-Prolog";

///////////////////////////////////////////////////////////////////// Main Test Cases
//	
//    /**
//     * Checks if the program will compute the correct number of
//     * declarations and references using "Class" as the type
//     * to search for.
//     */
//    @Test
//    public void test_class_declaration() {
//    	int total = new Main("path name", "java.lang.Class");
//    	assertEquals(expected, total);
//    }
//    
//	/**
//     * Checks if the program will compute the correct number of
//     * declarations and references using "Enumerator" as the type
//     * to search for. 
//     */
//    @Test
//    public void test_Enum_declaration() {
//    	int total = new Main("path name", "java.lang.Enumerator");
//    	assertEquals(expected, total);
//    }
//    
//    /**
//     * Checks if the program will compute the correct number of
//     * declarations and references using "Interface" as the type 
//     * to search for.
//     */
//    @Test
//    public void test_Interface_Declaration() {
//    	int total = new Main("path name", "java.lang.Interface");
//    	assertEquals(expected, total);
//    }
//    
//    /**
//     * Checks if the program will compute the correct number of
//     * declarations and references using "Annotation" as the type
//     * to search for.
//     */
//    @Test
//    public void test_Annotation_Declaration() {
//    	int total = new Main("path name", "java.lang.Annotation");
//    	assertEquals(expected, total);
//    }
//    
//    /**
//     * Checks if the program will throw InvalidArgumentException
//     * for an invalid path but a valid declaration type
//     */
//    @Test(expected = IllegalArgumentException.class)
//    public void test_Invalid_Path_Valid_Dec() {
//    	int total = new Main("path name", "java.lang.Class");
//    }
//    
//    /**
//     * Checks if the program will throw InvalidArgumentException 
//     * for an invalid declaration type but a valid path
//     */
//    @Test(expected = IllegalArgumentException.class)
//    public void test_Invalid_Dec_Valid_Path() {
//    	int total = new Main("path name", "java.lang.Class");
//    }
//    
//    /**
//     * Checks if the program will throw InvalidArgumentException
//     * when both the path and declaration type are invalid
//     */
//    @Test(expected = IllegalArgumentException.class)
//    public void test_Ivalid_Path_and_Dec() {
//    	int total = new Main("path name", "java.lang.Class");
//    }
//    
//	/**
//     * Checks if the program will return 0 when the directory has
//     * no declarations or references of "Enumerator" as the type
//     * to search for.
//     */
//    @Test
//    public void test_Enum_declaration_With_None() {
//    	int total = new Main("path name", "java.lang.Enumerator");
//    	assertEquals( 0, total);
//    }
//    
//    /**
//     * Checks if the program will return 0 when the directory has
//     * no declarations or references of "Interface" as the type
//     * to search for.
//     */
//    @Test
//    public void test_Interface_Declaration_With_None() {
//    	int total = new Main("path name", "java.lang.Interface");
//    	assertEquals( 0, total);
//    }
//    
//    /**
//     * Checks if the program will return 0 when the directory has
//     * no declarations or references of "Annotation" as the type
//     * to search for.
//     */
//    @Test
//    public void test_Annotation_Declaration_With_None() {
//    	int total = new Main("path name", "java.lang.Annotation");
//    	assertEquals( 0, total);
//    }
			
///////////////////////////////////////////////////////////////////// MyParser Test cases
			
	/**
	 * Tests if the method ParseFilesInDir within MyParser works as
	 * intended with a valid path and type. No errors. 		
	 */
			
	@Test
	public void test_ParseFilesInDir_Correct() {
		MyParser myParser = new MyParser("java.lang.Class",BASEDIR);
		myParser.ParseFilesInDir();
	}
	
	/**
	 * Tests if the method ParseFilesInDir within MyParser generates 
	 * an error with an invalid path name
	 */
			
	@Test (expected = IOException)
	public void test_ParseFilesInDir_Invalid_Path() {
		MyParser myParser = new MyParser("java.lang.Class", " ");
		myParser.ParseFilesInDir();
	}
	
	/**
	 * Tests if the method ParseFilesInDir within MyParser throws
	 * an exception when both arguments are invalid.
	 */
			
	@Test (expected = IOException)
	public void test_ParseFilesInDir_Invalid_Path_and_Type() {
		MyParser myParser = new MyParser(" ", " ");
		myParser.ParseFilesInDir();
	}
	
	/**
	 * Tests if the method readFilesToString within MyParser works
	 * as intended with a valid path and type.
	 */
			
	@Test
	public void test_readFileToString_Valid_Path() {
		MyParser myParser = new MyParser("java.lang.Class", BASEDIR);
		myParser.readFileToString(myParser.dirPath);
	}
	
	/**
	 * Tests if the method readFilesToString within MyParser works
	 * as intended with a valid path and type.
	 */
			
	@Test (expected = IOException)
	public void test_readFileToString_Invalid_Path() {
		MyParser myParser = new MyParser("java.lang.Class", BASEDIR);
		myParser.readFileToString(myParser.dirPath);
	}
}

