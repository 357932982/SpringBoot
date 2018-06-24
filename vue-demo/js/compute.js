var vm = new Vue({
   el: '#example',
   data: {
       message: 'Hello'
   },
    computed: { //计算属性，只会在message值发生变化时才重新计算，计算属性是基于它们的依赖进行缓存的
       //计算属性的getter
        reversedMessage: function(){
            //this指向vm实例
            return this.message.split('').reverse().join('')
        }
    },
    methods: { //调用方法，会在每一次请求时都进行调用
        reversedMessage11: function(){
            return this.message.split('').reverse().join('')
        }
    }
});


// var vm1 = new Vue({
//    el: '#demo',
//    data: {
//        firstName: '小',
//        lastName: '明',
//        fullName: '小 明'
//    } ,
//     watch: {
//        firstName: function(val){
//            this.fullName = val + ' ' + this.lastName
//        },
//         lastName: function (val) {
//             this.fullName = this.firstName + ' ' + val
//         }
//     }
// });

var vm1 = new Vue({
    el: '#demo',
    data: {
        firstName: '小',
        lastName: '明'
    } ,
    computed:{
        fullName: function(){ //默认只有getter方法
            return this.firstName + ' ' + this.lastName
        }
    }
});

var vm2 = new Vue({
    el: '#demo-2',
    data: {
        firstName: '小',
        lastName: '明'
    } ,
    computed:{
        fullName: {
            get: function () {
                return this.firstName + ' ' + this.lastName
            },
            set: function (newValue) {
                var names = newValue.split(' ');
                this.firstName = names[0];
                this.lastName = names[names.length - 1];
            }
        }
    }
});

var vm3 = new Vue({
   el: '#demo-3',
   data: {
       isActive: true,
       hasError: false,
       error: null,
       activateClass: 'test-array-01',
       errorClass: 'test-array-02'
   },
    computed:{
       classObject: function () {
           return {
               active: this.isActive && !this.error,
               'text-danger': !this.error
           }
       }
    }
});

Vue.component('my-component', {
    template: '<p class="A B">自定义组件上绑定class</p>'
});

var vm4 = new Vue({
   el: '#demo-4',
    data: {
       isActive: true
    }
});

var vm5 = new Vue({
   el: '#demo-5',
   data: {
       activeColor: 'red',
       fontSize: 30,
       styleObject: {
           color: 'blue',
           fontSize: '30px'
       }
   }
});