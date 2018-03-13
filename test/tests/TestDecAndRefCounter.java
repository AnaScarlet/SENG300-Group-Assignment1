/**
 * @authors			    Anastasiya Lazarenko, Matthew Buhler, Zachary Hull
 * @team                1
 * @version             Group Assignment 1
 * @since               March 14th, 2018
 *
 * Course:              SENG300, University of Calgary
 * Instructor:          Prof. Robert Walker
 * 
 * This is the JUnit test suit designed to test the Main and MyParser classes as of now.
 */


package test.tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.junit.Test;

import src.Assign3.Main;
import src.Assign3.MyParser;
import src.Assign3.VisitClassDec;

public class TestDecAndRefCounter {
	
	private static String BASEDIR = "/home/anastasiya/git/SENG300-Group-Assignment1/test/TestDirWithoutAllTypes";

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
	 * @throws IOException 
	 */
			
	@Test
	public void test_ParseFilesInDir_Correct() throws IOException {
		MyParser myParser = new MyParser(BASEDIR, "java.lang.Class");
		myParser.ParseFilesInDir();
	}
	
	/**
	 * Tests if the method ParseFilesInDir within MyParser generates 
	 * an error with an invalid path name
	 * @throws IOException 
	 */
			
	@Test (expected = IOException.class)
	public void test_ParseFilesInDir_Invalid_Path() throws IOException {
		MyParser myParser = new MyParser("lejjfbklas", "java.lang.Class");
		myParser.ParseFilesInDir();
	} 
	
	/**
	 * Tests if the method ParseFilesInDir within MyParser throws
	 * an exception when both arguments are invalid.
	 * @throws IOException
	 */
			
	@Test (expected = IOException.class)
	public void test_ParseFilesInDir_Invalid_Path_and_Type() throws IOException {
		MyParser myParser = new MyParser("aslfjnkfba", "kahdbfka");
		myParser.ParseFilesInDir();
	} 
	 
	/**
	 * Tests if the method readFilesToString within MyParser works
	 * as intended with a valid path and type.
	 * @throws IOException 
	 */
			
	@Test
	public void test_readFileToString_Valid_Path() throws IOException {
		MyParser myParser;
		myParser = new MyParser(BASEDIR, "java.lang.Class");
		myParser.readFileToString(myParser.dirPath + "/ATestClass.java");
	}  
	
	/**
	 * Tests if the method readFilesToString within MyParser works
	 * as intended with a valid and type.
	 * @throws IOException 
	 */
			
	@Test (expected = IOException.class)
	public void test_readFileToString_Invalid_Path() throws IOException {
		MyParser myParser = new MyParser(BASEDIR, "java.lang.Class");
		myParser.readFileToString(myParser.dirPath);
	}
	
	@Test
	public void testMyParserParseYesClassDeclaration() {
		MyParser myParser = new MyParser(BASEDIR, "java.lang.class");
		myParser.parse("public class ATestClass{}");
		assertEquals(1, myParser.getDeclarations());
	}
	
	@Test
	public void testMyParserParseNoClassDeclaration() {
		MyParser myParser = new MyParser("", "java.lang.class");
		myParser.parse("ATest{}");
		assertEquals(0, myParser.getDeclarations());
	}
	
	@Test
	public void testMyParserParseNoInterfaceDeclaration() {
		MyParser myParser = new MyParser("", "java.lang.interface");
		myParser.parse("public class ATestClass{}");
		assertEquals(0, myParser.getDeclarations());
	}
	
	@Test
	public void testMyParserParseYesInterfaceDeclaration() {
		MyParser myParser = new MyParser("", "java.lang.interface");
		myParser.parse("public interface ATestInterface{}");
		assertEquals(1, myParser.getDeclarations());
	}
	
	@Test
	public void testMyParserParseNoEnumDeclaration() {
		MyParser myParser = new MyParser("", "java.lang.enum");
		myParser.parse("public class ATestClass{}");
		assertEquals(0, myParser.getDeclarations());
	}
	
	@Test
	public void testMyParserParseYesEnumDeclaration() {
		MyParser myParser = new MyParser("", "java.lang.enum");
		myParser.parse("public enum ATestEnum{A,B}");
		assertEquals(1, myParser.getDeclarations());
	}
	
	@Test
	public void testMyParserParseNoAnnotationReference() {
		MyParser myParser = new MyParser("", "java.lang.annotation");
		myParser.parse("public class ATestClass{}");
		assertEquals(0, myParser.getDeclarations());
	}
	
	@Test
	public void testMyParserParseYesAnnotationReference() {
		MyParser myParser = new MyParser("", "java.lang.annotation");
		myParser.parse("public class ATestClass{@Test}");
		assertEquals(1, myParser.getDeclarations());
	}
	
	@Test
	public void testVisitClasDecYesDec() {
		ASTParser parser = ASTParser.newParser(AST.JLS9);					
		parser.setSource("class MyClass{}".toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		ASTNode node =  parser.createAST(null);	
		VisitClassDec a = new VisitClassDec();								
		node.accept(a);														
		assertEquals(1, a.getNum());
	} 
	
	@Test
	public void testVisitClasDecNoDec() {
		ASTParser parser = ASTParser.newParser(AST.JLS9);					
		parser.setSource(" ".toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		ASTNode node =  parser.createAST(null);	
		VisitClassDec a = new VisitClassDec();								
		node.accept(a);														
		assertEquals(0, a.getNum());
	} 
	
	@Test
	public void testMainGetTypeName() {
		assertEquals("String", Main.getTypeName("java.lang.String"));
	}
	
	@Test
	public void testMainGetTypeNameNoDot() {
		assertEquals("Str", Main.getTypeName("Str"));
	}
	
}

