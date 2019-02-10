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

    <form method="post" action="/AgregarALaListadeEstudiantes">

        <div class="form-group">
            <label for="matricula">Matricula</label>
            <input type="text" class="form-control" id="matricula" name="matricula" placeholder="Matricula" required>
        </div>

        <div class="form-group">
            <label for="nombre">Nombre</label>
            <input type="text" class="form-control"  id="nombre" name="nombre" placeholder="Nombre" required>
        </div>

        <div class="form-group">
            <label for="apellido">Apellido</label>
            <input type="text" class="form-control" id="apellido" name="apellido" placeholder="Apellido" required>
        </div>

        <div class="form-group">
            <label for="telefono">Teléfono</label>
            <input type="text" class="form-control" id="telefono" name="telefono" placeholder="Telefono" required>
        </div>

        <button type="submit" class="btn btn-success"><i class="fas fa-plus-square"></i> Agregar</button>

    </form>
</div>
<!-- /.container -->

<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
