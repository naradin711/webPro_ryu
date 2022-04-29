package com.lec.ex02_Swing;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
//3�� 2��¥�� �׸��� ���̾ƿ�
public class Ex03_GUI extends JFrame implements ActionListener {
    // ������Ʈ ��ü ���� ����. ArrayList ����, file io���� stream, db ���Ӱ��� ��ü ����
	private Container  contenPane; // �����̳� ���� ����
    private JPanel     jp;         // �̸�, ��ȭ, ���� ���� 6�� ������Ʈ�� gridLayout���� add
    private JTextField txtName, txtTel, txtAge;
    private ImageIcon  icon;
    private JButton    btnOut;
    private JTextArea  jTa;
    private JScrollPane scrollbar;
    private int        cnt; // ��� �Է��ߴ��� ����
    
    public Ex03_GUI(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE); //x Ű ������ �ڹ� ���â ����
		contenPane = getContentPane();
		jp         = new JPanel(new GridLayout(3,2)); // 3�� 2�� //jp.setLayout(new GridLayout(3,2)); // 3�� 2��
		txtName    = new JTextField();                // �̸��� �Է��� �ؽ�Ʈ �ʵ� ��ü ����
		txtTel     = new JTextField();                // ��ȭ��ȣ�� �Է��� �ؽ�Ʈ �ʵ� ��ü ����
		txtAge     = new JTextField();                // ���̸� �Է��� �ؽ�Ʈ �ʵ� ��ü ����
		icon       = new ImageIcon ("src/icon/output.png"); // ������ �������� �̹��� ��������
		btnOut     = new JButton ("���", icon);             // ������ ������ �־ ��ư �����ϱ�
		jTa        = new JTextArea (5,30);                  // text�� ����� �� �ʵ� ���� 5 , 30 
		scrollbar  = new JScrollPane(jTa);                  // JScrollPane�� ����Ͽ� ���� �ؽ�Ʈ �ʵ忡 ��ũ�ѹ� �Է�
		jp.add(new JLabel("��  ��", (int) CENTER_ALIGNMENT)); //�̸� �� ������ ��� ����
		jp.add(txtName);                                    // �̸��� �Է��� �ؽ�Ʈ �ʵ� ����
		jp.add(new JLabel("��  ȭ", (int) CENTER_ALIGNMENT)); //��ȭ �� ������ ��� ����
		jp.add(txtTel);                                     // ��ȭ��ȣ�� �Է��� �ؽ�Ʈ �ʵ� ����
		jp.add(new JLabel("��  ��", (int) CENTER_ALIGNMENT)); //���� �� ������ ��� ����
		jp.add(txtAge);                                     // ���̸� �Է��� �ؽ�Ʈ �ʵ� ����
		contenPane.add(jp, BorderLayout.NORTH);        // grid�� jp �г��� ���ʿ� ��ġ
		contenPane.add(btnOut, BorderLayout.CENTER);   // ��¹�ư�� ���Ϳ� ��ġ
		contenPane.add(scrollbar, BorderLayout.SOUTH); // ��ũ�ѹٸ� ���ʿ� ��ġ
		setVisible(true);                              // �ڹ�â�� ����ȭ ��Ű��
//		setSize(new Dimension(400,300));
//		setLocation(200, 100);
		setBounds(200, 100, 400, 300); // �ڹ� â�� ȣ�� �� ��(��ġ, ��ġ, ����, ����) �ȼ� ����
		btnOut.addActionListener(this); // ��ư ������ �׼Ǹ����� ��ġ. �ؿ��� �׼��̺�Ʈ�� Ʈ���Ű� ��.
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { // override�� �׼������� �Լ�.
		if(e.getSource()== btnOut) {
			// txtName, txtTel, txtAge�� �Է��� ���� jTa�� ���
			String name = txtName.getText().trim();  // txtName���� name ���ڿ� ����. ���� ���� ����
			String tel = txtTel.getText().trim();    // txtTel���� tel ���ڿ� ����. ���� ���� ����
			if(name.equals("") || tel.equals("")) {
				System.out.println("�̸��� ��ȭ��ȣ�� �ʼ� �Է� �����Դϴ�.");
				return;
			}
			if(tel.indexOf("-")==tel.lastIndexOf("-") ||  // 111-1111-2222, 000-00000
					tel.indexOf("-")<2 ||                 // ���ڸ� �� 012 ���� �տ� ���� 01- 0- ���� ��.
					tel.lastIndexOf("-")>10) {            // ������ - �� 10���� ũ�� ex)000-0000000-0000 
				System.out.println("��ȭ��ȣ ������ �ٽ� �ѹ� Ȯ���� �ּ���.");
				return;
			}
			// ����üũ
			int age = 0; // ���� ���� �ʱ�ȭ
			try {
				age = Integer.parseInt(txtAge.getText());	//txtAge�� �Է��� �������� ���ڿ�ȭ ��Ŵ
				if(age <0 || age>150) {
					System.out.println("��ȿ���� ���� ���̸� �Է��ϼ̽��ϴ�.");
					age = 0; // ��ȿ���� ���� ���̴� age ���� 0���� ���.
				}
			}catch(Exception e1) {
				System.out.println("��ȿ���� ���� ���̸� �Է��ϼ̽��ϴ�.");
			}
			System.out.println(++cnt +"�� �Էµ�.");
			if(cnt==1) {
				jTa.setText("�̸�\t��ȭ\t\t����\n");
			}
			jTa.append(name+"\t"+tel+"\t\t"+age+"\n");
			txtName.setText("");
			txtTel.setText("");
			txtAge.setText("");
		}

	}

	public static void main(String[] args) {
		new Ex03_GUI("GUI ������ ����");

	}

	
}





















