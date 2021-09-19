#https://leetcode.com/problems/customer-order-frequency/
SELECT
        c.customer_id as customer_id,
        c.name as name
    FROM Orders o
        JOIN Customers c
            on c.customer_id = o.customer_id
        JOIN Product p
            on p.product_id = o.product_id
    WHERE YEAR(o.order_date) = 2020
    GROUP BY c.customer_id, name
    HAVING (
        SUM(
            case when
                MONTH(o.order_date)=6
                then
                    (p.price*o.quantity)
                else
                    0
            end
        )>=100
        AND
        SUM(
            case when
                MONTH(o.order_date)=7
                then
                    (p.price*o.quantity)
                else
                    0
            end
        )>=100
    )
/*
With subqueries
*/
SELECT
    c.customer_id,
    c.name
FROM Customers c
JOIN
    (
    SELECT
    o.customer_id as customer_id,
    SUM(p.price*o.quantity) as total_spent
    FROM Orders o
    JOIN Product p
        ON  o.product_id = p.product_id
        AND YEAR(o.order_date) = 2020
        AND (MONTH(o.order_date) = 6)
    GROUP BY o.customer_id
    ) sub_june
ON c.customer_id = sub_june.customer_id
AND sub_june.total_spent >= 100
JOIN (
    SELECT
    o.customer_id as customer_id,
    SUM(p.price*o.quantity) as total_spent
    FROM Orders o
    JOIN Product p
        ON  o.product_id = p.product_id
        AND YEAR(o.order_date) = 2020
        AND (MONTH(o.order_date) = 7)
    GROUP BY o.customer_id
) sub_july
ON c.customer_id = sub_july.customer_id
AND sub_july.total_spent >= 100
