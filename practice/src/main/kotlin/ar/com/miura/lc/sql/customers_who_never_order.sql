# Write your MySQL query statement below
SELECT C.name as Customers FROM Customers C WHERE C.id NOT IN (
    SELECT o.CustomerId FROM Orders o
)