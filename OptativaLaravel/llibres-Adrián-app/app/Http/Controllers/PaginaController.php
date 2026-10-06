<?php
namespace App\Http\Controllers;
use App\Models\Llibre;
use Illuminate\Http\Request;

class PaginaController extends Controller
{
  public function Index(){
    return view ("inici");
  }
  public function afegir(Request $request){

  }
  public function submit(Request $request){

  }
}
?>