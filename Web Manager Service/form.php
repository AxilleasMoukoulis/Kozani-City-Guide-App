<?php
session_start();
if($_SESSION["loggedIn"] != true)
{
    header("Location: index.html");
    die();
}
header('Content-Type: text/html; charset=utf-8');
//echo $_POST['poi_name'];
$connection = mysql_connect("localhost", "city_guide", "city_guide_2016"); // Establishing connection with server..
$db = mysql_select_db("city_guide", $connection); // Selecting Database.
mysql_query("SET CHARACTER SET 'greek'", $connection);
mysqli_set_charset($connection, "utf8");
mysql_query("SET NAMES 'utf8'"); 
		
?>

<!DOCTYPE html>

<html>
	
<head>
	<title>Kozani City Guide - Form</title>
		<meta http-equiv="Content-Type" content="text/html"/>
		<meta charset="UTF-8"/>		
		<meta name="viewport" content="width=device-width, initial-scale=1">
	  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

		
	<script type="application/x-javascript"> 
		addEventListener("load", function() 
		{ setTimeout(hideURLbar, 0); }, false); 

		function hideURLbar(){ window.scrollTo(0,1); } 
	</script>
	
	<!--webfonts-->
	<link href='//fonts.googleapis.com/css?family=Open+Sans:600italic,400,300,600,700' rel='stylesheet' type='text/css'>
	<!--//webfonts-->
	
	<link rel="stylesheet" href="themes/base/jquery.ui.all.css">
  	<link rel="stylesheet" href="css/demo.css">
  	
	<script src="http://maps.google.com/maps/api/js?sensor=false"></script>
  	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
  	<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
  	<script src="src/jquery.ui.addresspicker.js"></script>
  
	<script>
  	$(function() {
    		var addresspicker = $( "#addresspicker" ).addresspicker({componentsFilter: 'country:GR'});
    		var addresspickerMap = $( "#addresspicker_map" ).addresspicker({regionBias: "gr", language: "gr", updateCallback: showCallback, mapOptions: { zoom: 18, center: new google.maps.LatLng(40.30088248559031, 21.78860855102539), scrollwheel: false, mapTypeId: google.maps.MapTypeId.ROADMAP}, 
elements: { map: "#map", lat: "#lat", lng: "#lng", street_number: '#street_number'} });


    var gmarker = addresspickerMap.addresspicker( "marker");
    gmarker.setVisible(true);
    addresspickerMap.addresspicker( "updatePosition");

    $('#reverseGeocode').change(function(){
      $("#addresspicker_map").addresspicker("option", "reverseGeocode", ($(this).val() === 'true'));
    });

    function showCallback(geocodeResult, parsedGeocodeResult){
      $('#callback_result').text(JSON.stringify(parsedGeocodeResult, null, 4));
    }
    
  });
  </script>

</head>

<body background="images/city_back.png">
	
	<?php
		$poi_id = $_GET["poi_id"];
		if ($poi_id)
		{
			$result = mysql_query("SELECT * FROM Points_of_interest WHERE point_of_interest_id = ".$poi_id."");
			$row = mysql_fetch_array($result);
			$action = "update";
			echo 
			"<script type='text/javascript'>
				$(document).ready(function(){
					$('#singlebutton').prop('value', 'Update');
				});
			</script>";
		} 	
		else 
		{
		$action = "insert";	
		echo 
			"<script type='text/javascript'>
				$(document).ready(function(){
					$('#singlebutton').prop('value', 'Submit');
				});
			</script>";	
		}
		
	?>
	
	</br>
	<form class="form-horizontal" method="POST" action="logout.php" >
	<fieldset>	
	<div class="form-group">
  		<label class="col-md-4 control-label" for="singlebutton">Έξοδος Χρήστη</label>
  		<div class="col-md-4">
	       	<button type="submit" class="btn btn-danger" id="logout" name="logout">Logout</button>
  	</div>
	</div>
	</fieldset>
  	</form>
	
	<div class="bs-example">
	<legend><h2>Σημείο Ενδιαφέροντος</h2></legend></br></br></br>

    <ul class="nav nav-tabs">
        <li class="active"><a data-toggle="tab" href="#eisagwgi">Εισαγωγή</a></li>
        <li><a data-toggle="tab" href="#epexergasia">Επεξεργασία</a></li>
    </ul>
    <div class="tab-content">
        <div id="eisagwgi" class="tab-pane fade in active">
				<!--Edw ksekinaei i eisagwgi-->
				</br>
				<form id="form" class="form-horizontal" method="POST" action="insertpoi.php" enctype="multipart/form-data">
				<input type="hidden" id="action" name="action" value=<?php echo $action ?> />
				<input type="hidden" id="id" name="id" value=<?php echo $row['point_of_interest_id'] ?> />

				<fieldset>
					<div class="form-group">
					<label class="col-md-4 control-label" for="poi_name">Όνομα</label>  
						<div class="col-md-4">
							<input id="poi_name" name="poi_name" type="text" placeholder="πχ. Chorus Bar" value="<?php echo $row['point_of_interest_name']; ?>" class="form-control input-md" required>
						</div>
					</div>
					</br>
	
					<div class="form-group">
					<label class="col-md-4 control-label" for="poi_subcategory">Κατηγορία</label>
						<div class="col-md-4">
							<select id="poi_subcategory" name="poi_subcategory" class="form-control">
								<option value="1" <?php if($row['point_of_interest_subcategory_id']==1) echo 'selected="selected"'; ?>>Ιστορικά Κτήρια</option>
								<option value="2" <?php if($row['point_of_interest_subcategory_id']==2) echo 'selected="selected"'; ?>>Εκκλησίες</option>
								<option value="3" <?php if($row['point_of_interest_subcategory_id']==3) echo 'selected="selected"'; ?>>Μουσεία</option>
								<option value="4" <?php if($row['point_of_interest_subcategory_id']==4) echo 'selected="selected"'; ?>>Καφετέριες</option>
								<option value="5" <?php if($row['point_of_interest_subcategory_id']==5) echo 'selected="selected"'; ?>>Μπαρ</option>
								<option value="6" <?php if($row['point_of_interest_subcategory_id']==6) echo 'selected="selected"'; ?>>Κλαμπ</option>
								<option value="7" <?php if($row['point_of_interest_subcategory_id']==7) echo 'selected="selected"'; ?>>Εστιατόρια</option>
								<option value="8" <?php if($row['point_of_interest_subcategory_id']==8) echo 'selected="selected"'; ?>>Ταβέρνες</option>
								<option value="9" <?php if($row['point_of_interest_subcategory_id']==9) echo 'selected="selected"'; ?>>Μεζεδοπωλεία</option>
								<option value="10" <?php if($row['point_of_interest_subcategory_id']==10) echo 'selected="selected"'; ?>>Ξενοδοχεία</option>
							</select>
						</div>
					</div>
					</br>


					<div class="form-group">
					<label class="col-md-4 control-label" for="poi_description">Περιγραφή</label>
						<div class="col-md-4">                     
							<textarea class="form-control" id="poi_description" name="poi_description" required><?php echo $row['point_of_interest_description'];?></textarea>
						</div>
					</div>
					</br>

					<div class="demo">
						<div class='clearfix'>
							<div class='input input-positioned'>
							<label>Διεύθυνση : </label> <input name="poi_address" id="addresspicker_map" value="<?php echo $row['point_of_interest_address']; ?>" required>   <br/>
							<label>Latitude:      </label> <input name="poi_landtitude" id="lat" value="<?php echo $row['point_of_interest_landtitude']; ?>" readonly="readonly" required> <br/>
							<label>Longtitude:      </label> <input name="poi_longtitude" id="lng" value="<?php echo $row['point_of_interest_longtitude']; ?>" readonly="readonly" required> <br/>
							</div>

							<div class='map-wrapper'> 
								<div id="map"></div>
								<div id="legend">Σείρε το κόκκινο pin icon για να διαλέξεις την διεύθυνση</div>
							</div>
						</div>
					</div><!-- End demo -->

					</br>
					<div class="form-group">
						<label class="col-md-4 control-label" for="poi_images">Φωτογραφίες</label>
					<div class="col-md-4">                     
						<input type="file" class="btn btn-success" name="poi_images[]" id="poi_images" multiple="" />  	</div>
					</div>

					</br>
					<div class="form-group">
					<label class="col-md-4 control-label" for="singlebutton">Καταχώρηση στη Βάση</label>
						<div class="col-md-4">
							  <input type="submit" class="btn btn-primary" id="singlebutton" name="singlebutton" value="Submit">
						</div>
					</div>

			</fieldset>
			</form>	       
		</div>
		<!--Edw teleiwnei i eisagwgi-->

		<!--Edw ksekinaei i epexergasia-->	
		<div id="epexergasia" class="tab-pane fade">
			</br>
			<div id="tableForm">
		<?php
				echo '<div>';
				echo '<table >';
					echo '<tr>';
						echo '  <td colspan="2" style="padding: 15px">';
							echo ' ';
						echo '</td>';
						echo '  <td style="padding: 15px">';
							echo ' ID ';
						echo '</td>';
						echo '<td style="padding: 15px">';
							echo ' Όνομα σ.ε. ';
						echo ' </td>';
					echo '</tr>';
					
				$result = mysql_query("SELECT point_of_interest_id, point_of_interest_name FROM Points_of_interest");
	
				echo "<tr>";
				while ($row = mysql_fetch_array($result)) 
				{		
						$poi_id = $row['point_of_interest_id'];
						$poi_name = $row['point_of_interest_name'];
					
						$icon_delete = '<img src="images/delete.png" width="30" height="30"  alt=""/>';
						$icon_edit = '<img src="images/edit.png" width="30" height="30"  alt=""/> ';
						$msg_confirm = "Είστε σίγουρος για τη διαγραφή;";
						echo "<td >";	
							echo '<a onclick="return confirm(\'Είστε σίγουρος για τη διαγραφή;\')" href="deletepoi.php?poi_id='.$poi_id.'&poi_name='.$poi_name.'">'.$icon_delete.'</a>'; 
						echo "</td >";
						echo "<td >";
							echo '&nbsp;&nbsp;<a href="form.php?poi_id=' .$poi_id. '">'.$icon_edit.'</a>'; 
						echo "</td >";
						echo '<td style="padding: 15px">';	
							echo " ". $row['point_of_interest_id']. " ";
						echo "</td >";
						echo '<td style="padding: 15px">';	
							echo " ". $row['point_of_interest_name']. " ";
						echo "</td >";
					echo "</tr>";	
				}
				echo ' </table>';
				echo '</div>';	
		?>
		</div>
		</div>    
    	<!--Edw teleiwnei i epexergasia-->	

    </div>

	
</body>
</html>
