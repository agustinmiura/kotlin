/*
https://platform.stratascratch.com/coding/10322-finding-user-purchases?python=
*/
select
DISTINCT(t1.user_id) as user_id
from amazon_transactions t1,
amazon_transactions t2
WHERE t1.user_id = t2.user_id
AND t1.id != t2.id
AND DATE_PART('day', t2.created_at::timestamp - t1.created_at::timestamp) < 7
AND DATE_PART('day', t2.created_at::timestamp - t1.created_at::timestamp) >= 0
ORDER BY 1