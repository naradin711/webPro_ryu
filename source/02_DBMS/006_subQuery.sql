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

-- EX3. ��ձ޿� ���Ϸ� �޴� ����� �̸� �޿� ��հ� ���� ���.
SELECT ROUND(AVG(SAL)) FROM EMP; -- SUB

SELECT ENAME, SAL, ROUND((SELECT AVG(SAL) FROM EMP)-SAL, 1) "��հ��� ����"
FROM EMP
WHERE SAL <= (SELECT ROUND(AVG(SAL)) FROM EMP)
ORDER BY SAL DESC;

-- ������ ���߿� �������� : SCOTT�̶� JOB�� DEPTNO�� ���� ������ ��� �ʵ� ���
SELECT JOB, DEPTNO FROM EMP WHERE ENAME= 'SCOTT'; -- SUB ������ ���߿�.

SELECT * FROM EMP
 WHERE (JOB, DEPTNO) IN (SELECT JOB, DEPTNO FROM EMP WHERE ENAME= 'SCOTT')
      AND ENAME != 'SCOTT';
 -- ���������� ���߿��϶� WHERE ������ ���ϴ� ���� ��ü ������ ()�ȿ� �־ ��ġ��Ų��.


-- 1. ������̺��� ���� ���� �Ի��� ����� �̸�, �޿�, �Ի���
SELECT ENAME, SAL, HIREDATE FROM EMP
WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP);

-- 2. ȸ�翡�� ���� �޿��� ���� ����� �̸�, �޿�
SELECT ENAME, SAL FROM EMP
WHERE SAL = (SELECT MIN(SAL) FROM EMP);

-- 3. ȸ�� ��պ��� �޿��� ���� �޴� ����� �̸�, �޿�, �μ��ڵ�
SELECT ENAME, SAL, DEPTNO FROM EMP
WHERE SAL > (SELECT AVG(SAL) FROM EMP);

--4. ȸ�� ��� ������ �޿��� �޴� ����� �̸�, �޿�, �μ���
SELECT ENAME, SAL, DNAME FROM EMP, DEPT
WHERE EMP.DEPTNO = DEPT.DEPTNO 
AND SAL <= (SELECT AVG(SAL) FROM EMP);

--5. SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ���
SELECT ENAME, SAL, emp.hiredate ,GRADE FROM EMP, SALGRADE
WHERE SAL BETWEEN LOSAL AND HISAL
AND EMP.HIREDATE < (SELECT HIREDATE FROM EMP WHERE EMP.ENAME = 'SCOTT');


--6. 5��(SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ���)�� �μ��� �߰��ϰ� �޿��� ū �� ����
SELECT ENAME, SAL, emp.hiredate ,GRADE, DNAME FROM EMP, SALGRADE, DEPT D
WHERE EMP.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL
AND EMP.HIREDATE < (SELECT HIREDATE FROM EMP WHERE EMP.ENAME = 'SCOTT')
ORDER BY SAL DESC;

--7. BLAKE ���� �޿��� ���� ������� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL FROM EMP
WHERE SAL > (SELECT SAL FROM EMP WHERE ENAME = 'BLAKE');

--8. MILLER���� �ʰ� �Ի��� ����� ���, �̸�, �Ի���
SELECT EMPNO, ENAME, HIREDATE FROM EMP
WHERE HIREDATE > (SELECT HIREDATE FROM EMP WHERE ENAME = 'MILLER');

--9. �����ü ��� �޿����� �޿��� ���� ������� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL FROM EMP
WHERE SAL > (SELECT AVG(SAL) FROM EMP);

--10. CLARK�� ���� �μ���ȣ�̸�, ����� 7698�� ������ �޿����� ���� �޿��� �޴� ����� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME ='CLARK')
  AND SAL > (SELECT SAL FROM EMP WHERE EMPNO = 7698); 
 
 
--11.  �����ȭ. CLARK�� ���� �μ����̸�, ����� 7698�� ������ �޿����� ���� �޿��� �޴� ����� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO 
  AND DNAME = (SELECT DNAME FROM EMP E, DEPT D  WHERE E.DEPTNO = D.DEPTNO AND E.ENAME ='CLARK')
  AND E.SAL > (SELECT SAL FROM EMP  WHERE EMPNO = 7698); 

--12. BLAKE�� ���� �μ��� �ִ� ��� ����� �̸��� �Ի�����
SELECT ENAME, HIREDATE FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO 
  AND DNAME = (SELECT DNAME FROM EMP E, DEPT D  WHERE E.DEPTNO = D.DEPTNO AND E.ENAME ='BLAKE');


--13. ��� �޿� �̻��� �޴� ��� �������� ���ؼ� �����ȣ�� �̸� (�� �޿��� ���� ������ ���)
SELECT EMPNO, ENAME FROM EMP 
WHERE SAL > (SELECT AVG(SAL) FROM EMP)
ORDER BY SAL DESC;


-- **3 ������ �������� : IN, ALL, ANY=SOME, EXISTS
--(1) IN : �������� ��� �� �ϳ��� ��ġ�ϸ� ��.
  -- EX. �μ���ȣ���� �Ի����� ���� ���� ����� �̸�, �Ի���, �μ���ȣ
SELECT DEPTNO, MAX(HIREDATE) FROM EMP GROUP BY DEPTNO; -- �������� (������)
SELECT ENAME, HIREDATE, DEPTNO                         -- ��������
   FROM EMP
   WHERE (DEPTNO, HIREDATE) IN (SELECT DEPTNO, MAX(HIREDATE) FROM EMP GROUP BY DEPTNO);
   
  -- EX. �޿� 3000 �̻� �޴� ����� �Ҽӵ� �μ����� �ٹ��ϴ� ����� ��� �ʵ�.
  SELECT DEPTNO FROM EMP WHERE SAL >= 3000; -- ��������
  SELECT * FROM EMP
  WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE SAL >= 3000); -- ��������
  
-- (2) ALL : �������� ����� ��� �����ؾ� ��.

  -- EX. 30�� �μ� �޿��� ��κ��� ū ��� = 30�� �μ� �ִ� �޿����� ū ��� �� ��� �ʵ�
SELECT SAL FROM EMP WHERE DEPTNO = 30;
SELECT * FROM EMP WHERE SAL > ALL (SELECT SAL FROM EMP WHERE DEPTNO = 30);
-- �� ������ ���������� ������ ����������
SELECT SAL FROM EMP WHERE DEPTNO = 30;
SELECT * FROM EMP WHERE SAL > (SELECT MAX(SAL) FROM EMP WHERE DEPTNO = 30);

-- (3) ANY = SOME : �������� ����� �ϳ��� �����ϸ� ��.
  -- EX. 30�� �μ� �޿��� �� �� ������ٵ� �޿��� ū ��� ��� = �ּұ޿����� ū��� 
SELECT SAL FROM EMP WHERE DEPTNO = 30;
SELECT * FROM EMP WHERE SAL > ANY (SELECT SAL FROM EMP WHERE DEPTNO = 30);  
 -- �� ������ ���������� ������ ����������  
SELECT SAL FROM EMP WHERE DEPTNO = 30;
SELECT * FROM EMP WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO = 30) ORDER BY SAL DESC;

-- (4) EXISTS ; �������� ����� �����ϸ� ��.
  -- EX. ���Ӻ��ϰ� �ִ� �������� ���, �̸�, �޿�
  SELECT EMPNO, ENAME, SAL  -- MAIN
     FROM EMP M
     WHERE EXISTS (SELECT * FROM EMP WHERE M.EMPNO = MGR ); -- SUB
     
  SELECT DISTINCT M.EMPNO, M.ENAME, M.SAL
  FROM EMP W, EMP M
  WHERE W. MGR = M.EMPNO;
  
  -- EX. ���� ������� ��� �ʵ�
 SELECT *  -- MAIN
     FROM EMP M
     WHERE NOT EXISTS (SELECT * FROM EMP WHERE M.EMPNO = MGR ); -- SUB    
  SELECT M.*  -- MAIN
     FROM EMP M , EMP W
     WHERE W.MGR(+) = M.EMPNO AND W.ENAME IS NULL;
     
-- źź������ 1. �μ����� ���� �޿��� ���� �޴� ����� ���� ���, �̸�, �޿�, �μ���ȣ �� ��� IN ������ �̿�.
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO; -- ��������
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM EMP
WHERE (DEPTNO, SAL) IN (SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO); -- ��������

-- źź2. ������ MANAGER�� ����� ���� �μ��� �μ���ȣ�� �μ���� ������ ����Ͻÿ�. IN �����ڷ�
SELECT DEPTNO FROM EMP WHERE JOB = 'MANAGER';
SELECT DEPTNO, DNAME, LOC FROM DEPT D
WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE JOB = 'MANAGER');

-- źź3. �޿� 3000 �̻��� ����� �� �޿� ����� ����� 
-- �ش� ��޺� �ְ� �޿��� �޴� ������� ��� �̸�, ����, �Ի���, �޿�, �޿������ ���
SELECT MAX(SAL) FROM EMP, SALGRADE 
WHERE SAL BETWEEN LOSAL AND HISAL AND SAL >= 3000
GROUP BY GRADE; -- ��������

SELECT EMPNO, ENAME, JOB, HIREDATE, SAL, GRADE
  FROM EMP, SALGRADE
 WHERE SAL BETWEEN LOSAL AND HISAL
   AND SAL IN (SELECT MAX(SAL) 
                 FROM EMP, SALGRADE 
                WHERE SAL BETWEEN LOSAL AND HISAL AND SAL >= 3000
             GROUP BY GRADE); -- ��������

--źź4. �����ȭ : �Ի��� �б⺰�� ���� ���� �޿��� �޴� �������
-- �б�, ���, �̸�, JOB, �����, �Ի���, �޿�, �󿩸� ����Ͻÿ�.
-- 1,2,3 -> 1 / 4,5,6 - 2 / 7,8,9 - 3/ 10, 11, 12 - 4 : �б� ������ MM/3�� �ø�.
SELECT HIREDATE, CEIL(EXTRACT(MONTH FROM HIREDATE)/3) "QUARTER" FROM EMP; -- CEIL EXTRACT�� �б� ���� ��������
SELECT HIREDATE, CEIL(TO_CHAR(HIREDATE, 'MM')/3) "QUARTER" FROM EMP;      -- CEIL TO_CHAR�� �б� ���� ��������
SELECT MAX(SAL) FROM EMP GROUP BY CEIL(EXTRACT(MONTH FROM HIREDATE)/3);
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, CEIL(EXTRACT(MONTH FROM HIREDATE)/3) || 'Q' "QUARTER" FROM EMP
WHERE SAL IN (SELECT MAX(SAL) FROM EMP GROUP BY CEIL(EXTRACT(MONTH FROM HIREDATE)/3)) ORDER BY "QUARTER"; -- MAIN ����

SELECT MAX(SAL) FROM EMP GROUP BY TO_CHAR(HIREDATE, 'Q');                   -- CEIL TO_CHAR 'Q'�� �б� ���� ��������
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, TO_CHAR(HIREDATE, 'Q')|| '�б�' "�б�" FROM EMP
WHERE SAL IN (SELECT MAX(SAL) FROM EMP GROUP BY TO_CHAR(HIREDATE, 'Q'))ORDER BY "�б�";

--źź 5. SALESMAN ��� ����� ���� �޿��� ���� �޴� ������� �̸��� ��� ������ ���
-- ���� ����� ������� �ʴ´�. ALL �̿�
SELECT SAL FROM EMP WHERE JOB = 'SALESMAN'; --SUB
SELECT ENAME, SAL, JOB
  FROM EMP
 WHERE SAL > ALL (SELECT SAL FROM EMP WHERE JOB = 'SALESMAN') AND JOB != 'SALESMAN'; -- ������ SUB�̿��� ��������
 SELECT SAL FROM EMP WHERE JOB = 'SALESMAN'; --SUB
SELECT ENAME, SAL, JOB
  FROM EMP
 WHERE SAL >(SELECT MAX(SAL) FROM EMP WHERE JOB = 'SALESMAN')AND JOB != 'SALESMAN' 
ORDER BY SAL; -- ������ �������� �̿��� ����

--źź 6. SALESMAN �� �� �Ѹ��̶� �޿��� ���� �޴� ������� �̸��� ��� ������ ���
-- ���� ����� ������� �ʴ´�.

SELECT SAL FROM EMP WHERE JOB = 'SALESMAN'; --SUB
SELECT ENAME, SAL, JOB
  FROM EMP
 WHERE SAL > ANY (SELECT SAL FROM EMP WHERE JOB = 'SALESMAN') AND JOB != 'SALESMAN'; -- ������ SUB�̿��� ��������

SELECT ENAME, SAL, JOB
  FROM EMP
 WHERE SAL >(SELECT MIN(SAL) FROM EMP WHERE JOB = 'SALESMAN')AND JOB != 'SALESMAN' 
ORDER BY SAL DESC; -- ������ �������� �̿��� ����

-- źź 7. ������ 3000 �̸� ��� �߿� ���� �ֱٿ� �Ի��� ����� ���, �̸�, �޿�, �Ի���
SELECT MAX(HIREDATE) FROM EMP WHERE SAL<3000;
SELECT EMPNO, ENAME, SAL, HIREDATE
  FROM EMP
  WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP WHERE SAL<3000);

-- ?	������ ��SALESMAN���� ����� �޴� �޿��� �ּ� �޿����� ���� �޴� ������� 
-- �̸�, �޿�, ����, �μ���ȣ�� ����ϵ� �μ���ȣ�� 20���� ����� �����Ѵ�(ANY ������ �̿�)
SELECT ENAME, SAL, JOB, DEPTNO
FROM EMP
WHERE SAL > ANY (SELECT SAL FROM EMP WHERE JOB = 'SALESMAN') AND DEPTNO!=20;







-- ���⼭���ʹ� �����༭�������� �����༭������, ������ �����༭������
-- 14.  �̸��� ��T���� �ִ� ����� �ٹ��ϴ� �μ����� �ٹ��ϴ� ��� ������ ��� ��ȣ,�̸�,�޿�(�� ��� �� ���)
SELECT EMPNO, ENAME, SAL FROM EMP
WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%')
ORDER BY EMPNO;

-- 15. �μ� ��ġ�� Dallas�� ��� �������� ���� �̸�,����,�޿�
SELECT ENAME, JOB ,SAL FROM EMP, DEPT
WHERE EMP.DEPTNO = DEPT.DEPTNO
   AND LOC = (SELECT LOC FROM DEPT WHERE LOC='DALLAS')
   ORDER BY SAL;
-- ���� ��������
SELECT ENAME, JOB ,SAL FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
AND LOC = 'DALLAS' ORDER BY SAL;

-- 16. EMP ���̺��� King���� �����ϴ� ��� ����� �̸��� �޿�
SELECT W.ENAME, W.SAL FROM EMP K, EMP W
WHERE K.EMPNO = W.MGR
AND W.MGR IN (SELECT K.EMPNO FROM EMP WHERE K.ENAME = 'KING');

-- 17. SALES�μ� ����� �̸�, ����
SELECT ENAME, JOB FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
  AND E.DEPTNO IN (SELECT DEPTNO FROM DEPT D WHERE DNAME = 'SALES')  ORDER BY ENAME;
--
SELECT ENAME, JOB FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
  AND DNAME = 'SALES' ORDER BY ENAME;


-- 18. ������ �μ� 30�� ���� ���޺��� ���� ����� ��� �ʵ�
SELECT * FROM EMP
WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO = 30 );
SELECT * FROM EMP
WHERE SAL > ANY (SELECT SAL  FROM EMP WHERE DEPTNO = 30 );


-- 19. �μ� 10���� �μ� 30�� ����� ���� ������ �ð� �ִ� ����� �̸��� ����
SELECT ENAME, JOB FROM EMP
WHERE DEPTNO = 10
  AND JOB IN (SELECT JOB FROM EMP WHERE DEPTNO = 30);

-- 20.  FORD�� ������ ���޵� ���� ����� ��� �ʵ�
SELECT * FROM EMP
WHERE (JOB, SAL) = (SELECT JOB, SAL FROM EMP WHERE ENAME = 'FORD') AND ENAME != 'FORD';

-- 21. �̸��� JONES�� ������ JOB�� ���ų� FORD�� SAL �̻��� �޴� ����� ������ �̸�, ����, �μ���ȣ, �޿�
-- ��, ������ ���ĺ� ��, ������ ���� ������ ���
SELECT ENAME, JOB, DEPTNO, SAL FROM EMP
WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME = 'JONES') AND ENAME != 'JONES'
   OR SAL >= (SELECT SAL FROM EMP WHERE ENAME = 'FORD') AND ENAME != 'FORD'
ORDER BY JOB, SAL DESC;
    

-- 22. SCOTT �Ǵ� WARD�� ������ ���� ����� ������ �̸�,����,�޿�
SELECT ENAME, JOB, SAL FROM EMP
WHERE SAL = (SELECT SAL FROM EMP WHERE ENAME = 'SCOTT') AND ENAME != 'SCOTT'
   OR SAL = (SELECT SAL FROM EMP WHERE ENAME = 'WARD')  AND ENAME != 'WARD';
 
   
   
-- 23. CHICAGO���� �ٹ��ϴ� ����� ���� ������ �ϴ� ������� �̸�,����
SELECT ENAME, JOB FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
  AND JOB IN (SELECT JOB FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND LOC = 'CHICAGO' )
  AND LOC != 'CHICAGO';


-- 24. �μ����� ������ ��� ���޺��� ���� ����� ���, �̸�, �޿�, �μ���ȣ
SELECT ROUND(AVG(SAL)),DEPTNO FROM EMP GROUP BY DEPTNO;
SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP E
WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO = E.DEPTNO)
ORDER BY DEPTNO;
SELECT DISTINCT E1.EMPNO, E1.ENAME, E1.SAL, E1.DEPTNO FROM EMP E1, EMP E2
WHERE  E1.DEPTNO = E2.DEPTNO
   AND E1.SAL > (SELECT AVG(E1.SAL) FROM EMP E1 WHERE E1.DEPTNO = E2.DEPTNO)
ORDER BY E1.SAL;
SELECT EMPNO, ENAME, SAL
  FROM EMP E, (SELECT DEPTNO, AVG(SAL)"AVG" FROM EMP GROUP BY DEPTNO) A
  WHERE E.DEPTNO = A.DEPTNO
  AND SAL > AVG 
  ORDER BY SAL; --INLINE VIEW �̿�
  
-- 24.1 �ش� �μ� ��պ��� ���, �̸�, �޿�, �μ���ȣ, �ش�μ������ (�Ҽ��� 2�ڸ�)
  SELECT EMPNO, ENAME, SAL, DEPTNO, 
         (SELECT ROUND(AVG(SAL),2) FROM EMP WHERE deptno = e.deptno) "�μ� ���" -- �μ� ��� ���� ��������
  FROM EMP E
  WHERE SAL > (SELECT ROUND(AVG(SAL),2) FROM EMP WHERE deptno = e.deptno) -- ������ �޿� > �μ����
  ORDER BY DEPTNO;


-- 25. �������� ��� ���޺��� ���� ������ �޴� ����� �μ���ȣ, �̸�, �޿�
SELECT ROUND(AVG(SAL)),JOB FROM EMP GROUP BY JOB;
SELECT DEPTNO, ENAME, SAL, JOB FROM EMP E
WHERE SAL < (SELECT AVG(SAL) FROM EMP WHERE JOB = E.JOB)
ORDER BY SAL;
SELECT ROUND(AVG(E1.SAL)) FROM EMP E1, EMP E2 WHERE E1.JOB = E2.JOB;

-- 26. ��� �� �� �̻����κ��� ���� ���� �� �ִ� ����� ����, �̸�, ���, �μ���ȣ�� ���(��, �μ���ȣ ������ �������� ����)
 SELECT EMPNO, ENAME, SAL  -- MAIN
     FROM EMP M
     WHERE EXISTS (SELECT * FROM EMP WHERE M.EMPNO = MGR ); -- SUB
     
SELECT DISTINCT M.JOB, M.ENAME, M.EMPNO, M.DEPTNO FROM EMP M, EMP W
WHERE M.EMPNO = W.MGR
ORDER BY DEPTNO;

-- 27.  ���� ����� ���, �̸�, ����, �μ���ȣ 
SELECT EMPNO, ENAME, JOB, DEPTNO  -- MAIN
     FROM EMP M
     WHERE NOT EXISTS(SELECT * FROM EMP WHERE M.EMPNO = MGR ); -- SUB












