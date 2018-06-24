var example1 = new Vue({
   el: '#example-1',
   data: {
       counter: 0
   }
});

var example2 = new Vue({
   el: '#example-2',
   data: {
       message: '没事别瞎点！'
   },
   //在method对象中定义方法
   methods: {
       greet: function (event) {
           alert('说你呢，'+ this.message);
           if (event){
               alert(event.target.tagName)
           }
       }
   }
});

// 也可以用 JavaScript 直接调用方法   在浏览器中试试
// example2.greet() // => 'Hello Vue.js!'

var example3 = new Vue({
   el: '#example-3',
   methods: {
       say: function (message) {
           alert(message);
       },
       warn: function (message, event) { //保证只有原生DOM事件生效， 在浏览器中试试example3.warn(123, event)
           if (event){
               event.preventDefault();
               alert(message)
           }

       }
   }
});