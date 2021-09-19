/*
https://platform.stratascratch.com/coding/2057-weight-for-first-shipment?python=
*/
SELECT
s2.shipment_id,
s2.weight
FROM amazon_shipment s2
JOIN (
    select
    shipment_id as shipment_id,
    min(shipment_date) as shipment_date
    FROM
        amazon_shipment
    GROUP BY 1
) shipment
ON
(s2.shipment_id = shipment.shipment_id
    AND s2.shipment_date = shipment.shipment_date)