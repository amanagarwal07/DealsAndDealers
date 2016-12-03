angular.module('dealsndealers', ['ngMaterial', 'md.data.table'])
    .service('dealsService', ['$http', function($http){
        this.getAllSmbDetails = function(){
            return $http.get('/dealsndealers/api/smb/getAllSmbs');
        };
        this.getAllProducts = function(){
            return $http.get('/dealsndealers/api/product/getAllProducts');
        };
        this.getAllDealers = function(){
            return $http.get('/dealsndealers/api/dealer/getAllDealers');
        };

        this.addExpense = function(dealerId, smbId, productId, price, quantity, rating){
            var receiptId = Math.floor((Math.random() * 100) + 1);
            var expense = {
                receiptId: receiptId,
                smbId: smbId,
                productId: productId,
                dealerId: dealerId,
                quantity: quantity,
                price: price,
                rating: rating
            };
            return $http.post('/dealsndealers/api/expense/add', expense);
        };

    }])
    .controller('mainController',['$scope', 'dealsService', '$log', function($scope
        , dealsService, $log){

        dealsService.getAllSmbDetails().then(function(success){
            $scope.smbDetails = success.data;
            $log.info($scope.smbDetails);
            $scope.showSmbGrid = true;
        }, function(error){});

        dealsService.getAllProducts().then(function(success){
            $scope.products = success.data;
            $log.info($scope.products);
            $scope.showProductGrid = true;
        }, function(error){});

        dealsService.getAllDealers().then(function(success){
            $scope.dealers = success.data;
            $log.info($scope.dealers);
            $scope.showDealerGrid = true;
        }, function(error){});

        $scope.state = 'ALL_DATA';

        $scope.expense = {
            dealerSelection : null,
            smbSelection: null,
            productSelection: null,
            rating: null,
            quantity: null,
            price: null
        };

        $scope.addExpense = function(){
          $log.info($scope.expense);
            $scope.isBetterDealerPresent = false;
            $scope.showSuccessMessage = false;
            dealsService.addExpense($scope.expense.dealerSelection, $scope.expense.smbSelection
                ,$scope.expense.productSelection, Number($scope.expense.price), Number($scope.expense.quantity)
                , $scope.expense.rating).then(function(success){
                $log.info(success.data);
                $scope.betterDealers = success.data;
                if(!!$scope.betterDealers && $scope.betterDealers.length > 0){
                    $scope.isBetterDealerPresent = true;
                }
                else{
                    $scope.showSuccessMessage = true;
                }
            }, function(error){});
        };
    }])

    .controller('smbController', ['$scope',function($scope){

    }]);
