SELECT
	book.*
FROM
	book
    INNER JOIN inventory on inventory.book_id = book.book_id
WHERE
	inventory.quantity > 0