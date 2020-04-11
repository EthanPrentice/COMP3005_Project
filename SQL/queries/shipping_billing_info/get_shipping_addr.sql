SELECT
    address.*
FROM
    address,
    NATURAL JOIN shipping_addr
WHERE
    shipping_addr.shipping_info_id = ?