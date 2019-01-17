import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
 
public class AccessFile {
	private String pathway;
	public AccessFile() {
		JFileChooser jfc = new JFileChooser();
		jfc.setCurrentDirectory(new File("C:\\Users\\Justin Quong"));
		int allowed = jfc.showOpenDialog(new JFrame());
		
		File file = null;
		if(allowed == JFileChooser.APPROVE_OPTION) {
			file = jfc.getSelectedFile();
			System.out.println("Selected file: " + file.getAbsolutePath());
		}
		this.pathway = file.getAbsolutePath();
		
	}	
	
	public static void main(String[] args) throws IOException {
		AccessFile file = new AccessFile();
		String path = file.pathway;
        Files.lines(Paths.get(path), StandardCharsets.UTF_8).forEach(System.out::println);
	
	}
}
