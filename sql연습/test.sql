select version(), current_date, now()
	from dual;

-- 수학함수, 사칙 연산도 한다.
select sign(pi()/4), 1+2*3-4/5
	from dual;

-- 대소문자 구분이 없다
select VERSION(), current_DATE
	from DUAL;

-- table 생성 : ddl
create table pet(
	name varchar(100),
	owner varchar(20),
	species varchar(20),
	gender char(1),
	birth date,
	death date
);
