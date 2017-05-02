<?php

    $DB_HOST = '';
    $DB_NAME = '';
    $DB_USER = '';
    $DB_PASSWORD = ''; 
try {  
      
        $conn = new PDO("mysql:host=$DB_HOST;dbname=$DB_NAME", $DB_USER, $DB_PASSWORD);
	$conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);     
        $stmt = $conn->prepare("INSERT INTO parsed_matches_high(matchId, json) VALUES(:matchId, :json)");	
        $stmt->bindParam(':matchId', $matchId);
        $stmt->bindParam(':json', $json, PDO::PARAM_LOB);
 	$json = fopen($argv[2], 'rb');
	$matchId = $argv[1];
        $stmt->execute();
    	echo "New records created successfully";
    }
catch(PDOException $e)
    {
    	echo "Error: " . $e->getMessage();
    }        
$conn = null;
?>
