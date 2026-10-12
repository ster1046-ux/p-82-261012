package com.back

class App {

    fun run() {
        var lastId = 0
        val wiseSayings = mutableListOf<WiseSaying>()

        println("== 명언 앱 ==")
        while (true) {
            print("명령) ")
            val input = readln()

//        if(input == "종료") {
//            break
//        } else if(input == "등록") {
//
//        }
            val rq: Rq = Rq(input)
            val actionName = rq.actionName

            when (input) {
                "종료" -> break
                "등록" -> {
                    print("명언: ")
                    val content = readln()
                    print("작가: ")
                    val author = readln()

                    val id = ++lastId

                    // 강사가 생각하기에 적합한 스코프함수는 also
                    // 대상이 주변부냐 핵심이냐에 따라서 it/this 구분
                    // wiseSayings.add 연산의 주체. wiseSaying이 핵심이 아니기 때문에
                    // 주인공이 아니기 때문에 it으로 받는게 좋겠다고 생각함
                    // 하지만 중요한건 also가 맞다가 아니라 본인이 쓴 함수가 다른 사람에게도 설득력이 있기만 하면 됨.
//                    val wiseSaying = WiseSaying(id, content, author)
//                    wiseSayings.add(wiseSaying)

                    val wiseSaying = WiseSaying(id, content, author).also {
                        wiseSayings.add(it)
                    }


                    println("${wiseSaying.id}번 명언이 등록되었습니다.")
                }
                "목록" -> {
                    println("번호 / 명언 / 작가")
                    println("-------------------")
                    wiseSayings.reversed().forEach {
                        println("${it.id} / ${it.content} / ${it.author}")
                    }
                }

                "삭제" -> {
                    val id = rq.getParamAsInt("id", 0)

                    val wiseSaying = wiseSayings.firstOrNull {
                        it.id == id
                    }

                    if(wiseSaying == null) {
                        println("{$id}번 명언은 존재하지 않습니다.")
                        continue
                    }

                    wiseSayings.remove(wiseSaying)

//                    wiseSayings.removeIf {
//                        it.id == id
//                    }

                    println("${id}번 명언이 삭제되었습니다.")
                }
            }
        }
    }
}