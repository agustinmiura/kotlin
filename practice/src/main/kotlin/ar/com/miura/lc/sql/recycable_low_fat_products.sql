# Write your MySQL query statement below
#https://leetcode.com/problems/recyclable-and-low-fat-products/
SELECT p.product_id as product_id FROM Products p
WHERE (p.low_fats = 'Y' and p.recyclable = 'Y')