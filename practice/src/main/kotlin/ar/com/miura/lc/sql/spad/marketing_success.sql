/*
https://platform.stratascratch.com/coding/514-marketing-campaign-success-advanced?python=
*/
select
    DISTINCT(mc2.user_id)
from marketing_campaign mc1
JOIN marketing_campaign mc2
    ON
        mc1.user_id = mc2.user_id
    AND
        mc1.created_at != mc2.created_at
    AND
        date_part('day', mc2.created_at::timestamp - mc1.created_at::timestamp) >= 2
ORDER BY 1