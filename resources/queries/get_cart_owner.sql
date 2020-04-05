SELECT
    `user`.*
FROM
    `user`
    INNER JOIN user_cart ON user_cart.user_id = `user`.user_id

WHERE
    user_cart.cart_id = ?