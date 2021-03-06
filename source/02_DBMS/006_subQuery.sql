--[VI] SUB QUERY : QUERY안에 QUERY가 내포되어 있음.
-- SELECT FIELD 1 (SELECT FIELD 2 FROM TABLE WHERE 조건)
-- FROM TABLE 
-- WHERE 조건 (SELECT FIELD 2 FROM TABLE WHERE 조건)

-- ** 1. 서브 쿼리 개념(필요성)
-- 서브쿼리의 필요성 : 
-- 급여를 제일 많이 받는 사람의 사번, 이름, 직책과 급여
SELECT MAX(SAL) FROM EMP;
SELECT EMPNO, ENAME, MAX(SAL) FROM EMP GROUP BY EMPNO;
SELECT MAX(SAL) FROM EMP; -- SUB
SELECT EMPNO, ENAME, JOB, SAL -- MAIN
  FROM EMP
  WHERE SAL = (SELECT MAX(SAL) FROM EMP);
  
-- 서브퀘리는 반드시 괄호로 묶여 있어야 합니다.  

-- 서브쿼리의 종류 (1) 단일행 서브쿼리 - 서브쿼리실행 결과가 단일행일때 : =, >, <, >=, != 연산자 사용가능
  -- EX. SCOTT이 근무하는 부서 이름 출력.
SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT'; -- SUB

SELECT DNAME FROM DEPT -- MAIN
WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT');

SELECT DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND ENAME = 'SCOTT';

-- 서브쿼리의 종류 (2) 다중행 서브쿼리 : 서브쿼리 결과가 2행 이상  = IN, ANY, ALL, EXIST
  --EX. JOB이 MANAGER인 사람의 부서이름
SELECT DEPTNO FROM EMP WHERE JOB = 'MANAGER';  -- SUB

SELECT DNAME FROM DEPT -- MAIN
   WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE JOB = 'MANAGER'); 


-- ** 2. 단일행 서브쿼리
   -- 아래 문제 전처리
   SELECT E.DEPTNO, D.LOC FROM EMP E ,DEPT D WHERE E.DEPTNO= D.DEPTNO AND ENAME='SCOTT';
   INSERT INTO DEPT VALUES (50, 'IT', 'DALLAS');
   INSERT INTO EMP (EMPNO, ENAME, DEPTNO) VALUES (9999, '홍길동', 50);
   ROLLBACK;
   
   -- EX. SCOTT과 같은 부서번호인 사람의 이름과 급여를 출력하시오.
SELECT DEPTNO FROM EMP WHERE ENAME ='SCOTT'; -- SUB
SELECT ENAME, SAL FROM EMP                   -- MAIN
   WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME ='SCOTT') AND ENAME!='SCOTT';



   -- EX. SCOTT과 동일한 근무지(DALLAS)에서 근무하는 사원의 이름, 근무지명, 급여를 출력하시오
SELECT LOC FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND ENAME ='SCOTT';   
SELECT E.ENAME "이름", D.LOC "근무지", E.SAL "급여" FROM EMP E, DEPT D                   -- MAIN
   WHERE E.DEPTNO=D.DEPTNO 
   AND LOC = (SELECT LOC FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND ENAME ='SCOTT') 
   AND ENAME!='SCOTT';
    ROLLBACK; -- 데이터 추가 취소 (DML - 데이터추가, 수정, 삭제를 취소)
 -- EX. 최초입사일과 최소입사한사람, 
 SELECT MIN(HIREDATE) FROM EMP;
 SELECT HIREDATE, ENAME FROM EMP
 WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP);
 --     최근입사일과 최근입사한사람이름
 SELECT MAX(HIREDATE) FROM EMP;
 SELECT HIREDATE, ENAME FROM EMP
 WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP);
 --     최근입사일과 최근입사한사람, 최초입사일과 최초입사한사람이름
SELECT (SELECT MAX(HIREDATE) FROM EMP) "LAST", 
        (SELECT HIREDATE, ENAME FROM EMP
        WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP)) "LASTMAN",
        (SELECT MIN(HIREDATE) FROM EMP) "FIRST",
        (SELECT HIREDATE, ENAME FROM EMP
        WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP)) "FIRSTMAN"
        FROM DUAL;
        
 
SELECT E1.HIREDATE "최근입사일", E1.ENAME"최근입사인", E2.HIREDATE "최초입사일", E2.ENAME "최초입사인"
FROM EMP E1 , EMP E2
WHERE E1.DEPTNO = E2.DEPTNO
      AND E1.HIREDATE = (SELECT MIN(HIREDATE) FROM EMP)
      AND E2.HIREDATE = (SELECT MAX(HIREDATE) FROM EMP);
      
  --EX. SCOTT과 같은 부서의 근무하는 사람들의 급여 합을 구하라.
SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT'; -- SUB

SELECT SUM(SAL) FROM EMP --MAIN
 WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT' );
 
  --EX. SCOTT과 같은 직책의 사람들의 모든 필드을 구하라.
SELECT * FROM EMP WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME = 'SCOTT' )  ;

  -- DALLAS에서 근무하는 사원의 이름, 부서번호
SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS'; -- SUB
SELECT ENAME, DEPTNO FROM EMP WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS'); -- MAIN

 --EX. KING이 직속 상사인 사원의 이름과 급여를 구하시오.
SELECT EMPNO FROM EMP WHERE ENAME ='KING'; --서브쿼리
SELECT ENAME, SAL FROM EMP WHERE MGR = (SELECT EMPNO FROM EMP WHERE ENAME ='KING') ; -- MAIN

-- 같은 예제를 셀프 조인을 넣어서 구해보세요.
SELECT C.ENAME, C.SAL 
FROM EMP M, EMP C
WHERE C.MGR = M.EMPNO AND M.ENAME = 'KING';

-- 탄탄다지기 1. 평균 급여 이하로 받는 사원의 이름과 급여를 출력하시오.
SELECT ROUND(AVG(SAL)) FROM EMP; -- SUB

SELECT ENAME, SAL 
FROM EMP
WHERE SAL <= (SELECT ROUND(AVG(SAL)) FROM EMP)
ORDER BY SAL DESC;

-- 탄탄다지기 1-1. 평균 급여 이하로 받는 사원의 이름과 급여, 평균급여를 출력하시오.

SELECT ENAME, SAL , (SELECT ROUND(AVG(SAL)) FROM EMP) "평균급여"
FROM EMP
WHERE SAL <= (SELECT ROUND(AVG(SAL)) FROM EMP)
ORDER BY SAL DESC;

-- EX3. 평균급여 이하로 받는 사원의 이름 급여 평균과 차이 출력.
SELECT ROUND(AVG(SAL)) FROM EMP; -- SUB

SELECT ENAME, SAL, ROUND((SELECT AVG(SAL) FROM EMP)-SAL, 1) "평균과의 차이"
FROM EMP
WHERE SAL <= (SELECT ROUND(AVG(SAL)) FROM EMP)
ORDER BY SAL DESC;

-- 단일행 다중열 서브쿼리 : SCOTT이랑 JOB과 DEPTNO가 같은 직원의 모든 필드 출력
SELECT JOB, DEPTNO FROM EMP WHERE ENAME= 'SCOTT'; -- SUB 단일행 다중열.

SELECT * FROM EMP
 WHERE (JOB, DEPTNO) IN (SELECT JOB, DEPTNO FROM EMP WHERE ENAME= 'SCOTT')
      AND ENAME != 'SCOTT';
 -- 서브쿼리가 다중열일때 WHERE 절에서 비교하는 다중 객체 변수도 ()안에 넣어서 매치시킨다.


-- 1. 사원테이블에서 가장 먼저 입사한 사람의 이름, 급여, 입사일
SELECT ENAME, SAL, HIREDATE FROM EMP
WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP);

-- 2. 회사에서 가장 급여가 적은 사람의 이름, 급여
SELECT ENAME, SAL FROM EMP
WHERE SAL = (SELECT MIN(SAL) FROM EMP);

-- 3. 회사 평균보다 급여를 많이 받는 사람의 이름, 급여, 부서코드
SELECT ENAME, SAL, DEPTNO FROM EMP
WHERE SAL > (SELECT AVG(SAL) FROM EMP);

--4. 회사 평균 이하의 급여를 받는 사람의 이름, 급여, 부서명
SELECT ENAME, SAL, DNAME FROM EMP, DEPT
WHERE EMP.DEPTNO = DEPT.DEPTNO 
AND SAL <= (SELECT AVG(SAL) FROM EMP);

--5. SCOTT보다 먼저 입사한 사람의 이름, 급여, 입사일, 급여 등급
SELECT ENAME, SAL, emp.hiredate ,GRADE FROM EMP, SALGRADE
WHERE SAL BETWEEN LOSAL AND HISAL
AND EMP.HIREDATE < (SELECT HIREDATE FROM EMP WHERE EMP.ENAME = 'SCOTT');


--6. 5번(SCOTT보다 먼저 입사한 사람의 이름, 급여, 입사일, 급여 등급)에 부서명 추가하고 급여가 큰 순 정렬
SELECT ENAME, SAL, emp.hiredate ,GRADE, DNAME FROM EMP, SALGRADE, DEPT D
WHERE EMP.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL
AND EMP.HIREDATE < (SELECT HIREDATE FROM EMP WHERE EMP.ENAME = 'SCOTT')
ORDER BY SAL DESC;

--7. BLAKE 보다 급여가 많은 사원들의 사번, 이름, 급여
SELECT EMPNO, ENAME, SAL FROM EMP
WHERE SAL > (SELECT SAL FROM EMP WHERE ENAME = 'BLAKE');

--8. MILLER보다 늦게 입사한 사원의 사번, 이름, 입사일
SELECT EMPNO, ENAME, HIREDATE FROM EMP
WHERE HIREDATE > (SELECT HIREDATE FROM EMP WHERE ENAME = 'MILLER');

--9. 사원전체 평균 급여보다 급여가 많은 사원들의 사번, 이름, 급여
SELECT EMPNO, ENAME, SAL FROM EMP
WHERE SAL > (SELECT AVG(SAL) FROM EMP);

--10. CLARK와 같은 부서번호이며, 사번이 7698인 직원의 급여보다 많은 급여를 받는 사원의 사번, 이름, 급여
SELECT EMPNO, ENAME, SAL FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME ='CLARK')
  AND SAL > (SELECT SAL FROM EMP WHERE EMPNO = 7698); 
 
 
--11.  응용심화. CLARK와 같은 부서명이며, 사번이 7698인 직원의 급여보다 많은 급여를 받는 사원의 사번, 이름, 급여
SELECT EMPNO, ENAME, SAL FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO 
  AND DNAME = (SELECT DNAME FROM EMP E, DEPT D  WHERE E.DEPTNO = D.DEPTNO AND E.ENAME ='CLARK')
  AND E.SAL > (SELECT SAL FROM EMP  WHERE EMPNO = 7698); 

--12. BLAKE와 같은 부서에 있는 모든 사원의 이름과 입사일자
SELECT ENAME, HIREDATE FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO 
  AND DNAME = (SELECT DNAME FROM EMP E, DEPT D  WHERE E.DEPTNO = D.DEPTNO AND E.ENAME ='BLAKE');


--13. 평균 급여 이상을 받는 모든 종업원에 대해서 사원번호와 이름 (단 급여가 많은 순으로 출력)
SELECT EMPNO, ENAME FROM EMP 
WHERE SAL > (SELECT AVG(SAL) FROM EMP)
ORDER BY SAL DESC;


-- **3 다중행 서브쿼리 : IN, ALL, ANY=SOME, EXISTS
--(1) IN : 서브쿼리 결과 중 하나라도 일치하면 참.
  -- EX. 부서번호별로 입사일이 가장 늦은 사람의 이름, 입사일, 부서변호
SELECT DEPTNO, MAX(HIREDATE) FROM EMP GROUP BY DEPTNO; -- 서브쿼리 (다중행)
SELECT ENAME, HIREDATE, DEPTNO                         -- 메인쿼리
   FROM EMP
   WHERE (DEPTNO, HIREDATE) IN (SELECT DEPTNO, MAX(HIREDATE) FROM EMP GROUP BY DEPTNO);
   
  -- EX. 급여 3000 이상 받는 사원이 소속된 부서에서 근무하는 사원의 모든 필드.
  SELECT DEPTNO FROM EMP WHERE SAL >= 3000; -- 서브쿼리
  SELECT * FROM EMP
  WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE SAL >= 3000); -- 메인쿼리
  
-- (2) ALL : 서브쿼리 결과가 모두 만족해야 함.

  -- EX. 30번 부서 급여들 모두보다 큰 경우 = 30번 부서 최대 급여보다 큰 경우 의 모든 필드
SELECT SAL FROM EMP WHERE DEPTNO = 30;
SELECT * FROM EMP WHERE SAL > ALL (SELECT SAL FROM EMP WHERE DEPTNO = 30);
-- 위 다중행 서브쿼리를 단일행 서브쿼리로
SELECT SAL FROM EMP WHERE DEPTNO = 30;
SELECT * FROM EMP WHERE SAL > (SELECT MAX(SAL) FROM EMP WHERE DEPTNO = 30);

-- (3) ANY = SOME : 서브쿼리 결과가 하나라도 만족하면 참.
  -- EX. 30번 부서 급여들 중 한 사람보다도 급여가 큰 경우 출력 = 최소급여보다 큰경우 
SELECT SAL FROM EMP WHERE DEPTNO = 30;
SELECT * FROM EMP WHERE SAL > ANY (SELECT SAL FROM EMP WHERE DEPTNO = 30);  
 -- 위 다중행 서브쿼리를 단일행 서브쿼리로  
SELECT SAL FROM EMP WHERE DEPTNO = 30;
SELECT * FROM EMP WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO = 30) ORDER BY SAL DESC;

-- (4) EXISTS ; 서브쿼리 결과가 존재하면 참.
  -- EX. 직속부하가 있는 직원들의 사번, 이름, 급여
  SELECT EMPNO, ENAME, SAL  -- MAIN
     FROM EMP M
     WHERE EXISTS (SELECT * FROM EMP WHERE M.EMPNO = MGR ); -- SUB
     
  SELECT DISTINCT M.EMPNO, M.ENAME, M.SAL
  FROM EMP W, EMP M
  WHERE W. MGR = M.EMPNO;
  
  -- EX. 말단 사원들의 모든 필드
 SELECT *  -- MAIN
     FROM EMP M
     WHERE NOT EXISTS (SELECT * FROM EMP WHERE M.EMPNO = MGR ); -- SUB    
  SELECT M.*  -- MAIN
     FROM EMP M , EMP W
     WHERE W.MGR(+) = M.EMPNO AND W.ENAME IS NULL;
     
-- 탄탄다지기 1. 부서별로 가장 급여를 많이 받는 사원의 정보 사번, 이름, 급여, 부서번호 를 출력 IN 연산자 이용.
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO; -- 서브쿼리
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM EMP
WHERE (DEPTNO, SAL) IN (SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO); -- 메인쿼리

-- 탄탄2. 직급이 MANAGER인 사람의 속한 부서의 부서번호와 부서명과 지역을 출력하시오. IN 연산자로
SELECT DEPTNO FROM EMP WHERE JOB = 'MANAGER';
SELECT DEPTNO, DNAME, LOC FROM DEPT D
WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE JOB = 'MANAGER');

-- 탄탄3. 급여 3000 이상인 사람들 중 급여 등급을 나누어서 
-- 해당 등급별 최고 급여를 받는 사람들의 사번 이름, 직업, 입사일, 급여, 급여등급을 출력
SELECT MAX(SAL) FROM EMP, SALGRADE 
WHERE SAL BETWEEN LOSAL AND HISAL AND SAL >= 3000
GROUP BY GRADE; -- 서브쿼리

SELECT EMPNO, ENAME, JOB, HIREDATE, SAL, GRADE
  FROM EMP, SALGRADE
 WHERE SAL BETWEEN LOSAL AND HISAL
   AND SAL IN (SELECT MAX(SAL) 
                 FROM EMP, SALGRADE 
                WHERE SAL BETWEEN LOSAL AND HISAL AND SAL >= 3000
             GROUP BY GRADE); -- 메인쿼리

--탄탄4. 응용심화 : 입사일 분기별로 가장 높은 급여를 받는 사람들의
-- 분기, 사번, 이름, JOB, 상사사번, 입사일, 급여, 상여를 출력하시오.
-- 1,2,3 -> 1 / 4,5,6 - 2 / 7,8,9 - 3/ 10, 11, 12 - 4 : 분기 추출은 MM/3을 올림.
SELECT HIREDATE, CEIL(EXTRACT(MONTH FROM HIREDATE)/3) "QUARTER" FROM EMP; -- CEIL EXTRACT로 분기 설정 서브쿼리
SELECT HIREDATE, CEIL(TO_CHAR(HIREDATE, 'MM')/3) "QUARTER" FROM EMP;      -- CEIL TO_CHAR로 분기 설정 서브쿼리
SELECT MAX(SAL) FROM EMP GROUP BY CEIL(EXTRACT(MONTH FROM HIREDATE)/3);
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, CEIL(EXTRACT(MONTH FROM HIREDATE)/3) || 'Q' "QUARTER" FROM EMP
WHERE SAL IN (SELECT MAX(SAL) FROM EMP GROUP BY CEIL(EXTRACT(MONTH FROM HIREDATE)/3)) ORDER BY "QUARTER"; -- MAIN 쿼리

SELECT MAX(SAL) FROM EMP GROUP BY TO_CHAR(HIREDATE, 'Q');                   -- CEIL TO_CHAR 'Q'로 분기 설정 서브쿼리
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, TO_CHAR(HIREDATE, 'Q')|| '분기' "분기" FROM EMP
WHERE SAL IN (SELECT MAX(SAL) FROM EMP GROUP BY TO_CHAR(HIREDATE, 'Q'))ORDER BY "분기";

--탄탄 5. SALESMAN 모든 사원들 보다 급여를 많이 받는 사원들의 이름과 담당 업무를 출력
-- 영업 사원을 출력하지 않는다. ALL 이용
SELECT SAL FROM EMP WHERE JOB = 'SALESMAN'; --SUB
SELECT ENAME, SAL, JOB
  FROM EMP
 WHERE SAL > ALL (SELECT SAL FROM EMP WHERE JOB = 'SALESMAN') AND JOB != 'SALESMAN'; -- 다중행 SUB이용한 메인쿼리
 SELECT SAL FROM EMP WHERE JOB = 'SALESMAN'; --SUB
SELECT ENAME, SAL, JOB
  FROM EMP
 WHERE SAL >(SELECT MAX(SAL) FROM EMP WHERE JOB = 'SALESMAN')AND JOB != 'SALESMAN' 
ORDER BY SAL; -- 단일행 서브쿼리 이용한 메인

--탄탄 6. SALESMAN 중 단 한명이라도 급여를 많이 받는 사원들의 이름과 담당 업무를 출력
-- 영업 사원을 출력하지 않는다.

SELECT SAL FROM EMP WHERE JOB = 'SALESMAN'; --SUB
SELECT ENAME, SAL, JOB
  FROM EMP
 WHERE SAL > ANY (SELECT SAL FROM EMP WHERE JOB = 'SALESMAN') AND JOB != 'SALESMAN'; -- 다중행 SUB이용한 메인쿼리

SELECT ENAME, SAL, JOB
  FROM EMP
 WHERE SAL >(SELECT MIN(SAL) FROM EMP WHERE JOB = 'SALESMAN')AND JOB != 'SALESMAN' 
ORDER BY SAL DESC; -- 단일행 서브쿼리 이용한 메인

-- 탄탄 7. 연봉인 3000 미만 사람 중에 가장 최근에 입사한 사람의 사번, 이름, 급여, 입사일
SELECT MAX(HIREDATE) FROM EMP WHERE SAL<3000;
SELECT EMPNO, ENAME, SAL, HIREDATE
  FROM EMP
  WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP WHERE SAL<3000);

-- ?	직급이 ‘SALESMAN’인 사원이 받는 급여의 최소 급여보다 많이 받는 사원들의 
-- 이름, 급여, 직급, 부서번호를 출력하되 부서번호가 20번인 사원은 제외한다(ANY 연산자 이용)
SELECT ENAME, SAL, JOB, DEPTNO
FROM EMP
WHERE SAL > ANY (SELECT SAL FROM EMP WHERE JOB = 'SALESMAN') AND DEPTNO!=20;







-- 여기서부터는 다중행서브쿼리와 단일행서브쿼리, 이전은 단일행서브쿼리
-- 14.  이름에 “T”가 있는 사원이 근무하는 부서에서 근무하는 모든 직원의 사원 번호,이름,급여(단 사번 순 출력)
SELECT EMPNO, ENAME, SAL FROM EMP
WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%')
ORDER BY EMPNO;

-- 15. 부서 위치가 Dallas인 모든 종업원에 대해 이름,업무,급여
SELECT ENAME, JOB ,SAL FROM EMP, DEPT
WHERE EMP.DEPTNO = DEPT.DEPTNO
   AND LOC = (SELECT LOC FROM DEPT WHERE LOC='DALLAS')
   ORDER BY SAL;
-- 단일 셀프조인
SELECT ENAME, JOB ,SAL FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
AND LOC = 'DALLAS' ORDER BY SAL;

-- 16. EMP 테이블에서 King에게 보고하는 모든 사원의 이름과 급여
SELECT W.ENAME, W.SAL FROM EMP K, EMP W
WHERE K.EMPNO = W.MGR
AND W.MGR IN (SELECT K.EMPNO FROM EMP WHERE K.ENAME = 'KING');

-- 17. SALES부서 사원의 이름, 업무
SELECT ENAME, JOB FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
  AND E.DEPTNO IN (SELECT DEPTNO FROM DEPT D WHERE DNAME = 'SALES')  ORDER BY ENAME;
--
SELECT ENAME, JOB FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
  AND DNAME = 'SALES' ORDER BY ENAME;


-- 18. 월급이 부서 30의 최저 월급보다 높은 사원의 모든 필드
SELECT * FROM EMP
WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO = 30 );
SELECT * FROM EMP
WHERE SAL > ANY (SELECT SAL  FROM EMP WHERE DEPTNO = 30 );


-- 19. 부서 10에서 부서 30의 사원과 같은 업무를 맡고 있는 사원의 이름과 업무
SELECT ENAME, JOB FROM EMP
WHERE DEPTNO = 10
  AND JOB IN (SELECT JOB FROM EMP WHERE DEPTNO = 30);

-- 20.  FORD와 업무도 월급도 같은 사원의 모든 필드
SELECT * FROM EMP
WHERE (JOB, SAL) = (SELECT JOB, SAL FROM EMP WHERE ENAME = 'FORD') AND ENAME != 'FORD';

-- 21. 이름이 JONES인 직원의 JOB과 같거나 FORD의 SAL 이상을 받는 사원의 정보를 이름, 업무, 부서번호, 급여
-- 단, 업무별 알파벳 순, 월급이 많은 순으로 출력
SELECT ENAME, JOB, DEPTNO, SAL FROM EMP
WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME = 'JONES') AND ENAME != 'JONES'
   OR SAL >= (SELECT SAL FROM EMP WHERE ENAME = 'FORD') AND ENAME != 'FORD'
ORDER BY JOB, SAL DESC;
    

-- 22. SCOTT 또는 WARD와 월급이 같은 사원의 정보를 이름,업무,급여
SELECT ENAME, JOB, SAL FROM EMP
WHERE SAL = (SELECT SAL FROM EMP WHERE ENAME = 'SCOTT') AND ENAME != 'SCOTT'
   OR SAL = (SELECT SAL FROM EMP WHERE ENAME = 'WARD')  AND ENAME != 'WARD';
 
   
   
-- 23. CHICAGO에서 근무하는 사원과 같은 업무를 하는 사원들의 이름,업무
SELECT ENAME, JOB FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
  AND JOB IN (SELECT JOB FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND LOC = 'CHICAGO' )
  AND LOC != 'CHICAGO';


-- 24. 부서별로 월급이 평균 월급보다 높은 사원을 사번, 이름, 급여, 부서번호
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
  ORDER BY SAL; --INLINE VIEW 이용
  
-- 24.1 해당 부서 평균보다 사번, 이름, 급여, 부서번호, 해당부서의평균 (소수점 2자리)
  SELECT EMPNO, ENAME, SAL, DEPTNO, 
         (SELECT ROUND(AVG(SAL),2) FROM EMP WHERE deptno = e.deptno) "부서 평균" -- 부서 평균 내는 서브쿼리
  FROM EMP E
  WHERE SAL > (SELECT ROUND(AVG(SAL),2) FROM EMP WHERE deptno = e.deptno) -- 개인의 급여 > 부서평균
  ORDER BY DEPTNO;


-- 25. 업무별로 평균 월급보다 적은 월급을 받는 사원을 부서번호, 이름, 급여
SELECT ROUND(AVG(SAL)),JOB FROM EMP GROUP BY JOB;
SELECT DEPTNO, ENAME, SAL, JOB FROM EMP E
WHERE SAL < (SELECT AVG(SAL) FROM EMP WHERE JOB = E.JOB)
ORDER BY SAL;
SELECT ROUND(AVG(E1.SAL)) FROM EMP E1, EMP E2 WHERE E1.JOB = E2.JOB;

-- 26. 적어도 한 명 이상으로부터 보고를 받을 수 있는 사원을 업무, 이름, 사번, 부서번호를 출력(단, 부서번호 순으로 오름차순 정렬)
 SELECT EMPNO, ENAME, SAL  -- MAIN
     FROM EMP M
     WHERE EXISTS (SELECT * FROM EMP WHERE M.EMPNO = MGR ); -- SUB
     
SELECT DISTINCT M.JOB, M.ENAME, M.EMPNO, M.DEPTNO FROM EMP M, EMP W
WHERE M.EMPNO = W.MGR
ORDER BY DEPTNO;

-- 27.  말단 사원의 사번, 이름, 업무, 부서번호 
SELECT EMPNO, ENAME, JOB, DEPTNO  -- MAIN
     FROM EMP M
     WHERE NOT EXISTS(SELECT * FROM EMP WHERE M.EMPNO = MGR ); -- SUB












