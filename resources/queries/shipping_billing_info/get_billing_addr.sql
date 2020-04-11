SELECT
    address.*
FROM
    address,
    NATURAL JOIN billing_addr
WHERE
    billing_addr.billing_info_id = ?