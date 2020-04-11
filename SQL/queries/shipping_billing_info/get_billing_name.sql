SELECT
    name.*
FROM
    name,
    NATURAL JOIN billing_name
WHERE
    billing_name.billing_info_id = ?