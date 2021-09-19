/*
https://platform.stratascratch.com/coding/9915-highest-cost-orders?python=
*/
SELECT
    order_data.first_name,
    order_data.cost as total_order_cost,
    order_data.order_date as order_date
FROM
    (
        SELECT
            o.cust_id as cust_id,
            c.first_name,
            o.order_date as order_date,
            SUM(o.total_order_cost) as cost
        FROM orders o
        JOIN customers c
            ON o.cust_id = c.id
        AND order_date
            BETWEEN ('2019-02-01'::timestamp) AND ('2019-05-01'::timestamp)
        GROUP BY
            o.cust_id,
            c.first_name,
            o.order_date
        ORDER BY 4 DESC
    ) as order_data
LIMIT 1



