/*
https://platform.stratascratch.com/coding/9891-customer-details?python=
*/
select
c.first_name as first_name,
c.last_name as last_name,
c.city as city,
o.order_details as details
from customers c left join orders o
ON c.id = o.cust_id