package src.Assign3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;

public class MyParser {


	private String typeDec = "init";
	private String dirPath = "init";
	private int	declarations = 0;
	private int	references = 0;



	public MyParser(String path, String typeDec) {
		this.typeDec = typeDec.toLowerCase();
		this.dirPath = path;
	}


	public int getDeclarations(){

		return declarations;
	}

	public int getReferences(){

		return references;
	}


	public void parse(String filePath) {

		ASTParser parser = ASTParser.newParser(AST.JLS8);
		parser.setSource(filePath.toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);


		final ASTNode node =  parser.createAST(null);


		switch (typeDec) {

			case "class":

				classDeclarations(node);
				classReferences(node);
				break;

			case "enum":
				enumDeclarations(node);
				enumReferences(node);

				break;

			case "interface":
				interfaceDeclarations(node);
				interfaceReferences(node);

				break;

			case "annotation":

				break;
		}
	}

	public void classDeclarations(ASTNode node){
		VisitClassDec a = new VisitClassDec();
		node.accept(a);
		declarations = a.getNum();

	}

	public void classReferences(ASTNode node){
		VisitClassInstCreation a = new VisitClassInstCreation();
		node.accept(a);
		references = a.getNum();
	}

	public void interfaceDeclarations(ASTNode node){
		VisitInterfDec a = new VisitInterfDec ();
		node.accept(a);
		declarations = a.getNum();
	}

	public void interfaceReferences(ASTNode node){
		//todo add interface references

		//VisitClassDec a = new VisitClassDec();
		//node.accept(a);
		//references = a.getNumInterface();
	}

	public void enumReferences(ASTNode node){
		//todo add enum references

	}

	public void enumDeclarations(ASTNode node){
		VisitEnumDec a = new VisitEnumDec ();
		node.accept(a);
		declarations = a.getNum();
	}


	public void annotationReferences(ASTNode node){

	}

	public void annotationDeclarations(ASTNode node){
		VisitAnnotDec a = new VisitAnnotDec ();
		node.accept(a);
		declarations = a.getNum();

	}



	public void ParseFilesInDir() throws IOException{

		// Takes the string path, converts that to an abstract pathname
		// then breaks that pathname into each file.
		File root = new File(dirPath);
		File[] files = root.listFiles( );
		String filePath = "";

		// Loop through each file
		 for (File f : files ) {
			 filePath = f.getAbsolutePath();
			 if(f.isFile()){
				 // switch case here?

				 parse(readFileToString(filePath));
			 }
		 }
	}

	//read file content into a string
	public String readFileToString(String filePath) throws IOException {

		StringBuilder fileData = new StringBuilder();
		BufferedReader reader = new BufferedReader(new FileReader(filePath));

		char[] buf = new char[10];
		int numRead = 0;
		while ((numRead = reader.read(buf)) != -1) {
			String readData = String.valueOf(buf, 0, numRead);
			fileData.append(readData);
			buf = new char[1024];
		}

		reader.close();
		return  fileData.toString();
	}

}
