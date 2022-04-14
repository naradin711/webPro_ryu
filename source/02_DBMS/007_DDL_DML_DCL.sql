-- [VII] DDL, DML, DCL
-- SQL = DDL (테이블 생성, 테이블 삭제, 테이블구조변경, 테이블 모든 데이터 제거)
--       DML (검색 = SELECT, 추가 = INSERT, 수정 = UPDATE, 삭제 = DELETE)
--       DCL (사용자계정생성, 사용자권한부여, 권한박탈, 사용자계정삭제)

-- *** DDL ***
-- 1. 테이블 생성 (CREATE TABLE)
CREATE TABLE BOOK(
  BOOKID NUMBER(4),         -- 도서번호 BOOKID 필드 타입은 숫자 4자리
  BOOKNAME VARCHAR2(300),   -- 도서제목 BOOKNAME 필드는 문자 300 바이트
  PUBLISHER VARCHAR2(300),  -- 출판사 PUBLISHER 필드는 문자 300 바이트
  RDATE     DATE,           -- 출판일 RDATE 필드는 DATE형
  PRICE     NUMBER(8),      -- 가격 PRICE 필드는 숫자 8자리
  PRIMARY KEY(BOOKID));     -- BOOKID 는 주키/PRIMARY KEY 설정 - NOT NULL, 유일한 값 입력.
  
SELECT * FROM BOOK;