import java.awt.Desktop;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class launch_msword {

	private JFrame frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					launch_msword window = new launch_msword();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public launch_msword() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("JAVA WITH APACHE POI");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		final JTextArea textArea = new JTextArea();
		textArea.setBounds(110, 32, 204, 82);
		frame.getContentPane().add(textArea);
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			try{
				File file = new File("A:\\Document.docx");
				FileOutputStream fos1 = new FileOutputStream(file.getAbsolutePath());
				Desktop desktop = Desktop.getDesktop();
				XWPFDocument document1 = new XWPFDocument();
				XWPFParagraph paragraph1 = document1.createParagraph();
				XWPFRun run1 = paragraph1.createRun();
				run1.setText(textArea.getText());
				run1.setBold(true);
				run1.setFontSize(16);
				document1.write(fos1);
				fos1.close();
				
				System.out.println(file.getAbsolutePath()+ " Created Successfully!");
				desktop.open(file); 
			}	              
		       
		    catch(Exception ex) {
		    	ex.printStackTrace();
			    JOptionPane.showMessageDialog(null,"Error Opening File","WARNING", JOptionPane.ERROR_MESSAGE);
		    }
			}
		});
		btnSubmit.setBounds(170, 150, 89, 23);
		frame.getContentPane().add(btnSubmit);
	}
}
