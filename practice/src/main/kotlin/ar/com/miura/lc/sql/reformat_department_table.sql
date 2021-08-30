# Write your MySQL query statement below
#https://leetcode.com/problems/reformat-department-table/submissions/
SELECT
    d.id as id,
    MIN(CASE WHEN month = 'Jan' THEN revenue END) as Jan_Revenue,
    MIN(CASE WHEN month = 'Feb' THEN revenue END) as Feb_Revenue,
    MIN(CASE WHEN month = 'Mar' THEN revenue END) as Mar_Revenue,
    MIN(CASE WHEN month = 'Apr' THEN revenue END) as Apr_Revenue,
    MIN(CASE WHEN month = 'May' THEN revenue END) as May_Revenue,
    MIN(CASE WHEN month = 'Jun' THEN revenue END) as Jun_Revenue,
    MIN(CASE WHEN month = 'Jul' THEN revenue END) as Jul_Revenue,
    MIN(CASE WHEN month = 'Aug' THEN revenue END) as Aug_Revenue,
    MIN(CASE WHEN month = 'Sep' THEN revenue END) as Sep_Revenue,
    MIN(CASE WHEN month = 'Oct' THEN revenue END) as Oct_Revenue,
    MIN(CASE WHEN month = 'Nov' THEN revenue END) as Nov_Revenue,
    MIN(CASE WHEN month = 'Dec' THEN revenue END) as Dec_Revenue

FROM Department d
GROUP BY d.id
