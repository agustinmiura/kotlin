# Write your MySQL query statement below
#https://leetcode.com/problems/delete-duplicate-emails/
DELETE p FROM
Person p JOIN Person p2
ON p.Email = p2.Email WHERE p.id>p2.id

