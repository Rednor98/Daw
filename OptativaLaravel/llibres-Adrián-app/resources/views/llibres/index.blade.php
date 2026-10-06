
@yield('title', 'SanctoSantorum - Adrián')
        @extends('layouts.app')
        @section('content')
            <ul>
                @foreach ($llibres as $llibre)
                    <h1>{{$llibre['titol']}} </h1>
                    <p> Autor: {{$llibre['autor']}}</p>
                    <p> Año de publicacion: {{$llibre['anyPublicacio']}}</p>
                    <p> Genero: {{$llibre['genere']}}</p>
                    <p> Descripcion: {{$llibre['descripcio']}}</p>
                @endforeach
            </ul>
        @endsection
