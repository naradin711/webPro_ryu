-- [III] JOIN : ���̺� 2�� �̻��� �����Ͽ� �˻�
SELECT * FROM EMP WHERE ENAME='SCOTT'; -- �μ���ȣ DEPTNO 20
SELECT * FROM DEPT;

-- CROSS JOIN (FROM �� ���̺��� 2�� �̻� �ֱ�)
SELECT * FROM EMP, DEPT WHERE ENAME = 'SCOTT';
SELECT * FROM EMP, DEPT; 14 4 56 ��

--1. EQUI JOIN (��������) : �����ʵ忣 DEPTNO ���� ��ġ�Ǵ� ���Ǹ� JOIN.
SELECT * FROM EMP, DEPT WHERE ENAME ='SCOTT' AND EMP.DEPTNO=DEPT.DEPTNO;
SELECT EMPNO,ENAME,JOB, MGR, HIREDATE, SAL, COMM, EMP.DEPTNO, DNAME, LOC FROM EMP, DEPT WHERE EMP.DEPTNO=DEPT.DEPTNO;
  -- ���̺��� ��Ī
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, E.DEPTNO, DNAME, LOC FROM EMP E,DEPT D WHERE E.DEPTNO=D.DEPTNO;
  
  --EX. �޿��� 2000�̻��� ����� �̸�, ��å, �޿�, �μ���, �ٹ��� ���.
SELECT ENAME, JOB, SAL, DNAME, LOC  FROM EMP E , DEPT D WHERE E.DEPTNO=D.DEPTNO AND SAL>=2000;

  --EX. �ٹ����� 'CHICAGO'�� ����� �̸�, ����, �޿�, �μ���ȣ, �ٹ����� ��� 
SELECT ENAME, JOB, SAL, E.DEPTNO, LOC FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND LOC = 'CHICAGO';

  --EX. �μ���ȣ�� 10�̰ų� 20���� ����� �̸�, ����, �ٹ���, �޿�. �޿��� ����
SELECT ENAME, JOB, LOC, SAL FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND E.DEPTNO IN (10, 20) ORDER BY SAL; 

  --EX. JOB�� SALESMAN�̰ų� MANAGER�� ����� �̸�, �޿�, ��, ���� ((SAL+COMM)*12), �μ���, �ٹ����� ��� (������ ū ������ ���)
SELECT ENAME, SAL, COMM, ((SAL+NVL(COMM,0))*12) "����", DNAME, LOC FROM EMP, DEPT WHERE JOB = 'SALESMAN' OR JOB = 'MANAGER' ORDER BY ���� DESC; 
  
  --EX. COMM�� NULL�̰� �޿��� 1200 �̻��� ����� �̸�, �޿�, �Ի���, �μ���ȣ, �μ��� ��� �μ��� �޿��� ū ����
SELECT ENAME, SAL, HIREDATE, EMP.DEPTNO, DNAME FROM EMP, DEPT WHERE EMP.DEPTNO = DEPT.DEPTNO AND SAL >= 1200 AND COMM IS NULL ORDER BY SAL DESC; 
  
  --EX. 'NEW YORK'���� �ٹ��ϴ� ����� �̸��� �޿� ���
SELECT ENAME, SAL FROM EMP, DEPT WHERE LOC = 'NEW YORK';  
  
  --EX. 'ACCOUNTING' �μ� �Ҽ��� ��� �̸��� �Ի��� ���
SELECT ENAME, HIREDATE FROM EMP, DEPT WHERE DNAME = 'ACCOUNTING';  

  -- ������ MANAGER�� ����� �̸�, �μ����� ����Ͻÿ�
SELECT ENAME, DNAME FROM EMP, DEPT WHERE JOB = 'MANAGER';  

  -- Comm�� null�� �ƴ� ����� �̸�, �޿�, �μ��ڵ�, �ٹ����� ����Ͻÿ�.
SELECT ENAME, SAL, D.DEPTNO, LOC FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND COMM IS NOT NULL;  

-- 2. NON EQUI JOIN
SELECT * FROM EMP WHERE ENAME = 'SCOTT'; -- ��� ����
SELECT * FROM SALGRADE; -- �޿� ��� ����
-- CROSS JOIN = EMP�� 1�� * SALGRADE�� 5��
SELECT * FROM EMP, SALGRADE WHERE ENAME = 'SCOTT';










