import sys
import MySQLdb

try:
    db = MySQLdb.connect(host = 'localhost', user = 'root', passwd = 'welkom12', db = 'localdb')
    cursor = db.cursor()

except Exception as e:
    sys.exit('We can\'t get into the database')
    raw_input('Press <enter> to continue')


try:
    x = 0
    for x in range (1, 10):
        x += 1
        sql = "INSERT INTO `todolist`.`tasks` (`id`, `voor`, `wat`, `waneer`, `timestamp`) VALUES (NULL, 'Python', 'Script-added', 'PYTHON-DATE', CURRENT_TIMESTAMP)"
        cursor.execute(sql)
        db.commit()
        
except Exception as e:
    print("\nThis username is already in use!")
        
    


