-- empDept.sql 입니다.
--Dept.xml  id=deptList
SELECT * FROM DEPT;



-- Emp.xml ID = empList
SELECT * FROM EMP ORDER BY EMPNO; -- 출력 조건
SELECT * FROM
    (SELECT ROWNUM RN, A.* FROM (SELECT * FROM EMP ORDER BY EMPNO)A)
    WHERE RN BETWEEN 1 AND 15; -- TOPN구문 및 페이징 용 조회
-- Emp.xml ID=totCnt    
SELECT COUNT(*) CNT FROM EMP;
-- Emp.xml ID=detail -- EMPNO로 DTO 불러오기 (상세 출력)
SELECT * FROM EMP WHERE EMPNO=7369;
-- Emp.xml ID=managerList
SELECT * FROM EMP WHERE EMPNO IN (SELECT MGR FROM EMP);
-- Emp.xml ID=insert
INSERT INTO EMP VALUES (9000, 'SUJEONG', 'IT', 7902, '2022-07-20', 6000, 80, 40);
-- Emp.xml ID=update
UPDATE EMP SET ENAME = 'RYUVELY',
                JOB = 'MANAGER',
                MGR = 7869,
                HIREDATE = '1994-11-19',
                SAL = 7000,
                COMM = 180,
                DEPTNO = 20
                WHERE EMPNO = 9000;
-- Emp.xml ID=delete
DELETE FROM EMP WHERE EMPNO=9000;

-- EmpDept.xml id = empDeptList

SELECT E.*, DNAME, LOC FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO ORDER BY EMPNO; -- 출력조건
SELECT * FROM
    (SELECT ROWNUM RN, A.* FROM (SELECT E.*, DNAME, LOC FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO ORDER BY EMPNO DESC) A)
    WHERE RN BETWEEN 1 AND 15;
    
    







