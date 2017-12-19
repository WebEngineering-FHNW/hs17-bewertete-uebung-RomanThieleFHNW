package fhnw.webec.socrative_light

class Question {
    String text;

    static belongsTo = [room: Classroom]
    static hasMany = [options: Option]

    static mapping = {
        options cascade: 'all-delete-orphan'
    }

    static constraints = {
        text blank: false
        room nullable: false
    }
}
