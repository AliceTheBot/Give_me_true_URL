package 得到真正的网址;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import java.util.*;

public class GiveMeURL extends JFrame implements DocumentListener{
	JTextArea text1,text2;
	GiveMeURL(){
		init();
		setLayout(new FlowLayout());
		setBounds(500,300,400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void init() {
		text1=new JTextArea(2,30);
		text2=new JTextArea(2,30);
		add(new JScrollPane(text1));
		add(new JScrollPane(text2));
		text1.setLineWrap(true);
		text2.setLineWrap(true);
		text2.setEditable(false);
		(text1.getDocument()).addDocumentListener(this);
	}
	public void changedUpdate(DocumentEvent e) {
		String str=text1.getText();
		String regex="[^a-zA-Z0-9_\\u002e\\u002f\\u003a]";
		//String regex="/^(https?:\\/\\/)?([\\da-z\\.-]+)\\.([a-z\\.]{2,6})([\\/\\w \\.-]*)*\\/?$/";
		String result=str.replaceAll(regex, "");
		text2.setText(null);
		text2.append(result);
	}
	public void removeUpdate(DocumentEvent e) {
		changedUpdate(e);
	}
	public void insertUpdate(DocumentEvent e) {
		changedUpdate(e);
}
}
