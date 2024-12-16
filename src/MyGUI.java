import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class MyGUI extends JFrame{

    MyGUI(){
        this.setTitle("GUI");
        this.setSize(420, 420); //Sets the size of  x dimension and y dimension the this.
        this.setVisible(true); //makes this visible.
        this.setResizable(false);//Prevent this from being resized.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Closes the program on exit.

        ImageIcon img = new ImageIcon("C:/Users/shaha/Desktop/JAVAsql/App/src/Icon.png"); //creates an image icon.
        this.setIconImage(img.getImage()); // changes icon  of this.
        this.getContentPane().setBackground(new Color(123, 50, 250));  //change background color.
        }
}
