SELECT * FROM DEPT;
DELETE FROM DEPT WHERE DEPTNO = 55;
ROLLBACK;

INSERT INTO DEPT VALUES (77, 'IZONE', 'WIZONE');
SELECT * FROM DEPT;

--�μ����� �Է¹޾� �ش� �μ��� ����� ���, �̸�, ��å, �޿��� ���

SELECT EMPNO, ENAME, JOB, SAL
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND DNAME=UPPER('SALES');
    
SELECT * FROM DEPT;    

-- 1�� ������ ������ �Է�
-- �̸�, ������, ����, ����, ���������� �Է¹޾� 
-- ������ ���̽��� ��ȣ�� �����Ͽ� �Է��Ѵ�.
-- ��ȣ�� �������� �̿��Ͽ� ���������� �Է��Ѵ�. �����ͺ��̽��� ������ ������ ����

DROP TABLE JOB;
CREATE TABLE JOB (
    jNo NUMBER (10) PRIMARY KEY,
    jName VARCHAR2(100)
    );
INSERT INTO JOB VALUES (10, '���');
INSERT INTO JOB VALUES (20, '����');


SELECT * FROM JOB;    

COMMIT;

DROP TABLE PERSON;
CREATE TABLE PERSON(
    pNO NUMBER(10) PRIMARY KEY,
    pNAME VARCHAR2(50),
    jNo NUMBER(10) REFERENCES JOB(jNO),
    KOR NUMBER(10) NOT NULL,
    ENG NUMBER(10) NOT NULL,
    MAT NUMBER(10) NOT NULL
    );

 

DROP SEQUENCE PERSON_SEQ;
CREATE SEQUENCE PERSON_SEQ
  MAXVALUE 9999     -- �ִ밪
  MINVALUE 1        -- �ּҰ�
  NOCACHE           -- ���ο� �������� �����Ҷ� ĳ�� �޸𸮸� �ʱ�ȭ �ϴ� ��.
  NOCYCLE   ;

INSERT INTO PERSON VALUES (PERSON_SEQ.nextval, '���켺', 10, 90, 80, 81);

SELECT * FROM PERSON; 




