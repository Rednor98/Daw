<?php 
// app/Models/Llibre.php
namespace App\Models;
class Llibre
{
    //Array estàtic per emmagatzemar els llibres
    public static $llibres = [
        ['id' => 1, 'titol' => 'El nombre del Viento', 'autor' => 'Patrick Rothfuss','anyPublicacio' => 2002, 'genere' => 'Fantasia', 'descripcio' => 'Es la narracion de un Joven'],
        ['id' => 2, 'titol' => 'El principe de la Niebla', 'autor' => 'Carlos Ruiz Zafon','anyPublicacio' => 2005,'genere' => 'Suspense/Terror','descripcio' => 'Narra la historia de una familia que se muda a un nuevo vecindario y ocurre cosas que no se pueden explicar'],
        ['id' => 3, 'titol' => 'El camino de los reyes', 'autor' => 'Brandon Sanderson','anyPublicacio' => 2008,'genere' => 'Fantasia','descripcio' => 'Tiene poderes y hacen cosas'],
        ['id' => 4, 'titol' => 'El cementerio de animales', 'autor' => 'Stephen King','anyPublicacio' => 1999,'genere' => 'Terror/Suspense', 'descripcio' => 'Una familia se muda a una casa nueva y pasan cosas inexplicables'],
        ['id' => 5, 'titol' => 'El trono de cristal', 'autor' => 'Shara J Mass','anyPublicacio' => 2007, 'genere' => 'Fantasia', 'descripcio' => 'Una joven asesina quiere ser libre']

    ];

    //Funció per obtenir tots els llibres
    public static function obtenirTots()
    {
        return self::$llibres;
    }
}

?>