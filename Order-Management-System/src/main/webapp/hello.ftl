<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello ${name}!</title>
</head>
<body>
    <h2>Hello ${name}!</h2>
    <p>
    <#if names?has_content>
    <#list names as nameValue>
      ${nameValue}
    </#list>
    </#if>
    </p>
</body>
</html>