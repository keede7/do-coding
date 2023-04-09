
# 날짜의 차이값에 1을 더하는 이유는 
# 빌린 날짜를 기준으로 당일부터 하루로 계산하기 떄문에,
# 차이값에서 먼저 1을 더해서 평균값을 구해야한다.
# 그렇지 않으면 평균값이 달라질 수 있다.

SELECT CAR_ID,
round( avg( DATEDIFF( END_DATE, START_DATE ) +1 ), 1) AS AVERAGE_DURATION
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
HAVING avg(DATEDIFF(END_DATE, START_DATE)) > 6
ORDER BY AVERAGE_DURATION DESC, CAR_ID DESC
