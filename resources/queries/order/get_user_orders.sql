SELECT
	`order`.*

FROM
	`order`
    INNER JOIN user_order on user_order.order_id = `order`.order_id

WHERE
	user_order.user_id = ?