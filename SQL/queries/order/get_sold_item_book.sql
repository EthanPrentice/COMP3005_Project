SELECT
    book.*
FROM
    book
    NATURAL JOIN book_sold
WHERE
    book_sold.sold_item_id = ?