/*
https://platform.stratascratch.com/coding/10090-find-the-percentage-of-shipable-orders?python=
*/
SELECT
(COUNT(c.address)/COUNT(*)::float)*100 as percent_shipable
FROM
    orders o
LEFT JOIN
    customers c
ON o.cust_id = c.id