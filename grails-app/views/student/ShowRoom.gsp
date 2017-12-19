<html>
<head>
    <meta name="layout" content="main">
    <title>${room.name}</title>
</head>
<body>
<div class="jumbotron">
    <h1>${room.name}</h1>
</div>
<form action="/student/answerQuestions" method="post">
    <g:each var="question" in="${room.questions}">
        <div class="panel panel-default">
            <div class="panel-heading">${question.text}</div>
        </div>

        <div class="answer-list">
            <h3>Answers:</h3>
            <input type="hidden" name="question_ids" value="${question.id}" />
            <g:each var="answer" in="${question.answers}">
                <div class="checkbox">
                    <label>
                        <input type="checkbox" name="answerIds_${question.id}" value="${answer.id}" />
                        ${answer.text}
                    </label>
                </div>
            </g:each>
        </div>
    </g:each>
    <g:submitButton name="Submit" value="Submit"  class="btn btn-primary" />
</form>
</body>

</html>