CREATE TABLE score(
num NUMBER PRIMARY KEY,
name VARCHAR2(30) NOT NULL,
korean NUMBER(3) NOT NULL,
english NUMBER(3) NOT NULL,
math NUMBER(3) NOT NULL,
sum NUMBER(3) NOT NULL,
avg NUMBER(3) NOT NULL,
grade VARCHAR2(2) NOT NULL,
reg_date DATE NOT NULL
);

CREATE SEQUENCE score_seq;