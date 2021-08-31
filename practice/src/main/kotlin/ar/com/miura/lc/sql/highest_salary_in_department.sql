#https://leetcode.com/problems/department-highest-salary/submissions/
SELECT
    d.Name as Department,
    e.Name as Employee,
    e.Salary as Salary
    FROM Employee e
        JOIN Department d
            ON e.DepartmentId = d.Id
    WHERE (e.DepartmentId, e.Salary) in
        (SELECT
            e.DepartmentId,
            max(e.Salary)
            FROM Employee e
            JOIN Department d
                ON e.DepartmentId = d.Id
        GROUP BY e.DepartmentId)
