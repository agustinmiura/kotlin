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
/*
https://leetcode.com/problems/department-highest-salary/submissions/
*/
SELECT
    DISTINCT

    d1.Name as Department,
    e2.Name as Employee,
    sub.Salary as Salary

    FROM
    Department d1
    JOIN
        (
            SELECT
                e.DepartmentId as DepartmentId,
                MAX(e.Salary) as Salary
            FROM Employee e
            GROUP BY e.DepartmentId
        ) sub
        ON d1.Id = sub.DepartmentId
    JOIN
        Employee e2
        ON e2.Salary = sub.Salary
        AND e2.DepartmentId = sub.DepartmentId
