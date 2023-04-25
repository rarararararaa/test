--메모장(보관 , 백업용)
CREATE table test2(
	num NUMBER PRIMARY KEY,
	title VARCHAR2(30) NOT NULL,
	name VARCHAR2(30) NOT NULL,
	memo VARCHAR2(4000) NOT NULL,
	email VARCHAR2(30),
	reg_date DATE NOT NULL
);
CREATE SEQUENCE test2_seq;
