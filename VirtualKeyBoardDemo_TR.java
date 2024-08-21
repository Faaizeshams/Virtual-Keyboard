import java.util.*;
import javax.swing.text.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;

public class VirtualKeyBoardDemo_TR extends JPanel implements ActionListener {
    static final String st = "ABCDEFGHIJKLMNOPQRSTUVWXYZ01234567891@#$%^&*()<>?{},./; '[]~' +-=";
    JButton buttonList[];
    String buffer="";
    JTextField text;
    JButton backspace, spaceBar;
    public void key() {
        text = new JTextField(100);
        text.setActionCommand(""+ buffer);
        add(text);
        int n= st.length();
        buttonList = new JButton[n];
        for (int i=0; i < n; i++) {
            buttonList[i] = new JButton("" + st.charAt(i));
            add(buttonList[i]);
            buttonList[i].addActionListener(this);
        }
        spaceBar = new JButton("Spacebar Key");
        add(spaceBar);
        spaceBar.addActionListener(this);
        backspace =new JButton("BackSpace Key");
        add(backspace);
        backspace.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        int n = st.length();
        if (e.getSource() == backspace) {
            buffer = buffer.substring(0,buffer.length()-1);
            text.setText("" + buffer);
        }
        else if (e.getSource() == spaceBar) {
            buffer += " ";
        }
        else{
            for (int i=0; i < n; i++){
                if (e.getSource() == buttonList[i]){
                    buffer += st.toUpperCase().charAt(i);
                    text.setText(""+ buffer);
                    break;
                }
            }
        }

    }

    public VirtualKeyBoardDemo_TR(){
        JPanel pane = new JPanel();
        add(pane);
    }
    public static void main(String s[]){
        JFrame frame = new JFrame("Virtual KeyBoard");
         VirtualKeyBoardDemo_TR keys =new VirtualKeyBoardDemo_TR();
         ImageIcon logo = null;
         java.net.URL imgURL =VirtualKeyBoardDemo_TR.class.getResource("logo_tr.png");
         if (imgURL != null) {
             logo=  new ImageIcon(imgURL);
             frame.setIconImage(logo.getImage());
         }
         else {
             JOptionPane.showMessageDialog(frame, "Icon image not found.");
         }
         frame.getContentPane().add(keys, "Center");
         keys.key();
         frame.setSize(500,100);
         frame.setVisible(true);

    }

}
