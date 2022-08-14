window.onload = function (){
    var vue = new Vue({
        el:"#div_cart",
        data:{
            cart:{}
        },
        methods:{
            cartInfo:function () {
                axios({
                    method:"get",
                    url:"cart.do",
                    params:{
                        operator:"getCartInfo"
                    }
                }).then(function (value){
                    console.log(value.data)
                    vue.cart = value.data
                }).catch(function (reason){

                })
            },
            editCart:function (CartItemid,buyCount) {
                //window.location.href="cart.do?operator=edit&CartItemid="+CartItemid + "&buyCount=" + buyCount;
                axios({
                    method:"get",
                    url:"cart.do",
                    params:{
                        operator:"edit",
                        CartItemid:CartItemid,
                        buyCount:buyCount
                    }
                }).then(function (value){
                    vue.cartInfo()
                }).catch(function (reason){

                })
            }
        },
        mounted:function (){
            this.cartInfo()
        }
    })
}