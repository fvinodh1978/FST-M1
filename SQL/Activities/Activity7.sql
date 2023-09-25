REM   Script: Activity7
REM   FST Sql

select * From orders;

select sum(purchase_amount) from orders;

select max(purchase_amount) from orders;

select min(purchase_amount) from orders;

select count(unique salesman_id) from orders;

