package com.back

class Rq(
    val cmd: String,
) {
    val actionName : String
    val paramMap: Map<String, String>
// 주 생성자에 넣어도 되고 나중에 넣어도 된다.

    init {
        val cmdBits = cmd.split("?")
        actionName = cmdBits[0]

        paramMap = if (cmdBits.size == 2) {

            cmdBits[1]
                .split("&")
                .mapNotNull {  // aaa=bbb
                    val paramBits = it.split("=")
                    if(paramBits.size == 2) {
                        paramBits[0] to paramBits[1]
                    } else {
                        null
                    }
                }
                .toMap()
        } else {
            emptyMap()
        }
    }

    fun getParam(key: String, defaultValue: String): String {
        return paramMap[key] ?: defaultValue
    }

    fun getParamAsInt(key: String, defaultValue: Int): Int {
        return paramMap[key]?.toIntOrNull() ?: defaultValue
    }
}