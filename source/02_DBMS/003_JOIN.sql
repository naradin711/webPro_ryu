-- [III] JOIN : 테이블 2개 이상을 연결하여 검색
SELECT * FROM EMP WHERE ENAME='SCOTT'; -- 부서번호 DEPTNO 20
SELECT * FROM DEPT;

-- CROSS JOIN (FROM 에 테이블을 2개 이상 넣기)
SELECT * FROM EMP, DEPT WHERE ENAME = 'SCOTT';
SELECT * FROM EMP, DEPT; 14 4 56 행

--1. EQUI JOIN (동등조건) : 공통필드엔 DEPTNO 값이 일치되는 조건만 JOIN.
SELECT * FROM EMP, DEPT WHERE ENAME ='SCOTT' AND EMP.DEPTNO=DEPT.DEPTNO;
SELECT EMPNO,ENAME,JOB, MGR, HIREDATE, SAL, COMM, EMP.DEPTNO, DNAME, LOC FROM EMP, DEPT WHERE EMP.DEPTNO=DEPT.DEPTNO;
  -- 테이블의 별칭
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, E.DEPTNO, DNAME, LOC FROM EMP E,DEPT D WHERE E.DEPTNO=D.DEPTNO;
  
  --EX. 급여가 2000이상인 사람만 이름, 직책, 급여, 부서명, 근무지 출력.
SELECT ENAME, JOB, SAL, DNAME, LOC  FROM EMP E , DEPT D WHERE E.DEPTNO=D.DEPTNO AND SAL>=2000;

  --EX. 근무지가 'CHICAGO'인 사람의 이름, 업무, 급여, 부서번호, 근무지를 출력 
SELECT ENAME, JOB, SAL, E.DEPTNO, LOC FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND LOC = 'CHICAGO';

  --EX. 부서번호가 10이거나 20번인 사원의 이름, 업무, 근무지, 급여. 급여순 정렬
SELECT ENAME, JOB, LOC, SAL FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND E.DEPTNO IN (10, 20) ORDER BY SAL; 

  --EX. JOB이 SALESMAN이거나 MANAGER인 사원의 이름, 급여, 상여, 연봉 ((SAL+COMM)*12), 부서명, 근무지를 출력 (연봉이 큰 순으로 출력)
SELECT ENAME, SAL, COMM, ((SAL+NVL(COMM,0))*12) "연봉", DNAME, LOC FROM EMP, DEPT WHERE JOB = 'SALESMAN' OR JOB = 'MANAGER' ORDER BY 연봉 DESC; 
  
  --EX. COMM이 NULL이고 급여가 1200 이상인 사원의 이름, 급여, 입사일, 부서번호, 부서명 출력 부서명 급여가 큰 순서
SELECT ENAME, SAL, HIREDATE, EMP.DEPTNO, DNAME FROM EMP, DEPT WHERE EMP.DEPTNO = DEPT.DEPTNO AND SAL >= 1200 AND COMM IS NULL ORDER BY SAL DESC; 
  
  --EX. 'NEW YORK'에서 근무하는 사원의 이름과 급여 출력
SELECT ENAME, SAL FROM EMP, DEPT WHERE LOC = 'NEW YORK';  
  
  --EX. 'ACCOUNTING' 부서 소속의 사원 이름과 입사일 출력
SELECT ENAME, HIREDATE FROM EMP, DEPT WHERE DNAME = 'ACCOUNTING';  

  -- 직급이 MANAGER인 사원의 이름, 부서명을 출력하시오
SELECT ENAME, DNAME FROM EMP, DEPT WHERE JOB = 'MANAGER';  

  -- Comm이 null이 아닌 사원의 이름, 급여, 부서코드, 근무지를 출력하시오.
SELECT ENAME, SAL, D.DEPTNO, LOC FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND COMM IS NOT NULL;  

-- 2. NON EQUI JOIN
SELECT * FROM EMP WHERE ENAME = 'SCOTT'; -- 사원 정보
SELECT * FROM SALGRADE; -- 급여 등급 정보
-- CROSS JOIN = EMP의 1행 * SALGRADE의 5행
SELECT * FROM EMP, SALGRADE WHERE ENAME = 'SCOTT';
SELECT * FROM EMP, SALGRADE WHERE ENAME = 'SCOTT' AND SAL BETWEEN LOSAL AND HISAL;

  --EX. 모든 사원의 사번, 이름, 직급, 상사사번, 급여, 급여 등급 출력
SELECT EMPNO, ENAME, JOB, MGR, SAL, grade||'등급' GRADE FROM EMP, SALGRADE WHERE SAL BETWEEN LOSAL AND HISAL;




--Comm이 null이 아닌 사원의 이름, 급여, 등급, 부서번호, 부서이름, 근무지를 출력하시오.
SELECT ENAME, SAL, GRADE, D.DEPTNO, DNAME, LOC FROM EMP E, SALGRADE S, DEPT D 
  WHERE SAL BETWEEN LOSAL AND HISAL
  AND E.DEPTNO = D.DEPTNO
  AND NOT COMM IS NULL;

--이름, 급여, 입사일, 급여등급
SELECT ENAME, HIREDATE, GRADE FROM EMP, SALGRADE WHERE SAL BETWEEN LOSAL AND HISAL;

--이름, 급여, 입사일, 급여등급, 부서명, 근무지
SELECT ENAME, SAL, HIREDATE, GRADE, DNAME, LOC
  FROM EMP E, SALGRADE S, DEPT D
  WHERE E.DEPTNO = D.DEPTNO
  AND SAL BETWEEN LOSAL AND HISAL;

--이름, 급여, 등급, 부서코드, 근무지. 단 comm 이 null아닌 경우
SELECT ENAME, SAL, GRADE, LOC FROM EMP E , SALGRADE S , DEPT D
WHERE E.DEPTNO = D.DEPTNO
AND SAL BETWEEN LOSAL AND HISAL
AND NOT COMM IS NULL;

--이름, 급여, 급여등급, 연봉, 부서명, (부서별 , 부서가 같으면 연봉순). 연봉=(sal+comm)*12 comm이 null이면 0
SELECT ENAME, SAL, GRADE, (SAL+NVL(COMM, 0))*12, DNAME
 FROM EMP E, SALGRADE S, DEPT D
 WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL
 ORDER BY DNAME, (SAL+NVL(COMM, 0))*12;

--이름, 업무, 급여, 등급, 부서코드, 부서명 출력. 급여가 1000~3000사이. 정렬조건 : 부서별, 부서같으면 업무별, 업무같으면 급여 큰순
SELECT ENAME, JOB, SAL, GRADE, E.DEPTNO, DNAME
 FROM EMP E, DEPT D, SALGRADE
 WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL
 AND SAL BETWEEN 1000 AND 3000 ORDER BY DEPTNO, JOB, SAL DESC; 

--이름, 급여, 등급, 입사일, 근무지. 81년에 입사한 사람. 등급 큰순
SELECT ENAME, JOB, SAL, GRADE || '등급' GRADE, HIREDATE, LOC
 FROM EMP E, DEPT D, SALGRADE
 WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL
 AND HIREDATE LIKE '%81%' ORDER BY GRADE DESC;



-- 3. SELF JOIN
SELECT EMPNO 사번, ENAME 이름, MGR 상사사번 FROM EMP WHERE ENAME = 'SMITH'; --상사사번 7902

SELECT EMPNO, ENAME FROM EMP WHERE EMPNO = 7902;

SELECT WORKER.EMPNO, WORKER.ENAME, WORKER.MGR, MANAGER.EMPNO, MANAGER.ENAME FROM EMP WORKER, EMP MANAGER 
WHERE WORKER.ENAME ='SMITH' AND WORKER.MGR = MANAGER.EMPNO;

  --EX. 모든 사원의 사번, 이름, 상사사번, 상사이름 (13행 - KING의 상사사번이 NULL이기때문에 KING이 출력이 안됨. )
SELECT  W.EMPNO, W.ENAME, W.MGR, M.ENAME
  FROM EMP W, EMP M
  WHERE W.MGR = M.EMPNO(+);
  
  --EX. 'SMITH'의 상사는 FORD이다. 포맷으로 모든 사원들을 출력하시오.
  SELECT W.ENAME || '의 상사는 ' || M.ENAME || '이다'
   FROM EMP W , EMP M
   WHERE W.MGR = M.EMPNO;
 
 -- 탄탄 0. 상사의 이름이 KING인 사원들의 이름과 직급을 출력하시오.
 SELECT C.ENAME "이름" , C.JOB "직급"
 FROM EMP K, EMP C
 WHERE K.ENAME = 'KING' AND K.EMPNO = C.MGR;
 
 -- 탄탄 1. SCOTT과 동일한 부서번호(20)에서 근무하는 사원의 이름을 출력하시오
SELECT C.ENAME
FROM EMP S, EMP C
WHERE S.ENAME='SCOTT' AND S.DEPTNO = C.DEPTNO AND C.ENAME != 'SCOTT'; -- 스콧을 제거해야 함.

 -- 탄탄 2. SCOTT과 동일한 근무지(DALLAS)에서 근무하는 사원의 이름을 출력하시오(2단계 최종문제)
 SELECT * FROM DEPT;
 -- 인위적으로 DALLAS 근무지 부서를 하나 추가
INSERT INTO DEPT VALUES (50, 'IT', 'DALLAS');
SELECT * FROM DEPT;
 -- 인위적으로 50번 부서 사원 추가.
SELECT * FROM EMP;
INSERT INTO EMP VALUES (9999, '홍길동', NULL,NULL,NULL, 9000, 900, 50);
SELECT * FROM EMP;

SELECT C.ENAME
  FROM EMP S, EMP C, DEPT A, DEPT B
  WHERE S.ENAME='SCOTT' AND S.DEPTNO = A.DEPTNO AND A.LOC ='DALLAS' 
  AND A.LOC = B.LOC AND B.DEPTNO = c.deptno  
  AND C.ENAME != 'SCOTT' ORDER BY ENAME;
 
ROLLBACK; -- 인서트된 홍길동 달라스 취소

SELECT C.ENAME
  FROM EMP S, EMP C, DEPT A, DEPT B
  WHERE S.ENAME='SCOTT' AND S.DEPTNO = A.DEPTNO AND A.LOC ='DALLAS' 
  AND A.LOC = B.LOC AND B.DEPTNO = c.deptno  
  AND C.ENAME != 'SCOTT' ORDER BY ENAME;
  
  
  
-- 4. OUTER JOIN : JOIN시 조건에 만족하지 않는 행까지 나타나게 해야 함.

SELECT  W.EMPNO, W.ENAME, W.MGR, M.ENAME
  FROM EMP W, EMP M
  WHERE W.MGR = M.EMPNO(+);
  
SELECT ENAME, D.DEPTNO, DNAME
  FROM EMP E, DEPT D WHERE E.DEPTNO(+) = D.DEPTNO; --E.DEPTNO에는 40번 부서 없음.

SELECT W.EMPNO, W.ENAME, W.MGR, M.ENAME
  FROM EMP W, EMP M
  WHERE W.MGR(+) = M.EMPNO AND W.EMPNO IS NULL;

 -- ★ <연습문제> PART1
 
--1. 이름, 직속상사

SELECT W.ENAME "이름", M.ENAME "직속상사"
FROM EMP W, EMP M
WHERE W.MGR = M.EMPNO;

--2. 이름, 급여, 업무, 직속상사
SELECT W.ENAME "이름", W.SAL "급여" , W.JOB "업무" , M.ENAME "직속상사"
FROM EMP W, EMP M
WHERE W.MGR = M.EMPNO;


--3. 이름, 급여, 업무, 직속상사. (상사가 없는 직원까지 전체 직원 다 출력.
    --상사가 없을 시 '없음'으로 출력)
SELECT W.ENAME "이름", W.SAL "급여" , W.JOB "업무" , nvl( M.ENAME , '없음') "직속상사"
FROM EMP W, EMP M
WHERE W.MGR = M.EMPNO (+);    

--4. 이름, 급여, 부서명, 직속상사명
SELECT W.ENAME "이름", W.SAL "급여" , DNAME "부서명" , nvl( M.ENAME , '없음') "직속상사"
FROM EMP W, EMP M, DEPT D
WHERE W.DEPTNO = D.DEPTNO AND W.MGR = M.EMPNO (+) ;

--5. 이름, 급여, 부서코드, 부서명, 근무지, 직속상사명, (상사가 없는 직원까지 전체 직원 다 출력)
SELECT W.ENAME "이름", W.SAL "급여" , DNAME "부서명", LOC "근무지" , nvl( M.ENAME , '없음') "직속상사"
FROM EMP W, EMP M, DEPT D
WHERE W.DEPTNO = D.DEPTNO AND W.MGR = M.EMPNO (+) ;


--6. 이름, 급여, 등급, 부서명, 직속상사명. 급여가 2000이상인 사람
SELECT W.ENAME "이름", W.SAL "급여", GRADE "등급" , DNAME "부서명" , nvl( M.ENAME , '없음') "직속상사"
FROM EMP W, EMP M, DEPT D, SALGRADE
WHERE W.DEPTNO = D.DEPTNO AND W.SAL BETWEEN LOSAL AND HISAL
AND W.MGR = M.EMPNO(+) AND W.SAL >= 2000;

--7. 이름, 급여, 등급, 부서명, 직속상사명, (직속상사가 없는 직원까지 전체직원 부서명 순 정렬)
SELECT W.ENAME "이름", W.SAL "급여" , GRADE ||'등급' "등급", DNAME "부서명" , nvl( M.ENAME , '없음') "직속상사"
FROM EMP W, EMP M, DEPT D, SALGRADE
WHERE W.DEPTNO = D.DEPTNO AND W.SAL BETWEEN LOSAL AND HISAL
AND W.MGR = M.EMPNO (+) ORDER BY DNAME ;

--8. 이름, 급여, 등급, 부서명, 연봉, 직속상사명. 연봉=(급여+comm)*12 단 comm이 null이면 0
SELECT W.ENAME "이름", W.SAL "급여" , GRADE ||'등급' "등급", DNAME "부서명" , nvl( M.ENAME , '없음') "직속상사", (W.SAL+NVL(W.COMM,0))*12  "연봉"
FROM EMP W, EMP M, DEPT D, SALGRADE
WHERE W.DEPTNO = D.DEPTNO AND W.SAL BETWEEN LOSAL AND HISAL
AND W.MGR = M.EMPNO (+);

--9. 8번을 부서명 순 부서가 같으면 급여가 큰 순 정렬

SELECT W.ENAME "이름", W.SAL "급여" , GRADE ||'등급' "등급", DNAME "부서명" , nvl( M.ENAME , '없음') "직속상사", (W.SAL+NVL(W.COMM,0))*12  "연봉"
FROM EMP W, EMP M, DEPT D, SALGRADE
WHERE W.DEPTNO = D.DEPTNO AND W.SAL BETWEEN LOSAL AND HISAL
AND W.MGR = M.EMPNO (+) ORDER BY DNAME , W.SAL DESC;

--  PART2

--1.EMP 테이블에서 모든 사원에 대한 이름,부서번호,부서명을 출력하는 SELECT 문장을 작성하여라.
SELECT ENAME "이름", E.DEPTNO "부서번호", DNAME "부서명"
FROM EMP E, DEPT D
WHERE e.deptno = d.deptno ;


--2. EMP 테이블에서 NEW YORK에서 근무하고 있는 사원에 대하여 이름,업무,급여,부서명을 출력
SELECT ENAME "이름", JOB "업무", SAL "급여", DNAME "부서명" 
FROM EMP E , DEPT D
WHERE E.DEPTNO = d.deptno AND D.LOC = 'NEW YORK'; 

--3. EMP 테이블에서 보너스를 받는 사원에 대하여 이름,부서명,위치를 출력

SELECT ENAME "이름", DNAME "부서명", D.LOC "위치"
FROM EMP E , DEPT D
WHERE E.DEPTNO = d.deptno AND E.COMM IS NOT NULL ; 


--4. EMP 테이블에서 이름 중 L자가 있는 사원에 대하여 이름,업무,부서명,위치를 출력
SELECT ENAME "이름", JOB "업무", DNAME "부서명", D.LOC "위치"
FROM EMP E , DEPT D
WHERE E.DEPTNO = d.deptno AND E.ENAME LIKE '%L%' ;

--5. 사번, 사원명, 부서코드, 부서명을 검색하라. 사원명기준으로 오름차순정열
SELECT E.EMPNO "사번", E.ENAME "이름", E.DEPTNO "부서코드", DNAME "부서명"
FROM EMP E , DEPT D
WHERE E.DEPTNO = d.deptno ORDER BY E.ENAME ;

--6. 사번, 사원명, 급여, 부서명을 검색하라. 
--단 급여가 2000이상인 사원에 대하여 급여를 기준으로 내림차순으로 정열하시오
SELECT E.EMPNO "사번", E.ENAME "이름", E.SAL "급여", DNAME "부서명"
FROM EMP E , DEPT D
WHERE E.DEPTNO = d.deptno AND E.SAL >= 2000
ORDER BY E.SAL DESC ;    

--7. 사번, 사원명, 업무, 급여, 부서명을 검색하시오. 단 업무가 MANAGER이며 급여가 2500이상인
-- 사원에 대하여 사번을 기준으로 오름차순으로 정열하시오.

SELECT E.EMPNO "사번", E.ENAME "이름", E.JOB "업무", E.SAL "급여", DNAME "부서명"
FROM EMP E , DEPT D
WHERE E.DEPTNO = d.deptno AND E.SAL >= 2500 AND E.JOB = 'MANAGER'
ORDER BY E.EMPNO ;

--8. 사번, 사원명, 업무, 급여, 등급을 검색하시오. 단, 급여기준 내림차순으로 정렬하시오
SELECT E.EMPNO "사번", E.ENAME "이름", E.JOB "업무", E.SAL "급여", GRADE "등급"
FROM EMP E , DEPT D, SALGRADE
WHERE E.DEPTNO = d.deptno AND E.SAL BETWEEN LOSAL AND HISAL
ORDER BY E.SAL DESC ;

--9. 사원테이블에서 사원명, 사원의 상사를 검색하시오(상사가 없는 직원까지 전체)
SELECT W.ENAME "이름", nvl( M.ENAME , '없음') "사원의 상사"
FROM EMP W, EMP M
WHERE W.MGR = M.EMPNO (+); 

--10. 사원명, 상사명, 상사의 상사명을 검색하시오
SELECT W.ENAME "이름", nvl( M.ENAME , '없음') "사원의 상사", nvl( S.ENAME , '없음') "상사의 상사"
FROM EMP W, EMP M, EMP S
WHERE W.MGR = M.EMPNO AND M.MGR = S.EMPNO;

--11. 위의 결과에서 상위 상사가 없는 모든 직원의 이름도 출력되도록 수정하시오
SELECT W.ENAME "이름", nvl( M.ENAME , '없음') "사원의 상사", nvl( S.ENAME , '없음') "상사의 상사"
FROM EMP W, EMP M, EMP S
WHERE W.MGR = M.EMPNO (+) AND M.MGR = S.EMPNO(+) 
ORDER BY W.SAL DESC;
















