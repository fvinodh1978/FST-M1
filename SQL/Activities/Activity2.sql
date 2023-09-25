REM   Script: Activity2
REM   Create Table

CREATE TABLE salesman (  
    salesman_id int,  
    salesman_name varchar2(32),  
    salesman_city varchar2(32),  
    commission int  
);

describe salesman


INSERT INTO salesman VALUES(5002, 'Nail Knite', 'Paris', 13);

INSERT ALL   
    INTO salesman VALUES(5001, 'James Hoog', 'New York', 15)   
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11)   
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14)   
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13)   
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12)   
SELECT 1 FROM DUAL;

SELECT salesman_id, salesman_city FROM salesman;

select * From salesman;

select salesman_id, commission from salesman where salesman_name='Paul Adam';

select * From salesman where salesman_city='Paris';

