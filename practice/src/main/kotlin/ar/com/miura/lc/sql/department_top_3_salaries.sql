#Mysql
#https://leetcode.com/explore/interview/card/facebook/58/sql/317/
SELECT
    dep.Name as Department,
    emp.Name as Employee,
    emp.Salary as Salary
FROM Employee emp
JOIN Department dep ON emp.DepartmentId = dep.id
AND (
 (
    SELECT COUNT(distinct(emp2.Salary))
        FROM Employee emp2
        WHERE emp2.DepartmentId = dep.id
        AND (emp2.Salary>emp.Salary)
 )<3
)