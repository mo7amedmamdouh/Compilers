import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

	public ArrayList<Pair> pairs = new ArrayList<>();
	public ArrayList<Pattern>patterns = new ArrayList<>();
	public ArrayList<Token>token = new ArrayList<>();
	
	HashMap<String,String> Tokens = new HashMap<>();
	
	public Regex() {
		InitTokens();
	}
	
	
	public boolean Compile(String s) {
		Pattern pattern;
		
		for(int i=0;i<pairs.size();i++)
			{
			pattern= Pattern.compile(pairs.get(i).regex);
			patterns.add(pattern);
			}
		
		match(s);
		/*
		Matcher matcher = pattern.matcher(s);
		
		if(matcher.find()) {
			System.out.println("Found a match: " + matcher.group());
			System.out.println("Start position: " + matcher.start());
			System.out.println("End position: " + matcher.end());
		}
		else {
			System.out.println("3`lt ya 7omar");
			return false;
		}
		*/
		return true;
	}
	
	public boolean match(String s) {
		while(!s.isEmpty()) {
		    String handler = "";
			boolean check = false;
			for(int i = 0 ;i<patterns.size();i++) {
				Matcher matcher = patterns.get(i).matcher(s);
				
				if(matcher.find()) {
					check = true;
					//System.out.println(pairs.get(i).name+"--->" + matcher.group());
					/*System.out.println("Token: ");*/
					Token t = new Token(pairs.get(i).name ,matcher.group());
					token.add(t);
					s = matcher.replaceFirst("");
					break;
				}
/*				else if(check==false && matcher.find()==false && i+1 == patterns.size()) {
					System.out.println("Error ---> ");
					s = matcher.replaceFirst("");
					break;
				}
*/				else if ( i+1 == patterns.size() && s.isEmpty()==false&& check==false){
					handler=handler+s.charAt(0);
					s = s.substring(1, s.length());
					break;
				}
			}
			if(check==false) {
		//	System.out.println("Handler --->  "+handler);
			Token t = new Token("UnKnown Token",handler);
			token.add(t);
			}
		}
		
		printResult();
		return true;
	}
	
	public void printResult() {
		for (int i = 0 ; i <token.size();i++) {
			System.out.println("<"+token.get(i).type+"> : " +"-"+token.get(i).value+"-");
		}
		
	}
	
	private void InitTokens() {
		
		String EOL = "^(End of line)";
		pairs.add(new Pair("EOL",EOL));
		String PLUS ="^(\\+)";
		pairs.add(new Pair("PLUS",PLUS));
		String LEFT_CURLY_B="^(\\{)";
		pairs.add(new Pair("LEFT_CURLY_B",LEFT_CURLY_B));
		String RIGHT_CURLY_B="^(\\})";
		pairs.add(new Pair("RIGHT_CURLY_B",RIGHT_CURLY_B));
		String LEFT_SQUARE_B="^(\\[)";
		pairs.add(new Pair("LEFT_SQUARE_B",LEFT_SQUARE_B));
		String RIGHT_SQUARE_B="^(])";
		pairs.add(new Pair("RIGHT_SQUARE_B",RIGHT_SQUARE_B));
		String LEFT_ROUND_B ="^(\\()";
		pairs.add(new Pair("LEFT_ROUND_B",LEFT_ROUND_B));
		String RIGHT_ROUND_B ="^(\\))";
		pairs.add(new Pair("RIGHT_ROUND_B",RIGHT_ROUND_B));
		String COMMA="^(,)";
		pairs.add(new Pair("COMMA",COMMA));
		String SEMICOLON="^(;)";
		pairs.add(new Pair("SEMICOLON",SEMICOLON));
		String DOT ="^(\\.)";
		pairs.add(new Pair("DOT",DOT));
		String NOT ="^(!)";
		pairs.add(new Pair("NOT",NOT));
		String EQUAL ="^(=)";
		pairs.add(new Pair("EQUAL",EQUAL));
		String AND ="^(&&)";
		pairs.add(new Pair("AND",AND));
		String MINUS ="^(-)";
		pairs.add(new Pair("MINUS",MINUS));
		String MULTIPLY ="^(\\*)";
		pairs.add(new Pair("MULTIPLY",MULTIPLY));
		String LESSTHAN ="^(<)";
		pairs.add(new Pair("LESSTHAN",LESSTHAN));
		String GREATERTHAN ="^(>)";
		pairs.add(new Pair("GREATERTHAN",GREATERTHAN));

		String IF ="^(if)";
		pairs.add(new Pair("IF",IF));

		String INT ="^(int)";
		pairs.add(new Pair("INT",INT));

		String ELSE ="^(else)";
		pairs.add(new Pair("ELSE",ELSE));

		String MAIN ="^(main)";
		pairs.add(new Pair("MAIN",MAIN));

		String THIS ="^(this)";
		pairs.add(new Pair("THIS",THIS));

		String TRUE ="^(true)";
		pairs.add(new Pair("TRUE",TRUE));

		String VOID ="^(void)";
		pairs.add(new Pair("VOID",VOID));
		
		String CLASS ="^(class)";
		pairs.add(new Pair("CLASS",CLASS));
		
		String FALSE ="^(false)";
		pairs.add(new Pair("FALSE",FALSE));
		
		String WHILE ="^(while)";
		pairs.add(new Pair("WHILE",WHILE));
		
		String LENGTH  ="^(length)";
		pairs.add(new Pair("LENGTH",LENGTH));
		
		String PUBLIC ="^(public)";
		pairs.add(new Pair("PUBLIC",PUBLIC));
		
		String PRIVATE ="^(private)";
		pairs.add(new Pair("PRIVATE",PRIVATE));
		
		String PROTECTED ="^(protected)";
		pairs.add(new Pair("PROTECTED",PROTECTED));
		
		String RETURN ="^(return)";
		pairs.add(new Pair("RETURN",RETURN));
		
		String STATIC ="^(static)";
		pairs.add(new Pair("STATIC",STATIC));
		
		String NEW ="^(new)";
		pairs.add(new Pair("NEW",NEW));
		
		String STRING ="^(string)";
		pairs.add(new Pair("STRING",STRING));
		
		String FLOAT ="^(float)";
		pairs.add(new Pair("FLOAT",FLOAT));
		
		String CHARACTER ="^(character)";
		pairs.add(new Pair("CHARACTER",CHARACTER));
		
		String BOOLEAN ="^(boolean)";
		pairs.add(new Pair("BOOLEAN",BOOLEAN));
		
		String EXTENDS ="^(extends)";
		pairs.add(new Pair("EXTENDS",EXTENDS));
		
		String NULL ="^(null)";
		pairs.add(new Pair("NULL",NULL));
		
		String ABSTRACT ="^(abstract)";
		pairs.add(new Pair("ABSTRACT",ABSTRACT));
		
		String ASSERT ="^(assert)";
		pairs.add(new Pair("ASSERT",ASSERT));
		
		String BREAK ="^(break)";
		pairs.add(new Pair("BREAK",BREAK));
		
		String CONTINUE ="^(continue)";
		pairs.add(new Pair("CONTINUE",CONTINUE));
		
		String BYTE ="^(byte)";
		pairs.add(new Pair("BYTE",BYTE));
		
		String CASE ="^(case)";
		pairs.add(new Pair("CASE",CASE));
		
		String CATCH ="^(catch)";
		pairs.add(new Pair("CATCH",CATCH));
		
		String CONST ="^(const)";
		pairs.add(new Pair("CONST",CONST));
		
		String DEFAULT ="^(default)";
		pairs.add(new Pair("DEFAULT",DEFAULT));
		
		String DO="^(do)";
		pairs.add(new Pair("DO",DO));
		
		String DOUBLE ="^(double)";
		pairs.add(new Pair("DOUBLE",DOUBLE));
		
		String ENUM ="^(enum)";
		pairs.add(new Pair("ENUM",ENUM));
		
		String FINAL="^(final)";
		pairs.add(new Pair("FINAL",FINAL));
		
		String FOR ="^(for)";
		pairs.add(new Pair("FOR",FOR));
		
		String GOTO ="^(goto)";
		pairs.add(new Pair("GOTO",GOTO));
		
		String IMPLEMENTS ="^(implements)";
		pairs.add(new Pair("IMPLEMENTS",IMPLEMENTS));
		
		String IMPORT ="^(import)";
		pairs.add(new Pair("IMPORT",IMPORT));
		
		String INSTANCEOF ="^(instanceof)";
		pairs.add(new Pair("INSTANCEOF",INSTANCEOF));
		
		String INTERFACE ="^(interface)";
		pairs.add(new Pair("INTERFACE",INTERFACE));
		
		String SHORT ="^(short)";
		pairs.add(new Pair("SHORT",SHORT));
		
		String SUPER ="^(super)";
		pairs.add(new Pair("SUPER",SUPER));
		
		String SWITCH ="^(switch)";
		pairs.add(new Pair("SWITCH",SWITCH));
		
		String THROW ="^(throw)";
		pairs.add(new Pair("THROW",THROW));
		
		String TRY ="^(try)";
		pairs.add(new Pair("TRY",TRY));
		
		String SYSTEM_OUT_PRINTLN = "^(System\\.out\\.println)";
		pairs.add(new Pair("SYSTEM_OUT_PRINTLN",SYSTEM_OUT_PRINTLN));
		
		String INTEGRAL_LITERAL = "^[\\+|-]?\\d+";
		pairs.add(new Pair("INTEGRAL_LITERAL",INTEGRAL_LITERAL));
		
		String FLOAT_LITERAL = "^[\\+|-]?\\d+.\\d+";
		pairs.add(new Pair("FLOAT_LITERAL",FLOAT_LITERAL));
		
		String STRING_LITERAL ="^\"[\\w|\\s]*\"";
		pairs.add(new Pair("STRING_LITERAL",STRING_LITERAL));
		
		String ID = "^\\w[\\w|\\d]*";
		pairs.add(new Pair("ID",ID));
		
		String S_COMMENTS = "^(\\/\\/).*";
		pairs.add(new Pair("S_COMMENTS",S_COMMENTS));
		
		String M_COMMENTS = "^\\/\\*[\\s|\\w]*\\*\\/";
		pairs.add(new Pair("M_COMMENTS",M_COMMENTS));
		
		String A_CHAR = "^'[\\w|\\s]?'";
		pairs.add(new Pair("A_CHAR",A_CHAR));
		
	
	}
	
	// mlhash Ay lzma fe el 7yah :"D
	private void fill_hashMap() {
		Tokens.put("End of line", "EOL");
		Tokens.put("+","PLUS");
		Tokens.put("{", "LEFT_CURLY_B");
		Tokens.put("}", "RIGHT_CURLY_B");
		Tokens.put("[", "LEFT_SQUARE_B");
		Tokens.put("]", "RIGHT_SQUARE_B");
		Tokens.put("(", "LEFT_ROUND_B");
		Tokens.put(")", "RIGHT_ROUND_B");
		Tokens.put(",", "COMMA");
		Tokens.put(";", "SEMICOLON");
		Tokens.put(".", "DOT");
		Tokens.put("!", "NOT");
		Tokens.put("=", "EQUAL");
		Tokens.put("&&", "AND");
		Tokens.put("-", "MINUS");
		Tokens.put("*", "MULTIPLY");
		Tokens.put("<", "LESSTHAN");
		Tokens.put(">", "GREATERTHAN");
		Tokens.put("if", "IF");
		Tokens.put("int", "INT");
		Tokens.put("else", "ELSE");
		Tokens.put("main", "MAIN");
		Tokens.put("this", "THIS");
		Tokens.put("true", "TRUE");
		Tokens.put("void", "VOID");
		Tokens.put("class", "CLASS");
		Tokens.put("false", "FALSE");
		Tokens.put("while", "WHILE");
		Tokens.put("length", "LENGTH");
		Tokens.put("public", "PUBLIC");
		Tokens.put("private", "PRIVATE");
		Tokens.put("protected", "PROTECTED");
		Tokens.put("return", "RETURN");
		Tokens.put("static", "STATIC");
		Tokens.put("new", "NEW");
		Tokens.put("string", "STRING");
		Tokens.put("float", "FLOAT");
		Tokens.put("char", "CHARACTER");
		Tokens.put("boolean", "BOOLEAN");
		Tokens.put("extends", "EXTENDS");
		Tokens.put("null", "NULL");
		Tokens.put("abstract", "ABSTRACT");
		Tokens.put("assert", "ASSERT");
		Tokens.put("break", "BREAK");
		Tokens.put("continue", "CONTINUE");
		Tokens.put("byte", "BYTE");
		Tokens.put("case", "CASE");
		Tokens.put("catch", "CATCH");
		Tokens.put("const", "CONST");
		Tokens.put("default", "DEFAULT");
		Tokens.put("do", "DO");
		Tokens.put("double", "DOUBLE");
		Tokens.put("ENUM", "ENUM");
		Tokens.put("final", "FINAL");
		Tokens.put("finally", "FINALLY");
		Tokens.put("for", "FOR");
		Tokens.put("goto", "GOTO");
		Tokens.put("implements", "IMPLEMENTS");
		Tokens.put("import", "IMPORT");
		Tokens.put("instanceof", "INSTANCEOF");
		Tokens.put("interface", "INTERFACE");
		Tokens.put("short", "SHORT");
		Tokens.put("super", "SUPER");
		Tokens.put("throw", "THROW");
		Tokens.put("switch", "SWITCH");
		Tokens.put("try", "TRY");
		Tokens.put("System.out.println", "SYSTEM.OUT.PRINTLN");
		
		// edit
		Tokens.put("rkm_int", "INTEGRAL_LITERAL");
		Tokens.put("rkm_float", "FLOAT_LITERAL");
		Tokens.put("klma", "STRING_LITERAL");
		Tokens.put("idntifier", "ID");
		Tokens.put("//", "S_COMMENTS");
		Tokens.put("comment", "M_COMMENTS");
		Tokens.put("7rf", "A_CHAR");
		
	
		
		
		
		
	}
	
}
