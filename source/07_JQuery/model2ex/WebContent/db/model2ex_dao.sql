--for Model2
DROP TABLE MEMBER;
CREATE TABLE MEMBER(
        MID      VARCHAR2(50) PRIMARY KEY,
        MPW      VARCHAR2(50) NOT NULL,
        MNAME    VARCHAR2(50) NOT NULL,
        MEMAIL   VARCHAR2(50) UNIQUE NOT NULL,
        MPHOTO   VARCHAR2(500),
        MBIRTH   DATE NOT NULL,
        MADDRESS VARCHAR2(500) NOT NULL,
        MRDATE   DATE DEFAULT SYSDATE
        );
 commit; 
 SELECT  * FROM member;
-- 로그인

SELECT * FROM member WHERE MID='aaa' AND MPW='111';

-- 회원가입
INSERT INTO member (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS, MRDATE)
       VALUES ('fff', '111', '금길동', 'hong5@hong.com', null, '1945/12/05', '서울시 은평구', SYSDATE);
       INSERT INTO member (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS, MRDATE)
       VALUES ('aaa', '111', '고길동', 'hong001@hong.com', null, '1946/12/05', '서울시 강남구', SYSDATE);
       INSERT INTO member (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS, MRDATE)
       VALUES ('bbb', '111', '저길동', 'hong005@hong.com', null, '1947/12/01', '서울시 중랑구', SYSDATE);
       INSERT INTO member (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS, MRDATE)
       VALUES ('ccc', '111', '하길동', 'hong004@hong.com', null, '1948/12/02', '서울시 마포구', SYSDATE);
       INSERT INTO member (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS, MRDATE)
       VALUES ('ddd', '111', '춘길동', 'hong003@hong.com', null, '1949/12/02', '서울시 강서구', SYSDATE);
       INSERT INTO member (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS, MRDATE)
       VALUES ('eee', '111', '추길동', 'hong002@hong.com', null, '1955/12/05', '서울시 강동구', SYSDATE);
       INSERT INTO member (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS, MRDATE)
       VALUES ('aaaa', '111', '아길동', 'hong002a@hong.com', null, '1951/11/02', '서울시 강북구', SYSDATE);

-- 회원가입 아이디 중복체크
SELECT * FROM member WHERE MID='aaa';

-- 회원가입 아이디 중복체크
SELECT * FROM member WHERE MEMAIL='hong002@hong.com'; 

-- 회원 수 세보기

SELECT COUNT(*) CNT FROM member;

-- 회원목록 전체보기 (페이징 3 블록사이즈 5)
SELECT * FROM 
        (SELECT ROWNUM RN, A.* FROM 
        (SELECT * FROM member ORDER BY MRDATE DESC)A )
         WHERE RN BETWEEN 1 AND 7;


-- 회원정보 상세보기 (MID로 DTO 불러오기)
SELECT * FROM member WHERE MID='aaa'; 

-- 회원정보 수정하기
UPDATE member SET MNAME  = '신길동',
                     MPW    = '111',
                     MEMAIL = 'hong111@hong.com',
                     MPHOTO = NULL,
                     MBIRTH = '1990-07-08',
                     MADDRESS = '서울시 중랑구'
                     WHERE MID = 'aaa';
                     
-- 회원정보 삭제하기 
DELETE MEMBER WHERE MID = 'aaaa';
                     
SELECT * FROM member order by mrdate desc;     

-----------------------------------------------------------------------------------------
--freeBoard TABLE 
-----------------------------------------------------------------------------------------
DROP TABLE FILEBOARD;
DROP SEQUENCE FILEBOARD_SEQ;
CREATE SEQUENCE FILEBOARD_SEQ MAXVALUE 999999 NOCACHE NOCYCLE;
CREATE TABLE FILEBOARD(
    fId         NUMBER(9) PRIMARY KEY,
    mId         VARCHAR2(30) REFERENCES MEMBER(MID),
    fTitle      VARCHAR2(100) NOT NULL,
    fContent    VARCHAR2(2000),
    fFileName   VARCHAR2(100),
    fRdate      DATE DEFAULT SYSDATE,
    fHit         NUMBER(7) DEFAULT 0,
    fGroup      NUMBER(7) NOT NULL,
    fStep       NUMBER(3) NOT NULL,
    fIndent     NUMBER(3) NOT NULL,
    fIp         VARCHAR2(30) NOT NULL);

-- 1. 글 출력 (int startRow, int endRow)
SELECT F.*, MNAME FROM fileboard F, MEMBER M WHERE F.MID = M.MID
                  ORDER BY FGROUP DESC, FSTEP;
SELECT * FROM
    (SELECT ROWNUM RN, A.* FROM
    (SELECT F.*, MNAME FROM fileboard F, MEMBER M WHERE F.MID = M.MID
                       ORDER BY FGROUP DESC, FSTEP)A )
     WHERE RN BETWEEN 1 AND 50;                  
                  
-- 2. 글 갯수 세기

SELECT COUNT(*)CNT FROM FILEBOARD;

-- 3. 글 작성하기. (원글)
INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, fFILENAME,  
        FGROUP, FSTEP, FINDENT, FIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'aaa','title220623','content',null, 
        FILEBOARD_SEQ.CURRVAL, 0, 0, '192.168.10.151');
        
        commit;
        
-- 4. 조회수 올리기      
UPDATE FILEBOARD SET FHIT = FHIT +1 WHERE FID=1;

-- 5. bId로 글 dto보기 (글쓴이 이름 추가)
SELECT F.*, MNAME FROM FILEBOARD F, MEMBER M WHERE M.MID=F.MID AND FID=1;

-- 6. 글 수정 (fid, ftitle, FContent, FILENAME,  FIp, FDATE)
UPDATE FILEBOARD SET FTITLE = '바뀐제목22',
                    FCONTENT = '바뀐 본문',
                    fFILENAME = NULL,
                    FIP = '192.168.151.10', 
                    FRDATE = SYSDATE
                WHERE FID = 2;
-- (7) 글 삭제하기(bId로 삭제하기)
COMMIT;
DELETE FROM FILEBOARD WHERE FID=3;
ROLLBACK;

--  (8) 답변글 추가전 STEP a 수행
UPDATE FILEBOARD SET FSTEP = FSTEP+1 
    WHERE FGROUP = 1 AND FSTEP>0;
-- (9) 답변글 쓰기
INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, fFILENAME,
        FGROUP, FSTEP, FINDENT, FIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'aaa','reply','content', null,
        30, 1, 1, '192.168.10.151');














-----------------------------------------------------------------------------------------
--ADMIN TABLE 
-----------------------------------------------------------------------------------------
DROP TABLE ADMIN CASCADE CONSTRAINTS;
CREATE TABLE ADMIN(
    aid VARCHAR2(30)    PRIMARY KEY,
    apw VARCHAR2(30)    NOT NULL,
    aname VARCHAR2(30)  NOT NULL);

insert into admin (aid, apw, aname) VALUES ('admin', '111', '관리자');
-- (1) admin loginCheck
SELECT * FROM ADMIN WHERE AID='admin' AND APW='111';
-- (2) 로그인 후 세션에 넣을 용도 : admin aid로 dto 가져오기
SELECT * FROM ADMIN WHERE AID='admin';






















