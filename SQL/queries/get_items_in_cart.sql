SELECT
    cart_item.*,
    book.*
FROM
    cart_item
    INNER JOIN in_cart ON in_cart.cart_item_id = cart_item.cart_item_id
    INNER JOIN book_in_item ON book_in_item.cart_item_id = cart_item.cart_item_id
    INNER JOIN book ON book.book_id = book_in_item.book_id

WHERE
    in_cart.cart_id = ?
