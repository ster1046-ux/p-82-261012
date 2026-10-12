package com.back

class App(
    val wiseSayingController: WiseSayingController,
    val systemController: SystemController = SystemController()
) {

    fun run() {

        println("== 명언 앱 ==")
        while (true) {
            print("명령) ")

            val input = readln()

            val rq: Rq = Rq(input)
            val actionName = rq.actionName

            when (actionName) {
                "종료" -> systemController.exit()
                "등록" -> wiseSayingController.write()
                "목록" -> wiseSayingController.list()
                "삭제" -> wiseSayingController.delete(rq)
            }
        }
    }
}