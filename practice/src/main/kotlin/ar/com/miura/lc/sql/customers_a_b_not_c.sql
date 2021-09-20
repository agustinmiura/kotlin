/*
https://leetcode.com/problems/customers-who-bought-products-a-and-b-but-not-c/submissions/
*/
SELECT
    DISTINCT c1.customer_id as CUSTOMER_ID,c1.customer_name as CUSTOMER_NAME
    FROM Customers c1
    JOIN
    (
        SELECT
            c.customer_id
        FROM Customers c
        JOIN Orders o ON c.customer_id = o.customer_id
        AND o.product_name IN ('A')
    ) sub_a
    ON c1.customer_id = sub_a.customer_id
    JOIN
    (
        SELECT
            c.customer_id
        FROM Customers c
        JOIN Orders o ON c.customer_id = o.customer_id
        AND o.product_name IN ('B')
    ) sub_b
    ON c1.customer_id = sub_b.customer_id
    AND c1.customer_id NOT IN (
        SELECT o.customer_id FROM Orders o WHERE o.product_name = 'C'
    )
ORDER BY c1.customer_id ASC