/*
https://platform.stratascratch.com/coding/9607-the-most-expensive-products-per-category?python=
*/
SELECT
    data_table.cat as category,
    i1.product_name as product_name,
    data_table.price as modified_table
    FROM
        innerwear_amazon_com i1
        JOIN
            (
                SELECT
                    i.product_category as cat,
                    max(RIGHT(i.price,LENGTH(i.price)-1)::numeric) as price
                FROM innerwear_amazon_com i
                GROUP BY i.product_category
            ) as data_table
        ON i1.product_category = data_table.cat
        AND (RIGHT(i1.price,LENGTH(i1.price)-1)::numeric) = data_table.price

