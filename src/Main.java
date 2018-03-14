import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
                BufferedReader br = null;
		FileReader fr = null;
		
                fr = new FileReader("TESTCASE1.txt");
			br = new BufferedReader(fr);

			String sCurrentLine;
                        Regex regex = new Regex();

			while ((sCurrentLine = br.readLine()) != null) {
				String line = sCurrentLine;
//                                regex.Compile(line);
                                System.err.println(line);
                        }

		
                
                
                
//		Regex regex = new Regex();
//		//regex.Compile("/dsdma");
//		String s = "class myclass{"
//				+ "/*my comment*/"
//				+";*/"
//				+ "};";
//		
////		s= s.replaceAll(" ","");
////		regex.Compile(s);
//		regex.Compile("System.out.println");

		
	}

}
