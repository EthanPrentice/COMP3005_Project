SELECT
    cart_item.*
FROM
    cart_item
    NATURAL JOIN in_cart
WHERE
    in_cart.cart_id = ?