SELECT
    bank_account.*

FROM
    bank_account
    INNER JOIN publisher_bank_acc ON publisher_bank_acc.bank_acc_id = bank_account.bank_acc_id

WHERE
    publisher_bank_acc.publisher_id = ?