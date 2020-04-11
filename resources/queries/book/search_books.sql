SELECT
    book.*,
    inventory.quantity
FROM
    book
    NATURAL JOIN written_by
    NATURAL JOIN author
    INNER JOIN author_name ON author_name.author_id = author.author_id
    INNER JOIN `name` ON `name`.name_id = author_name.name_id

    INNER JOIN published_by ON published_by.book_id = book.book_id
    INNER JOIN publisher ON publisher.publisher_id = published_by.publisher_id

    INNER JOIN inventory ON inventory.book_id = book.book_id

WHERE
    inventory.quantity > 3
    AND (
        book.title LIKE CONCAT('%', ?, '%')
        OR book.genre LIKE CONCAT('%', ?, '%')
        OR CONCAT(IFNULL(`name`.`first`, ''), ' ', IFNULL(`name`.`middle`, ''), IFNULL(`name`.`last`, '')) LIKE CONCAT('%', ?, '%')
        OR publisher.publisher_name LIKE CONCAT('%', ?, '%')
    )