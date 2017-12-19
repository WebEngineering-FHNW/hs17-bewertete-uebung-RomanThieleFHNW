package fhnw.webec.socrative_light

import grails.transaction.Transactional

@Transactional
class SocrativeService {
    static allowedMethods = [getRooms: "POST",
                             getRoom: "POST",
                             saveRoom: "POST",
                             deleteRoom: "POST",
                             getQuestion: "POST",
                             saveQuestion: "POST",
                             deleteQuestion: "POST",
                             saveOption: "POST",
                             getOption: "POST",
                             saveAnswer: "POST",
                             deleteOption: "POST"]

    def getRooms() {
        return Classroom.getAll()
    }

    def getRoom(id) {
        return Classroom.get(id)
    }

    def saveRoom(Classroom classroom) {
        classroom.save flush: true
    }

    def deleteRoom(id) {
        if (Room.exists(id)) {
            def o = Room.get(id)
            o.delete()
        }
    }

    def getQuestion(id) {
        return Question.get(id)
    }

    def saveQuestion(Question question) {
        question.save flush: true
    }

    def deleteQuestion(id) {
        if (Question.exists(id)) {
            def o = Question.get(id)
            o.delete()
        }
    }

    def saveOption(Option option) {
        option.save(flush: true)
    }

    def deleteOption(id) {
        if (Option.exists(id)) {
            def o = Option.get(id)
            o.delete()
        }
    }

    def getOption(id) {
        return Option.get(id)
    }

    def saveAnswer(questionId, optionIds) {
        def question = getQuestion(questionId)
        if (SubmittedAnswer.count() > 0) {
            newId = Answer.last().submissionId + 1;
        }
        for (optionId in optionIds) {
            def option = getOption(optionId)
            def answer = new Answer(question: question, option: option, submissionId: newId)
            answer.save(flush: true, failOnError: true)
        }
    }

}
