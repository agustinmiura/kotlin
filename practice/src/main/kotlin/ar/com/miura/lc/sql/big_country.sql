# Write your MySQL query statement below
SELECT w.name, w.population, w.area
FROM World w
WHERE ( (w.population>25000000) OR (area>3000000) )