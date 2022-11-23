import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
public class WortJpanel_test extends JFrame{

    public void panel() {
        JFrame frame = new JFrame(); //JFrame Creation
             
        frame.setTitle("Add Image"); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setBounds(100, 200, 350, 300); 
        Container c = frame.getContentPane(); 
        frame.setLayout(new BorderLayout());
        JLabel label = new JLabel(); 
        label.setIcon(new ImageIcon("test.jpg")); 
        Dimension size = label.getPreferredSize(); 
        label.setBounds(100, 200, size.width, size.height); 
        c.setLayout(getLayout());
        c.add(label, BorderLayout.CENTER); //Adds objects to the container
        
        JLabel j1 = new JLabel("Was wird hier angezeigt?");
        c.add(j1, BorderLayout.NORTH);
        JTextField k = new JTextField();
        JLabel j2 = new JLabel();
        JPanel h = new JPanel();
        j2.add(k);
        ((JComponent) c).setBorder(BorderFactory.createDashedBorder(new Color(255, 0, 0)));
        j2.add(new JLabel("Tetst"), BorderLayout.NORTH);
        c.add(j2,BorderLayout.SOUTH);

        JButton t = new JButton("submit");
        t.setSize(10, 10);
        frame.add(t, BorderLayout.EAST);

        frame.setVisible(true); // Exhibit the frame  
    }

    public static void main(String[] args) throws IOException{
        saveImage("https://images.t3n.de/news/wp-content/uploads/2016/12/java-logo-hero.jpeg?class=structuredData-large", "test.jpg");
        WortJpanel x = new WortJpanel();
        x.panel();

    }

    public static void saveImage(String imageUrl, String destinationFile) throws IOException {
        URL url = new URL(imageUrl);
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(destinationFile);
    
        byte[] b = new byte[2048];
        int length;
    
        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }
    
        is.close();
        os.close();
    }

}

