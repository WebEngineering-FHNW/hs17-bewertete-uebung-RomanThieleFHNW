<div>
    <div class="panel panel-default">
        <div class="panel-heading">Question ${question.id}</div>

        <div class="panel-body">${question.text}</div>
    </div>

    <div class="option-list">
        <h3>Answers:</h3>
        <g:if test="${question.options.size() > 0}">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Answer</th>
                    <th>Correct</th>
                </tr>
                </thead>
                <tbody>
                <g:each var="option" in="${question.options}">
                    <tr>
                        <td>
                            ${option.text}
                        </td>
                        <g:if test="${option.isCorrect}">
                            <td class="success">
                                Yes
                            </td>
                        </g:if>

                        <g:else>
                            <td class="danger">
                                No
                            </td>
                        </g:else>

                        <g:if test="${answerCount != null}">
                            <td>
                                ${answerCount[option.id]}
                            </td>
                        </g:if>
                        <td>
                            <form action="/lecturer/removeOption/${option.id}" method="post">
                                <input type="submit" value="Remove" class="btn btn-danger"/>
                            </form>
                        </td>
                    </tr>
                </g:each>
                </tbody>
            </table>
        </g:if>
        <g:else>
            <p>
                There are currently no answers registered for the current question
            </p>
        </g:else>
    </div>
</div>