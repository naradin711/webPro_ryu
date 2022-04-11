-- [II] SELECT �� - ���� ���� ���̴� DML(DATA MANIPULATION LANGUAGE) �˻� ���
-- 1. SELECT���� �ۼ���
-- ���� ���� (���� : CTRL + ENTER)
SHOW USER;
SELECT * FROM TAB;   -- ���� ������ ������ �ִ� ���̺�
SELECT * FROM EMP;   -- EMP ���̺��� ��� �� �ʵ�, ��� ��
SELECT * FROM dept;   -- DEPT ���̺��� ��� �� �ʵ�, ��� ��
-- EMP ���̺��� ������ �˾ƺ��ô�.
DESC EMP;
DESC DEPT;
-- 2. SQL�� ���� (Ư�� ���� ���)
SELECT EMPNO, ENAME, SAL, JOB FROM EMP;
SELECT EMPNO AS "���", ENAME AS "�̸�", SAL AS "�޿�",JOB FROM EMP; -- ��Ī
-- �ش� �����ƽ��� �����̽��� ������ �ݵ�� �ֵ���ǥ�� �ٿ��� �Ѵ�.
SELECT EMPNO "�� ��", ENAME "�� ��", SAL "�� ��",JOB FROM EMP;
SELECT EMPNO AS "NO", ENAME AS "NAME", SAL AS "SALARY",JOB FROM EMP;

-- 3. Ư�� �� ��� : WHERE �� (����) : �񱳿�����.
-- ���� (=), ũ�ų� ����(>=), �۰ų� ����(<=), �ٸ���(!=, <>, ^=)

SELECT EMPNO "���", ENAME "�̸�", SAL "�޿�" FROM EMP WHERE SAL = 3000; -- ����
SELECT EMPNO "���", ENAME "�̸�", SAL "�޿�" FROM EMP WHERE SAL != 3000; -- �ٸ���
SELECT EMPNO "���", ENAME "�̸�", SAL "�޿�" FROM EMP WHERE SAL <> 3000; -- �ٸ���
SELECT EMPNO "���", ENAME "�̸�", SAL "�޿�" FROM EMP WHERE SAL >= 3000; -- ũ��.

-- �񱳿����ڴ� ����, ����, ��¥�� ��� �����ϴ�.
-- ����̸� (ENAME)�� A B C �� �����ϴ� ����� ��� �ʵ带 ����Ͻÿ�

SELECT * FROM EMP WHERE ENAME < 'D'; -- ABC ������ ���ڵ� �񱳰� �����ϴ�. ""�� ������ ��Ī�� ���� ��쿡�� ����.
-- 81�⵵ ������ �Ի��� ����� ��� �ʵ�
SELECT * FROM EMP WHERE hiredate < '81/01/01';
-- �μ���ȣ�� 10���� ����� ��� �ʵ带 ���
SELECT * FROM EMP WHERE DEPTNO = 10;
-- �̸��� FORD�� ������ EMPNO, ENAME, MGR ����� ����� ����Ͻÿ�
SELECT EMPNO, ENAME, MGR FROM EMP WHERE ENAME = 'FORD'; -- '' "" �ȿ� �ִ� ��ҹ��ڴ� ����

-- 4. �������� : AND, OR
-- EX. �޿� SAL�� 2000 �̻� 3000 ������ ������ ��� �ʵ带 ����Ͻÿ�.
SELECT * FROM EMP WHERE SAL > 2000 AND SAL < 3000;
-- 82�� ���� �Ի��� ����� ��� �ʵ�
SELECT * FROM EMP WHERE hiredate >= '82/01/01' AND hiredate <= '82/12/31';
-- ��¥ ǥ��� ���� (���� : YY/MM/DD OR RR/MM/DD)
ALTER SESSION SET NLS_DATE_FORMAT = 'MM-DD-RR';
ALTER SESSION SET NLS_DATE_FORMAT =  'RR/MM/DD';
SELECT ENAME, HIREDATE FROM EMP;

-- ������ 2400 �̻��� ������ ENAME, SAL, ���� ��� (������ SAL*12)

SELECT ENAME, SAL, SAL*12 "����" FROM EMP WHERE SAL*12 > 2400; -- WHERE������ ��Ī�� ��� �Ұ�.
SELECT ENAME, SAL, SAL*12 "����" FROM EMP WHERE SAL*12 > 2400 ORDER BY ���� ; -- ���⿡�� ��Ī ��밡��
-- 10�� �μ��̰ų� ��å�� MANAGER�� ����� ��� �ʵ�
SELECT * FROM EMP WHERE DEPTNO = 10 OR JOB = 'MANAGER';
SELECT * FROM EMP WHERE DEPTNO != 10;
SELECT * FROM EMP WHERE NOT DEPTNO = 10; -- �ش� ������ �ݴ밡 ��.

-- 5. ���ǥ���� 

SELECT ENAME, SAL "����޿�" , SAL+100 "�ø��޿�" FROM EMP WHERE deptno = 10;
-- ��� ����� �̸� ���� �� ���� SAL*12+COMM �̱�
-- ���� ������ ����� NULL �����ϸ� ����� NULL
-- NVL(NULL)�� ���� �ִ� �ʵ��, NULL�� ����� ��ġ��) �ݵ�� �Ű����� ���� Ÿ���� ���ƾ� �Ѵ�.
SELECT ENAME, SAL, COMM, SAL*12+NVL(COMM, 0) "����" FROM EMP;
-- ��� ����� �����, ����� ����� ���
SELECT ENAME, NVL(MGR, 0) FROM EMP;  -- NVL �Ű����� Ÿ�� ����ġ ����.

--6. ���Ῥ���� (||) : ���̳� ���ڸ� ����
SELECT ENAME || '�� ' || JOB "EMPLOYEES" FROM EMP;
-- EX. "SMITH : ���� = XXX"�� ���� ��� �� ��� ������ SAL*12+NVL(COMM, 0)
SELECT ENAME || ' : ���� = ' || (SAL*12+NVL(COMM, 0)) FROM EMP;

-- 7. �ߺ� ���� (DISTINCT)
SELECT JOB FROM EMP;
SELECT DEPTNO FROM EMP;
SELECT DISTINCT DEPTNO FROM EMP;
SELECT DISTINCT JOB FROM EMP;


-- �� ���� �� Ǯ�� 
--1. emp ���̺��� ���� ��� (������ ����Ŭ������ ��� ����.)
DESC EMP;
--2. emp ���̺��� ��� ������ ��� 
SELECT * FROM EMP;
--3. �� scott �������� ��밡���� ���̺� ���
show user;
SELECT * FROM TAB; -- ���� ������ ������ �ִ� ���̺�
--4. emp ���̺��� ���, �̸�, �޿�, ����, �Ի��� ���
SELECT EMPNO "���", ENAME "�̸�", SAL "�޿�",   JOB "����", HIREDATE "�Ի���" FROM EMP;

--5. emp ���̺��� �޿��� 2000�̸��� ����� ���, �̸�, �޿� ���
SELECT EMPNO "���", ENAME "�̸�", SAL "�޿�" FROM EMP WHERE SAL>2000;

--6. �Ի����� 81/02���Ŀ� �Ի��� ����� ���, �̸�, ����, �Ի��� ���
SELECT EMPNO "���", ENAME "�̸�", JOB "����", HIREDATE "�Ի���" FROM EMP 
       WHERE TO_CHAR (hiredate, 'RR/MM/DD') >= '81/02/01'; -- �������Լ� 4�� ����
SELECT EMPNO "���", ENAME "�̸�", JOB "����", HIREDATE "�Ի���" FROM EMP 
       WHERE hiredate >= TO_DATE ('81/02/01', 'RR/MM/DD'); -- �������Լ� 4�� ����
--# ��¥���� �ϴ� ��. YYYY �⵵ 4�ڸ�, RR �⵵ 2�ڸ�, M�� D��.
--# ��¥�� -> ���������� ��ȯ�ϴ� �Լ� : TO_CHAR ��¥��, ����
--# ������ -> ��¥������ ��ȯ�ϴ� �Լ� : TO_DATE ������, ����
Alter session set nls_DATE_FORMAT = 'MM-DD-RR';
Alter session set nls_DATE_FORMAT = 'RR/MM/DD';


--7. ������ SALESMAN�� ����� ��� �ڷ� ���
SELECT * FROM EMP WHERE JOB = 'SALESMAN';

--8. ������ CLERK�� �ƴ� ����� ��� �ڷ� ���
SELECT * FROM EMP WHERE JOB != 'CLERK';
SELECT * FROM EMP WHERE NOT JOB = 'CLERK';

--9. �޿��� 1500�̻��̰� 3000������ ����� ���, �̸�, �޿� ��� &&�� ���Ұ�
SELECT EMPNO "���", ENAME "�̸�", SAL "�޿�" FROM EMP WHERE SAL > 1500 AND SAL < 3000;

--10. �μ��ڵ尡 10���̰ų� 30�� ����� ���, �̸�, ����, �μ��ڵ� ���
SELECT EMPNO "���", ENAME "�̸�", JOB "����", DEPTNO "�μ��ڵ�" FROM EMP WHERE deptno = 10 OR deptno = 30;

--11. ������ SALESMAN�̰ų� �޿��� 3000�̻��� ����� ���, �̸�, ����, �μ��ڵ� ���
SELECT EMPNO "���", ENAME "�̸�", JOB "����", DEPTNO "�μ��ڵ�" FROM EMP WHERE JOB='SALESMAN' OR SAL >3000;

--12. �޿��� 2500�̻��̰� ������ MANAGER�� ����� ���, �̸�, ����, �޿� ���
SELECT EMPNO "���", ENAME "�̸�", JOB "����", SAL "�޿�" FROM EMP WHERE SAL >2500 AND JOB= 'MANAGER';

--13.��ename�� XXX �����̰� ������ XX�١� ��Ÿ�Ϸ� ��� ���(������ SAL*12+COMM)
SELECT ENAME || '�� ' || JOB || '�����̰� ������ ' || (SAL*12+NVL(COMM, 0)) || '�̴�' FROM EMP;


-- 8. SQL ������ BETWEEN, IN, LIKE, IS NULL
 -- 8. 1. BETWEEN
  -- EX. SAL�� 1500 �̻� 3000������ ��� �̸� �޿�.
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL >=1500 AND SAL<=3000;
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL BETWEEN 1500 AND 3000; -- �Ųٷδ� �ȵ� ������ ���� ���� ū ���� ������ �Է�!
  -- EX. 1500 �̸� 3000 �ʰ��� NOT BETWEEN ���
SELECT * FROM EMP WHERE SAL NOT BETWEEN 1500 AND 3000;
  -- EX. 82�⵵�� �Ի��� ������ ��� �ʵ� ���
SELECT * FROM EMP WHERE HIREDATE BETWEEN '82/01/01' AND  '82/12/31';
SELECT * FROM EMP
   WHERE TO_CHAR (HIREDATE, 'RR/MM/DD') BETWEEN '82/01/01' AND  '82/12/31';
  -- EX. ��� �̸��� 'A' �� 'B'�� �����ϴ� ����� ��� �ʵ�.
SELECT * FROM EMP WHERE ENAME BETWEEN 'A' AND 'C' AND ENAME!='C'; -- A���� B������ �Ϸ��� C���� ��Ʈ���� ���� �Ŀ� C ���ָ� ���� ��.

  -- EX. ��� �̸��� 'B' �� 'C'�� �����ϴ� ����� ��� �ʵ�.
SELECT * FROM EMP WHERE ENAME BETWEEN 'B' AND 'D' AND ENAME!='D';

 -- 8. 2. ������ IN ������ (A, B, C .....)
  --EX. �μ���ȣ�� 10,20,40���� �μ� ����� ����ʵ�
SELECT * FROM EMP WHERE DEPTNO=10 OR DEPTNO=20 OR DEPTNO=40;
SELECT * FROM EMP WHERE DEPTNO IN (10,20,40); -- ��ȣ�ȿ� �ִ� ��ü���� ������. 

  --EX. �μ���ȣ�� 10,20,40�� �μ��� ������ ����� ��� �ʵ�
SELECT * FROM EMP WHERE DEPTNO NOT IN (10,20,40);

  --EX. ����� 7902, 7788, 7566�� ����� ��� �ʵ�
SELECT * FROM EMP WHERE EMPNO IN (7902, 7788, 7566); 

 -- 8. 3 LIKE ���� : (����) ������ LIKE ����(% : 0���� �̻�, _ : 1���� )
  -- EX. �̸��� M�� �� ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME LIKE '%M%'; -- ������ ������� M�� ���� OK

  -- EX. �̸��� M���� '�����ϴ�' ����� ��� �ʵ带 ����Ͻÿ�.
SELECT * FROM EMP WHERE ENAME LIKE 'M%';

  -- EX. �̸��� S���� '������' ����� ��� �ʵ带 ����Ͻÿ�.
SELECT * FROM EMP WHERE ENAME LIKE '%S';

  -- EX. �޿��� 5�� ������ ����� ��� �ʵ�
SELECT * FROM EMP WHERE SAL LIKE '%5';
SELECT * FROM EMP WHERE SAL = '2975'; -- �������� ������ �񱳰���!

  --EX. 82�⵵�� �Ի��� ����� ����ʵ�
SELECT * FROM EMP WHERE HIREDATE LIKE '82/%';
SELECT * FROM EMP WHERE TO_CHAR (HIREDATE, 'RR/MM/DD') LIKE  '82/%';
SELECT * FROM EMP WHERE TO_CHAR (HIREDATE, 'RR') LIKE '82';
SELECT * FROM EMP WHERE TO_CHAR (HIREDATE, 'RR') LIKE 82;

  --EX. 1���� �Ի��� ����� ����ʵ�
SELECT * FROM EMP WHERE HIREDATE LIKE '%/01/%';
SELECT * FROM EMP WHERE TO_CHAR (HIREDATE, 'MM') LIKE '01'; -- ���� ���� �ϰ� ������ ���ڿ�ȭ ���Ѽ� MM���� ��
SELECT * FROM EMP WHERE TO_CHAR (HIREDATE, 'RR/MM/DD') LIKE '__/01/__';

  --EX. 82�⵵�� �ƴ� �⵵�� �Ի��� ����� ��� �ʵ�
SELECT * FROM EMP WHERE HIREDATE NOT LIKE '82/%';  

  --EX. �̸��� S�� �� ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME LIKE '%S%';  
SELECT * FROM EMP WHERE ENAME LIKE '%%%';  -- ��� �ʵ�
SELECT * FROM EMP WHERE ENAME LIKE '%\%%' ESCAPE '\';
INSERT INTO EMP VALUES (9999, 'ȫ%', NULL, NULL, NULL, 9000, 900, 40); --������ �Է�
ROLLBACK; -- DML (�����͸� �߰�, ����, ����)�� �� ������ ������ ���󺹱� DML���
 
 -- 8. 4. IS NULL
SELECT * FROM EMP;
  --EX. �󿩱��� NULL�� ����� ��� �ʵ�
SELECT * FROM EMP WHERE COMM IS NULL;--NULL�� �񱳽� �ݵ�� IS NULL��.

  --EX. �󿩱��� ���� ����� ��� �ʵ� (COMM�� NULL�̰ų�)
SELECT * FROM EMP WHERE COMM IS NULL OR COMM=0;

  --EX. �󿩱��� �ִ� ����� ��� �ʵ�
SELECT * FROM EMP WHERE NOT COMM IS NULL AND COMM!=0;

--9. ���� (��������, ��������)

SELECT ENAME, SAL FROM EMP ORDER BY SAL ;       -- �޿� �������� ���� �����ź��� ū������
SELECT ENAME, SAL FROM EMP ORDER BY SAL ASC ;
SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC ;  -- �޿� ��������
SELECT ENAME, SAL FROM EMP ORDER BY ENAME;      -- �̸� ABCD ������
SELECT ENAME, SAL FROM EMP ORDER BY ENAME DESC; -- �̸� ZYX ������
SELECT ENAME, HIREDATE FROM EMP ORDER BY HIREDATE; -- ��¥ ������� ����
SELECT ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC;  -- ���� �������� ���� �������

  -- �̸�, ���� (SAL*12+COMM)�� ��� (������ ���� ������, ������ ���� ��� �̸� ������)
SELECT ENAME, SAL*12+NVL(COMM,O) "ANNUAL_SAL" 
   FROM EMP ORDER BY SAL*12+NVL(COMM,O) DESC, ENAME;
SELECT ENAME, SAL*12+NVL(COMM,O) "ANNUAL_SAL" 
   FROM EMP ORDER BY "ANNUAL_SAL" DESC, ENAME;   -- ���� ���� ������ ��Ī ��밡���ϴ�.
   
  -- EX. ���, �̸�, �Ի���, �޿�, �μ���ȣ (�μ���ȣ������, �μ��� ������ �Ի��� ������ ������ ���)
SELECT EMPNO, ENAME, HIREDATE, SAL, DEPTNO FROM EMP ORDER BY DEPTNO, HIREDATE;

 -- ���� ��������!


--1.	EMP ���̺��� sal�� 3000�̻��� ����� empno, ename, job, sal�� ���
SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL>=3000;
 
--2.	EMP ���̺��� empno�� 7788�� ����� ename�� deptno�� ���
SELECT ENAME, DEPTNO FROM EMP WHERE EMPNO = '7788';

--3.	������ 24000�̻��� ���, �̸�, �޿� ��� (�޿�������)
SELECT EMPNO, ENAME, SAL FROM EMP WHERE (SAL*12+NVL(COMM,0)) >=24000 ORDER BY SAL;

--4.	�Ի����� 1981�� 2�� 20�� 1981�� 5�� 1�� ���̿� �Ի��� ����� �����, ��å, �Ի����� ��� (�� hiredate ������ ���)
SELECT ENAME, JOB, HIREDATE FROM EMP WHERE  HIREDATE BETWEEN TO_DATE ('1981/02/20', 'YYYY/MM/DD') AND TO_DATE ('1981/05/01', 'YYYY/MM/DD') ORDER BY HIREDATE;

--5.	deptno�� 10,20�� ����� ��� ������ ��� (�� ename������ ����)
SELECT * FROM EMP WHERE DEPTNO IN (10, 20) ORDER BY ENAME;

--6.	sal�� 1500�̻��̰� deptno�� 10,30�� ����� ename�� sal�� ���
-- (�� HEADING�� employee�� Monthly Salary�� ���)
SELECT ENAME AS "employee", SAL as "Monthly Salary" FROM EMP WHERE DEPTNO IN (10, 30) AND SAL >=1500;

--7.	hiredate�� 1982���� ����� ��� ������ ���
SELECT * FROM EMP WHERE TO_CHAR (HIREDATE, 'YYYY/MM/DD') LIKE '1982/%';

--8.	�̸��� ù�ڰ� C����  P�� �����ϴ� ����� �̸�, �޿� �̸��� ����
SELECT ENAME, SAL FROM EMP WHERE ENAME BETWEEN 'C' AND 'Q' AND ENAME != 'Q' ORDER BY SAL, ENAME; 

--9.	comm�� sal���� 10%�� ���� ��� ����� ���Ͽ� �̸�, �޿�, �󿩱��� 
--����ϴ� SELECT ���� �ۼ�
SELECT ENAME, SAL, COMM FROM EMP WHERE COMM > (SAL*1.1);

--10.	job�� CLERK�̰ų� ANALYST�̰� sal�� 1000,3000,5000�� �ƴ� ��� ����� ������ ���
SELECT * FROM EMP WHERE JOB = 'CLERK' OR JOB = 'ANALYST' AND SAL NOT IN (1000, 3000, 5000);

--11.	ename�� L�� �� �ڰ� �ְ� deptno�� 30�̰ų� �Ǵ� mgr�� 7782�� ����� 
--��� ������ ����ϴ� SELECT ���� �ۼ��Ͽ���.
SELECT * FROM EMP WHERE ENAME LIKE '%L%L%' AND DEPTNO = '30' OR MGR = '7782';

--12.	�Ի����� 81�⵵�� ������ ���,�����, �Ի���, ����, �޿��� ���
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE TO_CHAR(HIREDATE, 'RR') = '81';

--13.	�Ի�����81���̰� ������ 'SALESMAN'�� �ƴ� ������ ���, �����, �Ի���, 
-- ����, �޿��� �˻��Ͻÿ�.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE TO_CHAR(HIREDATE, 'RR') = '81' AND JOB != 'SALESMAN';

--14.	���, �����, �Ի���, ����, �޿��� �޿��� ���� ������ �����ϰ�, 
-- �޿��� ������ �Ի����� ���� ������� �����Ͻÿ�.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP ORDER BY SAL DESC, HIREDATE;

--15.	������� �� ��° ���ĺ��� 'N'�� ����� ���, ������� �˻��Ͻÿ�
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '__N%';

--16.	����� 'A'�� �� ����� ���, ������� ���
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '%A%';

--17.	����(SAL*12)�� 35000 �̻��� ���, �����, ������ �˻� �Ͻÿ�.
SELECT EMPNO, ENAME, (SAL*12) "����" FROM EMP WHERE (SAL*12) >= 35000; 











