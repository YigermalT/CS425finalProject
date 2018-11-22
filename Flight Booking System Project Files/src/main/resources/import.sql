USE 'fbsapp';

INSERT INTO `role` VALUES (1,'ADMIN');

/*populate Airline*/
INSERT INTO `Airline` VALUES (1,'SkyTeam'),(2,'oneworld'),(3,'Star Alliance');

/*populate Airplane*/
INSERT INTO `Airplane` VALUES (1,519,'A380','12345'),(2,416,'747','54321'),(3,519,'A380','23451'),(4,416,'747','43215'),(5,519,'A380','34512'),(6,416,'747','32154');

/*populate Airport*/
/*INSERT INTO `Airport` VALUES (1,'AMS','Amsterdam','The Netherlands','Schiphol'),(2,'DTW','Detroit','USA','Detroit City'),(3,'NRT','Tokyo','Japan','Narita International Airport'),(4,'SYD','Sydney','Australia','Kingsford Smith'),(5,'LAX','Los Angeles','USA','Los Angeles International'),(6,'FRA','Frankfurt','Germany','Frankfurt International Airport'),(7,'ORD','Chicago','USA','Chicago Ohare International'),(8,'LHR','London','UK','London Heathrow'),(9,'JFK','New York','USA','John F. Kennedy International'),(10,'SIN','Singapore','Singapore','Changi Airport');
*/

INSERT INTO `Airport` VALUES (1,'AMS','Schiphol','Amsterdam','Netherlands'),(2,'DTW','Detroit City','Detroit','USA'),(3,'NRT','Narita International Airport','Tokyo','Japan'),(4,'SYD','Kingsford Smith','Sydney','Australia'),(5,'LAX','Los Angeles International','Los Angeles','USA'),(6,'FRA','Frankfurt International Airport','Frankfurt','Germany'),(7,'ORD','Chicago Ohare International','Chicago','USA'),(8,'LHR','London Heathrow','London','UK'),(9,'JFK','John F. Kennedy International','New York','USA'),(10,'SIN','Changi Airport','Singapore','Singapore');

/*populate Flight*/
INSERT INTO `Flight` VALUES (1,'2019-11-07','09:00:00','2019-11-06','19:10:00','NW 36',1,1,1,2),(2,'2019-11-07','13:45:00','2019-11-06','15:05:00','NW 96',1,2,2,3),(3,'2019-11-07','06:15:00','2019-11-05','22:30:00','QF 12',2,3,4,5),(4,'2019-11-07','06:55:00','2019-11-06','21:55:00','QF 21',2,4,3,4),(5,'2019-11-07','05:45:00','2019-11-06','14:30:00','UA 944',3,5,6,7),(6,'2019-11-07','07:30:00','2019-11-06','12:59:00','UA 934',3,6,8,5),(7,'2019-11-07','07:40:00','2019-11-07','07:15:00','NW 8445',1,1,8,1),(8,'2019-11-07','12:21:00','2019-11-07','12:05:00','NW 1689',1,2,7,2),(9,'2019-11-07','23:39:00','2019-11-07','15:00:00','QF 3101',2,3,9,5),(10,'2019-11-07','17:15:00','2019-11-07','11:05:00','QF 4022',2,4,10,3),(11,'2019-11-07','14:53:00','2019-11-07','12:45:00','UA 941',3,5,7,6),(12,'2019-11-07','10:38:00','2019-11-07','08:10:00','UA 4842',3,6,1,8);