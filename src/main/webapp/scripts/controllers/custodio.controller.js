var app = angular.module('pruebaApp', ['ngCookies']);
app.controller('custodioCtrl', function ($scope, $http, $cookies) {
    $scope.records = [];
    $scope.user = 'custodio';
    $scope.pwd = 'custodiop';
    $scope.checkStatus = function () {
        if (typeof($cookies.get('session')) === 'undefined') {
            $scope.session = 'false';
        } else {
            if ($cookies.get('session') === 'true') {
                $scope.session = 'true';
            }else{
                $scope.session = 'false';
            }
        }
    };
    $scope.logout = function () {
        $cookies.remove('session');
        $scope.session = 'false';
        $scope.usrForm = '';
        $scope.pwdForm = '';
        $location.path("/");
    };
    $scope.login=function (user,pwd) {
        var expiration = new Date();
        expiration.setHours(expiration.getHours() + 1);
        if(user === $scope.user && pwd === $scope.pwd){
            $cookies.put('session', 'true', {expires:expiration});
            $scope.session = 'true';
        }else{
            alert('User or password are wrong');
        }
    };
    $scope.checkStatus();
    $http({
        method: "GET",
        url: "/Prueba-1.0/services/records"
    }).then(function mySucces(response) {
        console.log(response.data);
        $scope.records = response.data;
        $scope.getBalance();
    }, function myError(response) {

    });
    $scope.deliver = function (id) {
        console.log(id);
        $http({
            method: "GET",
            url: "/Prueba-1.0/services/records/deliver/" + id,
        }).then(function mySucces(response) {
            console.log(response.data);
            $scope.records = response.data;
            $scope.getBalance();
        }, function myError(response) {

        });
    };
    $scope.getBalance = function () {
        $scope.added = 0.0;
        $scope.delivered = 0.0;
        $scope.pending = 0.0;
        $scope.total = 0.0;
        $scope.records.forEach(function (element) {
            switch (element.state) {
                case 'added':
                    $scope.added += element.amount;
                    break;
                case 'delivered':
                    $scope.delivered += element.amount;
                    break;
                case 'pending':
                    $scope.pending += element.amount;
                    break;
            }
        })
        $scope.total = $scope.added - $scope.delivered;
    };
    $scope.firstName = "John";
    $scope.lastName = "Doe";
});