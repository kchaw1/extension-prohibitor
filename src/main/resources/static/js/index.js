$(document).ready(function () {

    $(document).on('change','.basic-ext-checkbox', function () {
        if($(this).is(":checked")) {
            saveBasicExtension($(this).val())
        } else {
            removeBasicExtension($(this).val())
        }
    });

    $('.btn-custom-add').click(function () {
        customAddEvent();
    });

    getBasicExtension();
    getCheckedBasicExtension();
    getCustomExtension();
})

function customAddEvent() {
    let $input = $('#custom-ext-input');
    let value = $input.val();
    if(value === "") {
        alert("커스텀 확장자를 입력해주세요");
    } else {
        saveCustomExtension(value);
        getCustomExtension();
        $('#custom-ext-input').val("");
    }
}

function removeCustomExtension(extension) {
    let body = {"extension": extension};
    ajaxSend("/extension/custom", "delete", body, alertMessage);
    getCustomExtension();
}

function getCustomExtension() {
    ajaxSend("/extension/custom", "get", "", addCustomExtension);
}

function addCustomExtension(result) {
    console.log(result);
    $('.custom-ext-list').empty();
    let data = result.data;
    for(let i=0; i<data.length; i++) {
        let extension = data[i].extension;
        let customExt =
            `<div class="custom-ext">
                    ${extension}
                    <a href="javascript:removeCustomExtension('${extension}')" class="btn-custom-remove">X</a>
                </div>`
        $('.custom-ext-list').append(customExt);
    }
}

function saveCustomExtension(extension) {
    let body = {"extension": extension}
    ajaxSend("/extension/custom", "post", body, alertMessage);
}

function saveBasicExtension(codeName) {
    let body = {"codeName": codeName}
    ajaxSend('/extension/basic', 'post', body, alertMessage)
}

function removeBasicExtension(codeName) {
    let body = {"codeName": codeName}
    ajaxSend('/extension/basic', 'delete', body, alertMessage)
}

function alertMessage(result) {
    alert(result.message);
}

function getCheckedBasicExtension() {
    ajaxSend("/extension/basic", "get", "", checkBasicExtension);
}

function checkBasicExtension(result) {
    let data = result.data;
    for(let i=0; i<data.length; i++) {
        let codeName = data[i].codeName;
        let checkboxList = document.getElementsByClassName("basic-ext-checkbox");
        for(let j=0; j<checkboxList.length; j++) {
            if(checkboxList[j].value === codeName) {
                checkboxList[j].checked = true;
            }
        }
    }
}

function getBasicExtension() {
    let body = {"groupName": "FILE_EXTENSION"}
    ajaxSend("/code", "post", body, addBasicExtension);
}

function addBasicExtension(result) {
    let data = result.data;
    for(let i=0; i<data.length; i++) {
        let id = data[i].id;
        let name = data[i].name;
        let description = data[i].description;
        let checkbox = `<div class='basic-ext'>
                                <label for="${id}">
                                <input type="checkbox" class="basic-ext-checkbox" value="${name}" />${description}
                                </label>
                            </div>`
        $(".basic-ext-list").append(checkbox);
    }
}

function ajaxSend(url, method, body, callback) {
    $.ajax({
        url: url,
        method: method,
        contentType: "application/json",
        async: false,
        data: JSON.stringify(body),
        success: function (result) {
            callback(result);
        }
    })
}