# Write your MySQL query statement below
SELECT ROUND(SUM(first_order=1 AND immediate=1)*100.0/SUM(first_order=1),2) AS immediate_percentage
FROM 
(
    SELECT t1.*, IF(t1.order_date=t2.first_date,1,0) AS first_order, 
    IF(t1.customer_pref_delivery_date=t1.order_date,1,0) AS immediate
    FROM Delivery t1
    LEFT JOIN 
    (
        SELECT customer_id, MIN(order_date) AS first_date
        FROM Delivery
        GROUP BY customer_id 
    )t2
    ON t1.customer_id=t2.customer_id
)t3