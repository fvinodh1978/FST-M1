REM   Script: Activity9
REM   FST Sql

create table customers ( 
    customer_id int primary key, customer_name varchar(32), 
    city varchar(20), grade int, salesman_id int);

INSERT ALL 
    INTO customers VALUES (3002, 'Nick Rimando', 'New York', 100, 5001) 
    INTO customers VALUES (3007, 'Brad Davis', 'New York', 200, 5001) 
    INTO customers VALUES (3005, 'Graham Zusi', 'California', 200, 5002) 
    INTO customers VALUES (3008, 'Julian Green', 'London', 300, 5002) 
    INTO customers VALUES (3004, 'Fabian Johnson', 'Paris', 300, 5006) 
    INTO customers VALUES (3009, 'Geoff Cameron', 'Berlin', 100, 5003) 
    INTO customers VALUES (3003, 'Jozy Altidor', 'Moscow', 200, 5007) 
    INTO customers VALUES (3001, 'Brad Guzan', 'London', 300, 5005) 
SELECT 1 FROM DUAL;

select * from customers order by customers_id;

select * from salesman order by salesman_id;

select * from orders order by order_no;

select salesman_name, customer_name from salesman, customers 
where salesman.salesman_id=customers.salesman_id 
order by salesman_name;

select grade, customer_name, salesman_name from salesman, customers 
where salesman.salesman_id=customers.salesman_id 
and grade<300 
order by grade asc;

select commission, customer_name, salesman_name from salesman, customers 
where salesman.salesman_id=customers.salesman_id 
and salesman.commission>12 
order by commission asc;

select order_no, order_date, purchase_amount, customer_name, salesman_name, commission  
from salesman, customers, orders 
where salesman.salesman_id=orders.salesman_id 
and orders.customer_id = customers.customer_id 
order by order_no;

