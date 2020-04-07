SELECT
    cart.*
FROM
    cart
    NATURAL JOIN user_cart
WHERE
    user_cart.user_id = ?