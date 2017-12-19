package fhnw.webec.socrative_light

import grails.transaction.Transactional

class LecturerController {

    def socrativeService

    def index() {
        render view: "index", model: [classrooms: socrativeService.getRooms()]
    }

    def createRoom() {
        render view: "CreateRoom"
    }

    @Transactional
    def saveRoom(Classroom room) {
        if (room.hasErrors()) {
            respond room.errors, view: 'CreateRoom'
        } else {
            socrativeService.saveRoom(room)
            redirect(action: "createQuestion", id: room.id)
        }
    }

    def createQuestion(Classroom room) {
        render view: "CreateQuestion", model: [room: room]
    }

    @Transactional
    def saveQuestion() {
        def room = socrativeService.getRoom(params.roomId)
        def question = new Question(text: params.text, room: room)
        if (question.hasErrors()) {
            respond question.errors, view: 'CreateQuestion', model: [room: room]
        } else {
            socrativeService.saveQuestion(question)
            redirect(action: "editQuestion", id: question.id)
        }
    }

    def editQuestion(Question question) {
        render view: "EditQuestion", model: [question: question]
    }

    /**
     * Adds an option
     * @return
     */
    @Transactional
    def addOption() {
        def isCorrect = false
        if (params.isCorrect != null) {
            isCorrect = true
        }

        def question = socrativeService.getQuestion(params.questionId)
        if (question != null) {
            def option = new Option(question: question, isCorrect: isCorrect, text: params.text)
            if (option.hasErrors()) {
                respond option.errors, view: 'show', id: params.questionId
            } else {
                socrativeService.saveOption(option)
                redirect(action: "editQuestion", id: params.questionId)
            }
        }
    }

    /**
     * Removes an option
     * @param option
     * @return
     */
    @Transactional
    def removeOption(Option option) {
        if(option.id != null)
        {
            socrativeService.deleteOption(option.id)
        }
        redirect action: "editQuestion", id: option.question.id
    }

}
