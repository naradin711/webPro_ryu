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
         WHERE RN BETWEEN 1 AND 3;


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
                     
SELECT * FROM member order by mrdate desc;        