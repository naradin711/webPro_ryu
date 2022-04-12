-- [IV] 단일행 함수 ; 내장함수, SQL 주요함수
-- 함수 => 단일행 함수 + 그룹함수(집계함수)
  -- 단일행 함수 (INPUT 1행 -> OUTPUT 1행)
SELECT HIREDATE, TO_CHAR(HIREDATE, 'YY"년"MM"월"DD"일"') FROM EMP; -- 단일행 함수
SELECT ENAME, INITCAP (ENAME) FROM EMP; -- 첫글자만 대문자.
  -- 그룹함수 (INPUT N행 -> OUTPUT 1행) - 5장에서 할 예정.
SELECT SUM (SAL), ROUND(AVG(SAL), 2) FROM EMP; -- SAL 14행의 모든 값을 더해서 SUM 함수 AVG(평균)함수
SELECT DEPTNO, SUM (SAL) FROM EMP GROUP BY DEPTNO; -- 부서별 SAL의 합


-- 단일행함수의 종류 : 숫자관련함수, 문자관련함수, 날짜관련된함수(예약어), 형변환함수, NVL(), ETC...

--1. 숫자 관련함수
  --DUAL 테이블 : 오라클에서 제공하는 1행 1열짜리 DUMMY TABLE
DESC DUAL;
DESC DUMMY;
SELECT * FROM DUAL; -- 산술함수를 하고 싶은데 테이블을 제공하는 DUMMY TABLE
SELECT * FROM DUMMY; -- DUAL이 없으면 이 테이블을 산술용 테이블로 사용 가능.
SELECT -9, ABS (-9) FROM DUAL;
SELECT FLOOR(34.5678) FROM DUAL;
SELECT FLOOR(34.5678*100)/100 FROM DUAL;  -- 소수점 2번째 자리에서 내림
SELECT TRUNC(34.5678, 2) FROM DUAL;       -- 소수점 2번째 자리에서 내림
SELECT TRUNC(34.5678) FROM DUAL;          -- 소수점에서 내림
SELECT TRUNC(34.5678, -1) FROM DUAL;      -- 일의 자리에서 내림

  --EX. EMP테이블에서 이름, 급여(십의 자리에서 내림)
SELECT ENAME, TRUNC(SAL, -2) "급여", SAL FROM EMP;  

SELECT CEIL(34.5678) FROM DUAL;           -- 소수점에서 올림
SELECT CEIL(34.5678*100)/100 FROM DUAL;   -- 소수점 2번째 자리에서 올림

SELECT ROUND(34.5678) FROM DUAL;          -- 소수점에서 반올림
SELECT ROUND(34.5678, 2) FROM DUAL;       -- 소수점 두번째 자리에서 반올림
SELECT ROUND(34.5678, -1) FROM DUAL;      -- 일의 자리에서 반올림

SELECT MOD (9, 2) FROM DUAL;              -- 9%2 나머지 연산자.

  --EX. 사번이 홀수인 사원의 모든 필드 출력!
SELECT * FROM EMP WHERE MOD (EMPNO, 2) = 1; 

  --EX. 홀수달에 입사한 사원의 모든 필드 출력
SELECT * FROM EMP WHERE MOD (TO_CHAR (HIREDATE, 'MM'),2 ) = 1;

-- 2. 문자관련함수
-- (1) 대소문자 관련
SELECT UPPER (' abcABC') FROM DUAL;
SELECT LOWER (' abcABC') FROM DUAL;
SELECT INITCAP ('WELCOME TO ORACLE') FROM DUAL;
  --EX. JOB이 대소문자인지는 모르나 'MANAGER'인 모든 필드 출력
SELECT * FROM EMP WHERE UPPER(JOB) = 'MANAGER'; --JOB에 있는 모든 문자열을 대문자화 
SELECT * FROM EMP WHERE LOWER(JOB) = 'manager'; --JOB에 있는 모든 문자열을 소문자화
SELECT * FROM EMP WHERE INITCAP(JOB) = 'Manager';

-- (2) 문자연결 (CONCAT, || 연산자)
SELECT 'AB' || 'CD' || 'EF' || 'GH' FROM DUAL;
SELECT CONCAT(CONCAT('AB', 'CD'), CONCAT ('EF','GH')) FROM DUAL;

  --EX. 아무개(ENAME)는 ㅇㅇ(JOB)이다 포맷으로 EMP M 테이블 정보 출력
SELECT CONCAT(CONCAT(ENAME, '은 '), CONCAT ( JOB,'이다')) FROM EMP; 

-- (3) SUBSTR(STR, 시작위치, 문자갯수) 첫번째 위치가 1, 시작위치는 음수도 가능.
-- SUBSTRB(STR, 시작바이트위치, 문자바이트수)
SELECT SUBSTR ('ORACLE', 3, 2) FROM DUAL; -- 3번째 글자부터 2글자씩 추출
SELECT SUBSTRB ('ORACLE', 3, 2) FROM DUAL; --3번째 바이트부터 2바이트 추출
SELECT SUBSTR ('데이터베이스', 4,3) FROM DUAL; 
SELECT SUBSTRB ('데이터베이스', 4,3) FROM DUAL; --4번째 바이트 부터 3바이트 추출 한글의 경우 한글자가 3바이트
SELECT SUBSTRB ('홍길동', 3) FROM DUAL ;
SELECT SUBSTR('ABCDXD', -1 , 1) FROM DUAL;
SELECT SUBSTR (123, 2, 1) FROM DUAL; -- 숫자도 가능.
  --EX. 9월에 입시한 사원의 모든 필드 (단 DATE 출력 FORMAT 'RR/MM/DD')
SELECT * FROM EMP WHERE SUBSTR (HIREDATE, 4, 2 )= '09';
  --EX. 9일에 입시한 사원의 모든 필드 (단 DATE 출력 FORMAT 'RR/MM/DD')

-- 글자수 LENGH, NOT LENGTH VS 바이트수 (LENTHB)
SELECT LENGTH ('ABC') FROM DUAL; -- 글자수 3
SELECT LENGTHB ('ABC') FROM DUAL; -- 바이트 3
SELECT LENGTH ('오라클') FROM DUAL; -- 글자수 3
SELECT LENGTHB ('오라클') FROM DUAL; -- 바이트 9

-- (5) INSTR(STR, 찾을 글자) : STR로 인해 찾을 글자의 위치 첫번째 1 없으면 0
--     INSTR(STR, 찾을 글자,  시작위치) : STR을 시작위치에서 찾아서 찾은 글자의 위치, 위치 음수 가능
SELECT INSTR ('ABCABC', 'B' ) FROM DUAL; -- 처음부터 찾아서 처음나오는 찾을값을 반환
SELECT INSTR ('ABCABC', 'B', 3 ) FROM DUAL; -- 앞 3번째 부터 찾아서 처음 나오는 값을 반환
SELECT INSTR ('ABCABC', 'B', -3 ) FROM DUAL; -- 뒤 3번째부터 찾아서 뒤에서 앞으로 찾아서 처음 나오는 값의 위치

  -- EX. 9월에 입사한 사원의 모든 필드 (INSTR)
SELECT * FROM EMP WHERE INSTR(HIREDATE, '09', 4) =4;
 -- EX. 9일에 입사한 사원의 모든 필드 (INSTR)
SELECT * FROM EMP WHERE INSTR(HIREDATE, '09', 7) =7;
 -- EX. 9일이 아닌날에 입사한 사원의 모든 필드 (INSTR)
SELECT * FROM EMP WHERE INSTR(HIREDATE, '09', 7) =0;

-- (6) LPAD(STR, 자리수, 채울문자) STR을 자리수 만큼 확보하고 왼쪽 빈자리에 채울 문자 출력
--     RPAD(STR, 자리수, 채울문자) STR을 자리수 만큼 확보하고 왼쪽 빈자리에 채울 문자 출력

SELECT LPAD ('ORACLE', 10, '#') FROM DUAL;
SELECT RPAD ('ORACLE', 10, '#') FROM DUAL;
SELECT ENAME, SAL, LPAD (SAL, 6, '*') FROM EMP;

  -- EX. 사번, 이름 출력 (7788 S****, 이름은 앞 한글자만 출력하고 나머지는 *)
 SELECT EMPNO, RPAD ((SUBSTR (ENAME, 1,1)), LENGTH(ENAME), '*') "이름" FROM EMP;
 
  -- EX. 사번, 이름, 입사일 (이름은 10자리 확보하면서 이름 글자수 만큼 * 맨 마지막 글자만 출력)
  -- EX. 7892. ______****H 80/12/** 

SELECT EMPNO, LPAD(LPAD((SUBSTR (ENAME, -1,1)), LENGTH(ENAME), '*'), 10, '_') "NAME", TO_CHAR (HIREDATE, 'YY/MM/**') "HIREDATE" FROM EMP;
SELECT RPAD (SUBSTR (HIREDATE,1,6),LENGTH(HIREDATE),'*') FROM EMP;

  -- EX. 이름의 세번째 자리가 R인 사원의 모든 필드
SELECT * FROM EMP WHERE ENAME LIKE '__R%';
SELECT * FROM EMP WHERE INSTR(ENAME, 'R', 3)=3;
SELECT * FROM EMP WHERE SUBSTR (ENAME, 3,1)='R';

-- (7) 여백제거
SELECT TRIM('      ORACLE    ')FROM DUAL;
SELECT RTRIM('  ORACLE   ')FROM DUAL;
SELECT LTRIM('  ORACLE   ')FROM DUAL;

-- (8) 대체하기

SELECT REPLACE (ENAME, 'A', 'XX') FROM EMP;
SELECT REPLACE (HIREDATE, '0', '_') FROM EMP;

-- 3. 날짜 관련 함수 및 예약
-- (1). SYSDATE : 지금
SELECT SYSDATE FROM DUAL;
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD DY HH24:MI:SS';
SELECT SYSDATE FROM DUAL;
SELECT ENAME, HIREDATE FROM EMP;
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD'; -- 원상복구
SELECT TO_CHAR (SYSDATE, 'YYYY/MM/DD DY HH24:MI:SS') "TIMENOW" FROM DUAL;
SELECT SYSDATE-1 "어제 이시간", SYSDATE "지금", SYSDATE+1 "내일이시간"  FROM DUAL; --

--(2) 날짜 계산 : 14일 후
SELECT SYSDATE+14 "반납기한일" FROM DUAL;

  --EX. 이름, 입사일, 근무일수 
SELECT ENAME "이름", HIREDATE "입사일", FLOOR(SYSDATE-HIREDATE)||'일' "근무일수" FROM EMP;  
SELECT ENAME "이름", HIREDATE "입사일", FLOOR((SYSDATE-HIREDATE)/7)||'주' "근무주수" FROM EMP; 
SELECT ENAME "이름", HIREDATE "입사일", FLOOR((SYSDATE-HIREDATE)/365)||'년' "근무년수" FROM EMP; 

--(3) MONTHS_BETWEEN (날짜, 날짜) : 두 날짜간의 개월수
  -- EX. 이름, 입사일, 근무월수
SELECT ENAME, HIREDATE, FLOOR(MONTHS_BETWEEN(SYSDATE, HIREDATE))|| '개월' "근무월수" FROM EMP; 
  
  -- EX. 이름, 입사한 이후 받은 급여와 상여금 SAL 매달, COMM은 매년 2회씩
SELECT ENAME,  FLOOR(MONTHS_BETWEEN(SYSDATE, HIREDATE))* SAL "총 급여", FLOOR((SYSDATE-HIREDATE)/365)*2*NVL(COMM, 0) "총 상여금" FROM EMP;

-- (4) ADD_MONTHS(날짜, 개월수) : 특정시점부터 몇개월 후의 날짜.
  -- EX. 이름, 입사일, 수습종료일 (수습기간은 입사일로부터 6개월로 한다.)
SELECT ENAME, HIREDATE, ADD_MONTHS(HIREDATE, 6) "수습종료일" FROM EMP;

-- (5) LAST_DAY (특정날짜) : 특정날짜 달의 말일을 출력
SELECT LAST_DAY(SYSDATE) FROM DUAL;
  -- EX. 이름, 입사일, 첫 월급 (월급날은 말일)
SELECT ENAME, HIREDATE, LAST_DAY(HIREDATE) "월급날" FROM EMP;

--(6) ROUND (날짜, XX) : 날짜 반올림 / TRUNC (날짜, XX) : 날짜 버림
SELECT ROUND (SYSDATE, 'YEAR') FROM DUAL; -- 결과 가까운년도의 1월 1일
SELECT ROUND (SYSDATE, 'MONTH') FROM DUAL; --  결과 가까운 월의 1일 15일까지는 해당 월 16일부터는 다음 달.
SELECT ROUND (SYSDATE, 'DAY') FROM DUAL; -- 결과는 가까운 일요일 수요일까지는 저번 일요일 목부터는 다음 일요일
SELECT ROUND (SYSDATE) FROM DUAL; -- 결과 가까운 0시
SELECT TO_CHAR (ROUND (SYSDATE) , 'YYYY/MM/DD DY HH24:MI:SS') FROM DUAL; --정오 이전 오늘 정오 이후 다음날

SELECT TRUNC (SYSDATE, 'YEAR') FROM DUAL; -- 올해 1월 1일
SELECT TRUNC (SYSDATE, 'MONTH') FROM DUAL; --  이번달 1일
SELECT TRUNC (SYSDATE, 'DAY') FROM DUAL; -- 지난 일요일
SELECT TRUNC (SYSDATE) FROM DUAL; -- 결과 오늘 0시
SELECT TO_CHAR (ROUND (SYSDATE) , 'YYYY/MM/DD DY HH24:MI:SS') FROM DUAL; --정오 이전 오늘 정오 이후 다음날

  --  EX. 이름, 입사일, 입사한 달의 5일
SELECT ENAME, HIREDATE, TRUNC(HIREDATE, 'MONTH')+4 FROM EMP;  
  --  EX. 이름, 입사일, 월급날 (월급날은 매달 16일)
SELECT ENAME, HIREDATE, TO_CHAR(ROUND(HIREDATE, 'MONTH')+15 , 'MM/DD' ) "월급날" FROM EMP;
  --  EX. 이름, 입사일, 월급날 (월급날은 매달 15일)
SELECT ENAME, HIREDATE, TO_CHAR(ROUND(HIREDATE+1, 'MONTH')+14 , 'MM/DD' ) "월급날" FROM EMP;
--  EX. 이름, 입사일, 월급날 (월급날은 매달 5일)
SELECT ENAME, HIREDATE, TO_CHAR(ROUND(HIREDATE+11, 'MONTH')+4 , 'MM/DD' ) "월급날" FROM EMP;
--  EX. 이름, 입사일, 월급날 (월급날은 매달 20일)
SELECT ENAME, HIREDATE, TO_CHAR(ROUND(HIREDATE-4, 'MONTH')+19 , 'MM/DD' ) "월급날" FROM EMP;

--(7) NEXT_DAY (날짜, '수') : 특정날짜로부터 처음 도래하는 수요일
SELECT SYSDATE, NEXT_DAY(SYSDATE, '수') FROM DUAL;

-- 4. 형변환 함수 (문자<>숫자, 문자<>날짜)
-- (1) TO_CHAR(날짜형데이터, '출력형식')
   -- YYYY(년도 4자리), YY/RR (년도 2자리), MM (월) DD(일) DAY(요일)/DY(요일 요약)
   -- AM/PM (오전/오후) HH12/HH24 (시간) MI(분) SS(초)
SELECT TO_CHAR(SYSDATE,' YY "년" MM "월"  DD"일  " DY HH24"시"  MI"분" SS"초" ' ) FROM DUAL;  
-- (2) TO_CHAR(숫자데이터, '출력형식')
  -- 0 : 자릿수, 출력형식의 자릿수가 많으면 0으로 채움
  -- 9 : 자릿수, 출력형식의 자릿수가 많아도 숫자만큼만 입력.
  -- , : 세자리마다, 가능
  -- . : 소수점
  -- $ : 통화단위가 앞에 붙을수 있음
  -- L : 지역통화단위가 앞에 붙음
SELECT TO_CHAR (123456, '9,999,999.99') FROM DUAL;  
SELECT TO_CHAR (123456, '0,000,000.00') FROM DUAL; -- 여기에는 빈자리 0이 자동 출력
SELECT TO_CHAR (10000, 'L999,999') FROM DUAL; -- 시스템에서 국적을 읽어서 통화단위 자동 출력
SELECT ENAME, TO_CHAR (SAL, '$99,999') FROM EMP; -- 달러를 붙임
SELECT ENAME, TO_CHAR (SAL, '$99,999') FROM EMP;

--3. TO_DATE (문자데이터, '패턴')
SELECT TO_DATE('20220412', 'YYYY-MMDD') FROM DUAL;
  -- EX. 81/5/1 ~83/5/1 사이에 입사한 직원의 모든 필드 (TO_DATE)사용
SELECT * FROM EMP
  WHERE HIREDATE BETWEEN TO_DATE ('810501', 'RRMMDD')AND TO_DATE ('830501', 'RRMMDD');
  
--4. TO_NUMBER (문자, '패턴')  
SELECT '1234'+1 FROM DUAL;
SELECT TO_NUMBER('1,234', '9,999')+1 FROM DUAL;

--5. NVL (NULL 일수도 잇는 데이터, NULL이면 대신할 값) - 매개변수 2개는 타입 일치 해야함.
SELECT ENAME, NVL(COMM, 0) FROM EMP;
 -- EX. 이름, 상사의 사번을 출력하되 상사의 사번이 NULL일 경우 'CEO'로 출력
SELECT ENAME, NVL(TO_CHAR (MGR), 'CEO') FROM EMP;

--6. ETC
-- (1) EXTRACT
SELECT EXTRACT (YEAR FROM SYSDATE) FROM DUAL;
SELECT TO_CHAR (SYSDATE, 'YYYY') FROM DUAL;
SELECT EXTRACT (MONTH FROM HIREDATE) FROM EMP;
SELECT EXTRACT (DAY FROM HIREDATE) FROM EMP;
  --EX. 2월에 입사한 직원의 모든 필드
SELECT * FROM EMP WHERE HIREDATE LIKE '__/02/__';
SELECT * FROM EMP WHERE EXTRACT (MONTH FROM HIREDATE)=2 ;
  -- 81년도에 입사한 직원의 모든 필드
SELECT * FROM EMP WHERE HIREDATE LIKE '81/__/__';
SELECT * FROM EMP WHERE EXTRACT (YEAR FROM HIREDATE)=1981 ;

-- (2) 계층적 출력(레벨별 출력) : LEVEL, START WITH 조건 (MGL IS NULL), CONNECT BY PRIOR 조건 (EMPNO=MGR)

SELECT LEVEL, LPAD(' ', LEVEL*2)||ENAME -- 댓글 대댓글 달때 쓰는 것
  FROM EMP
  START WITH MGR IS NULL
  CONNECT BY PRIOR EMPNO = MGR;


-- <총 연습문제>

-- 1. 현재 날짜를 출력하고 TITLE에 “Current Date”로 출력하는 SELECT 문장을 기술하시오.
SELECT SYSDATE "Current Date" FROM DUAL;

-- 2. EMP 테이블에서 현재 급여에 15%가 증가된 급여를 계산하여,
-- 사원번호,이름,업무,급여,증가된 급여(New Salary),증가액(Increase)를 출력하는 SELECT 문장
SELECT EMPNO, ENAME, JOB, SAL, ROUND(SAL*1.15) "New Salary", ROUND(SAL*0.15) "Increase" FROM EMP;

--3. 이름, 입사일, 입사일로부터 6개월 후 돌아오는 월요일 구하여 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, HIREDATE, TRUNC (HIREDATE+180, 'DAY')+1  FROM EMP;

--4. 이름, 입사일, 입사일로부터 현재까지의 개월수, 급여, 입사일부터 현재까지의 받은 급여의 총계를 출력
SELECT ENAME, HIREDATE, FLOOR(MONTHS_BETWEEN(SYSDATE, HIREDATE))|| '개월' "근무월수", SAL, 
     SAL * FLOOR(MONTHS_BETWEEN(SYSDATE, HIREDATE)) "총급여" FROM EMP;

--5. 모든 사원의 이름과 급여(15자리로 출력 좌측의 빈 곳은 “*”로 대치)를 출력
SELECT LPAD(ENAME, 15, '*'), LPAD(SAL, 15, '*') FROM EMP;

--6. 모든 사원의 정보를 이름,업무,입사일,입사한 요일을 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, JOB, HIREDATE, TO_CHAR (HIREDATE, 'DY"요일"') "입사요일" FROM EMP;

--7. 이름의 길이가 6자 이상인 사원의 정보를 이름,이름의 글자수,업무를 출력
SELECT ENAME, LENGTH(ENAME) "글자수", JOB FROM EMP WHERE LENGTH(ENAME)>=6;

--8. 모든 사원의 정보를 이름, 업무, 급여, 보너스, 급여+보너스를 출력
SELECT ENAME, JOB, SAL, NVL(COMM, 0), SAL+NVL(COMM, 0) FROM EMP;

-- 9.사원 테이블의 사원명에서 2번째 문자부터 3개의 문자를 추출하시오. 
SELECT SUBSTR (ENAME, 2, 3) FROM EMP;

--10. 사원 테이블에서 입사일이 12월인 사원의 사번, 사원명, 입사일을 검색하시오. 
--  시스템에 따라 DATEFORMAT 다를 수 있으므로 아래의 방법도 알아보자
SELECT EMPNO, ENAME, HIREDATE FROM EMP
  WHERE HIREDATE LIKE '__/12/__';


--11. 다음과 같은 결과를 검색할 수 있는 SQL 문장을 작성하시오
--EMPNO		ENAME		급여
--7369		       SMITH		*******800
--7499		       ALLEN		******1600
--7521		       WARD		******1250
--……. 
SELECT EMPNO, LPAD (ENAME, 10, '_'), LPAD (SAL, 10, '*') "급여" FROM EMP;


-- 12. 다음과 같은 결과를 검색할 수 있는 SQL 문장을 작성하시오
-- EMPNO	 ENAME 	입사일
-- 7369	  SMITH		1980-12-17
-- ….
SELECT EMPNO, RPAD (ENAME, 7, '_') "ENAME", TO_CHAR (HIREDATE, 'YYYY"-"MM"-"DD') "입사일" FROM EMP;




--13. 사원 테이블에서 부서 번호가 20인 사원의 사번, 이름, 직무, 급여를 출력하시오.
    --(급여는 앞에 $를 삽입하고3자리마다 ,를 출력한다)
SELECT EMPNO, ENAME, JOB, TO_CHAR (SAL, '$99,999') "급여" FROM EMP WHERE DEPTNO = 20;



