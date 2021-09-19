/*
https://platform.stratascratch.com/coding/9899-percentage-of-total-spend?python=
*/
SELECT
    c1.first_name as first_name,
    o1.order_details as order_details,
    (o1.total_order_cost/order_data.total_cost) percentage_total_cost
FROM customers c1
JOIN orders o1
    ON c1.id = o1.cust_id
JOIN
    (
       SELECT
            o.cust_id as cust_id,
            SUM(o.total_order_cost) as total_cost
        FROM orders o
        GROUP BY o.cust_id
    ) order_data
    ON o1.cust_id = order_data.cust_id
ORDER BY 1
