-- DCL (계정생성, 권한부여, 권한박탈, 계정삭제)
-- DDL (제약조건, 시퀀스 없음)
-- DML (outer join, AND=&&, OR=||, 일부단행형함수)
-- java에서 쓸 데이터 넣고 연습해보기
show databases; -- database 리스트 보기
use kimdb;
select * from personal;
-- * * * DCL (계정생성, 권한부여, 권한박탈, 계정삭제) * * *
create user user01 identified by 'password';
grant all privileges on *.* to user01; -- 권한부여
revoke all on *.* from user01; -- 권한박탈
drop user user01;
show tables; -- 오라클의 select * from tab)

show databases;

create database kimdb; --새로운 데이터베이스 영역 생성
use kimdb; -- kimdb 데이터베이스로 들어감
select database();
use world;
use kimdb; -- kimdb 데이터베이스로 들어감 수업시간에 모든 수업은 kimdb로 진행

-- * * * DDL (테이블 생성, 제약조건, 시퀀스 없음) * * *
create table emp(
		empno numeric(4) primary key, -- 숫자 4자리
        ename varchar(20) not null,   -- 글자 20바이트
        nickname varchar(20) unique,  -- 글자 20바이트
        sal numeric (7,2) check (sal>0), -- 숫자 7자리 소수점 2째 
        hiredate datetime default now(), -- 오늘 날짜.
        comm numeric (7,2) default 0 -- 숫자 7자리 소수점 2째 
);
select * from emp;
drop table if exists emp;
--
-- Major (mCode (시퀀스 같은 숫자번호)) : PK, mName, mOffice
-- Student (sNo : PK, sName, mCode)

create table major (
	mCode int primary key auto_increment, -- auto_increment일 경우 int
    mName varchar(20),
    mOffice varchar(50) );
    
create table student (
	sNo int primary key,
    sName varchar(20),
	mCode int references major (mCode));

insert into major (mName, mOffice) values ('컴공', '402호');
insert into major (mName, mOffice) values ('경영', '502호');
insert into major (mName, mOffice) values ('경제', '301호');
select * from major;
insert into student values (1111, '홍', 1);
insert into student values (2222, '이', 2);
insert into student values (3333, '사', 3);
insert into student values (4444, '사', 4);

drop table if exists major;
drop table if exists student;

create table major (
	mCode int auto_increment,
    mName varchar(30) not null,
    mOffi varchar(30),
    primary key (mCode)
    );
    
create table student(
	sNo int,
    sName varchar (30),
    mCode int,
    primary key (sNo),
    foreign key(mCode) references major(mCode)
	);    

insert into major (mName, mOffi) values ('컴공', '402호');
insert into major (mName, mOffi) values ('경영', '502호');
insert into major (mName, mOffi) values ('경제', '301호');
select * from major;
insert into student values (1111, '홍', 1);
insert into student values (2222, '이', 2);
insert into student values (3333, '사', 3);
insert into student values (4444, '박', 4);
select * from student;
-- 학번, 이름, 학과코드, 학과명, 사무실
select sNo, sName, s.mCode, mName, mOffi
  from student s, major m
  where s.mCode = m.mCode;

-- 자바 (JDBC) 수업시간에 쓸 테이블 생성
drop table if exists personal;
drop table if exists division;
create table division (
	dNo int,           -- 부서번호
    dName varchar(20), -- 부서이름
    dTel varchar(20),   -- 부서전화
    postion varchar(20), -- 부서위치
    primary key (dno)
	);
insert into division values (10, 'finance', '02-545-5555', '강남');
insert into division values (20, 'research', '02-777-7777', '회현');
insert into division values (30, 'sales', '02-333-333', '서초');
insert into division values (40, 'marketing', '02-666-6666', '과천');
select * from division;

create table personal (
	pNo int,                     -- 사번
    pName varchar(20) not null , -- 사원명
    job varchar(20) not null ,   -- 직급
    manager int,                 -- 상사의 사번
    startdate date,              -- 입사일
    pay int,                     -- 급여
	bonus int,                   -- 상여
    dNo int,
    primary key (pNo),
    foreign key (dNo) references division (dNo)
	);
    
insert into personal values (1111,'smith','manager', 1001, '1990-12-17', 1000, null, 10);
insert into personal values (1112,'ally','salesman',1116,'1991-02-20',1600,500,30);
insert into personal values (1113,'word','salesman',1116,'1992-02-24',1450,300,30);
insert into personal values (1114,'james','manager',1001,'1990-04-12',3975,null,20);
insert into personal values (1001,'bill','president',null,'1989-01-10',7000,null,10);
insert into personal values (1116,'johnson','manager',1001,'1991-05-01',3550,null,30);
insert into personal values (1118,'martin','analyst',1111,'1991-09-09',3450,null,10);
insert into personal values (1121,'kim','clerk',1114,'1990-12-08',4000,null,20);
insert into personal values (1123,'lee','salesman',1116,'1991-09-23',1200,0,30);
insert into personal values (1226,'park','analyst',1111,'1990-01-03',2500,null,10);
commit;
select * from personal; 


-- *** DML (outer join, 단일행함수 일부, top-n구문, and=&&, )

-- 1. 사번, 이름, 급여를 출력
select pNo, pName, pay from personal;

-- 2. 급여가 2000~5000 사이 모든 직원의 모든 필드
select * from personal where pay between 2000 and 5000;

-- 3. 부서번호가 10또는 20인 사원의 사번, 이름, 부서번호
select pNo, pName, dNo from personal 
	where dNo = 10 or dNo =20 ;

-- 4. 보너스가 null인 사원의 사번, 이름, 급여 급여 큰 순정렬
select pNo, pName, pay from personal where bonus is null order by pay desc;

-- 5. 사번, 이름, 부서번호, 급여. 부서코드 순 정렬 같으면 PAY 큰순
select pNo, pName, dNo, pay from personal order by dNo, pay desc;

-- 6. 사번, 이름, 부서명
select pNo, pName, dName from personal p, division d
	where p.dNo = d.dNo;

-- 7. 사번, 이름, 상사이름
select p1.pNo, p1.pName, p2.pName "mName"
	from personal p1 , personal p2
    where p1.manager = p2.pNo;
    
-- 8. 사번, 이름, 상사이름(상사가 없는 사람도 출력, 상사가 없으면 null 대신 'ceo')
select p1.pNo, p1.pName, ifnull(p2.pName, 'ceo') "mName"
	from personal p1 left outer join personal p2
    on p1.manager = p2.pNo; -- left outer join.

select p1.pNo, p1.pName, if(p2.pName is null, 'ceo', p2.pName) "mName"
	from personal p1 left outer join personal p2
    on p1.manager = p2.pNo; -- left outer join.

-- 9. 이름이 s로 시작하는 사원 이름
select pName from personal where pName like 's%';

-- 10. 사번, 이름, 급여, 부서명, 상사이름
select p1.pNo, p1.pName, p1.pay , dName ,ifnull(p2.pName, 'ceo') "mName"
	from division d, personal p1 left outer join personal p2 
    on p1.manager = p2.pNo
    where d.dNo=p1.dNo; -- left outer join.

-- 11. 부서코드, 급여합계, 최대급여
select dNo, sum(pay), max(pay) from personal;

-- 12. 부서명, 급여평균, 인원수
select dName, avg(pay), round(count(pName),2) "인원수" from personal p, division d
	where d.dNo = p.dNo group by dName;

-- 13. 부서코드, 급여합계, 인원수 인원수가 4명 이상인 부서만 출력
select p.dNo, sum(pay), round(count(pName),2) "인원수" from personal p, division d
	where d.dNo = p.dNo
    group by p.dNo
    having count(pName)>=4; 
    
    
-- 14. 사번, 이름, 급여 회사에서 제일 급여를 많이 받는 사람
select pNo, pName, pay from personal where pay = (select max(pay) "maxpay" from personal);

-- 15. 회사 평균보다 급여를 많이 받는 사람 이름, 급여, 부서번호
select pName, pay, dNo from personal
	where pay > (select avg(pay) from personal);

-- 16. 15번에 부서명을 추가하고 부서명순 정열 같으면 급여 큰순
select pName, pay, p.dNo, dName from personal p, division d
	where p.dNo = d.dNo
    and pay > (select avg(pay) from personal)
    order by p.dNo, pay desc;
    
-- 17. 자신이 속한 부서의 평균보다 많인 받는 사람의 이름, 금여, 부서번호, 반올림한 해당부서평균
select pName, pay, dNo, (select round(avg(pay)) FROM personal WHERE dNo = p.dNo) "groupavg"
	from personal p
	where  dNo = p.dNo
    and pay > (select avg(pay) FROM personal WHERE dNo = p.dNo)
    group by dNo;

-- INLINE VIEW를 이용한 풀이

SELECT pNo, pName, pay, (select round(avg(pay)) FROM personal WHERE dNo = p.dNo) "groupavg"
  FROM personal p, (SELECT dNo, AVG(pay)"AVG" FROM personal GROUP BY dNo) A
  WHERE p.dNo = A.dNo
  AND pay > AVG 
  ORDER BY pay desc;     
    select avg(pay) FROM personal p WHERE dNo = p.dNo;
    SELECT dNo, AVG(pay)"AVG" FROM personal GROUP BY dNo;
    
-- 18. 입사가 가장 빠른 사람의 이름, 급여, 부서명
select pName, pay, dName, startdate from personal p, division d
	where p.dNo = d.dNo
	and startdate = (select min(startdate) from personal);

-- 19. 이름, 급여, 해당부서평균
select pName, pay, (select round(avg(pay)) FROM personal WHERE dNo = p.dNo) "groupavg"
	from personal p;

-- 20. 이름, 급여, 부서명, 해당부서평균
select pName, pay, dName ,(select round(avg(pay)) FROM personal WHERE dNo = p.dNo) "groupavg"
	from personal p, division d
    where p.dNo = d.dNo;

-- 오라클에서 date : 날짜와 시간 
-- MYSQL : date, time, datetime

-- Oracle에서의 단일행함수와 MySQL 컬럼함수의 다른 부분
select round(789.56, 1); -- from절 없어도 실행 가능
select pName || '은' || job || '이다' from personal; -- || 은 OR 연산자.
select concat(pname, '은 ', job, '이다') 설명 from personal; -- concat을 적극적으로 써주도록 하자

-- 날짜 포맷용 컬럼함수
select startdate from personal;
-- extract 형 함수
select year(startdate), month(startdate), day(startdate),
	hour(startdate), minute(startdate), second(startdate) from personal;

-- date_format(날짜나 시간데이터, '포맷') -- 날짜를 숫자로 변환하는 것
	-- 포맷 글자 : %y - 연도 두자리, %Y - 연도 네자리, 
    -- %M 월이름, %b 짧은 월이름 , %m 2자리 개월수, %c (개월수)
    -- %d 01,02,03 두자리수 날짜, %e 날짜만 나옴
    -- %H 24시간 %h 12시간, %p 오전오후, %i 분, %s 초
-- 시스템으로부터 현재 날짜와 시간을 받음
select sysdate();
select now();
-- 시스템으로부터 현재 날짜만 가지고 옴
	select current_date();
	select curdate();
-- 시스템으로부터 현재 시간만 가지고 옴
	select current_time();
	select curtime();
    
select date_format(now(), '%Y년%m월%e일 %p %h시 %i분') nowtime ;

-- format(숫자데이터) ; 3자리 콤마 추가
-- format(숫자데이터, 소수점자리수) ; 소수점 확보되면서 3자리 콤마 추가
select format(pay, 1) from personal;


-- workbench에서 데이터 삭제하고 수정 (where절에 primary key이용한 비교)
insert into personal (pNo, pName, job, manager, startdate, pay, bonus, dNo)
	values (1000, 'hong', 'manager', 1001, curdate(), 9000, 900, 40);
commit;
set sql_safe_updates = 0; -- commit 이후 업데이트 막아 놓은 것 풀어버리기
delete from personal where pName = 'hong'; -- 퍼스널에서 홍 빼기 

-- * * * TOP - N 구문
-- MySQL에서 Top-N 구문 꼭 써보기
select rownum, pNo from personal; -- rownum에 없음
select pname, pay from personal order by pay desc;
-- limit n  1등부터 N등까지 가져와라.
select pname, pay from personal order by pay desc limit 5;
-- limit 3,3 (3번째 자리 다음 등수부터 3자리 등수의 값을 출력) 4등부터 6등까지 가져와라.
select pname, pay from personal order by pay desc limit 3,3;
-- limit 5,4 6등부터 9등까지 가져오라 6,7,8,9
select pname, pay from personal order by pay desc limit 5,4;





