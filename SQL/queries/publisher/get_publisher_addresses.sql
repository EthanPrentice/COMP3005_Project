SELECT
    address.*
FROM
    address
    INNER JOIN publisher_address on publisher_address.address_id = address.address_id

WHERE
    publisher_address.publisher_id = ?