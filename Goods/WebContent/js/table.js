let map = new Map(); //申请、发布的数据存储
let num = 0; //DIY行数
let content_list; //查看、申请表的显示数据
let id = -1;
let types = 1;
const url = location.href;
let result;
let academic;
//初始化
function init() {
    if (url.indexOf('?') < 0 || url.indexOf('flag') < 0) {
        alert("访问失败！");
        location.href = "on.jsp";
    }
    result = url.split('?')[1];
    let flag = Number(result.split('&')[0].split('=')[1]);
    getFlag = function () {
        return flag;
    };
    requirList(Status);
}
//设置类型
function changeType(objs){
    types = objs.value;
}
//请求学术数据
function requirList(callback) {
    var url = 'GetAcademicInfoServlet';
    $.ajax({
        url: url,
        type: 'post',
        dataType: 'json',
        data: {
            'types': Number(types),
        },
        success: function (res) {
            let json = eval(res);
            if ($.isEmptyObject(json.allAcademic)) {
                alert('数据异常！');
                return;
            }
            academic = json.allAcademic;
            callback();
        },
        error: function () {
            alert('网络中断，未能响应服务器请求！');
        }
    })
}
//表格状态控制
function Status() {
    const flag = getFlag();
    switch (flag) {
        case 0:
            {
                hiddenInput();
                break;
            }
        case 1:
            {
                id = Number(result.split('&')[1].split('=')[1]);
                types = Number(result.split('&')[2].split('=')[1]);
                content_list = academic[id];
                showInput();
                break;
            }
        case 2:
            {
                id = Number(result.split('&')[1].split('=')[1]);
                types = Number(result.split('&')[2].split('=')[1]);
                seeList();
                content_list = academic[id];
                break;
            }
    }
}
//隐藏可填写表格
function hiddenInput() {
    let input = $('tbody').find('input');
    let select = $('tbody').find('select');
    let array = new Array();
    array.push(input, select);
    for (let ar of array) {
        for (let list of ar) {
            list.disabled = true;
        }
    }
}

//显示可填写表格
function showInput() {
    $('tfoot').find('button').eq(0).hide();
    $('tfoot').find('button').eq(1).hide();
    $('tfoot').find('button').eq(2).attr('onclick', "applySubmit()");

    // for(let objS of content_list){
    //     createRow();
    // }
}

//查看详细表格
function seeList() {
    let input = $('tbody').find('input');
    let select = $('tbody').find('select');
    let textarea = $('tbody').find('textarea');
    let btnGroup = $('tbody').find('button');
    let array = new Array();
    array.push(input, select, textarea);
    for (let ar of array) {
        for (let list of ar) {
            list.disabled = true;
        }
    }
    $('tfoot').find('button').eq(0).hide();
    $('tfoot').find('button').eq(1).hide();
    $('tfoot').find('button').eq(2).hide();
    for (let objS of content_list) {
        createRow(objS.name, objS.choose, objS.anotation, objS.select1, objS.select2);
    }

}
//判断是否为空
function isEmpty() {
    let start = $('tbody').find('tr').length - 1;
    let end = $('tbody').find('tr').length - num;
    console.log(start);
    console.log(end);
    for (let z = start; z >= end; z--) {
        console.log($('tbody').find('tr').eq(z).find('td'));
        for (let i of $('tbody').find('tr').eq(z).find('td'))
        {
            console.log(i.children);
            if (i.children.length < 2) {
                if ($.isEmptyObject(i.children[0].value)) {
                    return true;
                }
            } else {
                for (var j = 0; j < i.children.length - 1; j++) {
                    if ($.isEmptyObject(i.children[j].children[1].value)) {
                        return true;
                    }
                }
            }
        }
    }
    return false;
}
//添加行
function addTr() {
    if ($('tbody').find('tr').length > 5) {
        if (isEmpty()) {
            alert('请填写完成DIY行信息');
            return;
        }
    }
    let tr = $('<tr></tr>');
    let td_name = $('<td></td>');
    let td_content = $('<td></td>');
    let td_anotation = $('<td></td>');

    let input_anotation = $('<textarea></textarea>');
    let select_content = $('<select></select>');
    let input_name = $('<input>');

    let option_1 = $('<option></option>');
    let option_2 = $('<option></option>');
    let option_3 = $('<option></option>');

    input_name.attr('class', "col-md-12");
    input_name.attr('name', "name");
    input_name.attr('maxlength', "15");
    input_name.attr('placeholder', "限制15字符");
    input_name.attr('onchange', "setInformation(this)");

    input_anotation.attr('class', "col-md-12");
    input_anotation.attr('rows', "5");
    input_anotation.attr('cols', "5");
    input_anotation.attr('name', "anotation");
    input_anotation.attr('placeholder', "限制250字符,例如'请说出你擅长的科目'");
    input_anotation.attr('onchange', "setInformation(this)");

    select_content.attr('class', 'col-md-12');
    select_content.attr('name', 'choose')
    select_content.attr("onchange", "selectSet(this)");

    option_1.attr('value', 'input');
    option_2.attr('value', 'textarea');
    option_3.attr('value', 'select');
    option_1.html('单行输入框，最高50字符');
    option_2.html('多行输入框，最高250字符');
    option_3.html('下拉框，例如性别选择');

    select_content.append(option_1);
    select_content.append(option_2);
    select_content.append(option_3);

    td_name.append(input_name);
    td_content.append(select_content);
    td_anotation.append(input_anotation);
    tr.append(td_name);
    tr.append(td_content);
    tr.append(td_anotation);
    $('tbody').append(tr);
    num++;
}
//根据选择的框体，进行属性设置
function selectSet(objS) {
    let choose = objS.value;
    let perant = objS.parentNode;
    setInformation(objS);
    if (choose == 'select') {
        let div_1 = document.createElement('div');
        let div_2 = document.createElement('div');

        let input_1 = document.createElement('input');
        let input_2 = document.createElement('input');

        let label_1 = document.createElement('label');
        let label_2 = document.createElement('label');

        let button = document.createElement('button');

        label_1.innerHTML = '第一个：';
        label_2.innerHTML = '第二个：';

        input_1.setAttribute('name', 'select_1');
        input_2.setAttribute('name', 'select_2');

        input_1.setAttribute('onchange', 'setInformation(this)');
        input_2.setAttribute('onchange', 'setInformation(this)');

        div_1.setAttribute('class', 'col-md-8');
        div_2.setAttribute('class', 'col-md-8');
        button.setAttribute('class', 'btn btn-danger');
        button.innerHTML = '取消';
        button.setAttribute('onclick', "cancelSet(this)");

        while (perant.hasChildNodes()) {
            perant.removeChild(perant.firstChild);
        }
        div_1.appendChild(label_1);
        div_1.appendChild(input_1);
        div_2.appendChild(label_2);
        div_2.appendChild(input_2);
        perant.appendChild(div_1);
        perant.appendChild(div_2);
        perant.appendChild(button);
    }
}

function cancelSet(objS) {
    let perant = objS.parentNode;
    let child = perant.childNodes;
    while (perant.hasChildNodes()) {
        perant.removeChild(perant.firstChild);
    }

    let select_content = document.createElement('select');

    let option_1 = document.createElement('option');
    let option_2 = document.createElement('option');
    let option_3 = document.createElement('option');

    option_1.setAttribute('value', 'input');
    option_2.setAttribute('value', 'textarea');
    option_3.setAttribute('value', 'select');
    option_1.innerHTML = '单行输入框，最高50字符';
    option_2.innerHTML = '多行输入框，最高250字符';
    option_3.innerHTML = '下拉框，例如性别选择';

    select_content.setAttribute('class', 'col-md-12');
    select_content.setAttribute('name', 'content')
    select_content.setAttribute("onchange", "selectSet(this)");

    select_content.appendChild(option_1);
    select_content.appendChild(option_2);
    select_content.appendChild(option_3);

    perant.appendChild(select_content);
}
//设置map信息
function setInformation(objS) {
    if (!$.isEmptyObject(objS.value))
        map.set(objS.name + "_" + num, objS.value);

}
//申请提交
function applySubmit() {
    let url = "AcademicServlet";
    let flag = getFlag();

    var form = document.createElement("form");
    form.setAttribute("action", url);
    form.setAttribute("method", "post");
    form.style.display = "none";

    map.set('flag', flag);
    map.set('username', $("input[name='username']").val());
    map.set('confact', $("input[name='confact']").val());
    map.set('grade', $("select[name='grade']").val());
    map.set('sex', $("select[name='sex']").val());
    map.set('major', $("select[name='major']").val());


}
//发布提交
function submit() {
    let flag = getFlag();
    let url = "AcademicServlet?flag="+flag;

    var form = document.createElement("form");
    form.setAttribute("action", url);
    form.setAttribute("method", "post");
    form.style.display = "none";

    map.set('types',types);
    
    //追加参数
    for (var entry of map) {
        var param_input = document.createElement("input");
        param_input.setAttribute("type", "text");

        param_input.setAttribute("name", entry[0]);
        param_input.setAttribute("value", entry[1]);
        form.appendChild(param_input);
    }
    
    //body追加form表单
    document.body.appendChild(form);

    form.submit();//提交(注意，这里的提交调用者是form表单，不是submit按钮)
}
//返回
function out() {
    window.history.back();
}
//删除行
function removeTr() {
    if ($('tbody').find('tr').length > 5) {
        $('tbody').find('tr').last().remove();
        map.delete('name_' + num);
        if (map.get('choose_' + num) == 'select') {
            map.delete('select_1_' + num);
            map.delete('select_2_' + num);
        }
        map.delete('choose_' + num);
        map.delete('anotation_' + num);
        num--;
    }
}
//创建对应行
function createRow(nameText, choose, anotation, select1, select2) {
    num++;
    let tbody = $('tbody');

    let tr = $('<tr></tr>');
    let td_name = $("<td></td>");
    let td_content = $('<td></td>');
    let td_anotation = $('<td></td>');

    let label = $('<label></label>');
    label.attr('for', 'name_' + num);
    label.html(nameText);

    switch (choose) {
        case 'input':
            let content = $('<input>');
            content.attr('maxlength', '50');
            break;
        case 'textarea':
            let content = $('<textarea></textarea>');
            content.attr('cols', '10');
            content.attr('rows', '5');
            content.attr('maxlength', '250');
            break;
        case 'slect':
            let content = $('<select></select>');
            let option_1 = $('<option></option>');
            let option_2 = $('<option></option>');
            option_1.attr('value', 0);
            option_2.attr('value', 1);
            option_1.html(select1);
            option_2.html(select2);
            break;
    }
    content.attr('name', 'name_' + num);
    content.attr('id', 'name_' + num);
    content.attr('class', 'col-md-8 col-md-offset-2');
    content.attr('required', 'required');
    content.attr('placeholder', '请输入');

    td_name.attr('class', 'text-center');
    td_content.attr('class', 'text-center');
    td_anotation.attr('class', 'text-center');

    td_name.append(label);
    td_content.append(content);
    td_anotation.html(anotation);

    tr.append(td_name);
    tr.append(td_content);
    tr.append(td_anotation);

    tbody.append(tr);
}