package observer.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

class MyButtonListener implements ActionListener {
	JTextArea jTextArea;

	public void actionPerformed(ActionEvent e) {
		jTextArea.setText("Button Event!");
	}
	public void setjTextArea(JTextArea jTextArea) {
		this.jTextArea = jTextArea;
	}
}

public class ButtonTest {
	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		JButton jButton = new JButton("Button");
		JTextArea jTextArea = new JTextArea("TestArea");
		MyButtonListener myButtonListener = new MyButtonListener();
		myButtonListener.setjTextArea(jTextArea);
		jButton.addActionListener(myButtonListener);
		
		jFrame.setLayout(new FlowLayout());
		jFrame.add(jTextArea);
		jFrame.add(jButton);
		jFrame.setSize(300, 200);
		jFrame.setVisible(true);
	}
}
