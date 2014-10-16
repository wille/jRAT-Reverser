package su.jrat.reverser;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Frame extends JFrame {

	private JPanel contentPane;

	public Frame() {
		setTitle("jRAT Reverser + Content viewer");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Frame.class.getResource("/icons/drill--pencil.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		PanelReverser panelReverser = new PanelReverser();
		contentPane.add(panelReverser);
		getContentPane().add(panelReverser);
	}

}
