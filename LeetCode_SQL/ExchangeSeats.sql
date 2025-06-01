SELECT 
    id,
    CASE
      WHEN id % 2 = 1 AND id + 1 <= (SELECT MAX(id) FROM seat)
        THEN (SELECT student FROM seat WHERE id = s.id + 1)
      WHEN id % 2 = 0 
        THEN (SELECT student FROM seat WHERE id = s.id - 1)
      ELSE
        student
    END AS student
FROM
    Seat s
ORDER BY
    id;

    
-- Alernative solution
SELECT 
    s1.id, 
    s2.student
FROM 
    seat s1
JOIN 
    seat s2
ON 
    s1.id % 2 = 1 AND s2.id = s1.id + 1

UNION

SELECT 
    s1.id, 
    s2.student
FROM 
    seat s1
JOIN 
    seat s2
ON 
    s1.id % 2 = 0 AND s2.id = s1.id - 1

UNION

SELECT 
    s1.id, 
    s1.student
FROM 
    seat s1
WHERE 
    s1.id % 2 = 1 
    AND s1.id = (SELECT MAX(id) FROM seat)

ORDER BY id;