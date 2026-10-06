
@yield('title', 'SanctoSantorum - Adrián')
        @extends('layouts.app')
        @section('content')
            <ul>
                <h1>{$name}</h1>
                <p>{$email}</p>
                <p>{$missatge}</p>
            </ul>
        @endsection