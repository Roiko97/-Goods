var bussessObj = function () {
    this.nearMerchant = new Array();
    this.count = 0;
}

bussessObj.prototype.init = function () {
    this.requirItem();
}
bussessObj.prototype.requirItem = function () {
    var obj = this;
    $.ajax({
        url: 'getNearMerchantServlet',
        type:'post',
        dataType: 'json',
        dat: {
        },
        success: function (res) {
            var json = eval(res);
            console.log(json);
            obj.setObj(json);
        },
        error: function (res) {
            alert("网络错误");
        }
    });
}

bussessObj.prototype.setObj = function(obj){
    this.nearMerchant = obj.nearMerchant;
    console.log(this.nearMerchant);
    for(x in this.nearMerchant){
        this.createItem(x)
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
    span_3_2.innerHTML = '地址:' +  this.nearMerchant[x].address;
    span_3_3.innerHTML = '电话:' + this.nearMerchant[x].phone;

    div_2_2.appendChild(span_3_1);
    div_2_2.appendChild(span_3_2);
    div_2_2.appendChild(span_3_3);
    div_1.appendChild(div_2_1);
    div_1.appendChild(div_2_2);

    var main = document.getElementsByClassName('flex-content');
    main[0].appendChild(div_1);
    if(x / 4 == 0 && x != 0){
        var hr = document.createElement('hr');
        hr.setAttribute('class','hr0');
        main[0].appendChild(hr);
    }
    this.count++;
}
