# Write your MySQL query statement below
UPDATE Salary s SET s.sex = CASE sex
    WHEN 'm' THEN 'f'
    ELSE 'm'
END;