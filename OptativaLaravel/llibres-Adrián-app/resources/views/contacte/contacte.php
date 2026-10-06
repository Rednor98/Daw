
@yield('title', 'SanctoSantorum - Adrián')
        @extends('layouts.app')
        @section('content')
            <form action="{{ route('pagina.afegir') }}" method="POST">
                @csrf
                <input type="text" name="nom" placeholder="Nom de la persona" required>
                <input type="email" name="email" placeholder="Email" required>
                <input type="text" name="missatge" placeholder="Missatge(opcional)"
                <button type="submit">Afegir Contacte</button>
            </form>
        @endsection