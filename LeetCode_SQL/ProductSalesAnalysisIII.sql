SELECT
   product_id,
   year AS first_year,
   quantity,
   price
FROM
    Sales
WHERE
    (product_id, year) IN (
        SELECT
            product_id,
            MIN(year)
        FROM
            Sales
        GROUP BY
            product_id 
    );

-- Alternative solution using JOIN
SELECT 
    s.product_id,
    y.first_year,
    s.quantity,
    s.price
FROM Sales s
JOIN (
    SELECT product_id, MIN(year) AS first_year
    FROM Sales
    GROUP BY product_id
) y
ON 
  s.product_id = y.product_id AND s.year = y.first_year;