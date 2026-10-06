<?php
namespace App\Http\Controllers;
use App\Models\Llibre;
use Illuminate\Http\Request;

class ContacteController extends Controller
{
  public function Index(){
    return view ("inici");
  }
  public function afegir(Request $request){
    $name = $request->name;
    $email = $request->email;
    $missatge = $request->missatge;
    return view ("request-contacte", compact ("name","email",""));
  }
  public function submit(Request $request){

  }
}
?>