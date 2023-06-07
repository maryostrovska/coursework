<html>
<body>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<div class="form-group">
    <form action="/findByArea" method="post">
        <input placeholder="Площа" name="OwnerArea">
        <button type="submit">Відправити</button>
    </form>
    <#if error?has_content>
        <ul class="text-danger">
                <li>${error.defaultMessage}</li>
        </ul>
    </#if>
</div>
</body>
</html>