
SELECT concat('/home/grep/src/', file.BOARD_ID, "/", file.FILE_ID, file.FIle_NAME, file.FILE_EXT) AS FILE_PATH
FROM USED_GOODS_BOARD board
INNER JOIN USED_GOODS_FILE file on board.board_id = file.BOARD_ID
having max(board.VIEWS)
ORDER BY board.VIEWS DESC, file.FILE_ID DESC
limit 1
