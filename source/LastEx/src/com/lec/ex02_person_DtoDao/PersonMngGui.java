package com.lec.ex02_person_DtoDao;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;

public class PersonMngGui extends JFrame implements Action{
	private Container contenPane;
	private JPanel  jpup, jpbtn;
	private JTextField txtName, txtKor, txtEng, txtMat;
	private Vector<String> jnames;
	private JComboBox<String> comJob;
	private JButton btnInput, btnSearch, btnOutput, btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane;
	private PersonDao dao = PersonDao.getInstance();
	private ArrayList<PersonDto> person;
	public PersonMngGui(String title){
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane();
		contenPane.setLayout(new FlowLayout()); // 1���� �Ʒ��� ���ʴ��
		jpup = new JPanel(new GridLayout(5,2));// Panel�� �⺻ ���̾ƿ��� FlowLayout ���⼭�� GridLayout 5�� 2��
		jpbtn = new JPanel(new FlowLayout());
		txtName = new JTextField(20);
		jnames = dao.jnamelist();
		comJob = new JComboBox<String>(jnames);
		txtKor = new JTextField(20);
		txtEng = new JTextField(20);
		txtMat = new JTextField(20);
		ImageIcon icon1 = new ImageIcon("icon01/join.png");
		btnInput = new JButton("�Է�",icon1);
		ImageIcon icon2 = new ImageIcon("icon01/search.png");
		btnSearch = new JButton("������ȸ",icon2);
		ImageIcon icon3 = new ImageIcon("icon01/output.png");
		btnOutput = new JButton("��ü���",icon3);
		ImageIcon icon4 = new ImageIcon("icon01/exit.png");
		btnExit = new JButton("����",icon4);
		btnInput.setPreferredSize(new Dimension(150, 50));
		btnSearch.setPreferredSize(new Dimension(150, 50));
		btnOutput.setPreferredSize(new Dimension(150, 50));
		btnExit.setPreferredSize(new Dimension(150, 50));
		txtPool = new JTextArea(10, 60);
		scrollPane = new JScrollPane(txtPool);
		//������ ������Ʈ ȭ�� �߰�
		jpup.add(new JLabel("�̸�", (int) CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(comJob);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(txtKor);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(txtEng);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(txtMat);
		jpbtn.add(btnInput);
		jpbtn.add(btnSearch);
		jpbtn.add(btnOutput);
		jpbtn.add(btnExit);
		contenPane.add(jpup);
		contenPane.add(jpbtn);
		contenPane.add(scrollPane);
		setSize(new Dimension(700, 450));
		setLocation(200, 150);
		setVisible(true);
		btnInput.addActionListener(this);
		btnSearch.addActionListener(this);
		btnOutput.addActionListener(this);
		btnExit.addActionListener(this);
	}

	public PersonMngGui() {
		this("");
	}
	@Override
	public void actionPerformed(ActionEvent e) { // �̺�Ʈ ���� �߰�
		// btninput ��ư ������ �׼�
		if(e.getSource() == btnInput) { // txtName, comJob, txtKor, txtEng, txtMat
			String pname = txtName.getText();
			String jname = comJob.getSelectedItem().toString();
			String korStr = txtKor.getText();
			String engStr = txtEng.getText();
			String matStr = txtMat.getText();
			if(pname.equals("") || jname.equals("") || korStr.equals("")|| engStr.equals("") || matStr.equals("")) {
				txtPool.setText("��� ������ �Է��ϼž� �մϴ�.");
			return;
			}
			int kor = Integer.parseInt(korStr);
			int eng = Integer.parseInt(engStr);
			int mat = Integer.parseInt(matStr);
			PersonDto newPerson = new PersonDto(pname, jname, kor, eng, mat);
			int result = dao.insertPerson(newPerson);
				if(result == PersonDao.SUCCESS) {
				txtPool.setText(pname+"�� �Է¼���");
				txtName.setText("");
				comJob.setSelectedIndex(0); // �޺��ڽ��� 0��°�� ����
				comJob.setSelectedItem(""); // �޺��ڽ��� �������μ���
				txtKor.setText("");
				txtEng.setText("");
				txtMat.setText("");
				}
		} else if(e.getSource() == btnSearch) {  // btnSearch ��ư ������ �׼� // comJob�� ���õ� ������ȸ ����� txtPool
			String jname = comJob.getSelectedItem().toString();
			if(jname.equals("")) {
				txtPool.setText("���� ���� �� ���� ��ȸ �ϼ���");
				return;
			}		
			person = dao.selectJname(jname);		
			if (person.size()!=0) {
				txtPool.setText("���\t�̸�\t����\t����\t����\t����\t ����\n");
				for(PersonDto dto : person) {
					txtPool.append(dto.toString()+"\n");
				}
			}else {
				txtPool.setText("��ȿ�� �Է°��� �ƴմϴ�.");
			}
			
		} else if(e.getSource() == btnOutput) {
			person = dao.selectAll();
			if (person.size()!=0) {
				txtPool.setText("���\t�̸�\t����\t����\t����\t����\t ����\n");
				for(PersonDto dto : person) {
					txtPool.append(dto.toString()+"\n");
				}
			}else {
				txtPool.setText("��ȿ�� �Է°��� �ƴմϴ�.");
			}
			
		}else if(e.getSource() == btnExit) {
			setVisible(false); //���� �Ⱥ���
			dispose(); //������ ����
			System.exit(0);// â ����			
		}
		
	}
 public static void main(String[] args) {
	new PersonMngGui("������ ���� ����");
 	}

@Override
public Object getValue(String key) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void putValue(String key, Object value) {
	// TODO Auto-generated method stub
	
}

}





