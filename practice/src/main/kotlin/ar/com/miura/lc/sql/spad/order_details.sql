/*
https://platform.stratascratch.com/coding/9913-order-details?python=
*/
SELECT
o.order_date,
o.order_details,
o.total_order_cost,
c.first_name
FROM customers c
JOIN orders o
ON c.id = o.cust_id
AND (c.first_name = 'Jill' OR c.first_name = 'Eva')