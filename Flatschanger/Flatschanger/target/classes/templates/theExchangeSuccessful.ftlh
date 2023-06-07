<!DOCTYPE html>
<html>
<head>
    <title>Success</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <style>
        body {
            background-color: #7AA077;
            font-family: Arial, sans-serif;
        }
        .container {
            max-width: 600px;
            margin: 100px auto;
            text-align: center;
            padding: 20px;
            background-color: #ffffff;
            box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }
        h1 {
            font-size: 28px;
            margin-bottom: 40px;
            color: #F4C447;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 30px;
        }
        th, td {
            padding: 12px 8px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #070726;
            color: #fff;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        .btn-custom {
            background-color: #555;
            color: #fff;
            border: none;
            margin-bottom: 20px;
            padding: 12px 30px;
            font-size: 18px;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .btn-custom:hover {
            background-color: #333;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Квартиру успішно обміняно!</h1>
    <h1>Ваша нова квартира</h1>
    <table>
        <tr>
            <th>Площа</th>
            <th>Номер поверху</th>
            <th>Кількість кімнат</th>
            <th>Район</th>
        </tr>
        <tr>
            <td>${apartment.ownerArea}</td>
            <td>${apartment.ownerFloor}</td>
            <td>${apartment.ownerNumberOfRooms}</td>
            <td>${apartment.ownerDistrict}</td>
        </tr>
    </table>
    <form method="get" action="/menu">
        <button class="btn btn-custom" type="submit">OK</button>
    </form>
</div>
</body>
</html>
