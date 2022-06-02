-- 테이블 DROP과 CREATE
DROP TABLE BOARD;
SELECT * FROM board;

CREATE TABLE BOARD (
    NUM        NUMBER(5,0)    PRIMARY KEY, -- 글번호
    WRITER     VARCHAR(30)    NOT NULL, -- 글쓴이
    SUBJECT    VARCHAR(100)   NOT NULL, -- 글제목
    CONTENT    VARCHAR(4000)  NOT NULL, -- 본문
    EMAIL      VARCHAR(30),             -- 작성자 이메일
    READCOUNT  NUMBER(7,0)    DEFAULT 0,-- 조회수
    PW         VARCHAR(30)    NOT NULL, -- 삭제할 때 물어볼 비밀번호
    REF        NUMBER(5,0)    NOT NULL, -- 글 그룹(원글일 경우, 글번호로 / 답변글일 경우 원글의 글번호로 출력)
    RE_STEP    NUMBER(5,0)    NOT NULL, -- 그룹 내의 출력 순서 (원글은 무조건 0)
    RE_INDENT  NUMBER(5,0)    NOT NULL, -- 글 LIST 출력시 들여쓰기 정도 (원글은 무조건 0)
    IP         VARCHAR2(20)   NOT NULL, -- 글 작성 시의 ip 주소
    RDATE      DATE           DEFAULT SYSDATE -- 글 쓴 시점(날짜+시간)
    );

--





























