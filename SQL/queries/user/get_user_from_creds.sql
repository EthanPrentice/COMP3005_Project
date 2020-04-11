SELECT
    `user`.*
FROM
    `user`
WHERE
    `user`.username = ?
    AND `user`.password = ?