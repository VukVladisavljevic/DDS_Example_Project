/**
 * Created by Lupus on 8/17/2017.
 */
angular.module("BookstoreApp")
    .controller('UserController', ['$scope', '$rootScope', '$window','$http',
        function ($scope, $rootScope, $window, $http) {

            $scope.loadData = function () {

                        $scope.name = $rootScope.USER.name.value;
                        $scope.surname = $rootScope.USER.surname.value;
                        $scope.address = $rootScope.USER.address.value;
                        $scope.email = $rootScope.USER.email.value;
                    };

            $scope.changeName = function () {

                var json = JSON.stringify({
                    "email" : $rootScope.USER.email.value,
                    "name": $scope.name
                });

                var url = "api/change/name";
                $.ajax(
                    {
                        type: 'POST',
                        url: url,
                        contentType: "application/json",
                        data : json,
                        success: function (response) {
                            var user = response;
                            console.log(user.name);
                            $rootScope.USER = user;
                        },
                        error: function (err) {
                            console.log(err);
                            console.log("nije uspela izmena imena");
                        }
                    }
                )
            };


            $scope.changeAddress = function() {

                var json = JSON.stringify({
                    "email" : $rootScope.USER.email.value,
                    "address": $scope.address
                });

                var url = "api/change/address";
                $.ajax(
                    {
                        type: 'POST',
                        url: url,
                        contentType: "application/json",
                        data : json,
                        success: function (response) {
                            var user = response;
                            console.log(user.surname);
                            $rootScope.USER = user;
                        },
                        error: function (err) {
                            console.log(err);
                            console.log("nije uspela izmena adrese");
                        }
                    }
                )
            };

            $scope.changeSurname = function() {

                var json = JSON.stringify({
                    "email" : $rootScope.USER.email.value,
                    "surname": $scope.surname
                });

                var url = "api/change/surname";
                $.ajax(
                    {
                        type: 'POST',
                        url: url,
                        contentType: "application/json",
                        data : json,
                        success: function (response) {
                            var user = response;
                            console.log(user.surname);
                            $rootScope.USER = user;
                        },
                        error: function (err) {
                            console.log(err);
                            console.log("nije uspela izmena prezimena");
                        }
                    }
                )
            };
        }]);