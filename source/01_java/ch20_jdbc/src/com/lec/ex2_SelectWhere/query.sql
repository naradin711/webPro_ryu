-- Ex 1 : ����ڿ��� �μ���ȣ�� �Է¹޾� �μ� ���� ���
SELECT * FROM DEPT WHERE DEPTNO=30;
INSERT INTO DEPT VALUES (50, 'IT', 'SEOUL');
SELECT * FROM DEPT;
ROLLBACK;

-- Ex 2 : ����ڿ��� �μ���ȣ�� �Է¹޾Ƽ� EMP�� ���� ���.
-- �ش� �μ��� ������ ��� ����(���, �̸�, �޿�, ����)�� ���
SELECT * FROM DEPT WHERE DEPTNO=40;
SELECT W.EMPNO empno , W.ENAME ename, W.SAL sal, M.ENAME MGRNAME
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO AND W.DEPTNO = 30;

-- Ex 3 �μ� ������ �������(���, �̸�, �޿�, �޿����)�� ���
SELECT * FROM DEPT WHERE DNAME=UPPER('SALES');
SELECT EMPNO, ENAME, SAL, GRADE
    FROM EMP e, SALGRADE S, DEPT D
    WHERE SAL BETWEEN LOSAL AND HISAL AND E.DEPTNO = D.DEPTNO AND DNAME=UPPER('SALES');
 SELECT EMPNO, ENAME, SAL, GRADE
    FROM EMP e, SALGRADE S
    WHERE SAL BETWEEN LOSAL AND HISAL AND DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME=UPPER('SALES'));   
select * from dept;    
    
    
-- Ex 4

