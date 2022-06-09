--book.sql
-- DROP & CREATE
DROP SEQUENCE BOOK_SEQ;
DROP TABLE BOOK;
CREATE SEQUENCE BOOK_SEQ MAXVALUE 99999 NOCACHE NOCYCLE;
CREATE TABLE BOOK (
        BID     NUMBER(5) PRIMARY KEY,      --  책번호
        BTITLE  VARCHAR2(50) NOT NULL,      --  책제목
        BPRICE  NUMBER(7) NOT NULL,         --  책가격
        BIMAGE1 VARCHAR2(50) NOT NULL,      --  책 대표 이미지 (첨부 하지 않을 경우 : noImg.png)
        BIMAGE2 VARCHAR2(50) NOT NULL,      --  책 부가 이미지 (첨부 하지 않을 경우 : NOTHING.jpg)
        BCONTENT VARCHAR2(4000),            --  책 설명 (한글 1,333 글자 이내)
        BDISCOUNT NUMBER(3) NOT NULL,       --  책 할인율
        BRDATE  DATE DEFAULT SYSDATE        --  책 등록일
        
        );
SELECT * FROM BOOK;

-- 책등록
        INSERT INTO BOOK ( BID, BTITLE, BPRICE, BIMAGE1, BIMAGE2, BCONTENT, BDISCOUNT)
        VALUES (BOOK_SEQ.nextval, '이것은 자바다', 30000, 'noImg.png', 'NOTHING.jpg', '이것은 자바다. 자바야 나 자바봐라. 자바야지! 못잡겠지? 몽충몽충', 20);
        INSERT INTO BOOK ( BID, BTITLE, BPRICE, BIMAGE1, BIMAGE2, BCONTENT, BDISCOUNT)
        VALUES (BOOK_SEQ.nextval, '이것은 sql이다', 38000, 'noImg.png', 'NOTHING.jpg', '이것은 sql이다. 자바야 나 자바봐라. sql이다 못잡겠지? 몽충몽충', 10);
        INSERT INTO BOOK ( BID, BTITLE, BPRICE, BIMAGE1, BIMAGE2, BCONTENT, BDISCOUNT)
        VALUES (BOOK_SEQ.nextval, '이것은 BTS다', 50000, 'noImg.png', 'NOTHING.jpg', '이것은 BTS다. BTS야 나 자바봐라. BTS지! 못잡겠지? 몽충몽충', 30);
        INSERT INTO BOOK ( BID, BTITLE, BPRICE, BIMAGE1, BIMAGE2, BCONTENT, BDISCOUNT)
        VALUES (BOOK_SEQ.nextval, '이것은 lovelyz다', 11120, 'noImg.png', 'NOTHING.jpg', '이것은 lovelyz다. 자바야 나 자바봐라. 자바야지! 못잡겠지? 몽충몽충', 5);

        commit;
        
-- 책목록(전체LIST)
SELECT * FROM BOOK ORDER BY BRDATE DESC;


-- 책목록(TOP-N구문)
SELECT
    * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOOK ORDER BY BRDATE DESC) A)
    WHERE RN BETWEEN 1 AND 3;

-- 등록된 책 갯수
SELECT COUNT(*) CNT FROM BOOK;

-- 책 상세보기 (BID로 DTO가져오기)

SELECT * FROM BOOK WHERE BID=1;

COMMIT;















