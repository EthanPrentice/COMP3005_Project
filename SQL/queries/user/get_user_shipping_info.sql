SELECT
    shipping_info.*
FROM
    shipping_info
    NATURAL JOIN user_shipping
WHERE
    user_shipping.user_id = ?