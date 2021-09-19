/*
https://platform.stratascratch.com/coding/2058-total-shipment-weight?python=
*/
SELECT
s2.shipment_id,
s2.sub_id,
s2.weight,
s2.shipment_date,
weight.total as total_weight
FROM amazon_shipment s2
JOIN
    (
    select s.shipment_id as id,
    SUM(s.weight) as total
    from amazon_shipment s
    GROUP BY s.shipment_id
    ) weight
ON s2.shipment_id = weight.id