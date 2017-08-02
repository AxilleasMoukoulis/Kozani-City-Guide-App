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

   	$poi_name=$_POST['poi_name']; // Fetching Values from URL.
   	$poi_subcategory=$_POST['poi_subcategory']; // Password Encryption, If you like you can also leave sha1.
   	$poi_description=$_POST['poi_description']; // Password Encryption, If you like you can also leave sha1.
   	$poi_address=$_POST['poi_address']; // Password Encryption, If you like you can also leave sha1.
   	$poi_landtitude=$_POST['poi_landtitude']; // Password Encryption, If you like you can also leave sha1.
   	$poi_longtitude=$_POST['poi_longtitude']; // Password Encryption, If you like you can also leave sha1.

   	$action = $_POST['action'];
	if ($action == "insert")
	{	
		$sql = "INSERT INTO Points_of_interest (point_of_interest_id, point_of_interest_name, point_of_interest_subcategory_id, point_of_interest_lantitude, point_of_interest_longtitude, point_of_interest_address, point_of_interest_description) "."VALUES(' ', '$poi_name', '$poi_subcategory', '$poi_landtitude', '$poi_longtitude', '$poi_address', '$poi_description')";
   	}
   	else if ($action == "update")
	{	
		$id = $_POST['id'];
		$sql = "UPDATE Points_of_interest SET point_of_interest_name='$poi_name',point_of_interest_subcategory_id='$poi_subcategory',point_of_interest_lantitude='$poi_landtitude',point_of_interest_longtitude='$poi_longtitude',point_of_interest_address='$poi_address',point_of_interest_description='$poi_description' WHERE point_of_interest_id = '$id'";
   	}

 	$result = mysql_query($sql, $connection);

   	if($result==true)
   	{
      		echo "<script language='javascript'>alert('Database Successfully Updated'); window.location = 'form.php';</script>";
   	}
   	mysql_close ($connection); // Connection Closed.


//Images Handling
if(count($_FILES['poi_images']['name']) > 0) 
{
	//create poi directory
	$target_dir = "uploads/" . $_POST['poi_name'];
	if ( ! is_dir($target_dir)) {
		mkdir($target_dir);
	}
	chmod($target_dir, 0777);

	//get every poi image
	$count = count($_FILES['poi_images']['name']);
	//echo "Count: " . $count . " | ";
	for($i=0; $i<=$count; $i++) {
		//echo $_FILES['poi_images']['name'][$i]."\n";
	
		$target_file = $target_dir . "/" . basename($_FILES["poi_images"]["name"][$i]);
		$uploadOk = 1;
		$imageFileType = pathinfo($target_file,PATHINFO_EXTENSION);

		$check = getimagesize($_FILES["poi_images"]["tmp_name"][$i]);
		if($check !== false) {
			//echo "File is an image - " . $check["mime"] . ". | ";
			$uploadOk = 1;
		} else {
			//echo "File is not an image. | ";
			$uploadOk = 0;
		}
		
		//Check if image file is a actual image or fake image
		$check = getimagesize($_FILES["poi_images"]["tmp_name"][$i]);
		if($check !== false) {
			//echo "File is an image - " . $check["mime"] . ". | ";
			$uploadOk = 1;
		} else {
			//echo "File is not an image. | ";
			$uploadOk = 0;
		}
		
		// Check if file already exists
		if (file_exists($target_file)) {
			//echo "Sorry, file already exists. | ";
			$uploadOk = 0;
		}
	
			// Check file size
		if ($_FILES["poi_images"]["size"][$i] > 5000000) {
			//echo "Sorry, your file is too large.";
			$uploadOk = 0;
		}

		// Allow certain file formats
		if($imageFileType != "jpg" && $imageFileType != "png" && $imageFileType != "jpeg" && $imageFileType != "gif" ) {
			//echo "Sorry, only JPG, JPEG, PNG & GIF files are allowed. | ";
			$uploadOk = 0;
		}
	
		// Check if $uploadOk is set to 0 by an error
		if ($uploadOk == 0) {
			//echo "Sorry, your file was not uploaded. | ";
		// if everything is ok, try to upload file
		} else {
			$target_file = $target_dir . "/" . ($i + 1) . ".jpg";
			if (move_uploaded_file($_FILES["poi_images"]["tmp_name"][$i], $target_file)) {
				//echo "The file ". basename( $_FILES["poi_images"]["name"][$i]). " has been uploaded. | ";
			} else {
				//echo "Sorry, there was an error uploading your file. | ";
			}
		}
	
	}	
}

?>

</body>
</html>



