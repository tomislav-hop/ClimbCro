<?php
 
/**
 * klasa za spajanje
 */
class DB_CONNECT {
 
    // constructor
    function __construct() {
        // spajanje na bazu
        $this->connect();
    }
 
    // destructor
    function __destruct() {
        // zatvaranje veze
        $this->close();
    }
 
    /**
     * funkcija za spajanje na bazu
     */
    function connect() {
        // hvatanje variabli za bazu
        require_once 'db_config.php';
 
        // spajanje na bazu
        $con = mysql_connect(DB_SERVER, DB_USER, DB_PASSWORD) or die(mysql_error());
 
        // odabir baze
        $db = mysql_select_db(DB_DATABASE) or die(mysql_error()) or die(mysql_error());
 
        // onnection cursor
        return $con;
    }
 
    /**
     * funkcija za prekid veze
     */
    function close() {
        // zatvaranje veze
        mysql_close();
    }
 
}
 
?>