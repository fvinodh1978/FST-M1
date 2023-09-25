REM   Script: Activity10
REM   FST Sql

select * from customers;

select * from orders;

select * from salesman;

select * From orders  
where salesman_id in (select salesman_id from salesman where customer_id = 3007);

select * From orders  
where salesman_id in (select salesman_id from salesman where salesman_city = 'New York');

select grade, count(*) From customers 
where grade > (select avg(grade) from customers where city='New York') 
group by grade;

select * From orders  
where salesman_id in (select salesman_id from salesman where commission in (select max(commission) from salesman));

