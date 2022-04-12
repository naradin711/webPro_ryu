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
SELECT * FROM EMP, SALGRADE WHERE ENAME = 'SCOTT' AND SAL BETWEEN LOSAL AND HISAL;

  --EX. ��� ����� ���, �̸�, ����, �����, �޿�, �޿� ��� ���
SELECT EMPNO, ENAME, JOB, MGR, SAL, grade||'���' GRADE FROM EMP, SALGRADE WHERE SAL BETWEEN LOSAL AND HISAL;




--Comm�� null�� �ƴ� ����� �̸�, �޿�, ���, �μ���ȣ, �μ��̸�, �ٹ����� ����Ͻÿ�.
SELECT ENAME, SAL, GRADE, D.DEPTNO, DNAME, LOC FROM EMP E, SALGRADE S, DEPT D 
  WHERE SAL BETWEEN LOSAL AND HISAL
  AND E.DEPTNO = D.DEPTNO
  AND NOT COMM IS NULL;

--�̸�, �޿�, �Ի���, �޿����
SELECT ENAME, HIREDATE, GRADE FROM EMP, SALGRADE WHERE SAL BETWEEN LOSAL AND HISAL;

--�̸�, �޿�, �Ի���, �޿����, �μ���, �ٹ���
SELECT ENAME, SAL, HIREDATE, GRADE, DNAME, LOC
  FROM EMP E, SALGRADE S, DEPT D
  WHERE E.DEPTNO = D.DEPTNO
  AND SAL BETWEEN LOSAL AND HISAL;

--�̸�, �޿�, ���, �μ��ڵ�, �ٹ���. �� comm �� null�ƴ� ���
SELECT ENAME, SAL, GRADE, LOC FROM EMP E , SALGRADE S , DEPT D
WHERE E.DEPTNO = D.DEPTNO
AND SAL BETWEEN LOSAL AND HISAL
AND NOT COMM IS NULL;

--�̸�, �޿�, �޿����, ����, �μ���, (�μ��� , �μ��� ������ ������). ����=(sal+comm)*12 comm�� null�̸� 0
SELECT ENAME, SAL, GRADE, (SAL+NVL(COMM, 0))*12, DNAME
 FROM EMP E, SALGRADE S, DEPT D
 WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL
 ORDER BY DNAME, (SAL+NVL(COMM, 0))*12;

--�̸�, ����, �޿�, ���, �μ��ڵ�, �μ��� ���. �޿��� 1000~3000����. �������� : �μ���, �μ������� ������, ���������� �޿� ū��
SELECT ENAME, JOB, SAL, GRADE, E.DEPTNO, DNAME
 FROM EMP E, DEPT D, SALGRADE
 WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL
 AND SAL BETWEEN 1000 AND 3000 ORDER BY DEPTNO, JOB, SAL DESC; 

--�̸�, �޿�, ���, �Ի���, �ٹ���. 81�⿡ �Ի��� ���. ��� ū��
SELECT ENAME, JOB, SAL, GRADE || '���' GRADE, HIREDATE, LOC
 FROM EMP E, DEPT D, SALGRADE
 WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL
 AND HIREDATE LIKE '%81%' ORDER BY GRADE DESC;



-- 3. SELF JOIN
SELECT EMPNO ���, ENAME �̸�, MGR ����� FROM EMP WHERE ENAME = 'SMITH'; --����� 7902

SELECT EMPNO, ENAME FROM EMP WHERE EMPNO = 7902;

SELECT WORKER.EMPNO, WORKER.ENAME, WORKER.MGR, MANAGER.EMPNO, MANAGER.ENAME FROM EMP WORKER, EMP MANAGER 
WHERE WORKER.ENAME ='SMITH' AND WORKER.MGR = MANAGER.EMPNO;

  --EX. ��� ����� ���, �̸�, �����, ����̸� (13�� - KING�� ������� NULL�̱⶧���� KING�� ����� �ȵ�. )
SELECT  W.EMPNO, W.ENAME, W.MGR, M.ENAME
  FROM EMP W, EMP M
  WHERE W.MGR = M.EMPNO(+);
  
  --EX. 'SMITH'�� ���� FORD�̴�. �������� ��� ������� ����Ͻÿ�.
  SELECT W.ENAME || '�� ���� ' || M.ENAME || '�̴�'
   FROM EMP W , EMP M
   WHERE W.MGR = M.EMPNO;
 
 -- źź 0. ����� �̸��� KING�� ������� �̸��� ������ ����Ͻÿ�.
 SELECT C.ENAME "�̸�" , C.JOB "����"
 FROM EMP K, EMP C
 WHERE K.ENAME = 'KING' AND K.EMPNO = C.MGR;
 
 -- źź 1. SCOTT�� ������ �μ���ȣ(20)���� �ٹ��ϴ� ����� �̸��� ����Ͻÿ�
SELECT C.ENAME
FROM EMP S, EMP C
WHERE S.ENAME='SCOTT' AND S.DEPTNO = C.DEPTNO AND C.ENAME != 'SCOTT'; -- ������ �����ؾ� ��.

 -- źź 2. SCOTT�� ������ �ٹ���(DALLAS)���� �ٹ��ϴ� ����� �̸��� ����Ͻÿ�(2�ܰ� ��������)
 SELECT * FROM DEPT;
 -- ���������� DALLAS �ٹ��� �μ��� �ϳ� �߰�
INSERT INTO DEPT VALUES (50, 'IT', 'DALLAS');
SELECT * FROM DEPT;
 -- ���������� 50�� �μ� ��� �߰�.
SELECT * FROM EMP;
INSERT INTO EMP VALUES (9999, 'ȫ�浿', NULL,NULL,NULL, 9000, 900, 50);
SELECT * FROM EMP;

SELECT C.ENAME
  FROM EMP S, EMP C, DEPT A, DEPT B
  WHERE S.ENAME='SCOTT' AND S.DEPTNO = A.DEPTNO AND A.LOC ='DALLAS' 
  AND A.LOC = B.LOC AND B.DEPTNO = c.deptno  
  AND C.ENAME != 'SCOTT' ORDER BY ENAME;
 
ROLLBACK; -- �μ�Ʈ�� ȫ�浿 �޶� ���

SELECT C.ENAME
  FROM EMP S, EMP C, DEPT A, DEPT B
  WHERE S.ENAME='SCOTT' AND S.DEPTNO = A.DEPTNO AND A.LOC ='DALLAS' 
  AND A.LOC = B.LOC AND B.DEPTNO = c.deptno  
  AND C.ENAME != 'SCOTT' ORDER BY ENAME;
  
  
  
-- 4. OUTER JOIN : JOIN�� ���ǿ� �������� �ʴ� ����� ��Ÿ���� �ؾ� ��.

SELECT  W.EMPNO, W.ENAME, W.MGR, M.ENAME
  FROM EMP W, EMP M
  WHERE W.MGR = M.EMPNO(+);
  
SELECT ENAME, D.DEPTNO, DNAME
  FROM EMP E, DEPT D WHERE E.DEPTNO(+) = D.DEPTNO; --E.DEPTNO���� 40�� �μ� ����.

SELECT W.EMPNO, W.ENAME, W.MGR, M.ENAME
  FROM EMP W, EMP M
  WHERE W.MGR(+) = M.EMPNO AND W.EMPNO IS NULL;

 -- �� <��������> PART1
 
--1. �̸�, ���ӻ��

SELECT W.ENAME "�̸�", M.ENAME "���ӻ��"
FROM EMP W, EMP M
WHERE W.MGR = M.EMPNO;

--2. �̸�, �޿�, ����, ���ӻ��
SELECT W.ENAME "�̸�", W.SAL "�޿�" , W.JOB "����" , M.ENAME "���ӻ��"
FROM EMP W, EMP M
WHERE W.MGR = M.EMPNO;


--3. �̸�, �޿�, ����, ���ӻ��. (��簡 ���� �������� ��ü ���� �� ���.
    --��簡 ���� �� '����'���� ���)
SELECT W.ENAME "�̸�", W.SAL "�޿�" , W.JOB "����" , nvl( M.ENAME , '����') "���ӻ��"
FROM EMP W, EMP M
WHERE W.MGR = M.EMPNO (+);    

--4. �̸�, �޿�, �μ���, ���ӻ���
SELECT W.ENAME "�̸�", W.SAL "�޿�" , DNAME "�μ���" , nvl( M.ENAME , '����') "���ӻ��"
FROM EMP W, EMP M, DEPT D
WHERE W.DEPTNO = D.DEPTNO AND W.MGR = M.EMPNO (+) ;

--5. �̸�, �޿�, �μ��ڵ�, �μ���, �ٹ���, ���ӻ���, (��簡 ���� �������� ��ü ���� �� ���)
SELECT W.ENAME "�̸�", W.SAL "�޿�" , DNAME "�μ���", LOC "�ٹ���" , nvl( M.ENAME , '����') "���ӻ��"
FROM EMP W, EMP M, DEPT D
WHERE W.DEPTNO = D.DEPTNO AND W.MGR = M.EMPNO (+) ;


--6. �̸�, �޿�, ���, �μ���, ���ӻ���. �޿��� 2000�̻��� ���
SELECT W.ENAME "�̸�", W.SAL "�޿�", GRADE "���" , DNAME "�μ���" , nvl( M.ENAME , '����') "���ӻ��"
FROM EMP W, EMP M, DEPT D, SALGRADE
WHERE W.DEPTNO = D.DEPTNO AND W.SAL BETWEEN LOSAL AND HISAL
AND W.MGR = M.EMPNO(+) AND W.SAL >= 2000;

--7. �̸�, �޿�, ���, �μ���, ���ӻ���, (���ӻ�簡 ���� �������� ��ü���� �μ��� �� ����)
SELECT W.ENAME "�̸�", W.SAL "�޿�" , GRADE ||'���' "���", DNAME "�μ���" , nvl( M.ENAME , '����') "���ӻ��"
FROM EMP W, EMP M, DEPT D, SALGRADE
WHERE W.DEPTNO = D.DEPTNO AND W.SAL BETWEEN LOSAL AND HISAL
AND W.MGR = M.EMPNO (+) ORDER BY DNAME ;

--8. �̸�, �޿�, ���, �μ���, ����, ���ӻ���. ����=(�޿�+comm)*12 �� comm�� null�̸� 0
SELECT W.ENAME "�̸�", W.SAL "�޿�" , GRADE ||'���' "���", DNAME "�μ���" , nvl( M.ENAME , '����') "���ӻ��", (W.SAL+NVL(W.COMM,0))*12  "����"
FROM EMP W, EMP M, DEPT D, SALGRADE
WHERE W.DEPTNO = D.DEPTNO AND W.SAL BETWEEN LOSAL AND HISAL
AND W.MGR = M.EMPNO (+);

--9. 8���� �μ��� �� �μ��� ������ �޿��� ū �� ����

SELECT W.ENAME "�̸�", W.SAL "�޿�" , GRADE ||'���' "���", DNAME "�μ���" , nvl( M.ENAME , '����') "���ӻ��", (W.SAL+NVL(W.COMM,0))*12  "����"
FROM EMP W, EMP M, DEPT D, SALGRADE
WHERE W.DEPTNO = D.DEPTNO AND W.SAL BETWEEN LOSAL AND HISAL
AND W.MGR = M.EMPNO (+) ORDER BY DNAME , W.SAL DESC;

--  PART2

--1.EMP ���̺��� ��� ����� ���� �̸�,�μ���ȣ,�μ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT ENAME "�̸�", E.DEPTNO "�μ���ȣ", DNAME "�μ���"
FROM EMP E, DEPT D
WHERE e.deptno = d.deptno ;


--2. EMP ���̺��� NEW YORK���� �ٹ��ϰ� �ִ� ����� ���Ͽ� �̸�,����,�޿�,�μ����� ���
SELECT ENAME "�̸�", JOB "����", SAL "�޿�", DNAME "�μ���" 
FROM EMP E , DEPT D
WHERE E.DEPTNO = d.deptno AND D.LOC = 'NEW YORK'; 

--3. EMP ���̺��� ���ʽ��� �޴� ����� ���Ͽ� �̸�,�μ���,��ġ�� ���

SELECT ENAME "�̸�", DNAME "�μ���", D.LOC "��ġ"
FROM EMP E , DEPT D
WHERE E.DEPTNO = d.deptno AND E.COMM IS NOT NULL ; 


--4. EMP ���̺��� �̸� �� L�ڰ� �ִ� ����� ���Ͽ� �̸�,����,�μ���,��ġ�� ���
SELECT ENAME "�̸�", JOB "����", DNAME "�μ���", D.LOC "��ġ"
FROM EMP E , DEPT D
WHERE E.DEPTNO = d.deptno AND E.ENAME LIKE '%L%' ;

--5. ���, �����, �μ��ڵ�, �μ����� �˻��϶�. ������������ ������������
SELECT E.EMPNO "���", E.ENAME "�̸�", E.DEPTNO "�μ��ڵ�", DNAME "�μ���"
FROM EMP E , DEPT D
WHERE E.DEPTNO = d.deptno ORDER BY E.ENAME ;

--6. ���, �����, �޿�, �μ����� �˻��϶�. 
--�� �޿��� 2000�̻��� ����� ���Ͽ� �޿��� �������� ������������ �����Ͻÿ�
SELECT E.EMPNO "���", E.ENAME "�̸�", E.SAL "�޿�", DNAME "�μ���"
FROM EMP E , DEPT D
WHERE E.DEPTNO = d.deptno AND E.SAL >= 2000
ORDER BY E.SAL DESC ;    

--7. ���, �����, ����, �޿�, �μ����� �˻��Ͻÿ�. �� ������ MANAGER�̸� �޿��� 2500�̻���
-- ����� ���Ͽ� ����� �������� ������������ �����Ͻÿ�.

SELECT E.EMPNO "���", E.ENAME "�̸�", E.JOB "����", E.SAL "�޿�", DNAME "�μ���"
FROM EMP E , DEPT D
WHERE E.DEPTNO = d.deptno AND E.SAL >= 2500 AND E.JOB = 'MANAGER'
ORDER BY E.EMPNO ;

--8. ���, �����, ����, �޿�, ����� �˻��Ͻÿ�. ��, �޿����� ������������ �����Ͻÿ�
SELECT E.EMPNO "���", E.ENAME "�̸�", E.JOB "����", E.SAL "�޿�", GRADE "���"
FROM EMP E , DEPT D, SALGRADE
WHERE E.DEPTNO = d.deptno AND E.SAL BETWEEN LOSAL AND HISAL
ORDER BY E.SAL DESC ;

--9. ������̺��� �����, ����� ��縦 �˻��Ͻÿ�(��簡 ���� �������� ��ü)
SELECT W.ENAME "�̸�", nvl( M.ENAME , '����') "����� ���"
FROM EMP W, EMP M
WHERE W.MGR = M.EMPNO (+); 

--10. �����, ����, ����� ������ �˻��Ͻÿ�
SELECT W.ENAME "�̸�", nvl( M.ENAME , '����') "����� ���", nvl( S.ENAME , '����') "����� ���"
FROM EMP W, EMP M, EMP S
WHERE W.MGR = M.EMPNO AND M.MGR = S.EMPNO;

--11. ���� ������� ���� ��簡 ���� ��� ������ �̸��� ��µǵ��� �����Ͻÿ�
SELECT W.ENAME "�̸�", nvl( M.ENAME , '����') "����� ���", nvl( S.ENAME , '����') "����� ���"
FROM EMP W, EMP M, EMP S
WHERE W.MGR = M.EMPNO (+) AND M.MGR = S.EMPNO(+) 
ORDER BY W.SAL DESC;
















