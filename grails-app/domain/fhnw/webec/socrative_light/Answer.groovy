package fhnw.webec.socrative_light

class Answer {

    static belongsTo = [option: Option]

    Question question

    int submissionId

    static constraints = {
        option nullable: false
        question nullable: false
    }
}
