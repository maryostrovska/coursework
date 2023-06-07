<!DOCTYPE html>
<html>
<head>
    <title>Menu</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <style>

        body {
            background-color: #7AA077;
            font-family: Arial, sans-serif;
            margin: 0;


        }

        .colorful-line {
            height: 14px;
            background: linear-gradient(80deg, blue, yellow);
        }

        .container {
            max-width: 500px;
            margin: 160px auto;
            text-align: center;
        }

        h1 {
            font-family: 'Inter';
            font-style: normal;
            font-size: 46px;
            margin-bottom: 40px;
            font-weight: 400;
            color: #F4C447;
        }

        h2 {
            font-family: 'Inter';
            font-style: normal;
            font-size: 20px;

            margin: 84px;
            color: #F4C447;

            line-height: 18px;
            text-align: center;
        }

        .btn-custom {
            background-color: #5F5E5E;
            font-family: 'Inter';
            font-style: normal;
            margin-bottom: 20px;
            color: #F4C447;
            border: none;
            padding: 12px 30px;
            font-size: 18px;
            border-radius: 4px;
            cursor: pointer;
        }

        .btn-custom:hover {
            background-color: #A1A1A1;
        }

        .img1 {
            position: fixed;
            top: 0px;

        }

        .img2 {
            position: fixed;
            top: 0px;
            margin-left: 980px;
        }


    </style>
</head>


<body>
<div class="img2">
    <img src="https://i.pinimg.com/564x/26/a4/46/26a4460db7fefb93cb1eca75b2e7806b.jpg" >
</div>
<div class="img1">
    <img src="https://i.pinimg.com/564x/88/c7/61/88c7612585418fe85f7aa641ff8fcec5.jpg" >
</div>




<div class="container">
        <h1>Меню</h1>
    <form method="get" action="/exchange">
        <button class="btn btn-custom" type="submit">Обміняти квартиру</button>
    </form>
    <form method="get" action="/showAllApartments">
        <button class="btn btn-custom" type="submit">Показати усю картотеку</button>
    </form>
  <h2>Курсова робота <br>
      Островської Марії ПМ-33 <br>
      2023</h2>

</div>
<div class="colorful-line"></div>

</body>
</html>