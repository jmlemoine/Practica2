<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Práctica #2 - 2014-0795</title>

    <!-- Bootstrap core CSS -->
    <link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/css/heroic-features.css" rel="stylesheet">

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">

</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-success fixed-top">
    <div class="container">
        <a class="navbar-brand" href="#">Práctica #2 - 2014-0795</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">

            </ul>
        </div>
    </div>
</nav>

<!-- Page Content -->
<div class="container mt-4">
    <div class="card">
        <div class="card-body">
            <img src="https://www.thefamouspeople.com/profiles/images/david-ortiz-7.jpg" alt="David Ortiz" class="rounded-circle mb-2" width="128px"/>
            <ul class="list-group">
                <li class="list-group-item"><span class="font-weight-bold">Matricula: </span>${EstudianteX.matricula?string["0"]}</span></li>
                <li class="list-group-item"><span class="font-weight-bold">Nombre: </span>${EstudianteX.nombre}</li>
                <li class="list-group-item"><span class="font-weight-bold">Apellido: </span>${EstudianteX.apellido}</li>
                <li class="list-group-item"><span class="font-weight-bold">Teléfono: </span>${EstudianteX.telefono}</li>
            </ul>
        </div>
    </div>
</div>
<!-- /.container -->

<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
