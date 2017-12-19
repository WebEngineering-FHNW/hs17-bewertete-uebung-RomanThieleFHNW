package fhnw.webec.socrative_light

class Option {

    String text;
    Boolean isCorrect;

    static belongsTo = [question: Question]
    static hasMany = [answers: Answer]

    static mapping = {
        answers cascade: 'all-delete-orphan'
    }

    static constraints = {
        text blank: false
        question nullable: false
    }
}
