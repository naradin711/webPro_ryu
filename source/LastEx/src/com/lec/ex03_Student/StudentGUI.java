package com.lec.ex03_Student;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StudentGUI extends JFrame implements ActionListener{
	private Container contenPane;
	private JPanel  jpup, jpbtn;
	private JTextField txtSno, txtSname, txtScore ;
	private Vector<String> mnames;
	private JComboBox<String> comMname;
	private JButton btnSnoSearch, btnSnameSearch, btnMnameSearch, btnInput, btnUpdate, btnStudentOut, btnExpelOut, btnExpel , btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane;
	private StudentDao dao = StudentDao.getInstance();
	private ArrayList<StudentDto> students;
	
	public StudentGUI(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane();
		contenPane.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(4,3));
		jpbtn = new JPanel(new FlowLayout());
		txtSno = new JTextField(10);
		txtSname = new JTextField(10);
		mnames = dao.mnamelist();
		comMname = new JComboBox<String>(mnames);
		txtScore = new JTextField(10);
		btnSnoSearch = new JButton("�й��˻�");
		btnSnameSearch = new JButton("�̸��˻�");
		btnMnameSearch = new JButton("�����˻�");
		btnInput = new JButton("�Է�");
		btnUpdate = new JButton("�л�����");
		btnStudentOut = new JButton("�л����");
		btnExpelOut = new JButton("���������");
		btnExpel = new JButton("����ó��");
		btnExit = new JButton("����");
		txtPool = new JTextArea(10, 50);
		scrollPane = new JScrollPane(txtPool);
		jpup.add(new JLabel("�й�",(int) CENTER_ALIGNMENT));
		jpup.add(txtSno);
		jpup.add(btnSnoSearch);
		jpup.add(new JLabel("�̸�",(int) CENTER_ALIGNMENT));
		jpup.add(txtSname);
		jpup.add(btnSnameSearch);
		jpup.add(new JLabel("����",(int) CENTER_ALIGNMENT));
		jpup.add(comMname);
		jpup.add(btnMnameSearch);
		jpup.add(new JLabel("����",(int) CENTER_ALIGNMENT));
		jpup.add(txtScore);
		jpbtn.add(btnInput);
		jpbtn.add(btnUpdate);
		jpbtn.add(btnStudentOut);
		jpbtn.add(btnExpelOut);
		jpbtn.add(btnExpel);
		jpbtn.add(btnExit);
		contenPane.add(jpup);
		contenPane.add(jpbtn);
		contenPane.add(scrollPane);
		setSize(new Dimension(625, 400));
		setLocation(200, 150);
		setVisible(true);
		btnSnoSearch.addActionListener(this);
		btnSnameSearch.addActionListener(this);
		btnMnameSearch.addActionListener(this);
		btnInput.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnStudentOut.addActionListener(this);
		btnExpelOut.addActionListener(this);
		btnExpel.addActionListener(this);
		btnExit.addActionListener(this);
	}
	public StudentGUI() {
		this("");
	}
	public static void main(String[] args) {
		new StudentGUI("�л� ����");
	 }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnSnoSearch) { // �й� �˻�
			String snoStr = txtSno.getText().trim();			
			if(snoStr.length()==0) {
				txtPool.setText("�й��� �Է� �� �˻��Ͻÿ�. ");
				return;
			}
			int sno = Integer.parseInt(snoStr); 
			StudentDto dto = dao.snogetStudent(sno); 
			if(dto!=null) {
				txtSname.setText(dto.getSname());
				comMname.setSelectedItem(dto.getMname());
				txtScore.setText(String.valueOf(dto.getScore()));
				txtPool.setText(sno+"�� �˻� �Ϸ�");
			}else {
				txtPool.setText("�ش� �й��� ��ȿ���� �ʽ��ϴ�.");
			}
		}else if(e.getSource() == btnSnameSearch) { // �̸� �˻�
			String sname = txtSname.getText().trim();
			if(sname.length()==0) {
				txtPool.setText("�̸��� �Է� �� �˻��Ͻÿ�. ");
				txtSno.setText("");
				txtScore.setText("");
				comMname.setSelectedItem("");
				return;
			} students = dao.snamegetStudent(sname);
			if(students.size()==0) {
				txtSno.setText("");
				txtScore.setText("");
				comMname.setSelectedItem("");
				txtPool.setText("ã���ô� �̸��� �л��� �����ϴ�. ");
			}else if (students.size()==1) {
				txtSno.setText(String.valueOf(students.get(0).getSno()));
				comMname.setSelectedItem(students.get(0).getMname());
				txtSname.setText(students.get(0).getSname());
				txtScore.setText(String.valueOf(students.get(0).getScore()));
				txtPool.setText(sname +" �˻� �Ϸ� ");
			}else { // ���� �̸��� ��������				
				txtPool.setText("\t�й�\t�̸�\t����\t����\n"); // �׸� ����
				txtPool.append("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");//���뼱
				for(StudentDto dto : students) { // ���� �׸���� ����ϴ� for ����
					txtPool.append("\t"+dto.toString()+"\n");
				}
				
			}
		}else if(e.getSource() == btnMnameSearch) { // ���� �˻�
			// �������ö��� �����ϰ� �⺻���� ����
		 
			String mname = comMname.getSelectedItem().toString();
			students = dao.snamegetStudent(mname);
			if(mname.equals("")) {
				txtPool.setText("������ �����ϼ���. ");
				return;
			}
			students = dao.selectMname(mname);
			if(students.size()!=0) {
				txtPool.setText(" RANK\t�̸�\t\t����\t����\n");
				for (StudentDto dto : students) {
					txtPool.append(dto.toString()+"\n");
				}
			}else {
				txtPool.setText("��ȿ�� �Է°��� �ƴմϴ�.");
			}
		}else if(e.getSource() == btnInput) { // �л� �Է�
			String sname = txtSname.getText();
			String mname = comMname.getSelectedItem().toString();
			String scoreStr = txtScore.getText();
			if(sname.equals("")||mname.equals("")||scoreStr.equals("")) {
				txtPool.setText("�̸�, ����, ������ �Է��ϼž� �մϴ�. ");
				return;
			}
			int score = Integer.parseInt(scoreStr);
			StudentDto newStudent = new StudentDto(sname, mname, score);
			int result = dao.insertStudent(newStudent);
				if(result == StudentDao.SUCCESS) {
					txtPool.setText(sname+"�л� ���� �Է� ���� ");
					txtSname.setText("");
					comMname.setSelectedItem("");
					txtScore.setText("");
				}			
		} else if(e.getSource() == btnUpdate) { // �л� ����
			String snoStr = txtSno.getText().trim();
			String sname = txtSname.getText();
			String mname = comMname.getSelectedItem().toString();
			String scoreStr = txtScore.getText().trim();
			if(snoStr.equals("")||sname.equals("")||mname.equals("")||scoreStr.equals("")) {
				txtPool.setText("��� ������ �Է��ϼž� �մϴ�. ");
				return;
			}
			int sno = Integer.parseInt(snoStr);
			int score = Integer.parseInt(scoreStr);
			StudentDto newDto = new StudentDto(sname, sno, mname, score);
			int result = dao.updateStudent(newDto);
			if(result == StudentDao.SUCCESS) {
				txtPool.setText(sname+"�л� ���� ����");
				txtSno.setText("");
				txtSname.setText("");
				comMname.setSelectedItem("");
				txtScore.setText("");
			}else {
				txtPool.setText(sname+"�л� ���� ����");
			}
		}else if(e.getSource() == btnStudentOut) { // �л� ���
			txtSno.setText("");
			txtSname.setText("");
			comMname.setSelectedItem("");
			txtScore.setText("");
			students = dao.getStudents();
			if (students.size()!=0) {
				txtPool.setText("rank\t�̸�\t\t����\t����\n");
				for(StudentDto dto : students) {
					txtPool.append(dto.toString() + "\n");
				}
			}else {
				txtPool.setText("��ȿ�� �Է°��� �ƴմϴ�.");
			}
			
		}else if(e.getSource() == btnExpelOut) { // ������ ���
			txtSno.setText("");
			txtSname.setText("");
			comMname.setSelectedItem("");
			txtScore.setText("");
			students = dao.getStudentsExpel();
			if (students.size()!=0) {
				txtPool.setText("rank\t�̸�\t\t����\t����\n");
				for(StudentDto dto : students) {
					txtPool.append(dto.toString() + "\n");
				}
			}else {
				txtPool.setText("��ȿ�� �Է°��� �ƴմϴ�.");
			}			
		}else if(e.getSource() == btnExpel ) { // ���� ó��
			String snoStr = txtSno.getText().trim();
			String sname = txtSname.getText().trim();
			if(snoStr.length()==0) {
				txtPool.setText("�й��� �Է� �� �����Ͻÿ�. ");
				return;
			}
			int sno = Integer.parseInt(snoStr);
			StudentDto newDto = new StudentDto(sno, sname);
			int result = dao.updateStudent(newDto);
				if(result == StudentDao.SUCCESS) {
					txtPool.setText(sno+"�� �л� ����ó�� �Ϸ�");
					txtSno.setText("");
					txtSname.setText("");
					comMname.setSelectedItem("");
					txtScore.setText("");
			     }else {
			    	 txtPool.setText(sno+"�� �л� ����ó�� ����");
			     }
			
		}else if(e.getSource() == btnExit) { // ����
			setVisible(false); //���� �Ⱥ���
			dispose(); //������ ����
			System.exit(0);// â ����	
		}
	}
	
}
