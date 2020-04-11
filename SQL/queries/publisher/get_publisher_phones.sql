SELECT
    phone.*
FROM
    phone
    NATURAL JOIN phone_is_type
    NATURAL JOIN phone_type
    INNER JOIN publisher_phone on publisher_phone.phone_id = phone.phone_id

WHERE
    publisher_phone.publisher_id = ?