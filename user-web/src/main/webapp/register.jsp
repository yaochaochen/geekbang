<head>
    <jsp:directive.include file="/WEB-INF/jsp/prelude/include-head-meta.jspf"/>
    <title>register 用户注册</title>
</head>
<body style="text-align: center">
<form action="/register/submit" method="post">
    userName:&nbsp;&nbsp;<input type="text" name="userName" placeholder="input userName"/> <br/>
    password:&nbsp;&nbsp;<input type="password" name="password" placeholder="input password"/><br/>
    email:&nbsp;&nbsp;<input type="text" name="email" placeholder="input email"/><br/><br/>
    <input type="submit" value="submit">
</form>
</body>