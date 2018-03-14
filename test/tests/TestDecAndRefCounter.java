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

import src.Assign3.InvalidArgumentsException;
import src.Assign3.Main;
import src.Assign3.MyParser;
import src.Assign3.VisitDeclarations;
import src.Assign3.VisitReferences;

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
//    	int total = new Main(BASEDIR, "java.lang.Class");
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
//    	int total = new Main(BASEDIR, "java.lang.Enumerator");
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
//    	int total = new Main(BASEDIR, "java.lang.Interface");
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
//    	int total = new Main(BASEDIR, "java.lang.Annotation");
//    	assertEquals(expected, total);
//    }
//	
//    /**
//     * Checks if the program will compute the correct number of
//     * declarations and references using "String" as the type
//     * to search for.
//     */
//    @Test
//    public void test_Annotation_Declaration() {
//        int total = new Main(BASEDIR, "java.lang.String");
//  	  assertEquals(expected, total);
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
//	  /**
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
//			
///////////////////////////////////////////////////////////////////// MyParser Test cases
	
    /**
     * Checks if the program will throw InvalidArgumentException
     * when provided with empty string inputs
     * @throws InvalidArgumentsException 
     */
    @Test(expected = InvalidArgumentsException.class)
    public void test_Invalid_Path_Invalid_Dec_Main() throws InvalidArgumentsException {
    	String[] args = {"", ""};
    	Main.main(args);
    }
    
    @Test(expected = InvalidArgumentsException.class)
    public void test_Invalid_Path_Valid_Dec_Main() throws InvalidArgumentsException {
    	String[] args = {"asjn", "String"};
    	Main.main(args);
    }
	
    @Test(expected = InvalidArgumentsException.class)
    public void test_Valid_Path_Invalid_Dec_Main() throws InvalidArgumentsException {
    	String[] args = {BASEDIR, ""};
    	Main.main(args);
    }
    
	/**
	 * Tests if the method ParseFilesInDir within MyParser works as
	 * intended with a valid path and type. No errors. 	
	 * 	
	 * @throws IOException 
	 */	
	@Test
	public void test_ParseFilesInDir_Correct() throws IOException {
		MyParser myParser = new MyParser(BASEDIR, "java.lang.Class");
		myParser.ParseFilesInDir();
	}
	
	
	/**
	 * Tests if the method ParseFilesInDir within MyParser generates 
	 * an error with an invalid path name.
	 * 
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
	 * 
	 * @throws IOException
	 */	
	@Test (expected = IOException.class)
	public void test_ParseFilesInDir_Invalid_Path_and_Type() throws IOException {
		MyParser myParser = new MyParser("aslfjnkfba", "kahdbfka");
		myParser.ParseFilesInDir();
	} 
	
	@Test (expected = IOException.class)
	public void test_ParseFilesInDir_Valid_Path_Invalid_File_and_Type() throws IOException {
		MyParser myParser = new MyParser(new java.io.File( "." ).getCanonicalPath(), "kahdbfka");
		myParser.ParseFilesInDir();
	} 
	 
	
	/**
	 * Tests if the method readFilesToString within MyParser works
	 * as intended with a valid path and type.
	 * 
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
	 * 
	 * @throws IOException 
	 */	
	@Test (expected = IOException.class)
	public void test_readFileToString_Invalid_Path() throws IOException {
		MyParser myParser = new MyParser(BASEDIR, "java.lang.Class");
		myParser.readFileToString(myParser.dirPath);
	}
	
	/**
	 * This test checks to see if MyParser parse correctly computes 1 declaration to
	 * a class when a string is given with 1 class declared.
	 */
	@Test
	public void test_MyParser_Parse_With_ClassDeclaration() {
		MyParser myParser = new MyParser(BASEDIR, "ATestClass");
		myParser.parse("public class ATestClass { public String mystring;}");
		assertEquals(1, myParser.getDeclarations());
	}
	
	/**
	 * This test checks to see if MyParser parse correctly computes 0 declarations to
	 * a class when a string is given without any classes declared.
	 */
	@Test
	public void test_MyParser_Parse_Without_ClassDeclaration() {
		MyParser myParser = new MyParser("", "ATest");
		myParser.parse("ATest{}");
		assertEquals(0, myParser.getDeclarations());
	}
	
	/**
	 * This test checks to see if MyParser parse correctly computes 0 declarations to
	 * an enumeration when a string is given without any enumerations declared.
	 */
	@Test
	public void test_MyParser_Parse_Without_InterfaceDeclaration() {
		MyParser myParser = new MyParser("", "ATestInterface");
		myParser.parse("public class ATestClass{}");
		assertEquals(0, myParser.getDeclarations());
	}
	
	/**
	 * This test checks to see if MyParser parse correctly computes 1 declaration to
	 * an interface when a string is given with 1 interface declared.
	 */
	@Test
	public void test_MyParser_Parse_With_InterfaceDeclaration() {
		MyParser myParser = new MyParser("", "ATestInterface");
		myParser.parse("public interface ATestInterface{}");
		assertEquals(1, myParser.getDeclarations());
	}
	
	/**
	 * This test checks to see if MyParser parse correctly computes 1 declaration to
	 * an enumeration when a string is given with 1 enumeration declared.
	 */
	@Test
	public void test_MyParser_Parse_Without_EnumDeclaration() {
		MyParser myParser = new MyParser("", "ATestEnum");
		myParser.parse("public class ATestClass{}");
		assertEquals(0, myParser.getDeclarations());
	}
	
	/**
	 * This test checks to see if MyParser parse correctly computes 1 declaration to
	 * an enumeration when a string is given with 1 enumeration declared.
	 */
	@Test
	public void test_MyParser_Parse_With_EnumDeclaration() {
		MyParser myParser = new MyParser("", "ATestEnum");
		myParser.parse("public enum ATestEnum{A,B}");
		assertEquals(1, myParser.getDeclarations());
	}
	
	@Test
	public void test_MyParser_Parse_With_EnumReference() {
		MyParser myParser = new MyParser("", "ATestEnum");
		myParser.parse("class A{ enum ATestEnum{A,B} ATestEnum myEnum = ATestEnum.A;}");
		assertEquals(1, myParser.getReferences());
	}
	
	/**
	 * This test checks to see if MyParser parse correctly computes 0 references to
	 * an annotation when a string is given without any annotation references.
	 */
	@Test
	public void test_MyParser_Parse_Without_AnnotationReference() {
		MyParser myParser = new MyParser("", "ATestAnnot");
		myParser.parse("public class ATestClass{@}");
		assertEquals(0, myParser.getDeclarations());
	}
	
	/**
	 * This test checks to see if MyParser parse correctly computes 1 reference to
	 * an annotation when a string is given with 1 annotation reference.
	 */
	@Test
	public void test_MyParser_Parse_With_AnnotationReference() {
		MyParser myParser = new MyParser("", "Override");
		myParser.parse("public class ATestClass{@Override public void myfunc() {}}");
		assertEquals(1, myParser.getReferences());
	}
	
	/**
	 * This test checks to see if MyParser parse correctly computes 1 reference to
	 * a normal annotation when a string is given with 1 normal annotation reference.
	 */
	@Test
	public void test_MyParser_Parse_With_Normal_AnnotationReference() {
		MyParser myParser = new MyParser("", "Test");
		myParser.parse("public class ATestClass{@Test (expected = IOException.class) public void myfunc() {}}");
		assertEquals(1, myParser.getReferences());
	}
	
	@Test
	public void test_MyParser_Parse_With_AnnotationDeclaration() {
		MyParser myParser = new MyParser("", "IA");
		myParser.parse("@interface IA { String myStr();}");
		assertEquals(1, myParser.getReferences());
	}
	
	/**
	 * This test creates an AST with 1 class declaration and checks to see if VisitClassDec 
	 * correctly computes 1 declaration.
	 */
	@Test
	public void test_VisitClasDec_With_A_Declaration() {
		ASTParser parser = ASTParser.newParser(AST.JLS9);					
		parser.setSource("public class MyClass{}".toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		ASTNode node =  parser.createAST(null);	
		VisitDeclarations a = new VisitDeclarations("MyClass");								
		node.accept(a);														
		assertEquals(1, a.getNum());
	} 
	
	/**
	 * This test creates an empty AST and checks to see if VisitClassDec
	 * can correctly compute 0 declarations of class. 
	 */
	@Test
	public void test_VisitClasDec_Without_A_Declaration() {
		ASTParser parser = ASTParser.newParser(AST.JLS9);					
		parser.setSource(" ".toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		ASTNode node =  parser.createAST(null);	
		VisitDeclarations a = new VisitDeclarations("MyClass");								
		node.accept(a);														
		assertEquals(0, a.getNum());
	} 
	
	@Test
	public void test_VisitInterfaceDec_With_A_Declaration() {
		ASTParser parser = ASTParser.newParser(AST.JLS9);					
		parser.setSource("interface MyInterface {} ".toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		ASTNode node =  parser.createAST(null);	
		VisitDeclarations a = new VisitDeclarations("MyInterface");								
		node.accept(a);														
		assertEquals(1, a.getNum());
	} 
	
	@Test
	public void test_VisitInterfaceDec_Without_A_Declaration() {
		ASTParser parser = ASTParser.newParser(AST.JLS9);					
		parser.setSource("M{} ".toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		ASTNode node =  parser.createAST(null);	
		VisitDeclarations a = new VisitDeclarations("MyInterface ");								
		node.accept(a);														
		assertEquals(0, a.getNum());
	} 
	
	@Test
	public void test_VisitInterfaceRef_With_A_Reference() {
		ASTParser parser = ASTParser.newParser(AST.JLS9);					
		parser.setSource("public class M implements MyInterface {} ".toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		ASTNode node =  parser.createAST(null);	
		VisitReferences a = new VisitReferences("MyInterface");								
		node.accept(a);														
		assertEquals(1, a.getNum());
	} 
	
	@Test
	public void test_VisitInterfaceRef_Without_A_Reference() {
		ASTParser parser = ASTParser.newParser(AST.JLS9);					
		parser.setSource("public class M implements M {} ".toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		ASTNode node =  parser.createAST(null);	
		VisitReferences a = new VisitReferences("MyInterface");								
		node.accept(a);														
		assertEquals(0, a.getNum());
	} 
	
	@Test
	public void test_VisitAnnotationDec_With_A_Declaration() {
		ASTParser parser = ASTParser.newParser(AST.JLS9);					
		parser.setSource(("@interface Preamble {\n" + 
				"   String author();\n" ).toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		ASTNode node =  parser.createAST(null);	
		VisitDeclarations a = new VisitDeclarations("Preamble");	
		if (node.getNodeType() == ASTNode.ANNOTATION_TYPE_DECLARATION)
			System.out.println("Annot type dec pass");
		node.accept(a);				
		assertEquals(1, a.getNum());
	} 
	
	@Test
	public void test_VisitAnnotationDec_Without_A_Declaration() {
		ASTParser parser = ASTParser.newParser(AST.JLS9);					
		parser.setSource("@interface M {}".toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		ASTNode node =  parser.createAST(null);	
		VisitDeclarations a = new VisitDeclarations("MyAnnot");								
		node.accept(a);														
		assertEquals(0, a.getNum());
	} 
	
	@Test
	public void test_VisitMarkerAnnotationRef_With_A_Reference() {
		ASTParser parser = ASTParser.newParser(AST.JLS9);					
		parser.setSource("class C { @Test \n public method myMethod(); }".toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		ASTNode node =  parser.createAST(null);	
		VisitReferences a = new VisitReferences("Test");								
		node.accept(a);														
		assertEquals(1, a.getNum());
	} 
	
	@Test
	public void test_VisitMarkerAnnotationRef_Without_A_Reference() {
		ASTParser parser = ASTParser.newParser(AST.JLS9);					
		parser.setSource("public method myMethod(); ".toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		ASTNode node =  parser.createAST(null);	
		VisitReferences a = new VisitReferences("Test");								
		node.accept(a);														
		assertEquals(0, a.getNum());
	} 
	
	@Test
	public void test_VisitNormalAnnotationRef_With_A_Reference() {
		ASTParser parser = ASTParser.newParser(AST.JLS9);					
		parser.setSource("class C {@Test (expected = IOException.class) \n public method myMethod(); } ".toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		ASTNode node =  parser.createAST(null);	
		VisitReferences a = new VisitReferences("Test");								
		node.accept(a);														
		assertEquals(1, a.getNum());
	} 
	
	@Test
	public void test_VisitNormalAnnotationRef_Without_A_Reference() {
		ASTParser parser = ASTParser.newParser(AST.JLS9);					
		parser.setSource("@Testy (expected = TastyException.class) \n public method myMethod(); ".toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		ASTNode node =  parser.createAST(null);	
		VisitReferences a = new VisitReferences("Test");								
		node.accept(a);														
		assertEquals(0, a.getNum());
	} 
	
	@Test
	public void test_VisitEnumDec_With_A_Declaration() {
		ASTParser parser = ASTParser.newParser(AST.JLS9);					
		parser.setSource("public enum MyEnum implements MyType { enum EnumConst {A,B,C} \n public void myMethod() {} }".toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		ASTNode node =  parser.createAST(null);	
		VisitDeclarations a = new VisitDeclarations("MyEnum");	
		if (node.getNodeType() == ASTNode.ENUM_DECLARATION)
			System.out.println("enum dec pass");
		node.accept(a);														
		assertEquals(1, a.getNum());
	} 
	
	@Test
	public void test_VisitEnumDec_Without_A_Declaration() {
		ASTParser parser = ASTParser.newParser(AST.JLS9);					
		parser.setSource("public class MyC implements MyType { enum EnumConst {A,B,C} \n public void myMethod() {} }".toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		ASTNode node =  parser.createAST(null);	
		VisitDeclarations a = new VisitDeclarations("MyEnum");								
		node.accept(a);														
		assertEquals(0, a.getNum());
	} 
	
	@Test
	public void test_VisitEnumConstantDec_With_A_Declaration() {
		ASTParser parser = ASTParser.newParser(AST.JLS9);					
		parser.setSource("public class MyC { enum EnumConst {A,B,C} \n public void myMethod() {}; }".toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		ASTNode node =  parser.createAST(null);	
		VisitDeclarations a = new VisitDeclarations("EnumConst");	
		if (node.getNodeType() == ASTNode.ENUM_CONSTANT_DECLARATION)
			System.out.println("enum const dec pass");
		node.accept(a);														
		assertEquals(1, a.getNum());
	} 
	
	@Test
	public void test_VisitEnumConstantDec_Without_A_Declaration() {
		ASTParser parser = ASTParser.newParser(AST.JLS9);					
		parser.setSource("public class MyC implements MyType { enum E {} \n public void myMethod() {} }".toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		ASTNode node =  parser.createAST(null);	
		VisitDeclarations a = new VisitDeclarations("EnumConst");								
		node.accept(a);														
		assertEquals(0, a.getNum());
	} 
	
	@Test
	public void test_VisitTypeVariableRef_With_A_Reference() {
		ASTParser parser = ASTParser.newParser(AST.JLS9);					
		parser.setSource("public class MyC { Const c = Const.var; }".toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		ASTNode node =  parser.createAST(null);	
		VisitReferences a = new VisitReferences("Const");								
		node.accept(a);														
		assertEquals(1, a.getNum());
	} 
	
	@Test
	public void test_VisitTypeVariableRef_Without_A_Reference() {
		ASTParser parser = ASTParser.newParser(AST.JLS9);					
		parser.setSource("public class MyC { }".toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		ASTNode node =  parser.createAST(null);	
		VisitReferences a = new VisitReferences("Const");								
		node.accept(a);														
		assertEquals(0, a.getNum());
	} 
	
	@Test
	public void test_VisitTypeLiteralRef_With_A_Reference() {
		ASTParser parser = ASTParser.newParser(AST.JLS9);					
		parser.setSource("public class C { Const c = Const.class; }".toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		ASTNode node =  parser.createAST(null);	
		VisitReferences a = new VisitReferences("Const");								
		node.accept(a);														
		assertEquals(2, a.getNum());
	} 
	
	@Test
	public void test_VisitTypeLiteralRef_Without_A_Reference() {
		ASTParser parser = ASTParser.newParser(AST.JLS9);					
		parser.setSource("public class C { MyC c = MyC.class; }".toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		ASTNode node =  parser.createAST(null);	
		VisitReferences a = new VisitReferences("Cls");								
		node.accept(a);														
		assertEquals(0, a.getNum());
	} 
	
	@Test
	public void test_VisitTypeExtensionRef_With_A_Reference() {
		ASTParser parser = ASTParser.newParser(AST.JLS9);					
		parser.setSource("public class MyC extends C { }".toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		ASTNode node =  parser.createAST(null);	
		VisitReferences a = new VisitReferences("C");								
		node.accept(a);														
		assertEquals(1, a.getNum());
	} 
	
	@Test
	public void test_VisitTypeParameterRef2_With_A_Reference() {
		ASTParser parser = ASTParser.newParser(AST.JLS9);					
		parser.setSource("class MyC { public <U extends V> myMethod() {} }".toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		ASTNode node =  parser.createAST(null);	
		VisitReferences a = new VisitReferences("U");								
		node.accept(a);														
		assertEquals(1, a.getNum());
	} 
	
	@Test
	public void test_VisitTypeParameterRef2_Without_A_Reference() {
		ASTParser parser = ASTParser.newParser(AST.JLS9);					
		parser.setSource("class MyC { public <U extends V> myMethod() {} }".toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		ASTNode node =  parser.createAST(null);	
		VisitReferences a = new VisitReferences("X");								
		node.accept(a);														
		assertEquals(0, a.getNum());
	} 
	
	@Test
	public void test_VisitTypeExtensionRef_Without_A_Reference() {
		ASTParser parser = ASTParser.newParser(AST.JLS9);					
		parser.setSource("public class MyC extends C { }".toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		ASTNode node =  parser.createAST(null);	
		VisitReferences a = new VisitReferences("Clash");								
		node.accept(a);														
		assertEquals(0, a.getNum());
	} 
	
	@Test
	public void test_VisitEnumRef_With_A_Reference() {
		ASTParser parser = ASTParser.newParser(AST.JLS9);					
		parser.setSource("public class MyC { enum MyE{A} MyE e = MyE.A;}".toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		ASTNode node =  parser.createAST(null);	
		VisitReferences a = new VisitReferences("MyE");								
		node.accept(a);														
		assertEquals(1, a.getNum());
	}
	
	@Test
	public void test_VisitEnumRef_Without_A_Reference() {
		ASTParser parser = ASTParser.newParser(AST.JLS9);					
		parser.setSource("public class MyC { enum MyE{A} enum Ex {X} MyE e = MyE.A;}".toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		ASTNode node =  parser.createAST(null);	
		VisitReferences a = new VisitReferences("Ex");								
		node.accept(a);														
		assertEquals(0, a.getNum());
	}

	
	/**
	 * This test attempts to use the getTypeName method in main to see if it returns
	 * the correct output with a qualified name given.
	 */
	@Test
	public void test_Main_GetTypeName() {
		assertEquals("String", Main.getTypeName("java.lang.String"));
	}
	
	/**
	 * This test attempts to use the getTypeName method in main to see if it returns
	 * the correct output without a qualified name given.
	 */
	@Test
	public void test_Main_GetTypeName_NoDot() {
		assertEquals("Str", Main.getTypeName("Str"));
	}
	
}

