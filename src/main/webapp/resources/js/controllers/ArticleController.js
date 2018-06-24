/**
 * Created by Lupus on 8/15/2017.
 */

angular.module("BookstoreApp").controller('ArticleController', ['$scope', '$rootScope', '$window', '$http', '$location',
    function ($scope, $rootScope, $window, $http, $location) {

    $scope.articlesChosen = [];
    $scope.chosenArticlesCount = [];
    $scope.currentCart = [];

    $scope.loadArticles = function () {
        console.log("loading articles");

        var url = "/api/article/getAll";
        $.ajax({
            type: 'GET',
            url : url,
            contentType: 'application/json',
            dataType: 'text',
            success:  function (data) {
                $scope.BOOKS = JSON.parse(data);
                $scope.$apply();
            },
            error : function(XMLHttpRequest, textStatus, errorThrown) {
                //toaster poruka
                alert('Could not load articles!');
            }
        });
    };

    $scope.addToCart = function(article, index) {
       var selected = article;
       var t = document.getElementById("tabela1");
       var r = t.rows[index+1];
       var inputs = r.getElementsByTagName("input");
       var result = new Array(inputs.length);
       result[0] = inputs[0].value; // not innerHTML or something
       //       alert($scope.currentMealsOrdered.length);
       $scope.articlesChosen.push(article.id);
       $scope.chosenArticlesCount.push(result[0]);
       $scope.currentCart.push(article);
    };


    $scope.addArticle = function () {
        console.log("Adding article");
        var article = JSON.stringify({
            "title":$scope.title,
            "description":$scope.description,
            "writer":$scope.writer,
            "publishingYear":$scope.publishingYear,
            "price":$scope.price,
            "units":$scope.units,
        })

        var url = "/api/article/addArticle";
        $.ajax({
            type: 'POST',
            url : url,
            contentType: 'application/json',
            dataType: 'text',
            data : article,
            success:  function (data) {
                if(data !== null){
                    alert("Uspesno dodat");
                }
                else {
                    alert("ne valja dodavanje article");
                }

            },
            error : function(XMLHttpRequest, textStatus, errorThrown) {
                //toaster poruka
                alert('Could not add article!');
            }
        })
    }

    $scope.conclude = function (){
        console.log("Adding article");
        var json = JSON.stringify({
            "userEmail":$rootScope.USER.email.value,
            "articlesBought":$scope.articlesChosen,
            "articlesCount":$scope.chosenArticlesCount
        })

        alert(json);

        var url = "/api/purchase";
        $.ajax({
            type: 'POST',
            url : url,
            contentType: 'application/json',
            dataType: 'text',
            data : json,
            success:  function (data) {
                if(data !== null){
                    alert("Uspesno dodat");
                }
                else {
                    alert("ne valja dodavanje article");
                }

            },
            error : function(XMLHttpRequest, textStatus, errorThrown) {
                //toaster poruka
                alert('Could not add article!');
            }
        })



    }

        $scope.deleteSnippet = function (snippetID) {
            console.log("deleting article");
            var article = JSON.stringify({
                "id":articleID
            })

            var url = "/api/article/removeArticle";
            $.ajax({
                type: 'POST',
                url : url,
                contentType: 'application/json',
                dataType: 'text',
                data : article,
                success:  function (data) {
                    if(data !== null){
                        alert("Uspesno izbrisan");

                    }
                    else {
                        alert("ne valja brisanje article");
                    }
                    $scope.$apply();
                },
                error : function(XMLHttpRequest, textStatus, errorThrown) {
                    //toaster poruka
                    alert('Could not delete article!');
                }
            })
        }

}]);