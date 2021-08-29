# Write your MySQL query statement below
SELECT (
    SELECT DISTINCT e.Salary as SecondHighestSalary FROM Employee e ORDER BY salary desc LIMIT 1,1
) as SecondHighestSalary;
