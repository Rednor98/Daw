<?php
namespace App\Http\Controllers;
use App\Models\Llibre;
use Illuminate\Http\Request;

class LlibreController extends Controller
{
    //Mostrar llista de Llibres
    public function Index(){
      return view("inici");
    }
    public function Llibres(){
          $llibres = Llibre::obtenirTots();
        //Obtenim tots els Llibres del model
        return view('llibres.index', compact('llibres'));
        //Pasar-los a la vista
    }
}
?>