var app = new Vue({
    el: '#app',
    data: {
        message: 'hello World!'
    }
});

var app2 = new Vue({
    el: '#app-2',
    data: {
        message: '页面加载于' + new Date().toLocaleString()
    }
});

var app3 = new Vue({
    el: '#app-3',
    data: {
        seen: true
    }
});

var app4 = new Vue({
   el: '#app-4',
    data: {
       todos: [
           {text:"Java"},
           {text:"Python"},
           {text:"C++"}
       ]
    }
});

var app5 = new Vue({
   el: '#app-5',
   data: {
       message: 'Hello Vue.js!'
   },
    methods:{
       reverseMessage: function(){
           this.message = this.message.split('').reverse().join('')
       }
    }
});

var app6 = new Vue({
   el: '#app-6',
   data: {
       message: 'Hello Vue!'
   }
});

Vue.component('todo-item', {
    template: '<li>这是一个待办项</li>'
});

var app7 = new Vue({
    el: '#app-7'
});


Vue.component('test-item', {
    //'props',类似于一个自定义特性。
    //这个prop名为todo
    props: ['test'],
    template: '<li>{{test.text}}</li>'
})

var app8 = new Vue({
    el: '#app-8',
    data: {
        groceryList: [
            { id: 0, text: '蔬菜' },
            { id: 1, text: '奶酪' },
            { id: 2, text: '随便其它什么人吃的东西' }
        ]
    }
})