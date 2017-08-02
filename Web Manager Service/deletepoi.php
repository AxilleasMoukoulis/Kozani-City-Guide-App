<?php
session_start();
if($_SESSION["loggedIn"] != true)
{
    header("Location: index.html");
    die();
}
?>
<!DOCTYPE html>

<html>
	
<head>
	<title>Kozani City Guide - Form</title>
		<meta http-equiv="Content-Type" content="text/html"/>
		<meta charset="UTF-8"/>		
		<meta name="viewport" content="width=device-width, initial-scale=1">
	  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

</head>

<body>
	<?php 
	header('Content-Type: text/html; charset=utf-8');
	//echo $_POST['poi_name'];
	$connection = mysql_connect("localhost", "city_guide", "city_guide_2016"); // Establishing connection with server..
	$db = mysql_select_db("city_guide", $connection); // Selecting Database.
	mysql_query("SET CHARACTER SET 'greek'", $connection);
	mysqli_set_charset($connection, "utf8");
	mysql_query("SET NAMES 'utf8'"); 

	$delete_poi = $_GET['poi_id'];

   	$sql = "DELETE FROM Points_of_interest WHERE point_of_interest_id = ".$delete_poi."";
   	
   	$result = mysql_query($sql, $connection);

   	if($result==true)
   	{
      		echo "<script language='javascript'>alert('Database Successfully Updated'); window.location = 'form.php';</script>";
   	}
   	mysql_close ($connection); // Connection Closed.
	
	//remove poi directory
/*	$target_dir = "uploads/" . $_GET['poi_name'];
	if (is_dir($target_dir)) {
		rrmdir($target_dir);
	}
*/

?>

</body>
</html>



