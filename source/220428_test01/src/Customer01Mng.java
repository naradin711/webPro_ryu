import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Customer01Mng extends JFrame implements ActionListener {
	private Container contenPane;
	private JPanel  jpup, jpdown;
	private JTextField txtPhone, txtName, txtPoint;
	private JButton  btnJoin, btnPhoneSearch, btnPrint, btnExit;
	private JTextArea jta;
	private JScrollPane scrollPane;
	private Customer01dao dao = Customer01dao.getInstance();
	private ArrayList<Customer01dto> dtos;
	
	public Customer01Mng(String title)  {
		super(title);
		contenPane = getContentPane(); 
	 	contenPane.setLayout(new FlowLayout()); 
	 	jpup = new JPanel(new GridLayout(3,2));
	 	jpdown = new JPanel(new FlowLayout());
	 	txtPhone = new JTextField(12);
	 	txtName  = new JTextField(12);
	 	txtPoint = new JTextField(12);
	 	btnJoin			= new JButton("����");
	 	btnPhoneSearch	= new JButton("����ȸ");
	 	btnPrint		= new JButton("���"); 
	 	btnExit 		= new JButton("����");
	 	jta = new JTextArea(15, 30);
		scrollPane = new JScrollPane(jta);
		jpup.add(new JLabel("����ȣ",(int) CENTER_ALIGNMENT));
		jpup.add(txtPhone);
		jpup.add(new JLabel("�� ��",(int) CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(new JLabel("����Ʈ",(int) CENTER_ALIGNMENT));
		jpup.add(txtPoint);
		jpdown.add(btnJoin);
		jpdown.add(btnPhoneSearch);
		jpdown.add(btnPrint);
		jpdown.add(btnExit);
		contenPane.add(jpup);
		contenPane.add(jpdown);
		contenPane.add(scrollPane);
		setSize(new Dimension(400, 450));
		setLocation(200, 150);
		setVisible(true);
		btnJoin.addActionListener(this);
		btnPhoneSearch.addActionListener(this);
		btnPrint.addActionListener(this);
		btnExit.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnJoin) { // ȸ������
		String pno, cname;
		try {
			pno = txtPhone.getText().trim();
			cname = txtName.getText().trim();
			if(cname.length()<2) {
				txtName.setText("");
				jta.setText("�ùٸ� �̸��� �Է��Ͻÿ� ");
				return;
			}
			int result = dao.joinIn(pno, cname);
				if(result == Customer01dao.SUCCESS) {
					jta.setText("ȸ�� ������ �Ϸ�Ǿ����ϴ� \n����Ʈ 5000���� �⺻���� �帳�ϴ�!");
				}else {
					jta.setText("01 ��ȿ�� �Է°��� �ƴմϴ�.");
				}
			} catch (Exception e2) {
				txtPhone.setText("");
				jta.setText("02 ��ȿ�� ���� �Է��� �ֽñ� �ٶ��ϴ�. ");
				}
			
		}else if (e.getSource() == btnPhoneSearch) { // ��ȭ��ȣ�� ã��
				String pno;
				pno = txtPhone.getText().trim();
				if(pno.length()==0) {
					txtName.setText("");
					txtPoint.setText("");
					jta.setText("�ùٸ� ��ȣ�� �Է� �� �˻��Ͻÿ�. ");
					return;
				}
				ArrayList<Customer01dto> dtos = dao.pnoSearch(pno); 
					if (dtos.size()==0) { // ���� ȸ���� ��ȭ��ȣ�� �Է�������
						txtName.setText("");
						txtPhone.setText("");
						txtPoint.setText("");
						jta.setText("�ش��ϴ� ��ȣ�� �� ������ �������� �ʽ��ϴ�.");
					}else if (dtos.size()==1) { // ã�� ��ȣ�� ȸ���� 1���� ��
						txtPhone.setText(dtos.get(0).getPno());
						txtName.setText(dtos.get(0).getCname());
						txtPoint.setText(String.valueOf(dtos.get(0).getCpoint()));
						jta.setText("\t"+ (dtos.get(0).getPno()) +" ��ȣ ȸ���� �˻� �Ϸ�  ");
					}else { // �ش��ϴ� ��ȣ�� ȸ���� 2�� �̻� �϶�
						jta.setText("��ȭ��ȣ\t�̸�\t����Ʈ\n");
						jta.append("------------------------------------------------------------------------\n");
						for(Customer01dto cd : dtos) {
							jta.append(cd.toString() +"\n");
						}
					}
		}else if (e.getSource() == btnPrint) { // ȸ�� ��ü ���
			txtPhone.setText("");
			txtName.setText("");
			txtPoint.setText("");
			ArrayList<Customer01dto> dtos = dao.getCustomers();
			if(dtos.size()!=0) {
				jta.setText("��ȭ��ȣ\t�̸�\t����Ʈ\n");
				jta.append("------------------------------------------------------------------------\n");
				for(Customer01dto cd : dtos) {
					jta.append(cd.toString() +"\n");
				}
			}else {
				jta.setText("��ȿ���� ���� �Է°��Դϴ�.");
			}
		}
		
		if(e.getSource() == btnExit) { // ����
			setVisible(false); //���� �Ⱥ���
			dispose(); //������ ����
			System.exit(0);// â ����	
		}
	}
	
	public static void main(String[] args) {
		new Customer01Mng("ȸ������");

	}

	

}
