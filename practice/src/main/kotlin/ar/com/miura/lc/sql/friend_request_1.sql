#Mysql
SELECT (
    IFNULL(
        ROUND(
        (
        SELECT COUNT(*) FROM (
                SELECT DISTINCT ra.requester_id, ra.accepter_id FROM RequestAccepted ra
            ) as accepted
        )
        /
        (
            SELECT COUNT(*) FROM (
                SELECT DISTINCT fr.sender_id, fr.send_to_id FROM FriendRequest fr
            ) as total
        ),2),0
    )
) as accept_rate

