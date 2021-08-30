# Write your MySQL query statement below
# https://leetcode.com/problems/employees-earning-more-than-their-managers/submissions/
SELECT e.name as Employee FROM Employee e
JOIN Employee e2 ON e.ManagerId = e2.ID
WHERE
   e.salary > e2.salary