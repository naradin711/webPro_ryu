-- [XI] 인덱스 : 문서 내 검색 및 조회를 빠르게 하기 위한 방법
SELECT * FROM USER_INDEXES; -- 딕셔너리 뷰에서 SCOTT이 소유한 인덱스 정보
DESC EMP;
SELECT * FROM EMP01;
DROP TABLE EMP01;
CREATE TABLE EMP01 AS SELECT * FROM EMP; --EMP 테이블과 똑같은 EMP01 생성
SELECT * FROM EMP01; -- 14행
INSERT INTO EMP01 SELECT * FROM EMP01; -- 1번 수행 28 2번 수행 56행 / 12번 수행
INSERT INTO EMP01 (EMPNO, ENAME) VALUES (1111,'HONG'); --HONG 일부
INSERT INTO EMP01 SELECT * FROM EMP01; -- 3번 수행(20만 ROW정도)
SELECT * FROM EMP01 WHERE ENAME = 'HONG'; -- 인덱스 생성 이전 0.116초
-- 인덱스 생성 (EMP01의 ENAME) 하고 조회
CREATE INDEX IDX_EMP_ENAME ON EMP01(ENAME);
SELECT * FROM EMP01 WHERE ENAME = 'HONG'; -- 인덱스 생성 이후 0.002초
COMMIT;
SELECT TO_CHAR(COUNT(*),’9,999,999') FROM EMP01;