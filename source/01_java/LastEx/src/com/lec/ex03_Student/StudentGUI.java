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
		btnSnoSearch = new JButton("학번검색");
		btnSnameSearch = new JButton("이름검색");
		btnMnameSearch = new JButton("전공검색");
		btnInput = new JButton("입력");
		btnUpdate = new JButton("학생수정");
		btnStudentOut = new JButton("학생출력");
		btnExpelOut = new JButton("제적자출력");
		btnExpel = new JButton("제적처리");
		btnExit = new JButton("종료");
		txtPool = new JTextArea(10, 50);
		scrollPane = new JScrollPane(txtPool);
		jpup.add(new JLabel("학번",(int) CENTER_ALIGNMENT));
		jpup.add(txtSno);
		jpup.add(btnSnoSearch);
		jpup.add(new JLabel("이름",(int) CENTER_ALIGNMENT));
		jpup.add(txtSname);
		jpup.add(btnSnameSearch);
		jpup.add(new JLabel("전공",(int) CENTER_ALIGNMENT));
		jpup.add(comMname);
		jpup.add(btnMnameSearch);
		jpup.add(new JLabel("점수",(int) CENTER_ALIGNMENT));
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
		new StudentGUI("학사 관리");
	 }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnSnoSearch) { // 학번 검색
			String snoStr = txtSno.getText().trim();			
			if(snoStr.length()==0) {
				txtPool.setText("학번을 입력 후 검색하시오. ");
				return;
			}
			int sno = Integer.parseInt(snoStr); 
			StudentDto dto = dao.snogetStudent(sno); 
			if(dto!=null) {
				txtSname.setText(dto.getSname());
				comMname.setSelectedItem(dto.getMname());
				txtScore.setText(String.valueOf(dto.getScore()));
				txtPool.setText(sno+"번 검색 완료");
			}else {
				txtPool.setText("해당 학번은 유효하지 않습니다.");
			}
		}else if(e.getSource() == btnSnameSearch) { // 이름 검색
			String sname = txtSname.getText().trim();
			if(sname.length()==0) {
				txtPool.setText("이름을 입력 후 검색하시오. ");
				txtSno.setText("");
				txtScore.setText("");
				comMname.setSelectedItem("");
				return;
			} students = dao.snamegetStudent(sname);
			if(students.size()==0) {
				txtSno.setText("");
				txtScore.setText("");
				comMname.setSelectedItem("");
				txtPool.setText("찾으시는 이름의 학생이 없습니다. ");
			}else if (students.size()==1) {
				txtSno.setText(String.valueOf(students.get(0).getSno()));
				comMname.setSelectedItem(students.get(0).getMname());
				txtSname.setText(students.get(0).getSname());
				txtScore.setText(String.valueOf(students.get(0).getScore()));
				txtPool.setText(sname +" 검색 완료 ");
			}else { // 같은 이름이 나왔을때				
				txtPool.setText("\t학번\t이름\t전공\t점수\n"); // 항목 세팅
				txtPool.append("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");//절취선
				for(StudentDto dto : students) { // 관련 항목들을 출력하는 for 구문
					txtPool.append("\t"+dto.toString()+"\n");
				}
				
			}
		}else if(e.getSource() == btnMnameSearch) { // 전공 검색
			// 전공선택란을 제외하고 기본으로 비운다
		 
			String mname = comMname.getSelectedItem().toString();
			students = dao.snamegetStudent(mname);
			if(mname.equals("")) {
				txtPool.setText("전공을 선택하세요. ");
				return;
			}
			students = dao.selectMname(mname);
			if(students.size()!=0) {
				txtPool.setText(" RANK\t이름\t\t전공\t점수\n");
				for (StudentDto dto : students) {
					txtPool.append(dto.toString()+"\n");
				}
			}else {
				txtPool.setText("유효한 입력값이 아닙니다.");
			}
		}else if(e.getSource() == btnInput) { // 학생 입력
			String sname = txtSname.getText();
			String mname = comMname.getSelectedItem().toString();
			String scoreStr = txtScore.getText();
			if(sname.equals("")||mname.equals("")||scoreStr.equals("")) {
				txtPool.setText("이름, 전공, 점수를 입력하셔야 합니다. ");
				return;
			}
			int score = Integer.parseInt(scoreStr);
			StudentDto newStudent = new StudentDto(sname, mname, score);
			int result = dao.insertStudent(newStudent);
				if(result == StudentDao.SUCCESS) {
					txtPool.setText(sname+"학생 정보 입력 성공 ");
					txtSname.setText("");
					comMname.setSelectedItem("");
					txtScore.setText("");
				}			
		} else if(e.getSource() == btnUpdate) { // 학생 수정
			String snoStr = txtSno.getText().trim();
			String sname = txtSname.getText();
			String mname = comMname.getSelectedItem().toString();
			String scoreStr = txtScore.getText().trim();
			if(snoStr.equals("")||sname.equals("")||mname.equals("")||scoreStr.equals("")) {
				txtPool.setText("모든 변수를 입력하셔야 합니다. ");
				return;
			}
			int sno = Integer.parseInt(snoStr);
			int score = Integer.parseInt(scoreStr);
			StudentDto newDto = new StudentDto(sname, sno, mname, score);
			int result = dao.updateStudent(newDto);
			if(result == StudentDao.SUCCESS) {
				txtPool.setText(sname+"학생 수정 성공");
				txtSno.setText("");
				txtSname.setText("");
				comMname.setSelectedItem("");
				txtScore.setText("");
			}else {
				txtPool.setText(sname+"학생 수정 실패");
			}
		}else if(e.getSource() == btnStudentOut) { // 학생 출력
			txtSno.setText("");
			txtSname.setText("");
			comMname.setSelectedItem("");
			txtScore.setText("");
			students = dao.getStudents();
			if (students.size()!=0) {
				txtPool.setText("rank\t이름\t\t전공\t점수\n");
				for(StudentDto dto : students) {
					txtPool.append(dto.toString() + "\n");
				}
			}else {
				txtPool.setText("유효한 입력값이 아닙니다.");
			}
			
		}else if(e.getSource() == btnExpelOut) { // 제적자 출력
			txtSno.setText("");
			txtSname.setText("");
			comMname.setSelectedItem("");
			txtScore.setText("");
			students = dao.getStudentsExpel();
			if (students.size()!=0) {
				txtPool.setText("rank\t이름\t\t전공\t점수\n");
				for(StudentDto dto : students) {
					txtPool.append(dto.toString() + "\n");
				}
			}else {
				txtPool.setText("유효한 입력값이 아닙니다.");
			}			
		}else if(e.getSource() == btnExpel ) { // 제적 처리
			String snoStr = txtSno.getText().trim();
			String sname = txtSname.getText().trim();
			if(snoStr.length()==0) {
				txtPool.setText("학번을 입력 후 실행하시오. ");
				return;
			}
			int sno = Integer.parseInt(snoStr);
			StudentDto newDto = new StudentDto(sno, sname);
			int result = dao.updateStudent(newDto);
				if(result == StudentDao.SUCCESS) {
					txtPool.setText(sno+"번 학생 제적처리 완료");
					txtSno.setText("");
					txtSname.setText("");
					comMname.setSelectedItem("");
					txtScore.setText("");
			     }else {
			    	 txtPool.setText(sno+"번 학생 제적처리 실패");
			     }
			
		}else if(e.getSource() == btnExit) { // 종료
			setVisible(false); //눈에 안보임
			dispose(); //데이터 삭제
			System.exit(0);// 창 삭제	
		}
	}
	
}
