/*
https://platform.stratascratch.com/coding/10089-find-the-number-of-customers-without-an-order?python=
*/
SELECT
COUNT(c.id)
FROM
customers c
WHERE c.id NOT IN (
    SELECT o.cust_id FROM orders o
)