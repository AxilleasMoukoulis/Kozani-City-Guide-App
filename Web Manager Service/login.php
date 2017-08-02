<?php
session_start();

$connection = mysql_connect("localhost", "city_guide", "city_guide_2016"); // Establishing connection with server..
$db = mysql_select_db("city_guide", $connection); // Selecting Database.

   $username=stripslashes($_POST['username']); // Fetching Values from URL.
   $password=stripslashes($_POST['password']); // Password Encryption, If you like you can also leave sha1.

   $result = mysql_query("SELECT * FROM Users WHERE user_name='$username' AND user_password='$password'");

   $data = mysql_num_rows($result);

   if($data==1)
   {

      $_SESSION["loggedIn"] = true;
      header("Location: form.php");
      //echo "Successfully Logged in...";
   }
   else
   {
      header("Location: index.html");
      die();
      //echo "Username or Password is wrong...!!!!";
   }
   mysql_close ($connection); // Connection Closed.

?>
