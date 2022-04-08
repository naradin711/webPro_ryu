-- [II] SELECT 문 - 가장 많이 쓰이는 DML(DATA MANIPULATION LANGUAGE) 검색 기능
-- 1. SELECT문장 작성법
-- 현재 계정 (실행 : CTRL + ENTER)
SHOW USER;
SELECT * FROM TAB;   -- 지금 계정이 가지고 있는 테이블
SELECT * FROM EMP;   -- EMP 테이블의 모든 열 필드, 모든 행
SELECT * FROM dept;   -- DEPT 테이블의 모든 열 필드, 모든 행
-- EMP 테이블의 구조를 알아봅시다.
DESC EMP;
DESC DEPT;
-- 2. SQL문 실행 (특정 열만 출력)
SELECT EMPNO, ENAME, SAL, JOB FROM EMP;
SELECT EMPNO AS "사번", ENAME AS "이름", SAL AS "급여",JOB FROM EMP; -- 별칭
-- 해당 엘리아스에 스페이스가 있으면 반드시 쌍따옴표를 붙여야 한다.
SELECT EMPNO "사 번", ENAME "이 름", SAL "급 여",JOB FROM EMP;
SELECT EMPNO AS "NO", ENAME AS "NAME", SAL AS "SALARY",JOB FROM EMP;

-- 3. 특정 행 출력 : WHERE 절 (조건) : 비교연산자.
-- 같다 (=), 크거나 같다(>=), 작거나 같다(<=), 다르다(!=, <>, ^=)

SELECT EMPNO "사번", ENAME "이름", SAL "급여" FROM EMP WHERE SAL = 3000; -- 같다
SELECT EMPNO "사번", ENAME "이름", SAL "급여" FROM EMP WHERE SAL != 3000; -- 다르다
SELECT EMPNO "사번", ENAME "이름", SAL "급여" FROM EMP WHERE SAL <> 3000; -- 다르다
SELECT EMPNO "사번", ENAME "이름", SAL "급여" FROM EMP WHERE SAL >= 3000; -- 크다.

-- 비교연산자는 숫자, 문자, 날짜형 모두 가능하다.
-- 사원이름 (ENAME)이 A B C 로 시작하는 사원의 모든 필드를 출력하시오

SELECT * FROM EMP WHERE ENAME < 'D'; -- ABC 순으로 문자도 비교가 가능하다. ""는 오로지 별칭을 붙일 경우에만 쓴다.
-- 81년도 이전에 입사한 사원의 모든 필드
SELECT * FROM EMP WHERE hiredate < '81/01/01';
-- 부서번호가 10번인 사원의 모든 필드를 출력
SELECT * FROM EMP WHERE DEPTNO = 10;
-- 이름이 FORD인 직원의 EMPNO, ENAME, MGR 상사의 사번을 출력하시오
SELECT EMPNO, ENAME, MGR FROM EMP WHERE ENAME = 'FORD'; -- '' "" 안에 있는 대소문자는 구분

-- 4. 논리연산자 : AND, OR
-- EX. 급여 SAL가 2000 이상 3000 이하인 직원의 모든 필드를 출력하시오.
SELECT * FROM EMP WHERE SAL > 2000 AND SAL < 3000;
-- 82년 도에 입사한 사원의 모든 필드
SELECT * FROM EMP WHERE hiredate >= '82/01/01' AND hiredate <= '82/12/31';
-- 날짜 표기법 셋팅 (현재 : YY/MM/DD OR RR/MM/DD)
ALTER SESSION SET NLS_DATE_FORMAT = 'MM-DD-RR';
ALTER SESSION SET NLS_DATE_FORMAT =  'RR/MM/DD';
SELECT ENAME, HIREDATE FROM EMP;

-- 연봉이 2400 이상인 직원의 ENAME, SAL, 연봉 출력 (연봉은 SAL*12)

SELECT ENAME, SAL, SAL*12 "연봉" FROM EMP WHERE SAL*12 > 2400; -- WHERE절에는 별칭은 사용 불가.
SELECT ENAME, SAL, SAL*12 "연봉" FROM EMP WHERE SAL*12 > 2400 ORDER BY 연봉 ; -- 여기에는 별칭 사용가능
-- 10번 부서이거나 직책이 MANAGER인 사람의 모든 필드
SELECT * FROM EMP WHERE DEPTNO = 10 OR JOB = 'MANAGER';
SELECT * FROM EMP WHERE DEPTNO != 10;
SELECT * FROM EMP WHERE NOT DEPTNO = 10; -- 해당 조건의 반대가 됨.

-- 5. 산술표현식 

SELECT ENAME, SAL "현재급여" , SAL+100 "올릴급여" FROM EMP WHERE deptno = 10;
-- 모든 사원의 이름 월급 상여 연봉 SAL*12+COMM 뽑기
-- 산출 연산의 결과는 NULL 포함하면 결과도 NULL
-- NVL(NULL)일 수도 있는 필드명, NULL일 경우의 대치값) 반드시 매개변수 둘은 타입이 같아야 한다.
SELECT ENAME, SAL, COMM, SAL*12+NVL(COMM, 0) "연봉" FROM EMP;
-- 모든 사원의 사원명, 상사의 사번을 출력
SELECT ENAME, NVL(MGR, 0) FROM EMP;  -- NVL 매개변수 타입 불일치 에러.

--6. 연결연산자 (||) : 열이나 문자를 연결
SELECT ENAME || '은 ' || JOB "EMPLOYEES" FROM EMP;
-- EX. "SMITH : 연봉 = XXX"와 같이 모든 행 출력 연봉은 SAL*12+NVL(COMM, 0)
SELECT ENAME || ' : 연봉 = ' || (SAL*12+NVL(COMM, 0)) FROM EMP;

-- 7. 중복 제거 (DISTINCT)
SELECT JOB FROM EMP;
SELECT DEPTNO FROM EMP;
SELECT DISTINCT DEPTNO FROM EMP;
SELECT DISTINCT JOB FROM EMP;


-- ★ 예제 꼭 풀기 
--1. emp 테이블의 구조 출력
DESC EMP;
--2. emp 테이블의 모든 내용을 출력 
SELECT * FROM EMP;
--3. 현 scott 계정에서 사용가능한 테이블 출력
SELECT * FROM TAB;
--4. emp 테이블에서 사번, 이름, 급여, 업무, 입사일 출력
SELECT EMPNO "사번", ENAME "이름", SAL "급여",   JOB "업무", HIREDATE "입사일" FROM EMP;
--5. emp 테이블에서 급여가 2000미만인 사람의 사번, 이름, 급여 출력
SELECT EMPNO "사번", ENAME "이름", SAL "급여" FROM EMP WHERE SAL>2000;
--6. 입사일이 81/02이후에 입사한 사람의 사번, 이름, 업무, 입사일 출력
SELECT EMPNO "사번", ENAME "이름", JOB "업무", HIREDATE "입사일" FROM EMP WHERE hiredate > '81/02/01';
--7. 업무가 SALESMAN인 사람들 모든 자료 출력
SELECT * FROM EMP WHERE JOB = 'SALESMAN';
--8. 업무가 CLERK이 아닌 사람들 모든 자료 출력
SELECT * FROM EMP WHERE JOB != 'CLERK';

--9. 급여가 1500이상이고 3000이하인 사람의 사번, 이름, 급여 출력
SELECT EMPNO "사번", ENAME "이름", SAL "급여" FROM EMP WHERE SAL > 1500 AND SAL < 3000;

--10. 부서코드가 10번이거나 30인 사람의 사번, 이름, 업무, 부서코드 출력
SELECT EMPNO "사번", ENAME "이름", JOB "업무", DEPTNO "부서코드" FROM EMP WHERE deptno = 10 OR deptno = 30;

--11. 업무가 SALESMAN이거나 급여가 3000이상인 사람의 사번, 이름, 업무, 부서코드 출력
SELECT EMPNO "사번", ENAME "이름", JOB "업무", DEPTNO "부서코드" FROM EMP WHERE JOB='SALESMAN' OR SAL >3000;

--12. 급여가 2500이상이고 업무가 MANAGER인 사람의 사번, 이름, 업무, 급여 출력
SELECT EMPNO "사번", ENAME "이름", JOB "업무", SAL "급여" FROM EMP WHERE SAL >2500 AND JOB= 'MANAGER';

--13.“ename은 XXX 업무이고 연봉은 XX다” 스타일로 모두 출력(연봉은 SAL*12+COMM)
SELECT ENAME || '은 ' || JOB || '업무이고 연봉은 ' || (SAL*12+NVL(COMM, 0)) || '이다' FROM EMP;








