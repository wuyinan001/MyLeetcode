# Write your MySQL query statement below
SELECT ROUND(SUM(order_status='immediate' AND first_order=TRUE)*100.0/SUM(first_order=TRUE),2) AS immediate_percentage
FROM
(
    SELECT t1.delivery_id, t1.customer_id, t1.order_date, t1.customer_pref_delivery_date,
    (CASE WHEN order_date=customer_pref_delivery_date THEN 'immediate' ELSE 'sheduled' END) AS order_status,(CASE when t1.order_date=t2.earliest_date THEN TRUE ELSE FALSE END) AS first_order
    FROM Delivery t1
    INNER JOIN
    (
        SELECT customer_id, MIN(order_date) AS earliest_date
        FROM Delivery 
        GROUP BY customer_id
    ) t2
    ON t1.customer_id=t2.customer_id
) t3
