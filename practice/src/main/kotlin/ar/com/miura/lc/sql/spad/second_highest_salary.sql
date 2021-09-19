/*
https://platform.stratascratch.com/coding/9892-second-highest-salary?python=
*/
SELECT MIN(data_salary.salary)
FROM
(
    select distinct(salary) as salary
    from employee e
    ORDER BY e.salary desc
    limit 2
) as data_salary