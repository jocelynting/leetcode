SELECT 
    DISTINCT product_id,
    10 AS price
FROM 
    products
GROUP BY
    product_id
HAVING
    min(change_date) > "2019-08-16"

UNION

SELECT 
    product_id, 
    new_price
FROM 
    Products 
WHERE 
    (product_id, change_date) in (
        SELECT 
            product_id, 
            max(change_date) as recent_date
        FROM 
            Products
        WHERE 
            change_date <= "2019-08-16"
        GROUP BY 
            product_id
    )


-- Alternative solution
WITH latest_prices AS (
  SELECT 
    product_id, 
    new_price,
    ROW_NUMBER() OVER (
       PARTITION BY product_id
       ORDER BY change_date DESC
    ) AS rn
  FROM Products
  WHERE change_date <= '2019-08-16'
),
all_products AS (
  SELECT DISTINCT product_id FROM Products
)

SELECT 
  p.product_id,
  COALESCE(lp.new_price, 10) AS price
FROM 
    all_products p
LEFT JOIN 
    latest_prices lp
ON 
    p.product_id = lp.product_id AND lp.rn = 1;