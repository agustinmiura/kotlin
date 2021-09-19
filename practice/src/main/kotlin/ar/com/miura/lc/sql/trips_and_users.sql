/*
https://leetcode.com/problems/trips-and-users/submissions/
*/
SELECT
    DISTINCT
        t.Request_at as "Day",
        ROUND((
            CASE
                WHEN sub_partial.qty IS NULL THEN 0
                ELSE sub_partial.qty
            END
        )/(
            sub_total.qty
        ),2) as "Cancellation Rate"
FROM Trips t
JOIN
    (
        SELECT
            t.Request_at,
            COUNT(t.id) as qty
            FROM
            Trips t
                JOIN Users d
                    ON t.Driver_id = d.Users_Id
                JOIN Users c
                    ON t.Client_id = c.Users_Id
                AND
                    d.Banned = 'No'
                AND
                    c.Banned = 'No'
                AND
                    t.Request_at BETWEEN '2013-10-01' AND '2013-10-03'
        GROUP BY t.Request_at
        ORDER BY 1
    ) sub_total
ON t.Request_at = sub_total.Request_at
LEFT JOIN
    (
        SELECT
            t.Request_at,
            COUNT(t.id) as qty
            FROM
            Trips t
                LEFT JOIN Users d
                    ON t.Driver_id = d.Users_Id
                JOIN Users c
                    ON t.Client_id = c.Users_Id
                AND
                    d.Banned = 'No'
                AND
                    c.Banned = 'No'
                AND
                    t.Request_at BETWEEN '2013-10-01' AND '2013-10-03'
                AND
                    t.Status != 'completed'
        GROUP BY t.Request_at
        ORDER BY 1
    ) sub_partial
ON t.Request_at = sub_partial.Request_at

