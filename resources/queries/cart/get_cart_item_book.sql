SELECT
    book.*
FROM
    book
    NATURAL JOIN book_in_item
WHERE
    book_in_item.cart_item_id = ?