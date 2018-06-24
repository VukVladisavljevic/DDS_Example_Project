angular.module("BookstoreApp").config(function ($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: '/resources/js/views/home.html',
        controller: 'MainController'
    }).when('/register', {
        templateUrl: '/resources/js/views/register.html',
        controller: 'MainController'
    }).when('/login', {
        templateUrl: '/resources/js/views/login.html',
        controller: 'MainController'
    }).when('/addArticle', {
        templateUrl: '/resources/js/views/addArticle.html',
        controller: 'ArticleController'
    }).when('/allArticles', {
        templateUrl: '/resources/js/views/allArticles.html',
        controller: 'ArticleController'
    }).when('/profile', {
        templateUrl: '/resources/js/views/profile.html',
        controller: 'UserController'
    }).when('/purchase', {
        templateUrl: '/resources/js/views/listArticlesToBuy.html',
        controller: 'ArticleController'
    }).otherwise({
        redirectTo: '/'
    });
});