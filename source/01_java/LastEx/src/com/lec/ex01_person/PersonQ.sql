-- ���̺� ���� (���� �̸��� ���̺��� �����Ǿ��� ��� DROP)
-- ���̵�����
SELECT * FROM PERSON;
SELECT * FROM JOB;
DROP TABLE JOB;
CREATE TABLE JOB (
    JNO NUMBER (10) PRIMARY KEY ,
    JNAME VARCHAR2(50) NOT NULL
    );
INSERT INTO JOB VALUES (10, '���');
INSERT INTO JOB VALUES (20, '����');
INSERT INTO JOB VALUES (30, '����');

DROP TABLE PERSON;
CREATE TABLE PERSON(
    pNO NUMBER(10) PRIMARY KEY,
    pNAME VARCHAR2(50),
    JNO NUMBER (10) REFERENCES JOB(JNO),
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
INSERT INTO PERSON VALUES (PERSON_SEQ.NEXTVAL, '���켺', 10, 90, 80, 81);
INSERT INTO PERSON VALUES (PERSON_SEQ.NEXTVAL, '�ڼ���', 10, 80, 90, 80);
INSERT INTO PERSON VALUES (PERSON_SEQ.NEXTVAL, '�����', 20, 50, 90, 90);
INSERT INTO PERSON VALUES (PERSON_SEQ.NEXTVAL, '����', 20, 95, 95, 95);
INSERT INTO PERSON VALUES (PERSON_SEQ.NEXTVAL, '������', 10, 100, 80, 95);

SELECT * FROM PERSON;
SELECT * FROM JOB;

-- 1�� : PNAME, JNAME, KOR, ENG, MAT �Է¹޾� INSERT
SELECT PNO "��ȣ", PNAME "�̸�", JNAME "������" , KOR "��������", ENG "��������", MAT "��������"
    FROM PERSON P, JOB J WHERE P.JNO = J.JNO;
INSERT INTO PERSON VALUES
   (PERSON_SEQ.NEXTVAL, '���켺', (SELECT JNAME FROM JOB WHERE JNO = 10) , 90, 80, 81);
SELECT JNAME FROM JOB WHERE JNO = 10;
-- 2�� : �������� �Է¹޾� �ش� ������ ���, �̸�, ������, ����, ����, ����, ������ ����ϰ�
--       ������������ �������� ����
SELECT  ROWNUM ||'��' "���", PNAME||'('||PNO||'��)' "�̸�(��ȣ)", JNAME "������" , 
        KOR "��������", ENG "��������", MAT "��������", KOR+ENG+MAT "����"
    FROM 
    (SELECT * FROM PERSON P, JOB J WHERE P.JNO = J.JNO AND JNAME = '���' 
     ORDER BY KOR+ENG+MAT DESC);

-- 3�� : �����ͺ��̽��� �Էµ� ��� ����� ���, �̸�, ������, ����, ����, ����, ������ ����ϰ�
--       ������������ �������� ����
SELECT  ROWNUM ||'��' "���", PNAME||'('||PNO||'��)' "�̸�(��ȣ)", JNAME "������" , 
        KOR "��������", ENG "��������", MAT "��������", KOR+ENG+MAT "����"
    FROM 
    (SELECT * FROM PERSON P, JOB J WHERE P.JNO = J.JNO 
     ORDER BY KOR+ENG+MAT DESC);
  
     
DROP TABLE JOB;
CREATE TABLE JOB (
    JNO NUMBER (10) PRIMARY KEY ,
    JNAME VARCHAR2(50) NOT NULL
    );
INSERT INTO JOB VALUES (10, '���');
INSERT INTO JOB VALUES (20, '����');
INSERT INTO JOB VALUES (30, '����');

DROP TABLE PERSON;
CREATE TABLE PERSON(
    pNO NUMBER(10) PRIMARY KEY,
    pNAME VARCHAR2(50),
    JNO NUMBER (10) REFERENCES JOB(JNO),
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
    
COMMIT; 

SELECT * FROM PERSON;
SELECT * FROM JOB;