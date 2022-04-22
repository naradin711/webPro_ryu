--[EMP] EMPNO(���;NUMBER), ENAME(�����;VARCHAR2), JOB(��å;VARCHAR2),
--MGR(����� ���;NUMBER), HIREDATE(�Ի���;DATE), SAL(�޿�;NUMBER)
--(��;NUMBER), DEPTNO(�μ���ȣ;NUMBER-DEPT���̺��� DEPTNO����)
--[DEPT] DEPTNO(�μ���ȣ;NUMBER), DNAME(�μ���;VARCHAR2), LOC(�ٹ���;VARCHAR2)
--[SALGRADE] GRADE(���;NUMBER), LOSAL(��� �� �����޿��񱳾�;NUMBER),
--HISAL(��� �� �ְ�޿��񱳾�;NUMBER)

-- 1. ������ ���̺��� ����� ����ϴ� SQL���� �ۼ��Ͻÿ�(5��).
SELECT * FROM TAB;
SELECT * FROM EMP;
SELECT * FROM DEPT;
SELECT * FROM SALGRADE;

-- 2. TO_DATE �������Լ��� �̿��Ͽ� EMP ���̺��� HIREDATE�� 1981�� 2�� 20�Ϻ��� 1981�� 5�� 1�� ���̿� �Ի��� ����� �����, ��å, �Ի����� �����Ի��Ϻ��� �ֱ��Ի��� ������ �����Ͽ� ����ϴ� SQL���� �ۼ��Ͻÿ�(5��).
SELECT ENAME �����, JOB ��å, HIREDATE �Ի��� FROM EMP 
    WHERE HIREDATE BETWEEN TO_DATE ('810220', 'RRMMDD')AND TO_DATE ('810501', 'RRMMDD')
    ORDER BY HIREDATE ;
-- 3. EMP���̺�� DEPT���̺��� self join�� outer join�� �̿��Ͽ� �����, �޿�, �μ���ȣ, �μ���, �ٹ���, ���ӻ����� ��簡 ���� �������� ��ü ���� �� ����ϴ� SQL���� �ۼ��Ͻÿ�. ��, ��簡 ���� ��� ���� ��� ���������� ����Ѵ�(5��).
SELECT W.ENAME �����, W.JOB ��å, W.DEPTNO �μ���ȣ, DNAME �μ���, LOC �ٹ���, NVL(M.ENAME,'����') ���ӻ��� 
    FROM EMP W, EMP M, DEPT D
    WHERE W.MGR = M.EMPNO(+) AND W.DEPTNO = D.DEPTNO;


-- 4. SALGRADE ���̺��� LOSAL�� ������� �޿�, HISAL�� ��� �ְ� �޿��� �̿��Ͽ�, EMP ���̺��� ����� ���, �����, ��å, �޿�, �޿������ �޿� ���� ������������ �����Ͽ� ����ϴ� SQL���� �ۼ��Ͻÿ�(5��).
SELECT EMPNO ���, ENAME �����, JOB ��å, SAL �޿�, GRADE �޿����
    FROM EMP E, SALGRADE S
    WHERE E.SAL BETWEEN LOSAL AND HISAL
    ORDER BY SAL DESC;

--5. EMP ���̺��� �μ���ȣ�� 20���� ����� ���, �����, �޿��� ����ϵ� �޿� �տ��� $�� ���̰�, ���ڴ� 3�ڸ����� �޸�( , )�� �߰��Ͽ� ����ϴ� SQL���� �ۼ��Ͻÿ�. �� �޿�(SAL)�� Ÿ���� NUMBER(7,2)�� �Ѵ�(5��).
SELECT EMPNO ���, ENAME �����, TO_CHAR(SAL, '$9,999,999.99') �޿� FROM EMP E WHERE DEPTNO = 20;

-- 6. EMP ���̺��� ��å�� �޿� ����� 3000�̻��� ��å�� ���Ͽ� �����, ��ձ޿�, �ݿ��� ���� ����ϴ� SQL���� �ۼ��Ͻÿ�(5��).

SELECT JOB, ROUND(AVG(SAL)), SUM(SAL) FROM EMP 
        GROUP BY JOB 
        HAVING AVG(SAL)>=3000 ;

    
-- 7. EMP���̺��� ������� ��FORD���� ������ ��å(JOB)�� �޿�(SAL)�� ���� ����� ��� ������ ����ϴ� SQL���� �ۼ��Ͻÿ�(5��).
SELECT * FROM EMP WHERE (JOB, SAL) =(SELECT JOB, SAL FROM EMP WHERE ENAME = 'FORD') AND ENAME!='FORD';

-- 8. EMP ���̺��� ������� ��FORD���� ����� �����ϴ� SQL���� �ۼ��Ͻÿ�(5��).
DELETE FROM EMP WHERE ENAME = 'FORD';


-- 9. �����ͺ��̽����� Ʈ������� ������ ó���� �� ������ ���Ѵ�. �����͸� �����ϱ� ���� INSERT, UPDATE, DELETE ���� ��ɵ��� ����ʰ� ���ÿ� Ʈ������� ����Ǵµ�, �̵� INSERT, UPDATE, DELETE�۾��� ���������� �����ͺ��̽��� �ݿ���ó���ǵ��� ��ɾ �ۼ��Ͻÿ�(5��).

CREATE TABLE DEPT02 AS SELECT * FROM DEPT; -- ���ο� ���̺� ����
SELECT * FROM DEPT02; -- ��� Ȯ��
INSERT INTO DEPT02 VALUES (99, 'GD', 'YG'); -- ���̺� ���ο� �� ����
SELECT * FROM DEPT02; -- ��� Ȯ��
COMMIT; --�����ͺ��̽��� �ݿ�
DELETE FROM DEPT02 WHERE DEPTNO IN (99,77); -- ���̺� �ش��ϴ� �� ����
SELECT * FROM DEPT02; -- ��� Ȯ��
COMMIT; --�����ͺ��̽��� �ݿ�
UPDATE DEPT02 SET DNAME = 'DONMILLS' WHERE DEPTNO = 88; -- 88�� �μ��� �μ��� ������Ʈ
SELECT * FROM DEPT02; -- ��� Ȯ��
COMMIT; --�����ͺ��̽��� �ݿ�

-- 10. EMP���̺��� ��������� ��ȸ�ϴ� �ð��� �����ϱ� ���� ���Ǵ� �ε��� ���� ��ɾ �ۼ��Ͻÿ�. ������ �ε����� �̸��� IDX_EMP_ENAME���� �Ѵ�(10��).
DROP TABLE EMP02;
CREATE TABLE EMP02 AS SELECT * FROM EMP; -- EMP�� �Ȱ��� ���̵����� ����
SELECT * FROM EMP02; -- ���̵����� ��ȸ
INSERT INTO EMP02 SELECT * FROM EMP02; -- ��� �� ������Ű��
INSERT INTO EMP02 (EMPNO, ENAME) VALUES (1111,'HONG'); --ã�� ������ ����
INSERT INTO EMP02 SELECT * FROM EMP02; -- ��� �� ������Ű��
SELECT * FROM EMP02 WHERE ENAME = 'HONG'; -- �ε��� ���� �� �˻� �ӵ� 0.002��
CREATE INDEX IDX_EMP_ENAME ON EMP02(ENAME); -- �ε��� ����
SELECT * FROM EMP01 WHERE ENAME = 'HONG'; -- �ε��� ���� ���� 0.012��

-- 11. ���� ���� ������ ���̺� ���� ������ ������ ������ ��ųʸ��並 ���캸�� SQL���� �ۼ��Ͻÿ�(5��).

SELECT * FROM USER_INDEXES;
