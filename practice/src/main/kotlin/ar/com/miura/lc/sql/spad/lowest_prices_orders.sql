/*
https://platform.stratascratch.com/coding/9912-lowest-priced-orders?python=
*/
SELECT
c1.id as cust_id,
c1.first_name as first_name,
order_data.order_cost as lowest_price_per_group
FROM
customers c1
JOIN
    (
        SELECT o.cust_id as cust_id,
        min(o.total_order_cost) as order_cost
        FROM orders o
        GROUP BY o.cust_id
    ) order_data
ON c1.id = order_data.cust_id
