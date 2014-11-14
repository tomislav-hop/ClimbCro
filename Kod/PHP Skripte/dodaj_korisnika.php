<?php

// polje za JSON odgovor
$response = array();
 
// provjera potrebnih polja
if (isset($_POST['korisnicko_ime']) && isset($_POST['email']) && isset($_POST['lozinka'])) {
 
    $ime = $_POST['korisnicko_ime'];
    $mail = $_POST['email'];
    $loz = $_POST['lozinka'];
 
    // klasa za spajanje
    require_once 'db_connect.php';
 
    // spajanje na bazu
    $db = new DB_CONNECT();
 
    // ubacivanje reda u bazu
    $result = mysql_query("INSERT INTO korisnik(korisnicko_ime, email, lozinka) VALUES('$ime', '$mail', '$loz')");
 
    // provjera unosa u bazu
    if ($result) {
        // uspjesan unos u bazu
        $response["success"] = 1;
        $response["message"] = "Korisnik unesen.";
 
        // echo JSON
        echo json_encode($response);
    } else {
        // neuspjesan unos u bazu
        $response["success"] = 0;
        $response["message"] = "Korisnik nije unesen.";
 
        // echo JSON
        echo json_encode($response);
    }
} else {
    // polje ili polja nedostaju
    $response["success"] = "0";
    $response["message"] = "Nesto nedostaje";
 
    // echo JSON
    echo json_encode($response);
}
?>