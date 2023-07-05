select version(), current_date, now()
  from dual;

-- 수학함수, 사칙 연산도 한다.
select sign(pi()/4), 1 + 2 * 3 - 4 / 5
  from dual;

-- 대소문자 구분이 없다.
seLect VERSION(), current_DATE
  froM DUAL;
  
-- table 생성: DDL
create table pet(
	name varchar(100),
    owner varchar(20),
    species varchar(20),
    gender char(1),
    birth date,
    death date
);

-- scheme 확인
describe pet;
desc pet;

-- table 삭제: DDL
drop table pet;
show tables; 

-- insert: DML(C)
insert
  into pet  
values ('성탄이', '안대혁', 'dog', 'm', '2008-12-15', null); 

-- select: DML(R)
select *
  from pet;

-- update: DML(U)
UPDATE pet
   SET name = 'sungtanee'
 WHERE name = '성탄이';

-- delete: DML(D)
delete
  from pet
 where name = 'sungtanee';
 
-- load data
load data local infile 'c:\pet.txt' into table pet;

update pet 
   set death = null
 where name != 'bowser';
 
-- select 연습
select name, species
  from pet
 where name = 'Bowser';

select name, species, birth
  from pet
 where birth >= '1998-01-01'; 
 
 select name, species, gender
	from pet
where species='dog'
	and gender='f';

select name, species
	from pet
where species='snake'
	or species='bird';

select name, birth
	from pet
order by birth asc;

select name, birth
	from pet
order by birth desc;

select name, birth, death
	from pet
where death is not null;

select name
	from pet
where name like 'b%';

select name
	from pet
where name like '%fy';

select name
	from pet
where name like '%w%';

select name
	from pet
where name like '_____';

select name
	from pet
where name like 'b_____';

select count(death)
	from pet;
    
