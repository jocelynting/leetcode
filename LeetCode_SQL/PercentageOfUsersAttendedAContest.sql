SELECT
    r.contest_id,
    ROUND(COUNT(DISTINCT r.user_id) * 100 / t.total_users, 2) AS percentage
FROM
    Register AS r
CROSS JOIN (
    SELECT COUNT(*) AS total_users
    FROM Users
) t
GROUP BY
    r.contest_id
ORDER BY 
    percentage DESC,
    r.contest_id ASC;