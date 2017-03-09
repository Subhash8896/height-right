<html>
<head><title>View Users</title>
<style>
body {
  font: normal medium/1.4 sans-serif;
}
table {
  border-collapse: collapse;
  width: 20%;
   margin-left: auto;
    margin-right: auto;
}
tr > td {
  padding: 0.25rem;
  text-align: center;
  border: 1px solid #ccc;
}
tr:nth-child(even) {
  background: #FAE1EE;
}
tr:nth-child(odd) {
  background: #edd3ff;
}
tr#header{
background: #c1e2ff;
}
div.header{
padding: 10px;
background: #e0ffc1;
width:30%;
color: #008000;
margin:5px;
}
div.refresh{
margin-top:10px;
width: 5%;
margin-left: auto;
margin-right: auto;
}
div#norecord{
margin-top:10px;
width: 15%;
margin-left: auto;
margin-right: auto;
}
</style>
<script>
function refreshPage(){
location.reload();
}
</script>
</head>
<body>
<center>
<div class="header">
Mahan Trust Central Database
</div>
</center>
<?php
    include_once 'db_functions.php';
    $db = new DB_Functions();
    $vol=$_POST['volunteer'];
	$kid=$_POST['kid'];
	$date=$_POST['date'];
	$users =mysql_query("SELECT * FROM users WHERE Name LIKE '$vol%$kid%$date' ");
    if ($users != false){
        $no_of_users = mysql_num_rows($users);
	
	}
    else{
        $no_of_users = 0;
		
	}
		?>
<?php
    if ($no_of_users > 0) {
?>
<table>
<tr id="header"><td>Id</td><td>Volunteer Id</td><td>Kid Name</td><td>Height(in cms)</td><td>Bmi</td><td>Date Of Checkup</td></tr>
<?php
function display($value,$key){ ?>
 <td><?php echo $value ?> </td>
<?php
}
    while ($row = mysql_fetch_array($users)) {
?> 
<tr>
<td><span><?php echo $row["Id"] ?></span></td>

<?php 
$res=$row["Name"];
$resultant=explode("|",$res);
$a= array();
$a=$resultant;


array_walk($a,"display");
?>
</tr>
<?php } ?>
</table>
<?php }else{ ?>
<div id="norecord">
No records in MySQL DB

</div>
<?php } ?>
<div class="refresh">
<button onclick="refreshPage()">Refresh</button>
</div>
</body>
</html>