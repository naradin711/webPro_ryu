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
--1. emp ���̺��� ���� ���
DESC EMP;
--2. emp ���̺��� ��� ������ ��� 
SELECT * FROM EMP;
--3. �� scott �������� ��밡���� ���̺� ���
SELECT * FROM TAB;
--4. emp ���̺��� ���, �̸�, �޿�, ����, �Ի��� ���
SELECT EMPNO "���", ENAME "�̸�", SAL "�޿�",   JOB "����", HIREDATE "�Ի���" FROM EMP;
--5. emp ���̺��� �޿��� 2000�̸��� ����� ���, �̸�, �޿� ���
SELECT EMPNO "���", ENAME "�̸�", SAL "�޿�" FROM EMP WHERE SAL>2000;
--6. �Ի����� 81/02���Ŀ� �Ի��� ����� ���, �̸�, ����, �Ի��� ���
SELECT EMPNO "���", ENAME "�̸�", JOB "����", HIREDATE "�Ի���" FROM EMP WHERE hiredate > '81/02/01';
--7. ������ SALESMAN�� ����� ��� �ڷ� ���
SELECT * FROM EMP WHERE JOB = 'SALESMAN';
--8. ������ CLERK�� �ƴ� ����� ��� �ڷ� ���
SELECT * FROM EMP WHERE JOB != 'CLERK';

--9. �޿��� 1500�̻��̰� 3000������ ����� ���, �̸�, �޿� ���
SELECT EMPNO "���", ENAME "�̸�", SAL "�޿�" FROM EMP WHERE SAL > 1500 AND SAL < 3000;

--10. �μ��ڵ尡 10���̰ų� 30�� ����� ���, �̸�, ����, �μ��ڵ� ���
SELECT EMPNO "���", ENAME "�̸�", JOB "����", DEPTNO "�μ��ڵ�" FROM EMP WHERE deptno = 10 OR deptno = 30;

--11. ������ SALESMAN�̰ų� �޿��� 3000�̻��� ����� ���, �̸�, ����, �μ��ڵ� ���
SELECT EMPNO "���", ENAME "�̸�", JOB "����", DEPTNO "�μ��ڵ�" FROM EMP WHERE JOB='SALESMAN' OR SAL >3000;

--12. �޿��� 2500�̻��̰� ������ MANAGER�� ����� ���, �̸�, ����, �޿� ���
SELECT EMPNO "���", ENAME "�̸�", JOB "����", SAL "�޿�" FROM EMP WHERE SAL >2500 AND JOB= 'MANAGER';

--13.��ename�� XXX �����̰� ������ XX�١� ��Ÿ�Ϸ� ��� ���(������ SAL*12+COMM)
SELECT ENAME || '�� ' || JOB || '�����̰� ������ ' || (SAL*12+NVL(COMM, 0)) || '�̴�' FROM EMP;








