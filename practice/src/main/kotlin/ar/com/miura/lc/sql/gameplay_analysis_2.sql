# Write your MySQL query statement below
SELECT
    a.player_id player_id,
    a.device_id device_id
FROM Activity a
WHERE (player_id, event_date) in (
    select
        player_id as player_id,
        min(event_date)
    from activity
    group by player_id
)
