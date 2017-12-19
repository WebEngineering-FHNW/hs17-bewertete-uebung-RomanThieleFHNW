<html>
<head>
    <meta name="layout" content="main"/>
    <title>Edit Room</title>
</head>

<body>

<div class="row">
    <div class="col-md-6 col-lg-4 ">
        <h1>${room.name}</h1>
        <form action="/lecturer/saveQuestion" method="post" class="form">
            <fieldset class="form padded">
                <div class="form-group">
                    <input type="hidden" name="roomId" id="roomId" value="${room.id}" class="form-control"/>
                    <label>Question Text</label>
                    <input type="text" name="text" class="form-control"/>
                </div>

                <div class="form-group">
                    <g:submitButton name="Submit" value="Create" class="form-control btn-primary"/>
                </div>
            </fieldset>
        </form>

        <div style="color: red">
            <g:renderErrors bean="${question}"/>
        </div>

    </div>
</div>

</body>
</html>