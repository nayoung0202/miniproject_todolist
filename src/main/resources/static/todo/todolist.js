const API = "/api/todos"
let main = document.querySelector("#todos");


async function getList(){

    let res = await fetch(API);
    let data = await res.json();


    //ul태그 초기화
    document.querySelector("#todos").innerHTML = "";

    for(let result of data){

        // console.log(sessionId);
        // console.log(result.memberId);
        if(sessionId == result.memberId){

            //memberId와 id가 같은 todolist를 보여달라는 조건을 써야함
            let done = result.done;
            let HTML =
                `
            <li class= "${done == true ? "completed" : ""}">${result.content}
            <input type="hidden" value="${result.id}"></li>
            `;
            main.innerHTML += HTML;
        }
    }
}
getList();

document.forms[0].addEventListener("submit", (e) =>{
    e.preventDefault();
    let keyword = document.querySelector('input');
    let value = keyword.value;
    // console.log(value);
    addTodo(value);
})

async function addTodo(value){
    let res = await fetch("api/todos", {
      method : "POST",
      headers : {
          "Content-Type": "application/json"
      },
      body : JSON.stringify({
          //id는 서버에 위임
          content: value,
          done: false,
          memberId: sessionId
      }),
    }).then(res => getList());
    //then : 기다렸다가 호출된 함수를 진행하겠다
    //검색한 기록이 검색창에 떠있지 않게
    //fetch가 완전히 끝난후에는 value를 지워주어야 함
    document.getElementById("input").value = "";
}


//마우스 우클릭 시 메뉴 해제
window.oncontextmenu = function (){
    return false;
}

let ul = document.querySelector('#todos');
ul.addEventListener("mousedown", (event) => {
    if (event.button === 2 || event.which === 3){
        //우클릭 시 삭제
        //console.log(event.target)
        event.target.remove();
        let delElem = event.target.childNodes[1].value; //todos id
        console.log(delElem);
        deleteTodo(delElem);
    } else {
        //좌클릭 시 취소선
        if(event.target.className == ""){
            event.target.className += "completed";
            let chkValue = event.target.childNodes[1].value; //todos id
            updateTodo_T(chkValue);
        } else  {
            event.target.className = "";
            let chkValue = event.target.childNodes[1].value;
            updateTodo_F(chkValue);
        }
    }
})

async function updateTodo_T(chkValue){
    let res = await fetch("api/todos/" + chkValue, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            id: chkValue,
            done: true
        }),
    })
}

async function updateTodo_F(chkValue){
    let res = await fetch("api/todos/" + chkValue, {
        method: "PUT",
        // headers: {
        //     "Content-Type": "application/json"
        // },
        // body: JSON.stringify({
        //     id: chkValue,
        //     done: false
        // }),
    })
}

async function deleteTodo(delElem){
    let res = await fetch("api/todos/" + delElem, {
        method: "DELETE",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            id: delElem
        }),
    })
}