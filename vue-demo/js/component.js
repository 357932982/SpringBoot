Vue.component('button-counter', {
    data: function () {
        return {
            count: 0
        }
    },
    template: '<button v-on:click="count++">你已经点我了{{ count }}次！</button>'
});

new Vue({
   el: '#component-demo'
});


Vue.component('blog-post', {
    props: ['title'],
    template: '<h3>{{ title }}</h3>'
});

new Vue({
   el: '#component-demo-2'
});

new Vue({
    el: '#component-demo-3',
    data: {
        posts: [
            { id: 1, title: 'My journey with Vue' },
            { id: 2, title: 'Blogging with Vue' },
            { id: 3, title: 'Why Vue is so fun' }
        ]
    }
});

Vue.component('blog-post-a', {
   props: ['post'],
   template: '\
            <div>\
                <h3>{{ post.title }}</h3>\
                <div v-html="post.content"></div>\
                <button v-on:click="$emit(\'enlarge-text\', 0.1)">\
                    Enlarge text\
                </button>\
            </div>'
});

new Vue({
    el: '#component-demo-4',
    data: {
        postFontSize: 1,
        posts: [
            { id: 1, title: 'My journey with Vue', content: '...content...'}
        ]
    },
    methods: {
        onEnlargeText: function (enlargeAmount) {
            this.postFontSize += enlargeAmount
        }
    }
});