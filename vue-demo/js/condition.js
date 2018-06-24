var demo1 = new Vue({
    el: '#demo-1',
    data: {
        seen: false
    }
});

var demo2 = new Vue({
    el: '#demo-2',
    data: {
        type: 'A'
    }
})

var demo3 = new Vue({
   el: '#demo-3',
   computed: {
       result: function () {
           return Math.random() > 0.5;
       }
   }
});