CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
	  SELECT DISTINCT E1.Salary
	  FROM Employee E1
	  LEFT JOIN (SELECT DISTINCT Salary FROM Employee) E2
	  ON E2.Salary > E1.Salary
	  GROUP BY E1.Id, E1.Salary
	  HAVING COUNT(E2.Salary) = N - 1
  );
END