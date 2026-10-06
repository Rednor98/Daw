<?php

use App\Http\Controllers\ContacteController;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\LlibreController;
use App\Http\Controllers\PaginaController;

Route::get('/inici', [PaginaController::class, 'index']);

Route::get('/llibres', [LlibreController::class, 'llibres']);

Route::post('/contacte', [ContacteController::class, 'afegir'])->name('pagina.afegir');
