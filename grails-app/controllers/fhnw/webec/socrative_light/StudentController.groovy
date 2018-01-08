package fhnw.webec.socrative_light

import grails.transaction.Transactional

class StudentController {

    def socrativeService

    /**
     * List of available rooms
     * @return
     */
    def index() {
        render view: "index", model: [classrooms: socrativeService.getRooms()]
    }
    /**
     * Enter room
     * @param room to enter
     * @return view
     */
    def showRooom(Classroom room) {
        render view: "ShowRoom", model: [room: room]
    }

    /**
     * Saves selected option
     */
    @Transactional
    def answerQuestions() {
        def questionIds = params.list("questionIds")
        for (id in questionIds) {
            if (socrativeService.getQuestion(id) != null) {
                List<String> answerIds = params.list("answerIds_" + id)
                socrativeService.saveAnswer(id, answerIds)
            }
        }
        def room = socrativeService.getQuestion(questionIds.first()).room

        redirect( action: "index")
    }
}
