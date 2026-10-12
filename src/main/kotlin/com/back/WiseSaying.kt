package com.back

data class WiseSaying(
    var id: Int = 0,
    var content: String,
    var author: String

    // 코틀린이 추구하는 데이터 클래스의 불변을 위해 val가 더 합리적이지만
    // entity 처럼 사용하기 위해서 var를 이용
    // val를 이용하고 밑에서 copy를 쓰는 방식이 더 코틀린스러우나
    // JPA를 어차피 써야되기 때문에 수정할 수 있는게 나아서 VAR 사용
) {

    constructor(content: String, author: String) : this(0, content, author)

    fun modify(newContent: String, newAuthor: String): WiseSaying {
        this.content = newContent
        this.author = newAuthor
        return this
    }

    fun isNew(): Boolean {
        return id == 0
    }

}
