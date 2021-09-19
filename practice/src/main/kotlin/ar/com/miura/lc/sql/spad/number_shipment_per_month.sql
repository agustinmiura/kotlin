/*
https://platform.stratascratch.com/coding/2056-number-of-shipments-per-month?python=
*/
select
to_char(shipment_date, 'YYYY-MM') as year_month,
count(*) as count
from amazon_shipment ashipment
group by 1