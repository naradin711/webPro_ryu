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
--1. emp 테이블의 구조 출력 (오로지 오라클에서만 사용 가능.)
DESC EMP;
--2. emp 테이블의 모든 내용을 출력 
SELECT * FROM EMP;
--3. 현 scott 계정에서 사용가능한 테이블 출력
show user;
SELECT * FROM TAB; -- 현재 계정이 가지고 있는 테이블
--4. emp 테이블에서 사번, 이름, 급여, 업무, 입사일 출력
SELECT EMPNO "사번", ENAME "이름", SAL "급여",   JOB "업무", HIREDATE "입사일" FROM EMP;

--5. emp 테이블에서 급여가 2000미만인 사람의 사번, 이름, 급여 출력
SELECT EMPNO "사번", ENAME "이름", SAL "급여" FROM EMP WHERE SAL>2000;

--6. 입사일이 81/02이후에 입사한 사람의 사번, 이름, 업무, 입사일 출력
SELECT EMPNO "사번", ENAME "이름", JOB "업무", HIREDATE "입사일" FROM EMP 
       WHERE TO_CHAR (hiredate, 'RR/MM/DD') >= '81/02/01'; -- 단일행함수 4장 참조
SELECT EMPNO "사번", ENAME "이름", JOB "업무", HIREDATE "입사일" FROM EMP 
       WHERE hiredate >= TO_DATE ('81/02/01', 'RR/MM/DD'); -- 단일행함수 4장 참조
--# 날짜설정 하는 법. YYYY 년도 4자리, RR 년도 2자리, M월 D일.
--# 날짜형 -> 문자형으로 변환하는 함수 : TO_CHAR 날짜형, 패턴
--# 문자형 -> 날짜형으로 변환하는 함수 : TO_DATE 문자형, 패턴
Alter session set nls_DATE_FORMAT = 'MM-DD-RR';
Alter session set nls_DATE_FORMAT = 'RR/MM/DD';


--7. 업무가 SALESMAN인 사람들 모든 자료 출력
SELECT * FROM EMP WHERE JOB = 'SALESMAN';

--8. 업무가 CLERK이 아닌 사람들 모든 자료 출력
SELECT * FROM EMP WHERE JOB != 'CLERK';
SELECT * FROM EMP WHERE NOT JOB = 'CLERK';

--9. 급여가 1500이상이고 3000이하인 사람의 사번, 이름, 급여 출력 &&는 사용불가
SELECT EMPNO "사번", ENAME "이름", SAL "급여" FROM EMP WHERE SAL > 1500 AND SAL < 3000;

--10. 부서코드가 10번이거나 30인 사람의 사번, 이름, 업무, 부서코드 출력
SELECT EMPNO "사번", ENAME "이름", JOB "업무", DEPTNO "부서코드" FROM EMP WHERE deptno = 10 OR deptno = 30;

--11. 업무가 SALESMAN이거나 급여가 3000이상인 사람의 사번, 이름, 업무, 부서코드 출력
SELECT EMPNO "사번", ENAME "이름", JOB "업무", DEPTNO "부서코드" FROM EMP WHERE JOB='SALESMAN' OR SAL >3000;

--12. 급여가 2500이상이고 업무가 MANAGER인 사람의 사번, 이름, 업무, 급여 출력
SELECT EMPNO "사번", ENAME "이름", JOB "업무", SAL "급여" FROM EMP WHERE SAL >2500 AND JOB= 'MANAGER';

--13.“ename은 XXX 업무이고 연봉은 XX다” 스타일로 모두 출력(연봉은 SAL*12+COMM)
SELECT ENAME || '은 ' || JOB || '업무이고 연봉은 ' || (SAL*12+NVL(COMM, 0)) || '이다' FROM EMP;


-- 8. SQL 연산자 BETWEEN, IN, LIKE, IS NULL
 -- 8. 1. BETWEEN
  -- EX. SAL이 1500 이상 3000이하인 사번 이름 급여.
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL >=1500 AND SAL<=3000;
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL BETWEEN 1500 AND 3000; -- 거꾸로는 안됨 무조건 작은 숫자 큰 숫자 순으로 입력!
  -- EX. 1500 미만 3000 초과는 NOT BETWEEN 사용
SELECT * FROM EMP WHERE SAL NOT BETWEEN 1500 AND 3000;
  -- EX. 82년도에 입사한 직원의 모든 필드 출력
SELECT * FROM EMP WHERE HIREDATE BETWEEN '82/01/01' AND  '82/12/31';
SELECT * FROM EMP
   WHERE TO_CHAR (HIREDATE, 'RR/MM/DD') BETWEEN '82/01/01' AND  '82/12/31';
  -- EX. 사원 이름이 'A' 나 'B'로 시작하는 사원의 모든 필드.
SELECT * FROM EMP WHERE ENAME BETWEEN 'A' AND 'C' AND ENAME!='C'; -- A에서 B까지를 하려면 C까지 비트윈에 넣은 후에 C 범주를 빼야 함.

  -- EX. 사원 이름이 'B' 나 'C'로 시작하는 사원의 모든 필드.
SELECT * FROM EMP WHERE ENAME BETWEEN 'B' AND 'D' AND ENAME!='D';

 -- 8. 2. 데이터 IN 연산자 (A, B, C .....)
  --EX. 부서번호가 10,20,40번인 부서 사원의 모든필드
SELECT * FROM EMP WHERE DEPTNO=10 OR DEPTNO=20 OR DEPTNO=40;
SELECT * FROM EMP WHERE DEPTNO IN (10,20,40); -- 괄호안에 있는 객체값을 선별함. 

  --EX. 부서번호가 10,20,40번 부서를 제외한 사원의 모든 필드
SELECT * FROM EMP WHERE DEPTNO NOT IN (10,20,40);

  --EX. 사번이 7902, 7788, 7566인 사원의 모든 필드
SELECT * FROM EMP WHERE EMPNO IN (7902, 7788, 7566); 

 -- 8. 3 LIKE 연산 : (문법) 데이터 LIKE 패턴(% : 0글자 이상, _ : 1글자 )
  -- EX. 이름에 M이 들어간 사원의 모든 필드
SELECT * FROM EMP WHERE ENAME LIKE '%M%'; -- 순서에 상관없이 M만 들어가면 OK

  -- EX. 이름이 M으로 '시작하는' 사원의 모든 필드를 출력하시오.
SELECT * FROM EMP WHERE ENAME LIKE 'M%';

  -- EX. 이름이 S으로 '끝나는' 사원의 모든 필드를 출력하시오.
SELECT * FROM EMP WHERE ENAME LIKE '%S';

  -- EX. 급여가 5로 끝나는 사원의 모든 필드
SELECT * FROM EMP WHERE SAL LIKE '%5';
SELECT * FROM EMP WHERE SAL = '2975'; -- 숫자형과 문자형 비교가능!

  --EX. 82년도에 입사한 사원의 모든필드
SELECT * FROM EMP WHERE HIREDATE LIKE '82/%';
SELECT * FROM EMP WHERE TO_CHAR (HIREDATE, 'RR/MM/DD') LIKE  '82/%';
SELECT * FROM EMP WHERE TO_CHAR (HIREDATE, 'RR') LIKE '82';
SELECT * FROM EMP WHERE TO_CHAR (HIREDATE, 'RR') LIKE 82;

  --EX. 1월에 입사한 사원의 모든필드
SELECT * FROM EMP WHERE HIREDATE LIKE '%/01/%';
SELECT * FROM EMP WHERE TO_CHAR (HIREDATE, 'MM') LIKE '01'; -- 따로 월만 하고 싶으면 문자열화 시켜서 MM으로 뺌
SELECT * FROM EMP WHERE TO_CHAR (HIREDATE, 'RR/MM/DD') LIKE '__/01/__';

  --EX. 82년도가 아닌 년도에 입사한 사원의 모든 필드
SELECT * FROM EMP WHERE HIREDATE NOT LIKE '82/%';  

  --EX. 이름에 S가 들어간 사원의 모든 필드
SELECT * FROM EMP WHERE ENAME LIKE '%S%';  
SELECT * FROM EMP WHERE ENAME LIKE '%%%';  -- 모든 필드
SELECT * FROM EMP WHERE ENAME LIKE '%\%%' ESCAPE '\';
INSERT INTO EMP VALUES (9999, '홍%', NULL, NULL, NULL, 9000, 900, 40); --데이터 입력
ROLLBACK; -- DML (데이터를 추가, 삭제, 수정)로 된 수정된 데이터 원상복귀 DML취소
 
 -- 8. 4. IS NULL
SELECT * FROM EMP;
  --EX. 상여금이 NULL인 사원의 모든 필드
SELECT * FROM EMP WHERE COMM IS NULL;--NULL을 비교시 반드시 IS NULL로.

  --EX. 상여금이 없는 사원의 모든 필드 (COMM이 NULL이거나)
SELECT * FROM EMP WHERE COMM IS NULL OR COMM=0;

  --EX. 상여금이 있는 사원의 모든 필드
SELECT * FROM EMP WHERE NOT COMM IS NULL AND COMM!=0;

--9. 정렬 (오름차순, 내림차순)

SELECT ENAME, SAL FROM EMP ORDER BY SAL ;       -- 급여 오름차순 정렬 작은거부터 큰것으로
SELECT ENAME, SAL FROM EMP ORDER BY SAL ASC ;
SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC ;  -- 급여 내림차순
SELECT ENAME, SAL FROM EMP ORDER BY ENAME;      -- 이름 ABCD 순으로
SELECT ENAME, SAL FROM EMP ORDER BY ENAME DESC; -- 이름 ZYX 순으로
SELECT ENAME, HIREDATE FROM EMP ORDER BY HIREDATE; -- 날짜 순서대로 정렬
SELECT ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC;  -- 가장 마지막에 들어온 사람부터

  -- 이름, 연봉 (SAL*12+COMM)을 출력 (연봉이 높은 순으로, 연봉이 같은 경우 이름 순으로)
SELECT ENAME, SAL*12+NVL(COMM,O) "ANNUAL_SAL" 
   FROM EMP ORDER BY SAL*12+NVL(COMM,O) DESC, ENAME;
SELECT ENAME, SAL*12+NVL(COMM,O) "ANNUAL_SAL" 
   FROM EMP ORDER BY "ANNUAL_SAL" DESC, ENAME;   -- 오더 바이 절에는 별칭 사용가능하다.
   
  -- EX. 사번, 이름, 입사일, 급여, 부서번호 (부서번호순으로, 부서가 같으면 입사일 오름차 순으로 출력)
SELECT EMPNO, ENAME, HIREDATE, SAL, DEPTNO FROM EMP ORDER BY DEPTNO, HIREDATE;

 -- 시험 연습문제!


--1.	EMP 테이블에서 sal이 3000이상인 사원의 empno, ename, job, sal을 출력
SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL>=3000;
 
--2.	EMP 테이블에서 empno가 7788인 사원의 ename과 deptno를 출력
SELECT ENAME, DEPTNO FROM EMP WHERE EMPNO = '7788';

--3.	연봉이 24000이상인 사번, 이름, 급여 출력 (급여순정렬)
SELECT EMPNO, ENAME, SAL FROM EMP WHERE (SAL*12+NVL(COMM,0)) >=24000 ORDER BY SAL;

--4.	입사일이 1981년 2월 20과 1981년 5월 1일 사이에 입사한 사원의 사원명, 직책, 입사일을 출력 (단 hiredate 순으로 출력)
SELECT ENAME, JOB, HIREDATE FROM EMP WHERE  HIREDATE BETWEEN TO_DATE ('1981/02/20', 'YYYY/MM/DD') AND TO_DATE ('1981/05/01', 'YYYY/MM/DD') ORDER BY HIREDATE;

--5.	deptno가 10,20인 사원의 모든 정보를 출력 (단 ename순으로 정렬)
SELECT * FROM EMP WHERE DEPTNO IN (10, 20) ORDER BY ENAME;

--6.	sal이 1500이상이고 deptno가 10,30인 사원의 ename과 sal를 출력
-- (단 HEADING을 employee과 Monthly Salary로 출력)
SELECT ENAME AS "employee", SAL as "Monthly Salary" FROM EMP WHERE DEPTNO IN (10, 30) AND SAL >=1500;

--7.	hiredate가 1982년인 사원의 모든 정보를 출력
SELECT * FROM EMP WHERE TO_CHAR (HIREDATE, 'YYYY/MM/DD') LIKE '1982/%';

--8.	이름의 첫자가 C부터  P로 시작하는 사람의 이름, 급여 이름순 정렬
SELECT ENAME, SAL FROM EMP WHERE ENAME BETWEEN 'C' AND 'Q' AND ENAME != 'Q' ORDER BY SAL, ENAME; 

--9.	comm이 sal보다 10%가 많은 모든 사원에 대하여 이름, 급여, 상여금을 
--출력하는 SELECT 문을 작성
SELECT ENAME, SAL, COMM FROM EMP WHERE COMM > (SAL*1.1);

--10.	job이 CLERK이거나 ANALYST이고 sal이 1000,3000,5000이 아닌 모든 사원의 정보를 출력
SELECT * FROM EMP WHERE JOB = 'CLERK' OR JOB = 'ANALYST' AND SAL NOT IN (1000, 3000, 5000);

--11.	ename에 L이 두 자가 있고 deptno가 30이거나 또는 mgr이 7782인 사원의 
--모든 정보를 출력하는 SELECT 문을 작성하여라.
SELECT * FROM EMP WHERE ENAME LIKE '%L%L%' AND DEPTNO = '30' OR MGR = '7782';

--12.	입사일이 81년도인 직원의 사번,사원명, 입사일, 업무, 급여를 출력
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE TO_CHAR(HIREDATE, 'RR') = '81';

--13.	입사일이81년이고 업무가 'SALESMAN'이 아닌 직원의 사번, 사원명, 입사일, 
-- 업무, 급여를 검색하시오.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE TO_CHAR(HIREDATE, 'RR') = '81' AND JOB != 'SALESMAN';

--14.	사번, 사원명, 입사일, 업무, 급여를 급여가 높은 순으로 정렬하고, 
-- 급여가 같으면 입사일이 빠른 사원으로 정렬하시오.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP ORDER BY SAL DESC, HIREDATE;

--15.	사원명의 세 번째 알파벳이 'N'인 사원의 사번, 사원명을 검색하시오
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '__N%';

--16.	사원명에 'A'가 들어간 사원의 사번, 사원명을 출력
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '%A%';

--17.	연봉(SAL*12)이 35000 이상인 사번, 사원명, 연봉을 검색 하시오.
SELECT EMPNO, ENAME, (SAL*12) "연봉" FROM EMP WHERE (SAL*12) >= 35000; 











