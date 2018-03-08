# filereader
Read file Alice-in-Wonderland.txt on MacBook Pro 2.3 GHz Intel Core i5 by wasuthun wanaphongthipakorn(5910545841)

Task|Time
-----------------------------------------------|-------:
Read file 52539 chars at a time to String | 1.022675 sec.
Read file 52539 chars at a time to StringBuilder | 0.003319 sec.
Read file line at a time using BufferedReader | 0.018784 sec.

Explain
String is the slowest for read file because all the time that you read file to String,itwill create new String that will consume memory and time.

BufferedReader is slower that use StringBuilder because it read file by using BufferedReader but it correct data in String that will make it slower.

StringBuilder is the fastest because StringBuilder will use internally an array of chars and when you use .append() method it will check if it have any space for the string to append and copy the chars of the string in the array.
