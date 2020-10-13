package com.todolist.data

//클래스 앞에 data를 붙이면 getter setter 자동 생성됨
//데이터 클래스의 생성자에서 값을 넣어주면 이 값이 기본값으로 설정됨
//isDone을 false로 해놨으니 기본값이 false고 생성할 때 입력 안해도됨
data class Todo(
    val text: String,
    var isDone: Boolean = false
    )