var cartApp = angular.module ("cartApp",[])

cartApp.controller("cartCtrl", function ($scope, $http) {
    $scope.refreshCart = function (cartId) {
        $http.get('/Gate617/rest/cart/' + $scope.cartId).success(function (data) {
            $scope.cart = data;
        });
    };

    $scope.clearCart = function () {
        $http.delete('/Gate617/rest/cart' + $scope.cartId).success($scope.refreshCart($scope.cartId));
    };

    $scope.initCartId = function (cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart(cartId);
    };

    $scope.addToCart = function (pId) {
        $http.put('/Gate617/rest/cart/add' + pId).success(function (data) {
            $scope.refreshCart($http.get('/Gate617/rest/cart/get/cartId'));
            alert("Product successfully added to the cart!")
        });
    };

    $scope.removeFromCart = function (pId) {
        $http.put('/Gate617/rest/cart/remove' + pId).success(function (data) {
            $scope.refreshCart($http.get('/Gate617/rest/cart/cartId'));
        });
    };
});