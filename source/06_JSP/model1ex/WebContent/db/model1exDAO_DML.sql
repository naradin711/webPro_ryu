-- for DAO 
-- 고객(CUSTOMER)테이블 DAO
	--1. 회원가입시 CID 중복체크
	SELECT * FROM CUSTOMER WHERE CID='aaa';
    
	--2. 회원가입
    INSERT INTO CUSTOMER (CID,  CPW, CNAME, CTEL, CEMAIL, CADDRESS, CGENDER, CBIRTH, CRDATE)
         VALUES('seojisoo', '111', '서지수', '010-2222-2222', 'lovelyz3@lovelyz.com', '인천광역시 연수구 연수동', 'f', '1994-02-11', SYSDATE );
     INSERT INTO CUSTOMER (CID,  CPW, CNAME, CTEL, CEMAIL, CADDRESS, CGENDER, CBIRTH, CRDATE)
         VALUES('iloveryu', '111', '류수정', '010-1997-1119', 'lovelyz8@lovelyz.com', '대전광역시 대덕구 성심동', 'f', '1997-11-19', SYSDATE );     
                  
	--3. 로그인(CID/PW)
    SELECT * FROM CUSTOMER WHERE CID='seojisoo' and CPW = '111';
    
	--4. CID로 DTO가져오기
    SELECT * FROM CUSTOMER WHERE CID='aaa';
    
	--5. 회원정보수정
    UPDATE CUSTOMER SET 
                    CPW = '111',
                    CTEL = '011-2222-2222',
                    CEMAIL = 'hong@hong.com',
                    CADDRESS = '부산',
                    CGENDER = 'm',
                    CBIRTH = '1998-08-17'
                    WHERE CID='aaa';
    
	--6. 회원리스트 출력하기 (첫화면에서 쓰임) TOP-N구문으로 출력 추후 페이징
    SELECT * FROM (SELECT ROWNUM RN, CID, CPW, CNAME, CEMAIL, CADDRESS 
             FROM (SELECT * FROM CUSTOMER ORDER BY customer.crdate DESC) A)
             WHERE RN BETWEEN 1 AND 5;
    
	--7. 등록된 회원수
	SELECT COUNT(*) CNT FROM CUSTOMER;


-- 도서(BOOK)테이블 DAO

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
    WHERE RN BETWEEN 5 AND 12;

-- 등록된 책 갯수
SELECT COUNT(*) CNT FROM BOOK;

-- 책 상세보기 (BID로 DTO가져오기)

SELECT * FROM BOOK WHERE BID=5;


-- 게시판(FileBoard)테이블 DAO

    -- 1. 글 목록 (STARTROW-ENDROW)
    SELECT F.*, CNAME, CEMAIL FROM FILEBOARD F, CUSTOMER C 
                              WHERE F.CID = C.CID 
                              ORDER BY FREF DESC, FRESTEP;
    
    SELECT * FROM (SELECT ROWNUM RN, A.*
             FROM (SELECT F.*, CNAME, CEMAIL FROM FILEBOARD F, CUSTOMER C 
                   WHERE F.CID = C.CID 
                   ORDER BY FREF DESC, FRESTEP) A )
             WHERE RN BETWEEN 2 AND 6;
             
    -- 2. 등록된 글 수
    SELECT COUNT(*) CNT FROM FILEBOARD;
    
    -- 3. 원글쓰기
    INSERT INTO FILEBOARD (FNUM, CID, FSUBJECT, FCONTENT, FFILENAME, FPW, FREF, FRESTEP, FRELEVEL, FIP)
           VALUES (FILEBOARD_SEQ.NEXTVAL, 'ccc', '상하이상하이', '트위스트 추면서', NULL, '111', FILEBOARD_SEQ.CURRVAL, 0, 0, '192.168.20.44');
    
    -- 4. 답글쓰기전 STEP A -- 5번 가기전 작업
    UPDATE FILEBOARD SET FRESTEP = FRESTEP+1 WHERE fREF=5 AND FRESTEP>0;
    
    -- 5. 답변 글 작성하기
    INSERT INTO FILEBOARD (FNUM, CID, FSUBJECT, FCONTENT, FFILENAME, FPW, FREF, FRESTEP, FRELEVEL, FIP) 
           VALUES (FILEBOARD_SEQ.NEXTVAL, 'bbb', '답5-1', '답글 답글', NULL, '111', 5, 1, 1, '192.168.20.44');
    
         
    -- 6. 글 상세보기 (FNUM으로 DTO가져오기)
    SELECT * FROM FILEBOARD WHERE FNUM = 1;
    -- 7. 글 수정하기
    UPDATE FILEBOARD SET FSUBJECT = '수정된 제목',
                         FCONTENT = '수정된 본문',
                         FFILENAME = NULL,
                         FPW = '111',
                         FIP = '155.155.15.7'
                     WHERE FNUM =3;
    
    -- 8. 글 삭제하기
    DELETE FROM FILEBOARD WHERE FNUM = 1 AND FPW = '111';
    
    -- 9. 조회수 올리기
    UPDATE fileboard SET fhit = FHIT+1 WHERE FNUM = 2;
    
    COMMIT;
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    