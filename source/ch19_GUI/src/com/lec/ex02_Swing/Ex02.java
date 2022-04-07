package com.lec.ex02_Swing;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.*;
public class Ex02 extends JFrame implements ActionListener {
    // �ʿ��� ������Ʈ ���� �߰�.
	private JPanel            jpanel; // �����̳� ���� ����
	private Container     contenPane; // �����̳� ��� �� ����
	private ImageIcon           icon; // ��ư�� �� ������
	
	private JButton             jBtn; // ��ư ����.
	private JTextField    jtxtField ; 
	private Vector<String>     items; // �ĺ��ڽ��� �� item ����Ʈ
	private String []          item = {"A", "B", "C", "D"};
    private JComboBox<String> jCombo;
    private JCheckBox         jCheck;
    private JLabel           jlBlank;
    private JButton         jbtnExit; // java ���� �����ų ��ư 
	// ������ : �����̳� ���ͼ� ���̾ƿ� ���� - ������Ʈ ������ add -> setVisible, set Size (ȭ�鱸��) ->�̺�Ʈ �߰� -> ���� �Լ����� ���
    public Ex02() {
    	setDefaultCloseOperation(EXIT_ON_CLOSE); //x Ŭ�� �� ����!
    	contenPane = getContentPane(); // ������ �����̳ʸ� ���� �� �۾�.
    	contenPane.setLayout(new FlowLayout()); // ���̾ƿ� ����
    	icon      = new ImageIcon("src/icon/write.gif"); // ������ �׸� ��� ����!
    	jBtn      = new JButton("Button", icon); // �̹��� ��ü!
    	jtxtField = new JTextField(20);
      //jCombo    = new JComboBox<String>(item); // �޺��ڽ� item ����Ʈ �߰� ��� 1. string �迭 (����)
    	items     = new Vector<String>();
    	items.add("A"); items.add("B"); items.add("C"); items.add("D");
    	jCombo    = new JComboBox<String>(items); //��������� �޺��ڽ� �ϼ� 2. Vector �̿� (������)
    	jCheck    = new JCheckBox("Check");
    	jlBlank   = new JLabel("");
    	jbtnExit  = new JButton("EXIT");
      //������Ʈ add�ϱ� - ������Ʈ�� ������ ����(pdf����)
    	contenPane.add(new JLabel("Label"));
    	contenPane.add(jBtn);
    	contenPane.add(jtxtField);
    	contenPane.add(jCombo);
    	contenPane.add(jCheck);
    	contenPane.add(jlBlank); // �ߺ��ؼ� �����ص� ������ �ʰ� �ٷ� �������
    	contenPane.add(jbtnExit);
    	// �����̳� ���ͼ� ������Ʈ �����ϰ� ������!
    	jBtn.setPreferredSize     (new Dimension(200,50));
    	jtxtField.setPreferredSize(new Dimension(300,50));
        jCombo.setPreferredSize   (new Dimension(100,50));
        jCheck.setPreferredSize   (new Dimension(100,50));
        jlBlank.setPreferredSize  (new Dimension(200,50));
        jbtnExit.setPreferredSize (new Dimension(100,50));
        jBtn.    addActionListener(this);
        jCombo.  addActionListener(this);
        jCheck.  addActionListener(this);
        jbtnExit.addActionListener(this);
        setVisible(true); // �ش� �г��� ����ȭ�Ѵ�
        pack(); // ������Ʈ���� �����ϴ� �ּ����� ������!
        setLocation(100, 50);
    	
    } 
    
    @Override
	public void actionPerformed(ActionEvent e) { //�̺�Ʈ ����
    	 if      (e.getSource()==jBtn)     {
    		String temp = jtxtField.getText().trim().toUpperCase();
    		if (temp.equals("")) {
    			System.out.println("����!"); // jtxtField�� �� ��Ʈ���̰ų� �����̽��� �Է��� ���
    			return;
    		}
    		jCombo.addItem(temp); // �ؽ�Ʈ�ʵ忡 �ִ� ���ڿ��� �빮�ڷ� �ٲ㼭 �޺��ڽ��� �߰���Ŵ
    		jlBlank.setText(jtxtField.getText().trim()); //��ũ���� �ؽ�Ʈ���� �Է³��� �״��
    		jtxtField.setText("");
    	}else if (e.getSource()==jCombo)   {
    		String temp = jCombo.getSelectedItem().toString(); // �޺��ڽ� ���õ� �׸�
    		int    no   = jCombo.getSelectedIndex();
    		jlBlank.setText(no+"��°  "+temp+"����");
    		jCombo.setSelectedItem("A"); // A�� ���õǵ��� jCombo.setSelectedIndex(0)
    	}else if (e.getSource()==jCheck)   {
    		if(jCheck.isSelected()) { // üũ�ڽ��� üũ �� ����
    		    jlBlank.setText(jCheck.getText());
    		}else {                   // üũ�ڽ� ��üũ��.
    			jlBlank.setText("");
    		}
    		
    	}else if (e.getSource()==jbtnExit) { // exit��ư Ŭ���� �� ����
	    	  setVisible(false); // �Ⱥ��̰�
	  		  dispose();         // �ڿ�����
	  		  System.exit(0);    // ��������
	    }
	}
    public static void main(String[] args) {
		new Ex02(); //����
	}   

}




















