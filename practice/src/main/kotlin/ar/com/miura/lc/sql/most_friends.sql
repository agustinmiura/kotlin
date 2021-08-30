SELECT id,count(*) num FROM
(
    SELECT requester_id id FROM request_accepted
    UNION ALL
    SELECT accepter_id id FROM request_accepted
) data
group by id
order by count(*) desc limit 1