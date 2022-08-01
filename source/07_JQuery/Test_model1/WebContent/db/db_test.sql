drop table member_test;
DROP SEQUENCE MT_SEQ;
CREATE SEQUENCE MT_SEQ MAXVALUE 99999 NOCACHE NOCYCLE;
create table member_test ( 
		custno number(5) NOT NULL PRIMARY KEY,
		custname varchar2(20),
		phone	varchar2(20),
		address varchar2(60),
		joindate DATE default sysdate,
		grade char(1),
		city char(2) );
		
		select * from MEMBER_TEST;
		select * from MEMBER_TEST where custno = '1005';
		

insert into MEMBER_TEST (custno, custname, phone, address, joindate, grade, city)
	   values (1001, '홍길동', '010-1111-2222', '서울 동대문구', '20220702', 'A', '01');
	   
	   insert into MEMBER_TEST (custno, custname, phone, address, joindate, grade, city)
	   values (1002, '신길동', '010-1111-3333', '서울 강남구', '20220601', 'B', '01');
	   
	   insert into MEMBER_TEST (custno, custname, phone, address, joindate, grade, city)
	   values (1003, '김길동', '010-1111-4444', '경기도 안양시', '20220501', 'B', '30');
	   
	   insert into MEMBER_TEST (custno, custname, phone, address, joindate, grade, city)
	   values (1004, '유길동', '010-1111-5555', '경기도 의정부시', '20220703', 'A', '30');
	   
	   insert into MEMBER_TEST (custno, custname, phone, address, joindate, grade, city)
	   values (1005, '정길동', '010-1111-6666', '서울시 용산구', '20220703', 'B', '60');
	   insert into MEMBER_TEST (custno, custname, phone, address, joindate, grade, city)
	   values ('10000'+MT_SEQ.nextval, '조길동', '010-1111-6666', '서울시 용산구', '20220703', 'B', '60');
	   
update MEMBER_TEST set custname = '리기동',
					   phone = '010-1111-6666',
					   address = '수정시 수정동',
					   joindate = '20220706',
					   grade = 'A',
					   city = '88'
					   where custno = 1005;
	
	 
	   
create table grade1( grade char(1), gname varchar2(10)  );

insert into grade1 (grade, gname) values ('A', 'VIP');
insert into grade1 (grade, gname) values ('B', '일반');
insert into grade1 (grade, gname) values ('C', '직원');

drop table money;
create table money ( 
		saleno number(6) NOT NULL PRIMARY KEY,
		custno number(5) NOT NULL,
		cost number(8),
		amount number(4),
		price number(8),
		pcode varchar2(4),
		sdate DATE default sysdate  );
		
		select * from money;
		
 insert into money (saleno , custno , cost, amount, price, pcode, sdate)
 values (202201, 1001, 100, 20, 2000, 'A01', '220701');
 
 insert into money (saleno , custno , cost  , amount, price, pcode, sdate)
 values (202202, 1001, 150, 20, 3000, 'A02', '220701');
 
 insert into money (saleno , custno , cost  , amount, price, pcode, sdate)
 values (202203, 1002, 200, 10, 2000, 'A03', '220701');
 
 insert into money (saleno , custno , cost  , amount, price, pcode, sdate)
 values (202204, 1003, 100, 5, 500, 'A01', '220701');
 
 insert into money (saleno , custno , cost  , amount, price, pcode, sdate)
 values (202205, 1004, 100, 9, 900, 'A01', '220702');
 
 insert into money (saleno , custno , cost  , amount, price, pcode, sdate)
 values (202206, 1003, 150, 6, 900, 'A02', '220703');
 
 insert into money (saleno , custno , cost  , amount, price, pcode, sdate)
 values (202207, 1001, 200, 2, 400, 'A03', '220704');

select mt.custno, mt.custname, g.gname
	from MEMBER_TEST mt, money m, grade1 g where mt.custno=m.custno and mt.grade = g.grade
	group by mt.custno order by mt.custno;
	
select t.custno, t.custname, a.*
from MEMBER_TEST t, (select sum(price) from money group by custno order by custno) a;

select t.custno, t.custname, g.gname
from MEMBER_TEST t, grade1 g where t.grade = g.grade order by t.custno;
 

select pcode, sum(price) sp from money group by pcode order by pcode;
	   