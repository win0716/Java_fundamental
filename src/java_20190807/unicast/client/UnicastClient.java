package java_20190807.unicast.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UnicastClient implements ActionListener {
	private String id;
	private String ip;
	private int port;
	private JFrame jframe;
	private JTextArea jta;
	private JTextField jtf;
	private JButton jbtn;

	public UnicastClient(String id, String ip, int port) {
		this.id = id;
		this.ip = ip;
		this.port = port;

		jframe = new JFrame("Unicst Chatting");
		/************************ 중앙 시작 *************************/
		jta = new JTextArea("", 20, 50);
		jta.setEditable(false);

		JScrollPane jsp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jta.setBackground(new Color(255,240,245));
		/********************** 중앙 끝 **************************/

		/********************** 하단 시작 ************************/
		jtf = new JTextField(30);
		jbtn = new JButton("SEND");
		jbtn.setBackground(Color.yellow);

		JPanel j1 = new JPanel();
		j1.setLayout(new BorderLayout());
		j1.add(jtf, BorderLayout.CENTER);
		j1.add(jbtn, BorderLayout.EAST);
		/************************ 하단 끝 *************************/

		/*********** 상단 시작 *********************/
		JPanel j2 = new JPanel();
		JLabel jl1 = new JLabel("User ID : [" + id + "]");
		j2.setBackground(Color.ORANGE);
		
		JLabel jl2 = new JLabel("Server IP : " + ip);
		j2.setLayout(new BorderLayout());
		j2.add(jl1, BorderLayout.CENTER);
		j2.add(jl2, BorderLayout.EAST);
		/***************** 상단 끝 *********************/

		jframe.add(jsp, BorderLayout.CENTER);
		jframe.add(j1, BorderLayout.SOUTH);
		jframe.add(j2, BorderLayout.NORTH);

		jframe.pack();
		jframe.setResizable(true);
		jframe.setVisible(true);

		// X(종료)을 눌렀을 때 프로그램 종료하기 위한 코드

		jframe.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

			public void windowOpened(WindowEvent e) {
				jtf.requestFocus();
			}

		});

		// 이벤트 등록
		jbtn.addActionListener(this);
		jtf.addActionListener(this);

	}

	public static void main(String[] args) {

		JFrame.setDefaultLookAndFeelDecorated(true);
		new UnicastClient("shy1011", "127.0.0.1", 5000);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == jtf) {
			// 텍스트 필드가 가져오기
			String message = jtf.getText();
			if (message.trim().length() == 0) {
				JOptionPane.showMessageDialog(jframe, "야....", "Warning", JOptionPane.ERROR_MESSAGE);

			} else {

				// 텍스트 에어리어에 추가하기
				jta.append(id + " : " + message + "\n");
				// 텍스트 필드에 입력된 값없애기
				jtf.setText("");
			}
			jtf.setText("");
		} else if (obj == jbtn) {
			// 텍스트 필드가 가져오기
			String message = jtf.getText();
			if (message.trim().length() == 0) {
				JOptionPane.showMessageDialog(jframe, "야....", "Warning", JOptionPane.ERROR_MESSAGE);
				jtf.setText("");

			} else {
				// 텍스트 에어리어에 추가하기
				jta.append(id + " : " + message + "\n");

				// 텍스트 필드에 입력 된 값 없애기
			}
			jtf.setText("");
			jtf.requestFocus();

		}

	}

}
