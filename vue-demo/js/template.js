var obj = {
    foo: 'bar'
};

Object.freeze(obj);

new Vue({
    el: '#app',
    data: obj
});


var data = { a: 1 };
var vm = new Vue({
    el: '#example',
    data: data
});

// 当a的值改变后触发此方法
vm.$watch('a', function (newValue, oldValue) {
    alert(newValue+"---"+oldValue);
});

// 测试v-html
var data = { rawHtml: '<span style="color:red">这应该是红色的</span>'};
var app1 = new Vue({
   el:'#app-1',
   data: data
});

//测试绑定属性到标签上
var app2 = new Vue({
   el: '#app-2',
   data: {
       dynamicId: 'test'
   }
});

// 测试JavaScript 表达式支持
var app3 = new Vue({
   el: '#app-3',
   data: {
       number: 1,
       ok: true,
       message: 'abcdefg'
   }
});