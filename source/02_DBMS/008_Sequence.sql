-- [VII] SEQUENCE : 순차번호 생성기, 대부분 인위적인 PK 사용용도
DROP SEQUENCE FRIEND_SEQ;
CREATE SEQUENCE FRIEND_SEQ
  START WITH 1      -- 해당 행 생략가능
  INCREMENT BY 1    -- 해당 행 생략가능
  MAXVALUE 9999     -- 최대값
  MINVALUE 1        -- 최소값
  NOCACHE           -- 새로운 시퀀스를 시작할때 캐시 메모리를 초기화 하는 행.
  NOCYCLE   ;       -- 시퀀스가 최대값을 넘으면 1이 되지 않게 하는 행.

SELECT FRIEND_SEQ.NEXTVAL FROM DUAL;

DROP SEQUENCE FRIEND_SEQ;
CREATE SEQUENCE FRIEND_SEQ
  MAXVALUE 9999     -- 최대값
  NOCACHE           -- 새로운 시퀀스를 시작할때 캐시 메모리를 초기화 하는 행.
  NOCYCLE   ; 
  
  DROP TABLE FRIEND;
CREATE TABLE FRIEND(
   NUM NUMBER(4)     PRIMARY KEY, -- 시퀀스 이용.
   NAME VARCHAR2(10) NOT NULL, --유효하지 않는 외부 입력을 막음.
   TEL VARCHAR2(30) UNIQUE, -- NULL 허용, 유일한 값.
   ADDRESS VARCHAR2(300),
   LAST_MODIFYED DATE DEFAULT SYSDATE);
   
INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS)
   VALUES (FRIEND_SEQ.NEXTVAL, '홍길동', NULL, '서울시 강남구 강남대로94길 13 삼경빌딩 402');

INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS)
  VALUES (FRIEND_SEQ.NEXTVAL, '홍길동', NULL, '서울시 용산구');
  
INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS)
  VALUES (FRIEND_SEQ.NEXTVAL, '박길동', '010-9999-8888', '서울시 강남구 강남대로94길 13 삼경빌딩 402');  

INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS)
  VALUES (FRIEND_SEQ.NEXTVAL, '신길동', '010-9999-8888', '서울시 영등포구');

SELECT * FROM FRIEND;

SELECT FRIEND_SEQ.CURRVAL FROM DUAL; -- 현재 시퀀스 값 보기.

-- EX. 초기값 101부터 최대값 999,999까지 1씩 증가하는 TEST_SEQ 시퀀스를 생성
CREATE SEQUENCE TEST_SEQ START WITH 101 MAXVALUE 999999 NOCACHE NOCYCLE;
SELECT TEST_SEQ.CURRVAL FROM DUAL; 
SELECT TEST_SEQ.NEXTVAL FROM DUAL;


-- EX(C7.PP 4~5 AND C8 EX1)

--EX 7강 4번 연습문제 C7 PP4 BOOKEXERD
DROP TABLE BOOKCATEGORY;
DROP TABLE BOOK;

CREATE TABLE BOOKCATEGORY (
   CATEGORYCODE NUMBER(3) PRIMARY KEY,
   CATEGORYNAME VARCHAR2(50) UNIQUE,
   CATEGORY_LOC VARCHAR2(50));
   
INSERT INTO BOOKCATEGORY
       VALUES (100, '철학', '3층 인문실');
INSERT INTO BOOKCATEGORY
       VALUES (200, '인문', '3층 인문실');
INSERT INTO BOOKCATEGORY
       VALUES (300, '과학', '4층 과학실'); 
INSERT INTO BOOKCATEGORY
       VALUES (400, 'IT', '4층 과학실');  
       
COMMIT;       

SELECT * FROM     BOOKCATEGORY;   
   
CREATE TABLE BOOK (
         BOOKNO VARCHAR2(10) PRIMARY KEY,
   CATEGORYCODE NUMBER(3) REFERENCES BOOKCATEGORY (CATEGORYCODE),
       BOOKNAME VARCHAR2(50) UNIQUE,
      PUBLISHER VARCHAR2(50),
        PUBYEAR NUMBER(4) DEFAULT EXTRACT (YEAR FROM SYSDATE));

INSERT INTO BOOK (CATEGORYCODE, BOOKNO, BOOKNAME ,PUBLISHER) 
       VALUES (100, '100A01' ,'철학자의 삶', '더존출판');
INSERT INTO BOOK (CATEGORYCODE, BOOKNO, BOOKNAME ,PUBLISHER)
       VALUES (400, '400A01' ,'이것이 DB이다', '더존출판');

SELECT * FROM     BOOK; 
       
COMMIT; 

SELECT BOOKNAME FROM BOOK B, BOOKCATEGORY BC 
   WHERE b.categorycode = bc.categorycode AND BC.CATEGORY_LOC = '4층 과학실';

--EX2. 7강 5번 연습문제

DROP TABLE MAJOR;   --테이블 초기화
DROP TABLE STUDENT; --테이블 초기화

CREATE TABLE MAJOR(
  MAJOR_CODE NUMBER(5) PRIMARY KEY,
  MAJOR_NAME VARCHAR2(30) UNIQUE,
  MAJOR_LOC VARCHAR2(30) NOT NULL
  );

INSERT INTO MAJOR VALUES (1, '경영정보', '경영관 305호');
INSERT INTO MAJOR VALUES (2, '소프트웨어공학', '정보관 808호');
INSERT INTO MAJOR VALUES (3, '디자인', '예술관 606호');
INSERT INTO MAJOR VALUES (4, '경제', '경상관 202호');

SELECT * FROM MAJOR;

COMMIT;

CREATE TABLE STUDENT (
       STUDENT_CODE VARCHAR2(30) PRIMARY KEY,
       STUDENT_NAME VARCHAR2(30) NOT NULL,
       SCORE        NUMBER(5)    CHECK (SCORE >= 0 AND SCORE <=100),
       MAJOR_CODE   NUMBER(5)    REFERENCES MAJOR(MAJOR_CODE)
  );

INSERT INTO STUDENT VALUES ('A01', '김길동', 100, 1);  
INSERT INTO STUDENT VALUES ('A02', '문길동', 90, 2); 
INSERT INTO STUDENT VALUES ('A03', '홍길동', 95, 1); 

SELECT * FROM STUDENT;

COMMIT;
  

-- 8강 1번 연습문제

--<총연습문제1> 다음과 같은 구조의 테이블을 생성하고 데이터를 입력하는 SQL문을 조건에 맞게 작성하여 ex1.sql파일과 실행 캡처파일(ex1.jpg나 ex1.png)을 제출하시오.
--[요구사항]
--(1) 같은 이름의 테이블이나 시퀀스가 있을 수 있으니 먼저 삭제하고 테이블을 생성하시오
--(2) MEMBER 테이블은 필드 별로 다음의 조건을 지켜 생성하시오.
	--① mNO(번호) : 주키
	--② mNAME(이름) : NULL값을 입력할 수 없다
	--③ mPW(비밀번호) : 반드시 1~8글자 이내의 문자를 입력한다
	--④ mEMAIL(메일) : 모든 데이터는 EMAIL 필드값이 모두 다르게 입력된다.
	--⑤ mPOINT(포인트) : 0이상의 값만 입력할 수 있다.
	--⑥ mRDATE(가입일) : 입력하지 않을 시, 기본적으로 현재날짜로 입력된다.
--⑦ LEVELNO : MEMBER_LEVEL 테이블의 LEVELNO 필드를 참조하는 외래키
--3) MEMBER_LEVEL 테이블은 필드 별로 다음의 제약조건을 지킨다.
	--① LEVELNO : 주키
	--② LEVELNAME : NULL값을 입력할 수 없다	
--(4) MEMBER 테이블의 mNO번호는 시퀀스(MEMBER_MNO_SQ)를 생성한 뒤 자동생성 번호로 입력
--[입력될 데이터 내용]
--[MEMBER 테이블]
--mNO mNAME  mPW  mMAIL            mPOINT  mRDATE  LEVELNO
--1     홍길동   aa     hong@hong.com      0      22/03/10     0
--2     신길동   bb     sin@sin.com        1000     22/04/01     1

--[MEMBER_LEVEL 테이블]
--LEVELNO LEVELNAME
---1           black
--0            일반
--1            실버
--2            골드
--[테스트 출력 내용]
--mNO mNAME   mRDATE          mMAIL       point   levelname
--   1    홍길동  2022-03-10  hong@hong.com    0     일반고객
--   2   신길동   2022-04-01  sin@sin.com       1000   실버고객


DROP SEQUENCE MEMBER_SEQ;
CREATE SEQUENCE MEMBER_SEQ
  MAXVALUE 9999     -- 최대값
  MINVALUE 1        -- 최소값
  NOCACHE           -- 새로운 시퀀스를 시작할때 캐시 메모리를 초기화 하는 행.
  NOCYCLE   ;       -- 시퀀스가 최대값을 넘으면 1이 되지 않게 하는 행.

DROP TABLE MEMBER;
DROP TABLE MEMBER_LEVEL;

CREATE TABLE MEMBER_LEVEL(
       LEVELNO NUMBER  (10) PRIMARY KEY,
     LEVELNAME VARCHAR (30) NOT NULL);

INSERT INTO MEMBER_LEVEL VALUES (-1, 'BLACK');
INSERT INTO MEMBER_LEVEL VALUES (0, '일반');
INSERT INTO MEMBER_LEVEL VALUES (1, '실버');
INSERT INTO MEMBER_LEVEL VALUES (2, '골드');

SELECT * FROM MEMBER_LEVEL; --  출력값 확인 

COMMIT;

DROP TABLE MEMBER;
CREATE TABLE MEMBER (
        mNO     NUMBER   (5)  PRIMARY KEY,
        mNAME   VARCHAR2 (50) ,
        mPW     VARCHAR2 (24) CHECK (LENGTH(mPW)<= 8),
        mEMAIL  VARCHAR2 (50) UNIQUE,
        mPOINT  NUMBER   (10) CHECK (mPOINT >= 0),
        mRDATE  VARCHAR2 (50) DEFAULT SYSDATE,
        LEVELNO NUMBER   (10) REFERENCES MEMBER_LEVEL(LEVELNO)
        );

INSERT INTO MEMBER VALUES (MEMBER_SEQ.NEXTVAL, '홍길동' , 'aa', 'hong@hong.com', 0, '22/03/10', 0 );  
INSERT INTO MEMBER VALUES (MEMBER_SEQ.NEXTVAL, '신길동' , 'bb', 'sin@sin.com', 1000, '22/03/10', 1 );

SELECT * FROM MEMBER;

COMMIT;

--테스트 출력 내용
SELECT mNO, mNAME, mRDATE, mEMAIL, mPOINT, LEVELNAME
  FROM MEMBER M, MEMBER_LEVEL ML
  WHERE M.LEVELNO = ml.levelno;





