new Vue({
   el: '#demo-1',
   data: {
       parentMessage: 'Parent',
       items: [
           { message: '小明' },
           { message: '静静' }
       ]
   }
});

var vue1 = new Vue({
   el: '#demo-2',
   data:{
       objects: [
           {
               id: 1,
               firstName: 'John1',
               lastName: 'Doe1',
               age: 301
           },
           {
               iud: 2,
               firstName: 'John2',
               lastName: 'Doe2',
               age: 302
           },
           {
               id: 3,
               firstName: 'John3',
               lastName: 'Doe3',
               age: 303
           }
       ]
   }
});

var vue3 = new Vue({
   el: '#demo-3',
   data: {
       numbers:[1,2,3,4,5,6,7,8]
   } ,
    computed: {
       evenNumbers: function () {
           return this.numbers.filter(function (number) {
               return number % 2 === 0
           })
       }
    },
    methods: {
       even: function(numbers){
           return numbers.filter(function (number) {
               return number % 2 === 1
           })
       }
    }
});

var env4 = new Vue({
   el: '#demo-4'
});

Vue.component('todo-item', {
    template: '\
    <li>\
        {{ title }}\
        <button v-on:click="$emit(\'remove\')">Remove</button>\
    </li>',
    props: ['title']
});

new Vue({
   el: '#todo-list-example',
    data: {
       newTodoText: '',
        todos: [
            {
                id: 1,
                title: "AAA"
            },
            {
                id: 2,
                title: "BBB"
            },
            {
                id: 3,
                title: "CCC"
            }
        ],
        nextTodoId: 4
    },
    methods: {
       addNewTodo: function () {
           this.todos.push({
               id: this.nextTodoId++,
               title: this.newTodoText
           });
           this.newTodoText = ''
       }
    }
});