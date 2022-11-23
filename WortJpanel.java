import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
public class WortJpanel extends JFrame{
    public void panel() {
        JFrame frame = new JFrame();      
        frame.setTitle("Add Image"); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setBounds(100, 200, 350, 300); 
        JLabel label = new JLabel(); 
        label.setIcon(new ImageIcon("CodeSpeedy.jpg")); 
        Dimension size = label.getPreferredSize(); 
        label.setBounds(50, 30, size.width, size.height); 
    }

    public static void main(String[] args) {
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

