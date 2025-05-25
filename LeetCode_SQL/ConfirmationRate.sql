SELECT
    s.user_id,
    IFNULL(ROUND(AVG(c.action = "confirmed"), 2), 0) as confirmation_rate
    -- ROUND(COALESCE(AVG(c.action = "confirmed"), 0), 2) as confirmation_rate
FROM
    Signups s
LEFT JOIN 
    Confirmations c
ON
    s.user_id = c.user_id
GROUP BY
    s.user_id;