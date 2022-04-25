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
		contenPane.setLayout(new FlowLayout()); // 1부터 아래로 차례대로
		jpup = new JPanel(new GridLayout(5,2));// Panel의 기본 레이아웃은 FlowLayout 여기서는 GridLayout 5열 2행
		jpbtn = new JPanel(new FlowLayout());
		txtName = new JTextField(20);
		jnames = dao.jnamelist();
		comJob = new JComboBox<String>(jnames);
		txtKor = new JTextField(20);
		txtEng = new JTextField(20);
		txtMat = new JTextField(20);
		ImageIcon icon1 = new ImageIcon("icon01/join.png");
		btnInput = new JButton("입력",icon1);
		ImageIcon icon2 = new ImageIcon("icon01/search.png");
		btnSearch = new JButton("직업조회",icon2);
		ImageIcon icon3 = new ImageIcon("icon01/output.png");
		btnOutput = new JButton("전체출력",icon3);
		ImageIcon icon4 = new ImageIcon("icon01/exit.png");
		btnExit = new JButton("종료",icon4);
		btnInput.setPreferredSize(new Dimension(150, 50));
		btnSearch.setPreferredSize(new Dimension(150, 50));
		btnOutput.setPreferredSize(new Dimension(150, 50));
		btnExit.setPreferredSize(new Dimension(150, 50));
		txtPool = new JTextArea(10, 60);
		scrollPane = new JScrollPane(txtPool);
		//생성된 컴포넌트 화면 추가
		jpup.add(new JLabel("이름", (int) CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(new JLabel("직업", (int) CENTER_ALIGNMENT));
		jpup.add(comJob);
		jpup.add(new JLabel("국어", (int) CENTER_ALIGNMENT));
		jpup.add(txtKor);
		jpup.add(new JLabel("영어", (int) CENTER_ALIGNMENT));
		jpup.add(txtEng);
		jpup.add(new JLabel("수학", (int) CENTER_ALIGNMENT));
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
	public void actionPerformed(ActionEvent e) { // 이벤트 로직 추가
		// btninput 버튼 누르는 액션
		if(e.getSource() == btnInput) { // txtName, comJob, txtKor, txtEng, txtMat
			String pname = txtName.getText();
			String jname = comJob.getSelectedItem().toString();
			String korStr = txtKor.getText();
			String engStr = txtEng.getText();
			String matStr = txtMat.getText();
			if(pname.equals("") || jname.equals("") || korStr.equals("")|| engStr.equals("") || matStr.equals("")) {
				txtPool.setText("모든 변수를 입력하셔야 합니다.");
			return;
			}
			int kor = Integer.parseInt(korStr);
			int eng = Integer.parseInt(engStr);
			int mat = Integer.parseInt(matStr);
			PersonDto newPerson = new PersonDto(pname, jname, kor, eng, mat);
			int result = dao.insertPerson(newPerson);
				if(result == PersonDao.SUCCESS) {
				txtPool.setText(pname+"님 입력성공");
				txtName.setText("");
				comJob.setSelectedIndex(0); // 콤보박스를 0번째로 선택
				comJob.setSelectedItem(""); // 콤보박스를 공백으로선택
				txtKor.setText("");
				txtEng.setText("");
				txtMat.setText("");
				}
		} else if(e.getSource() == btnSearch) {  // btnSearch 버튼 누르는 액션 // comJob에 선택된 직업조회 결과를 txtPool
			String jname = comJob.getSelectedItem().toString();
			if(jname.equals("")) {
				txtPool.setText("직업 선택 후 직업 조회 하세요");
				return;
			}		
			person = dao.selectJname(jname);		
			if (person.size()!=0) {
				txtPool.setText("등수\t이름\t직업\t국어\t수학\t영어\t 총점\n");
				for(PersonDto dto : person) {
					txtPool.append(dto.toString()+"\n");
				}
			}else {
				txtPool.setText("유효한 입력값이 아닙니다.");
			}
			
		} else if(e.getSource() == btnOutput) {
			person = dao.selectAll();
			if (person.size()!=0) {
				txtPool.setText("등수\t이름\t직업\t국어\t수학\t영어\t 총점\n");
				for(PersonDto dto : person) {
					txtPool.append(dto.toString()+"\n");
				}
			}else {
				txtPool.setText("유효한 입력값이 아닙니다.");
			}
			
		}else if(e.getSource() == btnExit) {
			setVisible(false); //눈에 안보임
			dispose(); //데이터 삭제
			System.exit(0);// 창 삭제			
		}
		
	}
 public static void main(String[] args) {
	new PersonMngGui("연예인 성적 관리");
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





