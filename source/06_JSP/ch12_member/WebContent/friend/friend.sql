-- Friend 쿼리 만들기
-- SELECT & DROP;
SELECT * FROM FRIEND;
DROP TABLE FRIEND;
DROP SEQUENCE FRIEND_SEQ;
commit;
--
CREATE SEQUENCE FRIEND_SEQ
    MAXVALUE 999
    MINVALUE 1
    NOCACHE
    NOCYCLE ;

CREATE TABLE FRIEND (
        NUM NUMBER(5) PRIMARY KEY,
        NAME VARCHAR2(20) NOT NULL,
        PHONE VARCHAR2(20)
        );

-- 1. 친구 추가 할 쿼리
    INSERT INTO FRIEND (NUM, NAME, PHONE)
    VALUES (FRIEND_SEQ.NEXTVAL , '서지수', '010-3333-3333');
    INSERT INTO FRIEND (NUM, NAME, PHONE)
    VALUES (FRIEND_SEQ.NEXTVAL , '유지애', '010-2222-2222');

-- 2. 친구 리스트 뽑기.
SELECT * FROM FRIEND;

-- 2-1. 이름으로 친구 리스트 뽑기.
SELECT * FROM FRIEND WHERE NAME LIKE '%정%' AND PHONE LIKE '%%' ;









    