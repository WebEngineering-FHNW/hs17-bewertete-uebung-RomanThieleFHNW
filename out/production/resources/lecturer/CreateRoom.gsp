<html>
<head>
    <meta name="layout" content="main"/>
    <title>Create Room</title>
</head>

<body>

<div class="row">
    <div class="col-md-6 col-lg-4 ">
        <form action="/lecturer/saveRoom" method="post" class="form">
            <fieldset class="form padded">
                <div class="form-group">
                    <label>Room name</label>
                    <input type="text" name="name" class="form-control"/>
                </div>

                <div class="form-group">
                    <g:submitButton name="Submit" value="Create" class="form-control btn-primary"/>
                </div>
            </fieldset>
        </form>

        <div style="color: red">
            <g:renderErrors bean="${room}"/>
        </div>

    </div>
</div>

</body>
</html>