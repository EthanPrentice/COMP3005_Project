SELECT
	book.*,
    sold_item.*

FROM
	book
    NATURAL JOIN book_sold
    NATURAL JOIN sold_item
    NATURAL JOIN item_in_order

WHERE
	item_in_order.order_id = ?