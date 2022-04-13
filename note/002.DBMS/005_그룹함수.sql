-- [V] 그룹함수 : SUM, AVG, MIN, MAX, COUNT, STDDEV (표준편차), VARIANCE

SELECT ENAME, ROUND(SAL, -3) FROM EMP; -- 단일행 함수 
SELECT MAX(SAL) FROM EMP; -- SAL중에서 가장 높은 숫자 출력
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO; -- 사번이 같은것 끼리 묶은 후에 부서별 최대 급여값 리턴
SELECT ENAME, MAX(SAL) FROM EMP; -- 최대급여를 받는 사람의 이름을 구하시오 (6장, 서브쿼리)

-- 1. 그룹함수들 실습
SELECT ROUND(AVG(SAL),2) FROM EMP; -- 총 급여의 평균을 구하시오 
SELECT COUNT(*) FROM EMP; -- 해당 테이블의 행(LOW, 세로)수를 구하시오.
SELECT AVG(SAL), SUM(SAL)/COUNT(SAL) FROM EMP;
SELECT AVG(COMM) FROM EMP;

-- 모든 그룹함수는 NULL은 자동으로 제외하고 계산함.
SELECT SUM(COMM), AVG(COMM), COUNT(COMM), MIN(COMM), MAX(COMM) FROM EMP; 
-- SAL의 평균, 합, 최소급여, 최대급여, 급여분산, 급여표준편차, 급여갯수를 구하시오.
SELECT ROUND(AVG(COMM)) "급여평균", SUM(SAL) "총 급여",  ROUND(VARIANCE (SAL)) "급여분산" , ROUND(STDDEV(SAL)) "급여표준편차",
MIN(SAL), MAX(SAL), COUNT(SAL)"급여갯수" FROM EMP;

--가장 최근에 입사한 사원의 입사일과 입사한지 가장 오래된 사원의 입사일을 출력. 
SELECT MAX(HIREDATE)"최근입사일", MIN(HIREDATE)"최초입사일" FROM EMP;

-- 최근 입사일 : XX,XXX일 , 최초입사일 : XX,XXX일 근무
SELECT MAX(HIREDATE) ||' 최근입사일 : ' "최근입사일" , 
           TO_CHAR(FLOOR(SYSDATE-MAX(HIREDATE)), '999,999')  || '일 근무,' "최소근무일수", 
       MIN(HIREDATE) ||' 최초입사일 : ' "최초입사일", 
           TO_CHAR(FLOOR(SYSDATE-MIN(HIREDATE)), '999,999')  || '일 근무' "최대근무일수" 
FROM EMP;
           
SELECT MAX(HIREDATE) || ' 최근입사일 : ' ||           
           TO_CHAR(MIN(SYSDATE-HIREDATE), '999,999')  || '일 근무,',
        MIN(HIREDATE) || ' 최초입사일 : ' ||           
           TO_CHAR(MAX(SYSDATE-HIREDATE), '999,999')  || '일 근무,'
FROM EMP;           

-- 10번 부서 소속의 사원 중에서 커미션을 받는 사원의 수를 구해 보시오.
SELECT COUNT(COMM) FROM EMP WHERE DEPTNO=10 AND COMM IS NOT NULL;

-- 10번 부서 소속의 사원 급여 평균
SELECT FLOOR(AVG(SAL)) FROM EMP WHERE DEPTNO=10;
SELECT FLOOR(AVG(SAL)) FROM EMP WHERE DEPTNO=20;
SELECT FLOOR(AVG(SAL)) FROM EMP WHERE DEPTNO=30;

-- 부서별 사원 최대급여 최소급여 급여 평균 총 급여를 구하시오
SELECT DEPTNO "부서번호", MAX(SAL) "최대급여", MIN(SAL) "최소급여", FLOOR(AVG(SAL))"평균급여", SUM(SAL) "총 급여" 
FROM EMP GROUP BY DEPTNO; -- 그룹바이절에는 별명 사용 안됨
SELECT DEPTNO "부서번호", MAX(SAL) "최대급여", MIN(SAL) "최소급여", ROUND(AVG(SAL),2) "평균급여", SUM(SAL) "총 급여" 
FROM EMP GROUP BY DEPTNO;
  -- EX. 급여가 5000미만 사원에 대해서만 부서 번호별 사원수, 최대급여, 최소급여, 평균급여 출력하시오.
SELECT DEPTNO"부서", COUNT(DEPTNO) "부서별사원수", MAX(SAL) "최대급여", MIN(SAL) "최소급여", ROUND(AVG(SAL),2) "평균급여" 
                                        ---- SELECT 절에서는 필드 별칭 가능
FROM EMP 
WHERE SAL < 5000                        ---- WHERE 절에서는 필드 별칭 불가능
GROUP BY DEPTNO                         ---- GROUP BY 절에서는 필드 별칭 불가능
ORDER BY DEPTNO;                        ---- ORDER BY 절에서는 필드 별칭 가능

-- EX. 부서명별 사원수, 최대급여, 최소급여, 평균급여 출력 사원수가 많은 순으로 정렬

SELECT DNAME "부서명", COUNT(E.DEPTNO) "부서별사원수", MAX(SAL) "최대급여", MIN(SAL) "최소급여", ROUND(AVG(SAL),2) "평균급여" 
                                        ---- SELECT 절에서는 필드 별칭 가능
FROM EMP E, DEPT D 
WHERE e.deptno = D.DEPTNO               ---- WHERE 절에서는 필드 별칭 불가능
GROUP BY DNAME                          ---- GROUP BY 절에서는 필드 별칭 불가능
ORDER BY COUNT(E.DEPTNO) DESC;          ---- ORDER BY 절에서는 필드 별칭 가능

-- 3. HAVING 절 : 그룹함수 결과의 조건만 출력

-- 부서번호별로 평균 급여 출력 (평균급여가 2000이상인 부서만 출력)
SELECT DEPTNO, ROUND(AVG(SAL),2) "평균" 
FROM EMP 
HAVING AVG(SAL) >= 2000 -- 그룹함수에는 WHERE절이 허락되지 않는다.
                        -- HAVING 절에도 별칭을 쓸 수 없다.
GROUP BY DEPTNO
ORDER BY 평균 DESC;

-- SAL 5000미만인 사원에 대해 부서명 최소급여, 최대급여, 평균급여
-- (단, 평균급여가 1800이상인 부서명에 대해서 평균 급여순으로 정렬 출력)

SELECT DNAME "부서명", MIN(SAL) "최소급여", MAX(SAL) "최대급여",  ROUND(AVG(SAL),2) "평균급여"                                      
FROM EMP E, DEPT D 
WHERE e.deptno = D.DEPTNO AND SAL < 5000  
HAVING ROUND(AVG(SAL),2)>=1800
GROUP BY DNAME                          
ORDER BY ROUND(AVG(SAL),2);    

--4. 결과 집계합 내 집계값 생성.
SELECT NVL(TO_CHAR(DEPTNO), '없음'), SUM(SAL) FROM EMP GROUP BY ROLLUP(DEPTNO);

   -- 부서별, JOB별 급여 합. 소계와 전체합 포함.
SELECT NVL(TO_CHAR(DEPTNO), '소계')"부서", NVL(JOB, '소계')"직종", SUM(SAL) FROM EMP GROUP BY ROLLUP (DEPTNO, JOB);


-- 그룹함수 연습문제.

-- 1. 인원수,최대 급여,최소 급여,급여의 합을 출력
SELECT COUNT(*), MAX(SAL),MIN(SAL),SUM(SAL)FROM EMP;

-- 2. 업무별 인원수를 구하여 출력
SELECT JOB, COUNT(JOB) FROM EMP GROUP BY JOB;

--- 3. 최고 급여와 최소 급여의 차이는 얼마인가 출력
SELECT MAX(SAL)-MIN(SAL) FROM EMP;

-- 4. 각 부서별로 인원수, 급여 평균, 최저 급여, 최고 급여, 급여의 합을 출력(급여의 합이 많은 순으로)
SELECT COUNT(*), ROUND(AVG(SAL)) ,MIN(SAL),MAX(SAL),SUM(SAL)FROM EMP 
GROUP BY DEPTNO 
ORDER BY SUM(SAL) DESC;

-- 5. 부서별, 업무별 그룹하여 결과를 부서번호, 업무, 인원수, 급여의 평균, 급여의 합을 출력(부서번호, 업무순으로 오름차순 정렬)
SELECT DEPTNO, JOB, COUNT(*), ROUND(AVG(SAL)),SUM(SAL)
FROM EMP 
GROUP BY DEPTNO, JOB 
ORDER BY DEPTNO, JOB;


-- 6. 업무별, 부서별 그룹하여 결과를  업무, 부서번호, 인원수, 급여의 평균, 급여의 합을 출력(출력결과는 업무순, 부서번호 순 오름차순 정렬)
SELECT JOB, DEPTNO,  COUNT(*), ROUND(AVG(SAL)),SUM(SAL)
FROM EMP 
GROUP BY JOB, DEPTNO 
ORDER BY JOB , DEPTNO;

--7. 사원수가 5명이상 넘는 부서번호와 사원수를 출력
SELECT DEPTNO,  COUNT(*)
FROM EMP 
HAVING COUNT(DEPTNO)>=5
GROUP BY DEPTNO;

-- 8. 사원수가 5명이상 넘는 부서명과 사원수를 출력
SELECT DNAME,  COUNT(*)
FROM EMP E, DEPT D
WHERE e.deptno = D.DEPTNO
HAVING COUNT(E.DEPTNO)>=5
GROUP BY DNAME;

--9. 업무별 급여의 평균이 3000이상인 업무에 대해서 업무명, 평균 급여, 급여의 합을 출력
SELECT JOB, ROUND(AVG(SAL)) "평균급여", SUM(SAL)
FROM EMP
HAVING ROUND(AVG(SAL))>=3000
GROUP BY JOB;

--10. 급여 합이 5000을 초과하는 각 업무에 대해서 업무와 급여합을 출력(급여 합계순 내림차순 정렬)
SELECT JOB,  SUM(SAL)
FROM EMP
HAVING SUM(SAL) >5000
GROUP BY JOB
ORDER BY SUM(SAL) DESC ;


--11. 부서별 급여평균, 부서별 급여합계, 부서별 최소급여를 출력
SELECT DEPTNO, ROUND(AVG(SAL)),SUM(SAL),MIN(SAL)
FROM EMP 
GROUP BY DEPTNO 
ORDER BY DEPTNO;


--12. 위의 11번을 수정하여, 부서별 급여평균 최대치, 부서별 급여합의 최대치, 부서별 최소급여의 최대치를 출력
SELECT  ROUND(MAX(AVG(SAL))),MAX (SUM(SAL)),MAX(MIN(SAL))
FROM EMP
GROUP BY DEPTNO;


--13. 사원 테이블에서 아래의 결과를 출력
--   H_YEAR	COUNT(*)	MIN(SAL)	MAX(SAL)	AVG(SAL)	SUM(SAL)
--     80	  1		    800		    800		    800		    800
--	81	 10		    950		    5000	    2282.5	  22825
--	82	  2		    1300	    3000	   2150		   4300
--	83	  1		    1100	    1100	    1100	   1100

SELECT TO_CHAR(HIREDATE, 'YY')"H_YEAR", COUNT(*) , MIN(SAL), MAX(SAL), ROUND(AVG(SAL),1) "AVG(SAL)" ,SUM(SAL)
FROM EMP
GROUP BY TO_CHAR(HIREDATE, 'YY')
ORDER BY TO_CHAR(HIREDATE, 'YY');



-- 14.  아래의 결과를 출력(입사년도별 사원수)
--  1980     1	
--  1981     10
--  1982     2
--  1983     1
--  total    14	
SELECT NVL (TO_CHAR(HIREDATE, 'YYYY'), 'TOTAL'), COUNT (*)
FROM EMP
GROUP BY ROLLUP (TO_CHAR(HIREDATE, 'YYYY'))
ORDER BY TO_CHAR(HIREDATE, 'YYYY');


--15. 최대급여, 최소급여, 전체급여합, 평균을 출력
SELECT MAX(SAL), MIN(SAL), SUM(SAL), ROUND(AVG(SAL)) "평균"
FROM EMP;

--16. 부서별 인원수 출력
SELECT DEPTNO, COUNT(DEPTNO)
FROM EMP
GROUP BY DEPTNO;

--17. 부서별 인원수가 6명이상인 부서번호 출력
SELECT DEPTNO
FROM EMP
HAVING COUNT(DEPTNO)>=6
GROUP BY DEPTNO;

--18. 급여가 높은 순서대로 등수를 부여하여 다음과 같은 결과가 나오게 하시오. 
-- (힌트 self join, group by, count사용)
--ENAME	    등수
--________________________
--KING		1
--SCOTT		2
--……

SELECT E1.ENAME, COUNT(E2.ENAME)+1 || '등' "등수" --월급을 많이 받는 사람의 수
FROM EMP E1, EMP E2
WHERE E1.SAL < E2.SAL (+) --1단계 : SELF JOIN / OUTER JOIN
GROUP BY E1.ENAME
ORDER BY COUNT(E2.ENAME);

SELECT ENAME, RANK() OVER(ORDER BY SAL DESC)"RANK" FROM EMP;





















