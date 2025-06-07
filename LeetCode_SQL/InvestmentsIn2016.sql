SELECT
    ROUND(SUM(tiv_2016), 2) AS tiv_2016
FROM (
    SELECT 
        *,
        COUNT(*) OVER (PARTITION BY tiv_2015) AS count_2015,
        COUNT(*) OVER (PARTITION BY lat, lon) AS location
    FROM
        Insurance
) t
WHERE
    count_2015 > 1 AND location = 1;