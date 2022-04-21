-- Ex 1 : 사용자에게 부서번호를 입력받아 부서 정보 출력
SELECT * FROM DEPT WHERE DEPTNO=30;
INSERT INTO DEPT VALUES (50, 'IT', 'SEOUL');
SELECT * FROM DEPT;
ROLLBACK;

-- Ex 2 : 사용자에게 부서번호를 입력받아서 EMP의 정보 출력.
-- 해당 부서의 정보와 사원 정보(사번, 이름, 급여, 상사명)를 출력
SELECT * FROM DEPT WHERE DEPTNO=40;
SELECT W.EMPNO empno , W.ENAME ename, W.SAL sal, M.ENAME MGRNAME
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO AND W.DEPTNO = 30;

-- Ex 3 부서 정보와 사원정보(사번, 이름, 급여, 급여등급)를 출력
SELECT * FROM DEPT WHERE DNAME=UPPER('SALES');
SELECT EMPNO, ENAME, SAL, GRADE
    FROM EMP e, SALGRADE S, DEPT D
    WHERE SAL BETWEEN LOSAL AND HISAL AND E.DEPTNO = D.DEPTNO AND DNAME=UPPER('SALES');
 SELECT EMPNO, ENAME, SAL, GRADE
    FROM EMP e, SALGRADE S
    WHERE SAL BETWEEN LOSAL AND HISAL AND DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME=UPPER('SALES'));   
select * from dept;    
    
    
-- Ex 4

