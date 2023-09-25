REM   Script: Activity8
REM   FST Sql

select * From orders;

select customer_id, max(purchase_amount) from orders  
group by customer_id;

select salesman_id, max(purchase_amount) from orders   
where order_date='17-AUG-12' 
group by salesman_id;

select order_date, customer_id,  max(purchase_amount) from orders    
group by customer_id, order_date   
having max(purchase_amount) in (2030, 3450, 5760, 6000);

