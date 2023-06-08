SELECT CAR_TYPE, COUNT(CAR_TYPE)
FROM CAR_RENTAL_COMPANY_CAR 
WHERE OPTIONS like concat ('%', '통풍시트', '%') OR
    OPTIONS like concat ('%', '열선시트', '%') OR
    OPTIONS like concat ('%', '가죽시트', '%')
GROUP BY CAR_TYPE
ORDER BY CAR_TYPE 
