var bussessObj = function () {
    this.nearMerchant = new Array();
    this.count = 0;
}

bussessObj.prototype.init = function () {
    this.requirItem();
    window.addEventListener('scroll', debounce(loadInformation, 1000));
}
bussessObj.prototype.requirItem = function () {
    var obj = this;
    $.ajax({
        url: 'getNearMerchantServlet',
        type: 'post',
        dataType: 'json',
        dat: {},
        success: function (res) {
            var json = eval(res);
            obj.setObj(json);
        },
        error: function (res) {
            alert("网络错误");
        }
    });
}

bussessObj.prototype.setObj = function (obj) {
    this.nearMerchant = obj.nearMerchant;
    this.showObj();
}
bussessObj.prototype.showObj = function () {
    let start = this.count;
    let end = this.count + 8 <= this.nearMerchant.length ? this.count + 8 : this.nearMerchant.length;
    for (let i = start; i < end; i++) {
        this.createItem(i);
    }
}
bussessObj.prototype.createItem = function (x) {
    var div_1 = document.createElement('div');
    div_1.setAttribute('class', 'flex-item item-img-one item-img');

    var div_2_1 = document.createElement('div');
    var div_2_2 = document.createElement('div');
    div_2_1.setAttribute('class', 'flex-item-null');
    div_2_2.setAttribute('class', 'flex-item-span');

    var span_3_1 = document.createElement('span');
    var span_3_2 = document.createElement('span');
    var span_3_3 = document.createElement('span');

    span_3_1.setAttribute('class', 'item-name');
    span_3_2.setAttribute('class', 'item-address');
    span_3_3.setAttribute('class', 'item-phone');

    span_3_1.innerHTML = this.nearMerchant[x].name;
    span_3_2.innerHTML = '地址:' + this.nearMerchant[x].address;
    span_3_3.innerHTML = '电话:' + this.nearMerchant[x].phone;

    div_2_2.appendChild(span_3_1);
    div_2_2.appendChild(span_3_2);
    div_2_2.appendChild(span_3_3);
    div_1.appendChild(div_2_1);
    div_1.appendChild(div_2_2);

    var main = document.getElementsByClassName('flex-content');
    if (Math.floor(x % 4) == 0 && x > 3) {
        var hr = document.createElement('hr');
        hr.setAttribute('class', 'hr0');
        main[0].appendChild(hr);
    }
    main[0].appendChild(div_1);
    this.count++;
}

function loadInformation() {
    let wScrollY = window.screenY;
    let wInnerH = window.innerHeight;
    let bScrollH = document.body.scrollHeight;
    if (wScrollY + wInnerH >= bScrollH) {
        bussness.showObj();
    }
}

function debounce(fn, delay) {
    let timer = null;
    return function () {
        let context = this;
        let args = arguments;
        clearTimeout(timer);
        timer = setTimeout(function () {
            fn.apply(context, args);
        }, delay);
    }
}