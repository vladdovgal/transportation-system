// When user clicks the button, open the modal

function GetSelectedValue(){
    var e = document.getElementById("status1");
    var result = e.options[e.selectedIndex].value;
    document.getElementById("result").innerHTML = result;
    return result;
}

function openModalInfo(id) {
    let modal = document.getElementById("myModal".concat(id));
    modal.style.display = "block";
}

function closeModalInfo(id) {
    let modal = document.getElementById("myModal".concat(id));
    modal.style.display = "none";

}

// let modal = document.getElementById("myModal".concat(id));

// // When the user clicks anywhere outside of the modal, close it
// window.onclick = function (event) {
//     let modal = document.getElementById("myModal".concat(id));
//     if (event.target == modal) {
//             modal.style.display = "none";
//         }
//     }

