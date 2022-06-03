-- 테이블 DROP과 CREATE
DROP TABLE BOARD;
SELECT * FROM board;
COMMIT;
CREATE TABLE BOARD (
    NUM        NUMBER(5,0)    PRIMARY KEY, -- 글번호
    WRITER     VARCHAR2(30)    NOT NULL, -- 글쓴이
    SUBJECT    VARCHAR2(100)   NOT NULL, -- 글제목
    CONTENT    VARCHAR2(4000)  NOT NULL, -- 본문
    EMAIL      VARCHAR2(30),             -- 작성자 이메일
    READCOUNT  NUMBER(7,0)    DEFAULT 0,-- 조회수
    PW         VARCHAR2(30)    NOT NULL, -- 삭제할 때 물어볼 비밀번호
    REF        NUMBER(5,0)    NOT NULL, -- 글 그룹(원글일 경우, 글번호로 / 답변글일 경우 원글의 글번호로 출력)
    RE_STEP    NUMBER(5,0)    NOT NULL, -- 그룹 내의 출력 순서 (원글은 무조건 0)
    RE_INDENT  NUMBER(5,0)    NOT NULL, -- 글 LIST 출력시 들여쓰기 정도 (원글은 무조건 0)
    IP         VARCHAR2(20)   NOT NULL, -- 글 작성 시의 ip 주소
    RDATE      DATE           DEFAULT SYSDATE -- 글 쓴 시점(날짜+시간)
    );

--1 글 갯수 가져오는 

SELECT COUNT(*)"COUNT" FROM BOARD;

--2 글 목록 (최신글이 위로)
-- SELECT * FROM BOARD ORDER BY NUM DESC;
SELECT * FROM BOARD ORDER BY REF DESC;


--3 글 쓰기
    -- 글번호 만들기: 
    SELECT NVL(MAX(NUM),0)+1 FROM BOARD; 
INSERT INTO BOARD  (NUM, WRITER, SUBJECT, CONTENT,  EMAIL, PW, REF, RE_STEP, RE_INDENT, IP) 
            VALUES ((SELECT NVL(MAX(NUM),0)+1 FROM BOARD), '홍길동', '활빈당아 일어나라!', '일어나 일어나 활빈당 꼬르륵 꼬르륵 속빈당\n 집에서 나가면 텅빈당 뇌물을 안받는 청빈당', null,
                    '1', ((SELECT NVL(MAX(NUM),0)+1 FROM BOARD)), 0, 0, '192.168.10.30');
INSERT INTO BOARD  (NUM, WRITER, SUBJECT, CONTENT,  EMAIL, PW, REF, RE_STEP, RE_INDENT, IP) 
            VALUES ((SELECT NVL(MAX(NUM),0)+1 FROM BOARD), '홍길동', '글제목2', '일어나 일어나 활빈당 꼬르륵 꼬르륵 속빈당\n 집에서 나가면 텅빈당 뇌물을 안받는 청빈당', null,
                    '1', ((SELECT NVL(MAX(NUM),0)+1 FROM BOARD)), 0, 0, '192.168.10.30');
INSERT INTO BOARD  (NUM, WRITER, SUBJECT, CONTENT,  EMAIL, PW, REF, RE_STEP, RE_INDENT, IP) 
            VALUES ((SELECT NVL(MAX(NUM),0)+1 FROM BOARD), '홍길동', '글제목3', '일어나 일어나 활빈당 꼬르륵 꼬르륵 속빈당\n 집에서 나가면 텅빈당 뇌물을 안받는 청빈당', null,
                    '1', ((SELECT NVL(MAX(NUM),0)+1 FROM BOARD)), 0, 0, '192.168.10.30');                    


--4 글 번호로 글 (DTO 가져오기)

SELECT * FROM BOARD WHERE NUM = 1;



--5 조회수 올리기 

UPDATE BOARD SET READCOUNT = READCOUNT+1 WHERE NUM = 1;

--6 글 수정

UPDATE BOARD SET SUBJECT = '수정된 제목1',
                CONTENT = '수정된 본문\n 와우 ',
                EMAIL = 'HONG@hong.com',
                PW = '1',
                IP = '155.155.155.7'
             WHERE NUM = 1;

--7 글 삭제 (비밀번호를 넣어야지만 삭제)

ROLLBACK;

DELETE FROM BOARD WHERE NUM =1 AND PW = '1';

-- 조회수 조작

UPDATE BOARD SET READCOUNT = 12 WHERE NUM = 3;





















































