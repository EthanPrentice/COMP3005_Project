SELECT
    billing_info.*
FROM
    billing_info
    NATURAL JOIN user_billing
WHERE
    user_billing.user_id = ?