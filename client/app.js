var app = angular.module('plunker', []);

app.controller('MainCtrl', function($scope, $http) {
  var count = 0;
  var serverUrl = 'http://localhost:8000/tasks';
  $scope.name = 'User';
  $scope.tasks = [];
  
  (function() {
    $http.get(serverUrl).then(function(result){
		$scope.tasks=result.data;
	});
  })();
  
  $scope.add = function() {
    addTask($scope.task);
    $scope.task = "";
  };
  
  $scope.deleteTask = function(index){
  $http.delete(serverUrl+'/'+$scope.tasks[index].id).then(function(result){
	  $scope.tasks.splice(index, 1);
	 });
  };
  
  var addTask = function(tName){
    var t = JSON.stringify({taskName:tName,taskContent:'content'});
	$http.post(serverUrl, t).then(function(result){
		$scope.tasks.push(result.data);
	});
  };
});
