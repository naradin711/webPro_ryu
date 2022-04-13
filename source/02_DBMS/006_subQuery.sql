--[VI] SUB QUERY : QUERY�ȿ� QUERY�� �����Ǿ� ����.
-- SELECT FIELD 1 (SELECT FIELD 2 FROM TABLE WHERE ����)
-- FROM TABLE 
-- WHERE ���� (SELECT FIELD 2 FROM TABLE WHERE ����)

-- ** 1. ���� ���� ����(�ʿ伺)
-- ���������� �ʿ伺 : 
-- �޿��� ���� ���� �޴� ����� ���, �̸�, ��å�� �޿�
SELECT MAX(SAL) FROM EMP;
SELECT EMPNO, ENAME, MAX(SAL) FROM EMP GROUP BY EMPNO;
SELECT MAX(SAL) FROM EMP; -- SUB
SELECT EMPNO, ENAME, JOB, SAL -- MAIN
  FROM EMP
  WHERE SAL = (SELECT MAX(SAL) FROM EMP);
  
-- ���������� �ݵ�� ��ȣ�� ���� �־�� �մϴ�.  

-- ���������� ���� (1) ������ �������� - ������������ ����� �������϶� : =, >, <, >=, != ������ ��밡��
  -- EX. SCOTT�� �ٹ��ϴ� �μ� �̸� ���.
SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT'; -- SUB

SELECT DNAME FROM DEPT -- MAIN
WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT');

SELECT DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND ENAME = 'SCOTT';

-- ���������� ���� (2) ������ �������� : �������� ����� 2�� �̻�  = IN, ANY, ALL, EXIST
  --EX. JOB�� MANAGER�� ����� �μ��̸�
SELECT DEPTNO FROM EMP WHERE JOB = 'MANAGER';  -- SUB

SELECT DNAME FROM DEPT -- MAIN
   WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE JOB = 'MANAGER'); 


-- ** 2. ������ ��������
   -- �Ʒ� ���� ��ó��
   SELECT E.DEPTNO, D.LOC FROM EMP E ,DEPT D WHERE E.DEPTNO= D.DEPTNO AND ENAME='SCOTT';
   INSERT INTO DEPT VALUES (50, 'IT', 'DALLAS');
   INSERT INTO EMP (EMPNO, ENAME, DEPTNO) VALUES (9999, 'ȫ�浿', 50);
   ROLLBACK;
   
   -- EX. SCOTT�� ���� �μ���ȣ�� ����� �̸��� �޿��� ����Ͻÿ�.
SELECT DEPTNO FROM EMP WHERE ENAME ='SCOTT'; -- SUB
SELECT ENAME, SAL FROM EMP                   -- MAIN
   WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME ='SCOTT') AND ENAME!='SCOTT';



   -- EX. SCOTT�� ������ �ٹ���(DALLAS)���� �ٹ��ϴ� ����� �̸�, �ٹ�����, �޿��� ����Ͻÿ�
SELECT LOC FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND ENAME ='SCOTT';   
SELECT E.ENAME "�̸�", D.LOC "�ٹ���", E.SAL "�޿�" FROM EMP E, DEPT D                   -- MAIN
   WHERE E.DEPTNO=D.DEPTNO 
   AND LOC = (SELECT LOC FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND ENAME ='SCOTT') 
   AND ENAME!='SCOTT';
    ROLLBACK; -- ������ �߰� ��� (DML - �������߰�, ����, ������ ���)
 -- EX. �����Ի��ϰ� �ּ��Ի��ѻ��, 
 SELECT MIN(HIREDATE) FROM EMP;
 SELECT HIREDATE, ENAME FROM EMP
 WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP);
 --     �ֱ��Ի��ϰ� �ֱ��Ի��ѻ���̸�
 SELECT MAX(HIREDATE) FROM EMP;
 SELECT HIREDATE, ENAME FROM EMP
 WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP);
 --     �ֱ��Ի��ϰ� �ֱ��Ի��ѻ��, �����Ի��ϰ� �����Ի��ѻ���̸�
SELECT (SELECT MAX(HIREDATE) FROM EMP) "LAST", 
        (SELECT HIREDATE, ENAME FROM EMP
        WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP)) "LASTMAN",
        (SELECT MIN(HIREDATE) FROM EMP) "FIRST",
        (SELECT HIREDATE, ENAME FROM EMP
        WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP)) "FIRSTMAN"
        FROM DUAL;
        
 
SELECT E1.HIREDATE "�ֱ��Ի���", E1.ENAME"�ֱ��Ի���", E2.HIREDATE "�����Ի���", E2.ENAME "�����Ի���"
FROM EMP E1 , EMP E2
WHERE E1.DEPTNO = E2.DEPTNO
      AND E1.HIREDATE = (SELECT MIN(HIREDATE) FROM EMP)
      AND E2.HIREDATE = (SELECT MAX(HIREDATE) FROM EMP);
      
  --EX. SCOTT�� ���� �μ��� �ٹ��ϴ� ������� �޿� ���� ���϶�.
SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT'; -- SUB

SELECT SUM(SAL) FROM EMP --MAIN
 WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT' );
 
  --EX. SCOTT�� ���� ��å�� ������� ��� �ʵ��� ���϶�.
SELECT * FROM EMP WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME = 'SCOTT' )  ;

  -- DALLAS���� �ٹ��ϴ� ����� �̸�, �μ���ȣ
SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS'; -- SUB
SELECT ENAME, DEPTNO FROM EMP WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS'); -- MAIN

 --EX. KING�� ���� ����� ����� �̸��� �޿��� ���Ͻÿ�.
SELECT EMPNO FROM EMP WHERE ENAME ='KING'; --��������
SELECT ENAME, SAL FROM EMP WHERE MGR = (SELECT EMPNO FROM EMP WHERE ENAME ='KING') ; -- MAIN

-- ���� ������ ���� ������ �־ ���غ�����.
SELECT C.ENAME, C.SAL 
FROM EMP M, EMP C
WHERE C.MGR = M.EMPNO AND M.ENAME = 'KING';

-- źź������ 1. ��� �޿� ���Ϸ� �޴� ����� �̸��� �޿��� ����Ͻÿ�.
SELECT ROUND(AVG(SAL)) FROM EMP; -- SUB

SELECT ENAME, SAL 
FROM EMP
WHERE SAL <= (SELECT ROUND(AVG(SAL)) FROM EMP)
ORDER BY SAL DESC;

-- źź������ 1-1. ��� �޿� ���Ϸ� �޴� ����� �̸��� �޿�, ��ձ޿��� ����Ͻÿ�.

SELECT ENAME, SAL , (SELECT ROUND(AVG(SAL)) FROM EMP) "��ձ޿�"
FROM EMP
WHERE SAL <= (SELECT ROUND(AVG(SAL)) FROM EMP)
ORDER BY SAL DESC;





























