SELECT
    c.id,
    c.first_name,
    SUM(o.total_order_cost) as total
FROM orders o JOIN customers c
ON o.cust_id = c.id
group by c.id, c.first_name
order by c.first_name