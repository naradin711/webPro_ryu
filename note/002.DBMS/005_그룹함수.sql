-- [V] �׷��Լ� : SUM, AVG, MIN, MAX, COUNT, STDDEV (ǥ������), VARIANCE

SELECT ENAME, ROUND(SAL, -3) FROM EMP; -- ������ �Լ� 
SELECT MAX(SAL) FROM EMP; -- SAL�߿��� ���� ���� ���� ���
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO; -- ����� ������ ���� ���� �Ŀ� �μ��� �ִ� �޿��� ����
SELECT ENAME, MAX(SAL) FROM EMP; -- �ִ�޿��� �޴� ����� �̸��� ���Ͻÿ� (6��, ��������)

-- 1. �׷��Լ��� �ǽ�
SELECT ROUND(AVG(SAL),2) FROM EMP; -- �� �޿��� ����� ���Ͻÿ� 
SELECT COUNT(*) FROM EMP; -- �ش� ���̺��� ��(LOW, ����)���� ���Ͻÿ�.
SELECT AVG(SAL), SUM(SAL)/COUNT(SAL) FROM EMP;
SELECT AVG(COMM) FROM EMP;

-- ��� �׷��Լ��� NULL�� �ڵ����� �����ϰ� �����.
SELECT SUM(COMM), AVG(COMM), COUNT(COMM), MIN(COMM), MAX(COMM) FROM EMP; 
-- SAL�� ���, ��, �ּұ޿�, �ִ�޿�, �޿��л�, �޿�ǥ������, �޿������� ���Ͻÿ�.
SELECT ROUND(AVG(COMM)) "�޿����", SUM(SAL) "�� �޿�",  ROUND(VARIANCE (SAL)) "�޿��л�" , ROUND(STDDEV(SAL)) "�޿�ǥ������",
MIN(SAL), MAX(SAL), COUNT(SAL)"�޿�����" FROM EMP;

--���� �ֱٿ� �Ի��� ����� �Ի��ϰ� �Ի����� ���� ������ ����� �Ի����� ���. 
SELECT MAX(HIREDATE)"�ֱ��Ի���", MIN(HIREDATE)"�����Ի���" FROM EMP;

-- �ֱ� �Ի��� : XX,XXX�� , �����Ի��� : XX,XXX�� �ٹ�
SELECT MAX(HIREDATE) ||' �ֱ��Ի��� : ' "�ֱ��Ի���" , 
           TO_CHAR(FLOOR(SYSDATE-MAX(HIREDATE)), '999,999')  || '�� �ٹ�,' "�ּұٹ��ϼ�", 
       MIN(HIREDATE) ||' �����Ի��� : ' "�����Ի���", 
           TO_CHAR(FLOOR(SYSDATE-MIN(HIREDATE)), '999,999')  || '�� �ٹ�' "�ִ�ٹ��ϼ�" 
FROM EMP;
           
SELECT MAX(HIREDATE) || ' �ֱ��Ի��� : ' ||           
           TO_CHAR(MIN(SYSDATE-HIREDATE), '999,999')  || '�� �ٹ�,',
        MIN(HIREDATE) || ' �����Ի��� : ' ||           
           TO_CHAR(MAX(SYSDATE-HIREDATE), '999,999')  || '�� �ٹ�,'
FROM EMP;           

-- 10�� �μ� �Ҽ��� ��� �߿��� Ŀ�̼��� �޴� ����� ���� ���� ���ÿ�.
SELECT COUNT(COMM) FROM EMP WHERE DEPTNO=10 AND COMM IS NOT NULL;

-- 10�� �μ� �Ҽ��� ��� �޿� ���
SELECT FLOOR(AVG(SAL)) FROM EMP WHERE DEPTNO=10;
SELECT FLOOR(AVG(SAL)) FROM EMP WHERE DEPTNO=20;
SELECT FLOOR(AVG(SAL)) FROM EMP WHERE DEPTNO=30;

-- �μ��� ��� �ִ�޿� �ּұ޿� �޿� ��� �� �޿��� ���Ͻÿ�
SELECT DEPTNO "�μ���ȣ", MAX(SAL) "�ִ�޿�", MIN(SAL) "�ּұ޿�", FLOOR(AVG(SAL))"��ձ޿�", SUM(SAL) "�� �޿�" 
FROM EMP GROUP BY DEPTNO; -- �׷���������� ���� ��� �ȵ�
SELECT DEPTNO "�μ���ȣ", MAX(SAL) "�ִ�޿�", MIN(SAL) "�ּұ޿�", ROUND(AVG(SAL),2) "��ձ޿�", SUM(SAL) "�� �޿�" 
FROM EMP GROUP BY DEPTNO;
  -- EX. �޿��� 5000�̸� ����� ���ؼ��� �μ� ��ȣ�� �����, �ִ�޿�, �ּұ޿�, ��ձ޿� ����Ͻÿ�.
SELECT DEPTNO"�μ�", COUNT(DEPTNO) "�μ��������", MAX(SAL) "�ִ�޿�", MIN(SAL) "�ּұ޿�", ROUND(AVG(SAL),2) "��ձ޿�" 
                                        ---- SELECT �������� �ʵ� ��Ī ����
FROM EMP 
WHERE SAL < 5000                        ---- WHERE �������� �ʵ� ��Ī �Ұ���
GROUP BY DEPTNO                         ---- GROUP BY �������� �ʵ� ��Ī �Ұ���
ORDER BY DEPTNO;                        ---- ORDER BY �������� �ʵ� ��Ī ����

-- EX. �μ��� �����, �ִ�޿�, �ּұ޿�, ��ձ޿� ��� ������� ���� ������ ����

SELECT DNAME "�μ���", COUNT(E.DEPTNO) "�μ��������", MAX(SAL) "�ִ�޿�", MIN(SAL) "�ּұ޿�", ROUND(AVG(SAL),2) "��ձ޿�" 
                                        ---- SELECT �������� �ʵ� ��Ī ����
FROM EMP E, DEPT D 
WHERE e.deptno = D.DEPTNO               ---- WHERE �������� �ʵ� ��Ī �Ұ���
GROUP BY DNAME                          ---- GROUP BY �������� �ʵ� ��Ī �Ұ���
ORDER BY COUNT(E.DEPTNO) DESC;          ---- ORDER BY �������� �ʵ� ��Ī ����

-- 3. HAVING �� : �׷��Լ� ����� ���Ǹ� ���

-- �μ���ȣ���� ��� �޿� ��� (��ձ޿��� 2000�̻��� �μ��� ���)
SELECT DEPTNO, ROUND(AVG(SAL),2) "���" 
FROM EMP 
HAVING AVG(SAL) >= 2000 -- �׷��Լ����� WHERE���� ������� �ʴ´�.
                        -- HAVING ������ ��Ī�� �� �� ����.
GROUP BY DEPTNO
ORDER BY ��� DESC;

-- SAL 5000�̸��� ����� ���� �μ��� �ּұ޿�, �ִ�޿�, ��ձ޿�
-- (��, ��ձ޿��� 1800�̻��� �μ��� ���ؼ� ��� �޿������� ���� ���)

SELECT DNAME "�μ���", MIN(SAL) "�ּұ޿�", MAX(SAL) "�ִ�޿�",  ROUND(AVG(SAL),2) "��ձ޿�"                                      
FROM EMP E, DEPT D 
WHERE e.deptno = D.DEPTNO AND SAL < 5000  
HAVING ROUND(AVG(SAL),2)>=1800
GROUP BY DNAME                          
ORDER BY ROUND(AVG(SAL),2);    

--4. ��� ������ �� ���谪 ����.
SELECT NVL(TO_CHAR(DEPTNO), '����'), SUM(SAL) FROM EMP GROUP BY ROLLUP(DEPTNO);

   -- �μ���, JOB�� �޿� ��. �Ұ�� ��ü�� ����.
SELECT NVL(TO_CHAR(DEPTNO), '�Ұ�')"�μ�", NVL(JOB, '�Ұ�')"����", SUM(SAL) FROM EMP GROUP BY ROLLUP (DEPTNO, JOB);


-- �׷��Լ� ��������.

-- 1. �ο���,�ִ� �޿�,�ּ� �޿�,�޿��� ���� ���
SELECT COUNT(*), MAX(SAL),MIN(SAL),SUM(SAL)FROM EMP;

-- 2. ������ �ο����� ���Ͽ� ���
SELECT JOB, COUNT(JOB) FROM EMP GROUP BY JOB;

--- 3. �ְ� �޿��� �ּ� �޿��� ���̴� ���ΰ� ���
SELECT MAX(SAL)-MIN(SAL) FROM EMP;

-- 4. �� �μ����� �ο���, �޿� ���, ���� �޿�, �ְ� �޿�, �޿��� ���� ���(�޿��� ���� ���� ������)
SELECT COUNT(*), ROUND(AVG(SAL)) ,MIN(SAL),MAX(SAL),SUM(SAL)FROM EMP 
GROUP BY DEPTNO 
ORDER BY SUM(SAL) DESC;

-- 5. �μ���, ������ �׷��Ͽ� ����� �μ���ȣ, ����, �ο���, �޿��� ���, �޿��� ���� ���(�μ���ȣ, ���������� �������� ����)
SELECT DEPTNO, JOB, COUNT(*), ROUND(AVG(SAL)),SUM(SAL)
FROM EMP 
GROUP BY DEPTNO, JOB 
ORDER BY DEPTNO, JOB;


-- 6. ������, �μ��� �׷��Ͽ� �����  ����, �μ���ȣ, �ο���, �޿��� ���, �޿��� ���� ���(��°���� ������, �μ���ȣ �� �������� ����)
SELECT JOB, DEPTNO,  COUNT(*), ROUND(AVG(SAL)),SUM(SAL)
FROM EMP 
GROUP BY JOB, DEPTNO 
ORDER BY JOB , DEPTNO;

--7. ������� 5���̻� �Ѵ� �μ���ȣ�� ������� ���
SELECT DEPTNO,  COUNT(*)
FROM EMP 
HAVING COUNT(DEPTNO)>=5
GROUP BY DEPTNO;

-- 8. ������� 5���̻� �Ѵ� �μ���� ������� ���
SELECT DNAME,  COUNT(*)
FROM EMP E, DEPT D
WHERE e.deptno = D.DEPTNO
HAVING COUNT(E.DEPTNO)>=5
GROUP BY DNAME;

--9. ������ �޿��� ����� 3000�̻��� ������ ���ؼ� ������, ��� �޿�, �޿��� ���� ���
SELECT JOB, ROUND(AVG(SAL)) "��ձ޿�", SUM(SAL)
FROM EMP
HAVING ROUND(AVG(SAL))>=3000
GROUP BY JOB;

--10. �޿� ���� 5000�� �ʰ��ϴ� �� ������ ���ؼ� ������ �޿����� ���(�޿� �հ�� �������� ����)
SELECT JOB,  SUM(SAL)
FROM EMP
HAVING SUM(SAL) >5000
GROUP BY JOB
ORDER BY SUM(SAL) DESC ;


--11. �μ��� �޿����, �μ��� �޿��հ�, �μ��� �ּұ޿��� ���
SELECT DEPTNO, ROUND(AVG(SAL)),SUM(SAL),MIN(SAL)
FROM EMP 
GROUP BY DEPTNO 
ORDER BY DEPTNO;


--12. ���� 11���� �����Ͽ�, �μ��� �޿���� �ִ�ġ, �μ��� �޿����� �ִ�ġ, �μ��� �ּұ޿��� �ִ�ġ�� ���
SELECT  ROUND(MAX(AVG(SAL))),MAX (SUM(SAL)),MAX(MIN(SAL))
FROM EMP
GROUP BY DEPTNO;


--13. ��� ���̺��� �Ʒ��� ����� ���
--   H_YEAR	COUNT(*)	MIN(SAL)	MAX(SAL)	AVG(SAL)	SUM(SAL)
--     80	  1		    800		    800		    800		    800
--	81	 10		    950		    5000	    2282.5	  22825
--	82	  2		    1300	    3000	   2150		   4300
--	83	  1		    1100	    1100	    1100	   1100

SELECT TO_CHAR(HIREDATE, 'YY')"H_YEAR", COUNT(*) , MIN(SAL), MAX(SAL), ROUND(AVG(SAL),1) "AVG(SAL)" ,SUM(SAL)
FROM EMP
GROUP BY TO_CHAR(HIREDATE, 'YY')
ORDER BY TO_CHAR(HIREDATE, 'YY');



-- 14.  �Ʒ��� ����� ���(�Ի�⵵�� �����)
--  1980     1	
--  1981     10
--  1982     2
--  1983     1
--  total    14	
SELECT NVL (TO_CHAR(HIREDATE, 'YYYY'), 'TOTAL'), COUNT (*)
FROM EMP
GROUP BY ROLLUP (TO_CHAR(HIREDATE, 'YYYY'))
ORDER BY TO_CHAR(HIREDATE, 'YYYY');


--15. �ִ�޿�, �ּұ޿�, ��ü�޿���, ����� ���
SELECT MAX(SAL), MIN(SAL), SUM(SAL), ROUND(AVG(SAL)) "���"
FROM EMP;

--16. �μ��� �ο��� ���
SELECT DEPTNO, COUNT(DEPTNO)
FROM EMP
GROUP BY DEPTNO;

--17. �μ��� �ο����� 6���̻��� �μ���ȣ ���
SELECT DEPTNO
FROM EMP
HAVING COUNT(DEPTNO)>=6
GROUP BY DEPTNO;

--18. �޿��� ���� ������� ����� �ο��Ͽ� ������ ���� ����� ������ �Ͻÿ�. 
-- (��Ʈ self join, group by, count���)
--ENAME	    ���
--________________________
--KING		1
--SCOTT		2
--����

SELECT E1.ENAME, COUNT(E2.ENAME)+1 || '��' "���" --������ ���� �޴� ����� ��
FROM EMP E1, EMP E2
WHERE E1.SAL < E2.SAL (+) --1�ܰ� : SELF JOIN / OUTER JOIN
GROUP BY E1.ENAME
ORDER BY COUNT(E2.ENAME);

SELECT ENAME, RANK() OVER(ORDER BY SAL DESC)"RANK" FROM EMP;





















