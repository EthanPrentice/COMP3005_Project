SELECT
    name.*
FROM
    name,
    NATURAL JOIN shipping_name
WHERE
    shipping_name.shipping_info_id = ?