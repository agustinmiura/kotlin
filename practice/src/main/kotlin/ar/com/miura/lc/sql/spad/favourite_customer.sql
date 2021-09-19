/*
https://platform.stratascratch.com/coding/9910-favorite-customer?python=
*/
SELECT
    c1.first_name as name,
    c1.city,
    acum.order_qty as order_count,
    acum.order_cost as total_cost
FROM
    customers c1
JOIN
    (
        SELECT
        c.id as customer_id,
        COUNT(*) as order_qty,
        SUM(o.total_order_cost) as order_cost
        FROM customers c
        JOIN orders o
        ON c.id = o.cust_id
        GROUP BY 1
        HAVING (count(*)>3)
        order by 3 DESC
    ) acum
ON c1.id = acum.customer_id
ORDER BY 4 desc