-- [X] VIEW , INLINE VIEW, TOP N ����
-- 10.1 VIEW : ������ ���̺� (1) �ܼ��� (2) ������
-- 10.1.(1) �ܼ��� : �ϳ��� ���̺�� ������ VIEW
-- EMPV0�̶�� ������ VIEW�� ���� �Ǵ� ���� = EMP ���̺� �Ϻθ� ���� ������ ���̺�
SELECT * FROM USER_VIEWS; -- ������ ��ųʸ� VIEW Ȯ��
CREATE OR REPLACE VIEW EMPV0 
       AS SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, DEPTNO FROM EMP; -- VIEW EMPV0 �����ϱ�
       -- DDL�� �����ϸ� ������ ��ųʸ� �ڵ� ���� 
SELECT * FROM EMPV0;
INSERT INTO EMPV0 VALUES (1111, 'ȫ', 'ITMANAGER', 7369, SYSDATE, 40); -- ���� ���� Į��. �信 �μ�Ʈ
SELECT * FROM EMPV0;
SELECT * FROM EMP; -- VIEW�� �μ�Ʈ�ϸ� �� ���������� �˾ƺ���.

UPDATE EMPV0 SET JOB = 'MANAGER' WHERE EMPNO = 1111; -- VIEWR�� UPDATE�ϸ� EMP���̺� ������Ʈ
SELECT * FROM EMPV0;
SELECT * FROM EMP;

DELETE FROM EMPV0 WHERE EMPNO = 1111; -- VIEW ����� ���̺� VIEW�� ��������.

-- EMPV0�̶�� VIEW ���� : EMP���̺��� 30�� �μ��ุ.

CREATE OR REPLACE VIEW EMPV0
       AS SELECT * FROM EMP WHERE DEPTNO=30;

DESC EMPV0;
SELECT * FROM EMPV0;

INSERT INTO EMPV0 VALUES (1111, 'ȫ', NULL, NULL, SYSDATE, 9000, 9000, 30);
SELECT * FROM EMPV0;
SELECT * FROM EMP;


-- 40�� �μ� �Է��� �����ϳ� VIEW������ ������ ����.
INSERT INTO EMPV0 VALUES (1112, '��', NULL, NULL, SYSDATE, 8000, 8000, 40);

SELECT * FROM EMPV0;
SELECT * FROM EMP;
DELETE FROM EMPV0 WHERE EMPNO IN (1111,1112);

SELECT * FROM EMPV0;
SELECT * FROM EMP;

DELETE FROM EMP WHERE DEPTNO =40; -- 40�� �μ��� EMP���� ����

SELECT * FROM EMPV0;
SELECT * FROM EMP; 

-- EMPV0 VIEW ���� : ENAME, JOB, HIREDATE������ VIEW�� �����ϱ�
-- NOT NULL�̳� PRIMARY KEY�� �Ǵ� �ʵ带 �������ϸ� INSERT �Ұ�.
CREATE OR REPLACE VIEW EMPV0
       AS SELECT ENAME, JOB, HIREDATE FROM EMP;
       
INSERT INTO EMPV0 VALUES ('ȫ', 'SALESMAN', SYSDATE);       
COMMIT;

-- VIEW�� ���� ���� (1)VIEW�� ���� (2) �б�����
-- WITH CHECK OPTION�� ������ VIEW�� VIEW ���ǿ� �ش��ϴ� �����͸� ����, ����, ���� ����
-- WITH READ ONLY�� ������  VIEW�� �б� ���� VIEW

-- EMPv0 : EMP ���̺��� 30�� �μ��� ������
CREATE OR REPLACE VIEW EMPv0
       AS SELECT * FROM EMP WHERE DEPTNO = 30
       WITH CHECK OPTION;

INSERT INTO EMPv0 VALUES (1111, 'ȫ', NULL, NULL, SYSDATE, 9000, 9000, 30);
INSERT INTO EMPv0 VALUES (1112, '��', NULL, NULL, SYSDATE, 3000, 3000, 40); -- WHERE ���ǿ� �������� ������ INSERT �Ұ���
SELECT * FROM EMP;
DELETE FROM EMPv0 WHERE ENAME = 'SMITH'; -- 20�� �μ� SMITH DELETE�� �ȵ�.
DELETE FROM EMPv0 WHERE EMPNO = 1111; -- 30�� �μ� ȫ DELETE
SELECT * FROM EMP;

-- EMPv0 �б� ���� VIEW

CREATE OR REPLACE VIEW EMPv0
       AS SELECT EMPNO, ENAME, JOB, MGR, DEPTNO FROM EMP
       WITH READ ONLY;
       
INSERT INTO EMPv0 VALUES (1111, 'ȫ', NULL, NULL, 30);     -- �б� ������ INSERT �Ұ�.  


-- 10.1.(2) ����VIEW : 2�� �̻��� ���̺�� ������ VIEW�̰ų� ������ �ʵ�� VIEW�� ���� ���
--                    DML���� ���������� ��� ������.

CREATE OR REPLACE VIEW EMPV0
       AS SELECT EMPNO, ENAME, JOB, DNAME, LOC
       FROM EMP E, DEPT D
       WHERE E.DEPTNO = D.DEPTNO;

SELECT * FROM EMPV0;       

INSERT INTO EMPV0 VALUES (1111, 'HONG', 'MANAGER', 'RESEARCH', 'DALLAS'); -- ���� VIEW�� INSERT, UPDATE �Ұ�! 

-- ������ �ʵ�� VIEW : COULMN�� ALIAS(�����ڷ� ����, ������, ����)�� �̿��Ͽ� VIEW ����
CREATE OR REPLACE VIEW EMPV0
       AS SELECT EMPNO, ENAME, SAL*12 "YEALYSAL" FROM EMP WHERE DEPTNO = 10; -- �ʵ忡 �Լ��� Ư�����ڰ� ������ ALIAS�� �����Ͽ� Į���� �νĽ�Ų��.

CREATE OR REPLACE VIEW EMPV0(EMPNO, ENAME, YEALYSAL)
       AS SELECT EMPNO, ENAME, SAL*12 FROM EMP WHERE DEPTNO = 20; -- ��Ī�鸸 ���� ������Ŵ

SELECT * FROM EMPV0;

-- EX. �μ���ȣ, �ּұ޿�, �ִ�޿�, �μ���ձ޿��� ������ VIEW DEPTV1�� �����Ͻÿ�

CREATE OR REPLACE VIEW DEPTV1
       AS SELECT E.DEPTNO, MIN(SAL) "MINSAL", MAX(SAL)"MAXSAL", ROUND(AVG(SAL)) "AVGSAL"
       FROM EMP E, DEPT D
       WHERE E.DEPTNO = D.DEPTNO
       GROUP BY E.DEPTNO;

SELECT * FROM DEPTV1;

--EX. ��å, �μ��� ������ EMPV0 VIEW�� ����

CREATE OR REPLACE VIEW EMPV0
       AS SELECT DISTINCT JOB, DEPTNO FROM EMP ORDER BY DEPTNO; -- DISTINCT �����ϸ� INSERT �Ұ�

SELECT * FROM  EMPV0;

-- 10. 2. INLINE VIEW : FROM�� ���� ���������� INLINE VIEW��� �ϸ�, FROM���� ���� ���������� VIEWó�� ����
-- EX. �޿��� 2000�� �ʰ��ϴ� ����� ��� �޿�.
SELECT AVG(SAL) FROM EMP WHERE SAL > 2000;
SELECT AVG(SAL) FROM (SELECT SAL FROM EMP WHERE SAL> 2000); -- ���⼭ FROM ���� SELECT ���� INLINE VIEW 

-- EX. �μ� ��� ���޺��� ���� ����� ���, �̸�, �޿�, (�������� �������� 24, 25)

SELECT EMPNO, ENAME, SAL 
  FROM EMP E
 WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO = E.DEPTNO) -- ��������
ORDER BY DEPTNO;
SELECT EMPNO, ENAME, SAL
  FROM EMP E, (SELECT DEPTNO, AVG(SAL)"AVG" FROM EMP GROUP BY DEPTNO) A
  WHERE E.DEPTNO = A.DEPTNO
  AND SAL > AVG 
  ORDER BY SAL; --INLINE VIEW �̿�
  

-- 10. 3. TOP-N���� (TOP 1~10��/ TOP 11~20�� / TOP 6~10��)  
-- ** ROMNUM = FROM ���� ���̺�κ��� ������ ����!
SELECT ROWNUM, ENAME FROM EMP WHERE DEPTNO=20 ORDER BY ENAME;

-- ���, �̸�, SAL(��ü�࿡ ����)
SELECT ROWNUM, ENAME, SAL FROM EMP ORDER BY SAL DESC; -- ROWNUM != RANK
SELECT ROWNUM, ENAME, SAL FROM (SELECT * FROM EMP ORDER BY SAL DESC); -- ROWNUM = RANK  

-- �Լ��� �̿���  RANK ���
SELECT RANK () OVER (ORDER BY SAL DESC) RANK,              -- RANK �ߺ� ��� ����
       DENSE_RANK () OVER (ORDER BY SAL DESC) DENSE_RANK,  -- DENSE_RANK  �ߺ� ��� ����
       ROW_NUMBER () OVER  (ORDER BY SAL DESC) ROW_NUMBER, -- ROW_NUMBER �ߺ� ��� ����
       ENAME, SAL FROM EMP;

-- SAL �������� 1~5�� ������ ���
 SELECT ROWNUM, ENAME, SAL 
        FROM (SELECT * FROM EMP ORDER BY SAL DESC)
        WHERE ROWNUM <=5;

-- SAL �������� 6~10�� ������ ���
SELECT ROWNUM, ENAME, SAL 
        FROM (SELECT * FROM EMP ORDER BY SAL DESC)
        WHERE ROWNUM BETWEEN 6 AND 10; -- ����� 1�൵ �ȳ���. TOP N ���� �ƴ�.
        
-- ** TOP N ���� 1�ܰ�
SELECT ROWNUM RN, ENAME, SAL 
       FROM(SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC);
-- ** TOP N ���� 2�ܰ� -- (�ϼ��� TOP-N����)
SELECT ROWNUM, RN, ENAME, SAL
       FROM(SELECT ROWNUM RN, ENAME, SAL FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC)) "A"
       WHERE RN BETWEEN 6 AND 10;
SELECT ROWNUM, RN, ENAME, SAL
       FROM(SELECT ROWNUM RN, ENAME, SAL FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC) "A" ) 
       WHERE RN BETWEEN 10 AND 14;
       
-- �̸��� ���ĺ� ������� �����ؼ� 6~10������ ��� (���, �̸�, ���, JOB, MGR, HIREDATE)
SELECT ROWNUM, RN, ENAME, EMPNO, JOB, MGR, HIREDATE
       FROM(SELECT ROWNUM RN, A.* FROM (SELECT ENAME, EMPNO, JOB, MGR, HIREDATE FROM EMP ORDER BY ENAME DESC)"A") 
       WHERE RN BETWEEN 6 AND 10;
       
-- <10�� �� ��������>

-- 1. �μ���� ������� ����ϴ� �뵵�� ��, DNAME_ENAME_VU �� �ۼ��Ͻÿ�
CREATE OR REPLACE VIEW DNAME_ENAME_VU
       AS SELECT DNAME, ENAME FROM DEPT D, EMP E
       WHERE D.DEPTNO = E.DEPTNO;
SELECT * FROM DNAME_ENAME_VU;     

-- 2. ������ ���ӻ������ ����ϴ� �뵵�� ��,  WORKER_MANAGER_VU�� �ۼ��Ͻÿ�
CREATE OR REPLACE VIEW WORKER_MANAGER_VU
       AS SELECT W.ENAME "WORKERNAME", M.ENAME "MANAGERNAME" FROM EMP M, EMP W
       WHERE W.MGR = M.EMPNO;
SELECT * FROM   WORKER_MANAGER_VU;     

-- 3. �μ��� �޿��հ� ����� ����Ͻÿ�(�μ���ȣ, �޿��հ�, ���). -- �л� ����
SELECT DEPTNO, "SUMSAL" ,ROWNUM "RANK"
FROM (SELECT DEPTNO, SUM(SAL)"SUMSAL" FROM EMP GROUP BY DEPTNO ORDER BY SUM(SAL) DESC);

-- 3-1. �μ��� �޿��հ� ����� 2~3���� �μ���ȣ, �޿��հ�, ����� ����Ͻÿ�.
SELECT DEPTNO, "SUMSAL", "RANK"
FROM (SELECT A.* ,ROWNUM "RANK"
FROM (SELECT DEPTNO, SUM(SAL)"SUMSAL" FROM EMP GROUP BY DEPTNO ORDER BY SUM(SAL) DESC)"A")
WHERE RANK BETWEEN 2 AND 3;

-- 4. ������̺��� ���, �����, �Ի����� �Ի����� �ֽſ��� ������ ��� ������ �����Ͻÿ�
SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC;

-- 5. ������̺��� ���, �����, �Ի����� �Ի����� �ֽſ��� ������ ��� 5���� ����Ͻÿ�
SELECT EMPNO, ENAME, HIREDATE 
  FROM (SELECT ROWNUM RN, EMPNO, ENAME, HIREDATE FROM (SELECT * FROM EMP ORDER BY HIREDATE DESC))
  WHERE RN <=5;

-- 6. ��� ���̺��� ���, �����, �Ի����� �ֽź��� ������ ������ 6��°�� ���� ������� 10��° ������� ���
 SELECT EMPNO, ENAME, HIREDATE 
  FROM (SELECT ROWNUM RN, EMPNO, ENAME, HIREDATE FROM (SELECT * FROM EMP ORDER BY HIREDATE DESC))
  WHERE RN BETWEEN 6 AND 10;     
       








































































