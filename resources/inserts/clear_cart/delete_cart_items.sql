DELETE FROM cart_item
WHERE
    cart_item.cart_item_id IN (
        SELECT in_cart.cart_item_id
        FROM in_cart
        WHERE in_cart.cart_id = ?
    )