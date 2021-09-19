/*
https://platform.stratascratch.com/coding/9908-customer-orders-and-details?python=
*/
SELECT
c.city as city,
COUNT(DISTINCT o.id) as orders_per_city,
COUNT(DISTINCT c.id) as customers_per_city,
SUM(o.total_order_cost) as orders_cost_per_city
FROM customers c
LEFT JOIN orders o
ON c.id = o.cust_id
GROUP BY 1
HAVING(COUNT(o.id)>=5)