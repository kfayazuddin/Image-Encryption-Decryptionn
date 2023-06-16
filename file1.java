import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.plaf.ColorChooserUI;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
public class file1 {
    public static void operate(int key)
    {
      JFileChooser fileChooser = new JFileChooser();
      fileChooser.showOpenDialog(null);
      File file  = fileChooser.getSelectedFile();
      // to read the data
      // file input stream reader
      //file FileInputStream
     try {
        FileInputStream fis = new FileInputStream(file);

      byte []data = new byte[fis.available()];
        fis.read(data);
        int i =0;
        for(byte b:data){
           System.out.println(b);
           data[i]=(byte)(b^key);// encryption
           i++;
        }
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(data);
        fos.close();
        fis.close();
        JOptionPane.showMessageDialog(null,"DONE");

     } catch (Exception e) {
        //TODO: handle exception
        e.printStackTrace();
     }

    }
    public static void main(String[] args) {
      JFrame f =  new JFrame();
      f.setTitle("Secure Image");
      f.setSize(400, 400); // arrange the size of display
      f.setLocationRelativeTo(null); // to set the position of display at center
      f.setResizable(false); // to fix the size of GUI
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ImageIcon image = new ImageIcon("logo.jpg"); // it will set new seleccted logo
      f.setIconImage(image.getImage());

      Font font = new Font("Roboto",Font.BOLD,25);
      
      f.setLayout(new FlowLayout());
      // creating text field
      JLabel l1 = new JLabel("Key Number:");
       f.add(l1);
       JTextField textField = new JTextField(10);
       f.add(textField);
       textField.setFont(font);
       textField.setForeground(new Color(0XFFFFFF));
       textField.setCaretColor(Color.white);
       textField.setBackground(Color.black);
       textField.setText("Enter Key Here");

       //SET THE BUTTON
      JButton button = new JButton();
      button.setText("Select Image");
      button.setFont(font);

       // Lambda func
      button.addActionListener(e->{
        System.out.println("button clicked");
         String text = textField.getText();
         int temp = Integer.parseInt(text);// parseInt function converting text into integer
         operate(temp);
     });
       //label 
       f.add(button);
       f.setVisible(true);
    }
}
