
angular.module("BookstoreApp").run(
    ['$http',
        '$log',
        '$rootScope',
        'authService',
        function ($http, $log, $rootScope, authService) {

            $rootScope.$on("$routeChangeStart",
                function (event, next, current) {
                    //If page requires admin authority and current user authority is not admin, redirect him on homepage
                    if (next.requireAdmin && !authService.isAdmin())
                        window.location = "/#/";
                    //Redirect to login page if user is not logged in
                    if (next.requireLogin && !authService.isLoggedIn())
                        window.location = "/#/login";
                }
            );
        }
    ]
);