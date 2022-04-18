-- [VII] SEQUENCE : ������ȣ ������, ��κ� �������� PK ���뵵
DROP SEQUENCE FRIEND_SEQ;
CREATE SEQUENCE FRIEND_SEQ
  START WITH 1      -- �ش� �� ��������
  INCREMENT BY 1    -- �ش� �� ��������
  MAXVALUE 9999     -- �ִ밪
  MINVALUE 1        -- �ּҰ�
  NOCACHE           -- ���ο� �������� �����Ҷ� ĳ�� �޸𸮸� �ʱ�ȭ �ϴ� ��.
  NOCYCLE   ;       -- �������� �ִ밪�� ������ 1�� ���� �ʰ� �ϴ� ��.

SELECT FRIEND_SEQ.NEXTVAL FROM DUAL;

DROP SEQUENCE FRIEND_SEQ;
CREATE SEQUENCE FRIEND_SEQ
  MAXVALUE 9999     -- �ִ밪
  NOCACHE           -- ���ο� �������� �����Ҷ� ĳ�� �޸𸮸� �ʱ�ȭ �ϴ� ��.
  NOCYCLE   ; 
  
  DROP TABLE FRIEND;
CREATE TABLE FRIEND(
   NUM NUMBER(4)     PRIMARY KEY, -- ������ �̿�.
   NAME VARCHAR2(10) NOT NULL, --��ȿ���� �ʴ� �ܺ� �Է��� ����.
   TEL VARCHAR2(30) UNIQUE, -- NULL ���, ������ ��.
   ADDRESS VARCHAR2(300),
   LAST_MODIFYED DATE DEFAULT SYSDATE);
   
INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS)
   VALUES (FRIEND_SEQ.NEXTVAL, 'ȫ�浿', NULL, '����� ������ �������94�� 13 ������ 402');

INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS)
  VALUES (FRIEND_SEQ.NEXTVAL, 'ȫ�浿', NULL, '����� ��걸');
  
INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS)
  VALUES (FRIEND_SEQ.NEXTVAL, '�ڱ浿', '010-9999-8888', '����� ������ �������94�� 13 ������ 402');  

INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS)
  VALUES (FRIEND_SEQ.NEXTVAL, '�ű浿', '010-9999-8888', '����� ��������');

SELECT * FROM FRIEND;

SELECT FRIEND_SEQ.CURRVAL FROM DUAL; -- ���� ������ �� ����.

-- EX. �ʱⰪ 101���� �ִ밪 999,999���� 1�� �����ϴ� TEST_SEQ �������� ����
CREATE SEQUENCE TEST_SEQ START WITH 101 MAXVALUE 999999 NOCACHE NOCYCLE;
SELECT TEST_SEQ.CURRVAL FROM DUAL; 
SELECT TEST_SEQ.NEXTVAL FROM DUAL;


-- EX(C7.PP 4~5 AND C8 EX1)

--EX 7�� 4�� �������� C7 PP4 BOOKEXERD
DROP TABLE BOOKCATEGORY;
DROP TABLE BOOK;

CREATE TABLE BOOKCATEGORY (
   CATEGORYCODE NUMBER(3) PRIMARY KEY,
   CATEGORYNAME VARCHAR2(50) UNIQUE,
   CATEGORY_LOC VARCHAR2(50));
   
INSERT INTO BOOKCATEGORY
       VALUES (100, 'ö��', '3�� �ι���');
INSERT INTO BOOKCATEGORY
       VALUES (200, '�ι�', '3�� �ι���');
INSERT INTO BOOKCATEGORY
       VALUES (300, '����', '4�� ���н�'); 
INSERT INTO BOOKCATEGORY
       VALUES (400, 'IT', '4�� ���н�');  
       
COMMIT;       

SELECT * FROM     BOOKCATEGORY;   
   
CREATE TABLE BOOK (
         BOOKNO VARCHAR2(10) PRIMARY KEY,
   CATEGORYCODE NUMBER(3) REFERENCES BOOKCATEGORY (CATEGORYCODE),
       BOOKNAME VARCHAR2(50) UNIQUE,
      PUBLISHER VARCHAR2(50),
        PUBYEAR NUMBER(4) DEFAULT EXTRACT (YEAR FROM SYSDATE));

INSERT INTO BOOK (CATEGORYCODE, BOOKNO, BOOKNAME ,PUBLISHER) 
       VALUES (100, '100A01' ,'ö������ ��', '��������');
INSERT INTO BOOK (CATEGORYCODE, BOOKNO, BOOKNAME ,PUBLISHER)
       VALUES (400, '400A01' ,'�̰��� DB�̴�', '��������');

SELECT * FROM     BOOK; 
       
COMMIT; 

SELECT BOOKNAME FROM BOOK B, BOOKCATEGORY BC 
   WHERE b.categorycode = bc.categorycode AND BC.CATEGORY_LOC = '4�� ���н�';

--EX2. 7�� 5�� ��������

DROP TABLE MAJOR;   --���̺� �ʱ�ȭ
DROP TABLE STUDENT; --���̺� �ʱ�ȭ

CREATE TABLE MAJOR(
  MAJOR_CODE NUMBER(5) PRIMARY KEY,
  MAJOR_NAME VARCHAR2(30) UNIQUE,
  MAJOR_LOC VARCHAR2(30) NOT NULL
  );

INSERT INTO MAJOR VALUES (1, '�濵����', '�濵�� 305ȣ');
INSERT INTO MAJOR VALUES (2, '����Ʈ�������', '������ 808ȣ');
INSERT INTO MAJOR VALUES (3, '������', '������ 606ȣ');
INSERT INTO MAJOR VALUES (4, '����', '���� 202ȣ');

SELECT * FROM MAJOR;

COMMIT;

CREATE TABLE STUDENT (
       STUDENT_CODE VARCHAR2(30) PRIMARY KEY,
       STUDENT_NAME VARCHAR2(30) NOT NULL,
       SCORE        NUMBER(5)    CHECK (SCORE >= 0 AND SCORE <=100),
       MAJOR_CODE   NUMBER(5)    REFERENCES MAJOR(MAJOR_CODE)
  );

INSERT INTO STUDENT VALUES ('A01', '��浿', 100, 1);  
INSERT INTO STUDENT VALUES ('A02', '���浿', 90, 2); 
INSERT INTO STUDENT VALUES ('A03', 'ȫ�浿', 95, 1); 

SELECT * FROM STUDENT;

COMMIT;
  

-- 8�� 1�� ��������

--<�ѿ�������1> ������ ���� ������ ���̺��� �����ϰ� �����͸� �Է��ϴ� SQL���� ���ǿ� �°� �ۼ��Ͽ� ex1.sql���ϰ� ���� ĸó����(ex1.jpg�� ex1.png)�� �����Ͻÿ�.
--[�䱸����]
--(1) ���� �̸��� ���̺��̳� �������� ���� �� ������ ���� �����ϰ� ���̺��� �����Ͻÿ�
--(2) MEMBER ���̺��� �ʵ� ���� ������ ������ ���� �����Ͻÿ�.
	--�� mNO(��ȣ) : ��Ű
	--�� mNAME(�̸�) : NULL���� �Է��� �� ����
	--�� mPW(��й�ȣ) : �ݵ�� 1~8���� �̳��� ���ڸ� �Է��Ѵ�
	--�� mEMAIL(����) : ��� �����ʹ� EMAIL �ʵ尪�� ��� �ٸ��� �Էµȴ�.
	--�� mPOINT(����Ʈ) : 0�̻��� ���� �Է��� �� �ִ�.
	--�� mRDATE(������) : �Է����� ���� ��, �⺻������ ���糯¥�� �Էµȴ�.
--�� LEVELNO : MEMBER_LEVEL ���̺��� LEVELNO �ʵ带 �����ϴ� �ܷ�Ű
--3) MEMBER_LEVEL ���̺��� �ʵ� ���� ������ ���������� ��Ų��.
	--�� LEVELNO : ��Ű
	--�� LEVELNAME : NULL���� �Է��� �� ����	
--(4) MEMBER ���̺��� mNO��ȣ�� ������(MEMBER_MNO_SQ)�� ������ �� �ڵ����� ��ȣ�� �Է�
--[�Էµ� ������ ����]
--[MEMBER ���̺�]
--mNO mNAME  mPW  mMAIL            mPOINT  mRDATE  LEVELNO
--1     ȫ�浿   aa     hong@hong.com      0      22/03/10     0
--2     �ű浿   bb     sin@sin.com        1000     22/04/01     1

--[MEMBER_LEVEL ���̺�]
--LEVELNO LEVELNAME
---1           black
--0            �Ϲ�
--1            �ǹ�
--2            ���
--[�׽�Ʈ ��� ����]
--mNO mNAME   mRDATE          mMAIL       point   levelname
--   1    ȫ�浿  2022-03-10  hong@hong.com    0     �Ϲݰ�
--   2   �ű浿   2022-04-01  sin@sin.com       1000   �ǹ���


DROP SEQUENCE MEMBER_SEQ;
CREATE SEQUENCE MEMBER_SEQ
  MAXVALUE 9999     -- �ִ밪
  MINVALUE 1        -- �ּҰ�
  NOCACHE           -- ���ο� �������� �����Ҷ� ĳ�� �޸𸮸� �ʱ�ȭ �ϴ� ��.
  NOCYCLE   ;       -- �������� �ִ밪�� ������ 1�� ���� �ʰ� �ϴ� ��.

DROP TABLE MEMBER;
DROP TABLE MEMBER_LEVEL;

CREATE TABLE MEMBER_LEVEL(
       LEVELNO NUMBER  (10) PRIMARY KEY,
     LEVELNAME VARCHAR (30) NOT NULL);

INSERT INTO MEMBER_LEVEL VALUES (-1, 'BLACK');
INSERT INTO MEMBER_LEVEL VALUES (0, '�Ϲ�');
INSERT INTO MEMBER_LEVEL VALUES (1, '�ǹ�');
INSERT INTO MEMBER_LEVEL VALUES (2, '���');

SELECT * FROM MEMBER_LEVEL; --  ��°� Ȯ�� 

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

INSERT INTO MEMBER VALUES (MEMBER_SEQ.NEXTVAL, 'ȫ�浿' , 'aa', 'hong@hong.com', 0, '22/03/10', 0 );  
INSERT INTO MEMBER VALUES (MEMBER_SEQ.NEXTVAL, '�ű浿' , 'bb', 'sin@sin.com', 1000, '22/03/10', 1 );

SELECT * FROM MEMBER;

COMMIT;

--�׽�Ʈ ��� ����
SELECT mNO, mNAME, mRDATE, mEMAIL, mPOINT, LEVELNAME
  FROM MEMBER M, MEMBER_LEVEL ML
  WHERE M.LEVELNO = ml.levelno;





