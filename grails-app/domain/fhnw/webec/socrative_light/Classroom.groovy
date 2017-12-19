package fhnw.webec.socrative_light

class Classroom {

    String name

    static hasMany = [questions: Question]

    static mapping = {
        questions cascade: 'all-delete-orphan'
    }

    static constraints = {
        name blank: false
    }
}
