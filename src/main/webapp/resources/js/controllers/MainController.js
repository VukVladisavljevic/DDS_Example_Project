/**
 * Created by Lupus on 8/13/2017.
 */

angular.module("BookstoreApp").controller('MainController', ['$rootScope', '$http', '$scope', '$window',
    function ($rootScope, $http, $scope, $window) {

        $rootScope.isAdmin = function()
        {
            if(!$rootScope.isLogged())
                return false;
            if($rootScope.USER.userRole === "ADMIN")
            {
                return true;
            }
            return false;
        };

        $rootScope.isRegistered = function()
        {
            if(!$rootScope.isLogged()) {
                return false;
            }
            if($rootScope.USER.userRole === "GUEST") {
               {
                   return true;
               }
            }
            return false;
        };

        $rootScope.isLogged = function (){

            if($rootScope.USER !== null && $rootScope.USER !== undefined)
            {
                return true;
            }
            if(localStorage.getItem("LoggedUser") !== "" && localStorage.getItem("LoggedUser") !== null)
            {
                return true;
            }
            return false;
        };

        $scope.register = function () {


            var json = JSON.stringify({
                "email": $scope.email,
                "password": $scope.password,
                "name": $scope.name,
                "surname": $scope.surname,
                "address": $scope.address,
                "role": "reg_user",
            });

            var url = "http://localhost:8080/api/register";
            $.ajax(
                {
                    type: 'POST',
                    url: url,
                    contentType: "application/json",
                    data: json,
                    success: function (response) {
                        var user = response;
                        console.log("User successfully created ");
                        console.log(user.name);
                        $window.location = '#home';
                    },
                    error: function (err) {
                        console.log("nenene");
                        console.log(err);

                    }
                }
            )
        };

        $scope.login = function () {
            var user = JSON.stringify({
                "email": $scope.email,
                "password": $scope.password,
            });

            console.log($scope.username);

            var url = "/api/login";

            $.ajax({
                type: 'POST',
                url: url,
                contentType: 'application/json',
                dataType: "text",
                data: user,
                success: function (data) {
                    //redirekt
                    if (data !== null) {
                        localStorage.setItem("LoggedUser", data);
                        $rootScope.USER = JSON.parse(data);
                        $window.location = '#profile';
                        console.log("logged in");
                    }
                    else {
                        console.log("Not logged in");
                    }
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert("Login not successful, try again! ");
                    //toaster poruka

                }
            });
        };

        $scope.logout = function()
        {
            $rootScope.USER = undefined;
            localStorage.removeItem('LoggedUser');
            $window.location = '#login';
        }

    }
]);