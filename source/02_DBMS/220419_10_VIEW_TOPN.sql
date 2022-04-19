-- [X] VIEW , INLINE VIEW, TOP N ����
-- 10.1 VIEW : ������ ���̺� (1) �ܼ��� (2) ������
-- 10.1.(1) �ܼ��� : �ϳ��� ���̺��� ������ VIEW
-- EMPV0�̶�� ������ VIEW�� ���� �Ǵ� ���� = EMP ���̺� �Ϻθ� ���� ������ ���̺�
SELECT * FROM USER_VIEWS; -- ������ ��ųʸ� VIEW Ȯ��
CREATE OR REPLACE VIEW EMPV0 
       AS SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, DEPTNO FROM EMP; -- VIEW EMPV0 �����ϱ�
       -- DDL�� �����ϸ� ������ ��ųʸ� �ڵ� ���� 
SELECT * FROM EMPV0;
INSERT INTO EMPV0 VALUES (1111, 'ȫ', 'ITMANAGER', 7369, SYSDATE, 40); -- ���� ���� Į��. �信 �μ�Ʈ
SELECT * FROM EMPV0;
SELECT * FROM EMP; -- VIEW�� �μ�Ʈ�ϸ� �� ���������� �˾ƺ���.

UPDATE EMPV0 SET JOB = 'MANAGER' WHERE EMPNO = 1111; -- VIEWR�� UPDATE�ϸ� EMP���̺��� ������Ʈ
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

-- EMPv0 : EMP ���̺����� 30�� �μ��� ������
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


-- 10.1.(2) ����VIEW : 2�� �̻��� ���̺��� ������ VIEW�̰ų� ������ �ʵ�� VIEW�� ���� ���
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

-- 24. �μ� ��� ���޺��� ���� ����� ���, �̸�, �޿�, (�������� �������� 24, 25)
SELECT ROUND(AVG(SAL)),DEPTNO FROM EMP GROUP BY DEPTNO;
SELECT EMPNO, ENAME, SAL FROM EMP E
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























































































