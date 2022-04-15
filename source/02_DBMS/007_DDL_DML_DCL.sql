-- [VII] DDL, DML, DCL
-- SQL = DDL (���̺� ����, ���̺� ����, ���̺�������, ���̺� ��� ������ ����)
--       DML (�˻� = SELECT, �߰� = INSERT, ���� = UPDATE, ���� = DELETE)
--       DCL (����ڰ�������, ����ڱ��Ѻο�, ���ѹ�Ż, ����ڰ�������)

-- *** DDL ***
-- 1. ���̺� ���� (CREATE TABLE)
CREATE TABLE BOOK(
  BOOKID NUMBER(4),         -- ������ȣ BOOKID �ʵ� Ÿ���� ���� 4�ڸ�
  BOOKNAME VARCHAR2(300),   -- �������� BOOKNAME �ʵ�� ���� 300 ����Ʈ
  PUBLISHER VARCHAR2(300),  -- ���ǻ� PUBLISHER �ʵ�� ���� 300 ����Ʈ
  RDATE     DATE,           -- ������ RDATE �ʵ�� DATE��
  PRICE     NUMBER(8),      -- ���� PRICE �ʵ�� ���� 8�ڸ�
  PRIMARY KEY(BOOKID));     -- BOOKID �� ��Ű/PRIMARY KEY ���� - NOT NULL, ������ �� �Է�.
  
SELECT * FROM BOOK;

DROP TABLE BOOK;
CREATE TABLE BOOK(
  BOOKID    NUMBER(4)    PRIMARY KEY, -- ������ȣ BOOKID �ʵ� Ÿ���� ���� 4�ڸ�
  BOOKNAME  VARCHAR2(20),             -- �������� BOOKNAME �ʵ�� ���� 300 ����Ʈ
  PUBLISHER VARCHAR2(20),             -- ���ǻ� PUBLISHER �ʵ�� ���� 300 ����Ʈ
  RDATE     DATE,                     -- ������ RDATE �ʵ�� DATE��
  PRICE     NUMBER(8) );              -- ���� PRICE �ʵ�� ���� 8�ڸ�
  
SELECT ROWNUM, EMPNO, ENAME FROM EMP; -- ROWNUM : ���̺��� �о���� ���� ����.
SELECT ROWNUM, ENAME FROM EMP WHERE DEPTNO = 20 ORDER BY ENAME;

-- EMP ���̺�� ������ EMP01 : EMPNO NUMBER(4) ENAME VARCHAR2(20), SAL   NUMBER(7, 2))
CREATE TABLE EMP01( 
            EMPNO NUMBER(4), 
            ENAME VARCHAR2(20), 
            SAL   NUMBER(7, 2)); -- 7�ڸ�, �Ҽ��� ���ڸ�
DESC EMP01;            
SELECT * FROM EMP01;

-- DEPT ���̺�� ������ DEPT01 : DEPTNO NUMBER(2, PK) DNAME VARCHAR2(42), SAL   LOC VARCHAR2(39)
CREATE TABLE DEPT01 (
       DEPTNO NUMBER(2),
       DNAME  VARCHAR2(15),
       LOC    VARCHAR2(39),
       PRIMARY KEY(DEPTNO) );
DESC DEPT01;       
-- ���������� �̿��� ���̺� ����
SELECT * FROM TAB ; -- SCOTT�� ������ ���̺� ��ȸ
CREATE TABLE EMP02 AS SELECT * FROM EMP; --�������� ����� EMP02 ���̺� ������ �� (���������� ������.)

--EX. EMP03 : EMP ���̺��� EMPNO, ENAME, DEPTNO�� ������ �����ͷ� ���̺� ����
CREATE TABLE EMP03 AS SELECT EMPNO, ENAME, DEPTNO FROM EMP;
SELECT * FROM EMP03;

--EX. EMP04 : EMP  ���̺��� 10�� �μ��� ������ �����ͷ� ���̺�
CREATE TABLE EMP04 AS SELECT * FROM EMP WHERE DEPTNO=10;
SELECT * FROM EMP04;

--EX. EMP05 : EMP  ���̺��� ���̺� ������ ����
CREATE TABLE EMP05 AS SELECT * FROM EMP WHERE 1=0; 
-- Ȥ�ö� �ʵ忡 �������� �ʴ� ���� ������ ���߿� INSERT �� �� �־ �ƿ� �������� �Ұ����� ������ �־ ������ �����Ѵ�.
SELECT * FROM EMP05;

-- 2. ���̺� �������� (ALTER TABLE)
-- ALTER TABLE ���̺�� ADD || MODIFY || DROP -
-- 2. 1. �ʵ� �߰� (ADD)
SELECT * FROM EMP03; -- EMPNO, ENAME, DEPTNO
ALTER TABLE EMP03 ADD (JOB VARCHAR2 (30), SAL NUMBER(7,2));
ALTER TABLE EMP03 ADD (COMM NUMBER(7, 2));
SELECT * FROM EMP03; -- �߰��� �ʵ忡�� NULL�� ���� �߰��� �ʵ�� EMP���� ���� ���� �ʾұ� ����.

--2. 2. �ʵ� ���� (MODIFY)
SELECT * FROM EMP03; -- EMPNO, ENAME, DEPTNO, / JOB, SAL, COMM = NULL
DESC EMP03;
ALTER TABLE EMP03 MODIFY (EMPNO VARCHAR2 (4)); -- ���ڵ����Ͱ� �� �ִ� ���¿��� ���ڷθ� ���� ����
ALTER TABLE EMP03 MODIFY (EMPNO NUMBER (3)); -- ����, ���� �ʵ庸�� �ڸ����� ����
ALTER TABLE EMP03 MODIFY (EMPNO NUMBER (6)); -- ����
SELECT MAX(LENGTH(ENAME)) FROM EMP;
ALTER TABLE EMP03 MODIFY (ENAME VARCHAR2 (300));
DESC EMP03;

--2. 3. �ʵ� ���� (DROP) : �ʵ� ��ü�� ����.
ALTER TABLE EMP03 DROP COLUMN JOB;
SELECT * FROM EMP03;
-- �������� Ư�� �ʵ带 ���� ���ϵ��� (��)
ALTER TABLE EMP03 SET UNUSED(DEPTNO);
SELECT * FROM EMP03;
-- �������� ���� ���� �ʵ带 ���������� ���� (����)
ALTER TABLE EMP03 DROP UNUSED COLUMNS;


--3. ���̺� ���� (DROP TABLE)
DROP TABLE EMP01;
DROP TABLE DEPT; -- �ٸ� ���̺��� �����ϴ� �����Ͱ� ���� ��� DROP �ȵ�.

--4. ���̺��� ��� ���� ���� (TRUNCATE)
SELECT * FROM EMP03;
TRUNCATE TABLE EMP03; -- EMP03���� ��� �����Ͱ� ����. (��ҺҰ�.)
SELECT * FROM EMP03;

--5. ���̺�� ���� (RENAME ���̸� TO ���̸�)
SELECT * FROM EMP02;
RENAME EMP02 TO EMP2;

--6. ������ ��ųʸ� (����Ŭ �ý��۸� �׼��� ���� ) VS ������ ��ųʸ� �� (����� ���ٿ�)
-- ����
-- USER_XXX : �� ������ �����ϰ� �ִ� ��ü (TABLE INDEX CONSTRAINT VIEW) 
--       EX. USER_TABLES   USER_INDEXES  USER_CONSTRAINTS  USER_VIEWS
-- ALL_XXX : �� ������ ���� ������ ��ü TABLE INDEX CONSTRAINT VIEW)
--       EX. ALL_TABLES   ALL_INDEXES  ALL_CONSTRAINTS  ALL_VIEWS
-- DBA_XXX : DBA�����ڸ� ���� ����. DBMS�� ��� ��ü
--       EX. DBA_TABLES   DBA_INDEXES  DBA_CONSTRAINTS  DBA_VIEWS
SELECT * FROM DBA_TABLES;
SELECT * FROM DBA_INDEXES;
SELECT * FROM DBA_CONSTRAINTS;
SELECT * FROM DBA_VIEWS;
SELECT * FROM ALL_TABLES;
SELECT * FROM ALL_INDEXES;
SELECT * FROM ALL_CONSTRAINTS;
SELECT * FROM ALL_VIEWS;
SELECT * FROM USER_TABLES;       -- �� ������ ������ ���̺� ��ü ����
SELECT * FROM USER_INDEXES;      -- �� ������ ������ �ε��� ����
SELECT * FROM USER_CONSTRAINTS;  -- �� ������ ������ ���� ����
SELECT * FROM USER_VIEWS;        -- �� ������ ������ �� ����

--- *** DCL (����ڰ�������, ����ڱ��Ѻο�, ���ѹ�Ż, ����� ��������) ***

CREATE USER scott2 IDENTIFIED BY 1234;
-- ���Ѻο� (���Ǳ���, scott.EMP, scott.DEPT ���̺� ���� ��� ����)

GRANT CREATE SESSION TO scott2; 
GRANT ALL ON EMP TO scott2; -- EMP ���̺� ���� ��� ���� (�˻�, �߰�, ����, ����) 
GRANT ALL ON DEPT TO scott2; -- DEPT ���̺� ���� ��� ���� (�˻�, �߰�, ����, ����)
SHOW USER;

-- ���� ��Ż (������ ��Ż�� ������ ���������� �� ���¿��� ����)
REVOKE ALL ON EMP FROM SCOTT2; -- SCOTT�� �ִ� EMP ��� ���� ��Ż.
REVOKE ALL ON DEPT FROM SCOTT2; -- SCOTT�� �ִ� DEPT ��� ���� ��Ż.
SHOW USER;

-- ����� ���� ���� (�������� ���� ���� �Ұ�)
DROP USER SCOTT2 CASCADE;


-- *** DML (SELECT, INSERT, UPDATE, DELETE)***

-- 1. INSERT INTO ���̺�� VALUES (��1, ��2, ��3, ��4, ��5 .....);
--    INSERT INTO ���̺�� (�ʵ��1, �ʵ��2, ....) VALUES (��1, ��2, ��3, ��4, ��5 .....);
SELECT * FROM DEPT01;
INSERT INTO DEPT01 VALUES (50, 'ACCOUNTING', 'NEW YORK');
INSERT INTO DEPT01 (DEPTNO, DNAME, LOC) VALUES (60, 'IT', 'SEOUL');
INSERT INTO DEPT01 (DEPTNO, DNAME) VALUES (70, 'OPERATION');
INSERT INTO DEPT01 (DEPTNO, DNAME, LOC) VALUES (80, 'HR', NULL); -- ��������� NULL �߰�
INSERT INTO DEPT01 VALUES (90, 'SALES', NULL); -- ��������� NULL �߰�

-- ���������� �̿��� INSERT
INSERT INTO DEPT01 SELECT * FROM DEPT;

SELECT * FROM DEPT01 ORDER BY DEPTNO;

-- Ʈ����� ��ɾ� (DML ��ɾ)
COMMIT;

-- SAM01 ���̺� �ۼ� ��Ű�� EMPNO

CREATE TABLE SAM01 (
       EMPNO NUMBER(4) CONSTRAINTS SAM_PK PRIMARY KEY,
       ENAME VARCHAR2(10),
       JOB   VARCHAR2(9),
       SAL   NUMBER(7,2));

INSERT INTO SAM01 VALUES (1000, 'APPLE', 'POLICE', 10000);
INSERT INTO SAM01 VALUES (1010, 'BANANA', 'NURSE', 15000);
INSERT INTO SAM01 VALUES (1020, 'ORANGE', 'DOCTOR', 25000);
INSERT INTO SAM01 VALUES (1030, 'VERY', NULL , 25000);
INSERT INTO SAM01 VALUES (1040, 'CAT', NULL, 2000);
INSERT INTO SAM01 (SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE DEPTNO=10);

SELECT * FROM SAM01;
SELECT * FROM USER_CONSTRAINTS;
COMMIT;
DROP TABLE SAM01;

-- 2. UPDATE ���̺�� SET �ʵ��1 = ��1 �ʵ�� 2 ��2 [WHERE ����];
DROP TABLE EMP01;

CREATE TABLE EMP01 AS SELECT * FROM EMP;

-- EMP01 ���̺��� ��� ����� SAL�� 10% �λ�
UPDATE EMP01 SET SAL = 1.1*SAL WHERE SAL IS NOT NULL;

-- 10�� �μ��� ������ �Ի����� ���÷�, �μ���ȣ�� 30���� ����
UPDATE EMP01 SET HIREDATE = SYSDATE, DEPTNO = 30
WHERE DEPTNO = 10;

-- EMP01 ���̺��� �޿��� 3000�̻��� ����� SAL�� 10% �λ�
UPDATE EMP01 SET SAL = 1.1*SAL WHERE SAL >= 3000;



-- 'DALLAS'�� �ٹ��ϴ� ������ �޿��� 1000�� �λ� (�����������)

UPDATE EMP01 SET SAL = (SAL+1000) 
WHERE DEPTNO = (SELECT DEPTNO FROM  DEPT WHERE LOC = 'DALLAS');

--SCOTT�� �μ���ȣ�� 20����, JOB�� MANAGER��, SAL�� COMM�� 500�� �λ�, ���� ��縦 KING���� ����

UPDATE EMP01 SET DEPTNO=20 ,
                 JOB = 'MANAGER',
                 SAL = SAL+500,
                COMM = NVL(COMM, 0)+500,
                 MGR =(SELECT EMPNO FROM EMP WHERE ENAME  = 'KING')
                 WHERE ENAME = 'SCOTT';
                 
SELECT * FROM EMP01;
-- DEPT01���� 20�� �μ� �������� DEPT ���̺��� 60�� �μ� ���������� ����   
UPDATE DEPT01 SET LOC =(SELECT LOC FROM DEPT WHERE DEPTNO=60)
              WHERE DEPTNO>=20;
              
SELECT * FROM DEPT01;   -- DEPT 60�� �μ��� ��� NULL������ ����.

-- EMP01 ���̺��� ��� ����� �޿��� �Ի����� 'KING'�� �޿��� �Ի��Ϸ� ����;
SELECT * FROM EMP01;
UPDATE EMP01
SET (SAL, HIREDATE) = (SELECT SAL, HIREDATE FROM EMP WHERE ENAME = 'KING');

-- DEPT01 ���̺��� 20�� �μ��� ������� �μ����� 40�� �μ��� ������� �μ������� ����
UPDATE DEPT01
SET (LOC, DNAME) = (SELECT LOC, DNAME FROM DEPT01 WHERE DEPTNO=40)
WHERE DEPTNO = 20;
COMMIT;
SELECT * FROM DEPT01 ORDER BY DEPTNO;

--3. DELETE FROM ���̺�� [WHERE ����];

SELECT * FROM EMP01; 
DELETE FROM EMP01;
ROLLBACK;

  --EX. EMP01���̺��� 'FORD'�� ����� ����
DELETE FROM EMP 01 WHERE ENAME = 'FORD';  

  --EX. EMP01 ���̺��� 30�� �μ� ������ ����
DELETE FROM EMP01 WHERE DEPTNO=30;
ROLLBACK;

  --EX. EMP01 ���̺��� �μ����� RESEARCH �μ��� ������ ����
  DELETE FROM EMP01 
  WHERE DEPTNO=(SELECT DEPTNO FROM DEPT WHERE DNAME = 'RESEARCH');
  
  --EX. SAM01 ���̺��� JOB�� �������� ���� ����� ����
  DELETE FROM SAM01 WHERE JOB IS NULL;
  
  --EX. SAM01 ���̺��� �̸��� ORANGE�� ����� ���� 
  DELETE FROM SAM01 WHERE ENAME = 'ORANGE';



CREATE TABLE MY_DATA (
       ID NUMBER(4) PRIMARY KEY,
       NAME VARCHAR2(10),
       USERID   VARCHAR2(30),
       SALARY   NUMBER(10,2));
INSERT INTO MY_DATA VALUES ( 1, 'Scott', 'sscott', 10000);
INSERT INTO MY_DATA VALUES ( 2, 'Ford', 'fford', 13000);
INSERT INTO MY_DATA VALUES ( 3, 'Patel', 'ppatel', 33000);
INSERT INTO MY_DATA VALUES ( 4, 'Report', 'rreport', 23500);
INSERT INTO MY_DATA VALUES ( 5, 'Good', 'ggood', 44450);

SELECT ID, NAME, USERID, TO_CHAR(SALARY, '999,999.99') "SALARY" FROM MY_DATA ;
COMMIT;

UPDATE MY_DATA SET  SALARY = 65000  WHERE ID = 3;
COMMIT;

DELETE MY_DATA WHERE NAME = 'Ford';
COMMIT;

UPDATE MY_DATA SET SALARY = 15000 WHERE SALARY <15000;
COMMIT;

DROP TABLE MY_DATA;


SELECT * FROM MY_DATA;
















