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
	 	btnJoin			= new JButton("가입");
	 	btnPhoneSearch	= new JButton("폰조회");
	 	btnPrint		= new JButton("출력"); 
	 	btnExit 		= new JButton("종료");
	 	jta = new JTextArea(15, 30);
		scrollPane = new JScrollPane(jta);
		jpup.add(new JLabel("폰번호",(int) CENTER_ALIGNMENT));
		jpup.add(txtPhone);
		jpup.add(new JLabel("이 름",(int) CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(new JLabel("포인트",(int) CENTER_ALIGNMENT));
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
		if(e.getSource() == btnJoin) { // 회원가입
		String pno, cname;
		try {
			pno = txtPhone.getText().trim();
			cname = txtName.getText().trim();
			if(cname.length()<2) {
				txtName.setText("");
				jta.setText("올바른 이름을 입력하시오 ");
				return;
			}
			int result = dao.joinIn(pno, cname);
				if(result == Customer01dao.SUCCESS) {
					jta.setText("회원 가입이 완료되었습니다 \n포인트 5000점을 기본으로 드립니다!");
				}else {
					jta.setText("01 유효한 입력값이 아닙니다.");
				}
			} catch (Exception e2) {
				txtPhone.setText("");
				jta.setText("02 유효한 값을 입력해 주시기 바랍니다. ");
				}
			
		}else if (e.getSource() == btnPhoneSearch) { // 전화번호로 찾기
				String pno;
				pno = txtPhone.getText().trim();
				if(pno.length()==0) {
					txtName.setText("");
					txtPoint.setText("");
					jta.setText("올바른 번호를 입력 후 검색하시오. ");
					return;
				}
				ArrayList<Customer01dto> dtos = dao.pnoSearch(pno); 
					if (dtos.size()==0) { // 없는 회원의 전화번호를 입력했을때
						txtName.setText("");
						txtPhone.setText("");
						txtPoint.setText("");
						jta.setText("해당하는 번호의 고객 정보가 존재하지 않습니다.");
					}else if (dtos.size()==1) { // 찾는 번호의 회원이 1명일 때
						txtPhone.setText(dtos.get(0).getPno());
						txtName.setText(dtos.get(0).getCname());
						txtPoint.setText(String.valueOf(dtos.get(0).getCpoint()));
						jta.setText("\t"+ (dtos.get(0).getPno()) +" 번호 회원님 검색 완료  ");
					}else { // 해당하는 번호의 회원이 2명 이상 일때
						jta.setText("전화번호\t이름\t포인트\n");
						jta.append("------------------------------------------------------------------------\n");
						for(Customer01dto cd : dtos) {
							jta.append(cd.toString() +"\n");
						}
					}
		}else if (e.getSource() == btnPrint) { // 회원 전체 출력
			txtPhone.setText("");
			txtName.setText("");
			txtPoint.setText("");
			ArrayList<Customer01dto> dtos = dao.getCustomers();
			if(dtos.size()!=0) {
				jta.setText("전화번호\t이름\t포인트\n");
				jta.append("------------------------------------------------------------------------\n");
				for(Customer01dto cd : dtos) {
					jta.append(cd.toString() +"\n");
				}
			}else {
				jta.setText("유효하지 않은 입력값입니다.");
			}
		}
		
		if(e.getSource() == btnExit) { // 종료
			setVisible(false); //눈에 안보임
			dispose(); //데이터 삭제
			System.exit(0);// 창 삭제	
		}
	}
	
	public static void main(String[] args) {
		new Customer01Mng("회원관리");

	}

	

}
