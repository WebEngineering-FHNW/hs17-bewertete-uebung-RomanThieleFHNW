<html>
<head>
    <meta name="layout" content="main"/>
    <title>List of all Questions</title>
</head>

<body>
<div class="jumbotron">
    <h1>List of Rooms</h1>
</div>
<ul>
    <g:each var="room" in="${classrooms}">
        <li><a href="CreateQuestion?id=${room.id}">${room.name}</a></li>
    </g:each>
</ul>
<a href="createRoom">Create new classroom</a>
</body>

</html>