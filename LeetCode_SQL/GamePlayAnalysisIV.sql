SELECT 
    ROUND(
        COUNT(DISTINCT a.player_id) * 1.0 / (SELECT COUNT(DISTINCT player_id) FROM Activity), 
        2
    ) AS fraction
FROM 
    Activity a
WHERE
    (player_id, event_date) IN (
        SELECT 
            player_id, 
            DATE_ADD(MIN(event_date), INTERVAL 1 DAY) 
        FROM 
            Activity
        GROUP BY
            player_id
    );


-- Alternative solution using JOIN
SELECT 
    ROUND(
        COUNT(DISTINCT a.player_id) * 1.0 / (SELECT COUNT(DISTINCT player_id) FROM Activity), 
        2
    ) AS fraction
FROM 
    Activity a
JOIN 
    (
        SELECT player_id, MIN(event_date) AS first_login
        FROM Activity
        GROUP BY player_id
    ) b
ON 
    a.player_id = b.player_id 
    AND DATEDIFF(a.event_date, b.first_login) = 1
