 # Case When 
 SELECT ANIMAL_ID, NAME, 
 ( CASE 
     WHEN (SEX_UPON_INTAKE like concat ('%', 'Neutered', '%')
 OR SEX_UPON_INTAKE like concat ('%', 'Spayed', '%'))  THEN 'O'  
     ELSE 'X'
  END
 ) AS '중성화'
 FROM ANIMAL_INS
 ORDER BY ANIMAL_ID

# 정규표현식 사용

SELECT ANIMAL_ID, NAME, 
( CASE 
    WHEN SEX_UPON_INTAKE REGEXP 'Neutered|Spayed'  THEN 'O'  
    ELSE 'X'
 END
) AS '중성화'
FROM ANIMAL_INS
ORDER BY ANIMAL_ID
