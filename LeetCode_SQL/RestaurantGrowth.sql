SELECT
  v1.visited_on,
  SUM(v2.amount) AS amount,
  ROUND(SUM(v2.amount) / 7, 2) AS average_amount
FROM
  (SELECT DISTINCT visited_on FROM Customer) v1
JOIN
  Customer v2
ON
  v2.visited_on BETWEEN DATE_SUB(v1.visited_on, INTERVAL 6 DAY) AND v1.visited_on
GROUP BY
  v1.visited_on
HAVING 
    COUNT(DISTINCT v2.visited_on) = 7
ORDER BY
  v1.visited_on;