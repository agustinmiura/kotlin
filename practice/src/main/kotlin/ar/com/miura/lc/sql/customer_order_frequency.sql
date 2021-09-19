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
