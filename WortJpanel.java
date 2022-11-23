import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
public class WortJpanel extends JFrame{

    public void panel() {
        JFrame frame = new JFrame(); //JFrame Creation
             
        frame.setTitle("Add Image"); //Add the title to frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Terminate program on close button
        frame.setBounds(100, 200, 350, 300); //Sets the position of the frame
        Container c = frame.getContentPane(); //Gets the content layer
        frame.setLayout(new BorderLayout());
        JLabel label = new JLabel(); //JLabel Creation
        label.setIcon(new ImageIcon("test.jpg")); //Sets the image to be displayed as an icon
        Dimension size = label.getPreferredSize(); //Gets the size of the image
        label.setBounds(100, 200, size.width, size.height); //Sets the location of the image
        c.add(label); //Adds objects to the container
        
        Container c1 = new Container();
        c1.setLayout(new BorderLayout());

        JLabel j1 = new JLabel("Was wird hier angezeigt?");
        c.add(j1, BorderLayout.NORTH);
        JTextField k = new JTextField();
        JLabel j2 = new JLabel();
        frame.add(k,BorderLayout.SOUTH);

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

