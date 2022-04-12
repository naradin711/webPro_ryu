-- [IV] ������ �Լ� ; �����Լ�, SQL �ֿ��Լ�
-- �Լ� => ������ �Լ� + �׷��Լ�(�����Լ�)
  -- ������ �Լ� (INPUT 1�� -> OUTPUT 1��)
SELECT HIREDATE, TO_CHAR(HIREDATE, 'YY"��"MM"��"DD"��"') FROM EMP; -- ������ �Լ�
SELECT ENAME, INITCAP (ENAME) FROM EMP; -- ù���ڸ� �빮��.
  -- �׷��Լ� (INPUT N�� -> OUTPUT 1��) - 5�忡�� �� ����.
SELECT SUM (SAL), ROUND(AVG(SAL), 2) FROM EMP; -- SAL 14���� ��� ���� ���ؼ� SUM �Լ� AVG(���)�Լ�
SELECT DEPTNO, SUM (SAL) FROM EMP GROUP BY DEPTNO; -- �μ��� SAL�� ��


-- �������Լ��� ���� : ���ڰ����Լ�, ���ڰ����Լ�, ��¥���õ��Լ�(�����), ����ȯ�Լ�, NVL(), ETC...

--1. ���� �����Լ�
  --DUAL ���̺� : ����Ŭ���� �����ϴ� 1�� 1��¥�� DUMMY TABLE
DESC DUAL;
DESC DUMMY;
SELECT * FROM DUAL; -- ����Լ��� �ϰ� ������ ���̺��� �����ϴ� DUMMY TABLE
SELECT * FROM DUMMY; -- DUAL�� ������ �� ���̺��� ����� ���̺�� ��� ����.
SELECT -9, ABS (-9) FROM DUAL;
SELECT FLOOR(34.5678) FROM DUAL;
SELECT FLOOR(34.5678*100)/100 FROM DUAL;  -- �Ҽ��� 2��° �ڸ����� ����
SELECT TRUNC(34.5678, 2) FROM DUAL;       -- �Ҽ��� 2��° �ڸ����� ����
SELECT TRUNC(34.5678) FROM DUAL;          -- �Ҽ������� ����
SELECT TRUNC(34.5678, -1) FROM DUAL;      -- ���� �ڸ����� ����

  --EX. EMP���̺��� �̸�, �޿�(���� �ڸ����� ����)
SELECT ENAME, TRUNC(SAL, -2) "�޿�", SAL FROM EMP;  

SELECT CEIL(34.5678) FROM DUAL;           -- �Ҽ������� �ø�
SELECT CEIL(34.5678*100)/100 FROM DUAL;   -- �Ҽ��� 2��° �ڸ����� �ø�

SELECT ROUND(34.5678) FROM DUAL;          -- �Ҽ������� �ݿø�
SELECT ROUND(34.5678, 2) FROM DUAL;       -- �Ҽ��� �ι�° �ڸ����� �ݿø�
SELECT ROUND(34.5678, -1) FROM DUAL;      -- ���� �ڸ����� �ݿø�

SELECT MOD (9, 2) FROM DUAL;              -- 9%2 ������ ������.

  --EX. ����� Ȧ���� ����� ��� �ʵ� ���!
SELECT * FROM EMP WHERE MOD (EMPNO, 2) = 1; 

  --EX. Ȧ���޿� �Ի��� ����� ��� �ʵ� ���
SELECT * FROM EMP WHERE MOD (TO_CHAR (HIREDATE, 'MM'),2 ) = 1;

-- 2. ���ڰ����Լ�
-- (1) ��ҹ��� ����
SELECT UPPER (' abcABC') FROM DUAL;
SELECT LOWER (' abcABC') FROM DUAL;
SELECT INITCAP ('WELCOME TO ORACLE') FROM DUAL;
  --EX. JOB�� ��ҹ��������� �𸣳� 'MANAGER'�� ��� �ʵ� ���
SELECT * FROM EMP WHERE UPPER(JOB) = 'MANAGER'; --JOB�� �ִ� ��� ���ڿ��� �빮��ȭ 
SELECT * FROM EMP WHERE LOWER(JOB) = 'manager'; --JOB�� �ִ� ��� ���ڿ��� �ҹ���ȭ
SELECT * FROM EMP WHERE INITCAP(JOB) = 'Manager';

-- (2) ���ڿ��� (CONCAT, || ������)
SELECT 'AB' || 'CD' || 'EF' || 'GH' FROM DUAL;
SELECT CONCAT(CONCAT('AB', 'CD'), CONCAT ('EF','GH')) FROM DUAL;

  --EX. �ƹ���(ENAME)�� ����(JOB)�̴� �������� EMP M ���̺� ���� ���
SELECT CONCAT(CONCAT(ENAME, '�� '), CONCAT ( JOB,'�̴�')) FROM EMP; 

-- (3) SUBSTR(STR, ������ġ, ���ڰ���) ù��° ��ġ�� 1, ������ġ�� ������ ����.
-- SUBSTRB(STR, ���۹���Ʈ��ġ, ���ڹ���Ʈ��)
SELECT SUBSTR ('ORACLE', 3, 2) FROM DUAL; -- 3��° ���ں��� 2���ھ� ����
SELECT SUBSTRB ('ORACLE', 3, 2) FROM DUAL; --3��° ����Ʈ���� 2����Ʈ ����
SELECT SUBSTR ('�����ͺ��̽�', 4,3) FROM DUAL; 
SELECT SUBSTRB ('�����ͺ��̽�', 4,3) FROM DUAL; --4��° ����Ʈ ���� 3����Ʈ ���� �ѱ��� ��� �ѱ��ڰ� 3����Ʈ
SELECT SUBSTRB ('ȫ�浿', 3) FROM DUAL ;
SELECT SUBSTR('ABCDXD', -1 , 1) FROM DUAL;
SELECT SUBSTR (123, 2, 1) FROM DUAL; -- ���ڵ� ����.
  --EX. 9���� �Խ��� ����� ��� �ʵ� (�� DATE ��� FORMAT 'RR/MM/DD')
SELECT * FROM EMP WHERE SUBSTR (HIREDATE, 4, 2 )= '09';
  --EX. 9�Ͽ� �Խ��� ����� ��� �ʵ� (�� DATE ��� FORMAT 'RR/MM/DD')

-- ���ڼ� LENGH, NOT LENGTH VS ����Ʈ�� (LENTHB)
SELECT LENGTH ('ABC') FROM DUAL; -- ���ڼ� 3
SELECT LENGTHB ('ABC') FROM DUAL; -- ����Ʈ 3
SELECT LENGTH ('����Ŭ') FROM DUAL; -- ���ڼ� 3
SELECT LENGTHB ('����Ŭ') FROM DUAL; -- ����Ʈ 9

-- (5) INSTR(STR, ã�� ����) : STR�� ���� ã�� ������ ��ġ ù��° 1 ������ 0
--     INSTR(STR, ã�� ����,  ������ġ) : STR�� ������ġ���� ã�Ƽ� ã�� ������ ��ġ, ��ġ ���� ����
SELECT INSTR ('ABCABC', 'B' ) FROM DUAL; -- ó������ ã�Ƽ� ó�������� ã������ ��ȯ
SELECT INSTR ('ABCABC', 'B', 3 ) FROM DUAL; -- �� 3��° ���� ã�Ƽ� ó�� ������ ���� ��ȯ
SELECT INSTR ('ABCABC', 'B', -3 ) FROM DUAL; -- �� 3��°���� ã�Ƽ� �ڿ��� ������ ã�Ƽ� ó�� ������ ���� ��ġ

  -- EX. 9���� �Ի��� ����� ��� �ʵ� (INSTR)
SELECT * FROM EMP WHERE INSTR(HIREDATE, '09', 4) =4;
 -- EX. 9�Ͽ� �Ի��� ����� ��� �ʵ� (INSTR)
SELECT * FROM EMP WHERE INSTR(HIREDATE, '09', 7) =7;
 -- EX. 9���� �ƴѳ��� �Ի��� ����� ��� �ʵ� (INSTR)
SELECT * FROM EMP WHERE INSTR(HIREDATE, '09', 7) =0;

-- (6) LPAD(STR, �ڸ���, ä�﹮��) STR�� �ڸ��� ��ŭ Ȯ���ϰ� ���� ���ڸ��� ä�� ���� ���
--     RPAD(STR, �ڸ���, ä�﹮��) STR�� �ڸ��� ��ŭ Ȯ���ϰ� ���� ���ڸ��� ä�� ���� ���

SELECT LPAD ('ORACLE', 10, '#') FROM DUAL;
SELECT RPAD ('ORACLE', 10, '#') FROM DUAL;
SELECT ENAME, SAL, LPAD (SAL, 6, '*') FROM EMP;

  -- EX. ���, �̸� ��� (7788 S****, �̸��� �� �ѱ��ڸ� ����ϰ� �������� *)
 SELECT EMPNO, RPAD ((SUBSTR (ENAME, 1,1)), LENGTH(ENAME), '*') "�̸�" FROM EMP;
 
  -- EX. ���, �̸�, �Ի��� (�̸��� 10�ڸ� Ȯ���ϸ鼭 �̸� ���ڼ� ��ŭ * �� ������ ���ڸ� ���)
  -- EX. 7892. ______****H 80/12/** 

SELECT EMPNO, LPAD(LPAD((SUBSTR (ENAME, -1,1)), LENGTH(ENAME), '*'), 10, '_') "NAME", TO_CHAR (HIREDATE, 'YY/MM/**') "HIREDATE" FROM EMP;
SELECT RPAD (SUBSTR (HIREDATE,1,6),LENGTH(HIREDATE),'*') FROM EMP;

  -- EX. �̸��� ����° �ڸ��� R�� ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME LIKE '__R%';
SELECT * FROM EMP WHERE INSTR(ENAME, 'R', 3)=3;
SELECT * FROM EMP WHERE SUBSTR (ENAME, 3,1)='R';

-- (7) ��������
SELECT TRIM('      ORACLE    ')FROM DUAL;
SELECT RTRIM('  ORACLE   ')FROM DUAL;
SELECT LTRIM('  ORACLE   ')FROM DUAL;

-- (8) ��ü�ϱ�

SELECT REPLACE (ENAME, 'A', 'XX') FROM EMP;
SELECT REPLACE (HIREDATE, '0', '_') FROM EMP;

-- 3. ��¥ ���� �Լ� �� ����
-- (1). SYSDATE : ����
SELECT SYSDATE FROM DUAL;
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD DY HH24:MI:SS';
SELECT SYSDATE FROM DUAL;
SELECT ENAME, HIREDATE FROM EMP;
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD'; -- ���󺹱�
SELECT TO_CHAR (SYSDATE, 'YYYY/MM/DD DY HH24:MI:SS') "TIMENOW" FROM DUAL;
SELECT SYSDATE-1 "���� �̽ð�", SYSDATE "����", SYSDATE+1 "�����̽ð�"  FROM DUAL; --

--(2) ��¥ ��� : 14�� ��
SELECT SYSDATE+14 "�ݳ�������" FROM DUAL;

  --EX. �̸�, �Ի���, �ٹ��ϼ� 
SELECT ENAME "�̸�", HIREDATE "�Ի���", FLOOR(SYSDATE-HIREDATE)||'��' "�ٹ��ϼ�" FROM EMP;  
SELECT ENAME "�̸�", HIREDATE "�Ի���", FLOOR((SYSDATE-HIREDATE)/7)||'��' "�ٹ��ּ�" FROM EMP; 
SELECT ENAME "�̸�", HIREDATE "�Ի���", FLOOR((SYSDATE-HIREDATE)/365)||'��' "�ٹ����" FROM EMP; 

--(3) MONTHS_BETWEEN (��¥, ��¥) : �� ��¥���� ������
  -- EX. �̸�, �Ի���, �ٹ�����
SELECT ENAME, HIREDATE, FLOOR(MONTHS_BETWEEN(SYSDATE, HIREDATE))|| '����' "�ٹ�����" FROM EMP; 
  
  -- EX. �̸�, �Ի��� ���� ���� �޿��� �󿩱� SAL �Ŵ�, COMM�� �ų� 2ȸ��
SELECT ENAME,  FLOOR(MONTHS_BETWEEN(SYSDATE, HIREDATE))* SAL "�� �޿�", FLOOR((SYSDATE-HIREDATE)/365)*2*NVL(COMM, 0) "�� �󿩱�" FROM EMP;

-- (4) ADD_MONTHS(��¥, ������) : Ư���������� ��� ���� ��¥.
  -- EX. �̸�, �Ի���, ���������� (�����Ⱓ�� �Ի��Ϸκ��� 6������ �Ѵ�.)
SELECT ENAME, HIREDATE, ADD_MONTHS(HIREDATE, 6) "����������" FROM EMP;

-- (5) LAST_DAY (Ư����¥) : Ư����¥ ���� ������ ���
SELECT LAST_DAY(SYSDATE) FROM DUAL;
  -- EX. �̸�, �Ի���, ù ���� (���޳��� ����)
SELECT ENAME, HIREDATE, LAST_DAY(HIREDATE) "���޳�" FROM EMP;

--(6) ROUND (��¥, XX) : ��¥ �ݿø� / TRUNC (��¥, XX) : ��¥ ����
SELECT ROUND (SYSDATE, 'YEAR') FROM DUAL; -- ��� �����⵵�� 1�� 1��
SELECT ROUND (SYSDATE, 'MONTH') FROM DUAL; --  ��� ����� ���� 1�� 15�ϱ����� �ش� �� 16�Ϻ��ʹ� ���� ��.
SELECT ROUND (SYSDATE, 'DAY') FROM DUAL; -- ����� ����� �Ͽ��� �����ϱ����� ���� �Ͽ��� ����ʹ� ���� �Ͽ���
SELECT ROUND (SYSDATE) FROM DUAL; -- ��� ����� 0��
SELECT TO_CHAR (ROUND (SYSDATE) , 'YYYY/MM/DD DY HH24:MI:SS') FROM DUAL; --���� ���� ���� ���� ���� ������

SELECT TRUNC (SYSDATE, 'YEAR') FROM DUAL; -- ���� 1�� 1��
SELECT TRUNC (SYSDATE, 'MONTH') FROM DUAL; --  �̹��� 1��
SELECT TRUNC (SYSDATE, 'DAY') FROM DUAL; -- ���� �Ͽ���
SELECT TRUNC (SYSDATE) FROM DUAL; -- ��� ���� 0��
SELECT TO_CHAR (ROUND (SYSDATE) , 'YYYY/MM/DD DY HH24:MI:SS') FROM DUAL; --���� ���� ���� ���� ���� ������

  --  EX. �̸�, �Ի���, �Ի��� ���� 5��
SELECT ENAME, HIREDATE, TRUNC(HIREDATE, 'MONTH')+4 FROM EMP;  
  --  EX. �̸�, �Ի���, ���޳� (���޳��� �Ŵ� 16��)
SELECT ENAME, HIREDATE, TO_CHAR(ROUND(HIREDATE, 'MONTH')+15 , 'MM/DD' ) "���޳�" FROM EMP;
  --  EX. �̸�, �Ի���, ���޳� (���޳��� �Ŵ� 15��)
SELECT ENAME, HIREDATE, TO_CHAR(ROUND(HIREDATE+1, 'MONTH')+14 , 'MM/DD' ) "���޳�" FROM EMP;
--  EX. �̸�, �Ի���, ���޳� (���޳��� �Ŵ� 5��)
SELECT ENAME, HIREDATE, TO_CHAR(ROUND(HIREDATE+11, 'MONTH')+4 , 'MM/DD' ) "���޳�" FROM EMP;
--  EX. �̸�, �Ի���, ���޳� (���޳��� �Ŵ� 20��)
SELECT ENAME, HIREDATE, TO_CHAR(ROUND(HIREDATE-4, 'MONTH')+19 , 'MM/DD' ) "���޳�" FROM EMP;

--(7) NEXT_DAY (��¥, '��') : Ư����¥�κ��� ó�� �����ϴ� ������
SELECT SYSDATE, NEXT_DAY(SYSDATE, '��') FROM DUAL;

-- 4. ����ȯ �Լ� (����<>����, ����<>��¥)
-- (1) TO_CHAR(��¥��������, '�������')
   -- YYYY(�⵵ 4�ڸ�), YY/RR (�⵵ 2�ڸ�), MM (��) DD(��) DAY(����)/DY(���� ���)
   -- AM/PM (����/����) HH12/HH24 (�ð�) MI(��) SS(��)
SELECT TO_CHAR(SYSDATE,' YY "��" MM "��"  DD"��  " DY HH24"��"  MI"��" SS"��" ' ) FROM DUAL;  
-- (2) TO_CHAR(���ڵ�����, '�������')
  -- 0 : �ڸ���, ��������� �ڸ����� ������ 0���� ä��
  -- 9 : �ڸ���, ��������� �ڸ����� ���Ƶ� ���ڸ�ŭ�� �Է�.
  -- , : ���ڸ�����, ����
  -- . : �Ҽ���
  -- $ : ��ȭ������ �տ� ������ ����
  -- L : ������ȭ������ �տ� ����
SELECT TO_CHAR (123456, '9,999,999.99') FROM DUAL;  
SELECT TO_CHAR (123456, '0,000,000.00') FROM DUAL; -- ���⿡�� ���ڸ� 0�� �ڵ� ���
SELECT TO_CHAR (10000, 'L999,999') FROM DUAL; -- �ý��ۿ��� ������ �о ��ȭ���� �ڵ� ���
SELECT ENAME, TO_CHAR (SAL, '$99,999') FROM EMP; -- �޷��� ����
SELECT ENAME, TO_CHAR (SAL, '$99,999') FROM EMP;

--3. TO_DATE (���ڵ�����, '����')
SELECT TO_DATE('20220412', 'YYYY-MMDD') FROM DUAL;
  -- EX. 81/5/1 ~83/5/1 ���̿� �Ի��� ������ ��� �ʵ� (TO_DATE)���
SELECT * FROM EMP
  WHERE HIREDATE BETWEEN TO_DATE ('810501', 'RRMMDD')AND TO_DATE ('830501', 'RRMMDD');
  
--4. TO_NUMBER (����, '����')  
SELECT '1234'+1 FROM DUAL;
SELECT TO_NUMBER('1,234', '9,999')+1 FROM DUAL;

--5. NVL (NULL �ϼ��� �մ� ������, NULL�̸� ����� ��) - �Ű����� 2���� Ÿ�� ��ġ �ؾ���.
SELECT ENAME, NVL(COMM, 0) FROM EMP;
 -- EX. �̸�, ����� ����� ����ϵ� ����� ����� NULL�� ��� 'CEO'�� ���
SELECT ENAME, NVL(TO_CHAR (MGR), 'CEO') FROM EMP;

--6. ETC
-- (1) EXTRACT
SELECT EXTRACT (YEAR FROM SYSDATE) FROM DUAL;
SELECT TO_CHAR (SYSDATE, 'YYYY') FROM DUAL;
SELECT EXTRACT (MONTH FROM HIREDATE) FROM EMP;
SELECT EXTRACT (DAY FROM HIREDATE) FROM EMP;
  --EX. 2���� �Ի��� ������ ��� �ʵ�
SELECT * FROM EMP WHERE HIREDATE LIKE '__/02/__';
SELECT * FROM EMP WHERE EXTRACT (MONTH FROM HIREDATE)=2 ;
  -- 81�⵵�� �Ի��� ������ ��� �ʵ�
SELECT * FROM EMP WHERE HIREDATE LIKE '81/__/__';
SELECT * FROM EMP WHERE EXTRACT (YEAR FROM HIREDATE)=1981 ;

-- (2) ������ ���(������ ���) : LEVEL, START WITH ���� (MGL IS NULL), CONNECT BY PRIOR ���� (EMPNO=MGR)

SELECT LEVEL, LPAD(' ', LEVEL*2)||ENAME -- ��� ���� �޶� ���� ��
  FROM EMP
  START WITH MGR IS NULL
  CONNECT BY PRIOR EMPNO = MGR;


-- <�� ��������>

-- 1. ���� ��¥�� ����ϰ� TITLE�� ��Current Date���� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT SYSDATE "Current Date" FROM DUAL;

-- 2. EMP ���̺��� ���� �޿��� 15%�� ������ �޿��� ����Ͽ�,
-- �����ȣ,�̸�,����,�޿�,������ �޿�(New Salary),������(Increase)�� ����ϴ� SELECT ����
SELECT EMPNO, ENAME, JOB, SAL, ROUND(SAL*1.15) "New Salary", ROUND(SAL*0.15) "Increase" FROM EMP;

--3. �̸�, �Ի���, �Ի��Ϸκ��� 6���� �� ���ƿ��� ������ ���Ͽ� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, HIREDATE, TRUNC (HIREDATE+180, 'DAY')+1  FROM EMP;

--4. �̸�, �Ի���, �Ի��Ϸκ��� ��������� ������, �޿�, �Ի��Ϻ��� ��������� ���� �޿��� �Ѱ踦 ���
SELECT ENAME, HIREDATE, FLOOR(MONTHS_BETWEEN(SYSDATE, HIREDATE))|| '����' "�ٹ�����", SAL, 
     SAL * FLOOR(MONTHS_BETWEEN(SYSDATE, HIREDATE)) "�ѱ޿�" FROM EMP;

--5. ��� ����� �̸��� �޿�(15�ڸ��� ��� ������ �� ���� ��*���� ��ġ)�� ���
SELECT LPAD(ENAME, 15, '*'), LPAD(SAL, 15, '*') FROM EMP;

--6. ��� ����� ������ �̸�,����,�Ի���,�Ի��� ������ ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, JOB, HIREDATE, TO_CHAR (HIREDATE, 'DY"����"') "�Ի����" FROM EMP;

--7. �̸��� ���̰� 6�� �̻��� ����� ������ �̸�,�̸��� ���ڼ�,������ ���
SELECT ENAME, LENGTH(ENAME) "���ڼ�", JOB FROM EMP WHERE LENGTH(ENAME)>=6;

--8. ��� ����� ������ �̸�, ����, �޿�, ���ʽ�, �޿�+���ʽ��� ���
SELECT ENAME, JOB, SAL, NVL(COMM, 0), SAL+NVL(COMM, 0) FROM EMP;

-- 9.��� ���̺��� ������� 2��° ���ں��� 3���� ���ڸ� �����Ͻÿ�. 
SELECT SUBSTR (ENAME, 2, 3) FROM EMP;

--10. ��� ���̺��� �Ի����� 12���� ����� ���, �����, �Ի����� �˻��Ͻÿ�. 
--  �ý��ۿ� ���� DATEFORMAT �ٸ� �� �����Ƿ� �Ʒ��� ����� �˾ƺ���
SELECT EMPNO, ENAME, HIREDATE FROM EMP
  WHERE HIREDATE LIKE '__/12/__';


--11. ������ ���� ����� �˻��� �� �ִ� SQL ������ �ۼ��Ͻÿ�
--EMPNO		ENAME		�޿�
--7369		       SMITH		*******800
--7499		       ALLEN		******1600
--7521		       WARD		******1250
--����. 
SELECT EMPNO, LPAD (ENAME, 10, '_'), LPAD (SAL, 10, '*') "�޿�" FROM EMP;


-- 12. ������ ���� ����� �˻��� �� �ִ� SQL ������ �ۼ��Ͻÿ�
-- EMPNO	 ENAME 	�Ի���
-- 7369	  SMITH		1980-12-17
-- ��.
SELECT EMPNO, RPAD (ENAME, 7, '_') "ENAME", TO_CHAR (HIREDATE, 'YYYY"-"MM"-"DD') "�Ի���" FROM EMP;




--13. ��� ���̺��� �μ� ��ȣ�� 20�� ����� ���, �̸�, ����, �޿��� ����Ͻÿ�.
    --(�޿��� �տ� $�� �����ϰ�3�ڸ����� ,�� ����Ѵ�)
SELECT EMPNO, ENAME, JOB, TO_CHAR (SAL, '$99,999') "�޿�" FROM EMP WHERE DEPTNO = 20;



