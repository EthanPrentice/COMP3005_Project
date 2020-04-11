SELECT
    sp.*

FROM
    supplier_pricing AS sp
    INNER JOIN book_supp_pricing AS bsp ON bsp.supplier_pricing_id = sp.supplier_pricing_id

WHERE
    bsp.book_id = ?