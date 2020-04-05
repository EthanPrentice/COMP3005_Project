SELECT
    author.*,
    `name`.*
FROM
    book
    NATURAL JOIN written_by
    NATURAL JOIN author
    INNER JOIN author_name ON author_name.author_id = author.author_id
    INNER JOIN `name` ON `name`.name_id = author_name.name_id

WHERE
    book_id = ?