package com.back


class WiseSayingRepository {
    var lastId = 0
    val wiseSayings = mutableListOf<WiseSaying>()

    fun save(wiseSaying: WiseSaying): WiseSaying {

//        if(wiseSaying.isNew()) {
//            wiseSaying.id = ++lastId
//            wiseSayings.add(wiseSaying)
//        }
//        return wiseSaying

        return wiseSaying
            .takeIf { it.isNew() }
            ?.also {
                wiseSaying.id = ++lastId
                wiseSayings.add(wiseSaying)
            } ?: wiseSaying
        // 코틀린을 배워서 사용할려고 했지만 자바방식으로 작성한게 더 명확하고 간단하게 끝나는 경우가 있다.
        // 강사님이 남용의 예시로 작성해 봄. 많은 사람들이 편하게 읽을 수 있는 코드로 작성하는게 좋은 것.
     }

    fun findListDesc() = wiseSayings.toList()

    fun findById(id: Int): WiseSaying? = wiseSayings.firstOrNull { it.id == id }

    fun delete(wiseSaying: WiseSaying) = wiseSayings.remove(wiseSaying)

}
